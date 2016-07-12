//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.iguiyu.dingdong.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final String[] NUM = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    public static final int ONEMINUTE = 60000;
    public static final int TENMINUTE = 600000;
    public static final int HALFHOUR = 1800000;
    public static final int ONEHOUR = 3600000;
    public static final int TWOHOUR = 7200000;
    public static final int ONEDAY = 86400000;

    public DateUtil() {
    }

    public static final String getYesterdayStr() {
        return dateFormat((new Date()).getTime() - 86400000L, "yyyy-MM-dd");
    }

    public static final Timestamp getYesterday() {
        return strToDate(getYesterdayStr());
    }

    public static final String getTodayStr() {
        return dateFormat((new Date()).getTime(), "yyyy-MM-dd");
    }

    public static final Timestamp getToday() {
        return strToDate(getTodayStr());
    }

    public static final String getTomorrowStr() {
        return dateFormat((new Date()).getTime() + 86400000L, "yyyy-MM-dd");
    }

    public static final Timestamp getTomorrow() {
        return strToDate(getTomorrowStr());
    }

    public static final Timestamp strToDate(String dateStr) {
        return strToDate(dateStr, "yyyy-MM-dd");
    }

    public static final Timestamp strToDate(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date();
        Timestamp t = new Timestamp(date.getTime());

        try {
            date = formatter.parse(dateStr);
            t = new Timestamp(date.getTime());
        } catch (ParseException var6) {
            var6.printStackTrace();
        }

        return t;
    }

    public static final String dateToWeek(Timestamp t) {
        String week = "星期";
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(t.getTime()));
        int re = c.get(7);
        return week + NUM[re - 1];
    }

    public static final boolean isTheSameDay(Timestamp t1, Timestamp t2) {
        return t1.getTime() / 86400000L == t2.getTime() / 86400000L;
    }

    public static final String dateFormat(Timestamp date) {
        return dateFormat(date.getTime());
    }

    public static final String dateFormat(long datenum) {
        return dateFormat(datenum, "yyyy-MM-dd HH:mm:ss");
    }

    public static final String dateFormat(Timestamp date, String format) {
        return dateFormat(date.getTime(), format);
    }

    public static final String dateFormat(long datenum, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = new Date(datenum);
        String re = formatter.format(date);
        return re;
    }

    public static final String dateDesc(Timestamp ts) {
        String re = "";
        long pub_time = ts.getTime();
        long now_time = (new Date()).getTime();
        int diff = (int)(now_time - pub_time);
        return diff > 86400000?ts.toString().substring(0, ts.toString().length() - 8):(diff > 7200000?"今天":(diff > 3600000?"一小时前":(diff > 1800000?"半小时前":(diff > 600000?"十分钟前":"刚刚"))));
    }

    public static void main(String[] args) {
        Date d = new Date();
        long s = d.getTime();
        String re = dateFormat(s);
        System.out.println("时间转换为 " + re);
        Timestamp t = new Timestamp(d.getTime());
        System.out.println(dateToWeek(t));
        Timestamp ti = strToDate("2015-01-01", "yyyy-MM-dd");
        System.out.println(ti);
    }
}
