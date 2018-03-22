package com.huawei.ui.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;

/* compiled from: CustomLoadingDialog */
public class C6009h {
    private Context f20703a;
    private boolean f20704b = true;
    private OnCancelListener f20705c;
    private OnKeyListener f20706d;
    private C6007f f20707e;
    private C6010i f20708f;

    public C6009h(Context context, Boolean bool) {
        this.f20703a = context;
        this.f20707e = new C6007f(context, bool);
        this.f20708f = this.f20707e.m27558a();
    }

    public C6009h m27562a(int i) {
        Object string = this.f20703a.getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.f20708f.m27567a(string);
        }
        return this;
    }

    public C6009h m27561a() {
        this.f20708f.m27568b();
        return this;
    }

    public C6007f m27564b() {
        return m27560c();
    }

    public C6009h m27563a(boolean z) {
        this.f20704b = z;
        return this;
    }

    private C6007f m27560c() {
        this.f20707e.addContentView(this.f20708f.m27566a(), new LayoutParams(-2, -2));
        this.f20707e.setContentView(this.f20708f.m27566a());
        this.f20707e.setCancelable(this.f20704b);
        this.f20707e.setOnCancelListener(this.f20705c);
        this.f20707e.setOnKeyListener(this.f20706d);
        return this.f20707e;
    }
}
