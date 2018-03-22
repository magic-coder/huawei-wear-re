package com.snowballtech.data.interaction;

import android.content.Context;
import java.util.Map;

public class RequesterParam<T> {
    private Context context;
    private Map<String, String> headerParam;
    private Map<String, String> param;
    private String requestMediaType;
    private int requestMethod = 1;
    private T requestObj;
    private int requestType = 3;
    private int responseType = 5;
    private String serverUrl;

    public Map<String, String> getHeaderParam() {
        return this.headerParam;
    }

    public void setHeaderParam(Map<String, String> map) {
        this.headerParam = map;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public T getRequestObj() {
        return this.requestObj;
    }

    public void setRequestObj(T t) {
        this.requestObj = t;
    }

    public int getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestMethod(int i) {
        this.requestMethod = i;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public void setRequestType(int i) {
        this.requestType = i;
    }

    public int getResponseType() {
        return this.responseType;
    }

    public void setResponseType(int i) {
        this.responseType = i;
    }

    public Map<String, String> getParam() {
        return this.param;
    }

    public void setParam(Map<String, String> map) {
        this.param = map;
    }

    public String getRequestMediaType() {
        return this.requestMediaType;
    }

    public void setRequestMediaType(String str) {
        this.requestMediaType = str;
    }
}
