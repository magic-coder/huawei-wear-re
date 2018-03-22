package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.regex.Pattern;

/* compiled from: AddContactActivity */
class C1876r implements TextWatcher {
    final /* synthetic */ AddContactActivity f6181a;
    private CharSequence f6182b;
    private int f6183c;
    private int f6184d;

    C1876r(AddContactActivity addContactActivity) {
        this.f6181a = addContactActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6182b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
        Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
        this.f6183c = this.f6181a.f5405p.getSelectionStart();
        this.f6184d = this.f6181a.f5405p.getSelectionEnd();
        if (compile.matcher(this.f6182b).matches() && this.f6182b.length() > this.f6181a.f5407r) {
            editable.delete(this.f6183c - 1, this.f6184d);
            this.f6181a.f5405p.setText(editable);
            this.f6181a.f5405p.setSelection(editable.length());
        } else if (compile2.matcher(this.f6182b).matches() && this.f6182b.length() > this.f6181a.f5408s) {
            editable.delete(this.f6183c - 1, this.f6184d);
            this.f6181a.f5405p.setText(editable);
            this.f6181a.f5405p.setSelection(editable.length());
        } else if (this.f6182b.length() > this.f6181a.f5407r && this.f6181a.m8994b(this.f6182b.toString())) {
            editable.delete(this.f6183c - 1, this.f6184d);
            this.f6181a.f5405p.setText(editable);
            this.f6181a.f5405p.setSelection(editable.length());
        } else if (this.f6182b.length() > this.f6181a.f5408s) {
            editable.delete(this.f6183c - 1, this.f6184d);
            this.f6181a.f5405p.setText(editable);
            this.f6181a.f5405p.setSelection(editable.length());
        }
    }
}
