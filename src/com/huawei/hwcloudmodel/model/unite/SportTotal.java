package com.huawei.hwcloudmodel.model.unite;

public class SportTotal {
    private Integer dataSource;
    private Long deviceCode;
    private Integer recordDay;
    private SportBasicInfo sportBasicInfo;
    private Integer sportType;
    private String timeZone;

    public Integer getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(Integer num) {
        this.dataSource = num;
    }

    public Integer getRecordDay() {
        return this.recordDay;
    }

    public void setRecordDay(Integer num) {
        this.recordDay = num;
    }

    public Integer getSportType() {
        return this.sportType;
    }

    public void setSportType(Integer num) {
        this.sportType = num;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public SportBasicInfo getSportBasicInfo() {
        return this.sportBasicInfo;
    }

    public void setSportBasicInfo(SportBasicInfo sportBasicInfo) {
        this.sportBasicInfo = sportBasicInfo;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String toString() {
        return "SportTotal{recordDay=" + this.recordDay + ", dataSource=" + this.dataSource + ", sportType=" + this.sportType + ", deviceCode=" + this.deviceCode + ", sportBasicInfo=" + this.sportBasicInfo + ", timeZone='" + this.timeZone + '\'' + '}';
    }
}
