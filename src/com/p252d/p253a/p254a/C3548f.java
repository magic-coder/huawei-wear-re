package com.p252d.p253a.p254a;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpRequest */
public class C3548f implements Runnable {
    private final AbstractHttpClient f13542a;
    private final HttpContext f13543b;
    private final HttpUriRequest f13544c;
    private final C3549s f13545d;
    private int f13546e;
    private final AtomicBoolean f13547f = new AtomicBoolean();
    private boolean f13548g;
    private volatile boolean f13549h;
    private boolean f13550i;

    public C3548f(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, C3549s c3549s) {
        this.f13542a = (AbstractHttpClient) C3564v.m17894a((Object) abstractHttpClient, "client");
        this.f13543b = (HttpContext) C3564v.m17894a((Object) httpContext, "context");
        this.f13544c = (HttpUriRequest) C3564v.m17894a((Object) httpUriRequest, "request");
        this.f13545d = (C3549s) C3564v.m17894a((Object) c3549s, "responseHandler");
    }

    public void m17821a(C3548f c3548f) {
    }

    public void m17823b(C3548f c3548f) {
    }

    public void run() {
        if (!m17822a()) {
            if (!this.f13550i) {
                this.f13550i = true;
                m17821a(this);
            }
            if (!m17822a()) {
                this.f13545d.mo4197f();
                if (!m17822a()) {
                    try {
                        m17819d();
                    } catch (Throwable e) {
                        if (m17822a()) {
                            C3543a.f13526a.mo4210b("AsyncHttpRequest", "makeRequestWithRetries returned error", e);
                        } else {
                            this.f13545d.mo4194b(0, null, null, e);
                        }
                    }
                    if (!m17822a()) {
                        this.f13545d.mo4198g();
                        if (!m17822a()) {
                            m17823b(this);
                            this.f13549h = true;
                        }
                    }
                }
            }
        }
    }

    private void m17818c() throws IOException {
        if (!m17822a()) {
            if (this.f13544c.getURI().getScheme() == null) {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            if (this.f13545d instanceof C3559p) {
                ((C3559p) this.f13545d).m17885a(this.f13544c);
            }
            HttpResponse execute = this.f13542a.execute(this.f13544c, this.f13543b);
            if (!m17822a()) {
                this.f13545d.mo4187a(this.f13545d, execute);
                if (!m17822a()) {
                    this.f13545d.mo4189a(execute);
                    if (!m17822a()) {
                        this.f13545d.mo4195b(this.f13545d, execute);
                    }
                }
            }
        }
    }

    private void m17819d() throws IOException {
        int i;
        IOException iOException = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.f13542a.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                m17818c();
                return;
            } catch (IOException iOException2) {
                try {
                    boolean z2;
                    IOException iOException3;
                    IOException iOException4 = new IOException("UnknownHostException exception: " + iOException2.getMessage());
                    if (this.f13546e > 0) {
                        int i2 = this.f13546e + 1;
                        this.f13546e = i2;
                        if (httpRequestRetryHandler.retryRequest(iOException2, i2, this.f13543b)) {
                            z2 = true;
                            iOException3 = iOException4;
                            z = z2;
                            iOException2 = iOException3;
                        }
                    }
                    z2 = false;
                    iOException3 = iOException4;
                    z = z2;
                    iOException2 = iOException3;
                } catch (Throwable e) {
                    Throwable th = e;
                    C3543a.f13526a.mo4210b("AsyncHttpRequest", "Unhandled exception origin cause", th);
                    iOException2 = new IOException("Unhandled exception: " + th.getMessage());
                }
            } catch (NullPointerException e2) {
                iOException2 = new IOException("NPE in HttpClient: " + e2.getMessage());
                i = this.f13546e + 1;
                this.f13546e = i;
                z = httpRequestRetryHandler.retryRequest(iOException2, i, this.f13543b);
            } catch (IOException e3) {
                iOException2 = e3;
                if (!m17822a()) {
                    i = this.f13546e + 1;
                    this.f13546e = i;
                    z = httpRequestRetryHandler.retryRequest(iOException2, i, this.f13543b);
                } else {
                    return;
                }
            }
        }
        throw iOException2;
        if (z) {
            this.f13545d.mo4193b(this.f13546e);
        }
    }

    public boolean m17822a() {
        boolean z = this.f13547f.get();
        if (z) {
            m17820e();
        }
        return z;
    }

    private synchronized void m17820e() {
        if (!(this.f13549h || !this.f13547f.get() || this.f13548g)) {
            this.f13548g = true;
            this.f13545d.mo4199h();
        }
    }

    public boolean m17824b() {
        return m17822a() || this.f13549h;
    }
}
