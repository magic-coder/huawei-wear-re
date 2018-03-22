package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.ApplyPayOrderCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.ApplyOrderInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.ApplyOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.ApplyOrderResponse;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryOrderResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;

public class ApplyPayOrderOperator {
    private static final int LIMITED_BALANCE = 100000;
    private static final String TAG = "ApplyPayOrderOperator";
    private String failCode;
    private int logUploadEventId;
    private final ApplyOrderInfo mApplyOrderInfo;
    private final Context mContext;
    private final IssuerInfoItem mItem;
    private final ApplyPayOrderResultHandler mResultHandler;

    public ApplyPayOrderOperator(Context context, IssuerInfoItem issuerInfoItem, ApplyOrderInfo applyOrderInfo, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        this.mContext = context;
        this.mApplyOrderInfo = applyOrderInfo;
        this.mItem = issuerInfoItem;
        this.mResultHandler = applyPayOrderResultHandler;
    }

    public void doApplyPayOrder() {
        getLoggerParamByOrderType();
        if (!hasUnfinishedOrder()) {
            if (checkBalance()) {
                ApplyOrderResponse applyOrder = SPIServiceFactory.createServerAccessService(this.mContext).applyOrder(bulidApplyOrderRequest());
                if (applyOrder.getResultCode() == 0 || applyOrder.getResultCode() == 1003) {
                    TrafficOrder buildOrderAndPayInfo = buildOrderAndPayInfo(applyOrder);
                    if (buildOrderAndPayInfo != null) {
                        this.mResultHandler.handleResult(0, buildOrderAndPayInfo);
                        return;
                    }
                }
                handleErrCode(applyOrder.getResultCode(), applyOrder.getResultDesc());
                LogUploadOperator.getInstance(this.mContext).init(this.mItem.getIssuerId(), "1300", "apply issue order,server," + applyOrder.getResultCode(), 11);
                reportErr(applyOrder.getResultCode(), applyOrder.getResultDesc());
                return;
            }
            C2538c.c(TAG, new Object[]{"ApplyPayOrderOperator err, recharge amount over limit."});
        }
    }

    private void getLoggerParamByOrderType() {
        int orderType = this.mApplyOrderInfo.getOrderType();
        if (orderType == 1 || orderType == 3) {
            this.logUploadEventId = AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN;
            this.failCode = "1300";
        } else if (orderType == 2) {
            this.logUploadEventId = AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_RECHARGE;
            this.failCode = "1501";
        } else if (orderType == 5) {
            this.logUploadEventId = AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_TRANSFER_IN;
            this.failCode = "2202";
        }
    }

    private TrafficOrder buildOrderAndPayInfo(ApplyOrderResponse applyOrderResponse) {
        List<ApplyOrder> orderList = applyOrderResponse.getOrderList();
        if (orderList == null) {
            C2538c.c(TAG, new Object[]{"buildOrderAndPayInfo orderList is null "});
            return null;
        }
        ApplyOrder applyOrder;
        TrafficOrder trafficOrder;
        for (ApplyOrder applyOrder2 : orderList) {
            if (this.mApplyOrderInfo.getOrderType() != 2 || !applyOrder2.getOrderType().equals("1")) {
                if (this.mApplyOrderInfo.getOrderType() != 1 || !applyOrder2.getOrderType().equals("0")) {
                    if (this.mApplyOrderInfo.getOrderType() == 3 && applyOrder2.getOrderType().equals("2")) {
                        applyOrder = applyOrder2;
                        break;
                    }
                } else {
                    applyOrder = applyOrder2;
                    break;
                }
            }
            applyOrder = applyOrder2;
            break;
        }
        applyOrder = null;
        if (applyOrder != null) {
            trafficOrder = new TrafficOrder();
            trafficOrder.setApplyOrders(orderList);
            trafficOrder.setPayInfo(PayInfo.build(applyOrder));
            trafficOrder.setNewPayVersion(true);
        } else {
            trafficOrder = null;
        }
        return trafficOrder;
    }

    private boolean checkBalance() {
        if (this.mApplyOrderInfo.getOrderType() == 2) {
            int balance = getBalance();
            C2538c.c(TAG, new Object[]{"currentBalance : " + balance + " ; TheoreticalPayment : " + this.mApplyOrderInfo.getTheoreticalPayment()});
            if (balance >= 0 && balance + this.mApplyOrderInfo.getTheoreticalPayment() > 100000) {
                this.mResultHandler.handleResult(1001, null);
                return false;
            }
        }
        return true;
    }

