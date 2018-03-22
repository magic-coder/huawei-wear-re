package com.huawei.nfc.carrera.logic.cardinfo.callback;

import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import java.util.List;

public interface QueryPayableCardCallback {
    public static final int ACCOUNT_LOGIN_STATUS_ACCOUNT_UNMATCH = 2;
    public static final int ACCOUNT_LOGIN_STATUS_NOT_LOGIN = 1;
    public static final int REFRESH_CARD_LIST_FAILED_ACCOUNT_ERROR = -2;

    void queryPayableCardCallback(List<CardListItem> list);

    void queryPayableError(int i);
}
