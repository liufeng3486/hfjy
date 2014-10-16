package forward.chuwa.hfjy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
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
	public static void send(Long id, String email,int type) throws IOException {
		StringBuilder sb = new StringBuilder();
		URL url1 = new URL("http://localhost:8080/hfjy/confirmUser?id=" + id+"&type="+type);
		InputStream is = url1.openStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		char[] cs = new char[9999];
		while (isr.read(cs, 0, 9999) != -1) {
			sb.append(cs);
		}
		is.close();

		String url = "https://sendcloud.sohu.com/webapi/mail.send.xml";
		HttpClient httpclient = new DefaultHttpClient();

		HttpPost httpost = new HttpPost(url);

		List nvps = new ArrayList();
		// 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
		nvps.add(new BasicNameValuePair("api_user",
				"postmaster@luqula.sendcloud.org"));
		nvps.add(new BasicNameValuePair("api_key", "Hhh8nx4G8XSp7YuB"));
		nvps.add(new BasicNameValuePair("from", "post@tongzhi.luqu.la"));
		nvps.add(new BasicNameValuePair("to", email));
		if(type == 0){
			nvps.add(new BasicNameValuePair("subject", "欢迎注册录取啦luqu.la，请验证您的邮箱哦~"));
		}else if(type == 1){
			nvps.add(new BasicNameValuePair("subject", "录取啦 - 通过邮箱找回密码"));
		}
		nvps.add(new BasicNameValuePair("html", sb.toString()));

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

	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
