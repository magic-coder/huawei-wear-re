package com.amap.api.maps.model;

public class MyTrafficStyle {
    private int f12084a = -16735735;
    private int f12085b = -35576;
    private int f12086c = -1441006;
    private int f12087d = -7208950;

    public int getSmoothColor() {
        return this.f12084a;
    }

    public void setSmoothColor(int i) {
        this.f12084a = i;
    }

    public int getSlowColor() {
        return this.f12085b;
    }

    public void setSlowColor(int i) {
        this.f12085b = i;
    }

    public int getCongestedColor() {
        return this.f12086c;
    }

    public void setCongestedColor(int i) {
        this.f12086c = i;
    }

    public int getSeriousCongestedColor() {
        return this.f12087d;
    }

    public void setSeriousCongestedColor(int i) {
        this.f12087d = i;
    }
}
