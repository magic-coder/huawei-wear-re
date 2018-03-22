package com.huawei.nfc.carrera.logic.swipe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.util.LogX;

public class FieldOffDetectedReceiver extends BroadcastReceiver {
    public static final String ACTION_RF_FIELD_OFF_DETECTED = "com.android.nfc_extras.action.RF_FIELD_OFF_DETECTED";
    private SwipeFieldOffListener fieldOffListener;

    public FieldOffDetectedReceiver(SwipeFieldOffListener swipeFieldOffListener) {
        this.fieldOffListener = swipeFieldOffListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogX.e("field off broadcast intent is null");
            return;
        }
        String action = intent.getAction();
        LogX.i("onReceive  action==" + action);
        if (!ACTION_RF_FIELD_OFF_DETECTED.equals(action)) {
            LogX.d("The action is not field off action, ignore it.");
        } else if (this.fieldOffListener != null) {
            this.fieldOffListener.fieldOff();
        }
    }
}
