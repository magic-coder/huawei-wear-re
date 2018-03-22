package com.tencent.open;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class C6419h {
    protected WeakReference<WebView> f22282a;
    protected long f22283b;
    protected String f22284c;

    public C6419h(WebView webView, long j, String str) {
        this.f22282a = new WeakReference(webView);
        this.f22283b = j;
        this.f22284c = str;
    }

    public void mo5339a(Object obj) {
        WebView webView = (WebView) this.f22282a.get();
        if (webView != null) {
            String str = "'undefined'";
            if (obj instanceof String) {
                str = "'" + ((String) obj).replace("\\", "\\\\").replace("'", "\\'") + "'";
            } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                str = obj.toString();
            } else if (obj instanceof Boolean) {
                str = obj.toString();
            }
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f22283b + ",{'r':0,'result':" + str + "});");
        }
    }

    public void mo5338a() {
        WebView webView = (WebView) this.f22282a.get();
        if (webView != null) {
            webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.f22283b + ",{'r':1,'result':'no such method'})");
        }
    }

    public void mo5340a(String str) {
        WebView webView = (WebView) this.f22282a.get();
        if (webView != null) {
            webView.loadUrl("javascript:" + str);
        }
    }
}
