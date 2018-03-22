package com.huawei.nfc.carrera.server.card.request;

public class ServerAccessApplyOrderRequest extends ServerAccessBaseRequest {
    public static final String CURRENCY_CNY = "CNY";
    public static final String SCENE_OPEN_CARD = "0";
    public static final String SCENE_OPEN_CARD_AND_RECHARGE = "2";
    public static final String SCENE_RECHARGE = "1";
    private String actualIssuePayment = null;
    private String actualRecharegePayment = null;
    private String currency = "CNY";
    private String scene = null;
    private String theoreticalIssuePayment = null;
    private String theoreticalRecharegePayment = null;

    public ServerAccessApplyOrderRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        setIssuerId(str);
        setCplc(str2);
        setAppletAid(str3);
        setDeviceModel(str5);
        setSeChipManuFacturer(str6);
        this.scene = str4;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public String getActualIssuePayment() {
        return this.actualIssuePayment;
    }

    public void setActualIssuePayment(String str) {
        this.actualIssuePayment = str;
    }

    public String getTheoreticalIssuePayment() {
        return this.theoreticalIssuePayment;
    }

    public void setTheoreticalIssuePayment(String str) {
        this.theoreticalIssuePayment = str;
    }

    public String getActualRecharegePayment() {
        return this.actualRecharegePayment;
    }

    public void setActualRecharegePayment(String str) {
        this.actualRecharegePayment = str;
    }

    public String getTheoreticalRecharegePayment() {
        return this.theoreticalRecharegePayment;
    }

    public void setTheoreticalRecharegePayment(String str) {
        this.theoreticalRecharegePayment = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }
}
