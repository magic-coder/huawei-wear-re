package com.huawei.wallet.logic.cardidentify;

import android.app.Activity;
import android.content.Intent;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventListener;
import com.huawei.wallet.logic.event.IEventType;
import com.huawei.wallet.ui.idencard.camera.bankcard.BankCardCaptureActivity;
import com.huawei.wallet.ui.idencard.camera.base.CardResultInfoManager;
import com.huawei.wallet.utils.UIUtil;
import com.huawei.wallet.utils.log.LogC;

public class CardCameraIdentifyHelper {
    private ICardIdentifyCallBack f21200a;

    class C61471 implements IEventListener {
        final /* synthetic */ CardCameraIdentifyHelper f21199a;

        C61471(CardCameraIdentifyHelper cardCameraIdentifyHelper) {
            this.f21199a = cardCameraIdentifyHelper;
        }

        public void onEventCallBack(IEventType iEventType, Object obj) {
            if (iEventType == IEventType.TYPE_CAMERA_IDENTIFY_CARD) {
                if (obj == null || !(obj instanceof Intent)) {
                    this.f21199a.f21200a.onIndetify(null);
                    return;
                }
                CardIdentifyInfo cardIdentifyInfo = new CardIdentifyInfo();
                try {
                    cardIdentifyInfo.m27971a(((Intent) obj).getStringExtra("exocr.bankcard.scanResult"));
                    cardIdentifyInfo.m27970a(CardResultInfoManager.m28422d().m28423a());
                    this.f21199a.f21200a.onIndetify(cardIdentifyInfo);
                } catch (Throwable e) {
                    LogC.m28529b("ClassCastException.", e, false);
                }
            } else if (iEventType == IEventType.TYPE_CAMERA_SWITCH_INPUT) {
                this.f21199a.f21200a.onSwitch2Input();
            } else if (iEventType == IEventType.TYPE_CAMERA_BACK_PRESSED) {
                this.f21199a.f21200a.onCardBackPressed();
            }
        }
    }

    public void m27968a(Activity activity, ICardIdentifyCallBack iCardIdentifyCallBack) {
        if (activity == null || iCardIdentifyCallBack == null) {
            LogC.m28530b("identifyCardByCamera context is null or callback is null", false);
            return;
        }
        LogC.m28530b("identifyCardByCamera begin to identify", false);
        this.f21200a = iCardIdentifyCallBack;
        String obj = toString();
        Intent intent = new Intent();
        intent.putExtra("isSupportHorVerSwitch", UIUtil.m28489a(activity));
        intent.setClass(activity, BankCardCaptureActivity.class);
        intent.putExtra("event_callback_id", obj);
        activity.startActivity(intent);
        EventDispatchManager.m28051a().m28055a(obj, new C61471(this));
    }
}
