package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* compiled from: AlarmTitleRegexUtil */
final class C1887c implements TextWatcher {
    final /* synthetic */ EditText f6208a;

    C1887c(EditText editText) {
        this.f6208a = editText;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!C1886b.m9650a(charSequence.toString())) {
            CharSequence subSequence = charSequence.subSequence(i, i + i3);
            CharSequence subSequence2 = charSequence.subSequence(0, i);
            CharSequence subSequence3 = i + i3 >= charSequence.length() ? "" : charSequence.subSequence(i + i3, charSequence.length());
            if (subSequence.length() <= 1) {
                this.f6208a.setText(subSequence2.toString() + subSequence3);
                this.f6208a.setSelection(this.f6208a.getText().length() - subSequence3.length());
                return;
            }
            for (int length = subSequence.length() - 2; length >= 0; length--) {
                String substring = subSequence.toString().substring(0, length + 1);
                if (C1886b.m9650a(subSequence2 + substring + subSequence3)) {
                    this.f6208a.setText(subSequence2.toString() + substring + subSequence3);
                    this.f6208a.setSelection(this.f6208a.getText().length() - subSequence3.length());
                    return;
                }
            }
            this.f6208a.setText(subSequence2.toString() + subSequence3);
            this.f6208a.setSelection(this.f6208a.getText().length() - subSequence3.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
