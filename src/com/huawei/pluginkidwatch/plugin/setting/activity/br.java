package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import java.util.regex.Pattern;

/* compiled from: RelationSettingActivity */
class br implements TextWatcher {
    final /* synthetic */ RelationSettingActivity f6639a;
    private CharSequence f6640b;
    private int f6641c;
    private int f6642d;

    br(RelationSettingActivity relationSettingActivity) {
        this.f6639a = relationSettingActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6640b = charSequence;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
        Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
        this.f6641c = this.f6639a.f6441s.getSelectionStart();
        this.f6642d = this.f6639a.f6441s.getSelectionEnd();
        if (compile.matcher(this.f6640b).matches() && this.f6640b.length() > 4) {
            C2538c.m12674b("RelationSettingActivity", "========纯中文");
            editable.delete(this.f6641c - 1, this.f6642d);
            this.f6639a.f6441s.setText(editable);
            this.f6639a.f6441s.setSelection(editable.length());
        } else if (compile2.matcher(this.f6640b).matches() && this.f6640b.length() > 10) {
            C2538c.m12674b("RelationSettingActivity", "========纯英文");
            editable.delete(this.f6641c - 1, this.f6642d);
            this.f6639a.f6441s.setText(editable);
            this.f6639a.f6441s.setSelection(editable.length());
        } else if (this.f6640b.length() > 4 && this.f6639a.m9954a(this.f6640b.toString())) {
            C2538c.m12674b("RelationSettingActivity", "========有汉字");
            editable.delete(this.f6641c - 1, this.f6642d);
            this.f6639a.f6441s.setText(editable);
            this.f6639a.f6441s.setSelection(editable.length());
        } else if (this.f6640b.length() > 10) {
            C2538c.m12674b("RelationSettingActivity", "========其它字符");
            editable.delete(this.f6641c - 1, this.f6642d);
            this.f6639a.f6441s.setText(editable);
            this.f6639a.f6441s.setSelection(editable.length());
        }
    }
}
