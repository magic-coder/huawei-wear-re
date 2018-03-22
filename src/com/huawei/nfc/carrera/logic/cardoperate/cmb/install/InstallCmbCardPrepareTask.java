package com.huawei.nfc.carrera.logic.cardoperate.cmb.install;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.InstallCardPrepareBaseTask;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyAidRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;

public class InstallCmbCardPrepareTask extends InstallCardPrepareBaseTask {
    private static final String BANK_RSA_INDEX_CMB = "CMB";
    private CMBService cmbServiceApi;

    public InstallCmbCardPrepareTask(Context context, String str, CardServerApi cardServerApi, CMBService cMBService) {
        super(context, cardServerApi, str);
        this.cmbServiceApi = cMBService;
    }

    protected ApplyAidResponse applyCardAid(ApplyAidRequest applyAidRequest) {
        return this.cmbServiceApi.applyAid(applyAidRequest);
    }

    protected String getBankRsaIndex() {
        return BANK_RSA_INDEX_CMB;
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN;
    }
}
