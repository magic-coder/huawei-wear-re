package com.huawei.nfc.carrera.logic.cardinfo.model;

import com.huawei.nfc.util.GodClassUtil;
import java.io.Serializable;

public class IssueMoney implements Serializable {
    private static final long serialVersionUID = -1167229855519094839L;
    private double issueMoney;
    private double issueStdMoney;
    private double payMoney;
    private double rechargeMoney;

    public double getRechargeMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.rechargeMoney))).doubleValue();
    }

    public void setRechargeMoney(double d) {
        this.rechargeMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }

    public double getIssueStdMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.issueStdMoney))).doubleValue();
    }

    public void setIssueStdMoney(double d) {
        this.issueStdMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }

    public double getIssueMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.issueMoney))).doubleValue();
    }

    public void setIssueMoney(double d) {
        this.issueMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }

    public double getPayMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.payMoney))).doubleValue();
    }

    public void setPayMoney(double d) {
        this.payMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }
}
