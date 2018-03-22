package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public abstract class BaseEntityModel implements Serializable {
    private static final long serialVersionUID = -2788623292434891852L;
    public String error = "";
    public String interfaceName = "";
    public int retCode = -1;
    public String retMsg = "";

    public void getBaseModelNameByBaseModel() {
    }

    public void requestBaseModelHeadUrl() {
    }

    public void downloadBaseModelNameUrl() {
    }

    public void judgeBaseModelWeightBySomeInfo() {
    }

    public void setBaseModelSwitchUpload() {
    }

    public void updataBaseModelLocalTable() {
    }

    public void dealWithBaseModelResetFactory() {
    }

    public void refreshBaseModelInitData() {
    }

    public void queryBaseModelProcessData() {
    }

    public void contrustBaseModelHeadImage() {
    }

    public void changeBaseModelDeviceInfo() {
    }
}
