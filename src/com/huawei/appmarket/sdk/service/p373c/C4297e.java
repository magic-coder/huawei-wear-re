package com.huawei.appmarket.sdk.service.p373c;

import android.content.Context;
import android.net.SSLSessionCache;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public class C4297e implements HttpClient {
    private static String[] f16002a = new String[]{"text/", "application/xml", "application/json"};
    private final HttpClient f16003b;
    private RuntimeException f16004c = new IllegalStateException("AndroidHttpClient created and never closed");
    private volatile C4301h f16005d;

    private C4297e(ClientConnectionManager clientConnectionManager, HttpParams httpParams, ThreadLocal<C4294b> threadLocal) {
        this.f16003b = new C4299f(this, clientConnectionManager, httpParams, threadLocal);
    }

    public static C4297e m20732a(String str, Context context, ThreadLocal<C4294b> threadLocal) {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        if (context != null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(context);
        }
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new C4297e(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams, threadLocal);
    }

    public static C4297e m20733a(String str, ThreadLocal<C4294b> threadLocal) {
        return C4297e.m20732a(str, null, threadLocal);
    }

    private static boolean m20736a(HttpUriRequest httpUriRequest) {
        Header[] headers = httpUriRequest.getHeaders("content-encoding");
        if (headers != null) {
            for (Header value : headers) {
                if ("gzip".equalsIgnoreCase(value.getValue())) {
                    return true;
                }
            }
        }
        Header[] headers2 = httpUriRequest.getHeaders("content-type");
        if (headers2 == null) {
            return true;
        }
        for (Header header : headers2) {
            for (String startsWith : f16002a) {
                if (header.getValue().startsWith(startsWith)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String m20737b(HttpUriRequest httpUriRequest, boolean z) throws IOException {
        Object uri;
        HttpEntity entity;
        OutputStream byteArrayOutputStream;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("curl ");
        stringBuilder.append("-X ");
        stringBuilder.append(httpUriRequest.getMethod());
        stringBuilder.append(HwAccountConstants.BLANK);
        for (Header header : httpUriRequest.getAllHeaders()) {
            if (z || !(header.getName().equals(AUTH.WWW_AUTH_RESP) || header.getName().equals("Cookie"))) {
                stringBuilder.append("--header \"");
                stringBuilder.append(header.toString().trim());
                stringBuilder.append("\" ");
            }
        }
        URI uri2 = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            HttpRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) original).getURI();
                stringBuilder.append("\"");
                stringBuilder.append(uri);
                stringBuilder.append("\"");
                if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
                    entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
                    if (entity != null && entity.isRepeatable()) {
                        if (entity.getContentLength() >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            entity.writeTo(byteArrayOutputStream);
                            if (C4297e.m20736a(httpUriRequest)) {
                                stringBuilder.append(" --data-ascii \"").append(byteArrayOutputStream.toString("utf-8")).append("\"");
                            } else {
                                stringBuilder.insert(0, "echo '" + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2) + "' | base64 -d > /tmp/$$.bin; ");
                                stringBuilder.append(" --data-binary @/tmp/$$.bin");
                            }
                        } else {
                            stringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
        URI uri3 = uri2;
        stringBuilder.append("\"");
        stringBuilder.append(uri);
        stringBuilder.append("\"");
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            if (entity.getContentLength() >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                stringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
            } else {
                byteArrayOutputStream = new ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                if (C4297e.m20736a(httpUriRequest)) {
                    stringBuilder.append(" --data-ascii \"").append(byteArrayOutputStream.toString("utf-8")).append("\"");
                } else {
                    stringBuilder.insert(0, "echo '" + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2) + "' | base64 -d > /tmp/$$.bin; ");
                    stringBuilder.append(" --data-binary @/tmp/$$.bin");
                }
            }
        }
        return stringBuilder.toString();
    }

    public void m20738a() {
        if (this.f16004c != null) {
            getConnectionManager().shutdown();
            this.f16004c = null;
        }
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return this.f16003b.execute(httpHost, httpRequest, (ResponseHandler) responseHandler);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return this.f16003b.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return this.f16003b.execute(httpUriRequest, (ResponseHandler) responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return this.f16003b.execute(httpUriRequest, (ResponseHandler) responseHandler, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return this.f16003b.execute(httpHost, httpRequest);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return this.f16003b.execute(httpHost, httpRequest, httpContext);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return this.f16003b.execute(httpUriRequest);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return this.f16003b.execute(httpUriRequest, httpContext);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.f16004c != null) {
            Log.e("AndroidHttpClient", "Leak found", this.f16004c);
            this.f16004c = null;
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return this.f16003b.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.f16003b.getParams();
    }
}
