/**
* @Project: fmp-agent
* @Package com.freemypay.util
* FileName：DateUtil.java
* Version：v1.0
* date：2014-7-17
* Copyright © 2014 Shanghai Deyi Network Technology Co.,Ltd All Rights Reserved
*/

package com.example.demo.util.two.date;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* FileName: DateUtil.java
* @Description:日期格式化工具类
* @version: v1.0
*/
public class DateUtil
{

	public static String DATE_FORMART_HHMMSS = "HHmmss";
	public static String DATE_FORMART_YYYYMMDD = "yyyyMMdd";
	public static String DATE_FORMART_YYYY_MM_DD = "yyyy-MM-dd";
	public static String DATE_FORMART_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMART_YYYYMMDD_HHMMSS_TO_SPRIT = "yyyy/MM/dd HH:mm:ss";
	public static String DATE_FORMART_YYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";
	public static String DATE_FORMART_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String DATE_FORMART_SYMBOL_LINE = "-";
	public static String DATE_FORMART_SYMBOL_COLON = ":";
	public static String DATE_FORMART_SYMBOL_SPACE = " ";

	/**
	 * @Description: 格式化日期 20140201->2014/02/01
	 */
	public static String formatDateSimple(String date, String separetor)
	{
		String dateStr = date.substring(0, 4) + separetor + date.substring(4, 6) + separetor + date.substring(6, 8);
		return dateStr;
	}

	/**
	 * @Title: formatDateSimpleyyyyMMddHHmmss
	 * @Description: 格式化日期20170312120530 ->2017-03-12 12:05:30
	 * @param date
	 * @return
	 */
	public static String formatDateSimpleyyyyMMddHHmmss(String date)
	{
		String dateStr = "";
		if (StringUtils.isNotBlank(date))
		{
			dateStr = date.substring(0, 4) + DATE_FORMART_SYMBOL_LINE + date.substring(4, 6) + DATE_FORMART_SYMBOL_LINE
					+ date.substring(6, 8) + DATE_FORMART_SYMBOL_SPACE + date.substring(8, 10)
					+ DATE_FORMART_SYMBOL_COLON + date.substring(10, 12) + DATE_FORMART_SYMBOL_COLON
					+ date.substring(12, 14);
		}
		return dateStr;
	}

	/**
	 * @Description: 格式化日期 2014-02-01->20140201
	 */
	public static String formatDateReplaceLine(String date)
	{
		if (date.contains(DATE_FORMART_SYMBOL_LINE))
		{
			return date.replace(DATE_FORMART_SYMBOL_LINE, "");
		}
		return date;
	}

	/**
	 * @Description: 格式化时间 092112->09:12:12
	 */
	public static String formatTimeSimple(String time, String separetor)
	{
		String timeStr = time.substring(0, 2) + separetor + time.substring(2, 4) + separetor + time.substring(4, 6);
		return timeStr;
	}

	/**
	 * @Title: getFormartDate
	 * @Description: date --> string
	 * @param formart
	 * @param date
	 * @return
	 */
	public static String getFormartDate(String formart, Date date)
	{
		DateFormat df = new SimpleDateFormat(formart);
		return null != date ? df.format(date) : null;
	}

