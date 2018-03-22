package com.snowballtech.smartdevice;

import java.io.Serializable;

public class Device implements Serializable {
    private static final long serialVersionUID = -2616191535516930416L;
    private String device_model;
    private String device_uid;
    private String device_vendor;

    public Device(String str, String str2, String str3) {
        this.device_model = str;
        this.device_uid = str2;
        this.device_vendor = str3;
    }

    public String getDevice_model() {
        return this.device_model;
    }

    public void setDevice_model(String str) {
        this.device_model = str;
    }

    public String getDevice_uid() {
        return this.device_uid;
    }

    public void setDevice_uid(String str) {
        this.device_uid = str;
    }

    public String getDevice_vendor() {
        return this.device_vendor;
    }

    public void setDevice_vendor(String str) {
        this.device_vendor = str;
    }
}
