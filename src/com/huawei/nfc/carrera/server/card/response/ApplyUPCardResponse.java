package com.huawei.nfc.carrera.server.card.response;

import com.huawei.nfc.carrera.server.card.model.CardMetadata;
import com.huawei.nfc.carrera.server.card.model.VirtualCardMetadata;

public class ApplyUPCardResponse extends CardServerBaseResponse {
    public static final int ERR_ACCOUNT_INFO_INVALID = 3609;
    public static final int ERR_ACCOUNT_IN_BLACK_LIST = 3611;
    public static final int ERR_ACCOUNT_UNEXIST = 3604;
    public static final int ERR_ALREADY_ASSOCIATED_CARD = 1317;
    public static final int ERR_ALREADY_ASSOCIATED_CARD2 = 3317;
    public static final int ERR_APPLY_EXCEED_LIMIT1 = 1309;
    public static final int ERR_APPLY_EXCEED_LIMIT2 = 3603;
    public static final int ERR_APPLY_EXCEED_LIMIT3 = 3605;
    public static final int ERR_APPLY_EXCEED_LIMIT4 = 3309;
    public static final int ERR_BANK_SYSTEM_ERR = 3102;
    public static final int ERR_INFORMATION_CHECK_FAILED = 3601;
    public static final int ERR_INFORMATION_CHECK_FAILED2 = 3602;
    public static final int ERR_NO_APPLICATION_PERMISSION = 3608;
    public static final int ERR_NO_PHONE = 3610;
    public static final int ERR_ON_RISK = 1901;
    public CardMetadata cardMetadata;
    public VirtualCardMetadata virtualCardMetadata;
}
