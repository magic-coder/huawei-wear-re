package com.huawei.nfc.carrera.lifecycle.cupoperate;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;

public class CUPOperateServiceManager {
    private static final int WAKE_LOCK_TIMEOUT = 120000;
    private static WakeLock lostServiceWakeLock;
    private static final Object wakeLockSync = new Object();

    public static void startCUPOperateService(Context context, String str, String str2, String str3, ArrayList<String> arrayList) {
        LogX.m5475i("startCUPOperateService");
        acquireWakeLock(context);
        Intent intent = new Intent();
        intent.putExtra("event", str);
        intent.putExtra(Constant.KEY_DOWNLOAD_INFO_SSID, str2);
        intent.putExtra("sign", str3);
        intent.putStringArrayListExtra("ref_ids", arrayList);
        intent.setClass(context, CUPOperateService.class);
        intent.setAction("com.huawei.wallet.nfc.CARD_OPERATE_SERVICE");
        context.startService(intent);
    }

    public static void startCUPPersonalService(Context context, String str, String str2, String str3) {
        LogX.m5475i("startCUPPersonalService");
        acquireWakeLock(context);
        Intent intent = new Intent();
        intent.putExtra("cplc", str);
        intent.putExtra("ref_id", str2);
        intent.putExtra("aid", str3);
        intent.setClass(context, CUPOperateService.class);
        intent.setAction("com.huawei.wallet.nfc.PERSONAL_RESULT_HANDLE_SERVICE");
        context.startService(intent);
    }

    private static void acquireWakeLock(Context context) {
        synchronized (wakeLockSync) {
            if (lostServiceWakeLock == null) {
                LogX.m5465d("===123===Lock==startLostTaskWakeLock");
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (C0977d.m3534a()) {
                    LogX.m5465d("===123===Lock == Huawei");
                    lostServiceWakeLock = powerManager.newWakeLock(1, "beginWakeLock");
                } else {
                    LogX.m5465d("===123===Lock ==not Huawei");
                    lostServiceWakeLock = powerManager.newWakeLock(536870922, "beginWakeLock");
                }
                lostServiceWakeLock.setReferenceCounted(false);
            }
            lostServiceWakeLock.acquire(120000);
        }
    }

    static void releaseCUPOperateWakeLock() {
        LogX.m5465d("===123===Lock==releaseLostTaskWakeLock");
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
