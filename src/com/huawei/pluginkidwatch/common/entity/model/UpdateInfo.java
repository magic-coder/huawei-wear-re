package com.huawei.pluginkidwatch.common.entity.model;

public class UpdateInfo {
    public int updateType;
    public String versionID;
    public String versionMd5;
    public String versionNum;
    public int versionSize;
    public String versionURL;

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public String getVersionNum() {
        return this.versionNum;
    }

    public void setVersionNum(String str) {
        this.versionNum = str;
    }

    public String getVersionMd5() {
        return this.versionMd5;
    }

    public void setVersionMd5(String str) {
        this.versionMd5 = str;
    }

    public int getVersionSize() {
        return this.versionSize;
    }

    public void setVersionSize(int i) {
        this.versionSize = i;
    }

    public String getVersionURL() {
        return this.versionURL;
    }

    public void setVersionURL(String str) {
        this.versionURL = str;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public void setVersionID(String str) {
        this.versionID = str;
    }

    public String toString() {
        return "{\"updateType\":\"" + this.updateType + "\",\"versionNum\":\"" + this.versionNum + "\",\"versionID\":\"" + this.versionID + "\",\"versionMd5\":\"" + this.versionMd5 + "\",\"versionSize\":\"" + this.versionSize + "\",\"versionURL\":\"" + this.versionURL + "\"}";
    }

    public void getUpdateInfoName() {
    }

    public void requestUpdateInfoHeadUrl() {
    }

    public void downloadUpdateInfoNameUrl() {
    }

    public void judgeUpdateInfoWeightBySomeInfo() {
    }

    public void setUpdateInfoSwitchUpload() {
    }

    public void updataUpdateInfoLocalTable() {
    }

    public void dealWithUpdateInfoResetFactory() {
    }

    public void refreshUpdateInfoInitData() {
    }

    public void queryUpdateInfoProcessData() {
    }

    public void contrustUpdateInfoHeadImage() {
    }

    public void changeUpdateInfoDeviceInfo() {
    }
}
