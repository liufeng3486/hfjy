package forward.chuwa.hfjy.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(DateConverter.class);

	@SuppressWarnings("rawtypes")
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values != null && values.length > 0 && values[0] != null
				&& values[0].length() > 0) {
			try {
				if (values[0].length() == 10) {
					return new SimpleDateFormat("yyyy-MM-dd").parse(values[0]);
				} else if (values[0].length() == 19) {
					return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(values[0]);
				}
			} catch (ParseException e) {
				// log.error("Error convert " + values[0] + " to Date ", e);
				throw new TypeConversionException();
			}
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	public String convertToString(Map context, Object o) {
		Date date = (Date) o;

		if (date != null) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		} else {
			return "";
		}
	}
}