	/**
	 * @Title: getFormartDate
	 * @Description: string --> date
	 * @param formart
	 * @param date
	 * @return
	 */
	public static Date getFormartDate(String formart, String date)
	{
		DateFormat df = new SimpleDateFormat(formart);
		try
		{
			return null != date ? df.parse(date) : null;
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String getFormartDateToString(String formart, String date)
	{
		DateFormat df = new SimpleDateFormat(formart);
		try
		{
			return StringUtils.isNotBlank(date) ? df.format(df.parse(date)) : "";
		} catch (ParseException e)
		{
			return "";
		}
	}

	public static String getyyyyMMddHHmmss()
	{
		return getFormartDate(DATE_FORMART_YYYYMMDDHHMMSS, new Date());
	}

	public static int getNowYear()
	{
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getNowMonth()
	{
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	public static int getNowMDay()
	{
		return Calendar.getInstance().get(Calendar.DATE);
	}

	/**
	* 获取当前日期的前一天(YYYYMMDD)
	*/
	public static String getPreviousDate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date finalDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
		return dateFormat.format(finalDate);
	}

	/**
	* 获取当前日期的前一天(YYYY-MM-DD)
	*/
	public static String getPreviousDateLine(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date finalDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMART_YYYY_MM_DD);
		return dateFormat.format(finalDate);
	}

	/**
	* 获取当前日期的后一天(YYYYMMDD)
	*/
	public static String getAfterDate(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date finalDate = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
		return dateFormat.format(finalDate);
	}

	/**
	* @Title: getBeforeWeekDay
	* @Description: 以当前日期为终点，获取七天前的日期
	* @param date
	* @return param
	* @return Date return type
	* @throws
	 */
	public static String getBeforeWeekDay(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, -6);
		Date d = c.getTime();
		return getFormartDate(DATE_FORMART_YYYYMMDD, d);
	}

	/**
	 * @Title: getBeforeMonthDay
	 * @Description: 以当前日期为终点，获取一个月前的日期
	 * @param date
	 * @return param
	 * @return String return type
	 * @throws
	 */
	public static String getBeforeMonthDay(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONDAY, -1);
		Date d = c.getTime();
		return getFormartDate(DATE_FORMART_YYYYMMDD, d);
	}

