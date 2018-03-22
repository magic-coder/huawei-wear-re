package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicRescManager;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;

public class QuerySupportedTrafficCardListTask extends QuerySupportedCardListTask<SupportedTrafficCardListItem> {
    private final CardPicRescManager picManager;

    public QuerySupportedTrafficCardListTask(Context context) {
        super(context);
        this.picManager = CardPicRescManager.getInstance(context);
    }

    protected SupportedTrafficCardListItem getSupportedCard(IssuerInfoItem issuerInfoItem) {
        if (issuerInfoItem.getIssuerType() != 2) {
            return null;
        }
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(issuerInfoItem.getAid());
        return SupportedTrafficCardListItem.build(this.picManager.getCardLogo(issuerInfoItem.getIssuerId()), issuerInfoItem.getName(), cardInfoByAid != null ? cardInfoByAid.getCardStatus() : 0, issuerInfoItem.getIssuerId(), issuerInfoItem.getProductId());
    }
}
