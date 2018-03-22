package com.huawei.nfc.carrera.logic.cardinfo.impl;

import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import java.io.Serializable;
import java.util.Comparator;

class IssuerInfoComparator implements Serializable, Comparator<IssuerInfoItem> {
    private static final long serialVersionUID = 3710710301062363L;

    IssuerInfoComparator() {
    }

    public int compare(IssuerInfoItem issuerInfoItem, IssuerInfoItem issuerInfoItem2) {
        if (issuerInfoItem.getSn() > issuerInfoItem2.getSn()) {
            return 1;
        }
        return issuerInfoItem.getSn() < issuerInfoItem2.getSn() ? -1 : 0;
    }
}
