package com.huawei.nfc.carrera.logic.cardinfo.listener;

import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;

public interface CardEventListener {
    public static final int CARD_CLICK_BACKGROUND = 1;
    public static final int CARD_CLICK_DEFAULTCARD = 2;
    public static final int CARD_CLICK_DETAIL = 0;

    void onCardClick(CardListItem cardListItem, int i);
}
