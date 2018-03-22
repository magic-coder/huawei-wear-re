package com.huawei.wallet.logic.cardidentify;

import android.content.Intent;
import android.nfc.NfcAdapter;
import com.huawei.wallet.logic.event.IEventListener;
import com.huawei.wallet.logic.event.IEventType;
import com.huawei.wallet.logic.tlv.TlvParserUtil;
import com.huawei.wallet.utils.log.LogC;

public class CardNFCIdentifyHelper {
    private ICardIdentifyCallBack f21204a;
    private NfcAdapter f21205b;

    class C61481 implements IEventListener {
        final /* synthetic */ CardNFCIdentifyHelper f21203a;

        public void onEventCallBack(IEventType iEventType, Object obj) {
            if (IEventType.TYPE_NFC_IDENTIFY_CARD == iEventType && (obj instanceof Intent) && this.f21203a.f21204a != null) {
                String a = this.f21203a.m27974a((Intent) obj);
                CardIdentifyInfo cardIdentifyInfo = new CardIdentifyInfo();
                cardIdentifyInfo.m27971a(a);
                this.f21203a.f21204a.onIndetify(cardIdentifyInfo);
            }
        }
    }

    public boolean m27976a() {
        boolean isEnabled;
        if (this.f21205b != null) {
            isEnabled = this.f21205b.isEnabled();
        } else {
            isEnabled = false;
        }
        LogC.m28530b("nfc function final is " + isEnabled, false);
        return isEnabled;
    }

    private String m27974a(Intent intent) {
        if (!m27976a()) {
            return null;
        }
        if (!"android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) {
            return null;
        }
        String a = TlvParserUtil.m28089a(intent);
        if (a == null) {
            LogC.m28530b("onNewIntent.number is null", false);
            return null;
        }
        LogC.m28530b("mCardIdentifyCallBack call back card info", false);
        return a;
    }
}
