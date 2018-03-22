package com.huawei.nfc.carrera.logic.spi.serveraccess.request;

public class BaseRequest {
    public static final String PAY_TYPE_HUAWEIPAY = "Huaweipay";
    public static final String SE_CHIP_MANUFACTURER_HISEE = "02";
    public static final String SE_CHIP_MANUFACTURER_NXP = "01";
    private String accountUserId = null;
    private String appletAid = null;
    private String basebandVersion = null;
    private String cplc = null;
    private String deviceModel = null;
    private String imei = null;
    private String issuerId = null;
    private String orderId = null;
    private String payType = "Huaweipay";
    private String phoneManufacturer = null;
    private String phoneNumber = null;
    private String reserved = null;
    private String seChipManuFacturer = null;
    private String seCosVersion = null;
    private String systemType = null;
    private String systemVersion = null;
    private String trafficCardId = null;

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public String getSeChipManuFacturer() {
        return this.seChipManuFacturer;
    }

    public void setSeChipManuFacturer(String str) {
        this.seChipManuFacturer = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setPayType(String str) {
        this.payType = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getAccountUserId() {
        return this.accountUserId;
    }

    public void setAccountUserId(String str) {
        this.accountUserId = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getAppletAid() {
        return this.appletAid;
    }

    public void setAppletAid(String str) {
        this.appletAid = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String getPhoneManufacturer() {
        return this.phoneManufacturer;
    }

    public void setPhoneManufacturer(String str) {
        this.phoneManufacturer = str;
    }

    public String getTrafficCardId() {
        return this.trafficCardId;
    }

    public void setTrafficCardId(String str) {
        this.trafficCardId = str;
    }

    public String getBasebandVersion() {
        return this.basebandVersion;
    }

    public void setBasebandVersion(String str) {
        this.basebandVersion = str;
    }

    public String getSystemType() {
        return this.systemType;
    }

    public void setSystemType(String str) {
        this.systemType = str;
    }

    public String getSystemVersion() {
        return this.systemVersion;
    }

    public void setSystemVersion(String str) {
        this.systemVersion = str;
    }

    public String getSeCosVersion() {
        return this.seCosVersion;
    }

    public void setSeCosVersion(String str) {
        this.seCosVersion = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }
}