    private int getBalance() {
        C2538c.c(TAG, new Object[]{"getBalance"});
        AppletCardResult readTrafficCardInfo = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardInfo(this.mItem.getAid(), this.mItem.getProductId(), 2);
        if (readTrafficCardInfo.getResultCode() == 0) {
            return ((CardInfo) readTrafficCardInfo.getData()).getBalanceByFenUnit();
        }
        this.mResultHandler.handleResult(SpiResultCodeTranslator.geteSEErrorCode(readTrafficCardInfo.getResultCode()), null);
        return -1;
    }

    private boolean hasUnfinishedOrder() {
        int i = 0;
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        QueryOrderRequest queryOrderRequest = new QueryOrderRequest(this.mItem.getIssuerId(), instance.queryCplc(), this.mItem.getAid(), instance.getDeviceModel(), instance.getBusChipManu());
        C2538c.c(TAG, new Object[]{"queryOrder, request.getIssuerId() = " + queryOrderRequest.getIssuerId() + " request.getCplc() = " + queryOrderRequest.getCplc() + " request.getAppletAid() = " + queryOrderRequest.getAppletAid() + " request.getDeviceModel() = " + queryOrderRequest.getDeviceModel() + " request.getSeChipManuFacturer() = " + queryOrderRequest.getSeChipManuFacturer()});
        queryOrderRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        queryOrderRequest.setOrderStatus("1");
        QueryOrderResponse queryOrder = SPIServiceFactory.createServerAccessService(this.mContext).queryOrder(queryOrderRequest);
        if (queryOrder.getResultCode() == 0) {
            if (queryOrder.getOrderList() != null && queryOrder.getOrderList().size() > 0) {
                List<QueryOrder> orderList = queryOrder.getOrderList();
                List arrayList = new ArrayList();
                boolean z = false;
                boolean z2 = false;
                for (QueryOrder queryOrder2 : orderList) {
                    boolean z3;
                    int i2 = (QueryOrder.STATUS_CREATE_SSD_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_DOWNLOAD_CAP_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_PERSONALIZED_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_RECHARGE_FAIL.equals(queryOrder2.getStatus())) ? true : 0;
                    if (i2 != 0) {
                        arrayList.add(queryOrder2);
                        if ("2".equals(queryOrder2.getOrderType()) || "0".equals(queryOrder2.getOrderType())) {
                            z3 = true;
                            z = true;
                        } else {
                            z3 = z;
                            z = true;
                        }
                    } else {
                        z3 = z;
                        z = z2;
                    }
                    z2 = z;
                    z = z3;
                }
                if (z2) {
                    C2538c.c(TAG, new Object[]{"ApplyPayOrderOperator, hasRetriableOrder"});
                    TrafficOrder trafficOrder = new TrafficOrder();
                    trafficOrder.setQueryOrders(arrayList);
                    trafficOrder.setHasUnusedIssueOrder(true);
                    trafficOrder.setDuplicateApply(z);
                    if (this.mApplyOrderInfo.getOrderType() == 2) {
                        i = 1002;
                    }
                    this.mResultHandler.handleResult(i, trafficOrder);
                    return true;
                }
            }
            C2538c.c(TAG, new Object[]{"ApplyPayOrderOperator, no unfinished orders."});
            return false;
        }
        C2538c.c(TAG, new Object[]{"ApplyPayOrderOperator, applyOrder err, code =" + queryOrder.getResultCode() + ", desc = " + queryOrder.getResultDesc()});
        handleCommenErr(queryOrder.getResultCode());
        reportUnfinishErr(queryOrder.getResultCode(), this.mApplyOrderInfo.getOrderType());
        reportErr(queryOrder.getResultCode(), queryOrder.getResultDesc());
        return true;
    }

    private void reportUnfinishErr(int i, int i2) {
        if (i2 == 1 || i2 == 3) {
            LogUploadOperator.getInstance(this.mContext).init(this.mItem.getIssuerId(), "1103", "query issue order,server," + i, 11);
        } else if (i2 == 2) {
            LogUploadOperator.getInstance(this.mContext).init(this.mItem.getIssuerId(), "1501", "apply_recharge_order,server," + i, 11);
        }
    }

