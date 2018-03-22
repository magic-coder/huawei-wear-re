package com.huawei.hwcloudmodel.model;

public class CloudCommonReponse {
    private int resultCode;
    private String resultDesc;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }

    public String toString() {
        return "CloudCommonReponse{resultCode=" + this.resultCode + ", resultDesc='" + this.resultDesc + '\'' + '}';
    }
}
