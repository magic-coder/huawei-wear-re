package com.amap.api.location;

import android.location.Location;
import com.amap.api.location.core.AMapLocException;

public class AMapLocation extends Location {
    private String f10613a;
    private String f10614b;
    private String f10615c;
    private String f10616d;
    private String f10617e;
    private String f10618f;
    private String f10619g;
    private String f10620h;
    private String f10621i;
    private String f10622j;
    private String f10623k;
    private String f10624l;
    private AMapLocException f10625m = new AMapLocException();

    public String getPoiName() {
        return this.f10624l;
    }

    public void setPoiName(String str) {
        this.f10624l = str;
    }

    public String getCountry() {
        return this.f10622j;
    }

    public void setCountry(String str) {
        this.f10622j = str;
    }

    public String getRoad() {
        return this.f10623k;
    }

    public void setRoad(String str) {
        this.f10623k = str;
    }

    public AMapLocException getAMapException() {
        return this.f10625m;
    }

    public void setAMapException(AMapLocException aMapLocException) {
        this.f10625m = aMapLocException;
    }

    void m14057a(String str) {
        this.f10620h = str;
    }

    public void setAddress(String str) {
        this.f10621i = str;
    }

    public String getPoiId() {
        return this.f10618f;
    }

    public void setPoiId(String str) {
        this.f10618f = str;
    }

    public String getFloor() {
        return this.f10619g;
    }

    public void setFloor(String str) {
        this.f10619g = str;
    }

    public AMapLocation(String str) {
        super(str);
    }

    public AMapLocation(Location location) {
        super(location);
    }

    public String getProvince() {
        return this.f10613a;
    }

    public void setProvince(String str) {
        this.f10613a = str;
    }

    public String getCity() {
        return this.f10614b;
    }

    public void setCity(String str) {
        this.f10614b = str;
    }

    public String getDistrict() {
        return this.f10615c;
    }

    public void setDistrict(String str) {
        this.f10615c = str;
    }

    public String getCityCode() {
        return this.f10616d;
    }

    public void setCityCode(String str) {
        this.f10616d = str;
    }

    public String getAdCode() {
        return this.f10617e;
    }

    public void setAdCode(String str) {
        this.f10617e = str;
    }

    public String getAddress() {
        return this.f10621i;
    }

    public String getStreet() {
        return this.f10620h;
    }
}
