package com.huawei.pluginkidwatch.common.entity.model;

import java.util.Map;

public class GetWatchSettingModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public String settingType;
    public Map<String, Object> watchSettingMap;

    public String toString() {
        String str = "[settingType=" + this.settingType + "   RetCode=" + this.retCode + "  watchSettingMap=";
        if (this.watchSettingMap != null) {
            str = str + this.watchSettingMap.toString();
        }
        return str + this.retMsg + "]";
    }

    public void getWatchSettingModelName() {
    }

    public void requestWatchSettingModelHeadUrl() {
    }

    public void downloadWatchSettingModelNameUrl() {
    }

    public void judgeWatchSettingModelWeightBySomeInfo() {
    }

    public void setWatchSettingModelSwitchUpload() {
    }

    public void updataWatchSettingModelLocalTable() {
    }

    public void dealWithWatchSettingModelResetFactory() {
    }

    public void refreshWatchSettingModelInitData() {
    }

    public void queryWatchSettingModelProcessData() {
    }

    public void contrustWatchSettingModelHeadImage() {
    }

    public void changeWatchSettingModelDeviceInfo() {
    }
}
