package com.huawei.pluginkidwatch.common.entity.model;

public class RelationIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public int deviceCode = -1;
    public String nickName = "";
    public String str = "";

    public void setRelationInfo(int i, String str) {
        this.deviceCode = i;
        this.nickName = str;
    }

    public String toString() {
        return "  deviceCode = " + this.deviceCode + "  nickName = " + this.nickName + "  errorCode = " + this.retCode + "  str = " + this.str;
    }
}
