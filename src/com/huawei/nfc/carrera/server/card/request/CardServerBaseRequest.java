package com.huawei.nfc.carrera.server.card.request;

import com.huawei.aj.p315a.p316a.C4022a;
import com.huawei.nfc.carrera.constant.ServiceConfig;

public class CardServerBaseRequest extends C4022a {
    public CardServerBaseRequest() {
        this.merchantID = ServiceConfig.WALLET_MERCHANT_ID;
        this.rsaKeyIndex = -1;
        this.srcTransactionID = ServiceConfig.WALLET_MERCHANT_ID;
    }

    public CardServerBaseRequest(String str, int i, String str2) {
        this.merchantID = str;
        this.rsaKeyIndex = i;
        this.srcTransactionID = str2;
    }
}
