package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

public class OrderHandleResultInfo {
    private int issueCardOrderCnt;
    private int rechargeOrderCnt;
    private int refundOrderCnt;
    private int totalOrderCnt;

    public OrderHandleResultInfo(int i, int i2, int i3, int i4) {
        this.totalOrderCnt = i;
        this.rechargeOrderCnt = i2;
        this.issueCardOrderCnt = i3;
        this.refundOrderCnt = i4;
    }

    public int getTotalOrderCnt() {
        return this.totalOrderCnt;
    }

    public void setTotalOrderCnt(int i) {
        this.totalOrderCnt = i;
    }

    public int getRechargeOrderCnt() {
        return this.rechargeOrderCnt;
    }

    public void setRechargeOrderCnt(int i) {
        this.rechargeOrderCnt = i;
    }

    public int getIssueCardOrderCnt() {
        return this.issueCardOrderCnt;
    }

    public void setIssueCardOrderCnt(int i) {
        this.issueCardOrderCnt = i;
    }

    public int getRefundOrderCnt() {
        return this.refundOrderCnt;
    }

    public void setRefundOrderCnt(int i) {
        this.refundOrderCnt = i;
    }

    public String toString() {
        return "OrderHandleResultInfo [totalOrderCnt=" + this.totalOrderCnt + ", rechargeOrderCnt=" + this.rechargeOrderCnt + ", issueCardOrderCnt=" + this.issueCardOrderCnt + ", refundOrderCnt=" + this.refundOrderCnt + "]";
    }
}
