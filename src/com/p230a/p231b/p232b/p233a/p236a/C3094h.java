package com.p230a.p231b.p232b.p233a.p236a;

import com.p230a.p231b.p232b.p233a.C3115m;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class C3094h implements C3091g {
    private final C3095i f10385a;
    private final SSLSocketFactory f10386b;

    public C3094h() {
        this(null);
    }

    public C3094h(C3095i c3095i) {
        this(c3095i, null);
    }

    public C3094h(C3095i c3095i, SSLSocketFactory sSLSocketFactory) {
        this.f10385a = c3095i;
        this.f10386b = sSLSocketFactory;
    }

    private static HttpEntity m13831a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private static void m13832a(HttpURLConnection httpURLConnection, C3115m c3115m) {
        byte[] c = c3115m.mo3666c();
        if (c != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", c3115m.mo3665b());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(c);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m13833a(URL url) {
        if ("https".equalsIgnoreCase(url.getProtocol())) {
            C3090d.m13823a();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse mo3655a(C3115m c3115m, Map map) {
        String a;
        String f = c3115m.m13881f();
        HashMap hashMap = new HashMap();
        hashMap.putAll(c3115m.mo3663a());
        hashMap.putAll(map);
        if (this.f10385a != null) {
            a = this.f10385a.m13835a(f);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + f);
            }
        }
        a = f;
        URL url = new URL(a);
        HttpURLConnection a2 = m13833a(url);
        int r = c3115m.m13893r();
        a2.setConnectTimeout(r);
        a2.setReadTimeout(r);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f10386b != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(this.f10386b);
        }
        for (String str : hashMap.keySet()) {
            a2.addRequestProperty(str, (String) hashMap.get(str));
        }
        switch (c3115m.m13879d()) {
            case -1:
                byte[] m = c3115m.m13888m();
                if (m != null) {
                    a2.setDoOutput(true);
                    a2.setRequestMethod(HttpPost.METHOD_NAME);
                    a2.addRequestProperty("Content-Type", c3115m.m13887l());
                    DataOutputStream dataOutputStream = new DataOutputStream(a2.getOutputStream());
                    dataOutputStream.write(m);
                    dataOutputStream.close();
                    break;
                }
                break;
            case 0:
                a2.setRequestMethod(HttpGet.METHOD_NAME);
                break;
            case 1:
                a2.setRequestMethod(HttpPost.METHOD_NAME);
                C3094h.m13832a(a2, c3115m);
                break;
            case 2:
                a2.setRequestMethod(HttpPut.METHOD_NAME);
                C3094h.m13832a(a2, c3115m);
                break;
            case 3:
                a2.setRequestMethod("DELETE");
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(C3094h.m13831a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
