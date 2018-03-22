package com.huawei.hwcloudmodel.model.unite;

public class GetSportDataByVersionReq {
    private Integer dataType;
    private Long deviceCode;
    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public void setVersion(int i) {
        this.version = Long.valueOf((long) i);
    }

    public String toString() {
        return "GetSportDataByVersionReq{version=" + this.version + ", dataType=" + this.dataType + ", deviceCode=" + this.deviceCode + '}';
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer num) {
        this.dataType = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }
}
