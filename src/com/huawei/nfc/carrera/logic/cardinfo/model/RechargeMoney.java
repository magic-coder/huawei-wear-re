package com.huawei.nfc.carrera.logic.cardinfo.model;

import com.huawei.nfc.util.GodClassUtil;

public class RechargeMoney {
    private double payMoney;
    private double rechargeMoney;

    public String getStringForRechargeMoney() {
        return (String) GodClassUtil.commonFunc(String.valueOf((int) this.rechargeMoney));
    }

    public double getRechargeMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.rechargeMoney))).doubleValue();
    }

    public void setRechargeMoney(double d) {
        this.rechargeMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }

    public double getPayMoney() {
        return ((Double) GodClassUtil.commonFunc(Double.valueOf(this.payMoney))).doubleValue();
    }

    public void setPayMoney(double d) {
        this.payMoney = ((Double) GodClassUtil.commonFunc(Double.valueOf(d))).doubleValue();
    }
}
