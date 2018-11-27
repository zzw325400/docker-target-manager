package com.ecreditpal.targetmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhengzhenwen
 * @data 2018/11/14 13:59
 * @description
 **/
public class DateUtil {
    public static String getStringYYMMddHHmmss(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sDateFormat.format(date);
    }
    public static String getStringYYMMdd(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return sDateFormat.format(date);
    }
    public static Date getDate(String str) throws ParseException {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sDateFormat.parse(str);
    }

    public static Date getToday() throws ParseException {
        Date date = new Date();
        String str = getStringYYMMdd(date);
        return getDate(str);
    }

    public static Date getDiffDay(Date date, int diff) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, diff);// +1天

        Date diffDay = c.getTime();
        return diffDay;

    }

    public static Date getLocalDate() {

        return new Date(System.currentTimeMillis());
    }

    public static String generateCalendarString(int dateDiff) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dateDiff);
        String dateString = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
                + (calendar.get(Calendar.DAY_OF_MONTH)) + "日";
        return dateString;
    }

    public static Date getFirstDayOfMonth() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());
        return getDate(firstDay);
    }
}
