package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OfflineTrafficCardInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficActivityInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryOfflineTrafficCardInfoResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryRecordsListResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RefundResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.GetIssueCardCouponSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.IssueTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard.PreIssueTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order.ApplyPayOrderSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.order.QueryAndHandleUnfinfishedOrdersSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.recharge.GetRechargeCouponSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.recharge.RechargeSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.records.QueryRecordsSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.refund.RefundSNBOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.uninstall.UninstallTrafficCardSNBOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.TimeUtil;

public class SNBTrafficCardOperatorImpl implements TrafficCardOperator {
    private Context mContext;

    public SNBTrafficCardOperatorImpl(Context context) {
        this.mContext = context;
    }

    public void preIssueTrafficCard(IssuerInfoItem issuerInfoItem) {
        new PreIssueTrafficCardSNBOperator(this.mContext, issuerInfoItem).preIssueTrafficCard();
    }

    public void issueTrafficCard(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        new IssueTrafficCardSNBOperator(this.mContext, issuerInfoItem, trafficOrder, issueTrafficCardResultHandler).issueTrafficCard();
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, double d, int i, int i2, String str, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        new ApplyPayOrderSNBOperator(this.mContext, d, i, issuerInfoItem, applyPayOrderResultHandler).applyPayOrder();
    }

    public void uninstallTrafficCard(IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        new UninstallTrafficCardSNBOperator(this.mContext, issuerInfoItem, uninstallTrafficCardResultHandler).uninstall();
    }

    public void recharge(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        new RechargeSNBOperator(this.mContext, issuerInfoItem, trafficOrder, rechargeResultHandler).recharge();
    }

    public void queryAndHandleUnfinfishedOrders(IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        new QueryAndHandleUnfinfishedOrdersSNBOperator(this.mContext, issuerInfoItem, i, queryAndHandleUnfinishedOrderResultHandler).queryAndHandleUnfinishedOrders();
    }

    public void queryRecords(IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        LogX.i("queryRecords  enter,item=" + issuerInfoItem);
        new QueryRecordsSNBOperator(this.mContext, issuerInfoItem, i, queryRecordsListResultHandler).queryRecords();
    }

    public void refund(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler) {
        new RefundSNBOperator(this.mContext, issuerInfoItem, trafficOrder, refundResultHandler).refund();
    }

    public TrafficActivityInfo getIssueCardCoupon(String str, IssuerInfoItem issuerInfoItem) {
        return new GetIssueCardCouponSNBOperator(this.mContext, issuerInfoItem).getIssueCardCoupon();
    }

    public TrafficActivityInfo getRechargeCoupon(IssuerInfoItem issuerInfoItem) {
        return new GetRechargeCouponSNBOperator(this.mContext, issuerInfoItem).getRechargeCoupon();
    }

    public void queryOfflineCardInfo(IssuerInfoItem issuerInfoItem, int i, QueryOfflineTrafficCardInfoResultHandler queryOfflineTrafficCardInfoResultHandler) {
        int i2;
        String aid = issuerInfoItem.getAid();
        if ((i & 1) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            i2 |= 4;
        }
        QueryCardInfoResponse queryTrafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(aid, i2);
        if (queryTrafficCardInfo.resultCode != 0) {
            queryOfflineTrafficCardInfoResultHandler.handleResult(SpiResultCodeTranslator.getSnbResultCode(queryTrafficCardInfo.resultCode), null);
            return;
        }
        OfflineTrafficCardInfo offlineTrafficCardInfo = new OfflineTrafficCardInfo();
        offlineTrafficCardInfo.setCardNo(queryTrafficCardInfo.cardInfo.getCardNo());
        if (!StringUtil.isEmpty(queryTrafficCardInfo.cardInfo.getBalance(), true)) {
            offlineTrafficCardInfo.setBalance(MoneyUtil.convertFenToYuan(queryTrafficCardInfo.cardInfo.getBalance()));
        }
        if (!StringUtil.isEmpty(queryTrafficCardInfo.cardInfo.getExpireDate(), true)) {
            offlineTrafficCardInfo.setExpireDate(TimeUtil.m28482a(TimeUtil.m28483a(queryTrafficCardInfo.cardInfo.getExpireDate(), "yyyy-MM-dd"), "yyyy/MM/dd"));
        }
        if (!StringUtil.isEmpty(queryTrafficCardInfo.cardInfo.getStartdate(), true)) {
            offlineTrafficCardInfo.setStartdate(TimeUtil.m28482a(TimeUtil.m28483a(queryTrafficCardInfo.cardInfo.getStartdate(), "yyyy-MM-dd"), "yyyy/MM/dd"));
        }
        queryOfflineTrafficCardInfoResultHandler.handleResult(0, offlineTrafficCardInfo);
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
    }
}
