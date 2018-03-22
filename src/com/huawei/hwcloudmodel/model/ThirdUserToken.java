package com.huawei.hwcloudmodel.model;

public class ThirdUserToken {
    private int expireTime = 0;
    private long huid = 0;
    private String thirdAccessToken = "";
    private String thirdAccount = "";
    private int thirdAccountType = 7;

    public void setHuid(long j) {
        this.huid = j;
    }

    public void setType(int i) {
        this.thirdAccountType = i;
    }

    public void setThirdAccount(String str) {
        this.thirdAccount = str;
    }

    public void setThirdAccessToken(String str) {
        this.thirdAccessToken = str;
    }

    public void setExpireTime(int i) {
        this.expireTime = i;
    }

    public String toString() {
        return "ThirdUserToken [type=" + this.thirdAccountType + ", huid = " + this.huid + ", thirdAccount = " + this.thirdAccount + ", thirdAccessToken = " + this.thirdAccessToken + ", expireTime = " + this.expireTime + "]";
    }

    public void uadpThirdUserToken1() {
    }

    public void uadpThirdUserToken2() {
    }

    public void uadpThirdUserToken3() {
    }
}
