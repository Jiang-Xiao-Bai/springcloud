package com.ssm.springboot.DemoTests;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * 去除String中的HTML代码
 *
 * @author zhaohf
 * @date 2020/3/8 21:12
 */
@Slf4j
public class JSoupTest {

    public static void deleteHtmlDemo(){
        String html = "<html><head><title>Website title</title></head><body><p>Sample paragraph number 1 </p><p>Sample paragraph number 2</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.title());
        Elements paragraphs = doc.getElementsByTag("p");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }
    }

    public static void getDataByIntent(){
        final String url="https://www.cnblogs.com/javazhiyin/p/11841374.html";
        try {
            Document document= Jsoup.connect(url).timeout(5000).get();
            Elements elements=document.getElementById("cnblogs_post_body").getElementsByTag("p").after("&nbsp;");
//            for (Element element : elements) {
//                log.info("element对象："+element.text());
//            }
            System.out.println(elements.get(1).text());
            System.out.println(elements.get(2).text());
        } catch (IOException e) {
            log.info("爬取数据异常",e);
        }
    }

    public static void main(String[] args) {
        getDataByIntent();
    }
}
