package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;

public class UnlockAppletTsmOperator extends TsmBaseOperator {
    private final String mAid;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public UnlockAppletTsmOperator(Context context, String str) {
        super(context, "UnlockApplet");
        this.mAid = str;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.mAid);
        return ServerServiceFactory.createCardServerApi(this.mContext).queryUnockAppletTsmParam(tsmParamQueryRequest);
    }
}
