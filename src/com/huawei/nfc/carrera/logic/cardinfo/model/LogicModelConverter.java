package com.huawei.nfc.carrera.logic.cardinfo.model;

import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.wallet.model.unicard.UniCardInfo;

public class LogicModelConverter {
    public static CardListItem convertFromTACardInfo(TACardInfo tACardInfo) {
        CardListItem cardListItem = new CardListItem();
        cardListItem.setDefault(tACardInfo.isDefaultCard);
        cardListItem.setAid(tACardInfo.aid);
        cardListItem.setReferenceId(tACardInfo.dpanDigest);
        cardListItem.setProductId(tACardInfo.productId);
        cardListItem.setFpanFour(tACardInfo.fpanFour);
        cardListItem.setStatusUpdateTime(tACardInfo.statusUpdateTime);
        cardListItem.setCardGroup(tACardInfo.cardGroupType);
        return cardListItem;
    }

    public static UniCardInfo convertToUniCardInfo(TACardInfo tACardInfo) {
        UniCardInfo uniCardInfo = new UniCardInfo();
        uniCardInfo.m28106a(tACardInfo.isDefaultCard);
        uniCardInfo.m28105a(tACardInfo.aid);
        uniCardInfo.m28118f(tACardInfo.issuerId);
        uniCardInfo.m28109b(tACardInfo.dpanDigest);
        uniCardInfo.m28112c(tACardInfo.productId);
        uniCardInfo.m28103a(tACardInfo.cardStatus);
        uniCardInfo.m28104a(tACardInfo.statusUpdateTime);
        uniCardInfo.m28108b(tACardInfo.cardGroupType);
        uniCardInfo.m28111c(tACardInfo.cardGroupType);
        return uniCardInfo;
    }
}
