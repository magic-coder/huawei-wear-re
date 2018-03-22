package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import java.util.List;

public class HealthDetail {
    private Long deviceCode;
    private Long endTime;
    private String metadata;
    private String recordId;
    private List<SamplePoint> samplePoints;
    private Long startTime;
    private String timeZone;
    private Integer type;
    private Long version;

    public String getRecordId() {
        return this.recordId;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public List<SamplePoint> getSamplePoints() {
        return this.samplePoints;
    }

    public void setSamplePoints(List<SamplePoint> list) {
        this.samplePoints = list;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(String str) {
        this.metadata = str;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public String toString() {
        return "HealthDetail{startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ", recordId='" + this.recordId + '\'' + ", deviceCode=" + this.deviceCode + ", samplePoints=" + this.samplePoints + ", metadata='" + this.metadata + '\'' + ", timeZone='" + this.timeZone + '\'' + ", version=" + this.version + '}';
    }
}
