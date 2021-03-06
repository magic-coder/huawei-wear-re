package com.huawei.hwcloudmodel.model.userprofile;

public class DeviceInfo {
    private Long deviceCode;
    private String deviceData;
    private String firmwareVersion;
    private String hardwareVersion;
    private String manufacturer;
    private String name;
    private Integer priority;
    private Integer productId;
    private String softwareVersion;
    private String uniqueId;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer num) {
        this.productId = num;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public void setHardwareVersion(String str) {
        this.hardwareVersion = str;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public void setSoftwareVersion(String str) {
        this.softwareVersion = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String getDeviceData() {
        return this.deviceData;
    }

    public void setDeviceData(String str) {
        this.deviceData = str;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public String toString() {
        return "DeviceInfo{productId=" + this.productId + ", uniqueId='" + this.uniqueId + '\'' + ", manufacturer='" + this.manufacturer + '\'' + ", firmwareVersion='" + this.firmwareVersion + '\'' + ", hardwareVersion='" + this.hardwareVersion + '\'' + ", softwareVersion='" + this.softwareVersion + '\'' + ", name='" + this.name + '\'' + ", deviceCode=" + this.deviceCode + ", deviceData='" + this.deviceData + '\'' + ", priority=" + this.priority + '}';
    }
}
