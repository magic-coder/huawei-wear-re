package com.huawei.nfc.carrera.logic.swipe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.lifecycle.swipeservice.TransactionChannelService;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;

public class NfcPayStateChangeReceiver extends BroadcastReceiver {
    private static final String NFC_STATE_CHANGED = "android.nfc.action.ADAPTER_STATE_CHANGED";
    private static final String SWITCH_CE_STATE = "com.huawei.android.nfc.SWITCH_CE_STATE";

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogX.m5469e("NfcPayStateChangeReceiver broadcast intent is null");
            return;
        }
        String action = intent.getAction();
        LogX.m5475i("NfcPayStateChangeReceiver onReceive  action==" + action);
        if (NFC_STATE_CHANGED.equals(action) || "com.huawei.android.nfc.SWITCH_CE_STATE".equals(action)) {
            if (NFC_STATE_CHANGED.equals(action)) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 0);
                if (intExtra == 2 || intExtra == 4) {
                    return;
                }
            }
            if (NfcUtil.isMatchPayCondition(context)) {
                LogX.m5475i("NfcPayStateChangeReceiver start service.");
                context.startService(new Intent(context, TransactionChannelService.class));
                return;
            }
            LogX.m5465d("do not match swipe condition.");
            return;
        }
        LogX.m5465d("The action is not nfc state change action, ignore it.");
    }
}
