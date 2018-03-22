package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.refund;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RefundResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.util.StringUtil;

public class RefundSNBOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;
    private TrafficOrder mOrder;
    private RefundResultHandler mResultHandler;

    public RefundSNBOperator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler) {
        this.mContext = context;
        this.mOrder = trafficOrder;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = refundResultHandler;
    }

    public void refund() {
        String aid = this.mInfo.getAid();
        String requestId = this.mOrder.getPayInfo().getRequestId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(requestId, true)) {
            this.mResultHandler.handleResult(10);
            return;
        }
        this.mResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(SPIServiceFactory.createSNBService(this.mContext).refund(aid, this.mOrder.getPayInfo().getRequestId())));
    }
}
