package com.huawei.nfc.carrera.server.card.request;

public class ServerAccessQueryOrderRequest extends ServerAccessBaseRequest {
    public static final String ORDER_STATUS_ABNOMAL = "1";
    public static final String ORDER_STATUS_NOMAL = "0";
    private String orderStatus = null;

    public ServerAccessQueryOrderRequest(String str, String str2, String str3, String str4, String str5) {
        setIssuerId(str);
        setCplc(str2);
        setAppletAid(str3);
        setDeviceModel(str4);
        setSeChipManuFacturer(str5);
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }
}
