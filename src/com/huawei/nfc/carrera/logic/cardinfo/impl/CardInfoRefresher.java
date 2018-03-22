package com.huawei.nfc.carrera.logic.cardinfo.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryBankIssuerInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryPayableCardCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportBankInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QuerySupportedTrafficCardListCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.QueryTrafficCardInfoCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.SyncRFConfFilesCallback;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankCardInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.BankIssuerInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportNFCBankInfo;
import com.huawei.nfc.carrera.logic.cardinfo.model.SupportedTrafficCardListItem;
import com.huawei.nfc.carrera.logic.cardinfo.model.TrafficCardInfo;
import com.huawei.wallet.model.unicard.UniCardInfo;
import com.huawei.wallet.ui.carddisplay.CardListInfoListener;
import java.util.List;
import java.util.Map;

public class CardInfoRefresher extends Handler {
    private static final int HANDLER_BANK_QUERY_BANK_CARD_RESULT = 303;
    private static final int HANDLER_BANK_QUERY_BANK_ISSUERINFO_RESULT = 302;
    private static final int HANDLER_BANK_QUERY_SUPPORTED_CARD_RESULT = 301;
    private static final int HANDLER_QUERY_PAYABLE_CARD_RESULT = 2;
    private static final int HANDLER_TAG_BANK_CARD_RESULT = 300;
    private static final int HANDLER_TAG_TRAFFIC_CARD_RESULT = 200;
    private static final int HANDLER_TRAFFIC_QUERY_CARDINFO_RESULT = 202;
    private static final int HANDLER_TRAFFIC_QUERY_SUPPORTED_CARDS_RESULT = 201;
    private static final int HANDLER_TRAFFIC_SYNC_RFCONF_RESULT = 203;
    private static final Object listInfoListenersLock = new Object();
    private CardListInfoListener listInfoListener;

    public CardInfoRefresher(Looper looper) {
        super(looper);
    }

    void addCardListInfoListener(CardListInfoListener cardListInfoListener) {
        synchronized (listInfoListenersLock) {
            this.listInfoListener = cardListInfoListener;
        }
    }

    void removeCardListInfoListener(CardListInfoListener cardListInfoListener) {
        synchronized (listInfoListenersLock) {
            if (this.listInfoListener != null && this.listInfoListener == cardListInfoListener) {
                this.listInfoListener = null;
            }
        }
    }

    void cardListRefreshed(final List<UniCardInfo> list) {
        post(new Runnable() {
            public void run() {
                CardInfoRefresher.this.refreshCardListInfos(list);
            }
        });
    }

    void cardListRefreshFailed(final int i) {
        post(new Runnable() {
            public void run() {
                CardInfoRefresher.this.refreshCardListFailed(i);
            }
        });
    }

    private void refreshCardListInfos(List<UniCardInfo> list) {
        synchronized (listInfoListenersLock) {
            if (this.listInfoListener != null) {
                this.listInfoListener.mo5165a(1, list);
            }
        }
    }

    private void refreshCardListFailed(int i) {
        synchronized (listInfoListenersLock) {
            if (this.listInfoListener != null) {
                this.listInfoListener.mo5164a(i);
            }
        }
    }

    public void handleQuerySupportedTrafficCardsResult(Map<String, SupportedTrafficCardListItem> map, QuerySupportedTrafficCardListCallback querySupportedTrafficCardListCallback) {
        Message obtain = Message.obtain(this, 200);
        obtain.arg1 = 201;
        obtain.obj = new Object[]{querySupportedTrafficCardListCallback, map};
        obtain.sendToTarget();
    }

    public void handleQueryPayableCardInfo(List<CardListItem> list, QueryPayableCardCallback queryPayableCardCallback) {
        Message obtain = Message.obtain(this, 2);
        obtain.obj = new Object[]{queryPayableCardCallback, list};
        obtain.sendToTarget();
    }

