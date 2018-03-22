package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class CallLog implements Serializable {
    private static final long serialVersionUID = 1327435226377505930L;
    public int duration;
    public int number;
    public String phoneNum;
    public long time;
    public int type;

    public CallLog() {
        this.time = 0;
        this.phoneNum = "";
        this.duration = 0;
        this.type = 0;
        this.number = 0;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public String toString() {
        return "CallLog [time=" + this.time + ", phoneNum=" + this.phoneNum + ", duration=" + this.duration + ", type=" + this.type + ", number=" + this.number + "]";
    }

    public CallLog(long j, String str, int i, int i2, int i3) {
        this.time = j;
        this.phoneNum = str;
        this.duration = i;
        this.type = i2;
        this.number = i3;
    }

    public void setCallLogTimePhoneType(long j, String str, int i) {
        this.time = j;
        this.phoneNum = str;
        this.type = i;
    }

    public int getCallLogTimeByType() {
        if (this.type == 0) {
            return this.duration;
        }
        return 1;
    }

    public void getCallPhoneName() {
    }

    public void requestCallPhoneHeadUrl() {
    }

    public void downloadCallPhoneNameUrl() {
    }

    public void judgeCallPhoneWeightBySomeInfo() {
    }

    public void setCallPhoneSwitchUpload() {
    }

    public void updataCallPhoneLocalTable() {
    }

    public void dealWithCallPhoneResetFactory() {
    }

    public void refreshCallPhoneInitData() {
    }

    public void queryCallPhoneProcessData() {
    }

    public void contrustCallPhoneHeadImage() {
    }

    public void changeCallPhoneDeviceInfo() {
    }
}
