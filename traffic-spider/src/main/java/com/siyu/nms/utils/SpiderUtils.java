package com.siyu.nms.utils;

import java.util.Calendar;
import java.util.Date;

public class SpiderUtils {

    /**
     * 获取当前的星期
     *
     * @return
     */
    public static String getWeek() {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "周日";
        } else if (weekday == 2) {
            week = "周一";
        } else if (weekday == 3) {
            week = "周二";
        } else if (weekday == 4) {
            week = "周三";
        } else if (weekday == 5) {
            week = "周四";
        } else if (weekday == 6) {
            week = "周五";
        } else if (weekday == 7) {
            week = "周六";
        }
        return week;
    }


    /**
     * 根据空气指数判断对应的空气质量
     *
     * @param index
     * @return
     */
    public static String getAirQuality(String index) {
        int num = Integer.parseInt(index);
        String airQuality = "";
        if (0 <= num && num < 50) {//优
            airQuality = "优";
        } else if (50 <= num && num < 100) {//良
            airQuality = "良";
        } else if (100 <= num && num < 150) {//轻度污染
            airQuality = "轻度污染";
        } else if (150 <= num && num < 300) {//中度污染
            airQuality = "中度污染";
        } else if (300 <= num && num < 500) {//重度污染
            airQuality = "重度污染";
        } else if (500 <= num) {//严重污染
            airQuality = "严重污染";
        }
        return airQuality;
    }

    /**
     * 根据天气情况返回对应的图片路径
     *
     * @param day
     * @return
     */
    public static String getWeatherImages(String day) {
        if (("晴").equals(day)) {
            return "晴";
        } else if (("阴").equals(day)) {
            return "阴";
        } else if (("多云").equals(day)) {
            return "多云";
        } else if (("阵雨").equals(day)) {
            return "阵雨";
        } else if (("小雨").equals(day)) {
            return "小雨";
        } else if (("中雨").equals(day)) {
            return "中雨";
        } else if (("大雨").equals(day)) {
            return "大雨";
        } else if (("暴雨").equals(day)) {
            return "暴雨";
        } else if (("大暴雨").equals(day)) {
            return "大暴雨";
        } else if (("特大暴雨").equals(day)) {
            return "特大暴雨";
        } else if (("雷阵雨").equals(day)) {
            return "雷阵雨";
        } else if (("小雪").equals(day)) {
            return "小雪";
        } else if (("中雪").equals(day)) {
            return "中雪";
        } else if (("大雪").equals(day)) {
            return "大雪";
        } else if (("雾").equals(day)) {
            return "雾";
        } else if ("小到中雨".equals(day)) {
            return "小雨到中雨";
        } else if ("中到大雨".equals(day)) {
            return "中雨到大雨";
        } else if ("大到暴雨".equals(day)) {
            return "大雨到暴雨";
        } else if ("暴雨到大暴雨".equals(day)) {
            return "暴雨到大暴雨";
        } else if ("大到特大暴雨".equals(day)) {
            return "大暴雨到特大暴雨";
        } else if ("小到中雪".equals(day)) {
            return "小雪到中雪";
        } else if ("中到大雪".equals(day)) {
            return "中雪到大雪";
        } else if ("大到暴雪".equals(day)) {
            return "大雪到暴雪";
        } else if ("浮尘".equals(day)) {
            return "浮尘";
        } else if ("扬沙".equals(day)) {
            return "扬沙";
        } else if ("强沙尘暴".equals(day)) {
            return "强沙尘暴";
        } else if ("霾".equals(day)) {
            return "霾";
        } else if (("雨夹雪").equals(day)) {
            return "雨夹雪";
        } else if (("暴雪").equals(day)) {
            return "暴雪";
        } else if (("阵雪").equals(day)) {
            return "阵雪";
        } else if (("冻雨").equals(day)) {
            return "冻雨";
        } else if ("沙尘暴".equals(day)) {
            return "沙尘暴";
        }
        return "";

    }

    /**
     * 判断白天和夜间的天气情况，返回对应的天气情况
     *
     * @param day
     * @param night
     * @return
     */
    public static String getWeatherSituation(String day, String night) {
        if (day.equals(night)) {
            return day;
        } else {
            return day + "转" + night;
        }
    }

    public static void main(String[] args) {
        Integer a = 100, b = 100, c = 150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);

    }
}
