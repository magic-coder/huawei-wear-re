package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;
import com.huawei.nfc.openapi.HwNFCOpenApi;

public class CreateOrDeleteOpenSSDTsmOperator extends TsmBaseOperator {
    private final String mAid;
    private final String mOperatorType;
    private final String mSign;
    private final String mSpID;
    private final String mTimeStamp;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public CreateOrDeleteOpenSSDTsmOperator(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context, "CreateOrDeleteOpenSSD");
        this.mAid = str;
        this.mSign = str3;
        this.mSpID = str2;
        this.mTimeStamp = str4;
        this.mOperatorType = str5;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.mAid);
        tsmParamQueryRequest.setBankSignResult(this.mSign);
        tsmParamQueryRequest.setBankSignTime(this.mTimeStamp);
        tsmParamQueryRequest.setBankRsaIndex(this.mSpID);
        tsmParamQueryRequest.setSignType("RSA256");
        if (HwNFCOpenApi.OPERATOR_TYPE_CREATE_SSD.equals(this.mOperatorType)) {
            return ServerServiceFactory.createCardServerApi(this.mContext).queryCreateSSDTsmParam(tsmParamQueryRequest);
        }
        if (HwNFCOpenApi.OPERATOR_TYPE_DELETE_SSD.equals(this.mOperatorType)) {
            return ServerServiceFactory.createCardServerApi(this.mContext).queryDeleteSSDTsmParam(tsmParamQueryRequest);
        }
        return null;
    }
}
