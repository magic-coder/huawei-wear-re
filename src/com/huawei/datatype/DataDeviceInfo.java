package com.huawei.datatype;

import com.huawei.p190v.C2538c;

public class DataDeviceInfo {
    private String BT_version;
    private String device_bt_mac;
    private String device_emmc_id;
    private String device_imei;
    private String device_model;
    private String device_opensource_version;
    private String device_phone_numbe;
    private String device_sn;
    private String device_soft_version;
    private int device_support_healthapp;
    private int device_type;
    private String device_version;

    public DataDeviceInfo(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.BT_version = str;
        this.device_type = i;
        this.device_version = str2;
    }

    public String getBT_version() {
        return this.BT_version;
    }

    public void setBT_version(String str) {
        this.BT_version = str;
    }

    public int getDevice_type() {
        return this.device_type;
    }

    public void setDevice_type(int i) {
        this.device_type = i;
    }

    public String getDevice_version() {
        return this.device_version;
    }

    public void setDevice_version(String str) {
        this.device_version = str;
    }

    public String getDevice_soft_version() {
        return this.device_soft_version;
    }

    public void setDevice_soft_version(String str) {
        this.device_soft_version = str;
    }

    public String getDevice_imei() {
        return this.device_imei;
    }

    public void setDevice_imei(String str) {
        this.device_imei = str;
    }

    public String getDevice_phone_numbe() {
        return this.device_phone_numbe;
    }

    public void setDevice_phone_numbe(String str) {
        this.device_phone_numbe = str;
    }

    public String getDevice_bt_mac() {
        return this.device_bt_mac;
    }

    public void setDevice_bt_mac(String str) {
        this.device_bt_mac = str;
    }

    public String getDevice_opensource_version() {
        return this.device_opensource_version;
    }

    public void setDevice_opensource_version(String str) {
        this.device_opensource_version = str;
    }

    public String getDevice_sn() {
        return this.device_sn;
    }

    public void setDevice_sn(String str) {
        this.device_sn = str;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public void setDevice_model(String str) {
        this.device_model = str;
    }

    public String getDevice_emmc_id() {
        return this.device_emmc_id;
    }

    public void setDevice_emmc_id(String str) {
        this.device_emmc_id = str;
    }

    public int getDevice_support_healthapp() {
        C2538c.c("DataDeviceInfo", new Object[]{"getDevice_support_healthapp:" + this.device_support_healthapp});
        return this.device_support_healthapp;
    }

    public void setDevice_support_healthapp(int i) {
        C2538c.c("DataDeviceInfo", new Object[]{"setDevice_support_healthapp:" + i});
        this.device_support_healthapp = i;
    }

    public String toString() {
        return "DataDeviceInfo [BT_version=" + this.BT_version + ", device_type=" + this.device_type + ", device_version=" + this.device_version + ", device_soft_version=" + this.device_soft_version + ", device_imei=" + this.device_imei + ", device_phone_numbe=" + this.device_phone_numbe + ", device_bt_mac=" + this.device_bt_mac + ", device_opensource_version=" + this.device_opensource_version + ", device_sn=" + this.device_sn + ", device_model=" + this.device_model + ", device_emmc_id=" + this.device_emmc_id + ", device_support_healthapp=" + this.device_support_healthapp + "]";
    }
}
