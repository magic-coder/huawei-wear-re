package com.huawei.nfc.carrera.logic.cardinfo.impl;

import com.huawei.wallet.model.unicard.UniCardInfo;
import java.io.Serializable;
import java.util.Comparator;

class UniCardInfoComparator implements Serializable, Comparator<UniCardInfo> {
    private static final long serialVersionUID = 371071030106236423L;

    UniCardInfoComparator() {
    }

    public int compare(UniCardInfo uniCardInfo, UniCardInfo uniCardInfo2) {
        if (uniCardInfo.m28125l() < uniCardInfo2.m28125l()) {
            return 1;
        }
        return uniCardInfo.m28125l() > uniCardInfo2.m28125l() ? -1 : 0;
    }
}
