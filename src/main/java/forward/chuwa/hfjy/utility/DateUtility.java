package forward.chuwa.hfjy.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;


public class DateUtility {
	
	public static final String LONG_FORMAT_PATTREN = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_FORMAT_PATTREN = "yyyy-MM-dd";
	
	public static final String LONG_FORMAT_PATTREN_2 = "yyyy/MM/dd HH:mm";
	public static final String SHORT_FORMAT_PATTREN_2 = "yyyy/MM/dd";
	
	/**
	 * 时间加减
	 * @param 需要进行加减的日期
	 * @param 1表示年,2月.3周.5天等
	 * @param 加减的数量
	 * @return 返回加减后的时间
	 */
	public static Date ComputerDate(Date d, int field, Integer amount) {
		if (d != null && amount != null) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d);
			gc.add(field, amount);
			return gc.getTime();
		}

		return null;
	}
	
	public static Date ComputerDate(Date d, int field, Long amount) {
		if (d != null && amount != null) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d);
			gc.add(field, amount.intValue());
			return gc.getTime();
		}

		return null;
	}
	
	/**
	 * 格式化字符串日期
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date format(String dateStr, String format){
		Date date = null;
		if(StringUtils.isBlank(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try{
			date = sdf.parse(dateStr);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return date;
		}
	}
	
	public static String format(Date date, String format){
		if(StringUtils.isBlank(format)){
			format = LONG_FORMAT_PATTREN;
		}
		if(date == null){
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static int compare(Date date1, Date date2) {
		if(date1 == null || date2 == null) {
			return -1;
		}
		
		return date1.compareTo(date2);
	}
}
