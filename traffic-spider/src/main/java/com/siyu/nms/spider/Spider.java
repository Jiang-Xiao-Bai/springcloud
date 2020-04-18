package com.siyu.nms.spider;

import com.siyu.nms.entity.Weather;
import com.siyu.nms.service.WeatherService;
import com.siyu.nms.utils.JsoupHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by zhangjy on 2019/8/25.
 */
@Component
public class Spider {

    @Autowired
    WeatherService weatherService;

    /**
     * 定时器执行的任务
     * 0 0 1,8,15,21 * * ?
     * 0 0/1 * * * ?
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void getData() {
        Weather weather = null;
        try {
            weather = JsoupHelper.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断当天是否有气象数据
        int checkNum = weatherService.checkWeather(weather);
        if (checkNum > 0) {
            System.out.println("修改当天数据中......");
            int updNum = weatherService.updWeather(weather);
            if (updNum > 0) {
                System.out.println("修改当天气象数据成功");
            } else {
                System.out.println("修改当天气象数据失败");
            }
        } else {
            int num = this.weatherService.addData(weather);
            if (num > 0) {
                System.out.println("数据采集成功");
            } else {
                System.out.println("数据采集失败");
            }
        }
    }
}
