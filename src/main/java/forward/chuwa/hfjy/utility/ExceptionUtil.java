package forward.chuwa.hfjy.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Exception工具类
 * 
 * @author 孙宇
 * 
 */
public class ExceptionUtil {


	/**
	 * 返回错误信息字符串
	 * 
	 * @param ex
	 *            Exception
	 * @return 错误信息字符串
	 */
	public static String getExceptionMessage(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String errorMessage = sw.toString();
		pw.close();
		try {
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return errorMessage;
	}

}
