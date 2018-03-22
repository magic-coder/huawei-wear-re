package com.huawei.hwcloudmodel.model;

import com.huawei.hwcloudmodel.model.unite.SportBasicInfo;

public class SportTotalData {
    private Integer dataSource;
    private Long deviceCode;
    private Integer recordDay;
    private SportBasicInfo sportBasicInfo;
    private Integer sportType;
    private String timeZone;

    public Integer getRecordDay() {
        return this.recordDay;
    }

    public void setRecordDay(Integer num) {
        this.recordDay = num;
    }

    public Integer getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(Integer num) {
        this.dataSource = num;
    }

    public Integer getSportType() {
        return this.sportType;
    }

    public void setSportType(Integer num) {
        this.sportType = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public SportBasicInfo getSportBasicInfo() {
        return this.sportBasicInfo;
    }

    public void setSportBasicInfo(SportBasicInfo sportBasicInfo) {
        this.sportBasicInfo = sportBasicInfo;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String toString() {
        return "SportTotalData{recordDay=" + this.recordDay + ", dataSource=" + this.dataSource + ", sportType=" + this.sportType + ", deviceCode=" + this.deviceCode + ", sportBasicInfo=" + this.sportBasicInfo + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
