package com.huawei.pluginkidwatch.common.entity.model;

public class CommonStateOModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "";
    public String type = "";

    public String toString() {
        return "CommonStateOModel [deviceCode=" + this.deviceCode + ", type=" + this.type + "]";
    }
}
