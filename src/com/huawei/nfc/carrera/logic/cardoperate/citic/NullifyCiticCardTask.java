package com.huawei.nfc.carrera.logic.cardoperate.citic;

import android.content.Context;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class NullifyCiticCardTask extends NullifyCardBaseTask {
    private static String CITIC_BANK_SIGN_RSA_INDEX = "CITIC";
    private CITICService citicServiceApi;

    NullifyCiticCardTask(Context context, CardServerApi cardServerApi, CITICService cITICService, String str, String str2, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        super(context, str, str2, handleNullifyCardResultTask);
        this.citicServiceApi = cITICService;
    }

    protected String getBankSignRsaIndex() {
        return CITIC_BANK_SIGN_RSA_INDEX;
    }

    protected boolean checkInputInfoValid(String str, String str2) {
        if (!StringUtil.isEmpty(str, true) && !StringUtil.isEmpty(str2, true)) {
            return true;
        }
        LogX.e("checkInputInfoValid, input info not fits citic.");
        return false;
    }

    protected boolean isNeedGetVerifySign() {
        return StringUtil.isEmpty(getVerifyToken(), true);
    }

    protected ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest) {
        return this.citicServiceApi.nullifyCard(nullifyCardRequest);
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN;
    }

    protected void reportCardDeletedStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(tACardInfo.aid, null);
    }
}
