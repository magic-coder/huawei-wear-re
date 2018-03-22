package com.huawei.nfc.carrera.logic.cardoperate.cmb;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.citic.HandleNullifyCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.NullifyCardBaseTask;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class NullifyCmbCardTask extends NullifyCardBaseTask {
    private static String CMB_BANK_SIGN_RSA_INDEX = "CMB";
    private CMBService cmbServiceApi;

    NullifyCmbCardTask(Context context, CardServerApi cardServerApi, CMBService cMBService, String str, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        super(context, str, null, handleNullifyCardResultTask);
        this.cmbServiceApi = cMBService;
    }

    protected String getBankSignRsaIndex() {
        return CMB_BANK_SIGN_RSA_INDEX;
    }

    protected boolean checkInputInfoValid(String str, String str2) {
        if (!StringUtil.isEmpty(str, true)) {
            return true;
        }
        LogX.e("checkInputInfoValid, input info not fits citic.");
        return false;
    }

    protected boolean isNeedGetVerifySign() {
        return true;
    }

    protected ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest) {
        return this.cmbServiceApi.nullifyCard(nullifyCardRequest);
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN;
    }

    protected void reportCardDeletedStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(tACardInfo.aid, tACardInfo.dpanDigest);
    }
}
