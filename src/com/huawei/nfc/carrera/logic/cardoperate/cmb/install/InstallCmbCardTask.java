package com.huawei.nfc.carrera.logic.cardoperate.cmb.install;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCardBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCardPrepareBaseTask;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.PersonalizedRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.PersonalizedResponse;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class InstallCmbCardTask extends InstallCardBaseTask {
    private final CMBService cmbServiceApi;
    private String dpanid;
    private String productId;

    public InstallCmbCardTask(Context context, CardServerApi cardServerApi, CMBService cMBService, String str, InstallCardPrepareBaseTask installCardPrepareBaseTask) {
        super(context, str, installCardPrepareBaseTask);
        this.cmbServiceApi = cMBService;
    }

    protected boolean isNeedGetVerifySign() {
        return true;
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN;
    }

    protected boolean checkInputInfoValid(OpenCardInfo openCardInfo) {
        if (openCardInfo == null) {
            LogX.e("checkInputInfoValid, null input info.");
            return false;
        } else if (!StringUtil.isEmpty(openCardInfo.getCardNum(), true) && !StringUtil.isEmpty(openCardInfo.getIssuerId(), true)) {
            return true;
        } else {
            LogX.e("checkInputInfoValid, input info not fits cmb.");
            return false;
        }
    }

    protected void fillInApplyCardInfo(ApplyCardRequest applyCardRequest, OpenCardInfo openCardInfo) {
        applyCardRequest.setCardType(openCardInfo.getCardType());
        if (2 == openCardInfo.getCardType()) {
            applyCardRequest.setPasscode(openCardInfo.getPwd());
        } else if (3 == openCardInfo.getCardType()) {
            applyCardRequest.setIdNum(openCardInfo.getIdNum());
            applyCardRequest.setValidDate(openCardInfo.getDate());
            applyCardRequest.setCvv2Code(openCardInfo.getCvv2());
        } else {
            LogX.e("fillInApplyCardInfo, cardtype invalid.");
        }
    }

    protected ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest) {
        return this.cmbServiceApi.applyCard(applyCardRequest);
    }

    protected PersonalizedResponse personalize(PersonalizedRequest personalizedRequest) {
        PersonalizedResponse personalizeCard = this.cmbServiceApi.personalizeCard(personalizedRequest);
        this.dpanid = personalizeCard.dpanid;
        this.productId = personalizeCard.productId;
        return personalizeCard;
    }

    protected String getProductId() {
        return this.productId;
    }

    protected String getCardDpan(Context context, String str) {
        return ESEApiFactory.createESEInfoManagerApi(context).queryCardNum(str);
    }

    protected String getDpanid(String str) {
        return this.dpanid;
    }
}
