package com.huawei.pluginkidwatch.common.entity.model;

public class ValidateCodeIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 7792862515411955231L;
    public String phoneNum = "";

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public String toString() {
        return "  phoneNum = " + this.phoneNum;
    }
}
