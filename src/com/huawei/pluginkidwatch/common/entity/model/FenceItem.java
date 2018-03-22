package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class FenceItem {
    private String mFenceAddress = "";
    private String mFenceId;
    private int mFenceIndex;
    private String mFenceName;
    private int mFenceRadius;
    private boolean mIsOn = false;
    private boolean mIsSelected = false;
    private boolean mIsShowCheck = false;
    private double mLat = 0.0d;
    private double mLon = 0.0d;

    public FenceItem(int i, String str, int i2, String str2, String str3, boolean z, boolean z2, boolean z3, double d, double d2) {
        this.mFenceIndex = i;
        this.mFenceId = str;
        this.mFenceRadius = i2;
        this.mFenceAddress = str3;
        this.mFenceName = str2;
        this.mIsShowCheck = z;
        this.mIsSelected = z2;
        this.mIsOn = z3;
        this.mLat = d2;
        this.mLon = d;
    }

    public FenceItem(int i, boolean z, boolean z2, boolean z3, double d, double d2) {
        this.mFenceIndex = i;
        this.mFenceId = "fenceId";
        this.mFenceRadius = 10;
        this.mFenceAddress = "content";
        this.mFenceName = "name";
        this.mIsShowCheck = z;
        this.mIsSelected = z2;
        this.mIsOn = z3;
        this.mLat = d2;
        this.mLon = d;
    }

    public void useFenceIdAdd() {
        if (this.mFenceIndex > 3) {
            this.mFenceId = this.mFenceName;
        } else {
            this.mFenceName = this.mFenceId;
        }
    }

    public boolean judgeFenceOpen() {
        if (this.mLat > 0.0d || this.mLon > 0.0d) {
            return true;
        }
        return false;
    }

    public String fenceNameBySelect() {
        String str = "";
        if (this.mIsSelected) {
            return this.mFenceAddress;
        }
        return this.mFenceName;
    }

    public void getFenceItemName() {
    }

    public void requestFenceItemHeadUrl() {
    }

    public void downloadFenceItemNameUrl() {
    }

    public void judgeFenceItemWeightBySomeInfo() {
    }

    public void setFenceItemSwitchUpload() {
    }

    public void updataFenceItemLocalTable() {
    }

    public void dealWithFenceItemResetFactory() {
    }

    public void refreshFenceItemInitData() {
    }

    public void queryFenceItemProcessData() {
    }

    public void contrustFenceItemHeadImage() {
    }

    public void changeFenceItemDeviceInfo() {
    }

    public int getmFenceIndex() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.mFenceIndex))).intValue();
    }

    public void setmFenceIndex(int i) {
        this.mFenceIndex = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public String getmFenceId() {
        return (String) C1489i.m6887a(this.mFenceId);
    }

    public void setmFenceId(String str) {
        this.mFenceId = (String) C1489i.m6887a(str);
    }

    public int getmFenceRadius() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.mFenceRadius))).intValue();
    }

    public void setmFenceRadius(int i) {
        this.mFenceRadius = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public String getmFenceName() {
        return (String) C1489i.m6887a(this.mFenceName);
    }

    public void setmFenceName(String str) {
        this.mFenceName = (String) C1489i.m6887a(str);
    }

    public String getmFenceAddress() {
        return this.mFenceAddress;
    }

    public void setmFenceAddress(String str) {
        this.mFenceAddress = (String) C1489i.m6887a(str);
    }

    public boolean ismIsShowCheck() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(this.mIsShowCheck))).booleanValue();
    }

    public void setmIsShowCheck(boolean z) {
        this.mIsShowCheck = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean ismIsSelected() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(this.mIsSelected))).booleanValue();
    }

    public void setmIsSelected(boolean z) {
        this.mIsSelected = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean ismIsOn() {
        return this.mIsOn;
    }

    public void setmIsOn(boolean z) {
        this.mIsOn = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public double getLat() {
        return ((Double) C1489i.m6887a(Double.valueOf(this.mLat))).doubleValue();
    }

    public void setLat(double d) {
        this.mLat = ((Double) C1489i.m6887a(Double.valueOf(d))).doubleValue();
    }

    public double getLon() {
        return ((Double) C1489i.m6887a(Double.valueOf(this.mLon))).doubleValue();
    }

    public void setLon(double d) {
        this.mLon = ((Double) C1489i.m6887a(Double.valueOf(d))).doubleValue();
    }
}
