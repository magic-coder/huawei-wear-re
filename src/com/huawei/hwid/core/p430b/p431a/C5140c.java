package com.huawei.hwid.core.p430b.p431a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.C5200d;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p430b.p431a.C5125a.C5122d;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p428c.C5115a;
import com.huawei.hwid.vermanager.C5313c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;

/* compiled from: HttpUtil */
public class C5140c {
    public static HttpResponse m24808a(Context context, C5125a c5125a, String str) throws UnsupportedEncodingException, IllegalArgumentException, IllegalStateException, IOException, SSLPeerUnverifiedException {
        Object httpPost = new HttpPost(c5125a.m24679a(context));
        HttpClient a = C5313c.m25694a().mo4682a(context, 18080, 18443);
        if (a == null) {
            C5165e.m24910d("HttpUtil", "httpClient init Failed");
            throw new UnknownHostException("ERROR");
        }
        HttpEntity stringEntity;
        C5165e.m24906b("HttpUtil", "the post request URI is:" + C5203g.m25321c(c5125a.m24679a(context)));
        String name = c5125a.getClass().getName();
        C5165e.m24906b("HttpUtil", "GlobalSiteId = " + c5125a.m24711s() + ", request = " + name.substring(name.lastIndexOf(".") + 1));
        httpPost.addHeader("Connection", "Keep-Alive");
        if (C5122d.URLType.equals(c5125a.m24678a())) {
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        } else {
            httpPost.addHeader("Content-Type", "text/html; charset=UTF-8");
        }
        C5140c.m24809a(context, httpPost, c5125a, str);
        httpPost.getParams().setIntParameter("http.socket.timeout", 20000);
        httpPost.getParams().setIntParameter("http.connection.timeout", 20000);
        HttpClientParams.setRedirecting(httpPost.getParams(), false);
        if (c5125a.m24678a().equals(C5122d.URLType)) {
            stringEntity = new StringEntity(c5125a.mo4633f(), GameManager.DEFAULT_CHARSET);
            C5165e.m24906b("HttpUtil", "request.urlencode()  ");
        } else {
            stringEntity = new StringEntity(c5125a.mo4629e(), GameManager.DEFAULT_CHARSET);
        }
        httpPost.setEntity(stringEntity);
        try {
            C5165e.m24912e("HttpUtil", "direct connect start!");
            return a.execute(httpPost);
        } catch (Throwable e) {
            if (e instanceof UnsupportedEncodingException) {
                throw new UnsupportedEncodingException("UnsupportedEncodingException[don't set proxy]:" + e.getMessage());
            } else if ((e instanceof SSLPeerUnverifiedException) || (e instanceof SSLHandshakeException) || (e instanceof SSLException)) {
                C5165e.m24911d("HttpUtil", e.getMessage(), e);
                throw new SSLPeerUnverifiedException("SSL Exception");
            } else if (e instanceof IllegalArgumentException) {
                throw new IllegalArgumentException("IllegalArgumentException[don't set proxy]:" + e.getMessage());
            } else if (e instanceof IllegalStateException) {
                throw new IllegalStateException("IllegalStateException[don't set proxy]:" + e.getMessage());
            } else if (e instanceof IOException) {
                C5165e.m24911d("HttpUtil", e.getMessage(), e);
                throw new IOException("IOException[don't set proxy]:" + e.getMessage());
            } else {
                throw new UnknownHostException("don't set proxy");
            }
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static void m24809a(Context context, HttpPost httpPost, C5125a c5125a, String str) {
        String str2 = "";
        HwAccount b = C5115a.m24641a(context).m24646b();
        if (b == null) {
            b = C5115a.m24641a(context).m24647c();
        }
        if (b != null) {
            str2 = C5115a.m24641a(context).m24642a(b.m25124d());
        }
        C5165e.m24904a("HttpUtil", "addHeader cookie= " + C5203g.m25316a(str2));
        httpPost.addHeader("Cookie", str2);
        switch (c5125a.m24709q()) {
            case 0:
                httpPost.addHeader(AUTH.WWW_AUTH_RESP, String.valueOf(System.currentTimeMillis()));
                return;
            case 1:
                if (b != null) {
                    Object g = b.m25130g();
                    Object d = b.m25124d();
                    C5165e.m24904a("HttpUtil", "userId = " + C5203g.m25318a("userId", d));
                    if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(g)) {
                        String str3 = System.currentTimeMillis() + ":" + new SecureRandom().nextInt(1000);
                        httpPost.addHeader(AUTH.WWW_AUTH_RESP, "Digest user=" + d + "," + "nonce" + "=" + str3 + "," + "response" + "=" + C5200d.m25303a(str3 + ":" + c5125a.m24710r(), g));
                        return;
                    }
                    return;
                }
                C5165e.m24908c("HttpUtil", "account is null ");
                return;
            default:
                return;
        }
    }
}
