package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;

public interface QueryBankIssuerInfoCallback extends BaseCallback {
    void queryBankIssuerInfoCallback(int i, BankIssuerInfo bankIssuerInfo);
}
