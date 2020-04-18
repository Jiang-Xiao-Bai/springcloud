package com.siyu.nms.utils;

import com.siyu.nms.entity.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 爬虫工具类
 */
public class JsoupHelper {
    /**
     * 根据url 和页面的选择器返回对应的数据
     * 返回实体类的所有字段对应选择器的文本（字段）
     *
     * @param
     * @param
     * @return
     * @throws IOException
     */
    public static Weather getData() throws IOException {
        System.out.println("------开始抓取数据中----------");
        Date currentTime = new Date();
        int timeout = 5000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long startTime = System.currentTimeMillis();
        org.jsoup.nodes.Document documentOne = Jsoup.connect("http://tianqi.2345.com/today-59289.htm").timeout(timeout).get();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        org.jsoup.nodes.Document documentTwo = Jsoup.connect("http://tianqi.2345.com/dongguan/59289.htm").get();//主要爬取省份省会，和天气情况
        Document documentThree = Jsoup.connect("http://www.weather.com.cn/weather1d/101281601.shtml").timeout(timeout).get();
//        org.jsoup.nodes.Document documentFour = Jsoup.connect("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theUserID=&theCityCode=2351").get();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        org.jsoup.nodes.Document documentFive = Jsoup.connect("http://tianqi.2345.com/air-59289.htm").timeout(timeout).get();
        Weather weather = new Weather();
        //星期
        String week = SpiderUtils.getWeek();
        weather.setWeek(week);
        //日期
        weather.setNoteDate(sdf.format(currentTime));
        //农历
        String according = documentOne.select("#wrap > div.city_t > div.city_title.clearfix > div.btitle > span > a").text();
        weather.setAccording(according);
        //天气情况
        String day = documentOne.select("#wrap > div.hour-detail.today-detail > div.tbody > div.time-main > dl.day > dd > ul > li.ord1 > span.phrase").text();
        String night = documentOne.select("#wrap > div.hour-detail.today-detail > div.tbody > div.time-main > dl.night > dd > ul > li.ord1 > span.phrase").text();
        String weatherSituation = SpiderUtils.getWeatherSituation(day, night);
        weather.setWeatherSituation(weatherSituation);
        //当前气温
        String temperature = StringUtils.Finds(documentOne.select("#skInfo > div.filter > ul > li:nth-child(2) > i").text());
        weather.setTemperature(temperature);
        //湿度
        String humidity = StringUtils.Finds(documentOne.select("#skInfo > div.filter > ul > li:nth-child(5) > i").text());
        weather.setHumidity(humidity);
        //风向
        String wind = documentOne.select("#skInfo > div.filter > ul > li:nth-child(3) > i").text();
        weather.setWind(wind);
        //风级
        String scale = StringUtils.Finds(documentOne.select("#skInfo > div.filter > ul > li:nth-child(4) > i").text());
        weather.setScale(scale);
        //降雨量
//        StringUtils.Finds(documentThree.select("#\\31 > div.op_weather4_twoicon_container_div > div.op_weather4_xiala > div.op_weather4_xltabcontent > a > div:nth-child(3) > div.op_weather4_jsm > ul > li:nth-child(1) > span.op_weather4_jsml").text())
        //能见度
        String visibility = StringUtils.Finds(documentOne.select("#skInfo > div.filter > ul > li:nth-child(8) > i").text());
        weather.setVisibility(visibility);
        //省份
        String provinces = documentThree.select("body > div.con.today.clearfix > div.left.fl > div:nth-child(1) > div.ctop.clearfix > div.crumbs.fl > a:nth-child(3)").text();
        weather.setProvinces(provinces);
        //省会
        String provincial = documentThree.select("body > div.con.today.clearfix > div.left.fl > div:nth-child(1) > div.ctop.clearfix > div.crumbs.fl > a:nth-child(5)").text();
        weather.setProvincial(provincial);
        //空气指数
        String docment = documentFive.select(".lists > dl >dd:first-child >div:nth-child(3)>span:first-child").toString();
        String beginString = "<span>";
        String endString = "</span>";
        String airIndex = StringUtils.splitString(docment, beginString, endString);
        weather.setAirIndex(airIndex);
        //空气质量
        String airQuality = SpiderUtils.getAirQuality(airIndex);
        weather.setAirQuality(airQuality);
        //最高温度
        String highest = documentOne.select("#wrap > div.hour-detail.today-detail > div.tbody > div.time-main > dl.day > dd > ul > li.ord2 > span").text();
        weather.setHighest(StringUtils.Finds(highest));
        //最低温度
        String lowest = documentOne.select("#wrap > div.hour-detail.today-detail > div.tbody > div.time-main > dl.night > dd > ul > li.ord2 > span").text();
        weather.setLowest(StringUtils.Finds(lowest));
        //紫外线强度
        String ultraviolet = documentOne.select("#skInfo > div.filter > ul > li:nth-child(7) > i").text();
        weather.setUltraviolet(ultraviolet);
        //日出时分
        String sunrise = documentOne.select("#skInfo > div.filter > ul > li:nth-child(9) > i").text();
        weather.setSunrise(sunrise);
        //日落时分
        String sunset = documentOne.select("#skInfo > div.filter > ul > li:nth-child(10) > i").text();
        weather.setSunset(sunset);
        //气压
        String airPower = documentOne.select("#skInfo > div.filter > ul > li:nth-child(6) > i").text();
        weather.setAirPower(StringUtils.Finds(airPower));
        //温馨提示
        String prompt = documentOne.select("#emoticonId > span").text();
        weather.setPrompt(prompt);
        //图片路径
        String weatherImages = SpiderUtils.getWeatherImages(day);
        weather.setWeatherImages(weatherImages);
        long endTime = System.currentTimeMillis();
        System.out.println("------数据抓取完毕,耗时" + (endTime - startTime) + "毫秒----------");
        return weather;
    }

    public static void main(String[] args) throws IOException {
        try {
            Weather weather = JsoupHelper.getData();
            System.out.println(weather);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
