package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.recharge;

import android.content.Context;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrderResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RechargeFMOperator {
    private static final String TAG = "RechargeFMOperator";
    private String mAid;
    private Context mContext;
    private TrafficOrder mOrder;
    private RechargeResultHandler mResultHandler;

    public RechargeFMOperator(Context context, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler, String str) {
        this.mContext = context;
        this.mOrder = trafficOrder;
        this.mResultHandler = rechargeResultHandler;
        this.mAid = str;
    }

    public void recharge() {
        LogX.i("RechargeFMOperator recharge begin");
        NfcosBusinessOrder nfcosBusinessOrder = null;
        if (this.mOrder.getNfcosMainOrder() != null && this.mOrder.getNfcosMainOrder().businessOrders != null) {
            for (NfcosBusinessOrder nfcosBusinessOrder2 : this.mOrder.getNfcosMainOrder().businessOrders) {
                C2538c.c(TAG, new Object[]{" order.businessOrderType " + nfcosBusinessOrder2.businessOrderType});
                if (nfcosBusinessOrder2.businessOrderType == 1) {
                    break;
                }
            }
            NfcosBusinessOrder nfcosBusinessOrder22 = null;
            nfcosBusinessOrder = nfcosBusinessOrder22;
        } else if (this.mOrder.getNfcosBusinessOrder() != null) {
            C2538c.c(TAG, new Object[]{" mOrder.getNfcosBusinessOrder().businessOrderType " + this.mOrder.getNfcosBusinessOrder().businessOrderType});
            if (this.mOrder.getNfcosBusinessOrder().businessOrderType == 1) {
                nfcosBusinessOrder = this.mOrder.getNfcosBusinessOrder();
            }
        }
        if (nfcosBusinessOrder == null) {
            LogX.e("RechargeFMOperator recharge, rechargeOrder == null");
            this.mResultHandler.handleResult(99);
        } else if (checkOrderState(nfcosBusinessOrder)) {
            LogX.d(" CardEvent RECHARGE bus cardEvent START_LOCK");
            WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mAid);
            RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
            rechargeOrDoUnsolvedOrderRequest.setOrder(nfcosBusinessOrder.order);
            rechargeOrDoUnsolvedOrderRequest.setAid(this.mAid);
            LogX.i("recharge  myAid : " + this.mAid);
            FMBaseResponse recharge = SPIServiceFactory.createFMService(this.mContext, this.mAid).recharge(rechargeOrDoUnsolvedOrderRequest);
            LogX.d(" CardEvent RECHARGE bus cardEvent END_LOCK");
            WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mAid);
            if (recharge.resultCode == 0) {
                this.mResultHandler.handleResult(0);
            } else if (recharge.resultCode == -2) {
                LogX.e("RechargeFMOperator recharge, NETWORK_ERROR");
                this.mResultHandler.handleResult(11);
            } else {
                Map hashMap = new HashMap();
                String str = "RechargeFMOperator recharge fail";
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(recharge.FMCode));
                hashMap.put("order_id", Arrays.toString(rechargeOrDoUnsolvedOrderRequest.getOrder()));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_RECHARGE_FAIL, hashMap, str, false, false);
                this.mResultHandler.handleResult(99);
            }
        } else {
            LogX.e("RechargeFMOperator recharge, checkOrderState fail");
        }
    }

    private boolean checkOrderState(NfcosBusinessOrder nfcosBusinessOrder) {
        Map hashMap;
        QueryBusinessOrderRequest queryBusinessOrderRequest = new QueryBusinessOrderRequest();
        queryBusinessOrderRequest.order = nfcosBusinessOrder.order;
        LogX.i("checkOrderState  myAid : " + this.mAid);
        QueryBusinessOrderResponse queryBusinessOrder = SPIServiceFactory.createFMService(this.mContext, this.mAid).queryBusinessOrder(queryBusinessOrderRequest);
        LogX.i("RechargeFMOperator checkOrderState res=" + queryBusinessOrder.resultCode);
        if (queryBusinessOrder.resultCode != 0 || queryBusinessOrder.order == null) {
            if (queryBusinessOrder.resultCode == -2) {
                LogX.e("RechargeFMOperator checkOrderState, query order info res=NETWORK_ERROR");
                this.mResultHandler.handleResult(11);
                return false;
            }
        } else if (queryBusinessOrder.order.tradeState == 5) {
            LogX.d(" CardEvent doUnsolvedOrder bus cardEvent START_LOCK");
            WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mAid);
            RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
            rechargeOrDoUnsolvedOrderRequest.setOrder(nfcosBusinessOrder.order);
            rechargeOrDoUnsolvedOrderRequest.setAid(this.mAid);
            LogX.i("checkOrderState  myAid : " + this.mAid);
            FMBaseResponse doUnsolvedOrder = SPIServiceFactory.createFMService(this.mContext, this.mAid).doUnsolvedOrder(rechargeOrDoUnsolvedOrderRequest);
            LogX.d(" CardEvent doUnsolvedOrder bus cardEvent END_LOCK");
            WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mAid);
            if (doUnsolvedOrder.resultCode == 0) {
                QueryBusinessOrderRequest queryBusinessOrderRequest2 = new QueryBusinessOrderRequest();
                queryBusinessOrderRequest2.order = nfcosBusinessOrder.order;
                LogX.i("checkOrderState  myAid : " + this.mAid);
                QueryBusinessOrderResponse queryBusinessOrder2 = SPIServiceFactory.createFMService(this.mContext, this.mAid).queryBusinessOrder(queryBusinessOrderRequest2);
                if (queryBusinessOrder2.resultCode != 0 || queryBusinessOrder2.order == null) {
                    if (queryBusinessOrder2.resultCode == -2) {
                        LogX.e("RechargeFMOperator checkOrderState, query order info res2=NETWORK_ERROR");
                        this.mResultHandler.handleResult(11);
                        return false;
                    }
                } else if (queryBusinessOrder2.order.tradeState == 4 || queryBusinessOrder2.order.tradeState == 2) {
                    return true;
                }
            } else if (doUnsolvedOrder.resultCode == -2) {
                LogX.e("RechargeFMOperator checkOrderState, do unsolved order res1=NETWORK_ERROR");
                this.mResultHandler.handleResult(11);
                return false;
            } else {
                hashMap = new HashMap();
                String str = "RechargeFMOperator checkOrderState, do unsolved order fail";
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(doUnsolvedOrder.FMCode));
                hashMap.put("order_id", Arrays.toString(rechargeOrDoUnsolvedOrderRequest.getOrder()));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_DO_UNSOLVED_ORDERS_FAIL, hashMap, str, false, false);
                this.mResultHandler.handleResult(99);
                return false;
            }
        } else if (queryBusinessOrder.order.tradeState == 4 || queryBusinessOrder.order.tradeState == 2) {
            return true;
        } else {
            if (queryBusinessOrder.order.tradeState == 3) {
                LogX.i("RechargeFMOperator checkOrderState, ORDER_STATUS_SUCCESS");
                this.mResultHandler.handleResult(0);
                return false;
            }
        }
        hashMap = new HashMap();
        String str2 = "RechargeFMOperator checkOrderState, query order fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrder.FMCode));
        hashMap.put("order_id", Arrays.toString(queryBusinessOrderRequest.order));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_ORDER_INFO_FAIL, hashMap, str2, false, false);
        this.mResultHandler.handleResult(99);
        return false;
    }
}
