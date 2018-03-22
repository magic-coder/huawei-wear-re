package com.huawei.pluginaf500.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DialogUtils */
public class C5826i {
    public static void m26921a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (context == null) {
            C2538c.e("DialogUtils", new Object[]{"null == context"});
            return;
        }
        C5823f c5823f = new C5823f(context);
        c5823f.m26915a(i);
        c5823f.m26919b(i2);
        c5823f.m26920b(i3, onClickListener);
        c5823f.m26916a(i4, onClickListener2);
        c5823f.m26914a().show();
    }
}
