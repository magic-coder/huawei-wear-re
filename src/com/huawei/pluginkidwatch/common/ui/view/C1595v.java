package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: CustomDialog */
public class C1595v {
    private Context f3979a;
    private boolean f3980b = true;
    private OnCancelListener f3981c;
    private OnKeyListener f3982d;
    private CustomDialog f3983e;
    private C1597x f3984f;

    public C1595v(Context context) {
        this.f3979a = context;
        this.f3983e = new CustomDialog(context);
        this.f3984f = this.f3983e.m7203a();
        CustomDialog.f3800a = new ButtonHandler(this.f3983e);
    }

    public C1595v m7346a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3984f.m7361a(str);
        }
        return this;
    }

    public C1595v m7339a(int i) {
        String string = this.f3979a.getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.f3984f.m7361a(string);
        }
        return this;
    }

    public C1595v m7351b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f3984f.m7363b(str);
        }
        return this;
    }

    public C1595v m7348b(int i) {
        String string = this.f3979a.getString(i);
        if (!TextUtils.isEmpty(string)) {
            this.f3984f.m7363b(string);
        }
        return this;
    }

    public C1595v m7343a(View view) {
        this.f3984f.m7359a(view);
        return this;
    }

    public C1595v m7344a(C1596w c1596w) {
        this.f3984f.m7360a(c1596w);
        return this;
    }

    public C1595v m7340a(int i, OnClickListener onClickListener) {
        String str = (String) this.f3979a.getText(i);
        if (!TextUtils.isEmpty(str)) {
            this.f3984f.m7362a(str, onClickListener);
        }
        return this;
    }

    public C1595v m7345a(CharSequence charSequence, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f3984f.m7362a((String) charSequence, onClickListener);
        }
        return this;
    }

    public C1595v m7349b(int i, OnClickListener onClickListener) {
        String str = (String) this.f3979a.getText(i);
        if (!TextUtils.isEmpty(str)) {
            this.f3984f.m7364b(str, onClickListener);
        }
        return this;
    }

    public C1595v m7350b(CharSequence charSequence, OnClickListener onClickListener) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f3984f.m7364b((String) charSequence, onClickListener);
        }
        return this;
    }

    public CustomDialog m7338a() {
        return m7337b();
    }

    public C1595v m7347a(boolean z) {
        this.f3980b = z;
        return this;
    }

    public C1595v m7341a(OnCancelListener onCancelListener) {
        this.f3981c = onCancelListener;
        return this;
    }

    public C1595v m7342a(OnKeyListener onKeyListener) {
        this.f3982d = onKeyListener;
        return this;
    }

    private CustomDialog m7337b() {
        this.f3983e.addContentView(this.f3984f.m7358a(), new LayoutParams(-2, -2));
        this.f3983e.setContentView(this.f3984f.m7358a());
        this.f3983e.setCancelable(this.f3980b);
        this.f3983e.setOnCancelListener(this.f3981c);
        this.f3983e.setOnKeyListener(this.f3982d);
        return this.f3983e;
    }
}
