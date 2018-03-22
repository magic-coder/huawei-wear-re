package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.RechargeResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.RechargeRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.BaseResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.RechargeResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.List;

public class RechargeSAOperator {
    static final String RECHARGE_MODE_FIRST = "0";
    static final String RECHARGE_MODE_REPEAT = "1";
    private static final String SYSTEMTYPE = "Android";
    private static final String TAG = "RechargeSAOperator";
    private Context mContext;
    private IssuerInfoItem mInfo;
    private TrafficOrder mOrder;
    private RechargeResultHandler mResultHandler;
    private String orderId;

    public RechargeSAOperator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, RechargeResultHandler rechargeResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mOrder = trafficOrder;
        this.mResultHandler = rechargeResultHandler;
    }

    public int recharge(QueryOrder queryOrder) {
        String aid = this.mInfo.getAid();
        String issuerId = this.mInfo.getIssuerId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(issuerId, true) || queryOrder == null || StringUtil.isEmpty(queryOrder.getOrderId(), true)) {
            String str = "RechargeSAOperator recharge failed. param is illegal. aid = " + aid + " issuerID = " + issuerId + " orderId = null";
            if (queryOrder != null) {
                str = "RechargeSAOperator recharge failed. param is illegal. aid = " + aid + " issuerID = " + issuerId + " orderId = " + queryOrder;
            }
            CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE).setFailCode("1502").setResultCode(10).setResultDesc(str).upload();
            handleResult(10);
            return 10;
        }
        this.orderId = queryOrder.getOrderId();
        return doRecharge(this.orderId, "1");
    }

    public int recharge(String str) {
        C2538c.c(TAG, new Object[]{" doRecharge recharge"});
        String aid = this.mInfo.getAid();
        String issuerId = this.mInfo.getIssuerId();
        String orderID = getOrderID();
        if (!StringUtil.isEmpty(aid, true) && !StringUtil.isEmpty(issuerId, true) && !StringUtil.isEmpty(orderID, true) && !StringUtil.isEmpty(str, true)) {
            return doRecharge(orderID, str);
        }
        aid = "RechargeSAOperator recharge failed. param is illegal. aid = " + aid + " issuerID = " + issuerId + " orderId = " + orderID + " rechargeMode = " + str;
        LogX.w(aid);
        CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE).setFailCode("1502").setResultCode(10).setResultDesc(aid).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).upload();
        handleResult(10);
        return 10;
    }

    private int doRecharge(String str, String str2) {
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        String queryCplc = instance.queryCplc();
        String deviceModel = instance.getDeviceModel();
        String busChipManu = instance.getBusChipManu();
        String deviceSoftVersion = instance.getDeviceSoftVersion();
        String deviceSN = instance.getDeviceSN();
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(this.mInfo.getAid());
        if (cardInfoByAid == null) {
            CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE).setFailCode("1502").setResultCode(10).setResultDesc("RechargeSAOperator recharge failed. taInfo == null .").appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).upload();
            return 10;
        }
        String str3 = str;
        RechargeRequest rechargeRequest = new RechargeRequest(this.mInfo.getIssuerId(), this.mInfo.getAid(), str3, queryCplc, cardInfoByAid.getFpanFour(), SYSTEMTYPE, deviceSoftVersion, deviceModel, busChipManu);
        rechargeRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        rechargeRequest.setImei(deviceSN);
        rechargeRequest.setRechargeMode(str2);
        RechargeResponse recharge = SPIServiceFactory.createServerAccessService(this.mContext).recharge(rechargeRequest);
        C2538c.c(TAG, new Object[]{" doRecharge response code : " + recharge.getResultCode()});
        if (recharge.getResultCode() == 0) {
            C2538c.c(TAG, new Object[]{" doRecharge RESULT_CODE_SUCCESS: " + recharge.getResultCode()});
            handleResult(0);
            return 0;
        }
        LogX.e("RechargeSAOperator, recharge err, code : " + recharge.getResultCode() + ", desc : " + recharge.getResultDesc());
        return handleErr(recharge.getResultCode(), recharge.getResultDesc());
    }

    private int handleErr(int i, String str) {
        int i2;
        switch (i) {
            case 1:
                i2 = 10;
                break;
            case 2:
                i2 = 11;
                break;
            case 3:
                i2 = 25;
                break;
            case 4:
                i2 = 14;
                reportErr(i, str);
                break;
            case BaseResponse.RESULT_CODE_RECHARGE_SP_SERVER_ERROR /*4003*/:
                i2 = RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE_RETRYABLE;
                reportErr(i, str);
                break;
            case BaseResponse.RESULT_CODE_RECHARGE_ABNORMAL_APPLET /*4004*/:
                i2 = RechargeCallback.RETURN_RECHARGE_FAILED_REFUNDABLE;
                reportErr(i, str);
                break;
            default:
                i2 = RechargeCallback.RETURN_RECHARGE_INNER_FAILED;
                reportErr(i, str);
                break;
        }
        handleResult(i2);
        return i2;
    }

    private String getOrderID() {
        if (this.mOrder.getQueryOrders() != null) {
            return getOpenCardRetryOrderId(this.mOrder.getQueryOrders());
        }
        List<ApplyOrder> applyOrders = this.mOrder.getApplyOrders();
        if (applyOrders == null || applyOrders.size() < 1) {
            LogX.e("IssueTrafficCardSAOperator issueTrafficCard, query orders err!");
            return null;
        }
        ApplyOrder applyOrder = null;
        ApplyOrder applyOrder2 = null;
        for (ApplyOrder applyOrder3 : applyOrders) {
            ApplyOrder applyOrder32;
            if ("1".equals(applyOrder32.getOrderType())) {
                ApplyOrder applyOrder4 = applyOrder;
                applyOrder = applyOrder32;
                applyOrder32 = applyOrder4;
            } else if ("2".equals(applyOrder32.getOrderType())) {
                applyOrder = applyOrder2;
            } else {
                applyOrder32 = applyOrder;
                applyOrder = applyOrder2;
            }
            applyOrder2 = applyOrder;
            applyOrder = applyOrder32;
        }
        if (applyOrder2 != null) {
            return applyOrder2.getOrderId();
        }
        if (applyOrder != null) {
            return applyOrder.getOrderId();
        }
        return null;
    }

    private String getOpenCardRetryOrderId(List<QueryOrder> list) {
        QueryOrder queryOrder = null;
        QueryOrder queryOrder2 = null;
        for (QueryOrder queryOrder3 : list) {
            QueryOrder queryOrder32;
            if ("1".equals(queryOrder32.getOrderType())) {
                QueryOrder queryOrder4 = queryOrder;
                queryOrder = queryOrder32;
                queryOrder32 = queryOrder4;
            } else if ("2".equals(queryOrder32.getOrderType())) {
                queryOrder = queryOrder2;
            } else {
                queryOrder32 = queryOrder;
                queryOrder = queryOrder2;
            }
            queryOrder2 = queryOrder;
            queryOrder = queryOrder32;
        }
        if (queryOrder2 != null) {
            return queryOrder2.getOrderId();
        }
        if (queryOrder != null) {
            return queryOrder.getOrderId();
        }
        return null;
    }

    private void handleResult(int i) {
        if (this.mResultHandler != null) {
            this.mResultHandler.handleResult(i);
        }
    }

    private void reportErr(int i, String str) {
        CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE, "1502", this.mInfo.getIssuerId()).setResultCode(i).setResultDesc("RechargeSAOperator err : " + str).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mInfo.getMode()).appendExtraInfo("orderNo", this.orderId).upload();
    }
}
