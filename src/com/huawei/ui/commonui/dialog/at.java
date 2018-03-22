package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: SecurityManagerSettingSwitchDialog */
final class at extends ClickableSpan {
    final /* synthetic */ Dialog f20669a;
    final /* synthetic */ Context f20670b;
    final /* synthetic */ String f20671c;

    at(Dialog dialog, Context context, String str) {
        this.f20669a = dialog;
        this.f20670b = context;
        this.f20671c = str;
    }

    public void onClick(View view) {
        this.f20669a.dismiss();
        if (this.f20670b != null) {
            an.m27520b(this.f20670b, this.f20671c, 0);
        }
    }
}
