package com.huawei.pluginkidwatch.common.entity.model;

public class SetAccompanyUserIEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public int deviceCode;
    public int operation;

    public String toString() {
        return "deviceCode = " + this.deviceCode + " operation = " + this.operation;
    }
}
