package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import android.app.Activity;
import android.webkit.WebView;
import com.huawei.android.pushagent.c.a.e;

public class C4180a {
    public C4187h f15736a;
    private C4181b f15737b;

    public C4180a(Activity activity, WebView webView, String str, boolean z) {
        e.e("PushSelfShowLog", "init ExposedJsApi");
        this.f15736a = new C4187h(activity, z);
        this.f15737b = new C4181b(activity, webView, str);
    }
}
