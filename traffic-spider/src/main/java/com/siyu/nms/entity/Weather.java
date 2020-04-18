package com.siyu.nms.entity;

import java.util.Date;

/**
 * Create by zjy
 */
public class Weather {
    private int id;
    private String week;        //星期
    private String noteDate;      //日期
    private String according;   //农历
    private String weatherSituation; //天气情况
    private String temperature; //气温
    private String humidity;    //湿度
    private String wind;        //风向
    private String scale;       //风级
    private String rainfall;    //降雨量
    private String visibility;  //能见度
    private String provinces;   //省份
    private String provincial;  //省会
    private String airIndex;    //空气指数
    private String airQuality;  //空气质量
    private String highest;     //最高气温
    private String lowest;      //最低气温
    private String ultraviolet; //紫外线强度
    private String sunrise;     //日出时分
    private String sunset;      //日落时分
    private String airPower;    //气压
    private String prompt;      //温馨提示
    private String weatherImages;//图片路径

    public String getAirIndex() {
        return airIndex;
    }

    public void setAirIndex(String airIndex) {
        this.airIndex = airIndex;
    }

    public String getWeatherImages() {
        return weatherImages;
    }

    public void setWeatherImages(String weatherImages) {
        this.weatherImages = weatherImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getAccording() {
        return according;
    }

    public void setAccording(String according) {
        this.according = according;
    }

    public String getWeatherSituation() {
        return weatherSituation;
    }

    public void setWeatherSituation(String weatherSituation) {
        this.weatherSituation = weatherSituation;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public String getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(String airQuality) {
        this.airQuality = airQuality;
    }

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public String getLowest() {
        return lowest;
    }

    public void setLowest(String lowest) {
        this.lowest = lowest;
    }

    public String getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(String ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getAirPower() {
        return airPower;
    }

    public void setAirPower(String airPower) {
        this.airPower = airPower;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", week='" + week + '\'' +
                ", noteDate='" + noteDate + '\'' +
                ", according='" + according + '\'' +
                ", weatherSituation='" + weatherSituation + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                ", scale='" + scale + '\'' +
                ", rainfall='" + rainfall + '\'' +
                ", visibility='" + visibility + '\'' +
                ", provinces='" + provinces + '\'' +
                ", provincial='" + provincial + '\'' +
                ", airIndex='" + airIndex + '\'' +
                ", airQuality='" + airQuality + '\'' +
                ", highest='" + highest + '\'' +
                ", lowest='" + lowest + '\'' +
                ", ultraviolet='" + ultraviolet + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", airPower='" + airPower + '\'' +
                ", prompt='" + prompt + '\'' +
                ", weatherImages='" + weatherImages + '\'' +
                '}';
    }
}
