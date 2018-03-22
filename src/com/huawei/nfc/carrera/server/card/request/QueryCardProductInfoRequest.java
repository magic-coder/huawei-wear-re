package com.huawei.nfc.carrera.server.card.request;

import java.util.Map;
import java.util.Set;

public class QueryCardProductInfoRequest extends CardServerBaseRequest {
    private static final String DEFAULT_CLIENT = "nfc";
    private static final String DEFAULT_VERSION = "201607V1_9";
    private String client = "nfc";
    private Set<Map<String, String>> filters;
    private long timeStamp;
    private String version = DEFAULT_VERSION;

    public String getVersion() {
        return this.version;
    }

    public String getClient() {
        return this.client;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public Set<Map<String, String>> getFilters() {
        return this.filters;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setFilters(Set<Map<String, String>> set) {
        this.filters = set;
    }
}
