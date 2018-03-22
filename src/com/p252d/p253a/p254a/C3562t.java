package com.p252d.p253a.p254a;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: RetryHandler */
class C3562t implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> f13575a = new HashSet();
    private static final HashSet<Class<?>> f13576b = new HashSet();
    private final int f13577c;
    private final int f13578d;

    static {
        f13575a.add(NoHttpResponseException.class);
        f13575a.add(UnknownHostException.class);
        f13575a.add(SocketException.class);
        f13576b.add(InterruptedIOException.class);
        f13576b.add(SSLException.class);
    }

    public C3562t(int i, int i2) {
        this.f13577c = i;
        this.f13578d = i2;
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = true;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z2 = bool != null && bool.booleanValue();
        if (i > this.f13577c) {
            z = false;
        } else if (!m17892a(f13575a, iOException)) {
            if (m17892a(f13576b, iOException)) {
                z = false;
            } else if (!z2) {
            }
        }
        if (z && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
            return false;
        }
        if (z) {
            SystemClock.sleep((long) this.f13578d);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }

    protected boolean m17892a(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((Class) it.next()).isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
