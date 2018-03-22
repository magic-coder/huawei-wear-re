package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;

/* compiled from: CustomViewDialog */
public class C6027z extends Dialog {
    private C6027z(Context context, int i) {
        super(context, i);
    }

    public static int m27600a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
