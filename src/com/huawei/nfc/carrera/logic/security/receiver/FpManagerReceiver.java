package com.huawei.nfc.carrera.logic.security.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.logic.security.CheckFingerPrintPasswd;
import com.huawei.nfc.carrera.logic.security.fingerprint.FingerPrintAuthUnusableException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaFingerIdNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;

public class FpManagerReceiver extends BroadcastReceiver {
    public static final String ACTION_FINGERPRINT_UPDATED = "com.huawei.wallet.nfc.action.FP_MANAGER";
    private static final String EXTRA_FID = "com.huawei.wallet.nfc.extra.FID";
    private static final String FINGER_ID_NOT_EXIST_TAG = "-1";
    public static final String TAG = FpManagerReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String str = null;
        if (intent != null) {
            str = intent.getAction();
        }
        LogX.d(TAG, "onReceive  action==" + str);
        if (intent == null || !ACTION_FINGERPRINT_UPDATED.equals(str) || intent.getStringExtra(EXTRA_FID) == null) {
            LogX.w(TAG, "onReceive  intent  action  mismatch");
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_FID);
        if ("-1".equals(stringExtra)) {
            try {
                WalletTaManager.getInstance(context).removeFingerId();
                return;
            } catch (WalletTaSystemErrorException e) {
                LogX.e("remove finger id failed, system error");
                return;
            }
        }
        boolean z = false;
        if (!isFingerIDInTa(context, stringExtra)) {
            try {
                z = new CheckFingerPrintPasswd(context).isFpIdInSystemSetting(stringExtra);
            } catch (FingerPrintAuthUnusableException e2) {
                LogX.e("FpManagerReceiver FingerPrintAuthUnusableException");
            }
            if (z) {
                try {
                    WalletTaManager.getInstance(context).setFingerId(Integer.parseInt(stringExtra));
                } catch (WalletTaSystemErrorException e3) {
                    LogX.e("set finger id failed, system error");
                }
            }
        }
    }

    private boolean isFingerIDInTa(Context context, String str) {
        try {
            if (str.equals(String.valueOf(WalletTaManager.getInstance(context).getFingerId()))) {
                return true;
            }
            return false;
        } catch (WalletTaFingerIdNotExistException e) {
            LogX.e("FpManagerReceiver  WalletTaFingerIdNotExistException");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.e("FpManagerReceiver WalletTaSystemErrorException");
            return false;
        }
    }
}
