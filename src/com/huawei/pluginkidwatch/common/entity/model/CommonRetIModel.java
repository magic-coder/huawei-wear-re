package com.huawei.pluginkidwatch.common.entity.model;

public class CommonRetIModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String data;

    public String toString() {
        return "[RetCode=" + this.retCode + "  retMsg=" + this.retMsg + "]";
    }
}
