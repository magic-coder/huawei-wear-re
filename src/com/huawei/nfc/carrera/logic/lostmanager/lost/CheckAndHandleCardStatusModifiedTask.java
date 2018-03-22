package com.huawei.nfc.carrera.logic.lostmanager.lost;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.lostmanager.callback.CheckDeviceStatusCallback;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardStatusQueryRequest;
import com.huawei.nfc.carrera.server.card.response.CardStatusItem;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.List;

public class CheckAndHandleCardStatusModifiedTask implements Runnable {
    private static final String TAG = "CheckAndHandleCardStatusModifiedTask";
    private final CheckDeviceStatusCallback mCallback;
    private final Context mContext;

    public CheckAndHandleCardStatusModifiedTask(Context context, CheckDeviceStatusCallback checkDeviceStatusCallback) {
        this.mContext = context;
        this.mCallback = checkDeviceStatusCallback;
    }

    public void run() {
        C2538c.b(TAG, new Object[]{"== card status Enter CheckAndHandleCardStatusModifiedTask run "});
        CardStatusQueryResponse queryCardsStatus = queryCardsStatus();
        if (queryCardsStatus == null) {
            new HashMap().put(ShowBindBusResultActivity.FAIL_REASON_KEY, "CheckAndHandleCardStatusModifiedTask, response is null");
            C2538c.b("== card status null == serverQueryRespons", new Object[0]);
            return;
        }
        C2538c.b(TAG, new Object[]{"== card status null == serverQueryRespons,serverQueryResponse.returnCode=" + queryCardsStatus.returnCode});
        if (-4 == queryCardsStatus.returnCode) {
            new HashMap().put(ShowBindBusResultActivity.FAIL_REASON_KEY, "queryCardsStatus retrun code server overload");
            C2538c.e(TAG, new Object[]{Integer.valueOf(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_OVERLOAD_ERR), new HashMap(), "queryCardsStatus retrun code server overload", Boolean.valueOf(false), Boolean.valueOf(false)});
        } else if (queryCardsStatus.returnCode != 0) {
            new HashMap().put(ShowBindBusResultActivity.FAIL_REASON_KEY, "query card status from server failed.");
            C2538c.e(TAG, new Object[]{Integer.valueOf(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR), new HashMap(), "query card status from server failed.", Boolean.valueOf(false), Boolean.valueOf(false)});
        } else {
            C2538c.b(TAG, new Object[]{"== card status query response : " + queryCardsStatus.getDevStatus() + ",card count: " + queryCardsStatus.getCardCount()});
            if ("2".equals(queryCardsStatus.getDevStatus())) {
                new DeleteAllLocalCardsTask(this.mContext, 1, null).run();
            } else if ("4".equals(queryCardsStatus.getDevStatus())) {
                C2538c.b(TAG, new Object[]{"== card status dev status queried from server: dev repair."});
                if (this.mCallback != null) {
                    this.mCallback.checkDeviceStatusCallback("4");
                }
            } else {
                updateCardState(queryCardsStatus);
            }
        }
    }

    private void updateCardState(CardStatusQueryResponse cardStatusQueryResponse) {
        List<CardStatusItem> items = cardStatusQueryResponse.getItems();
        if (items == null || items.isEmpty()) {
            C2538c.b(TAG, new Object[]{"== card status no server card status queried."});
            return;
        }
        for (CardStatusItem cardStatusItem : items) {
            C2538c.b(TAG, new Object[]{"== card status server card list, aid:" + cardStatusItem.getAid() + ", status:" + cardStatusItem.getStatus() + ", dpanid:" + cardStatusItem.getDpanid() + ", userid:" + cardStatusItem.getUserID(), Boolean.valueOf(true)});
            CardLostManager.getInstance(this.mContext).handleServerCardLostMessage(cardStatusItem.getAid(), cardStatusItem.getStatus(), cardStatusItem.getCplc(), cardStatusItem.getDpanid(), null);
        }
    }

    private CardStatusQueryResponse queryCardsStatus() {
        C2538c.b(TAG, new Object[]{"== card status queryCardsStatus"});
        CardStatusQueryRequest cardStatusQueryRequest = new CardStatusQueryRequest();
        cardStatusQueryRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        cardStatusQueryRequest.imei = ESEApiFactory.createESEInfoManagerApi(this.mContext).getDeviceSN();
        cardStatusQueryRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardStatusQueryRequest.setRsaKeyIndex(-1);
        cardStatusQueryRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return ServerServiceFactory.createCardServerApi(this.mContext).queryCardStatus(cardStatusQueryRequest);
    }
}
