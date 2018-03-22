package com.huawei.nfc.carrera.logic.cardoperate.tsm;

import android.content.Context;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.TsmParamQueryRequest;
import com.huawei.nfc.carrera.server.card.response.TsmParamQueryResponse;

public class DeleteSSDTsmOperator extends TsmBaseOperator {
    private final String aid;
    private boolean deleteRelatedObjects = false;
    private String issuerId;

    public /* bridge */ /* synthetic */ int excute() {
        return super.excute();
    }

    public /* bridge */ /* synthetic */ String getIssuerId() {
        return super.getIssuerId();
    }

    public /* bridge */ /* synthetic */ void setIssuerId(String str) {
        super.setIssuerId(str);
    }

    public DeleteSSDTsmOperator(Context context, String str) {
        super(context, "DeleteSSD");
        this.aid = str;
    }

    public DeleteSSDTsmOperator(Context context, String str, String str2, boolean z) {
        super(context, "DeleteSSD");
        this.aid = str;
        this.deleteRelatedObjects = z;
        this.issuerId = str2;
    }

    TsmParamQueryResponse queryOperateParams(TsmParamQueryRequest tsmParamQueryRequest) {
        tsmParamQueryRequest.setAid(this.aid);
        tsmParamQueryRequest.setIssuerId(this.issuerId);
        tsmParamQueryRequest.setDeleteRelatedObjects(this.deleteRelatedObjects);
        return ServerServiceFactory.createCardServerApi(this.mContext).queryDeleteSSDTsmParam(tsmParamQueryRequest);
    }
}
