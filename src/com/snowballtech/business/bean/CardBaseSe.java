package com.snowballtech.business.bean;

public class CardBaseSe {
    public static final String ACTIVATION_STATUS = "activation_status";
    public static final String INSTALL_STATUS = "install_status";
    public static final String INSTANCE_ID = "instance_id";
    private static final long serialVersionUID = 1;
    private String activation_status;
    private String balance;
    private String card_number;
    private String install_status;
    private String instance_id;
    private String logiccardtype;
    private String region_id;
    private String startdate;
    private String total_monthly_amount;
    private String validity;

    public String getTotal_monthly_amount() {
        return this.total_monthly_amount;
    }

    public void setTotal_monthly_amount(String str) {
        this.total_monthly_amount = str;
    }

    public String getInstance_id() {
        return this.instance_id;
    }

    public void setInstance_id(String str) {
        this.instance_id = str;
    }

    public String getInstall_status() {
        return this.install_status;
    }

    public void setInstall_status(String str) {
        this.install_status = str;
    }

    public String getActivation_status() {
        return this.activation_status;
    }

    public void setActivation_status(String str) {
        this.activation_status = str;
    }

    public String getCard_number() {
        return this.card_number;
    }

    public void setCard_number(String str) {
        this.card_number = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String str) {
        this.validity = str;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String str) {
        this.startdate = str;
    }

    public String getLogicCardType() {
        return this.logiccardtype;
    }

    public void setLogicCardType(String str) {
        this.logiccardtype = str;
    }

    public String getRegion_id() {
        return this.region_id;
    }

    public void setRegion_id(String str) {
        this.region_id = str;
    }
}
