package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import java.util.regex.Pattern;

/* compiled from: TailorContactActivity */
class gu implements TextWatcher {
    final /* synthetic */ TailorContactActivity f6164a;
    private CharSequence f6165b;
    private int f6166c;
    private int f6167d;

    gu(TailorContactActivity tailorContactActivity) {
        this.f6164a = tailorContactActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6165b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
        Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
        this.f6166c = this.f6164a.f5897d.getSelectionStart();
        this.f6167d = this.f6164a.f5897d.getSelectionEnd();
        if (compile.matcher(this.f6165b).matches() && this.f6165b.length() > this.f6164a.f5915v) {
            C2538c.m12674b("TailorContactActivity", "========纯中文");
            editable.delete(this.f6166c - 1, this.f6167d);
            this.f6164a.f5897d.setText(editable);
            this.f6164a.f5897d.setSelection(editable.length());
        } else if (compile2.matcher(this.f6165b).matches() && this.f6165b.length() > this.f6164a.f5916w) {
            C2538c.m12674b("TailorContactActivity", "========纯英文");
            editable.delete(this.f6166c - 1, this.f6167d);
            this.f6164a.f5897d.setText(editable);
            this.f6164a.f5897d.setSelection(editable.length());
        } else if (this.f6165b.length() > this.f6164a.f5915v && this.f6164a.m9545b(this.f6165b.toString())) {
            C2538c.m12674b("TailorContactActivity", "========有汉字");
            editable.delete(this.f6166c - 1, this.f6167d);
            this.f6164a.f5897d.setText(editable);
            this.f6164a.f5897d.setSelection(editable.length());
        } else if (this.f6165b.length() > this.f6164a.f5916w) {
            C2538c.m12674b("TailorContactActivity", "========其它字符");
            editable.delete(this.f6166c - 1, this.f6167d);
            this.f6164a.f5897d.setText(editable);
            this.f6164a.f5897d.setSelection(editable.length());
        }
    }
}
