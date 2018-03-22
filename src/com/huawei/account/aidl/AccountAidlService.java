package com.huawei.account.aidl;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p190v.C2538c;
import java.util.concurrent.CountDownLatch;

public class AccountAidlService extends Service {
    private String f1128a = "AccountAidlService_bone";
    private Context f1129b;
    private CountDownLatch f1130c;
    private String f1131d = "";
    private final BroadcastReceiver f1132e = new C0632b(this);
    private C0634h f1133f = new C0635c(this);
    private Binder f1134g = new C0638d(this);

    @Nullable
    public IBinder onBind(Intent intent) {
        return this.f1133f;
    }

    public void onCreate() {
        C2538c.m12677c(this.f1128a, "AccountAidlService-onCreate");
        super.onCreate();
        this.f1129b = this;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.bone.GET_USER_INFO_RETURN");
        this.f1129b.registerReceiver(this.f1132e, intentFilter, C0976c.f1642a, null);
    }

    public void onDestroy() {
        C2538c.m12677c(this.f1128a, "AccountAidlService-onDestroy");
        this.f1129b.unregisterReceiver(this.f1132e);
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c(this.f1128a, "AccountAidlService-onStartCommand");
        if (intent != null) {
            return super.onStartCommand(intent, i, i2);
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        C2538c.m12677c(this.f1128a, "AccountAidlService-onUnbind");
        return super.onUnbind(intent);
    }
}
