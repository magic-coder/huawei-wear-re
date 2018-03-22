package com.huawei.hwcloudmodel.p402a;

import android.os.Build.VERSION;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: ImageTransferAdapter */
final class C4673c implements HostnameVerifier {
    C4673c() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return VERSION.SDK_INT >= 2;
    }
}
