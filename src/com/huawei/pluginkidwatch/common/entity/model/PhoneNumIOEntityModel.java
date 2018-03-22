package com.huawei.pluginkidwatch.common.entity.model;

public class PhoneNumIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 3381989301585026394L;
    public String phoneNum = "";
    public String securityCode = "";
    public int type = -1;

    public void setPhoneNumValue(String str, String str2) {
        this.phoneNum = str;
        this.securityCode = str2;
    }

    public String toString() {
        return "PhoneNumIOEntityModel [phoneNum=" + this.phoneNum + ", securityCode=" + this.securityCode + ", type=" + this.type + "]";
    }
}
