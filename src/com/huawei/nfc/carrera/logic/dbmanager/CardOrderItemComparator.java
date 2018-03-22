package com.huawei.nfc.carrera.logic.dbmanager;

import java.io.Serializable;
import java.util.Comparator;

class CardOrderItemComparator implements Serializable, Comparator<CardOrderInfoItem> {
    private static final long serialVersionUID = 37107103010623644L;

    CardOrderItemComparator() {
    }

    public int compare(CardOrderInfoItem cardOrderInfoItem, CardOrderInfoItem cardOrderInfoItem2) {
        if (cardOrderInfoItem.getTimestamp() < cardOrderInfoItem2.getTimestamp()) {
            return 1;
        }
        return cardOrderInfoItem.getTimestamp() > cardOrderInfoItem2.getTimestamp() ? -1 : 0;
    }
}
