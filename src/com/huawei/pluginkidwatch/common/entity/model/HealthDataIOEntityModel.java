package com.huawei.pluginkidwatch.common.entity.model;

import java.util.ArrayList;
import java.util.List;

public class HealthDataIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 8490547722666991299L;
    public String daysCount = "";
    public String daysEnd = "";
    public String deviceCode = "";
    public List<HealthData> healthData = new ArrayList();

    public String toString() {
        return "  deviceCode = " + this.deviceCode + ",daysEnd = " + this.daysEnd + ",daysCount = " + this.daysCount + ",healthData = " + this.healthData.toString();
    }

    public void getHealthDataModelName() {
    }

    public void requestHealthDataModelHeadUrl() {
    }

    public void downloadHealthDataModelNameUrl() {
    }

    public void judgeHealthDataModelWeightBySomeInfo() {
    }

    public void setHealthDataModelSwitchUpload() {
    }

    public void updataHealthDataModelLocalTable() {
    }

    public void dealWithHealthDataModelResetFactory() {
    }

    public void refreshHealthDataModelInitData() {
    }

    public void queryHealthDataModelProcessData() {
    }

    public void contrustHealthDataModelHeadImage() {
    }

    public void changeHealthDataModelDeviceInfo() {
    }
}
