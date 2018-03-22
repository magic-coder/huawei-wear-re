package com.huawei.hwid.update.p451b;

import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HttpsUtils */
final class C5274c {
    public static void m25543a(HttpsURLConnection httpsURLConnection) {
        SocketFactory a = C5275e.m25544a();
        if (a instanceof SSLSocketFactory) {
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a);
        }
    }
}
