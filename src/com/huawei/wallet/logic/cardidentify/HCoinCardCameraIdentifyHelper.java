package com.huawei.wallet.logic.cardidentify;

import android.content.Intent;
import com.huawei.wallet.logic.event.IEventListener;
import com.huawei.wallet.logic.event.IEventType;

public class HCoinCardCameraIdentifyHelper {
    private ICardIdentifyCallBack f21207a;

    class C61491 implements IEventListener {
        final /* synthetic */ HCoinCardCameraIdentifyHelper f21206a;

        public void onEventCallBack(IEventType iEventType, Object obj) {
            if (iEventType == IEventType.TYPE_CAMERA_IDENTIFY_CARD) {
                if (obj == null || !(obj instanceof Intent)) {
                    this.f21206a.f21207a.onIndetify(null);
                    return;
                }
                CardIdentifyInfo cardIdentifyInfo = new CardIdentifyInfo();
                cardIdentifyInfo.m27971a(((Intent) obj).getStringExtra("exocr.bankcard.scanResult"));
                this.f21206a.f21207a.onIndetify(cardIdentifyInfo);
            } else if (iEventType == IEventType.TYPE_CAMERA_SWITCH_INPUT) {
                this.f21206a.f21207a.onSwitch2Input();
            } else if (iEventType == IEventType.TYPE_CAMERA_BACK_PRESSED) {
                this.f21206a.f21207a.onCardBackPressed();
            }
        }
    }
}
