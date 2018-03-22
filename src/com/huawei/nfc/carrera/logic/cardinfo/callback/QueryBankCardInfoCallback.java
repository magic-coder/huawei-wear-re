package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;

public interface QueryBankCardInfoCallback extends BaseCallback {
    void queryBankCardInfoCallback(int i, BankCardInfo bankCardInfo);
}
