package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import java.util.regex.Pattern;

/* compiled from: ContactInfoActivity */
class bl implements TextWatcher {
    final /* synthetic */ ContactInfoActivity f5967a;
    private CharSequence f5968b;
    private int f5969c;
    private int f5970d;

    bl(ContactInfoActivity contactInfoActivity) {
        this.f5967a = contactInfoActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f5968b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
        Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
        this.f5969c = this.f5967a.f5545R.getSelectionStart();
        this.f5970d = this.f5967a.f5545R.getSelectionEnd();
        if (compile.matcher(this.f5968b).matches() && this.f5968b.length() > 4) {
            C2538c.m12674b("ContactInfoActivity", "========纯中文");
            editable.delete(this.f5969c - 1, this.f5970d);
            this.f5967a.f5545R.setText(editable);
            this.f5967a.f5545R.setSelection(editable.length());
        } else if (compile2.matcher(this.f5968b).matches() && this.f5968b.length() > 10) {
            C2538c.m12674b("ContactInfoActivity", "========纯英文");
            editable.delete(this.f5969c - 1, this.f5970d);
            this.f5967a.f5545R.setText(editable);
            this.f5967a.f5545R.setSelection(editable.length());
        } else if (this.f5968b.length() > 4 && this.f5967a.m9156c(this.f5968b.toString())) {
            C2538c.m12674b("ContactInfoActivity", "========有汉字");
            editable.delete(this.f5969c - 1, this.f5970d);
            this.f5967a.f5545R.setText(editable);
            this.f5967a.f5545R.setSelection(editable.length());
        } else if (this.f5968b.length() > 10) {
            C2538c.m12674b("ContactInfoActivity", "========其它字符");
            editable.delete(this.f5969c - 1, this.f5970d);
            this.f5967a.f5545R.setText(editable);
            this.f5967a.f5545R.setSelection(editable.length());
        }
    }
}
