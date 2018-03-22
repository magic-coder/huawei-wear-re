package com.huawei.openalliance.ad.utils.p119c;

import com.huawei.openalliance.ad.utils.p129b.C1336d;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class C1348c {
    private HttpParams f2934a;
    private ClientConnectionManager f2935b;

    class C1351a extends DefaultConnectionKeepAliveStrategy {
        C1351a() {
        }
    }

    public C1348c() {
        m5956a();
    }

    @SuppressWarnings(justification = "h00193325/There will be a lot of exceptions, but the business does not need to be distinguished, just catch the Exception type", value = {"REC_CATCH_EXCEPTION"})
    private void m5956a() {
        SocketFactory c1350b;
        this.f2934a = new BasicHttpParams();
        ConnManagerParams.setMaxTotalConnections(this.f2934a, mo2460b());
        ConnManagerParams.setTimeout(this.f2934a, (long) mo2462d());
        ConnManagerParams.setMaxConnectionsPerRoute(this.f2934a, new ConnPerRouteBean(mo2461c()));
        HttpConnectionParams.setConnectionTimeout(this.f2934a, m5960e());
        HttpConnectionParams.setSoTimeout(this.f2934a, m5961f());
        HttpProtocolParams.setVersion(this.f2934a, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            c1350b = new C1350b(null);
        } catch (Throwable e) {
            C1336d.m5883a("HttpConnectionManager", "creat ssl socket exception", e);
            c1350b = null;
        } catch (Throwable e2) {
            C1336d.m5883a("HttpConnectionManager", "creat ssl socket exception", e2);
            c1350b = null;
        } catch (Throwable e22) {
            C1336d.m5883a("HttpConnectionManager", "creat ssl socket exception", e22);
            c1350b = null;
        } catch (Throwable e222) {
            C1336d.m5883a("HttpConnectionManager", "creat ssl socket exception", e222);
            c1350b = null;
        }
        if (c1350b == null) {
            c1350b = SSLSocketFactory.getSocketFactory();
            C1336d.m5888c("HttpConnectionManager", "use default ssl socket factory");
        }
        c1350b.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        schemeRegistry.register(new Scheme("https", c1350b, 443));
        this.f2935b = new ThreadSafeClientConnManager(this.f2934a, schemeRegistry);
    }

    protected int mo2460b() {
        return 25;
    }

    protected int mo2461c() {
        return 10;
    }

    protected int mo2462d() {
        return 6000;
    }

    protected int m5960e() {
        return 5000;
    }

    protected int m5961f() {
        return 10000;
    }

    protected HttpRequestRetryHandler m5962g() {
        return new DefaultHttpRequestRetryHandler(2, true);
    }

    public HttpClient m5963h() {
        HttpClient defaultHttpClient = new DefaultHttpClient(this.f2935b, this.f2934a);
        defaultHttpClient.setKeepAliveStrategy(new C1351a());
        defaultHttpClient.setHttpRequestRetryHandler(m5962g());
        return defaultHttpClient;
    }
}
