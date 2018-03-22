package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import java.util.List;

public interface SyncInfosFromServerCallback extends BaseCallback {
    void syncCardProductInfosFromServerResult(List<CardProductInfoItem> list);

    void syncIssuerInfosFromServerResult(List<IssuerInfoItem> list);
}
