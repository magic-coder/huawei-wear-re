package com.huawei.pluginkidwatch.common.entity.model;

public class TransferPrivilegeIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public String huid = "";
    public int id = -1;
    public String type = "";

    public TransferPrivilegeIOEntityModel(String str, String str2, int i) {
        this.type = str;
        this.huid = str2;
        this.id = i;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(String str) {
        this.deviceCode = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String toString() {
        return "TransferPrivilegeIOEntityModel{deviceCode='" + this.deviceCode + '\'' + ", type='" + this.type + '\'' + ", huid='" + this.huid + '\'' + ", id=" + this.id + '}';
    }

    public void getTrsfPrlModelName() {
    }

    public void requestTrsfPrlModelHeadUrl() {
    }

    public void downloadTrsfPrlModelNameUrl() {
    }

    public void judgeTrsfPrlModelWeightBySomeInfo() {
    }

    public void setTrsfPrlModelSwitchUpload() {
    }

    public void updataTrsfPrlModelLocalTable() {
    }

    public void dealWithTrsfPrlModelResetFactory() {
    }

    public void refreshTrsfPrlModelInitData() {
    }

    public void queryTrsfPrlModelProcessData() {
    }

    public void contrustTrsfPrlModelHeadImage() {
    }

    public void changeTrsfPrlModelDeviceInfo() {
    }
}
