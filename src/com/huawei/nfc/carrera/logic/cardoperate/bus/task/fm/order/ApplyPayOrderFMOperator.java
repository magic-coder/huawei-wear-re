package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.order;

import android.content.Context;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosPayOrder;
import cn.com.fmsh.util.FM_Bytes;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.PayInfo;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.ApplyPayOrderResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.util.ActCodeBuilder;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyIssueOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyRechargeOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.MainOrderResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.wxpay.WXPayInfo;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ApplyPayOrderFMOperator {
    private static final int LIMITED_BALANCE = 100000;
    private double mAmount;
    private Context mContext;
    private IssuerInfoItem mInfo;
    private int mOrderType;
    private int mPayType;
    private String mProductCode;
    private ApplyPayOrderResultHandler mResultHandler;

    public ApplyPayOrderFMOperator(Context context, double d, int i, int i2, IssuerInfoItem issuerInfoItem, String str, ApplyPayOrderResultHandler applyPayOrderResultHandler) {
        this.mContext = context;
        this.mAmount = d;
        this.mOrderType = i;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = applyPayOrderResultHandler;
        this.mProductCode = str;
        this.mPayType = i2;
        LogX.i("ApplyPayOrderFMOperator mAmount : " + this.mAmount + "; mOrderType : " + this.mOrderType + " ; mProductCode : " + this.mProductCode + " ; mPayType : " + this.mPayType);
    }

    public void applyPayOrder() {
        boolean z = true;
        LogX.i("ApplyPayOrderFMOperator applyPayOrder begin");
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(productId, true)) {
            LogX.e("ApplyPayOrderFMOperator applyPayOrder, empty productId");
            this.mResultHandler.handleResult(10, null);
            return;
        }
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            LogX.e("ApplyPayOrderFMOperator applyPayOrder, item == null");
            this.mResultHandler.handleResult(99, null);
            return;
        }
        if (!(this.mOrderType == 1 || this.mOrderType == 3)) {
            z = false;
        }
        if (z) {
            applyIssuerOrder(cacheCardProductInfoItem, this.mPayType);
        } else {
            applyRechargeOrder(cacheCardProductInfoItem, this.mPayType);
        }
        LogX.i("ApplyPayOrderFMOperator applyPayOrder end");
    }

    private double getRechargeAmountByOrderAmount(double d, CardProductInfoItem cardProductInfoItem) {
        if (cardProductInfoItem.getRechargeDiscountAmounts() == null || cardProductInfoItem.getCommonRechargeAmounts() == null) {
            LogX.e("ApplyPayOrderFMOperator getRechargeAmountByOrderAmount, empty item.rechargeDiscountAmounts or item.commonRechargeAmounts");
            return -1.0d;
        }
        int i = 0;
        double d2 = -1.0d;
        while (i < cardProductInfoItem.getRechargeDiscountAmounts().length) {
            try {
                double doubleValue = Double.valueOf(cardProductInfoItem.getRechargeDiscountAmounts()[i]).doubleValue();
                if (Double.compare(d, doubleValue) == 0) {
                    return Double.valueOf(cardProductInfoItem.getCommonRechargeAmounts()[i]).doubleValue();
                }
                i++;
                d2 = doubleValue;
            } catch (NumberFormatException e) {
                LogX.e("ApplyPayOrderFMOperator getRechargeAmountByOrderAmount, NumberFormatException");
                return -1.0d;
            }
        }
        return d2;
    }

    private void applyIssuerOrder(CardProductInfoItem cardProductInfoItem, int i) {
        LogX.i("ApplyPayOrderFMOperator applyIssuerOrder begin, item.issueCardActCd=" + cardProductInfoItem.getIssueCardActCd());
        byte[] querySeid = ESEApiFactory.createESEInfoManagerApi(this.mContext).querySeid();
        String aid = this.mInfo.getAid();
        int i2 = (int) (this.mAmount * 100.0d);
        byte[] buildServiceCode = new ActCodeBuilder(this.mContext, cardProductInfoItem.getIssueCardActCd(), i2, cardProductInfoItem.getIssueCardStdCost() * 100, cardProductInfoItem.getIssueCardDiscountCost() * 100, aid).buildServiceCode(1, aid);
        if (buildServiceCode == null || buildServiceCode.length == 0) {
            LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, empty actCode");
            this.mResultHandler.handleResult(11, null);
            return;
        }
        MainOrderResponse applyIssueOrderByproduct;
        LogX.i("ApplyPayOrderFMOperator issueCardActCd : " + cardProductInfoItem.getIssueCardActCd() + " issueCardStdCost " + cardProductInfoItem.getIssueCardStdCost() + " issueCardDiscountCost " + cardProductInfoItem.getIssueCardDiscountCost());
        LogX.i("ApplyPayOrderFMOperator applyIssuerOrder, actCode : " + FM_Bytes.bytesToHexString(buildServiceCode));
        String deviceModel = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceModel();
        String str = this.mProductCode;
        int i3 = 0;
        if (i == 1) {
            i3 = 89;
        } else if (i == 2) {
            i3 = 9;
        }
        LogX.i("applyIssuerOrder  myAid : " + aid + " ; mode : " + i3);
        if (Constant.LNT_CARD_AID.equals(aid)) {
            applyIssueOrderByproduct = SPIServiceFactory.createFMService(this.mContext, aid).applyIssueOrderByproduct(ApplyIssueOrderRequest.build(str, querySeid, deviceModel, buildServiceCode, aid), i3);
        } else {
            applyIssueOrderByproduct = SPIServiceFactory.createFMService(this.mContext, aid).applyIssueOrder(ApplyIssueOrderRequest.build(i2, querySeid, deviceModel, buildServiceCode, aid), i3);
        }
        LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, response.resultCode =" + applyIssueOrderByproduct.resultCode);
        if (applyIssueOrderByproduct.resultCode == 0) {
            if (applyIssueOrderByproduct.order != null) {
                PayInfo build;
                WXPayInfo wXPayInfo;
                if (applyIssueOrderByproduct.order.payOrders != null) {
                    for (NfcosPayOrder nfcosPayOrder : applyIssueOrderByproduct.order.payOrders) {
                        LogX.i("ApplyPayOrderFMOperator channel : " + nfcosPayOrder.channel);
                        if (nfcosPayOrder.channel == 89) {
                            build = PayInfo.build(nfcosPayOrder.thirdPayInfo);
                            wXPayInfo = null;
                            break;
                        } else if (nfcosPayOrder.channel == 9) {
                            wXPayInfo = WXPayInfo.build(nfcosPayOrder.thirdPayInfo);
                            build = null;
                            break;
                        } else {
                            LogX.i(" applyIssuerOrder payOrder channel else ");
                        }
                    }
                }
                wXPayInfo = null;
                build = null;
                if (build == null && wXPayInfo == null) {
                    LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, payInfo == null");
                    this.mResultHandler.handleResult(99, null);
                    return;
                }
                TrafficOrder trafficOrder = new TrafficOrder();
                trafficOrder.setNfcosMainOrder(applyIssueOrderByproduct.order);
                trafficOrder.setPayInfo(build);
                trafficOrder.setPayType(this.mPayType);
                trafficOrder.setWXPayInfo(wXPayInfo);
                this.mResultHandler.handleResult(0, trafficOrder);
                return;
            }
            LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, esponse.order == null");
            this.mResultHandler.handleResult(99, null);
        } else if (applyIssueOrderByproduct.resultCode == 1) {
            LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, EXIST_HAS_PAIED_ORDER");
            r0 = new HashMap();
            deviceModel = "ApplyPayOrderFMOperator applyIssuerOrder, EXIST_HAS_PAIED_ORDER";
            r0.put(ShowBindBusResultActivity.FAIL_REASON_KEY, deviceModel);
            r0.put(CloudEyeLogger.FAIL_CODE, String.valueOf(applyIssueOrderByproduct.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_APPLY_ORDER_FAIL, r0, deviceModel, false, false);
            queryHasPaiedIssueOrder();
        } else if (applyIssueOrderByproduct.resultCode == -2) {
            LogX.e("ApplyPayOrderFMOperator applyIssuerOrder, NETWORK_ERROR");
            this.mResultHandler.handleResult(11, null);
        } else {
            r0 = new HashMap();
            deviceModel = "ApplyPayOrderFMOperator applyIssuerOrder fail";
            r0.put(ShowBindBusResultActivity.FAIL_REASON_KEY, deviceModel);
            r0.put(CloudEyeLogger.FAIL_CODE, String.valueOf(applyIssueOrderByproduct.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_APPLY_ORDER_FAIL, r0, deviceModel, false, false);
            this.mResultHandler.handleResult(99, null);
        }
    }

    private void queryHasPaiedIssueOrder() {
        LogX.i("ApplyPayOrderFMOperator queryHasPaiedIssueOrder begin");
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(0, new int[]{2}, 2, ESEApiFactory.createESEInfoManagerApi(this.mContext).querySeid(), this.mInfo.getAid());
        LogX.i("queryHasPaiedIssueOrder  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        if (queryBusinessOrders.resultCode == 0) {
            if (!(queryBusinessOrders.orderList == null || queryBusinessOrders.orderList.isEmpty())) {
                TrafficOrder trafficOrder = new TrafficOrder();
                trafficOrder.setNfcosMainOrder(null);
                trafficOrder.setHasUnusedIssueOrder(true);
                trafficOrder.setNfcosBusinessOrder((NfcosBusinessOrder) queryBusinessOrders.orderList.get(0));
                this.mResultHandler.handleResult(0, trafficOrder);
                return;
            }
        } else if (queryBusinessOrders.resultCode == -2) {
            LogX.e("ApplyPayOrderFMOperator queryHasPaiedIssueOrder, NETWORK_ERROR");
            this.mResultHandler.handleResult(11, null);
            return;
        }
        Map hashMap = new HashMap();
        String str = "ApplyPayOrderFMOperator queryHasPaiedIssueOrder fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryBusinessOrders.FMCode));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_QUERY_UNFINISHED_ORDERS_FAIL, hashMap, str, false, false);
        this.mResultHandler.handleResult(99, null);
    }

    protected void applyRechargeOrder(CardProductInfoItem cardProductInfoItem, int i) {
        LogX.i("ApplyPayOrderFMOperator applyRechargeOrder begin, item.rechargeActCd=" + cardProductInfoItem.getRechargeActCd());
        if (!checkUnfinishedOrders()) {
            LogX.i("ApplyPayOrderFMOperator applyRechargeOrder, checkUnfinishedOrders fail");
        } else if (checkBalance(cardProductInfoItem)) {
            ApplyRechargeOrderRequest applyRechargeOrderRequest = new ApplyRechargeOrderRequest();
            applyRechargeOrderRequest.setActCode(new ActCodeBuilder(this.mContext, cardProductInfoItem.getRechargeActCd()).buildServiceCode(2, this.mInfo.getAid()));
            if (applyRechargeOrderRequest.getActCode() == null || applyRechargeOrderRequest.getActCode().length == 0) {
                LogX.e("ApplyPayOrderFMOperator applyRechargeOrder, empty actCode");
                this.mResultHandler.handleResult(11, null);
                return;
            }
            int i2;
            if (i == 1) {
                if (Constant.SH_CARD_AID.equals(this.mInfo.getAid())) {
                    i2 = 69;
                } else {
                    i2 = 89;
                }
            } else if (i != 2) {
                i2 = 0;
            } else if (Constant.SH_CARD_AID.equals(this.mInfo.getAid())) {
                i2 = 8;
            } else {
                i2 = 9;
            }
            applyRechargeOrderRequest.setAmount((int) (this.mAmount * 100.0d));
            applyRechargeOrderRequest.setAid(this.mInfo.getAid());
            LogX.i("applyRechargeOrder  myAid : " + this.mInfo.getAid() + " ; mode : " + i2);
            MainOrderResponse applyRechargeOrder = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).applyRechargeOrder(applyRechargeOrderRequest, i2);
            LogX.i("payOrder.response.resultCode : " + applyRechargeOrder.resultCode);
            if (applyRechargeOrder.resultCode == 0) {
                if (applyRechargeOrder.order != null) {
                    PayInfo build;
                    WXPayInfo wXPayInfo;
                    LogX.i("response.order != null");
                    if (applyRechargeOrder.order.payOrders != null) {
                        LogX.i("response.order.payOrders != null");
                        for (NfcosPayOrder nfcosPayOrder : applyRechargeOrder.order.payOrders) {
                            LogX.i("payOrder.channel : " + nfcosPayOrder.channel);
                            if (nfcosPayOrder.channel == 89 || nfcosPayOrder.channel == 69) {
                                LogX.i("ISSUE_MODE_HW payOrder.thirdPayInfo : " + nfcosPayOrder.thirdPayInfo);
                                build = PayInfo.build(nfcosPayOrder.thirdPayInfo);
                                wXPayInfo = null;
                                break;
                            } else if (nfcosPayOrder.channel == 8 || nfcosPayOrder.channel == 9) {
                                LogX.i("CARD_MODE_WX payOrder.thirdPayInfo : " + nfcosPayOrder.thirdPayInfo);
                                wXPayInfo = WXPayInfo.build(nfcosPayOrder.thirdPayInfo);
                                build = null;
                                break;
                            } else {
                                LogX.i(" applyRechargeOrder payOrder channel else ");
                            }
                        }
                    }
                    wXPayInfo = null;
                    build = null;
                    if (build == null && wXPayInfo == null) {
                        LogX.e("ApplyPayOrderFMOperator applyRechargeOrder, payInfo == null");
                        this.mResultHandler.handleResult(99, null);
                        return;
                    }
                    TrafficOrder trafficOrder = new TrafficOrder();
                    trafficOrder.setNfcosMainOrder(applyRechargeOrder.order);
                    trafficOrder.setPayType(this.mPayType);
                    trafficOrder.setPayInfo(build);
                    trafficOrder.setWXPayInfo(wXPayInfo);
                    this.mResultHandler.handleResult(0, trafficOrder);
                    return;
                }
                LogX.e("ApplyPayOrderFMOperator applyRechargeOrder, response.order == null");
                this.mResultHandler.handleResult(99, null);
            } else if (applyRechargeOrder.resultCode == -2) {
                LogX.e("ApplyPayOrderFMOperator applyRechargeOrder, NETWORK_ERROR");
                this.mResultHandler.handleResult(11, null);
            } else {
                Map hashMap = new HashMap();
                String str = "ApplyPayOrderFMOperator applyRechargeOrder fail";
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(applyRechargeOrder.FMCode));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_APPLY_ORDER_FAIL, hashMap, str, false, false);
                this.mResultHandler.handleResult(99, null);
            }
        } else {
            LogX.i("ApplyPayOrderFMOperator applyRechargeOrder, checkBalance fail");
        }
    }

    private boolean checkBalance(CardProductInfoItem cardProductInfoItem) {
        LogX.i("checkBalance  myAid : " + this.mInfo.getAid());
        QueryCardInfoResponse queryCardInfo = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryCardInfo(2, this.mInfo.getAid());
        if (queryCardInfo.resultCode == 0) {
            if ((getRechargeAmountByOrderAmount(this.mAmount, cardProductInfoItem) * 100.0d) + ((double) queryCardInfo.getBalance()) <= 100000.0d) {
                return true;
            }
            LogX.i("ApplyPayOrderFMOperator checkBalance, LIMITED_BALANCE");
            this.mResultHandler.handleResult(1001, null);
            return false;
        }
        Map hashMap = new HashMap();
        String str = "ApplyPayOrderFMOperator checkBalance, query balance fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryCardInfo.FMCode));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_CARD_INFO_FAIL, hashMap, str, false, false);
        this.mResultHandler.handleResult(99, null);
        LogX.i("ApplyPayOrderFMOperator checkBalance," + queryCardInfo.getBalance());
        return false;
    }

    private boolean checkUnfinishedOrders() {
        LogX.i("ApplyPayOrderFMOperator checkUnfinishedOrders begin");
        if (!handleUnknownRechargeOrder()) {
            LogX.e("ApplyPayOrderFMOperator checkUnfinishedOrders, handleUnknownRechargeOrder fail");
            this.mResultHandler.handleResult(1002, null);
            return false;
        } else if (handleUnfinishedOrders()) {
            LogX.i("ApplyPayOrderFMOperator checkUnfinishedOrders end");
            return true;
        } else {
            LogX.e("ApplyPayOrderFMOperator checkUnfinishedOrders, handleUnfinishedOrders fail");
            this.mResultHandler.handleResult(1002, null);
            return false;
        }
    }

    private boolean handleUnknownRechargeOrder() {
        ArrayList queryAllUnknownOrders = queryAllUnknownOrders(0);
        RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
        Iterator it = queryAllUnknownOrders.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            rechargeOrDoUnsolvedOrderRequest.setOrder(((NfcosBusinessOrder) it.next()).order);
            rechargeOrDoUnsolvedOrderRequest.setAid(this.mInfo.getAid());
            LogX.i("handleUnknownRechargeOrder  myAid : " + this.mInfo.getAid());
            FMBaseResponse doUnsolvedOrder = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).doUnsolvedOrder(rechargeOrDoUnsolvedOrderRequest);
            if (doUnsolvedOrder.resultCode != 0) {
                i2 = i + 1;
                Map hashMap = new HashMap();
                String str = "ApplyPayOrderFMOperator handleUnknownRechargeOrder fail, num=" + i2;
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(doUnsolvedOrder.FMCode));
                hashMap.put("order_id", Arrays.toString(rechargeOrDoUnsolvedOrderRequest.getOrder()));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_DO_UNSOLVED_ORDERS_FAIL, hashMap, str, false, false);
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 0) {
            return false;
        }
        return true;
    }

    private ArrayList<NfcosBusinessOrder> queryAllUnknownOrders(int i) {
        ArrayList<NfcosBusinessOrder> arrayList = new ArrayList();
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(i, new int[]{5}, 1, null, this.mInfo.getAid());
        LogX.i("queryAllUnknownOrders  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        if (queryBusinessOrders.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "ApplyPayOrderFMOperator queryAllUnknownOrders fail";
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

    private boolean handleUnfinishedOrders() {
        int balance;
        LogX.i("handleUnfinishedOrders  myAid : " + this.mInfo.getAid());
        QueryCardInfoResponse queryCardInfo = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryCardInfo(2, this.mInfo.getAid());
        if (queryCardInfo.resultCode == 0) {
            balance = queryCardInfo.getBalance();
        } else {
            Map hashMap = new HashMap();
            String str = "ApplyPayOrderFMOperator handleUnfinishedOrders, query balance fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryCardInfo.FMCode));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_CARD_INFO_FAIL, hashMap, str, false, false);
            balance = 0;
        }
        List queryAllUnfinishedOrders = queryAllUnfinishedOrders(0);
        int size = queryAllUnfinishedOrders.size();
        int i = 0;
        int i2 = 0;
        int i3 = balance;
        while (i < size) {
            NfcosBusinessOrder nfcosBusinessOrder = ((TrafficOrder) queryAllUnfinishedOrders.get(i)).getNfcosBusinessOrder();
            if (nfcosBusinessOrder == null || nfcosBusinessOrder.businessOrderType != 1) {
                LogX.e("ApplyPayOrderFMOperator handleUnfinishedOrders, illegal rechargeOrder");
                balance = i2;
                i2 = i3;
            } else if (nfcosBusinessOrder.amount + i3 > 100000) {
                Map hashMap2 = new HashMap();
                str = "ApplyPayOrderFMOperator handleUnfinishedOrders, LIMITED_BALANCE";
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_RECHARGE_FAIL, hashMap2, str, false, false);
                break;
            } else {
                RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
                rechargeOrDoUnsolvedOrderRequest.setOrder(nfcosBusinessOrder.order);
                rechargeOrDoUnsolvedOrderRequest.setAid(this.mInfo.getAid());
                LogX.i("handleUnfinishedOrdersaa  myAid : " + this.mInfo.getAid());
                FMBaseResponse recharge = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).recharge(rechargeOrDoUnsolvedOrderRequest);
                if (recharge.resultCode == 0) {
                    balance = i2 + 1;
                    i2 = nfcosBusinessOrder.amount + i3;
                } else {
                    Map hashMap3 = new HashMap();
                    String str2 = "ApplyPayOrderFMOperator handleUnfinishedOrders, recharge fail";
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
        if (i2 != size) {
            return false;
        }
        LogX.i("ApplyPayOrderFMOperator handleUnfinishedOrders, handledCnt == len");
        return true;
    }

    private ArrayList<TrafficOrder> queryAllUnfinishedOrders(int i) {
        ArrayList<TrafficOrder> arrayList = new ArrayList();
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(i, new int[]{2, 4}, 1, null, this.mInfo.getAid());
        LogX.i("queryAllUnfinishedOrders  myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        if (queryBusinessOrders.resultCode != 0) {
            Map hashMap = new HashMap();
            String str = "ApplyPayOrderFMOperator queryAllUnfinishedOrders, query orders fail";
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
}
