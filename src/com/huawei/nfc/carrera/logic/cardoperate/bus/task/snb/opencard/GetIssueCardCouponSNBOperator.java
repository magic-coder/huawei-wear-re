package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.response.IssueCardActResponse;
import com.huawei.nfc.carrera.util.LogX;

public class GetIssueCardCouponSNBOperator {
    private Context mContext;
    private IssuerInfoItem mInfo;

    public GetIssueCardCouponSNBOperator(Context context, IssuerInfoItem issuerInfoItem) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
    }

    public TrafficActivityInfo getIssueCardCoupon() {
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.w("GetIssueCardCouponSNBOperator getIssueCardCoupon failed. card info does not exists. productId = " + productId);
            trafficActivityInfo.setReturnCd(99);
        } else {
            productId = cacheCardProductInfoItem.getSnbCardId();
            LogX.i("GetIssueCardCouponSNBOperator befor");
            IssueCardActResponse queryIssueCardCoupon = SPIServiceFactory.createSNBService(this.mContext).queryIssueCardCoupon(aid, productId);
            if (queryIssueCardCoupon.getReturnCd() != 0) {
                trafficActivityInfo.setReturnCd(SpiResultCodeTranslator.getSnbResultCode(queryIssueCardCoupon.getReturnCd()));
            } else {
                int activityFlg = queryIssueCardCoupon.getActivityFlg();
                String issueStdAmount = queryIssueCardCoupon.getIssueStdAmount();
                if (activityFlg == 0) {
                    trafficActivityInfo.setIssueActCode(String.valueOf(activityFlg));
                    trafficActivityInfo.setIssueActAmount(issueStdAmount);
                    trafficActivityInfo.setIssueStdAmount(issueStdAmount);
                    trafficActivityInfo.setReturnCd(0);
                } else if (activityFlg == 1) {
                    trafficActivityInfo.setIssueActCode(String.valueOf(activityFlg));
                    trafficActivityInfo.setIssueActAmount(queryIssueCardCoupon.getActivityAmount());
                    trafficActivityInfo.setIssueStdAmount(issueStdAmount);
                    trafficActivityInfo.setReturnCd(0);
                } else {
                    trafficActivityInfo.setReturnCd(99);
                }
            }
        }
        return trafficActivityInfo;
    }
}
