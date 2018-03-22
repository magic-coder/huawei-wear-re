package com.huawei.hwcloudmodel.model.unite;

public class GetSportStatReq {
    private Integer dataSource = Integer.valueOf(2);
    private Long deviceCode;
    private Integer endTime;
    private Integer startTime;

    public Integer getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Integer num) {
        this.endTime = num;
    }

    public Integer getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Integer num) {
        this.startTime = num;
    }

    public Integer getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(Integer num) {
        this.dataSource = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String toString() {
        return "GetSportStatReq{startTime=" + this.startTime + ", endTime=" + this.endTime + ", dataSource=" + this.dataSource + ", deviceCode=" + this.deviceCode + '}';
    }
}
