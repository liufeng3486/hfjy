package forward.chuwa.hfjy.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Mail {

	@SuppressWarnings("unchecked")
	public static void send(String email) throws IOException {
		String url = "https://sendcloud.sohu.com/webapi/mail.send.xml";
		HttpClient httpclient = new DefaultHttpClient();
		
		HttpPost httpost = new HttpPost(url);

		List nvps = new ArrayList();
                //不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
		nvps.add(new BasicNameValuePair("api_user", "postmaster@luqula.sendcloud.org"));
		nvps.add(new BasicNameValuePair("api_key", "Hhh8nx4G8XSp7YuB"));
		nvps.add(new BasicNameValuePair("from", "post@tongzhi.luqu.la"));
		nvps.add(new BasicNameValuePair("to", email));
		nvps.add(new BasicNameValuePair("subject", "欢迎注册录取啦luqu.la，请验证您的邮箱哦~"));
		nvps.add(new BasicNameValuePair("html", "1111"));

		httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		// 请求
		HttpResponse response = httpclient.execute(httpost);
		// 处理响应
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
			// 读取xml文档
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
		} else {
			System.err.println("error");
		}
	}
}
