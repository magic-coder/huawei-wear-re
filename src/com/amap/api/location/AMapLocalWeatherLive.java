package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;

public class AMapLocalWeatherLive {
    private String f10603a;
    private String f10604b;
    private String f10605c;
    private String f10606d;
    private String f10607e;
    private String f10608f;
    private AMapLocException f10609g;
    private String f10610h;
    private String f10611i;
    private String f10612j;

    public String getCity() {
        return this.f10610h;
    }

    public void setCity(String str) {
        this.f10610h = str;
    }

    public String getProvince() {
        return this.f10611i;
    }

    public void setProvince(String str) {
        this.f10611i = str;
    }

    public String getCityCode() {
        return this.f10612j;
    }

    public void setCityCode(String str) {
        this.f10612j = str;
    }

    public AMapLocException getAMapException() {
        return this.f10609g;
    }

    void m14050a(AMapLocException aMapLocException) {
        this.f10609g = aMapLocException;
    }

    public String getWeather() {
        return this.f10603a;
    }

    void m14051a(String str) {
        this.f10603a = str;
    }

    public String getTemperature() {
        return this.f10604b;
    }

    void m14052b(String str) {
        this.f10604b = str;
    }

    public String getWindDir() {
        return this.f10605c;
    }

    void m14053c(String str) {
        this.f10605c = str;
    }

    public String getWindPower() {
        return this.f10606d;
    }

    void m14054d(String str) {
        this.f10606d = str;
    }

    public String getHumidity() {
        return this.f10607e;
    }

    void m14055e(String str) {
        this.f10607e = str;
    }

    public String getReportTime() {
        return this.f10608f;
    }

    void m14056f(String str) {
        this.f10608f = str;
    }
}
