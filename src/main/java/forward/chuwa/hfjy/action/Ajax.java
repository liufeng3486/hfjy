package forward.chuwa.hfjy.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;


public class Ajax extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private ArticleService articleService;
	
	private Long id;
	
	/**
	 * 首页导航分类
	 */
	@Action(value = "ajaxTopicType")
	public void topicType() {
		List<SysTopictype> list = systemService.findSysTopictypes(" order by orderid ");
		writeJson(list);
	}
	
	@Action(value = "ajaxTopicDetail")
	public void topicDetail() {
		Map<String,Object> result = new HashMap<String,Object>();
		if(id !=null && id>0){
			List<WebArticle> list = articleService.findWebArticles(
					" and exists (from t.webTopics t1 where t1.id = " + id
							+ " ) order by t.publishdate desc ", 0, 1);
			if (list != null && list.size() > 0) {
				Map<String,Object> last = new HashMap<String,Object>();
				last.put("id", list.get(0).getId());
				last.put("title", list.get(0).getTitle());
				result.put("last", last);
			}

			list = articleService.findWebArticles(
					" and exists (from t.webTopics t1 where t1.id = " + id
							+ " ) order by getArticleRecord(t.id) desc ", 0, 1);
			if (list != null && list.size() > 0) {
				Map<String,Object> hot = new HashMap<String,Object>();
				hot.put("id", list.get(0).getId());
				hot.put("title", list.get(0).getTitle());
				result.put("hot", hot);
			}
		}
		writeJson(result);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
