package com.snowballtech.business.bean;

import java.io.Serializable;

public class CardcouponData implements Serializable {
    private String activity_amount;
    private String activity_desc;
    private String activity_flag;
    private String card_id;
    private String card_switch_status;
    private String charge_amount;
    private String charge_desc;
    private String recharge_amount;
    private String recharge_desc;
    private String sp_id;

    public String getSp_id() {
        return this.sp_id;
    }

    public void setSp_id(String str) {
        this.sp_id = str;
    }

    public String getCard_id() {
        return this.card_id;
    }

    public void setCard_id(String str) {
        this.card_id = str;
    }

    public String getCharge_desc() {
        return this.charge_desc;
    }

    public void setCharge_desc(String str) {
        this.charge_desc = str;
    }

    public String getCharge_amount() {
        return this.charge_amount;
    }

    public void setCharge_amount(String str) {
        this.charge_amount = str;
    }

    public String getActivity_desc() {
        return this.activity_desc;
    }

    public void setActivity_desc(String str) {
        this.activity_desc = str;
    }

    public String getCard_switch_status() {
        return this.card_switch_status;
    }

    public void setCard_switch_status(String str) {
        this.card_switch_status = str;
    }

    public String getActivity_flag() {
        return this.activity_flag;
    }

    public void setActivity_flag(String str) {
        this.activity_flag = str;
    }

    public String getActivity_amount() {
        return this.activity_amount;
    }

    public void setActivity_amount(String str) {
        this.activity_amount = str;
    }

    public String getRecharge_amount() {
        return this.recharge_amount;
    }

    public void setRecharge_amount(String str) {
        this.recharge_amount = str;
    }

    public String getRecharge_desc() {
        return this.recharge_desc;
    }

    public void setRecharge_desc(String str) {
        this.recharge_desc = str;
    }
}
