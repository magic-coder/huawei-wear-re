package com.tencent.open.p532d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.open.p541a.C6367n;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ProGuard */
final class C6413z extends Thread {
    final /* synthetic */ Context f22271a;
    final /* synthetic */ Bundle f22272b;

    C6413z(Context context, Bundle bundle) {
        this.f22271a = context;
        this.f22272b = bundle;
    }

    public void run() {
        try {
            C6396i.m29190a(this.f22271a, "http://cgi.qplus.com/report/report", HttpGet.METHOD_NAME, this.f22272b);
        } catch (Exception e) {
            C6367n.m29112e(C6412y.f22262a, "reportBernoulli has exception: " + e.getMessage());
        }
    }
}
