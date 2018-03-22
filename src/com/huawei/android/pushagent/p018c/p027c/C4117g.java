package com.huawei.android.pushagent.p018c.p027c;

import com.huawei.android.pushagent.c.a.e;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class C4117g implements HostnameVerifier {
    C4117g() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        e.a("PushLogAC2712", "hostname=" + str);
        if (str == null || sSLSession == null || !str.equals(sSLSession.getPeerHost())) {
            return false;
        }
        e.b("PushLogAC2712", "verify hostname success");
        return true;
    }
}
