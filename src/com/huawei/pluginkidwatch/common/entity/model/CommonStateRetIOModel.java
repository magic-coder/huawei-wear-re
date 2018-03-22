package com.huawei.pluginkidwatch.common.entity.model;

import java.util.ArrayList;
import java.util.List;

public class CommonStateRetIOModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public CommonState commonState = new CommonState();
    public List<CommonState> commonStates = new ArrayList();
    public String data = "";

    public String toString() {
        return "CommonStateRetIOModel{commonState=" + this.commonState + ", commonStates=" + this.commonStates.toString() + '}';
    }

    public void getCommonStateRetName() {
    }

    public void requestCommonStateRetHeadUrl() {
    }

    public void downloadCommonStateRetNameUrl() {
    }

    public void judgeCommonStateRetWeightBySomeInfo() {
    }

    public void setCommonStateRetSwitchUpload() {
    }

    public void managerCommonStateRetLocalTable() {
    }

    public void dealWithCommonStateRetResetFactory() {
    }

    public void refreshCommonStateRetInitData() {
    }

    public void queryCommonStateRetProcessData() {
    }

    public void contrustCommonStateRetHeadImage() {
    }

    public void changeCommonStateRetDeviceInfo() {
    }
}
