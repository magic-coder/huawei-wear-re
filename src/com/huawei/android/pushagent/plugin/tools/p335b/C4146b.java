package com.huawei.android.pushagent.plugin.tools.p335b;

import com.huawei.android.pushagent.c.a.e;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class C4146b implements HostnameVerifier {
    C4146b() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        if (str == null || sSLSession == null || !str.equals(sSLSession.getPeerHost())) {
            return false;
        }
        e.b("PushLogSC2712", "verify hostname success");
        return true;
    }
}
