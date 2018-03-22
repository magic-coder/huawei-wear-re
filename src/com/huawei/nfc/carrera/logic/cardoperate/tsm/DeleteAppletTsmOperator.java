package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;

public class DeleteAppletTsmOperator extends TsmBaseOperator {
    private String bankRsaIndex;
    private final String mAid;
    private String mIssuerId;
    private String verifySign;
    private String verifyTime;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public DeleteAppletTsmOperator(Context context, String str, String str2) {
        super(context, "DeleteApplet");
        this.mAid = str;
        this.mIssuerId = str2;
    }

    public DeleteAppletTsmOperator(Context context, String str, String str2, String str3, String str4) {
        super(context, "DeleteApplet");
        this.mAid = str;
        this.verifySign = str2;
        this.verifyTime = str3;
        this.bankRsaIndex = str4;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.mAid);
        tsmParamQueryRequest.setBankSignResult(this.verifySign);
        tsmParamQueryRequest.setBankSignTime(this.verifyTime);
        tsmParamQueryRequest.setBankRsaIndex(this.bankRsaIndex);
        tsmParamQueryRequest.setIssuerId(this.mIssuerId);
        return ServerServiceFactory.createCardServerApi(this.mContext).queryDeleteAppletTsmParam(tsmParamQueryRequest);
    }
}
