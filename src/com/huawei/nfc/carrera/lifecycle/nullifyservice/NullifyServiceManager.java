package com.huawei.nfc.carrera.lifecycle.nullifyservice;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.nfc.carrera.util.LogX;
import org.apache.log4j.helpers.FileWatchdog;

public class NullifyServiceManager {
    private static final int WAKE_LOCK_TIMEOUT = 60000;
    private static WakeLock nullifyServiceWakeLock;
    private static final Object wakeLockSync = new Object();

    public static void startNullifyAccountManageService(Context context, String str, String str2, String str3) {
        LogX.i("startNullifyAccountManageService");
        acquireWakeLock(context);
        Intent intent = new Intent();
        intent.putExtra("user", str);
        intent.putExtra("cplc", str2);
        intent.putExtra("sign", str3);
        intent.setClass(context, NullifyAccountManagerService.class);
        context.startService(intent);
    }

    private static void acquireWakeLock(Context context) {
        synchronized (wakeLockSync) {
            if (nullifyServiceWakeLock == null) {
                nullifyServiceWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "beginWakeLock");
                nullifyServiceWakeLock.setReferenceCounted(false);
            }
            nullifyServiceWakeLock.acquire(FileWatchdog.DEFAULT_DELAY);
        }
    }

    static void releaseLostTaskWakeLock() {
        LogX.d("releaseLostTaskWakeLock");
        synchronized (wakeLockSync) {
            if (nullifyServiceWakeLock != null) {
                LogX.d("release the wake lock now.");
                if (nullifyServiceWakeLock.isHeld()) {
                    nullifyServiceWakeLock.release();
                }
                nullifyServiceWakeLock = null;
            }
        }
    }
}
