package com.siyu.nms.dao;

import com.siyu.nms.entity.Weather;

public interface WeatherMapper {
    /**
     * 添加气象数据
     *
     * @param weather
     * @return
     */
    public int addData(Weather weather);

    /**
     * 查询当天是否有气象数据
     *
     * @param weather
     * @return
     */
    public int checkWeather(Weather weather);

    /**
     * 修改当天的气象数据
     *
     * @param weather
     * @return
     */
    public int updWeather(Weather weather);
}
