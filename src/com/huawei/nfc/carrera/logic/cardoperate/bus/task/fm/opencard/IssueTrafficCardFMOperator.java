package com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.opencard;

import android.content.Context;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateSSDTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.UpdateAppletTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.fm.request.DoIssueRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IssueTrafficCardFMOperator {
    private final Context mContext;
    private final IssuerInfoItem mInfo;
    private final TrafficOrder mOrder;
    private final IssueTrafficCardResultHandler mResultHandler;

    public IssueTrafficCardFMOperator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mOrder = trafficOrder;
        this.mResultHandler = issueTrafficCardResultHandler;
    }

    public int issueTrafficCard() {
        LogX.i("IssueTrafficCardFMOperator issueTrafficCard begin");
        String aid = this.mInfo.getAid();
        if (StringUtil.isEmpty(aid, true)) {
            LogX.e("IssueTrafficCardFMOperator issueTrafficCard, empty aid");
            handleResult(10);
            return 10;
        }
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(aid);
        if (card == null) {
            LogX.e("IssueTrafficCardFMOperator issueTrafficCard, empty taInfo");
            handleResult(10);
            return 10;
        }
        if (card.isCardStatusPayedNotOpened()) {
            checkOrder(card);
        }
        int createDMSD;
        if (card.isCardStatusPayedNotOpened()) {
            createDMSD = createDMSD(aid);
            if (createDMSD != 0) {
                LogX.e("IssueTrafficCardFMOperator issueTrafficCard, createDMSD fail result=" + createDMSD);
                return createDMSD;
            }
            LogX.e("IssueTrafficCardFMOperator issueTrafficCard, createDMSD success");
            createDMSD = installAndPersonalize(aid);
            if (createDMSD != 0) {
                LogX.e("IssueTrafficCardFMOperator issueTrafficCard, installAndPersonalize fail result=" + createDMSD);
                return createDMSD;
            }
            createDMSD = updateApplet(aid);
            if (createDMSD != 0) {
                LogX.e("IssueTrafficCardFMOperator issueTrafficCard, updateApplet fail result=" + createDMSD);
                return createDMSD;
            }
        } else if (card.cardStatus == 13) {
            createDMSD = updateApplet(aid);
            if (createDMSD != 0) {
                LogX.e("IssueTrafficCardFMOperator issueTrafficCard, updateApplet fail result=" + createDMSD);
                return createDMSD;
            }
            doRecharge();
        }
        report(aid, null, this.mInfo.getName(), card.getFpanFour(), card.getIssuerId(), card.getCardType());
        LogX.i("IssueTrafficCardFMOperator issueTrafficCard end");
        handleResult(0);
        return 0;
    }

    private int createDMSD(String str) {
        LogX.i("IssueTrafficCardFMOperator createDMSD begin");
        int excute = new CreateSSDTsmOperator(this.mContext, str, this.mInfo.getIssuerId()).excute();
        LogX.i("IssueTrafficCardFMOperator createDMSD result=" + excute);
        if (excute == 0) {
            return 0;
        }
        if (-1 == excute) {
            LogX.e("IssueTrafficCardFMOperator createDMSD, no network");
            handleResult(11);
            return 11;
        }
        Map hashMap = new HashMap();
        String str2 = "IssueTrafficCardFMOperator createDMSD fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_INSTALL_DMSD_FAIL, hashMap, str2, false, false);
        handleResult(99);
        return 99;
    }

    private TACardInfo generateTaCardInfo(String str, int i, String str2, String str3, String str4) {
        return new TACardInfo(str, str3, str2, 2, false, null, str4, str, null, i, System.currentTimeMillis(), 11, this.mInfo.getName(), str3 + CardPicPathConfig.WALLET_CARD_STORAGE_NAME, 0, str3 + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME, 0);
    }

    private void handleResult(int i) {
        if (this.mResultHandler != null) {
            this.mResultHandler.handleResult(i);
        }
    }

    private int installAndPersonalize(String str) {
        LogX.i("IssueTrafficCardFMOperator installAndPersonalize begin");
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(str);
        if (cardInfoByAid == null || !(cardInfoByAid.cardStatus == 11 || cardInfoByAid.cardStatus == 12)) {
            LogX.e("IssueTrafficCardFMOperator installAndPersonalize, illegal ta card info");
            handleResult(99);
            return 99;
        }
        NfcosBusinessOrder nfcosOrder = this.mOrder.getNfcosOrder(2);
        if (nfcosOrder == null) {
            LogX.e("IssueTrafficCardFMOperator installAndPersonalize, issueOrder == null");
            handleResult(99);
            return 99;
        }
        LogX.d(" CardEvent installAndPersonalizeApplet bus cardEvent START_LOCK");
        WalletTaManager.getInstance(this.mContext).lockCardEvent(str);
        LogX.i("installAndPersonalize  myAid : " + this.mInfo.getAid());
        FMBaseResponse installAndPersonalizeApplet = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).installAndPersonalizeApplet(DoIssueRequest.build(nfcosOrder.order, ESEApiFactory.createESEInfoManagerApi(this.mContext).querySeid()));
        if (installAndPersonalizeApplet.resultCode == 0) {
            try {
                WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 13);
                return 0;
            } catch (WalletTaException e) {
                LogX.e("IssueTrafficCardFMOperator installAndPersonalize, WalletTaException");
                handleResult(99);
                return 99;
            }
        } else if (installAndPersonalizeApplet.resultCode == -2) {
            LogX.e("IssueTrafficCardFMOperator installAndPersonalize, NETWORK_ERROR");
            handleResult(11);
            return 11;
        } else {
            Map hashMap = new HashMap();
            String str2 = "IssueTrafficCardFMOperator installAndPersonalize fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(installAndPersonalizeApplet.FMCode));
            hashMap.put("order_id", Arrays.toString(nfcosOrder.order));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_ISSUE_CARD_FAIL, hashMap, str2, false, false);
            handleResult(99);
            return 99;
        }
    }

    private int updateApplet(String str) {
        LogX.i("IssueTrafficCardFMOperator updateApplet begin");
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(str);
        if (cardInfoByAid == null || cardInfoByAid.cardStatus != 13) {
            LogX.e("IssueTrafficCardFMOperator updateApplet, illegal ta card info");
            handleResult(99);
            return 99;
        }
        UpdateAppletTsmOperator updateAppletTsmOperator = new UpdateAppletTsmOperator(this.mContext, str);
        updateAppletTsmOperator.setIssuerId(this.mInfo.getIssuerId());
        int excute = updateAppletTsmOperator.excute();
        LogX.i("IssueTrafficCardFMOperator updateApplet response=" + excute);
        if (excute == 0) {
            String cardNum = getCardNum();
            TACardInfo generateTaCardInfo = generateTaCardInfo(str, 2, cardInfoByAid.issuerId, cardInfoByAid.productId, cardNum);
            generateTaCardInfo.setName(this.mInfo.getName());
            LogX.i("IssueTrafficCardFMOperator updateApplet name=" + generateTaCardInfo.name);
            if (WalletTaManager.getInstance(this.mContext).updateCardInfo(generateTaCardInfo)) {
                return 0;
            }
            handleResult(99);
            return 99;
        } else if (-1 == excute) {
            LogX.e("IssueTrafficCardFMOperator updateApplet, no network");
            handleResult(11);
            return 11;
        } else {
            Map hashMap = new HashMap();
            String str2 = "IssueTrafficCardFMOperator updateApplet fail";
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_UPDATE_APPLET_FAIL, hashMap, str2, false, false);
            handleResult(99);
            return 99;
        }
    }

    private String getCardNum() {
        LogX.i("getCardNum  myAid : " + this.mInfo.getAid());
        QueryCardInfoResponse queryCardInfo = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryCardInfo(1, this.mInfo.getAid());
        if (queryCardInfo.resultCode == 0) {
            return queryCardInfo.getCardNo();
        }
        Map hashMap = new HashMap();
        String str = "IssueTrafficCardFMOperator getCardNum fail";
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(queryCardInfo.FMCode));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_FM_READ_CARD_INFO_FAIL, hashMap, str, false, false);
        return null;
    }

    private void report(String str, String str2, String str3, String str4, String str5, int i) {
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(str, str2, str3, str4, str5, i);
        NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str, str3, str5, i);
    }

    private void checkOrder(TACardInfo tACardInfo) {
        LogX.i("IssueTrafficCardFMOperator checkOrder begin");
        NfcosBusinessOrder nfcosOrder = this.mOrder.getNfcosOrder(2);
        if (nfcosOrder == null) {
            LogX.i("IssueTrafficCardFMOperator issueOrder is null !");
            return;
        }
        LogX.i("IssueTrafficCardFMOperator checkOrder issueOrder.tradeState : " + nfcosOrder.tradeState);
        if (nfcosOrder.tradeState == 3) {
            LogX.i("IssueTrafficCardFMOperator checkOrder, update ta status");
            try {
                WalletTaManager.getInstance(this.mContext).updateCardStatus(tACardInfo.getAid(), 13);
                tACardInfo.setCardStatus(13);
            } catch (WalletTaException e) {
                LogX.e("IssueTrafficCardFMOperator checkOrder, WalletTaException");
            }
        }
    }

    public void doRecharge() {
        LogX.i("IssueTrafficCardFMOperator doRecharge begin");
        QueryBusinessOrdersRequest build = QueryBusinessOrdersRequest.build(0, new int[]{2}, 1, null, this.mInfo.getAid());
        LogX.i("doRecharge myAid : " + this.mInfo.getAid());
        QueryBusinessOrdersResponse queryBusinessOrders = SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).queryBusinessOrders(build);
        if (queryBusinessOrders.resultCode == 0 && queryBusinessOrders.orderList != null) {
            LogX.d("IssueTrafficCardFMOperator doRecharge size=" + queryBusinessOrders.orderList.size());
            Iterator it = queryBusinessOrders.orderList.iterator();
            while (it.hasNext()) {
                NfcosBusinessOrder nfcosBusinessOrder = (NfcosBusinessOrder) it.next();
                RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest = new RechargeOrDoUnsolvedOrderRequest();
                rechargeOrDoUnsolvedOrderRequest.setOrder(nfcosBusinessOrder.order);
                rechargeOrDoUnsolvedOrderRequest.setAid(this.mInfo.getAid());
                LogX.i("doRecharge d myAid : " + this.mInfo.getAid());
                if (SPIServiceFactory.createFMService(this.mContext, this.mInfo.getAid()).recharge(rechargeOrDoUnsolvedOrderRequest).resultCode == 0) {
                    LogX.d("IssueTrafficCardFMOperator doRecharge success");
                }
            }
        }
    }
}
