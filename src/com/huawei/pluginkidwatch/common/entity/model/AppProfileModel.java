package com.huawei.pluginkidwatch.common.entity.model;

import java.util.Map;

public class AppProfileModel extends BaseEntityModel {
    private static final long serialVersionUID = -6524523292434891852L;
    public Map<String, Integer> appAbilityMap;
    public String appVersion = "";
    public String phoneManufacturer = "";
    public String phoneModel = "";

    public String toString() {
        return "AppProfileModel{appVersion='" + this.appVersion + '\'' + ", phoneManufacturer='" + this.phoneManufacturer + '\'' + ", phoneModel='" + this.phoneModel + '\'' + ", appAbilityMap=" + this.appAbilityMap + '}';
    }

    public void getProfileModelName() {
    }

    public void requestProfileModelHeadUrl() {
    }

    public void downloadProfileModelNameUrl() {
    }

    public void judgeProfileModelWeightBySomeInfo() {
    }

    public void setProfileModelSwitchUpload() {
    }

    public void updataProfileModelLocalTable() {
    }

    public void dealWithProfileModelResetFactory() {
    }

    public void refreshProfileModelInitData() {
    }

    public void queryProfileModelProcessData() {
    }

    public void contrustProfileModelHeadImage() {
    }

    public void changeProfileModelDeviceInfo() {
    }
}
