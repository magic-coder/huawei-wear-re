package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.RechargeCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.OrderHandleResultInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.QueryAndHandleUnfinishedOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.impl.EseTsmInitLoader;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.QueryOrderRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.QueryOrderResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryAndHandleUnfinishedOrdersSAOperator {
    private String cplc;
    private int mBussnessType;
    private Context mContext;
    private IssuerInfoItem mInfo;
    private boolean mIsDeal = false;
    private QueryAndHandleUnfinishedOrderResultHandler mResultHandler;
    private TrafficOrder trafficOrder;

    public QueryAndHandleUnfinishedOrdersSAOperator(Context context, IssuerInfoItem issuerInfoItem, int i, boolean z, QueryAndHandleUnfinishedOrderResultHandler queryAndHandleUnfinishedOrderResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = queryAndHandleUnfinishedOrderResultHandler;
        this.mBussnessType = i;
        this.cplc = ESEInfoManager.getInstance(this.mContext).queryCplc();
        this.mIsDeal = z;
    }

    public void queryAndHandleUnfinishedOrders() {
        LogX.i("QueryAndHandleUnfinishedOrdersSAOperator queryAndHandleUnfinishedOrders begin bussness type=" + this.mBussnessType);
        String aid = this.mInfo.getAid();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(productId, true)) {
            LogX.w("QueryAndHandleUnfinishedOrdersSAOperator queryAndHandleUnfinishedOrders failed. aid or productId is illegal. aid = " + aid + " productId = " + productId);
            this.mResultHandler.handleResult(10, 10000, null);
        } else if (!queryOrders()) {
            LogX.e("QueryAndHandleUnfinishedOrdersSAOperator, queryOrders fail!");
        } else if (this.trafficOrder != null) {
            this.mResultHandler.handleResult(0, 10001, null);
            if (!this.mIsDeal) {
                return;
            }
            if (this.trafficOrder.getHasUnusedIssueOrder()) {
                handleOpenCardOrders();
            } else {
                handleRechargeOrders();
            }
        } else if (this.mBussnessType == 0 && checkLocalAppletStatus()) {
            OrderHandleResultInfo orderHandleResultInfo = new OrderHandleResultInfo(1, 0, 1, 0);
            this.mResultHandler.handleResult(0, 10001, orderHandleResultInfo);
            this.mResultHandler.handleResult(0, 10002, orderHandleResultInfo);
        } else {
            this.mResultHandler.handleResult(0, 10000, null);
        }
    }

    private void handleRechargeOrders() {
        List<QueryOrder> queryOrders = this.trafficOrder.getQueryOrders();
        int i = RechargeCallback.RETURN_RECHARGE_INNER_FAILED;
        int i2 = 0;
        for (QueryOrder queryOrder : queryOrders) {
            int recharge;
            if (QueryOrder.STATUS_RECHARGE_FAIL.equals(queryOrder.getStatus())) {
                recharge = new RechargeSAOperator(this.mContext, this.mInfo, this.trafficOrder, null).recharge(queryOrder);
                if (recharge == 0) {
                    recharge = i;
                    i = i2 + 1;
                } else {
                    i = i2;
                }
            } else {
                recharge = i;
                i = i2;
            }
            i2 = i;
            i = recharge;
        }
        if (i2 > 0) {
            this.mResultHandler.handleResult(0, 10002, new OrderHandleResultInfo(queryOrders.size(), i2, 0, 0));
            return;
        }
        this.mResultHandler.handleResult(i, 10002, null);
    }

    private void handleOpenCardOrders() {
        for (QueryOrder queryOrder : this.trafficOrder.getQueryOrders()) {
            if (!"2".equals(queryOrder.getOrderType())) {
                if ("0".equals(queryOrder.getOrderType())) {
                    break;
                }
            }
            break;
        }
        QueryOrder queryOrder2 = null;
        if (queryOrder2 != null) {
            String status = queryOrder2.getStatus();
            if (QueryOrder.STATUS_CREATE_SSD_FAIL.equals(status)) {
                retryInstallSSD(queryOrder2);
            } else if (QueryOrder.STATUS_DOWNLOAD_CAP_FAIL.equals(status) || QueryOrder.STATUS_PERSONALIZED_FAIL.equals(status)) {
                retryInstallApplet(queryOrder2);
            } else if (QueryOrder.STATUS_RECHARGE_FAIL.equals(status)) {
                retryOpenCardRecharge("1");
            }
        }
    }

    private boolean checkLocalAppletStatus() {
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.mInfo.getAid());
        if (card == null) {
            return false;
        }
        if (2 == card.getCardStatus()) {
            return true;
        }
        AppletCardResult readTrafficCardInfo = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardInfo(this.mInfo.getAid(), this.mInfo.getProductId(), 1);
        if (readTrafficCardInfo.getResultCode() == 0) {
            return updateTaInfo(card, ((CardInfo) readTrafficCardInfo.getData()).getCardNum());
        }
        boolean uninstall = new UninstallTrafficCardSAOperator(this.mContext, this.mInfo, null).uninstall();
        LogX.i("QueryAndHandleUnfinishedOrdersSAOperator remove the ta card for re-openning. The old card deleted[" + uninstall + "]");
        if (!uninstall) {
            return false;
        }
        removeTACardInfo();
        return false;
    }

    private boolean updateTaInfo(TACardInfo tACardInfo, String str) {
        tACardInfo.setFpanFour(str);
        tACardInfo.setCardStatus(2);
        if (removeTACardInfo()) {
            try {
                WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
                return true;
            } catch (Throwable e) {
                LogX.e("WalletTaCardAlreadyExistException ", e);
            }
        }
        return false;
    }

    private boolean removeTACardInfo() {
        try {
            WalletTaManager.getInstance(this.mContext).removeCard(this.mInfo.getAid());
            return true;
        } catch (Throwable e) {
            LogX.e("WalletTaCardNotExistException ", e);
            return true;
        } catch (Throwable e2) {
            LogX.e("WalletTaSystemErrorException ", e2);
            return false;
        }
    }

    private void retryOpenCardRecharge(String str) {
        LogX.i("do retryOpenCardRecharge");
        int recharge = new RechargeSAOperator(this.mContext, this.mInfo, this.trafficOrder, null).recharge(str);
        if (recharge == 0) {
            LogX.i("retryOpenCardRecharge success");
            this.mResultHandler.handleResult(0, 10002, new OrderHandleResultInfo(1, 0, 1, 0));
            return;
        }
        LogX.e("retryOpenCardRecharge fail!");
        if (!handleCommenErr(recharge)) {
            this.mResultHandler.handleResult(RechargeCallback.RETURN_RECHARGE_INNER_FAILED, 10001, null);
        }
    }

    private void retryInstallApplet(QueryOrder queryOrder) {
        LogX.i("do retryInstallApplet");
        int issueTrafficCard = new PersonalizingBusCardOprator(this.mContext, this.mInfo, this.trafficOrder, null).issueTrafficCard();
        if (issueTrafficCard == 0) {
            LogX.i("retryInstallApplet success");
            if ("2".equals(queryOrder.getOrderType())) {
                retryOpenCardRecharge("0");
                return;
            }
            this.mResultHandler.handleResult(0, 10002, new OrderHandleResultInfo(1, 0, 1, 0));
            return;
        }
        LogX.e("retryInstallApplet fail!");
        if (!handleCommenErr(issueTrafficCard)) {
            this.mResultHandler.handleResult(IssueTrafficCardCallback.RETURN_FAILED_ISSUE_CARD_INNER_ERROR, 10001, null);
        }
    }

    private void retryInstallSSD(QueryOrder queryOrder) {
        int i = IssueTrafficCardCallback.RETURN_FAILED_ISSUE_CARD_INNER_ERROR;
        LogX.i("do retryInstallSSD");
        int excuteEseInit = new EseTsmInitLoader(this.mContext).excuteEseInit();
        if (excuteEseInit != 100000) {
            LogX.e("retryInstallSSD fail! Init eSE fail!");
            reportErr(AutoReportErrorCode.ERROR_EVENT_ID_SA_INIT_FAILED, excuteEseInit, "retryInstallSSD fail! Init eSE fail!");
            switch (excuteEseInit) {
                case 100002:
                    i = 12;
                    break;
                case 100005:
                case 100010:
                    i = 25;
                    break;
                case 100006:
                    i = 11;
                    break;
            }
            this.mResultHandler.handleResult(i, 10001, null);
        } else if (new InitDmsdAndDownloadAppletOperator(this.mContext, this.mInfo.getAid(), this.mInfo.getIssuerId(), false).excute() == 0) {
            LogX.i("retryInstallSSD success");
            retryInstallApplet(queryOrder);
        } else {
            LogX.e("retryInstallSSD fail!");
            this.mResultHandler.handleResult(IssueTrafficCardCallback.RETURN_FAILED_ISSUE_CARD_INNER_ERROR, 10001, null);
        }
    }

    private boolean queryOrders() {
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        QueryOrderRequest queryOrderRequest = new QueryOrderRequest(this.mInfo.getIssuerId(), this.cplc, this.mInfo.getAid(), instance.getDeviceModel(), instance.getBusChipManu());
        queryOrderRequest.setAccountUserId(((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID());
        queryOrderRequest.setOrderStatus("1");
        QueryOrderResponse queryOrder = SPIServiceFactory.createServerAccessService(this.mContext).queryOrder(queryOrderRequest);
        if (queryOrder.getResultCode() != 0) {
            LogX.e("queryOrder err : " + queryOrder.getResultCode() + ", desc : " + queryOrder.getResultDesc());
            if (handleCommenErr(queryOrder.getResultCode())) {
                return false;
            }
            reportErr(AutoReportErrorCode.ERROR_EVENT_ID_SA_QUERY_ORDER_FAILED, queryOrder.getResultCode(), "queryOrder err : " + queryOrder.getResultDesc());
            this.mResultHandler.handleResult(99, 10000, null);
            return false;
        }
        if (queryOrder.getOrderList() == null || queryOrder.getOrderList().isEmpty()) {
            LogX.i("QueryAndHandleUnfinishedOrdersSAOperator, there is no unfinished order!");
        } else {
            List<QueryOrder> orderList = queryOrder.getOrderList();
            if (orderList != null) {
                List arrayList = new ArrayList();
                boolean z = false;
                for (QueryOrder queryOrder2 : orderList) {
                    boolean z2;
                    if (QueryOrder.STATUS_RECHARGE_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_PERSONALIZED_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_DOWNLOAD_CAP_FAIL.equals(queryOrder2.getStatus()) || QueryOrder.STATUS_CREATE_SSD_FAIL.equals(queryOrder2.getStatus())) {
                        arrayList.add(queryOrder2);
                        if ("2".equals(queryOrder2.getOrderType()) || "0".equals(queryOrder2.getOrderType())) {
                            z2 = true;
                            z = z2;
                        }
                    }
                    z2 = z;
                    z = z2;
                }
                if (arrayList.size() > 0) {
                    LogX.i("QueryAndHandleUnfinishedOrdersSAOperator, there is unfinished orders, size = " + arrayList.size());
                    this.trafficOrder = new TrafficOrder();
                    this.trafficOrder.setQueryOrders(arrayList);
                    this.trafficOrder.setHasUnusedIssueOrder(z);
                }
            }
        }
        return true;
    }

    private boolean handleCommenErr(int i) {
        boolean z = true;
        int i2 = 99;
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
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.mResultHandler.handleResult(i2, 10000, null);
        }
        return z;
    }

    private void reportErr(int i, int i2, String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i2));
        hashMap.put("issuerID", String.valueOf(this.mInfo.getIssuerId()));
        LogX.e(i, hashMap, "ApplyPayOrderOperator err : " + str, false, false);
    }
}
