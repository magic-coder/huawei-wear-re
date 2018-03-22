package com.huawei.nfc.carrera.server.card.request;

public class QueryDicsRequset extends CardServerBaseRequest {
    public String dicName;
    public String itemName;

    public String getDicName() {
        return this.dicName;
    }

    public void setDicName(String str) {
        this.dicName = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }
}
