package com.huawei.crowdtestsdk.devices;

import com.huawei.uploadlog.p188c.C2514j;
import java.io.Serializable;

public class DeviceHelper implements Serializable {
    private String deviceId = "unknown";
    private String prodConnType;
    private int prodSpecificCode;
    private String prodSpecificName;
    private int prodType;
    private String productName;
    private String versionName = "unknown";

    public DeviceHelper(int i) {
        this.prodType = i;
    }

    public DeviceHelper(int i, String str, int i2, String str2) {
        this.prodType = i;
        this.prodConnType = str;
        this.prodSpecificCode = i2;
        this.prodSpecificName = str2;
    }

    public static DeviceHelper getUnknownDeviceHelper() {
        return new DeviceHelper(C2514j.m12526d(), "unknown", -1, "unknown");
    }

    public int getProdType() {
        return this.prodType;
    }

    public void setProdType(int i) {
        this.prodType = i;
    }

    public String getProdConnType() {
        return this.prodConnType;
    }

    public void setProdConnType(String str) {
        this.prodConnType = str;
    }

    public int getProdSpecificCode() {
        return this.prodSpecificCode;
    }

    public void setProdSpecificCode(int i) {
        this.prodSpecificCode = i;
    }

    public String getProdSpecificName() {
        return this.prodSpecificName;
    }

    public void setProdSpecificName(String str) {
        this.prodSpecificName = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String toString() {
        return String.format("prodType, prodConnType, prodSpecificCode, prodSpecificName, productName,versionName,deviceId : %d,%s,%d,%s,%s,%s,%s", new Object[]{Integer.valueOf(this.prodType), this.prodConnType, Integer.valueOf(this.prodSpecificCode), this.prodSpecificName, this.productName, this.versionName, this.deviceId});
    }
}
