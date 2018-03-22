package com.huawei.nfc.carrera.lifecycle.lostservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleServerCardLostMsgCallback;
import com.huawei.nfc.carrera.util.LogX;

public class CardLostManagerService extends Service implements HandleServerCardLostMsgCallback {
    static final String SERVICE_INTENT_KEY_AID = "aid";
    static final String SERVICE_INTENT_KEY_CPLC = "cplc";
    static final String SERVICE_INTENT_KEY_DPANID = "dpanid";
    static final String SERVICE_INTENT_KEY_MODE = "mode";
    static final String SERVICE_INTENT_KEY_SIGN = "sign";
    static final String SERVICE_INTENT_KEY_STATUS = "status";
    public static final String SERVICE_START_MODE_DEVICES_LOST = "devices_lost";
    private int serviceStartedTimes = 0;

    class C12091 implements Runnable {
        C12091() {
        }

        public void run() {
            CardLostManagerService.this.finishOneServiceTask();
        }
    }

    public IBinder onBind(Intent intent) {
        LogX.m5465d("CardLostManagerService onBind");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        LogX.m5465d("CardLostManagerService onCreate");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        LogX.m5465d("CardLostManagerService onStartCommand");
        addOneServiceTask();
        if (intent == null) {
            LogX.m5465d("CardLostManagerService, but intent is illegal.");
            finishOneServiceTask();
        } else {
            String stringExtra = intent.getStringExtra("cplc");
            String queryCplc = ESEApiFactory.createESEInfoManagerApi(getApplicationContext()).queryCplc();
            if (queryCplc == null || !queryCplc.equals(stringExtra)) {
                LogX.m5465d("CardLostManagerService, cplc is illegal.");
                finishOneServiceTask();
            } else {
                CardLostManager.getInstance(getApplicationContext()).handleServerCardLostMessage(intent.getStringExtra("aid"), intent.getStringExtra("status"), stringExtra, intent.getStringExtra("dpanid"), this);
            }
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.m5465d("CardLostManagerService onDestroy");
    }

    private void addOneServiceTask() {
        this.serviceStartedTimes++;
    }

    private void finishOneServiceTask() {
        this.serviceStartedTimes--;
        if (this.serviceStartedTimes == 0) {
            stopSelf();
            LostServiceManager.releaseLostTaskWakeLock();
        }
    }

    public void handleServerMsgResult(boolean z, String str, String str2) {
        LogX.m5465d("CardLostManagerService finishOneServiceTask");
        new Handler(getMainLooper()).post(new C12091());
    }
}
