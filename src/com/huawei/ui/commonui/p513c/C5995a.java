package com.huawei.ui.commonui.p513c;

import android.content.Context;
import android.widget.Toast;

/* compiled from: ToastUtil */
public class C5995a {
    public static void m27436a(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 1);
        makeText.setText(str);
        makeText.show();
    }

    public static void m27435a(Context context, int i) {
        Toast makeText = Toast.makeText(context, i, 1);
        makeText.setText(i);
        makeText.show();
    }

    public static void m27438b(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.setText(str);
        makeText.show();
    }

    public static void m27437b(Context context, int i) {
        Toast makeText = Toast.makeText(context, i, 0);
        makeText.setText(i);
        makeText.show();
    }
}
