package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1017436602236539655L;
    public String bigHeadIcon = "";
    public String bitmapStr;
    public String deviceCode = "";
    public String headIcon = "";
    public String huid = "";
    public int id = 21;
    public String nickname = "";
    public String phoneNum = "";
    public String privilege = "";
    public int sosPriority = 0;
    public String type = "0";

    public String toString() {
        return "UserInfo{deviceCode='" + this.deviceCode + '\'' + ", huid='" + this.huid + '\'' + ", nickname='" + this.nickname + '\'' + ", privilege='" + this.privilege + '\'' + ", phoneNum='" + this.phoneNum + '\'' + ", bigHeadIcon='" + this.bigHeadIcon + '\'' + ", headIcon='" + this.headIcon + '\'' + ", type='" + this.type + '\'' + ", sosPriority='" + this.sosPriority + '\'' + ", id=" + this.id + ", bitmapStr=" + this.bitmapStr + '}';
    }

    public void getUserInfoName() {
    }

    public void requestUserInfoHeadUrl() {
    }

    public void downloadUserInfoNameUrl() {
    }

    public void judgeUserInfoWeightBySomeInfo() {
    }

    public void setUserInfoSwitchUpload() {
    }

    public void updataUserInfoLocalTable() {
    }

    public void dealWithUserInfoResetFactory() {
    }

    public void refreshUserInfoInitData() {
    }

    public void queryUserInfoProcessData() {
    }

    public void contrustUserInfoHeadImage() {
    }

    public void changeUserInfoDeviceInfo() {
    }
}
