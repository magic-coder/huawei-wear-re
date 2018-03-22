package com.google.tagmanager;

import android.net.Uri;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: PreviewManager */
class am {
    private static am f14254a;
    private volatile an f14255b;
    private volatile String f14256c;
    private volatile String f14257d;
    private volatile String f14258e;

    am() {
        m18477e();
    }

    static am m18470a() {
        am amVar;
        synchronized (am.class) {
            if (f14254a == null) {
                f14254a = new am();
            }
            amVar = f14254a;
        }
        return amVar;
    }

    synchronized boolean m18473a(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), GameManager.DEFAULT_CHARSET);
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    C3700z.m18628d("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f14255b = an.CONTAINER_DEBUG;
                    } else {
                        this.f14255b = an.CONTAINER;
                    }
                    this.f14258e = m18472b(uri);
                    if (this.f14255b == an.CONTAINER || this.f14255b == an.CONTAINER_DEBUG) {
                        this.f14257d = "/r?" + this.f14258e;
                    }
                    this.f14256c = m18471a(this.f14258e);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        C3700z.m18626b("Invalid preview uri: " + decode);
                        z = false;
                    } else if (m18471a(uri.getQuery()).equals(this.f14256c)) {
                        C3700z.m18628d("Exit preview mode for container: " + this.f14256c);
                        this.f14255b = an.NONE;
                        this.f14257d = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    private String m18472b(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    an m18474b() {
        return this.f14255b;
    }

    String m18475c() {
        return this.f14257d;
    }

    String m18476d() {
        return this.f14256c;
    }

    void m18477e() {
        this.f14255b = an.NONE;
        this.f14257d = null;
        this.f14256c = null;
        this.f14258e = null;
    }

    private String m18471a(String str) {
        return str.split(SNBConstant.FILTER)[0].split("=")[1];
    }
}
