package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
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
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard.GetIssueCardCouponFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard.IssueTrafficCardFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard.PreIssueTrafficCardFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.order.ApplyPayOrderFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.order.QueryAndHandleUnfinfishedOrdersFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.recharge.RechargeFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.records.QueryRecordsFMOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.uninstall.UninstallTrafficCardFMOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.MoneyUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.wallet.utils.TimeUtil;
import java.util.HashMap;
import java.util.Map;

public class FMTrafficCardOperatorImpl implements TrafficCardOperator {
    private final Context mContext;

    public FMTrafficCardOperatorImpl(Context context) {
        this.mContext = context;
    }

    public void preIssueTrafficCard(IssuerInfoItem issuerInfoItem) {
        LogX.i("FMTrafficCardOperatorImpl, preIssueTrafficCard begin");
        new PreIssueTrafficCardFMOperator(this.mContext, issuerInfoItem).preIssueTrafficCard();
    }

    public void issueTrafficCard(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, issueTrafficCard begin");
        new IssueTrafficCardFMOperator(this.mContext, issuerInfoItem, trafficOrder, issueTrafficCardResultHandler).issueTrafficCard();
    }

    public void uninstallTrafficCard(IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, uninstallTrafficCard begin");
        new UninstallTrafficCardFMOperator(this.mContext, issuerInfoItem, uninstallTrafficCardResultHandler).uninstall();
    }

    public void recharge(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, recharge begin");
        new RechargeFMOperator(this.mContext, trafficOrder, rechargeResultHandler, issuerInfoItem.getAid()).recharge();
    }

    public void queryAndHandleUnfinfishedOrders(IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, queryAndHandleUnfinfishedOrders begin");
        new QueryAndHandleUnfinfishedOrdersFMOperator(this.mContext, issuerInfoItem, i, queryAndHandleUnfinishedOrderResultHandler).queryAndHandleUnfinishedOrders();
    }

    public void queryRecords(IssuerInfoItem issuerInfoItem, int i, QueryRecordsListResultHandler queryRecordsListResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, queryRecords begin");
        new QueryRecordsFMOperator(this.mContext, i, queryRecordsListResultHandler, issuerInfoItem.getAid()).queryRecords();
    }

    public void refund(IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RefundResultHandler refundResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, refund begin");
    }

    public TrafficActivityInfo getIssueCardCoupon(String str, IssuerInfoItem issuerInfoItem) {
        LogX.i("FMTrafficCardOperatorImpl, getIssueCardCoupon begin");
        if (Constant.LNT_CARD_AID.equals(issuerInfoItem.getAid())) {
            return new GetIssueCardCouponFMOperator(this.mContext, str, issuerInfoItem).getIssueCardCoupon();
        }
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        trafficActivityInfo.setReturnCd(1);
        return trafficActivityInfo;
    }

    public TrafficActivityInfo getRechargeCoupon(IssuerInfoItem issuerInfoItem) {
        LogX.i("FMTrafficCardOperatorImpl, getRechargeCoupon begin");
        TrafficActivityInfo trafficActivityInfo = new TrafficActivityInfo();
        trafficActivityInfo.setReturnCd(1);
        return trafficActivityInfo;
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, double d, int i, int i2, String str, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        LogX.i("FMTrafficCardOperatorImpl, applyPayOrder begin");
        new ApplyPayOrderFMOperator(this.mContext, d, i, i2, issuerInfoItem, str, applyPayOrderResultHandler).applyPayOrder();
    }

    public void queryOfflineCardInfo(IssuerInfoItem issuerInfoItem, int i, QueryOfflineTrafficCardInfoResultHandler queryOfflineTrafficCardInfoResultHandler) {
        int i2;
        if ((i & 1) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            i2 |= 32;
        }
        OfflineTrafficCardInfo offlineTrafficCardInfo = new OfflineTrafficCardInfo();
        LogX.i("queryOfflineCardInfo myAid : " + issuerInfoItem.getAid());
        QueryCardInfoResponse queryCardInfo = SPIServiceFactory.createFMService(this.mContext, issuerInfoItem.getAid()).queryCardInfo(i2, issuerInfoItem.getAid());
        if (queryCardInfo.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "FMTrafficCardOperatorImpl queryOfflineCardInfo, query card info fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryCardInfo.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_CARD_INFO_FAIL, hashMap, str, false, false);
            queryOfflineTrafficCardInfoResultHandler.handleResult(99, null);
            return;
        }
        offlineTrafficCardInfo.setCardNo(queryCardInfo.getCardNo());
        offlineTrafficCardInfo.setBalance(MoneyUtil.convertFenToYuan(String.valueOf(queryCardInfo.getBalance())));
        if (!StringUtil.isEmpty(queryCardInfo.getTime4Validity(), true)) {
            offlineTrafficCardInfo.setExpireDate(TimeUtil.m28482a(TimeUtil.m28483a(queryCardInfo.getTime4Validity(), "yyyyMMdd"), "yyyy/MM/dd"));
        }
        queryOfflineTrafficCardInfoResultHandler.handleResult(0, offlineTrafficCardInfo);
    }

    public void applyPayOrder(IssuerInfoItem issuerInfoItem, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
    }
}
