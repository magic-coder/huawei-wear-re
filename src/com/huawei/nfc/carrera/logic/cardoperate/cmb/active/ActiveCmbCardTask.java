package com.huawei.nfc.carrera.logic.cardoperate.cmb.active;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.ActiveBaseCardTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.acvite.HandleActiveCardResultTask;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.request.ActivateCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;

public class ActiveCmbCardTask extends ActiveBaseCardTask {
    private static String CMB_BANK_SIGN_RSA_INDEX = "CMB";
    private CMBService cmbServiceApi;

    public ActiveCmbCardTask(Context context, String str, String str2, HandleActiveCardResultTask handleActiveCardResultTask, CMBService cMBService) {
        super(context, str, str2, handleActiveCardResultTask);
        this.cmbServiceApi = cMBService;
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN);
    }

    protected void setVerifyToken(String str) {
        VerifyTokenUtil.putVerifyTokenString(str, this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN);
    }

    protected ActivateOrNullifyCardResponse requestBankActivateCard(ActivateCardRequest activateCardRequest) {
        return this.cmbServiceApi.activateCard(activateCardRequest);
    }

    protected void reportCardOpenedAvailableStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, tACardInfo.dpanDigest, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    protected String getBankRsaIndex() {
        return CMB_BANK_SIGN_RSA_INDEX;
    }
}
