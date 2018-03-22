package com.huawei.nfc.carrera.logic.swipe;

import android.app.Activity;
import android.content.Context;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.model.CardListItem;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.ui.swipe.listener.QueryPaymentListener;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.logic.paysetting.server.OpenPayAppMsgCallBack;
import com.huawei.wallet.logic.paysetting.server.impl.PayAppMsgImpl;
import com.huawei.wallet.storage.sp.PaySettingPreferences;
import java.util.List;

public final class SwipeLogicManager {
    public static final String ALI_PAYFORM = "Alipay";
    private static final String LAST_PAY_KEY = "payForm";
    public static final String NFC_PAYFORM = "nfc";
    private static final byte[] SYNC_LOCK = new byte[0];
    private static SwipeLogicManager instance;
    private Context mContext;

    class OpenPayAppMsgImpl implements OpenPayAppMsgCallBack {
        private QueryPaymentListener listener;
        private PayAppMsgImpl payAppMsg;

        OpenPayAppMsgImpl(PayAppMsgImpl payAppMsgImpl, QueryPaymentListener queryPaymentListener) {
            this.payAppMsg = payAppMsgImpl;
            this.listener = queryPaymentListener;
        }

        public void getOpenPayAppMsg(List<String> list, int i) {
            this.listener.getOpenPayAppMsg(list, i);
            this.payAppMsg.m28073a(true);
        }
    }

    private SwipeLogicManager(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
    }

    public static SwipeLogicManager getInstance(Context context) {
        SwipeLogicManager swipeLogicManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new SwipeLogicManager(context);
            }
            swipeLogicManager = instance;
        }
        return swipeLogicManager;
    }

    public void queryPayment(QueryPaymentListener queryPaymentListener) {
    }

    public void saveLastPayForm(String str) {
        PaySettingPreferences.m28145a(this.mContext).m28147b(LAST_PAY_KEY, str);
    }

    public boolean isLastPayNFC() {
        String a = PaySettingPreferences.m28145a(this.mContext).m28146a(LAST_PAY_KEY, "");
        return NFC_PAYFORM.equals(a) || "".equals(a);
    }

    public void reportBIOnNFCSelected(final CardListItem cardListItem) {
        new Thread() {
            public void run() {
                TACardInfo card = WalletTaManager.getInstance(SwipeLogicManager.this.mContext).getCard(cardListItem.getReferenceId());
                if (card != null) {
                    NfcHianalyticsUtil.onReportForSelectCard(SwipeLogicManager.this.mContext.getApplicationContext(), card.issuerId, card.cardType);
                }
            }
        }.start();
    }

    public void reportBIOnSwipeFinished(CardListItem cardListItem, boolean z, long j) {
        final boolean z2 = z;
        final CardListItem cardListItem2 = cardListItem;
        final long j2 = j;
        new Thread() {
            public void run() {
                if (z2) {
                    TACardInfo card = WalletTaManager.getInstance(SwipeLogicManager.this.mContext).getCard(cardListItem2.getReferenceId());
                    if (card != null) {
                        NfcHianalyticsUtil.onReportForScanSwipeFinish(SwipeLogicManager.this.mContext.getApplicationContext(), card.issuerId, card.cardType, j2);
                        return;
                    }
                    return;
                }
                CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(SwipeLogicManager.this.mContext).cacheCardProductInfoItem(cardListItem2.getProductId());
                if (cacheCardProductInfoItem != null) {
                    NfcHianalyticsUtil.onReportForSwipeFinish(SwipeLogicManager.this.mContext.getApplicationContext(), cardListItem2.getAid(), cacheCardProductInfoItem.getProductName());
                }
            }
        }.start();
        LogX.i("swipeDone report");
    }

    public void reportBIOnScanPayment(String str) {
        NfcHianalyticsUtil.onReportForScanPay(this.mContext, str);
    }

    public void reportSwipeAction() {
        TACardInfo defaultCard = WalletTaManager.getInstance(this.mContext).getDefaultCard();
        if (defaultCard != null) {
            CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(defaultCard.productId);
            if (cacheCardProductInfoItem != null) {
                NfcHianalyticsUtil.onReportForSwipeAction(this.mContext, defaultCard.aid, cacheCardProductInfoItem.getProductName(), cacheCardProductInfoItem.getIssuerId());
            }
        }
    }
}
