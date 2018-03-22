package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import java.util.regex.Pattern;

/* compiled from: EditRelationSettingActivity */
class dl implements TextWatcher {
    final /* synthetic */ EditRelationSettingActivity f6036a;
    private CharSequence f6037b;
    private int f6038c;
    private int f6039d;

    dl(EditRelationSettingActivity editRelationSettingActivity) {
        this.f6036a = editRelationSettingActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6037b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
        Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
        this.f6038c = this.f6036a.f5698s.getSelectionStart();
        this.f6039d = this.f6036a.f5698s.getSelectionEnd();
        if (compile.matcher(this.f6037b).matches() && this.f6037b.length() > 4) {
            C2538c.m12674b("RelationSettingActivity", "========纯中文");
            editable.delete(this.f6038c - 1, this.f6039d);
            this.f6036a.f5698s.setText(editable);
            this.f6036a.f5698s.setSelection(editable.length());
        } else if (compile2.matcher(this.f6037b).matches() && this.f6037b.length() > 10) {
            C2538c.m12674b("RelationSettingActivity", "========纯英文");
            editable.delete(this.f6038c - 1, this.f6039d);
            this.f6036a.f5698s.setText(editable);
            this.f6036a.f5698s.setSelection(editable.length());
        } else if (this.f6037b.length() > 4 && this.f6036a.m9315a(this.f6037b.toString())) {
            C2538c.m12674b("RelationSettingActivity", "========有汉字");
            editable.delete(this.f6038c - 1, this.f6039d);
            this.f6036a.f5698s.setText(editable);
            this.f6036a.f5698s.setSelection(editable.length());
        } else if (this.f6037b.length() > 10) {
            C2538c.m12674b("RelationSettingActivity", "========其它字符");
            editable.delete(this.f6038c - 1, this.f6039d);
            this.f6036a.f5698s.setText(editable);
            this.f6036a.f5698s.setSelection(editable.length());
        }
    }
}
