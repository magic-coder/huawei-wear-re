package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class LocationData implements Serializable {
    private static final long serialVersionUID = 7171949127138189397L;
    public String data1 = "";
    public String data2 = "";
    public String data3 = "";
    public String data4 = "";
    public String data5 = "";
    public double elev = 0.0d;
    public String endTime = "";
    public String extendedField = "";
    public double hacc = 0.0d;
    public double lat = 0.0d;
    public double lon = 0.0d;
    public String motionType = "";
    public String name = "";
    public String radius;
    public long time;
    public String type = "";

    public String toString() {
        return "LocationData{time=" + this.time + ", lon=" + this.lon + ", lat=" + this.lat + ", elev=" + this.elev + ", hacc=" + this.hacc + ", name='" + this.name + '\'' + ", radius='" + this.radius + '\'' + ", type='" + this.type + '\'' + ", endTime='" + this.endTime + '\'' + ", motionType='" + this.motionType + '\'' + ", extendedField='" + this.extendedField + '\'' + ", data1='" + this.data1 + '\'' + ", data2='" + this.data2 + '\'' + ", data3='" + this.data3 + '\'' + ", data4='" + this.data4 + '\'' + ", data5='" + this.data5 + '\'' + '}';
    }

    public void getWatchLocationNameByWatchLocation() {
    }

    public void requestWatchLocationHeadUrl() {
    }

    public void downloadWatchLocationNameUrl() {
    }

    public void judgeWatchLocationWeightBySomeInfo() {
    }

    public void setWatchLocationSwitchUpload() {
    }

    public void updataWatchLocationLocalTable() {
    }

    public void dealWithWatchLocationResetFactory() {
    }

    public void refreshWatchLocationInitData() {
    }

    public void queryWatchLocationProcessData() {
    }

    public void contrustWatchLocationHeadImage() {
    }

    public void changeWatchLocationDeviceInfo() {
    }
}
