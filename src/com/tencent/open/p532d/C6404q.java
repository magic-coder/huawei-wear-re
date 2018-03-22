package com.tencent.open.p532d;

import android.os.Bundle;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ProGuard */
class C6404q extends Thread {
    final /* synthetic */ Bundle f22248a;
    final /* synthetic */ C6403p f22249b;

    C6404q(C6403p c6403p, Bundle bundle) {
        this.f22249b = c6403p;
        this.f22248a = bundle;
    }

    public void run() {
        try {
            this.f22249b.m29207a(C6412y.m29260d(C6396i.m29190a(this.f22249b.f22242c, "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", HttpGet.METHOD_NAME, this.f22248a).f22213a));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f22249b.f22246g = 0;
    }
}
