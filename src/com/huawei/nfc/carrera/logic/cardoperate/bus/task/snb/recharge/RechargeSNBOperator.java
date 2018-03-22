package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.recharge;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class RechargeSNBOperator {
    private static final String TAG = "RechargeSNBOperator";
    private Context mContext;
    private IssuerInfoItem mInfo;
    private TrafficOrder mOrder;
    private RechargeResultHandler mResultHandler;

    public RechargeSNBOperator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mOrder = trafficOrder;
        this.mResultHandler = rechargeResultHandler;
    }

    public void recharge() {
        String requestId = this.mOrder.getPayInfo().getRequestId();
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(requestId, true) || StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(productId, true)) {
            LogX.w("RechargeSNBOperator recharge failed. param is illegal. orderid = " + requestId + " aid = " + aid + " productId = " + productId);
            this.mResultHandler.handleResult(10);
            return;
        }
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.w("RechargeSNBOperator recharge failed. product info does not exist. productId = " + productId);
            this.mResultHandler.handleResult(99);
            return;
        }
        Map hashMap = new HashMap();
        if (!StringUtil.isEmpty(cacheCardProductInfoItem.getSnbCityBusCode(), true)) {
            hashMap.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
        }
        C2538c.b(TAG, new Object[]{" CardEvent RECHARGE bus cardEvent START_LOCK"});
        WalletTaManager.getInstance(this.mContext).cardEvent(aid, 2);
        RechargeResponse recharge = SPIServiceFactory.createSNBService(this.mContext).recharge(aid, requestId, hashMap);
        LogX.i("RechargeSNBOperator recharge resultCode : " + recharge.getReturnCd() + " orderId : " + requestId);
        int snbResultCode = SpiResultCodeTranslator.getSnbResultCode(recharge.getReturnCd());
        C2538c.b(TAG, new Object[]{" CardEvent RECHARGE bus cardEvent END_LOCK"});
        WalletTaManager.getInstance(this.mContext).cardEvent(aid, 3);
        this.mResultHandler.handleResult(snbResultCode);
    }
}
