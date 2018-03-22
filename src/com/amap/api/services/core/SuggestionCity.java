package com.amap.api.services.core;

public class SuggestionCity {
    private String f12294a;
    private String f12295b;
    private String f12296c;
    private int f12297d;

    protected SuggestionCity() {
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f12294a = str;
        this.f12295b = str2;
        this.f12296c = str3;
        this.f12297d = i;
    }

    public String getCityName() {
        return this.f12294a;
    }

    public void setCityName(String str) {
        this.f12294a = str;
    }

    public String getCityCode() {
        return this.f12295b;
    }

    public void setCityCode(String str) {
        this.f12295b = str;
    }

    public String getAdCode() {
        return this.f12296c;
    }

    public void setAdCode(String str) {
        this.f12296c = str;
    }

    public int getSuggestionNum() {
        return this.f12297d;
    }

    public void setSuggestionNum(int i) {
        this.f12297d = i;
    }
}
