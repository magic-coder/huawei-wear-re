package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

import com.huawei.nfc.carrera.logic.cardinfo.model.RechargeMoney;

public class ApplyOrderInfo {
    private int actualIssuePayment;
    private int actualPayment;
    private int actualRechargePayment;
    private int currencyCode;
    private boolean isBeijingAppMode;
    private String moveCode;
    private int orderType;
    private int payType;
    private String phoneNum;
    private String reserved;
    private int theoreticalIssuePayment;
    private int theoreticalPayment;
    private int theoreticalRechargePayment;

    public ApplyOrderInfo() {
        this(0, 0, 0);
    }

    public ApplyOrderInfo(int i, int i2, int i3) {
        this.isBeijingAppMode = false;
        this.orderType = i;
        this.actualPayment = i2;
        this.theoreticalPayment = i3;
    }

    public ApplyOrderInfo(int i, RechargeMoney rechargeMoney) {
        this.isBeijingAppMode = false;
        this.orderType = i;
        if (rechargeMoney != null) {
            this.actualPayment = (int) rechargeMoney.getPayMoney();
            this.theoreticalPayment = (int) rechargeMoney.getRechargeMoney();
            return;
        }
        this.actualPayment = 0;
        this.theoreticalPayment = 0;
    }

    public void setIssuePayment(int i, int i2) {
        this.actualIssuePayment = i;
        this.theoreticalIssuePayment = i2;
    }

    public void setRechargePayment(int i, int i2) {
        this.actualRechargePayment = i;
        this.theoreticalRechargePayment = i2;
    }

    public void setRechargePayment(RechargeMoney rechargeMoney) {
        if (rechargeMoney != null) {
            this.actualRechargePayment = (int) rechargeMoney.getPayMoney();
            this.theoreticalRechargePayment = (int) rechargeMoney.getRechargeMoney();
        }
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public String getReserved() {
        return this.reserved;
    }

    public void setReserved(String str) {
        this.reserved = str;
    }

    public String getMoveCode() {
        return this.moveCode;
    }

    public void setMoveCode(String str) {
        this.moveCode = str;
    }

    public int getPayType() {
        return this.payType;
    }

    public void setPayType(int i) {
        this.payType = i;
    }

    public int getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(int i) {
        this.currencyCode = i;
    }

    public int getActualIssuePayment() {
        return this.actualIssuePayment;
    }

    public void setActualIssuePayment(int i) {
        this.actualIssuePayment = i;
    }

    public int getTheoreticalIssuePayment() {
        return this.theoreticalIssuePayment;
    }

    public void setTheoreticalIssuePayment(int i) {
        this.theoreticalIssuePayment = i;
    }

    public int getTheoreticalPayment() {
        return this.theoreticalPayment;
    }

    public int getActualPayment() {
        return this.actualPayment;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setBeijingAppMode(boolean z) {
        this.isBeijingAppMode = z;
    }

    public boolean isBeijingAppMode() {
        return this.isBeijingAppMode;
    }

    public int getTheoreticalRechargePayment() {
        return this.theoreticalRechargePayment;
    }

    public void setTheoreticalRechargePayment(int i) {
        this.theoreticalRechargePayment = i;
    }

    public int getActualRechargePayment() {
        return this.actualRechargePayment;
    }

    public void setActualRechargePayment(int i) {
        this.actualRechargePayment = i;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    public void setActualPayment(int i) {
        this.actualPayment = i;
    }

    public void setTheoreticalPayment(int i) {
        this.theoreticalPayment = i;
    }
}
