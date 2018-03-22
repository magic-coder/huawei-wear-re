package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;
import com.huawei.nfc.openapi.HwNFCOpenApi;

public class SynESETsmOperator extends TsmBaseOperator {
    private String aid;
    private String mIssuerId;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public SynESETsmOperator(Context context, String str, String str2) {
        super(context, HwNFCOpenApi.OPERATOR_TYPE_SYNC_ESE);
        this.aid = str;
        this.mIssuerId = str2;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.aid);
        tsmParamQueryRequest.setIssuerId(this.mIssuerId);
        return ServerServiceFactory.createCardServerApi(this.mContext).queryInfoSynTsmParam(tsmParamQueryRequest);
    }
}
