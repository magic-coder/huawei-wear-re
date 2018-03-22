package com.huawei.nfc.carrera.logic.cardoperate.citic.acvite;

import android.content.Context;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.ActivateCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;

public class ActiveCiticCardTask extends ActiveBaseCardTask {
    private static String CITIC_BANK_SIGN_RSA_INDEX = "CITIC";
    private CITICService citicServiceApi;

    public ActiveCiticCardTask(Context context, String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask, CITICService cITICService) {
        super(context, str, str2, handleActiveCardResultTask);
        this.citicServiceApi = cITICService;
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN);
    }

    protected void setVerifyToken(String str) {
        VerifyTokenUtil.putVerifyTokenString(str, this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN);
    }

    protected ActivateOrNullifyCardResponse requestBankActivateCard(ActivateCardRequest activateCardRequest) {
        return this.citicServiceApi.activateCard(activateCardRequest);
    }

    protected void reportCardOpenedAvailableStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    protected String getBankRsaIndex() {
        return CITIC_BANK_SIGN_RSA_INDEX;
    }
}
