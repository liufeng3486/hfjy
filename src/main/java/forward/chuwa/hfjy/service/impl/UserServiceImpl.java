package forward.chuwa.hfjy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.SysGradeDao;
import forward.chuwa.hfjy.dao.SysProvinceDao;
import forward.chuwa.hfjy.dao.WebArticleDao;
import forward.chuwa.hfjy.dao.WebFavDao;
import forward.chuwa.hfjy.dao.WebTopicDao;
import forward.chuwa.hfjy.dao.WebUserDao;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebFav;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.model.WebUser;
import forward.chuwa.hfjy.service.UserService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private WebUserDao webUserDao;

	@Autowired
	private SysProvinceDao sysProvinceDao;

	@Autowired
	private SysGradeDao sysGradeDao;
	
	@Autowired
	private WebTopicDao webTopicDao;
	
	@Autowired
	private WebArticleDao webArticleDao;
	
	@Autowired
	private WebFavDao webFavDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebUser loadWebUser(Long id) {
		return webUserDao.load(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebUser login(String loginname, String password) {
		List<WebUser> listWebUsers = webUserDao.find(" and t.loginname = '"
				+ loginname + "' and t.password = '" + password + "' ");
		if (listWebUsers != null && listWebUsers.size() > 0) {
			WebUser webUser = listWebUsers.get(0);
			webUser.setLastlogindate(new Date());
			return webUserDao.update(webUser);
		} else {
			return null;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebUser> findWebUsers(String condition) {
		return webUserDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser createWebUser(String loginname, String password,
			String name, String email, Long provinceid, Long gradeid,
			String userphoto) {
		Date now = new Date();
		WebUser webUser = new WebUser();
		webUser.setLoginname(loginname);
		webUser.setPassword(password);
		webUser.setName(name);
		webUser.setEmail(email);
		webUser.setProvinceid(provinceid);

		if (provinceid != null && provinceid > 0) {
			webUser.setProvincename(sysProvinceDao.load(provinceid).getName());
		}

		webUser.setGradeid(gradeid);

		if (gradeid != null && gradeid > 0) {
			webUser.setGradename(sysGradeDao.load(gradeid).getGradename());
		}

		webUser.setUserphoto(userphoto);
		webUser.setCreatedate(now);
		webUser.setLastlogindate(now);
		return webUserDao.save(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser confirmWebUser(Long id) {
		WebUser webUser = webUserDao.load(id);
		webUser.setIsconfirm(DictionaryUtil.DELETE_FLAG1);
		webUser.setDytoken(null);
		return webUserDao.save(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser changePassword(Long id,String password){
		WebUser webUser = webUserDao.load(id);
		webUser.setPassword(password);
		webUser.setDytoken(null);
		return webUserDao.save(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser updateToken(Long id,String token){
		WebUser webUser = webUserDao.load(id);
		webUser.setDytoken(token);
		return webUserDao.save(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser addFocusTopic(Long userid,Long topicid){
		WebUser webUser = webUserDao.load(userid);
		List<WebTopic> listWebTopics = webUser.getWebTopics();
		WebTopic webTopic = webTopicDao.load(topicid);
		if(!listWebTopics.contains(webTopic)){
			listWebTopics.add(webTopic);
		}
		webUser.setWebTopics(listWebTopics);
		return webUserDao.update(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser removeFocusTopic(Long userid,Long topicid){
		WebUser webUser = webUserDao.load(userid);
		List<WebTopic> listWebTopics = webUser.getWebTopics();
		WebTopic webTopic = webTopicDao.load(topicid);
		if(listWebTopics.contains(webTopic)){
			listWebTopics.remove(webTopic);
		}
		webUser.setWebTopics(listWebTopics);
		return webUserDao.update(webUser);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long countWebUsers(String condition){
		return webUserDao.count(condition);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebFav addFavArticle(Long favid,Long articleid){
		WebFav webFav = webFavDao.load(favid);
		List<WebArticle> listWebArticles = webFav.getWebArticles();
		WebArticle webArticle = webArticleDao.load(articleid);
		if(!listWebArticles.contains(webArticle)){
			listWebArticles.add(webArticle);
		}
		webFav.setWebArticles(listWebArticles);
		return webFavDao.update(webFav);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebFav addFavArticle(Long userid,String name,Long articleid){
		WebFav webFav;
		List<WebArticle> listWebArticles;
		if (webFavDao.count(" and t.name = '" + name + "' and t.userid ="
				+ userid) > 0) {
			webFav = webFavDao.find(" and t.name = '" + name + "' and t.userid ="
				+ userid).get(0);
			listWebArticles = webFav.getWebArticles();
		}else{
			webFav = new WebFav();
			webFav.setUserid(userid);
			webFav.setName(name);
			webFavDao.save(webFav);
			listWebArticles = new ArrayList<WebArticle>();
		}
		
		WebArticle webArticle = webArticleDao.load(articleid);
		if(!listWebArticles.contains(webArticle)){
			listWebArticles.add(webArticle);
		}
		webFav.setWebArticles(listWebArticles);
		return webFavDao.update(webFav);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void removeFavArticle(Long userid,Long articleid){
		List<WebFav> listWebFavs = webFavDao.find(" and t.userid =" + userid
				+ " and exists (from t.webArticles t1 where t1.id = "
				+ articleid + " ) ");
		WebArticle webArticle = webArticleDao.load(articleid);
		for (WebFav webFav : listWebFavs) {
			List<WebArticle> listWebArticles = webFav.getWebArticles();
			if(listWebArticles.contains(webArticle)){
				listWebArticles.remove(webArticle);
			}
			webFav.setWebArticles(listWebArticles);
			webFavDao.update(webFav);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebFav> findWebFavs(String condition){
		return webFavDao.find(condition);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long countWebfavs(String condition){
		return webFavDao.count(condition);
	}
}
