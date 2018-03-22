package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

public class TrafficActivityInfo {
    private String issueActAmount;
    private String issueActCode;
    private String issueStdAmount;
    private String productCode;
    private String[] rechargeActAmounts;
    private String rechargeActCode;
    private String[] rechargeStdAmounts;
    private int returnCd;

    public String getIssueActCode() {
        return this.issueActCode;
    }

    public void setIssueActCode(String str) {
        this.issueActCode = str;
    }

    public String getIssueActAmount() {
        return this.issueActAmount;
    }

    public void setIssueActAmount(String str) {
        this.issueActAmount = str;
    }

    public String getIssueStdAmount() {
        return this.issueStdAmount;
    }

    public void setIssueStdAmount(String str) {
        this.issueStdAmount = str;
    }

    public String getRechargeActCode() {
        return this.rechargeActCode;
    }

    public void setRechargeActCode(String str) {
        this.rechargeActCode = str;
    }

    public String[] getRechargeStdAmounts() {
        return this.rechargeStdAmounts;
    }

    public void setRechargeStdAmounts(String[] strArr) {
        this.rechargeStdAmounts = strArr;
    }

    public String[] getRechargeActAmounts() {
        return this.rechargeActAmounts;
    }

    public void setRechargeActAmounts(String[] strArr) {
        this.rechargeActAmounts = strArr;
    }

    public int getReturnCd() {
        return this.returnCd;
    }

    public void setReturnCd(int i) {
        this.returnCd = i;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }
}
