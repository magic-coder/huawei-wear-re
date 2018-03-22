package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;

/* compiled from: NoTitleCustomAlertDialog */
public class ai extends Dialog {
    private ai(Context context, int i) {
        super(context, i);
    }

    public static int m27500a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
