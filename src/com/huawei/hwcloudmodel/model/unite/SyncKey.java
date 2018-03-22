package com.huawei.hwcloudmodel.model.unite;

public class SyncKey {
    private Integer dataType;
    private Long deviceCode;
    private Integer type;
    private Long version;

    public Integer getDataType() {
        return this.dataType;
    }

    public void setDataType(Integer num) {
        this.dataType = num;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long l) {
        this.version = l;
    }

    public String toString() {
        return "SyncKey{dataType=" + this.dataType + ", type=" + this.type + ", deviceCode=" + this.deviceCode + ", version=" + this.version + '}';
    }
}
