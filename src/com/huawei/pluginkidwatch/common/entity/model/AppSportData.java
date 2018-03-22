package com.huawei.pluginkidwatch.common.entity.model;

import java.util.ArrayList;
import java.util.List;

public class AppSportData extends BaseEntityModel {
    private static final long serialVersionUID = 6767879875099455399L;
    public String logDate = "";
    public List<WatchSportData> sportDatas = new ArrayList();
    public String totalCalories = "";
    public String totalSteps = "";

    public String toString() {
        return "  logDate = " + this.logDate + ",totalSteps = " + this.totalSteps + ",totalCalories = " + this.totalCalories + ",sportDatas = " + this.sportDatas.toString();
    }

    public void getAppSportDataName() {
    }

    public void requestAppSportDataHeadUrl() {
    }

    public void downloadAppSportDataNameUrl() {
    }

    public void judgeAppSportDataWeightBySomeInfo() {
    }

    public void setAppSportDataSwitchUpload() {
    }

    public void updataAppSportDataLocalTable() {
    }

    public void dealWithAppSportDataResetFactory() {
    }

    public void refreshAppSportDataInitData() {
    }

    public void queryAppSportDataProcessData() {
    }

    public void contrustAppSportDataHeadImage() {
    }

    public void changeAppSportDataDeviceInfo() {
    }
}
