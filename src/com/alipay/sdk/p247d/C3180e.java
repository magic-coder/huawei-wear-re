package com.alipay.sdk.p247d;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class C3180e {
    private static boolean f10586a = (VERSION.SDK_INT >= 11);

    public static Dialog m14036a(Context context, String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        if (f10586a) {
            if (!TextUtils.isEmpty(str4)) {
                builder.setPositiveButton(str4, onClickListener2);
            }
            if (!TextUtils.isEmpty(str3)) {
                builder.setNegativeButton(str3, onClickListener);
            }
        } else {
            if (!TextUtils.isEmpty(str3)) {
                builder.setPositiveButton(str3, onClickListener);
            }
            if (!TextUtils.isEmpty(str4)) {
                builder.setNegativeButton(str4, onClickListener2);
            }
        }
        builder.setTitle(str);
        builder.setMessage(str2);
        Dialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new C3181f());
        try {
            create.show();
        } catch (Throwable th) {
        }
        return create;
    }
}
