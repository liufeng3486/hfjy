package forward.chuwa.hfjy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.WebTopicDao;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private WebTopicDao webTopicDao;
	

	@Transactional(propagation = Propagation.REQUIRED)
	public WebTopic createWebTopic(String name, Long topictypeid,
			Long provinceid, String pinyin, Long parentid, String unitype,
			String unilevel, String prosubject, String topicimg,
			String topicphoto, String description) {
		Date now = new Date();
		WebTopic webTopic = new WebTopic();
		webTopic.setName(name);
		webTopic.setTopictypeid(topictypeid);
		webTopic.setProvinceid(provinceid);
		webTopic.setPinyin(pinyin);
		webTopic.setParentid(parentid);
		if(parentid > 0){
			webTopic.setParentname(webTopicDao.load(parentid).getName());
		}
		webTopic.setUnitype(unitype);
		webTopic.setUnilevel(unilevel);
		webTopic.setProsubject(prosubject);
		webTopic.setTopicimg(topicimg);
		webTopic.setTopicphoto(topicphoto);
		webTopic.setDescription(description);
		webTopic.setDeleteflag(DictionaryUtil.DELETE_FLAG0);
		webTopic.setCreatedate(now);
		webTopic.setUpdatedate(now);
		webTopic.setCreateid(1L);
		webTopic.setUpdateid(1L);
		return webTopicDao.save(webTopic);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebTopic updateWebTopic(Long id, String name, Long topictypeid,
			Long provinceid, String pinyin, Long parentid, String unitype,
			String unilevel, String prosubject, String topicimg,
			String topicphoto, String description) {
		WebTopic webTopic = webTopicDao.load(id);
		Date now = new Date();
		
		webTopic.setName(name);
		webTopic.setTopictypeid(topictypeid);
		webTopic.setProvinceid(provinceid);
		webTopic.setPinyin(pinyin);
		webTopic.setParentid(parentid);
		if (parentid > 0) {
			webTopic.setParentname(webTopicDao.load(parentid).getName());
		}else{
			webTopic.setParentname(null);
		}
		webTopic.setUnitype(unitype);
		webTopic.setUnilevel(unilevel);
		webTopic.setProsubject(prosubject);
		webTopic.setTopicimg(topicimg);
		webTopic.setTopicphoto(topicphoto);
		webTopic.setDescription(description);
		webTopic.setUpdatedate(now);
		webTopic.setUpdateid(1L);
		return webTopicDao.update(webTopic);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteWebTopic(Long id) {
		WebTopic webTopic = webTopicDao.load(id);
		webTopic.setDeleteflag(DictionaryUtil.DELETE_FLAG1);
		webTopicDao.update(webTopic);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebTopic loadWebTopic(Long id) {
		return webTopicDao.load(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebTopic> findWebTopics(String condition) {
		return webTopicDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebTopic> findWebTopics(String condition, int start, int length) {
		return webTopicDao.find(condition, start, length);
	}
}
