package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class UnbindDeviceIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = -314043462585550476L;
    public String deviceCode = "";
    public int id = -1;
    public String userId = "";

    public UnbindDeviceIOEntityModel(String str, String str2, int i) {
        this.userId = str;
        this.deviceCode = str2;
        this.id = i;
    }

    public String toString() {
        return "UnbindDeviceIOEntityModel{userId='" + this.userId + '\'' + ", deviceCode='" + this.deviceCode + '\'' + ", id=" + this.id + '}';
    }

    public void getUnbindModelName() {
    }

    public void requestUnbindModelHeadUrl() {
    }

    public void downloadUnbindModelNameUrl() {
    }

    public void judgeUnbindModelWeightBySomeInfo() {
    }

    public void setUnbindModelSwitchUpload() {
    }

    public void updataUnbindModelLocalTable() {
    }

    public void dealWithUnbindModelResetFactory() {
    }

    public void refreshUnbindModelInitData() {
    }

    public void queryUnbindModelProcessData() {
    }

    public void contrustUnbindModelHeadImage() {
    }

    public void changeUnbindModelDeviceInfo() {
    }

    public String getDeviceCode() {
        return (String) C1489i.m6887a(this.deviceCode);
    }

    public void setDeviceCode(String str) {
        this.deviceCode = (String) C1489i.m6887a(str);
    }
}
