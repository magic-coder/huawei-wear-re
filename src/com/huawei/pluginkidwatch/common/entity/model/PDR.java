package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class PDR implements Serializable {
    private static final long serialVersionUID = 6556963510436392628L;
    private int f3398d;
    private long time;
    private int f3399x;
    private int f3400y;
    private int f3401z;

    public long getTime() {
        return this.time;
    }

    public void setPDRData(long j, int i, int i2, int i3, int i4) {
        this.time = j;
        this.f3399x = i;
        this.f3400y = i2;
        this.f3401z = i3;
        this.f3398d = i4;
    }

    public int getLocationX() {
        return this.f3399x;
    }

    public int getLocationY() {
        return this.f3400y;
    }

    public int getLocationZ() {
        return this.f3401z;
    }

    public int getCurrentDirection() {
        return this.f3398d;
    }

    public String toString() {
        return "  time = " + this.time + "  location_x = " + this.f3399x + "  location_y = " + this.f3400y + "  location_z = " + this.f3401z + "  current_direction = " + this.f3398d;
    }

    public void getPDRName() {
    }

    public void requestPDRHeadUrl() {
    }

    public void downloadPDRNameUrl() {
    }

    public void judgePDRWeightBySomeInfo() {
    }

    public void setPDRSwitchUpload() {
    }

    public void updataPDRLocalTable() {
    }

    public void dealWithPDRResetFactory() {
    }

    public void refreshPDRInitData() {
    }

    public void queryPDRProcessData() {
    }

    public void contrustPDRHeadImage() {
    }

    public void changePDRDeviceInfo() {
    }
}
