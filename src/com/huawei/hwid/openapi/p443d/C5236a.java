package com.huawei.hwid.openapi.p443d;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.sina.weibo.sdk.component.GameManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.util.EntityUtils;

public abstract class C5236a {
    protected static final String f18867a = C5213b.f18818a;

    private final HttpUriRequest m25396a(HttpUriRequest httpUriRequest) {
        httpUriRequest.addHeader("Connection", "Keep-Alive");
        if (C5238b.URLType.equals(mo4650c())) {
            httpUriRequest.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        } else {
            httpUriRequest.addHeader("Content-Type", "text/html; charset=UTF-8");
        }
        httpUriRequest.getParams().setIntParameter("http.socket.timeout", 15000);
        httpUriRequest.getParams().setIntParameter("http.connection.timeout", 15000);
        HttpClientParams.setRedirecting(httpUriRequest.getParams(), false);
        return httpUriRequest;
    }

    private HttpGet m25397e() {
        HttpUriRequest httpGet = new HttpGet(mo4649b());
        m25396a(httpGet);
        return httpGet;
    }

    private HttpPost m25398f() {
        try {
            C5248c.m25447b(f18867a, "the post request URI is:" + mo4649b());
            HttpUriRequest httpPost = new HttpPost(mo4649b());
            m25396a(httpPost);
            HttpEntity a = mo4648a();
            if (a == null) {
                return httpPost;
            }
            httpPost.setEntity(a);
            return httpPost;
        } catch (Throwable e) {
            C5248c.m25448b(f18867a, e.toString(), e);
            return null;
        }
    }

    public Bundle m25399a(HttpResponse httpResponse) {
        Bundle bundle = new Bundle();
        if (httpResponse != null) {
            bundle.putInt(ParamStr.RET_RES_CODE, httpResponse.getStatusLine().getStatusCode());
            bundle.putString(ParamStr.RET_RES_CONTENT, m25403b(httpResponse));
            Header[] allHeaders = httpResponse.getAllHeaders();
            Bundle bundle2 = new Bundle();
            for (Header header : allHeaders) {
                bundle2.putString(header.getName(), header.getValue());
            }
            bundle.putBundle(ParamStr.RET_RES_HEAD, bundle2);
        }
        return bundle;
    }

    public abstract HttpEntity mo4648a();

    public boolean m25401a(Bundle bundle) {
        if (OutReturn.getRetResCode(bundle) != 200) {
            return false;
        }
        CharSequence nspstatus = OutReturn.getNSPSTATUS(bundle);
        return TextUtils.isEmpty(nspstatus) || "0".equals(nspstatus);
    }

    public abstract String mo4649b();

    public String m25403b(HttpResponse httpResponse) {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C5248c.m25448b(f18867a, e.toString(), e);
            return null;
        }
    }

    public abstract C5238b mo4650c();

    public HttpUriRequest m25405d() {
        return mo4650c() == C5238b.URLType ? m25397e() : m25398f();
    }
}
