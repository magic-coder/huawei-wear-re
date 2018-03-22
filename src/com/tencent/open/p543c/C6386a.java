package com.tencent.open.p543c;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class C6386a extends WebView {
    public C6386a(Context context) {
        super(context);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings != null) {
            try {
                Method method = settings.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
                if (method != null) {
                    method.invoke(this, new Object[]{"searchBoxJavaBridge_"});
                }
            } catch (Exception e) {
            }
        }
    }
}
