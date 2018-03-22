package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.C6419h;
import com.tencent.open.p541a.C6367n;
import com.tencent.open.p543c.C6387b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6424d extends C6419h {
    private String f22290d;

    public C6424d(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.f22290d = str2;
    }

    public void mo5339a(Object obj) {
        C6367n.m29107b("openSDK_LOG.SL", "-->onComplete, result: " + obj);
    }

    public void mo5338a() {
        C6367n.m29107b("openSDK_LOG.SL", "-->onNoMatchMethod...");
    }

    public void mo5340a(String str) {
        C6367n.m29107b("openSDK_LOG.SL", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        if (!C6387b.f22207a) {
            i = -4;
        }
        try {
            jSONObject.put("result", i);
            jSONObject.put("sn", this.b);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m29286b(jSONObject.toString());
    }

    private void m29286b(String str) {
        WebView webView = (WebView) this.a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!").append(this.f22290d).append("){");
            stringBuffer.append(this.f22290d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            C6367n.m29107b("openSDK_LOG", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }
}
