package com.huawei.hwcloudmodel.model.unite;

public class GetMotionPathByVersionReq {
    private String condition;
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

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String str) {
        this.condition = str;
    }

    public String toString() {
        return "GetMotionPathByVersionReq{version=" + this.version + ", dataType=" + this.dataType + ", deviceCode=" + this.deviceCode + ", condition=" + this.condition + '}';
    }
}
