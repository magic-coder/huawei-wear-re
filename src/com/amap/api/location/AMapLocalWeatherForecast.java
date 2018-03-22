package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;
import java.util.List;

public class AMapLocalWeatherForecast {
    private String f10600a;
    private List<AMapLocalDayWeatherForecast> f10601b;
    private AMapLocException f10602c;

    public AMapLocException getAMapException() {
        return this.f10602c;
    }

    void m14047a(AMapLocException aMapLocException) {
        this.f10602c = aMapLocException;
    }

    public String getReportTime() {
        return this.f10600a;
    }

    void m14048a(String str) {
        this.f10600a = str;
    }

    public List<AMapLocalDayWeatherForecast> getWeatherForecast() {
        return this.f10601b;
    }

    void m14049a(List<AMapLocalDayWeatherForecast> list) {
        this.f10601b = list;
    }
}
