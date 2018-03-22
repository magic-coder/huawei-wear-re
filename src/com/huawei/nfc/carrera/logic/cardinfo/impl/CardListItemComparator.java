package com.huawei.nfc.carrera.logic.cardinfo.impl;

import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import java.io.Serializable;
import java.util.Comparator;

class CardListItemComparator implements Serializable, Comparator<CardListItem> {
    private static final long serialVersionUID = 371071030106236423L;

    CardListItemComparator() {
    }

    public int compare(CardListItem cardListItem, CardListItem cardListItem2) {
        if (cardListItem.getStatusUpdateTime() < cardListItem2.getStatusUpdateTime()) {
            return 1;
        }
        return cardListItem.getStatusUpdateTime() > cardListItem2.getStatusUpdateTime() ? -1 : 0;
    }
}
