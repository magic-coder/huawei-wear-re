package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyAidRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.card.CardServerApi;

public class InstallCiticCardPrepareTask extends InstallCardPrepareBaseTask {
    private static final String BANK_RSA_INDEX_CITIC = "CITIC";
    private final CITICService citicServiceApi;

    public InstallCiticCardPrepareTask(Context context, String str, CardServerApi cardServerApi, CITICService cITICService) {
        super(context, cardServerApi, str);
        this.citicServiceApi = cITICService;
    }

    protected ApplyAidResponse applyCardAid(ApplyAidRequest applyAidRequest) {
        return this.citicServiceApi.applyAid(applyAidRequest);
    }

    protected String getBankRsaIndex() {
        return BANK_RSA_INDEX_CITIC;
    }

    protected String getBankVerifyTokenKey() {
        return VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN;
    }
}
