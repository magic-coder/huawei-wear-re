package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.GetIssueCardCouponSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.QueryCityAndCardListSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.recharge.GetRechargeCouponSNBOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.logic.spi.snb.response.PayOrderResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.QueryUnfinishedOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.snb.response.RecordServerInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.TimeUtil;
import java.util.Arrays;

public class ApplyPayOrderSNBOperator {
    private static final int MAX_AMOUNT = 100000;
    private int activityFlg;
    private double issueCardCost;
    private double mAmount;
    private Context mContext;
    private IssuerInfoItem mInfo;
    private int mOrderType;
    private ApplyPayOrderResultHandler mResultHandler;

    public ApplyPayOrderSNBOperator(Context context, double d, int i, IssuerInfoItem issuerInfoItem, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        this.mContext = context;
        this.mAmount = d;
        this.mOrderType = i;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = applyPayOrderResultHandler;
    }

    public void applyPayOrder() {
        LogX.i("ApplyPayOrderSNBOperator applyPayOrder begin");
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(productId, true)) {
            LogX.w("ApplyPayOrderSNBTask applyPayOrder failed. aid or productId is illegal. aid = " + aid + " productId = " + productId);
            this.mResultHandler.handleResult(10, null);
            return;
        }
        TrafficOrder queryUnusedIssuerOrder;
        if (this.mOrderType != 2) {
            queryUnusedIssuerOrder = queryUnusedIssuerOrder(aid);
            LogX.i("applyPayOrder 123");
        } else {
            queryUnusedIssuerOrder = null;
        }
        if (queryUnusedIssuerOrder != null) {
            this.mResultHandler.handleResult(0, queryUnusedIssuerOrder);
            return;
        }
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        LogX.i("applyPayOrder 456");
        if (cacheCardProductInfoItem == null) {
            LogX.w("ApplyPayOrderSNBTask applyPayOrder failed. can not find card product info. productId = " + productId);
            this.mResultHandler.handleResult(99, null);
            return;
        }
        String queryCityAndCardList;
        int i = (this.mOrderType == 1 || this.mOrderType == 3) ? true : 0;
        if (i != 0) {
            if (!getIssueCardCoupon()) {
                return;
            }
        } else if (!getRechargeCoupon()) {
            return;
        }
        if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
            queryCityAndCardList = new QueryCityAndCardListSNBOperator(this.mContext).queryCityAndCardList(aid);
            LogX.i("ApplyPayOrderSNBOperator applyPayOrder issuerId is LNT & citycode is " + queryCityAndCardList);
        } else {
            if (StringUtil.isEmpty(cacheCardProductInfoItem.getSnbCityBusCode(), true)) {
                productId = null;
            } else {
                productId = cacheCardProductInfoItem.getSnbCityBusCode();
            }
            LogX.i("ApplyPayOrderSNBOperator applyPayOrder issuerId is not LNT & citycode is " + productId);
            queryCityAndCardList = productId;
        }
        if (StringUtil.isEmpty(queryCityAndCardList, true)) {
            this.mResultHandler.handleResult(1008, null);
            return;
        }
        TrafficOrder trafficOrder;
        PayOrderResponse payOrder = SPIServiceFactory.createSNBService(this.mContext).getPayOrder(aid, queryCityAndCardList, this.mAmount, this.mOrderType, this.issueCardCost, this.activityFlg);
        if (payOrder.getReturnCd() == 0) {
            PayInfo payInfo = payOrder.payInfo;
            payInfo.setPubKey(PayInfo.SNB_PUBLIC_KEY);
            trafficOrder = new TrafficOrder();
            trafficOrder.setPayInfo(payInfo);
        } else if (payOrder.getReturnCd() == SNBConstant.SNB_REPEAT_APPLY_ISSUERCARD_ORDER) {
            trafficOrder = new TrafficOrder();
            trafficOrder.setDuplicateApply(true);
            payOrder.setReturnCd(0);
        } else {
            trafficOrder = queryUnusedIssuerOrder;
        }
        this.mResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(payOrder.getReturnCd()), trafficOrder);
        LogX.i("ApplyPayOrderSNBOperator applyPayOrder end");
    }

    private boolean getIssueCardCoupon() {
        LogX.i("ApplyPayOrderSNBOperator getIssueCardCoupon begin");
        TrafficActivityInfo issueCardCoupon = new GetIssueCardCouponSNBOperator(this.mContext, this.mInfo).getIssueCardCoupon();
        if (issueCardCoupon.getReturnCd() != 0) {
            LogX.w("ApplyPayOrderSNBTask applyPayOrder failed. query issuer card coupon failed.");
            this.mResultHandler.handleResult(issueCardCoupon.getReturnCd(), null);
            return false;
        }
        try {
            if ("1".equals(issueCardCoupon.getIssueActCode())) {
                this.activityFlg = 1;
                this.issueCardCost = Double.parseDouble(issueCardCoupon.getIssueActAmount());
            } else {
                this.activityFlg = 0;
                this.issueCardCost = Double.parseDouble(issueCardCoupon.getIssueStdAmount());
            }
            return isLegalRechargeAmount(this.mAmount, this.issueCardCost, this.mInfo.getMinRechargeAmount());
        } catch (NumberFormatException e) {
            LogX.w("handleSpecialGetDetailBusiness exception need check the config. issueCardCost = " + issueCardCoupon.getIssueActAmount());
            this.mResultHandler.handleResult(99, null);
            return false;
        }
    }

    private boolean isLegalRechargeAmount(double d, double d2, double d3) {
        if (d3 <= 0.0d) {
            return true;
        }
        if (((100.0d * d) - (100.0d * d2)) % (100.0d * d3) == 0.0d) {
            return true;
        }
        this.mResultHandler.handleResult(1007, null);
        return false;
    }

    private boolean getRechargeCoupon() {
        TrafficActivityInfo rechargeCoupon = new GetRechargeCouponSNBOperator(this.mContext, this.mInfo).getRechargeCoupon();
        if (rechargeCoupon.getReturnCd() != 0) {
            LogX.w("ApplyPayOrderSNBTask applyPayOrder failed. query recharge coupon failed.");
            this.mResultHandler.handleResult(rechargeCoupon.getReturnCd(), null);
            return false;
        }
        double rechargeAmountByOrderAmount = getRechargeAmountByOrderAmount(this.mAmount, rechargeCoupon);
        if (rechargeAmountByOrderAmount == -1.0d) {
            this.mResultHandler.handleResult(99, null);
            return false;
        }
        String cardBalance = getCardBalance(this.mInfo.getAid());
        if (cardBalance == null) {
            return false;
        }
        try {
            double parseDouble = Double.parseDouble(cardBalance);
            rechargeAmountByOrderAmount *= 100.0d;
            if (parseDouble + rechargeAmountByOrderAmount > 100000.0d) {
                this.mResultHandler.handleResult(1001, null);
                return false;
            } else if (parseDouble + rechargeAmountByOrderAmount <= 0.0d) {
                this.mResultHandler.handleResult(1003, null);
                return false;
            } else {
                if ("1".equals(rechargeCoupon.getRechargeActCode())) {
                    this.activityFlg = 1;
                }
                this.issueCardCost = 0.0d;
                return isLegalRechargeAmount(rechargeAmountByOrderAmount / 100.0d, this.issueCardCost, this.mInfo.getMinRechargeAmount());
            }
        } catch (NumberFormatException e) {
            this.mResultHandler.handleResult(99, null);
            return false;
        }
    }

    private String getCardBalance(String str) {
        QueryCardInfoResponse queryTrafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(this.mInfo.getAid(), 6);
        if (queryTrafficCardInfo.resultCode != 0) {
            this.mResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(queryTrafficCardInfo.resultCode), null);
            return null;
        }
        if (StringUtil.isEmpty(TimeUtil.m28482a(TimeUtil.m28483a(queryTrafficCardInfo.cardInfo.getStartdate(), "yyyy-MM-dd"), "yyyy/MM/dd"), true)) {
            LogX.w("ApplyPayOrderSNBTask getCardBalance startdate is null ");
        } else {
            Boolean valueOf;
            valueOf = Boolean.valueOf(TimeUtil.m28486c(queryTrafficCardInfo.cardInfo.getStartdate(), "yyyy-MM-dd"));
            LogX.w("ApplyPayOrderSNBTask getCardBalance notEnabled : " + valueOf + ",response.cardInfo.startdate=" + queryTrafficCardInfo.cardInfo.getStartdate());
            if (valueOf.booleanValue()) {
                this.mResultHandler.handleResult(1004, null);
                return null;
            }
        }
        String a = TimeUtil.m28482a(TimeUtil.m28483a(queryTrafficCardInfo.cardInfo.getExpireDate(), "yyyy-MM-dd"), "yyyy/MM/dd");
        LogX.w("ApplyPayOrderSNBTask getCardBalance famtDate : " + a);
        if (StringUtil.isEmpty(a, true)) {
            this.mResultHandler.handleResult(1006, null);
            return null;
        }
        valueOf = Boolean.valueOf(TimeUtil.m28485b(queryTrafficCardInfo.cardInfo.getExpireDate(), "yyyy-MM-dd"));
        LogX.w("ApplyPayOrderSNBTask getCardBalance isOverdue : " + valueOf);
        if (!Constant.BJ_CARD_AID.equals(str) || valueOf.booleanValue()) {
            return queryTrafficCardInfo.cardInfo.getBalance();
        }
        this.mResultHandler.handleResult(1005, null);
        return null;
    }

    private double getRechargeAmountByOrderAmount(double d, TrafficActivityInfo trafficActivityInfo) {
        if (trafficActivityInfo.getRechargeActAmounts() == null || trafficActivityInfo.getRechargeStdAmounts() == null) {
            LogX.w("ApplyPayOrderSNBOperator applyPayOrder getRechargeAmountByOrderAmount get amounts failed. order amount : " + Arrays.toString(trafficActivityInfo.getRechargeActAmounts()) + " recharge amount : " + Arrays.toString(trafficActivityInfo.getRechargeStdAmounts()));
            return -1.0d;
        }
        int i = 0;
        double d2 = -1.0d;
        while (i < trafficActivityInfo.getRechargeActAmounts().length) {
            try {
                double parseDouble = Double.parseDouble(trafficActivityInfo.getRechargeActAmounts()[i]);
                if (Double.compare(d, parseDouble) == 0) {
                    return Double.parseDouble(trafficActivityInfo.getRechargeStdAmounts()[i]);
                }
                i++;
                d2 = parseDouble;
            } catch (NumberFormatException e) {
                LogX.w("ApplyPayOrderSNBOperator getRechargeAmountByOrderAmount parseDouble failed. order amount : " + Arrays.toString(trafficActivityInfo.getRechargeActAmounts()) + " recharge amount : " + Arrays.toString(trafficActivityInfo.getRechargeStdAmounts()));
                return -1.0d;
            }
        }
        return d2;
    }

    private TrafficOrder queryUnusedIssuerOrder(String str) {
        LogX.i("applyPayOrder 777");
        QueryUnfinishedOrdersResponse queryUnfinishedOrders = SPIServiceFactory.createSNBService(this.mContext).queryUnfinishedOrders(str);
        LogX.i("applyPayOrder 789");
        if (queryUnfinishedOrders.getReturnCd() != 0) {
            return null;
        }
        TrafficOrder trafficOrder;
        for (RecordServerInfo recordServerInfo : queryUnfinishedOrders.unfinishedOrders) {
            if ((recordServerInfo.getOrderType() == 1 || recordServerInfo.getOrderType() == 3) && (recordServerInfo.getOrderStatus() == 1006 || recordServerInfo.getOrderStatus() == 1001)) {
                PayInfo payInfo = new PayInfo();
                payInfo.setRequestId(recordServerInfo.getOrderId());
                trafficOrder = new TrafficOrder();
                trafficOrder.setHasUnusedIssueOrder(true);
                trafficOrder.setHasUnusedIssueOrder(true);
                trafficOrder.setPayInfo(payInfo);
                break;
            }
        }
        trafficOrder = null;
        LogX.i("applyPayOrder queryUnusedIssuerOrder order : " + (trafficOrder == null ? "null" : trafficOrder.getPayInfo().getRequestId()));
        return trafficOrder;
    }
}
