package com.huawei.pluginkidwatch.common.entity.model;

import java.util.ArrayList;
import java.util.List;

public class SportDataIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 8490547722666991299L;
    public List<AppSportData> appSportDatas = new ArrayList();
    public String daysCount = "";
    public String daysEnd = "";
    public String deviceCode = "";

    public String toString() {
        return "  deviceCode = " + this.deviceCode + ",daysEnd = " + this.daysEnd + ",daysCount = " + this.daysCount + ",appSportDatas = " + this.appSportDatas.toString();
    }

    public void getSportModelNameBySportModel() {
    }

    public void requestSportModelHeadUrl() {
    }

    public void downloadSportModelNameUrl() {
    }

    public void judgeSportModelWeightBySomeInfo() {
    }

    public void setSportModelSwitchUpload() {
    }

    public void updataSportModelLocalTable() {
    }

    public void dealWithSportModelResetFactory() {
    }

    public void refreshSportModelInitData() {
    }

    public void querySportModelProcessData() {
    }

    public void contrustSportModelHeadImage() {
    }

    public void changeSportModelDeviceInfo() {
    }
}