    public void handleQueryTrafficCardInfoResult(int i, TrafficCardInfo trafficCardInfo, QueryTrafficCardInfoCallback queryTrafficCardInfoCallback) {
        Message obtain = Message.obtain(this, 200);
        obtain.arg1 = 202;
        obtain.arg2 = i;
        obtain.obj = new Object[]{queryTrafficCardInfoCallback, trafficCardInfo};
        obtain.sendToTarget();
    }

    public void handleQuerySupportedBankCardInfoResult(Map<String, SupportNFCBankInfo> map, QuerySupportBankInfoCallback querySupportBankInfoCallback) {
        Message obtain = Message.obtain(this, 300);
        obtain.arg1 = 301;
        obtain.obj = new Object[]{querySupportBankInfoCallback, map};
        obtain.sendToTarget();
    }

    public void handleQueryBankIssuerInfoResult(int i, BankIssuerInfo bankIssuerInfo, QueryBankIssuerInfoCallback queryBankIssuerInfoCallback) {
        Message obtain = Message.obtain(this, 300);
        obtain.arg1 = 302;
        obtain.arg2 = i;
        obtain.obj = new Object[]{queryBankIssuerInfoCallback, bankIssuerInfo};
        obtain.sendToTarget();
    }

    public void handleQueryBankCardInfoResult(int i, BankCardInfo bankCardInfo, QueryBankCardInfoCallback queryBankCardInfoCallback) {
        Message obtain = Message.obtain(this, 300);
        obtain.arg1 = 303;
        obtain.arg2 = i;
        obtain.obj = new Object[]{queryBankCardInfoCallback, bankCardInfo};
        obtain.sendToTarget();
    }

    public void handleSyncRFConfFileResult(int i, String str, SyncRFConfFilesCallback syncRFConfFilesCallback) {
        Message obtain = Message.obtain(this, 200);
        obtain.arg1 = 203;
        obtain.arg2 = i;
        obtain.obj = new Object[]{syncRFConfFilesCallback, str};
        obtain.sendToTarget();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                Object[] objArr = (Object[]) message.obj;
                ((QueryPayableCardCallback) objArr[0]).queryPayableCardCallback((List) objArr[1]);
                return;
            case 200:
                handleTrafficCardMessage(message);
                return;
            case 300:
                handleBankCardMessage(message);
                return;
            default:
                return;
        }
    }

    private void handleBankCardMessage(Message message) {
        Object[] objArr;
        switch (message.arg1) {
            case 301:
                objArr = (Object[]) message.obj;
                ((QuerySupportBankInfoCallback) objArr[0]).queryResultCallback((Map) objArr[1]);
                return;
            case 302:
                objArr = (Object[]) message.obj;
                ((QueryBankIssuerInfoCallback) objArr[0]).queryBankIssuerInfoCallback(message.arg2, (BankIssuerInfo) objArr[1]);
                return;
            case 303:
                objArr = (Object[]) message.obj;
                ((QueryBankCardInfoCallback) objArr[0]).queryBankCardInfoCallback(message.arg2, (BankCardInfo) objArr[1]);
                return;
            default:
                return;
        }
    }

    private void handleTrafficCardMessage(Message message) {
        Object[] objArr;
        switch (message.arg1) {
            case 201:
                objArr = (Object[]) message.obj;
                ((QuerySupportedTrafficCardListCallback) objArr[0]).querySupportedTrafficCardListCallback((Map) objArr[1]);
                return;
            case 202:
                objArr = (Object[]) message.obj;
                ((QueryTrafficCardInfoCallback) objArr[0]).queryTrafficCardInfoCallback(message.arg2, (TrafficCardInfo) objArr[1]);
                return;
            case 203:
                objArr = (Object[]) message.obj;
                ((SyncRFConfFilesCallback) objArr[0]).syncRFConfFilesResult((String) objArr[1], message.arg2);
                return;
            default:
                return;
        }
    }
}
