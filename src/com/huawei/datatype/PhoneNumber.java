package com.huawei.datatype;

public class PhoneNumber {
    private String phone_number;
    private String phone_tag = "Mobile";

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(String str) {
        this.phone_number = str;
    }

    public String getPhone_tag() {
        return this.phone_tag;
    }

    public void setPhone_tag(String str) {
        this.phone_tag = str;
    }

    public String toString() {
        return "[PhoneNumber: phone_tag = " + this.phone_tag + ", phone_number = " + this.phone_number + "]";
    }

    public PhoneNumber(String str, String str2) {
        this.phone_tag = str;
        this.phone_number = str2;
    }
}
