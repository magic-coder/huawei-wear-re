package com.huawei.nfc.carrera.lifecycle.lostservice;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import org.apache.log4j.helpers.FileWatchdog;

public class LostServiceManager {
    private static final int WAKE_LOCK_TIMEOUT = 60000;
    private static WakeLock lostServiceWakeLock;
    private static final Object wakeLockSync = new Object();

    public static void startCardLostManageService(Context context, String str, String str2, String str3, String str4) {
        LogX.m5475i("startCCLostManageService");
        acquireWakeLock(context);
        Intent intent = new Intent();
        intent.putExtra("aid", str);
        intent.putExtra("status", str2);
        intent.putExtra("cplc", str3);
        intent.putExtra(ReportCardInfo.COLUMN_NAME_DPANID, str4);
        intent.setClass(context, CardLostManagerService.class);
        context.startService(intent);
    }

    public static void startDevicesLostManageService(Context context, String str, String str2) {
        LogX.m5475i("startCCLostManageService  devices Lost mode ");
        acquireWakeLock(context);
        Intent intent = new Intent();
        intent.putExtra("sign", str2);
        intent.putExtra("cplc", str);
        intent.putExtra(IssuerInfoColumns.COLUMN_NAME_MODE, CardLostManagerService.SERVICE_START_MODE_DEVICES_LOST);
        intent.setClass(context, CardLostManagerService.class);
        context.startService(intent);
    }

    private static void acquireWakeLock(Context context) {
        synchronized (wakeLockSync) {
            if (lostServiceWakeLock == null) {
                lostServiceWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "beginWakeLock");
                lostServiceWakeLock.setReferenceCounted(false);
            }
            lostServiceWakeLock.acquire(FileWatchdog.DEFAULT_DELAY);
        }
    }

    static void releaseLostTaskWakeLock() {
        LogX.m5465d("releaseLostTaskWakeLock");
        synchronized (wakeLockSync) {
            if (lostServiceWakeLock != null) {
                LogX.m5465d("release the wake lock now.");
                if (lostServiceWakeLock.isHeld()) {
                    lostServiceWakeLock.release();
                }
                lostServiceWakeLock = null;
            }
        }
    }
}