	/**
	* @Title: getBefore2MonthDay
	* @Description: 以当前日期为终点，获取两个月前的日期
	* @param date
	* @return param
	* @return String return type
	* @throws
	 */
	public static String getBefore2MonthDay(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -2);
		Date d = c.getTime();
		return getFormartDate(DATE_FORMART_YYYYMMDD, d);
	}

	/**
	* @Title: getBefore3MonthDay
	* @Description: 以当前日期为终点，获取三个月前的日期
	* @param date
	* @return param
	* @return String return type
	* @throws
	*/
	public static String getBefore3MonthDay(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -3);
		Date d = c.getTime();
		return getFormartDate(DATE_FORMART_YYYYMMDD, d);
	}

	/**
	* @Title: getFirstDayOfWeek
	* @Description: 以当前日期为终点，获取一周前的日期
	* @return 参数
	* @return Date 返回类型
	* @throws
	*/
	public static String getFirstDayOfWeek()
	{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -6);
		return getFormartDate(DATE_FORMART_YYYYMMDD, c.getTime());
	}

	/**
	* @Title: compareToDate
	* @Description: 判断两个字符串类型的日期大小
	* @param date1
	* @param date2
	* @return param
	* @return boolean return type
	* @throws
	 */
	public static boolean compareToDate(String date1, String date2)
	{
		return 1 == new BigDecimal(date2).compareTo(new BigDecimal(date1)) ? true : false;
	}

	/**
	* @Title: compareToDate
	* @Description: 判断两个字符串类型的日期大小
	* @param date1
	* @param date2
	* @return param
	* @return boolean return type
	* @throws
	 */
	public static boolean compareToDateContainsEq(String date1, String date2)
	{
		return 0 <= new BigDecimal(date2).compareTo(new BigDecimal(date1)) ? true : false;
	}

	/**
	* @Title: getDayBetweenTwoStr
	* @Description: 计算两个字符串类型的日期大小之间相隔几天
	* @param date1	格式如：20141230
	* @param date2	格式如：20141231
	* @return param
	* @return int return type
	* @throws
	 */
	public static long getDayBetweenTwoStr(String date1, String date2)
	{
		SimpleDateFormat sf = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
		long days = 0;
		try
		{
			long dateTimes = sf.parse(date2).getTime() - sf.parse(date1).getTime();
			days = dateTimes / 1000 / 60 / 60 / 24;
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return days;
	}

	/**
	* @Title: checkIsCurrentMonth
	* @Description:校验日期是否属于系统当前月
	* @return param yyyyMMdd
	* @return String return type
	* @throws
	*/
	public static boolean checkIsCurrentMonth(String date)
	{
		return getFormartDate(DATE_FORMART_YYYYMMDD, new Date()).substring(0, 6).equals(date.substring(0, 6)) ? true
				: false;
	}

	/**
	 * @create user：huangchuang
	 * @create time：2015年8月31日
	 * @Description： 获取当前日期
	 */
	public static String formatyymmdd(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
		return format.format(date);
	}

	/**
	 * 格式化日期(YYYY-MM-DD)
	 */
	public static String formatyymmddLine(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYY_MM_DD);
		return format.format(date);
	}

	/**
	 * 格式化日期(YYYY-MM-DD)
	 * @throws ParseException 
	 */
	public static String formatyymmddLine(String date) throws ParseException
	{

		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYY_MM_DD);

		return format.format(format.parse(date));
	}

	/**
	 * @Title: getyymmddLine
	 * @Description: 获取当前日期(YYYY-MM-DD)
	 * @return
	 */
	public static String getyymmddLine()
	{
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYY_MM_DD);
		return format.format(new Date());
	}

	/**
	 * 将dateStr转成Date
	 */
	public static String parseDateStrToLine(String dateStr)
	{
		String dateString = "";
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
			dateString = formatyymmddLine(sdf.parse(dateStr));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * @create user：huangchuang
	 * @create time：2015年8月31日
	 * @Description： 获取当前时间
	 */
	public static String formathhmmss(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_HHMMSS);
		return format.format(date);
	}

	/**
	 * create user : suqiang
	 * create time : 2016年4月12日
	 * comment :获取当前日期的小时
	 */
	public static int getCurrentHour()
	{
		SimpleDateFormat df = new SimpleDateFormat("HH");
		String hour = df.format(new Date());
		return Integer.valueOf(hour).intValue();
	}

	/**
	 * @Title: formatStrDate
	 * @Description: string->date
	 * @param date
	 * @return
	 */
	public static Date formatStrDate(String date)
	{
		Date d = null;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDDHHMMSS);
			d = sdf.parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return d;
	}

	public static String formatStrDateYYYYMMDDHHMMSS(String date)
	{
		return getFormartDate(DATE_FORMART_YYYYMMDD_HHMMSS, formatStrDate(date));
	}

	/**
	 * @Title: getStrDate
	 * @Description: 获取当前时间
	 * @param date
	 * @return
	 */
	public static String getStrDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDDHHMMSS);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return sdf.format(c.getTime());
	}

	/**
	 * @Title: getStrSevenDaysLaterDate
	 * @Description: 获取7天后当前时间
	 * @param date
	 * @return
	 */
	public static String getStrSevenDaysLaterDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDDHHMMSS);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 7);
		return sdf.format(c.getTime());
	}

	public static boolean isNumeric(Object str)
	{
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str.toString());
		if (!isNum.matches())
		{
			return false;
		}
		return true;
	}

	// 16位整数位，两小数位
	public static String format(String number)
	{
		DecimalFormat df = new DecimalFormat("###############0.00 ");
		return df.format( number);
	}

	public static void main(String[] args) throws ParseException
	{
		// System.out.println(formatStrDate("20170312120530"));
		// System.out.println(formatStrDateYYYYMMDDHHMMSS("20170312120530"));
		//// System.out.println(formatDateSimpleyyyyMMddHHmmss("20170312120530"));
		// Date date = new Date();
		// System.out.println(getStrDate(date));
		// System.out.println(getStrSevenDaysLaterDate(date));
		//// DateUtil.compareToDateContainsEq(getStrDate(new Date()),
		// getStrSevenDaysLaterDate(date))
		// System.out.println(compareToDateContainsEq(getStrDate(new Date()),
		// getStrSevenDaysLaterDate(date)));
		System.out.println(formatDateSimple("20171120", "-"));
	}

}
