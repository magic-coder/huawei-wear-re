package com.snowballtech.business.bean;

import java.io.Serializable;
import java.util.Map;

public class WTaskBaseBean implements Serializable {
    private Map<String, String> bodyParm;
    private Map<String, String> headerParm;
    private boolean needParser = false;
    private int requestType;
    private String tag;
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public Map<String, String> getHeaderParm() {
        return this.headerParm;
    }

    public void setHeaderParm(Map<String, String> map) {
        this.headerParm = map;
    }

    public Map<String, String> getBodyParm() {
        return this.bodyParm;
    }

    public void setBodyParm(Map<String, String> map) {
        this.bodyParm = map;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public boolean isNeedParser() {
        return this.needParser;
    }

    public void setNeedParser(boolean z) {
        this.needParser = z;
    }
}
