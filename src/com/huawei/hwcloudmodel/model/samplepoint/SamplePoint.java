package com.huawei.hwcloudmodel.model.samplepoint;

import java.io.Serializable;

public class SamplePoint implements Serializable {
    private Long endTime;
    private String key;
    private Long startTime;
    private String unit;
    private String value;

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        return "SamplePoint{startTime=" + this.startTime + ", endTime=" + this.endTime + ", key='" + this.key + '\'' + ", value='" + this.value + '\'' + ", unit='" + this.unit + '\'' + '}';
    }
}
