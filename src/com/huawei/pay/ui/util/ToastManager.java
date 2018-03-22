package com.huawei.pay.ui.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.ag.e;
import com.huawei.ag.f;
import com.huawei.cp3.widget.C4372a;

public class ToastManager {
    public static void show(Context context, int i) {
        show(context, i, 0);
    }

    public static void show(Context context, String str) {
        show(context, str, 0);
    }

    public static void show(Context context, int i, int i2) {
        show(context, context.getResources().getString(i), i2);
    }

    public static void show(Context context, String str, int i) {
        if (C4372a.m20999a()) {
            Toast.makeText(context, str, i).show();
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(f.hwpay_toast, null);
        ((TextView) inflate.findViewById(e.hb_toast)).setText(str);
        Toast toast = new Toast(context);
        toast.setView(inflate);
        toast.setDuration(i);
        toast.show();
    }
}
