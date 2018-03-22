package com.huawei.nfc.carrera.logic.cardoperate.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.InitEseTsmOperator;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;

public class EseTsmInitLoader implements Runnable {
    private static final long RECHECK_CAP_UPGRADE_DURATION = 86400000;
    private static final String SHAREPREFRENCE_KEY_LAST_CHECK_CAP_TIME = "last_check_cap_time";
    private final Context mContext;

    public EseTsmInitLoader(Context context) {
        this.mContext = context;
    }

    public void run() {
        LogX.i("init ese info by huawei tsm.");
        excuteEseInit();
    }

    public int excuteEseInit() {
        long longValue = NFCPreferences.getInstance(this.mContext).getLong(SHAREPREFRENCE_KEY_LAST_CHECK_CAP_TIME, Long.valueOf(0)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if ((longValue - currentTimeMillis <= 0 || longValue - currentTimeMillis >= 86400000) && (currentTimeMillis - longValue <= 0 || currentTimeMillis - longValue >= 86400000)) {
            LogX.d("notifyInfoInit now");
            int notifyInfoInit = notifyInfoInit();
            LogX.d("laserNotifyResult : " + notifyInfoInit);
            if (notifyInfoInit != 0) {
                return notifyInfoInit;
            }
            NFCPreferences.getInstance(this.mContext).putLong(SHAREPREFRENCE_KEY_LAST_CHECK_CAP_TIME, Long.valueOf(System.currentTimeMillis()));
            return notifyInfoInit;
        }
        LogX.d("excuteUpgrade, had checked in 24 hours, no need to check again now.");
        return 0;
    }

    private int notifyInfoInit() {
        int excute = new InitEseTsmOperator(this.mContext).excute();
        LogX.d("notifyInfoInit, excute init, result: " + excute);
        return excute;
    }
}
