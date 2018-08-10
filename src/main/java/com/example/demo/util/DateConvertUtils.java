package com.example.demo.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author badqiu
 */
public class DateConvertUtils {
	
	private static final DateFormat yymmdd = new SimpleDateFormat("yyMMdd");
	
	private static final DateFormat yyyymmddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static final DateFormat yymmddHHmm = new SimpleDateFormat("yyyyMMddHHmm");
	
	private static final DateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");
	
	private static final DateFormat yyyymm = new SimpleDateFormat("yyyyMM");
	
	private static final DateFormat yyyy = new SimpleDateFormat("yyyy");
	private static final DateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat HH_mm_ss = new SimpleDateFormat("HH:mm:ss");
	private static final DateFormat yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	private static final String endTime = "235959";
	
	public static Date parse(String dateString,String dateFormat) {
		return parse(dateString, dateFormat,Date.class);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Date> T parse(String dateString,String dateFormat,Class<T> targetResultType) {
		if(StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			Date t = targetResultType.getConstructor(long.class).newInstance(time);
			return (T)t;
		} catch (ParseException e) {
			String errorInfo = "cannot use dateformat:"+dateFormat+" parse datestring:"+dateString;
			throw new IllegalArgumentException(errorInfo,e);
		} catch (Exception e) {
			throw new IllegalArgumentException("error targetResultType:"+targetResultType.getName(),e);
		}
	}

	public static String format(Date date,String dateFormat) {
		 if(date == null)
			 return null;
		 return new SimpleDateFormat(dateFormat).format(date);
	}
	
	public static String formatYYMMDD(Date date) {
		if(date == null)
			 return null;
		return yymmdd.format(date);
	}
	
	public static String formatYYYYMMDDHHMMSS(Date date) {
		if(date == null)
			 return null;
		return yyyymmddHHmmss.format(date);
	}
	
	public static String formatYYMMDDHHMM(Date date) {
		if(date == null)
			 return null;
		return yymmddHHmm.format(date);
	}
	
	public static String formatYYYYMMDD(Date date) {
		if(date == null)
			 return null;
		return yyyymmdd.format(date);
	}
	
	public static String formatYYYYMM(Date date) {
		if(date == null)
			return null;
		return yyyymm.format(date);
	}
	
	public static String formatYYYY(Date date) {
		if(date == null)
			return null;
		return yyyy.format(date);
	}

	public static String formatYYYY_MM_DD(String date) throws ParseException {
		if(date == null)
			return null;
		else {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			return  yyyy_MM_dd.format(format.parse(date)) ;
		}
	}

	public static String formatHH_mm_ss(String date) throws ParseException {
		if(date == null)
			return null;
		else {
			SimpleDateFormat format = new SimpleDateFormat("HHmmss");
			return  HH_mm_ss.format(format.parse(date));
		}

	}
	
	public static int getYearAndDay(Date date) {
		String s = formatYYYYMMDD(date);
		if(s == null)
			return 0;
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}


	/**
	 * 格式化日期  yyyy-MM-dd HH:mm:ss ->yyyyMMddHHmmss
	 */
	public static String formatYYYY_MM_dd_HH_mm_ss(String dateStr)
	{
		String dateString = "";
		try
		{
//			SimpleDateFormat oldFormat = new SimpleDateFormat(yyyymmddHHmmss);
//			SimpleDateFormat newFormat = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
			dateString = yyyy_MM_dd_HH_mm_ss.format(yyyymmddHHmmss.parse(dateStr));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dateString;
	}
	
	/**
	* @Title: getFirstDayOfMonth
	* @Description:获取当前月份第一天日期
	* @return param
	* @return String return type
	* @throws
	*/
	public static String getFirstDayOfMonth()
	{
		Calendar c = Calendar.getInstance();   
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return yyyymmdd.format(c.getTime());
	}
	
	/**
	* @Title: getLastDayOfMonth
	* @Description:获取当前月份最后一天日期
	* @return param
	* @return String return type
	* @throws
	*/
	public static String getLastDayOfMonth()
	{
		Calendar ca = Calendar.getInstance();   
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        return yyyymmdd.format(ca.getTime());
	}
	
	/**
	* @Title: getPreviousDate
	* @Description:获取当前日期前一天
	* @param date
	* @return param
	* @return String return type
	* @throws
	*/
	public static String getPreviousDate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date finalDate = calendar.getTime();
		return yyyymmdd.format(finalDate);
	}
	
	/**
	* @Title: getAfterDate
	* @Description:获取当前日期后一天
	* @param date
	* @return param
	* @return String return type
	* @throws
	*/
	public static String getAfterDate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date finalDate = calendar.getTime();
		return yyyymmdd.format(finalDate);
	}
	
	public static Date getEndTimeOfDay(String date)
	{
		return DateConvertUtils.parse(date + endTime, "yyyyMMddHHmmss");
	}
	
	
	/**获取当天最小时间(即当天0点0分0秒)*/
	public static Date getCurrentDateMin(){
		Calendar c = Calendar.getInstance();  //得到当前日期和时间
        c.set(Calendar.HOUR_OF_DAY, 0);              //把当前时间小时变成０
        c.set(Calendar.MINUTE, 0);            //把当前时间分钟变成０
        c.set(Calendar.SECOND, 0);            //把当前时间秒数变成０
        c.set(Calendar.MILLISECOND, 0);       //把当前时间毫秒变成０
        
        return c.getTime();
	}
	/**获取前n天时间*/
	public static Date getDate(int num){
		return DateUtils.addDays(Calendar.getInstance().getTime(), -num);
	}
	/**返回今天剩余时间-毫秒*/
	public static Long todayLeftTime(){
		return (DateUtils.addDays(getCurrentDateMin(),1).getTime() - new Date().getTime());
	}
	
    /**
     * @Description: date1大于date2返回1，date1小于date2返回-1
     * @param format_date
     * @param date1
     * @param date2
     * @return int
     */ 
    public static int compare_date(String format_date, String date1, String date2) {
         DateFormat df = new SimpleDateFormat(format_date);
         try {
             Date dt1 = df.parse(date1);
             Date dt2 = df.parse(date2);
             if (dt1.getTime() > dt2.getTime()) {
                 return 1;
             } else if (dt1.getTime() < dt2.getTime()) {
                 return -1;
             } else {
                 return 0;
             }
         } catch (Exception exception) {
             exception.printStackTrace();
         }
         return 0;
    }





	public static void main(String [] arg) throws ParseException {
		System.out.println("年月日:"+ formatYYYY_MM_DD("20180329"));
		System.out.println("时分秒:"+ formatHH_mm_ss("091624"));
	}
    
}
