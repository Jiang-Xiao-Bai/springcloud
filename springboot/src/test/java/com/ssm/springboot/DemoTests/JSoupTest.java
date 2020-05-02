package com.ssm.springboot.DemoTests;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * 去除String中的HTML代码
 *
 * @author zhaohf
 * @date 2020/3/8 21:12
 */
@Slf4j
public class JSoupTest {

    public static void deleteHtmlDemo() {
        String html = "<html><head><title>Website title</title></head><body><p>Sample paragraph number 1 </p><p>Sample paragraph number 2</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.title());
        Elements paragraphs = doc.getElementsByTag("p");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }
    }

    public static void getDataByIntent() {
        final String url = "https://www.cnblogs.com/javazhiyin/p/11841374.html";
        try {
            Document document = Jsoup.connect(url).timeout(5000).get();
            Elements elements = document.getElementById("cnblogs_post_body").getElementsByTag("p").after("&nbsp;");
//            for (Element element : elements) {
//                log.info("element对象："+element.text());
//            }
            System.out.println(elements.get(1).text());
            System.out.println(elements.get(2).text());
        } catch (IOException e) {
            log.info("爬取数据异常", e);
        }
    }

    public static void getWeather(String areaStr) {
        try {
            final String areaStrUrl = "http://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=" + areaStr +"天气";
            String url = Jsoup.connect(areaStrUrl).timeout(3000).get().select(".t").
                    get(0).getElementsByTag("a").attr("href");
            log.info("爬取地址："+url);
            Document document = Jsoup.connect(url).timeout(3000).get();
            Elements areaElements = document.select(".ctop > .crumbs");
            Elements weaherElements = document.getElementById("7d").select(".sky");
            for (Element element : weaherElements) {
                System.out.println("-------------------------------------");
                System.out.println(areaElements.get(0).getElementsByTag("a").get(2).text());
                String dateStr=element.getElementsByTag("h1").text();
                System.out.println(StringUtils.substringBefore(dateStr,"日"));
                System.out.println(element.select(".wea").text());
                System.out.println(element.select(".tem").text());
                System.out.println(element.select(".win").text());
            }
        } catch (Exception e) {
            log.info("爬取数据异常",e);
        }


    }

    public static void main(String[] args) {
        getWeather("西安");
    }
}
