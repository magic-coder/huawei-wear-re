package com.huawei.pluginkidwatch.common.entity.model;

public class CommonRetOModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String data = "";
    public String deviceCode = "";
    public int type = -1;

    public void setCommonRetOModel(int i, String str, String str2) {
        this.type = i;
        this.data = str;
        this.deviceCode = str2;
    }

    public String toString() {
        return "[ type=" + this.type + "data=" + this.data + "deviceCode=" + this.deviceCode + " ]";
    }
}
