package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import com.huawei.ui.commonui.C6035l;

/* compiled from: CustomLoadingDialog */
public class C6007f extends Dialog {
    private C6010i f20701a;
    private Context f20702b;

    private C6007f(Context context, Boolean bool) {
        this(context, C6035l.CustomDialog, bool);
    }

    private C6007f(Context context, int i, Boolean bool) {
        super(context, i);
        this.f20702b = context;
        this.f20701a = new C6010i(context, bool);
    }

    public void m27559a(int i) {
        this.f20701a.m27567a(this.f20702b.getString(i));
    }

    public C6010i m27558a() {
        return this.f20701a;
    }
}
