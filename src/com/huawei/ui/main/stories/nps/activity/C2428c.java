package com.huawei.ui.main.stories.nps.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.mode.Records;

/* compiled from: FiledFragment */
class C2428c implements TextWatcher {
    final /* synthetic */ C2427b f8759a;

    C2428c(C2427b c2427b) {
        this.f8759a = c2427b;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f8759a.f8755e = charSequence.toString();
            if (Records.queryInt(this.f8759a.f8756f)) {
                Records.getStringDataCenter().remove(this.f8759a.f8756f);
                Records.getStringDataCenter().put(this.f8759a.f8756f, this.f8759a.f8755e);
            } else {
                Records.getStringDataCenter().put(this.f8759a.f8756f, this.f8759a.f8755e);
            }
            C2538c.m12677c(this.f8759a.f8751a, "finish Filed question successful:" + Records.getStringDataCenter());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
    }
}
