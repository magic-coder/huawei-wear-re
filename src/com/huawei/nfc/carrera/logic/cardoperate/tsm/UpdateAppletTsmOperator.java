package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;

public class UpdateAppletTsmOperator extends TsmBaseOperator {
    private final String aid;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public UpdateAppletTsmOperator(Context context, String str) {
        super(context, "UpdateApplet");
        this.aid = str;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.aid);
        tsmParamQueryRequest.setIssuerId(getIssuerId());
        return ServerServiceFactory.createCardServerApi(this.mContext).queryUpdateTsmParam(tsmParamQueryRequest);
    }
}