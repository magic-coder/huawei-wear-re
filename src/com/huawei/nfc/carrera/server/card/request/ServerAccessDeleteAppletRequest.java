package com.huawei.nfc.carrera.server.card.request;

public class ServerAccessDeleteAppletRequest extends ServerAccessBaseRequest {
    public static final String REASON_LOST_CARD = "";
    public static final String REASON_OPEN_CARD_FAIL = "";
    public static final String REASON_REPAIRE_CARD = "";
    private String reason = null;
    private String refundTicketId = null;

    public ServerAccessDeleteAppletRequest(String str, String str2, String str3, String str4, String str5) {
        setIssuerId(str);
        setCplc(str2);
        setAppletAid(str3);
        setDeviceModel(str4);
        setSeChipManuFacturer(str5);
    }

    public String getRefundTicketId() {
        return this.refundTicketId;
    }

    public void setRefundTicketId(String str) {
        this.refundTicketId = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }
}
