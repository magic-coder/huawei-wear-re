package com.huawei.ui.main.stories.guide.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2385g implements TextWatcher {
    final /* synthetic */ BasicInfoSettingActivity f8648a;

    C2385g(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8648a = basicInfoSettingActivity;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C2538c.m12677c("BasicInfoSettingActivity", "onTextChanged is enter!  new name is :" + this.f8648a.f8608n.getText().toString());
    }

    public void afterTextChanged(Editable editable) {
    }
}
