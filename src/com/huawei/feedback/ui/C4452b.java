package com.huawei.feedback.ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FeedbackDetailActivity */
class C4452b implements TextWatcher {
    final /* synthetic */ FeedbackDetailActivity f16573a;

    C4452b(FeedbackDetailActivity feedbackDetailActivity) {
        this.f16573a = feedbackDetailActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f16573a.m21308f();
    }
}
