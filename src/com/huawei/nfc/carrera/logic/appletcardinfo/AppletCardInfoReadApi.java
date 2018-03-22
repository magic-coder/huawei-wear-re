package com.huawei.nfc.carrera.logic.appletcardinfo;

import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.TransactionRecord;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.List;

public interface AppletCardInfoReadApi {
    public static final int READ_CARD_BALANCE = 2;
    public static final int READ_CARD_NUM = 1;
    public static final int READ_CARD_VALIDITY_DATE = 4;

    AppletCardResult<CardInfo> readTrafficCardInfo(String str, String str2, int i);

    AppletCardResult<List<TransactionRecord>> readTrafficCardTransactionRecord(String str, String str2);
}
