package com.siyu.nms.service.impl;

import com.siyu.nms.dao.WeatherMapper;
import com.siyu.nms.entity.Weather;
import com.siyu.nms.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherMapper weatherMapper;

    /**
     * 添加气象数据
     *
     * @param weather
     * @return
     */
    @Override
    public int addData(Weather weather) {
        return weatherMapper.addData(weather);
    }

    /**
     * 查询当天是否有气象数据
     *
     * @param weather
     * @return
     */
    @Override
    public int checkWeather(Weather weather) {
        return weatherMapper.checkWeather(weather);
    }

    /**
     * 修改当天的气象数据
     *
     * @return
     */
    @Override
    public int updWeather(Weather weather) {
        return weatherMapper.updWeather(weather);
    }

}