    private void reportErr(int i, String str) {
        CloudEyeLogger.build(this.logUploadEventId, this.failCode, this.mItem.getIssuerId()).setResultCode(i).setResultDesc("ApplyPayOrderOperator err : " + str).appendExtraInfo(IssuerInfoColumns.COLUMN_NAME_MODE, this.mItem.getMode()).upload();
    }

    private void handleErrCode(int i, String str) {
        int i2 = 1;
        C2538c.c(TAG, new Object[]{"ApplyPayOrderOperator, applyOrder err, code =" + i + ", desc = " + str});
        if (!handleCommenErr(i)) {
            switch (i) {
                case 1001:
                    i2 = 1009;
                    break;
                case 1002:
                    break;
                case 1004:
                case 1005:
                case 1006:
                    i2 = ApplyPayOrderCallback.RETURN_FAILED_APPLY_ORDER_INNER_ERROR;
                    break;
                case 1007:
                    i2 = 1028;
                    break;
                case 1008:
                    i2 = 1029;
                    break;
                case 1009:
                    i2 = 1010;
                    break;
                default:
                    i2 = ApplyPayOrderCallback.RETURN_FAILED_APPLY_ORDER_INNER_ERROR;
                    break;
            }
            this.mResultHandler.handleResult(i2, null);
        }
    }

    private boolean handleCommenErr(int i) {
        boolean z = true;
        int i2 = ApplyPayOrderCallback.RETURN_FAILED_APPLY_ORDER_INNER_ERROR;
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
            default:
                z = false;
                break;
        }
        if (z) {
            this.mResultHandler.handleResult(i2, null);
        }
        return z;
    }

    private ApplyOrderRequest bulidApplyOrderRequest() {
        String str;
        String str2;
        String str3;
        String str4;
        String payment;
        String str5;
        String queryCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        String str6 = "01";
        String payment2;
        if (1 == this.mApplyOrderInfo.getOrderType()) {
            str = "0";
            payment2 = getPayment(this.mApplyOrderInfo.getActualIssuePayment());
            str2 = null;
            str3 = null;
            str4 = null;
            payment = getPayment(this.mApplyOrderInfo.getTheoreticalIssuePayment());
            str5 = payment2;
        } else if (2 == this.mApplyOrderInfo.getOrderType()) {
            String fpanFour;
            r5 = "1";
            str = getPayment(this.mApplyOrderInfo.getActualRechargePayment());
            payment2 = getPayment(this.mApplyOrderInfo.getTheoreticalRechargePayment());
            C2538c.c(TAG, new Object[]{"TA aRechargePayment : " + str + " ; tRechargePayment : " + payment2});
            TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mItem.getAid());
            if (card != null) {
                fpanFour = card.getFpanFour();
                C2538c.c(TAG, new Object[]{"TA cardNum : " + fpanFour});
            } else {
                fpanFour = null;
            }
            str2 = fpanFour;
            str3 = payment2;
            str4 = str;
            payment = null;
            str5 = null;
            str = r5;
        } else {
            r5 = getPayment(this.mApplyOrderInfo.getActualIssuePayment());
            str = getPayment(this.mApplyOrderInfo.getTheoreticalIssuePayment());
            payment2 = getPayment(this.mApplyOrderInfo.getActualRechargePayment());
            str3 = getPayment(this.mApplyOrderInfo.getTheoreticalRechargePayment());
            str4 = payment2;
            payment = str;
            str5 = r5;
            str = "2";
            str2 = null;
        }
        ApplyOrderRequest applyOrderRequest = new ApplyOrderRequest(this.mItem.getIssuerId(), queryCplc, this.mItem.getAid(), str, ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel(), str6);
        applyOrderRequest.setActualIssuePayment(str5);
        applyOrderRequest.setTheoreticalIssuePayment(payment);
        applyOrderRequest.setActualRecharegePayment(str4);
        applyOrderRequest.setTheoreticalRecharegePayment(str3);
        applyOrderRequest.setTrafficCardId(str2);
        applyOrderRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        return applyOrderRequest;
    }

    private String getPayment(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = i % 100;
        stringBuilder.append(i / 100).append('.');
        if (i2 < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }
}
