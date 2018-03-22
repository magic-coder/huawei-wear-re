package com.p230a.p231b.p232b.p233a.p236a;

import com.p230a.p231b.p232b.p233a.C3115m;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class C3092e implements C3091g {
    protected final HttpClient f10384a;

    public C3092e(HttpClient httpClient) {
        this.f10384a = httpClient;
    }

    private static void m13825a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, C3115m c3115m) {
        byte[] c = c3115m.mo3666c();
        if (c != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(c));
        }
    }

    private static void m13826a(HttpUriRequest httpUriRequest, Map map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public HttpResponse mo3655a(C3115m c3115m, Map map) {
        HttpUriRequest httpGet;
        HttpEntityEnclosingRequestBase httpPost;
        switch (c3115m.m13879d()) {
            case -1:
                byte[] m = c3115m.m13888m();
                if (m == null) {
                    httpGet = new HttpGet(c3115m.m13881f());
                    break;
                }
                httpGet = new HttpPost(c3115m.m13881f());
                httpGet.addHeader("Content-Type", c3115m.m13887l());
                httpGet.setEntity(new ByteArrayEntity(m));
                break;
            case 0:
                httpGet = new HttpGet(c3115m.m13881f());
                break;
            case 1:
                httpPost = new HttpPost(c3115m.m13881f());
                httpPost.addHeader("Content-Type", c3115m.mo3665b());
                C3092e.m13825a(httpPost, c3115m);
                break;
            case 2:
                httpPost = new HttpPut(c3115m.m13881f());
                httpPost.addHeader("Content-Type", c3115m.mo3665b());
                C3092e.m13825a(httpPost, c3115m);
                break;
            case 3:
                httpGet = new HttpDelete(c3115m.m13881f());
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        C3092e.m13826a(httpGet, map);
        C3092e.m13826a(httpGet, c3115m.mo3663a());
        m13828a(httpGet);
        HttpParams params = httpGet.getParams();
        int r = c3115m.m13893r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.f10384a.execute(httpGet);
    }

    protected void m13828a(HttpUriRequest httpUriRequest) {
    }
}
