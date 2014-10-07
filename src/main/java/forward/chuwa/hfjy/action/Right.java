package forward.chuwa.hfjy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebHot;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Namespace("/")
@Action("right")
public class Right extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private TopicService topicService;
	
	
	
	private List<WebTopic> listHotTopics;
	private List<WebArticle> listWebArticles;
	
	public String execute() {
		listWebArticles = articleService.findWebArticles(" order by getArticleRecord(t.id) desc ",0,5);
		
		listHotTopics = new ArrayList<WebTopic>();
		for (WebHot webHot : systemService.findWebHots(" and t.hottype = '"
				+ DictionaryUtil.HOT_TYPE2 + "' and t.relationtype = '"
				+ DictionaryUtil.RELATION_TYPE1 + "' ", 0, 3)) {
			WebTopic webTopic = topicService.loadWebTopic(webHot.getRelationid());
			if (getUserInfo() != null) {
				if (topicService.countWebTopics(" and t.id = "
						+ webTopic.getId()
						+ " and exists (from t.webUsers t1 where t1.id = "
						+ getUserInfo().getUserId() + " )  ") > 0) {
					webTopic.setProtype("1");
				}
			}
			listHotTopics.add(webTopic);
		}
		return INPUT;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}

	public List<WebTopic> getListHotTopics() {
		return listHotTopics;
	}

	public void setListHotTopics(List<WebTopic> listHotTopics) {
		this.listHotTopics = listHotTopics;
	}
	
	

}
