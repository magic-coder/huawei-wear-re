package com.huawei.pluginkidwatch.common.entity.model;

public class WatchStatusIOModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode;
    public String type;
    public WatchStatus watchStatus = new WatchStatus();

    public void setWatchStatusIOModel(WatchStatus watchStatus, String str) {
        this.watchStatus = watchStatus;
        this.deviceCode = str;
    }

    public String toString() {
        return "WatchStatusIOModel{watchStatus=" + this.watchStatus + ", deviceCode='" + this.deviceCode + '\'' + ", type='" + this.type + '\'' + '}';
    }
}
