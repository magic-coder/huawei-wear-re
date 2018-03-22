package com.huawei.ui.commonui.dialog;

import android.app.Dialog;
import android.content.Context;

/* compiled from: CustomTextAlertDialog */
public class C6022u extends Dialog {
    private C6022u(Context context, int i) {
        super(context, i);
    }

    public static int m27581a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
