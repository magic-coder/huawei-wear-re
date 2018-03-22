package com.huawei.nfc.carrera.lifecycle.nullifyservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.huawei.aj.p315a.p318c.p319a.C4025a;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.lostmanager.callback.HandleDeleteLocalCardsCallback;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaAccountNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.NfcUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.pay.p130e.C5730c;
import java.util.HashMap;
import java.util.Map;

public class NullifyAccountManagerService extends Service implements HandleDeleteLocalCardsCallback {
    public static final String RSA_PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOv0vhs4mPhr7icuEVWuhkHwPGAdmIdQ9IulOGKhV2zAh6COvf+SVvWTWeLIX5/fzSyhFp5BUJAiQjWe7Xr5K2whSJWN+Xgtfwr2H2iiZaul4wGwMep20JyBuaHVm1TZ3A1qbT51reg+H9d6Qy9es96QNjg+iNHgsRUKYZnzNgSQIDAQAB";
    static final String SERVICE_INTENT_KEY_CPLC = "cplc";
    static final String SERVICE_INTENT_KEY_SIGN = "sign";
    static final String SERVICE_INTENT_KEY_USER = "user";
    private int serviceStartedTimes = 0;

    class C55311 implements Runnable {
        C55311() {
        }

        public void run() {
            NullifyAccountManagerService.this.finishOneServiceTask();
        }
    }

    public IBinder onBind(Intent intent) {
        LogX.d("NullifyAccountManagerService onBind");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        LogX.d("NullifyAccountManagerService onCreate");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        LogX.d("NullifyAccountManagerService onStartCommand");
        addOneServiceTask();
        if (intent == null || !NfcUtil.isEnabledNFC(this)) {
            LogX.i("CardLostManagerService, isEnabledNFC: false or intent is illegal.");
            finishOneServiceTask();
        } else {
            String stringExtra = intent.getStringExtra(SERVICE_INTENT_KEY_USER);
            String stringExtra2 = intent.getStringExtra("cplc");
            String stringExtra3 = intent.getStringExtra("sign");
            Map hashMap = new HashMap();
            hashMap.put("uid", stringExtra);
            hashMap.put("cplc", stringExtra2);
            if (!C4025a.m19817a(C5730c.m26407a(hashMap), stringExtra3, RSA_PUBLICKEY)) {
                LogX.i("NullifyAccountManagerService, sign verify return false");
                finishOneServiceTask();
            } else if (StringUtil.isEmpty(stringExtra, true) || !isAccountStatuMatch(getApplicationContext(), stringExtra)) {
                LogX.i("NullifyAccountManagerService, user id not match");
                finishOneServiceTask();
            } else {
                CardLostManager.getInstance(getApplicationContext()).deleteLocalBankCards(this);
            }
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        LogX.d("NullifyAccountManagerService onDestroy");
    }

    private void addOneServiceTask() {
        this.serviceStartedTimes++;
    }

    private void finishOneServiceTask() {
        this.serviceStartedTimes--;
        if (this.serviceStartedTimes == 0) {
            stopSelf();
            NullifyServiceManager.releaseLostTaskWakeLock();
        }
    }

    private boolean isAccountStatuMatch(Context context, String str) {
        boolean z = false;
        try {
            z = WalletTaManager.getInstance(context).checkUserAccount(str);
        } catch (WalletTaAccountNotExistException e) {
            LogX.d("there is no account in ta", z);
        } catch (WalletTaSystemErrorException e2) {
            LogX.d("check account, ta exception");
        }
        LogX.i("NullifyAccountManagerService isAccountMatch: " + z);
        return z;
    }

    public void handleDeletelocalcardCallback(boolean z) {
        LogX.i("NullifyAccountManagerService delete card isSuccess " + z);
        new Handler(getMainLooper()).post(new C55311());
    }
}
