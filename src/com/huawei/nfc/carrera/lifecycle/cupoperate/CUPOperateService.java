package com.huawei.nfc.carrera.lifecycle.cupoperate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.nfc.carrera.logic.CardOperateLogicApi;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardoperate.response.CheckCUPCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPOperateResultCallback;
import com.huawei.nfc.carrera.logic.cardoperate.response.HandleCUPPersonalizedResultCallback;
import com.huawei.nfc.carrera.util.LogX;

public class CUPOperateService extends Service implements CheckCUPCardCallback, HandleCUPOperateResultCallback, HandleCUPPersonalizedResultCallback {
    static final String SERVICE_ACTION_CUP_OPERATE = "com.huawei.wallet.nfc.CARD_OPERATE_SERVICE";
    static final String SERVICE_ACTION_PERSONALIZED_RESULT = "com.huawei.wallet.nfc.PERSONAL_RESULT_HANDLE_SERVICE";
    static final String SERVICE_INTENT_KEY_AID = "aid";
    static final String SERVICE_INTENT_KEY_CPLC = "cplc";
    static final String SERVICE_INTENT_KEY_EVENT = "event";
    static final String SERVICE_INTENT_KEY_REFID = "ref_id";
    static final String SERVICE_INTENT_KEY_REFIDS = "ref_ids";
    static final String SERVICE_INTENT_KEY_SIGN = "sign";
    static final String SERVICE_INTENT_KEY_SSID = "ssid";
    private int serviceStartedTimes = 0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        LogX.m5465d("CUPOperateService onCreate");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        LogX.m5465d("CUPOperateService onStartCommand");
        addOneServiceTask();
        if (intent == null) {
            LogX.m5475i("cup operate service restarted.");
            CardOperateLogicApi createCardOperateApi = LogicApiFactory.createCardOperateApi(getApplicationContext());
            createCardOperateApi.initCUPCardOperator(null);
            createCardOperateApi.checkCUPInterruptedCard(true, this);
        } else {
            String action = intent.getAction();
            if (SERVICE_ACTION_CUP_OPERATE.equals(action)) {
                LogicApiFactory.createCardOperateApi(getApplicationContext()).notifyCUPCardOperation(intent.getStringExtra("event"), intent.getStringExtra("ssid"), intent.getStringExtra("sign"), intent.getStringArrayListExtra(SERVICE_INTENT_KEY_REFIDS), this);
            } else if (SERVICE_ACTION_PERSONALIZED_RESULT.equals(action)) {
                LogicApiFactory.createCardOperateApi(getApplicationContext()).notifyCUPCardPersonalized(intent.getStringExtra("cplc"), intent.getStringExtra(SERVICE_INTENT_KEY_REFID), intent.getStringExtra("aid"), this);
            } else {
                LogX.m5469e("action error.");
                finishOneServiceTask();
            }
        }
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.m5465d("CUPOperateService onDestroy");
    }

    private void addOneServiceTask() {
        this.serviceStartedTimes++;
    }

    private void finishOneServiceTask() {
        this.serviceStartedTimes--;
        if (this.serviceStartedTimes == 0) {
            stopSelf();
            CUPOperateServiceManager.releaseCUPOperateWakeLock();
        }
    }

    public void operateResultCallback(int i) {
        LogX.m5475i("card operate result: " + i);
        finishOneServiceTask();
    }

    public void handleResultCallback(int i) {
        LogX.m5475i("handle personalized result: " + i);
        finishOneServiceTask();
    }

    public void checkFinished() {
        LogX.m5475i("check cup card finished.");
        finishOneServiceTask();
    }
}
