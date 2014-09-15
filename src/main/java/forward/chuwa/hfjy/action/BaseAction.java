package forward.chuwa.hfjy.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import forward.chuwa.hfjy.utility.UserInfo;

@SuppressWarnings("serial")
public abstract class BaseAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware, ServletContextAware {
	private HttpServletRequest servletRequest;

	private HttpServletResponse servletResponse;

	private ServletContext servletContext;

	public static final String COMPLETE = "complete";

	public static final String BACK = "back";

	public static final String REPORT = "report";

	public static final String FAIL = "fail";

	public static final int PAGE_SIZE = 10;

	public static final String KEY_USER_INFO = "user_info";

	public static final String NEW_PROJECT = "new_project";

	protected int startIndex = 1;

	private boolean reset = false;

	private int count = 0;

	public String back() {
		return BACK;
	}

	public boolean getReset() {
		return reset;
	}

	public void setReset(boolean reset) {
		this.reset = reset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

	public HttpSession getSession() {
		return servletRequest.getSession();
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		servletResponse.addCookie(cookie);
	}

	public String getCookie(String name) {
		Cookie[] cookies = servletRequest.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (StringUtils.equals(cookie.getName(), name)) {
					return cookie.getValue();
				}
			}
		}

		return "";
	}

	public int getPageSize() {
		return PAGE_SIZE;
	}

	public int getStartIndex() {
		String pageOffset = getServletRequest().getParameter("pager.offset");

		if (!StringUtils.isEmpty(pageOffset)) {
			try {
				startIndex = Math.max(1, Integer.parseInt(pageOffset) + 1);
			} catch (NumberFormatException ex) {

			}
		}

		return startIndex;
	}

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将对象转换成JSON字符串，并响应回前台(可定义日期格式)
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object, String formaterType) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, formaterType);
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UserInfo getUserInfo() {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(KEY_USER_INFO);
		return userInfo;
	}

	
}
