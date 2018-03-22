package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.recharge;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.response.RechargeActResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;

public class GetRechargeCouponSNBOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;

    public GetRechargeCouponSNBOperator(Context context, IssuerInfoItem issuerInfoItem) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
    }

    public TrafficActivityInfo getRechargeCoupon() {
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.w("GetRechargeCouponSNBOperator getRechargeCoupon failed. card info does not exists. productId = " + productId);
            trafficActivityInfo.setReturnCd(99);
        } else {
            RechargeActResponse queryRechargeCoupon = SPIServiceFactory.createSNBService(this.mContext).queryRechargeCoupon(aid, cacheCardProductInfoItem.getSnbCardId());
            if (queryRechargeCoupon.getReturnCd() != 0) {
                trafficActivityInfo.setReturnCd(SpiResultCodeTranslator.getSnbResultCode(queryRechargeCoupon.getReturnCd()));
            } else {
                int activityFlg = queryRechargeCoupon.getActivityFlg();
                if (activityFlg == 0) {
                    trafficActivityInfo.setRechargeActCode(String.valueOf(activityFlg));
                    if (!StringUtil.isEmpty(queryRechargeCoupon.getRechargeStdAmount(), true)) {
                        trafficActivityInfo.setRechargeStdAmounts(queryRechargeCoupon.getRechargeStdAmount().split(","));
                    }
                    trafficActivityInfo.setRechargeActAmounts(trafficActivityInfo.getRechargeStdAmounts());
                    trafficActivityInfo.setReturnCd(0);
                } else if (activityFlg == 1) {
                    trafficActivityInfo.setRechargeActCode(String.valueOf(activityFlg));
                    if (!StringUtil.isEmpty(queryRechargeCoupon.getRechargeStdAmount(), true)) {
                        trafficActivityInfo.setRechargeStdAmounts(queryRechargeCoupon.getRechargeStdAmount().split(","));
                    }
                    if (!StringUtil.isEmpty(queryRechargeCoupon.getActivityAmount(), true)) {
                        trafficActivityInfo.setRechargeActAmounts(queryRechargeCoupon.getActivityAmount().split(","));
                    }
                    trafficActivityInfo.setReturnCd(0);
                } else {
                    trafficActivityInfo.setReturnCd(99);
                }
            }
        }
        return trafficActivityInfo;
    }
}
