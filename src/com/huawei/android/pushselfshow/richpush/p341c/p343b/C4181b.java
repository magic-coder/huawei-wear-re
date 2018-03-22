package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import android.app.Activity;
import android.webkit.WebView;
import com.huawei.android.pushagent.c.a.e;
import java.util.LinkedList;
import org.json.JSONObject;

public class C4181b {
    public WebView f15738a;
    private final LinkedList f15739b = new LinkedList();
    private final C4182d f15740c;
    private final Activity f15741d;
    private String f15742e;

    public C4181b(Activity activity, WebView webView, String str) {
        e.a("PushSelfShowLog", "activity is " + activity);
        e.a("PushSelfShowLog", "webView is " + webView);
        e.a("PushSelfShowLog", "localPath is " + str);
        this.f15741d = activity;
        this.f15738a = webView;
        this.f15742e = str;
        this.f15740c = new C4183c(this);
        m20371a();
    }

    private boolean m20370b() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.f15739b.isEmpty();
        }
        return isEmpty;
    }

    public void m20371a() {
        synchronized (this) {
            this.f15739b.clear();
        }
    }

    public void m20372a(String str, C4189j c4189j, String str2, JSONObject jSONObject) {
        try {
            e.a("PushSelfShowLog", "addPluginResult status is " + C4188i.m20377a()[c4189j.ordinal()]);
            if (str == null) {
                e.e("JsMessageQueue", "Got plugin result with no callbackId");
                return;
            }
            C4184e c4184e = new C4184e(jSONObject == null ? new C4188i(str2, c4189j) : new C4188i(str2, c4189j, jSONObject), str);
            synchronized (this) {
                this.f15739b.add(c4184e);
                if (this.f15740c != null) {
                    this.f15740c.mo4387a();
                }
            }
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "addPluginResult failed", e);
        }
    }
}
