package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class WatchStatus implements Serializable {
    private static final long serialVersionUID = -7317830822332061255L;
    public String acompanyDeviceUser = "";
    public Banlance banlance = new Banlance();
    public String battery = "";
    public int deviceCode = -1;
    public LocationData lastLocation = new LocationData();
    public String locaingMode = "";
    public String schoolMode = "";
    public String version = "";
    public int wearState = 0;

    public String toString() {
        return "WatchStatus{deviceCode=" + this.deviceCode + ", lastLocation=" + this.lastLocation + ", battery='" + this.battery + '\'' + ", acompanyDeviceUser='" + this.acompanyDeviceUser + '\'' + ", schoolMode='" + this.schoolMode + '\'' + ", locaingMode='" + this.locaingMode + '\'' + ", banlance=" + this.banlance + ", version='" + this.version + '\'' + ", wearState=" + this.wearState + '}';
    }

    public void getWatchStatusName() {
    }

    public void requestWatchStatusHeadUrl() {
    }

    public void downloadWatchStatusNameUrl() {
    }

    public void judgeWatchStatusWeightBySomeInfo() {
    }

    public void setWatchStatusSwitchUpload() {
    }

    public void updataWatchStatusLocalTable() {
    }

    public void dealWithWatchStatusResetFactory() {
    }

    public void refreshWatchStatusInitData() {
    }

    public void queryWatchStatusProcessData() {
    }

    public void contrustWatchStatusHeadImage() {
    }

    public void changeWatchStatusDeviceInfo() {
    }
}
