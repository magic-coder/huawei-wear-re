package com.huawei.hwcloudmodel.model.unite;

import java.util.Set;

public class GetSportDataByTimeReq {
    private Integer dataType;
    private Long deviceCode;
    private Long endTime;
    private Integer queryType;
    private Set<Integer> sportTypes;
    private Long startTime;

    public Integer getQueryType() {
        return this.queryType;
    }

    public void setQueryType(Integer num) {
        this.queryType = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public Set<Integer> getSportTypes() {
        return this.sportTypes;
    }

    public void setSportTypes(Set<Integer> set) {
        this.sportTypes = set;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer num) {
        this.dataType = num;
    }

    public String toString() {
        return "GetSportDataByTimeReq{queryType=" + this.queryType + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", sportTypes=" + this.sportTypes + ", dataType=" + this.dataType + ", deviceCode=" + this.deviceCode + '}';
    }
}
