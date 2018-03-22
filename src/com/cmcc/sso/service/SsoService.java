package com.cmcc.sso.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.cmcc.sso.p011a.C0323c;
import com.cmcc.sso.p011a.C0324d;
import com.cmcc.sso.sdk.p012a.C0325a;

public class SsoService extends Service {
    private static C0337g f188a = null;
    private IBinder f189b = new C0336f(this);

    public IBinder onBind(Intent intent) {
        Log.i("CMCC_SSO", "SsoService onBind, cmcc-sso.jar version[" + C0325a.f176b + "].");
        C0324d.m181a((Context) this);
        if (f188a == null || !f188a.m222a()) {
            f188a = C0323c.m174a(this);
        }
        if (f188a != null) {
            f188a.m220a(this);
        }
        return this.f189b;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("CMCC_SSO", "SsoService onCreate.");
    }

    public void onDestroy() {
        super.onDestroy();
        if (f188a != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("commandid", -1);
            f188a.m223b();
            f188a.m221a(bundle, null);
            f188a = null;
        }
    }
}
