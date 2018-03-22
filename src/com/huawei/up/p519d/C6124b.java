package com.huawei.up.p519d;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.up.p520e.C6128b;
import com.huawei.up.p520e.C6133g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/* compiled from: HttpRequestBase */
public abstract class C6124b {
    static String f21156a = "https://setting1.hicloud.com/AccountServer";
    public String f21157b = f21156a;
    private Context f21158c;

    public static void m27889g(String str) {
        f21156a = str;
    }

    public C6124b(Context context) {
        this.f21158c = context;
    }

    public HttpResponse m27890a(HashMap<String, String> hashMap) {
        HttpHost a;
        HttpRequest a2 = C6128b.m27910a(this.f21157b, 30, 30, false);
        try {
            a = C6128b.m27907a(this.f21157b);
        } catch (C6133g e) {
            C2538c.b("HttpRequestBase", new Object[]{"NSPException() e=" + e.getMessage()});
            a = null;
        }
        if (a2 == null) {
            C2538c.b("HttpRequestBase", new Object[]{"null == httpPost"});
            return null;
        }
        HttpClient a3;
        String str = "" + System.currentTimeMillis();
        if (str != null && str.length() > 0) {
            a2.addHeader(AUTH.WWW_AUTH_RESP, str);
        }
        try {
            a3 = C6128b.m27909a(this.f21158c, this.f21157b);
        } catch (C6133g e2) {
            C2538c.b("HttpRequestBase", new Object[]{"NSPException() e=" + e2.getMessage()});
            a3 = null;
        }
        if (a3 == null) {
            C2538c.b("HttpRequestBase", new Object[]{"null == httpClient"});
            return null;
        }
        HttpResponse execute;
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry entry : hashMap.entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                stringBuilder.append(SNBConstant.FILTER + ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
        }
        C2538c.b("HttpRequestBase", new Object[]{"execute() url=" + this.f21157b});
        C2538c.b("HttpRequestBase", new Object[]{"execute() data=" + stringBuilder.toString()});
        try {
            a2.setEntity(new UrlEncodedFormEntity(arrayList, GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e3) {
            C2538c.b("HttpRequestBase", new Object[]{"UnsupportedEncodingException() e=" + e3.getMessage()});
        }
        try {
            execute = a3.execute(a, a2);
        } catch (IOException e4) {
            C2538c.b("HttpRequestBase", new Object[]{"IOException() e=" + e4.getMessage()});
            execute = null;
        }
        return execute;
    }

    public String mo5139d(String str) {
        HttpResponse httpResponse = null;
        C2538c.b("HttpRequestBase", new Object[]{"execute requestURL=" + this.f21157b});
        C2538c.b("HttpRequestBase", new Object[]{"execute xml=" + str});
        HttpRequest a = C6128b.m27910a(this.f21157b, 30, 30, false);
        try {
            HttpHost a2 = C6128b.m27907a(this.f21157b);
        } catch (C6133g e) {
            C2538c.b("HttpRequestBase", new Object[]{"NSPException() e=" + e.getMessage()});
            Object obj = httpResponse;
        }
        if (a == null) {
            C2538c.b("HttpRequestBase", new Object[]{"null == httpPost"});
            return "";
        }
        a.addHeader("Content-Type", "text/xml");
        try {
            a.setEntity(new StringEntity(str));
        } catch (UnsupportedEncodingException e2) {
            C2538c.b("HttpRequestBase", new Object[]{"UnsupportedEncodingException e=" + e2.getMessage()});
        }
        try {
            HttpClient a3 = C6128b.m27909a(this.f21158c, this.f21157b);
        } catch (C6133g e3) {
            C2538c.b("HttpRequestBase", new Object[]{"NSPException() e=" + e3.getMessage()});
            Object obj2 = httpResponse;
        }
        if (a3 == null) {
            C2538c.b("HttpRequestBase", new Object[]{"null == httpClient"});
            return "";
        }
        String entityUtils;
        try {
            httpResponse = a3.execute(a2, a);
        } catch (IOException e4) {
            C2538c.b("HttpRequestBase", new Object[]{"IOException() e=" + e4.getMessage()});
        }
        String str2 = "";
        if (httpResponse != null) {
            try {
                entityUtils = EntityUtils.toString(httpResponse.getEntity(), GameManager.DEFAULT_CHARSET);
            } catch (IOException e5) {
                C2538c.b("HttpRequestBase", new Object[]{"IOException() e1=" + e5.getMessage()});
                return str2;
            }
        }
        entityUtils = str2;
        return entityUtils;
    }
}
