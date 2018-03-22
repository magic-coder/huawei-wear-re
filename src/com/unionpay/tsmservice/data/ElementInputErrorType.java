package com.unionpay.tsmservice.data;

public class ElementInputErrorType {
    private String mElementName = "";
    private String mErrorInfo = "";

    public void setErrorInfo(String str) {
        this.mErrorInfo = str;
    }

    public String getErrorInfo() {
        return this.mErrorInfo;
    }

    public void setElementName(String str) {
        this.mElementName = str;
    }

    public String getElementName() {
        return this.mElementName;
    }
}
