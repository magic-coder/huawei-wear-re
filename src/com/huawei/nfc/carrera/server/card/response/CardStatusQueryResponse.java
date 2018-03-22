package com.huawei.nfc.carrera.server.card.response;

import java.util.List;

public class CardStatusQueryResponse extends CardServerBaseResponse {
    public static final String DEV_STATUS_LOCK = "9";
    public static final String DEV_STATUS_LOST = "2";
    public static final String DEV_STATUS_REPAIR = "4";
    private long cardCount;
    private String devStatus;
    private List<CardStatusItem> items;

    public String getDevStatus() {
        return this.devStatus;
    }

    public void setDevStatus(String str) {
        this.devStatus = str;
    }

    public long getCardCount() {
        return this.cardCount;
    }

    public void setCardCount(long j) {
        this.cardCount = j;
    }

    public List<CardStatusItem> getItems() {
        return this.items;
    }

    public void setItems(List<CardStatusItem> list) {
        this.items = list;
    }
}
