package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportNFCBankInfo;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;

public class QuerySupportedBankCardListTask extends QuerySupportedCardListTask<SupportNFCBankInfo> {
    public QuerySupportedBankCardListTask(Context context) {
        super(context);
    }

    protected SupportNFCBankInfo getSupportedCard(IssuerInfoItem issuerInfoItem) {
        if (issuerInfoItem.getIssuerType() != 1) {
            return null;
        }
        SupportNFCBankInfo supportNFCBankInfo = new SupportNFCBankInfo();
        supportNFCBankInfo.setNfcBankName(issuerInfoItem.getName());
        supportNFCBankInfo.setMode(issuerInfoItem.getMode());
        supportNFCBankInfo.setSupportCardType(issuerInfoItem.getSupportType());
        supportNFCBankInfo.setIssuerId(issuerInfoItem.getIssuerId());
        return supportNFCBankInfo;
    }
}
