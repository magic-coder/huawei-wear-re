package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class HeartRateInfo {
    private int hr_info;
    private int hri_info;
    private int hrsqi_info;
    private long time_info;

    public int getHr_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hr_info))).intValue();
    }

    public void setHr_info(int i) {
        this.hr_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getHrri_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hri_info))).intValue();
    }

    public void setHrri_info(int i) {
        this.hri_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getHrsqi_info() {
        return ((Integer) C0978h.a(Integer.valueOf(this.hrsqi_info))).intValue();
    }

    public void setHrsqi_info(int i) {
        this.hrsqi_info = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTime_info() {
        return ((Long) C0978h.a(Long.valueOf(this.time_info))).longValue();
    }

    public void setTime_info(long j) {
        this.time_info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void getHeartRateNameByHeartRate() {
    }

    public void requestHeartRateHeadUrl() {
    }

    public void downloadHeartRateNameUrl() {
    }

    public void judgeHeartRateWeightBySomeInfo() {
    }

    public void setHeartRateSwitchUpload() {
    }

    public void updataHeartRateLocalTable() {
    }

    public void dealWithHeartRateResetFactory() {
    }

    public void refreshHeartRateInitData() {
    }

    public void queryHeartRateProcessData() {
    }

    public void contrustHeartRateHeadImage() {
    }

    public void changeHeartRateDeviceInfo() {
    }
}
