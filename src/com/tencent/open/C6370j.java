package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;

/* compiled from: ProGuard */
public abstract class C6370j extends Dialog {
    protected C6418g f22155c;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient f22156d = new C6420k(this);

    protected abstract void mo5333a(String str);

    public C6370j(Context context, int i) {
        super(context, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22155c = new C6418g();
    }
}
