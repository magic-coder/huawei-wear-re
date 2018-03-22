package com.huawei.nfc.carrera.lifecycle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.nfc.carrera.ui.swipe.SwipeActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.wallet.utils.nversion.NversionUtil;
import net.sqlcipher.database.SQLiteDatabase;

public class FieldOnDetectedReceiver extends BroadcastReceiver {
    private static final String ACTION_RF_FIELD_ON_DETECTED = "com.android.nfc_extras.action.RF_FIELD_ON_DETECTED";
    private static final int WAKE_LOCK_TIMEOUT = 3000;
    private static WakeLock swipeWakeLock;
    private static final Object wakeLockSync = new Object();

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogX.m5469e("detect in field broadcast intent is null");
            return;
        }
        String action = intent.getAction();
        LogX.m5475i("FieldOnDetectedReceiver onReceive  action==" + action);
        if (ACTION_RF_FIELD_ON_DETECTED.equals(action)) {
            acquireFieldOnWakelock(context);
            if (!NversionUtil.m12764a(context)) {
                LogX.m5465d("FieldOnDetectedReceiver, N version isUserUnLocked is false");
                return;
            } else if (NfcUtil.isMatchPayCondition(context)) {
                Intent intent2 = new Intent(context, SwipeActivity.class);
                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent2);
                return;
            } else {
                return;
            }
        }
        LogX.m5465d("The action is not field on action, ignore it.");
    }

    private void acquireFieldOnWakelock(Context context) {
        synchronized (wakeLockSync) {
            if (swipeWakeLock == null) {
                swipeWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "swipeWakeLock");
                swipeWakeLock.setReferenceCounted(false);
            }
            if (!swipeWakeLock.isHeld()) {
                swipeWakeLock.acquire(3000);
            }
        }
    }
}
