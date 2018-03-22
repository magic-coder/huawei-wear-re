package com.huawei.hwcommonservice.model;

public class WearableDeviceInfo {
    public static final int DEVICE_CONNECTED = 2;
    public static final int DEVICE_CONNECTING = 1;
    public static final int DEVICE_DISCONNECTED = 3;
    private int mBatteryLevel;
    private int mConnectionStatus;
    private String mDeviceID;
    private int mDeviceType;

    public int getConnectionStatus() {
        return this.mConnectionStatus;
    }

    public void setConnectionStatus(int i) {
        this.mConnectionStatus = i;
    }

    public int getBatteryLevel() {
        return this.mBatteryLevel;
    }

    public void setBatteryLevel(int i) {
        this.mBatteryLevel = i;
    }

    public String getDeviceID() {
        return this.mDeviceID;
    }

    public void setDeviceID(String str) {
        this.mDeviceID = str;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(int i) {
        this.mDeviceType = i;
    }

    public String toJsonString() {
        return "TODO";
    }

    public void procWearDeviceInfo1() {
    }

    public void procWearDeviceInfo2() {
    }

    public void procWearDeviceInfo3() {
    }

    public void procWearDeviceInfo4() {
    }

    public void procWearDeviceInfo5() {
    }
}
