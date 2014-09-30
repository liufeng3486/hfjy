package forward.chuwa.hfjy.service;

import java.util.List;

import forward.chuwa.hfjy.model.WebTopic;

public interface TopicService {

	public WebTopic createWebTopic(String name, Long topictypeid,
			Long provinceid, String pinyin, Long parentid, String unitype,
			String unilevel,String subjecttype,String protype, String topicimg,
			String topicphoto,String introduction, String description);

	public WebTopic updateWebTopic(Long id,String name, Long topictypeid,
			Long provinceid, String pinyin, Long parentid, String unitype,
			String unilevel,String subjecttype, String protype, String topicimg,
			String topicphoto,String introduction, String description);

	public void deleteWebTopic(Long id);

	public WebTopic loadWebTopic(Long id);

	public List<WebTopic> findWebTopics(String condition);

	public List<WebTopic> findWebTopics(String condition, int start, int length);
	
	public Long countWebTopics(String condition);
}
