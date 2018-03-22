package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.order;

import android.content.Context;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard.IssueTrafficCardFMOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QueryAndHandleUnfinfishedOrdersFMOperator {
    private static final int LIMITED_BALANCE = 100000;
    private int mBussnessType;
    private Context mContext;
    private IssuerInfoItem mInfo;
    private QueryAndHandleUnfinishedOrderResultHandler mResultHandler;
    private int[] unfinishedStatus = new int[]{2, 4};
    private int[] unknownStatus = new int[]{5};

    class QueryResult {
        OrderHandleResultInfo mResultInfo;
        List<TrafficOrder> mUnfinishedOrders;

        public QueryResult(List<TrafficOrder> list, OrderHandleResultInfo orderHandleResultInfo) {
            this.mUnfinishedOrders = list;
            this.mResultInfo = orderHandleResultInfo;
        }
    }

    public QueryAndHandleUnfinfishedOrdersFMOperator(Context context, IssuerInfoItem issuerInfoItem, int i, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = queryAndHandleUnfinishedOrderResultHandler;
        this.mBussnessType = i;
    }

    public void queryAndHandleUnfinishedOrders() {
        LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryAndHandleUnfinishedOrders begin bussness type=" + this.mBussnessType);
        if (this.mBussnessType == 0) {
            TrafficOrder queryIssueBusinessOrders = queryIssueBusinessOrders();
            if (queryIssueBusinessOrders == null) {
                LogX.e("QueryAndHandleUnfinfishedOrdersFMOperator queryIssueBusinessOrders failed");
                return;
            }
            LogX.d(" CardEvent issueTrafficCard bus cardEvent START_LOCK");
            WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
            IssueTrafficCardFMOperator issueTrafficCardFMOperator = new IssueTrafficCardFMOperator(this.mContext, this.mInfo, queryIssueBusinessOrders, null);
            int issueTrafficCard = issueTrafficCardFMOperator.issueTrafficCard();
            LogX.d(" CardEvent issueTrafficCard bus cardEvent END_LOCK");
            WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
            LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryAndHandleUnfinishedOrders, issueTrafficCard result=" + issueTrafficCard);
            if (issueTrafficCard == 0) {
                issueTrafficCardFMOperator.doRecharge();
                this.mResultHandler.handleResult(issueTrafficCard, 10002, new OrderHandleResultInfo(1, 0, 1, 0));
                return;
            }
            this.mResultHandler.handleResult(issueTrafficCard, 10001, new OrderHandleResultInfo(1, 0, 0, 0));
            return;
        }
        QueryResult queryUnfinishedOrders = queryUnfinishedOrders();
        if (queryUnfinishedOrders.mUnfinishedOrders.isEmpty()) {
            LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryAndHandleUnfinishedOrders, no unfinished orders");
            this.mResultHandler.handleResult(0, 10000, null);
            return;
        }
        LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryAndHandleUnfinishedOrders, exist unfinished orders");
        this.mResultHandler.handleResult(0, 10001, queryUnfinishedOrders.mResultInfo);
        handleUnfinishedOrders(queryUnfinishedOrders);
    }

    private QueryResult queryUnfinishedOrders() {
        LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryUnfinishedOrders begin");
        handleUnknownOrders();
        List queryAllUnfinishedOrders = queryAllUnfinishedOrders(0);
        int size = queryAllUnfinishedOrders.size();
        QueryResult queryResult = new QueryResult(queryAllUnfinishedOrders, new OrderHandleResultInfo(size, size, 0, 0));
        LogX.i("QueryAndHandleUnfinfishedOrdersFMOperator queryUnfinishedOrders end");
        return queryResult;
    }

    private void handleUnfinishedOrders(QueryResult queryResult) {
        int balance;
        LogX.d(" CardEvent queryCardInfo bus cardEvent START_LOCK");
        WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
        LogX.i("handleUnfinishedOrderssss  myAid : " + this.mInfo.getAid());
        QueryCardInfoResponse queryCardInfo = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryCardInfo(2, this.mInfo.getAid());
        LogX.d(" CardEvent queryCardInfo bus cardEvent END_LOCK");
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
        if (queryCardInfo.resultCode == 0) {
            balance = queryCardInfo.getBalance();
        } else {
            Map hashMap = new HashMap();
            String str = "QueryAndHandleUnfinfishedOrdersFMOperator handleUnfinishedOrders, query balance fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryCardInfo.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_CARD_INFO_FAIL, hashMap, str, false, false);
            balance = 0;
        }
        List list = queryResult.mUnfinishedOrders;
        int size = list.size();
        int size2 = list.size();
        int i = 0;
        int i2 = 0;
        int i3 = balance;
        while (i < size2) {
            NfcosBusinessOrder nfcosBusinessOrder = ((TrafficOrder) list.get(i)).getNfcosBusinessOrder();
            if (nfcosBusinessOrder == null || nfcosBusinessOrder.businessOrderType != 1) {
                LogX.e("QueryAndHandleUnfinfishedOrdersFMOperator handleUnfinishedOrders, illegal rechargeOrder");
                balance = i2;
                i2 = i3;
            } else if (nfcosBusinessOrder.amount + i3 > 100000) {
                Map hashMap2 = new HashMap();
                str = "QueryAndHandleUnfinfishedOrdersFMOperator handleUnfinishedOrders, LIMITED_BALANCE";
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_RECHARGE_FAIL, hashMap2, str, false, false);
                this.mResultHandler.handleResult(0, 1201, new OrderHandleResultInfo(size, i2, 0, 0));
                return;
            } else {
                LogX.d(" CardEvent RECHARGE bus cardEvent START_LOCK");
                WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
                RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
                rechargeOrDoUnsolvedOrderRequest.setOrder(nfcosBusinessOrder.order);
                rechargeOrDoUnsolvedOrderRequest.setAid(this.mInfo.getAid());
                LogX.i("handleUnfinishedOrders  myAid : " + this.mInfo.getAid());
                FMBaseResponse recharge = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).recharge(rechargeOrDoUnsolvedOrderRequest);
                LogX.d(" CardEvent RECHARGE bus cardEvent END_LOCK");
                WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
                if (recharge.resultCode == 0) {
                    balance = i2 + 1;
                    i2 = nfcosBusinessOrder.amount + i3;
                } else {
                    Map hashMap3 = new HashMap();
                    String str2 = "QueryAndHandleUnfinfishedOrdersFMOperator handleUnfinishedOrders, recharge fail";
                    hashMap3.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                    hashMap3.put(CloudEyeLogger.FAIL_CODE, String.valueOf(recharge.FMCode));
                    hashMap3.put("order_id", Arrays.toString(rechargeOrDoUnsolvedOrderRequest.getOrder()));
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_RECHARGE_FAIL, hashMap3, str2, false, false);
                    balance = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = balance;
        }
        this.mResultHandler.handleResult(0, 10002, new OrderHandleResultInfo(size, i2, 0, 0));
    }

    private ArrayList<TrafficOrder> queryAllUnfinishedOrders(int i) {
        ArrayList<TrafficOrder> arrayList = new ArrayList();
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(i, this.unfinishedStatus, 1, null, this.mInfo.getAid());
        LogX.i("queryAllUnfinishedOrders  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        if (queryBusinessOrders.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "QueryAndHandleUnfinfishedOrdersFMOperator queryAllUnfinishedOrders, query orders fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrders.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_UNFINISHED_ORDERS_FAIL, hashMap, str, false, false);
        } else if (queryBusinessOrders.orderList != null) {
            Iterator it = queryBusinessOrders.orderList.iterator();
            while (it.hasNext()) {
                NfcosBusinessOrder nfcosBusinessOrder = (NfcosBusinessOrder) it.next();
                TrafficOrder trafficOrder = new TrafficOrder();
                trafficOrder.setNfcosBusinessOrder(nfcosBusinessOrder);
                arrayList.add(trafficOrder);
            }
        }
        if (arrayList.size() >= 10) {
            arrayList.addAll(queryAllUnfinishedOrders(i + 10));
        }
        return arrayList;
    }

    private void handleUnknownOrders() {
        ArrayList queryAllUnknownOrders = queryAllUnknownOrders(0);
        RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
        Iterator it = queryAllUnknownOrders.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            rechargeOrDoUnsolvedOrderRequest.setOrder(((NfcosBusinessOrder) it.next()).order);
            rechargeOrDoUnsolvedOrderRequest.setAid(this.mInfo.getAid());
            LogX.d(" CardEvent doUnsolvedOrder bus cardEvent START_LOCK");
            WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
            LogX.i("handleUnknownOrders  myAid : " + this.mInfo.getAid());
            FMBaseResponse doUnsolvedOrder = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).doUnsolvedOrder(rechargeOrDoUnsolvedOrderRequest);
            LogX.d(" CardEvent doUnsolvedOrder bus cardEvent END_LOCK");
            WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
            if (doUnsolvedOrder.resultCode != 0) {
                i2 = i + 1;
                Map hashMap = new HashMap();
                String str = "QueryAndHandleUnfinfishedOrdersFMOperator handleUnknownOrders fail, num=" + i2;
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(doUnsolvedOrder.FMCode));
                hashMap.put("order_id", Arrays.toString(rechargeOrDoUnsolvedOrderRequest.getOrder()));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_DO_UNSOLVED_ORDERS_FAIL, hashMap, str, false, false);
            } else {
                i2 = i;
            }
            i = i2;
        }
    }

    private ArrayList<NfcosBusinessOrder> queryAllUnknownOrders(int i) {
        ArrayList<NfcosBusinessOrder> arrayList = new ArrayList();
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(i, this.unknownStatus, 1, null, this.mInfo.getAid());
        LogX.d(" CardEvent queryBusinessOrders bus cardEvent START_LOCK");
        WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
        LogX.i("queryAllUnknownOrders  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        LogX.d(" CardEvent queryBusinessOrders bus cardEvent END_LOCK");
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
        if (queryBusinessOrders.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "QueryAndHandleUnfinfishedOrdersFMOperator queryAllUnknownOrders fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrders.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_UNFINISHED_ORDERS_FAIL, hashMap, str, false, false);
        } else if (queryBusinessOrders.orderList != null) {
            arrayList.addAll(queryBusinessOrders.orderList);
        }
        if (arrayList.size() >= 10) {
            arrayList.addAll(queryAllUnknownOrders(i + 10));
        }
        return arrayList;
    }

    private TrafficOrder queryIssueBusinessOrders() {
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(0, new int[]{2, 3}, 2, ESEApiFactory.createESEInfoManagerApi(this.mContext).querySeid(), this.mInfo.getAid());
        LogX.d(" CardEvent queryBusinessOrders bus cardEvent START_LOCK");
        WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mInfo.getAid());
        LogX.i("queryIssueBusinessOrders  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        LogX.d(" CardEvent queryBusinessOrders bus cardEvent END_LOCK");
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mInfo.getAid());
        if (queryBusinessOrders.resultCode == 0) {
            if (!(queryBusinessOrders.orderList == null || queryBusinessOrders.orderList.isEmpty())) {
                TrafficOrder trafficOrder = new TrafficOrder();
                trafficOrder.setNfcosBusinessOrder((NfcosBusinessOrder) queryBusinessOrders.orderList.get(0));
                return trafficOrder;
            }
        } else if (queryBusinessOrders.resultCode == -2) {
            LogX.e("QueryAndHandleUnfinfishedOrdersFMOperator queryIssueBusinessOrders, NETWORK_ERROR");
            this.mResultHandler.handleResult(11, 10000, null);
            return null;
        }
        Map hashMap = new HashMap();
        String str = "QueryAndHandleUnfinfishedOrdersFMOperator queryIssueBusinessOrders, query issue order fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrders.FMCode));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_UNFINISHED_ORDERS_FAIL, hashMap, str, false, false);
        this.mResultHandler.handleResult(99, 10000, null);
        return null;
    }
}
