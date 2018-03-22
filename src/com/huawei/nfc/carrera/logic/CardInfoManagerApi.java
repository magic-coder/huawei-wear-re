package com.huawei.nfc.carrera.logic;

import android.graphics.Bitmap;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryPayableCardCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportBankInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportedTrafficCardListCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SetCardDefaultCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.UpdateCardTimeStampCallback;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import java.util.List;

public interface CardInfoManagerApi {
    public static final int SPECIAL_TRAFFIC_BUSINESS_NONE_CODE = 0;
    public static final int SPECIAL_TRAFFIC_BUSINESS_OPENCARD_ADN_RECHARGE_CODE = 3;
    public static final int SPECIAL_TRAFFIC_BUSINESS_OPENCARD_CODE = 1;
    public static final int SPECIAL_TRAFFIC_BUSINESS_RECHARGE_CODE = 2;
    public static final int UNSUPPORTED_MODE = -1;

    int checkAvaiableCard();

    Bitmap getCardIcon(String str, int i);

    void queryBankCardInfo(String str, QueryBankCardInfoCallback queryBankCardInfoCallback);

    void queryBankIssuerInfo(String str, QueryBankIssuerInfoCallback queryBankIssuerInfoCallback);

    void queryPayableCardInfos(QueryPayableCardCallback queryPayableCardCallback);

    void querySupportNFCBankInfos(QuerySupportBankInfoCallback querySupportBankInfoCallback);

    void querySupportedTrafficCardList(QuerySupportedTrafficCardListCallback querySupportedTrafficCardListCallback);

    void queryTrafficCardInfo(String str, int i, String str2, QueryTrafficCardInfoCallback queryTrafficCardInfoCallback);

    void refreshCardList();

    void registerCardListListener(CardListInfoListener cardListInfoListener);

    void setCardDefault(String str, SetCardDefaultCallback setCardDefaultCallback);

    void setRefreshRF(boolean z);

    void syncRFConfFiles(boolean z);

    void unregisterCardListListener(CardListInfoListener cardListInfoListener);

    void updateCardOrder(int i, int i2, List<UniCardInfo> list);

    void updateTACardTimeStamp(String str, UpdateCardTimeStampCallback updateCardTimeStampCallback, long j);
}
