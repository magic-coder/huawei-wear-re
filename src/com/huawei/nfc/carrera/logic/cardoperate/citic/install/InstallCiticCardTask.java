package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.PersonalizedRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.PersonalizedResponse;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.SHA_256;

public class InstallCiticCardTask extends InstallCardBaseTask {
    private static final String PRODUCT_ID_CITIC = "*_63020000_01";
    private CITICService citicServiceApi;
    private String dPan;

    public InstallCiticCardTask(Context context, CardServerApi cardServerApi, CITICService cITICService, String str, InstallCardPrepareBaseTask installCardPrepareBaseTask) {
        super(context, str, installCardPrepareBaseTask);
        this.citicServiceApi = cITICService;
    }

    protected boolean checkInputInfoValid(OpenCardInfo openCardInfo) {
        if (openCardInfo == null) {
            LogX.e("checkInputInfoValid, null input info.");
            return false;
        } else if (!StringUtil.isEmpty(openCardInfo.getCardNum(), true) && !StringUtil.isEmpty(openCardInfo.getIssuerId(), true) && !StringUtil.isEmpty(openCardInfo.getCvv2(), true)) {
            return true;
        } else {
            LogX.e("checkInputInfoValid, input info not fits citic.");
            return false;
        }
    }

    protected boolean isNeedGetVerifySign() {
        return StringUtil.isEmpty(getVerifyToken(), true);
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN;
    }

    protected void fillInApplyCardInfo(ApplyCardRequest applyCardRequest, OpenCardInfo openCardInfo) {
        applyCardRequest.setCvv2Code(openCardInfo.getCvv2());
    }

    protected ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest) {
        ApplyCardResponse applyCard = this.citicServiceApi.applyCard(applyCardRequest);
        this.dPan = applyCard.dPan;
        return applyCard;
    }

    protected PersonalizedResponse personalize(PersonalizedRequest personalizedRequest) {
        return this.citicServiceApi.personalizeCard(personalizedRequest);
    }

    protected String getProductId() {
        return "*_63020000_01";
    }

    protected String getCardDpan(Context context, String str) {
        return this.dPan;
    }

    protected String getDpanid(String str) {
        return SHA_256.m28475a(str, null);
    }
}
