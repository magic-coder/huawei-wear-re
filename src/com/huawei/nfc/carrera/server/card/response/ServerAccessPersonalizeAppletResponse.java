package com.huawei.nfc.carrera.server.card.response;

public class ServerAccessPersonalizeAppletResponse extends ServerAccessBaseResponse {
    private String cardId;

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }
}
