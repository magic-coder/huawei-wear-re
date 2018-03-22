package com.huawei.androidcommon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.huawei.androidcommon.constants.AC;

public class ToastUtil {
    private static Toast toast;
    private static View view;

    private ToastUtil() {
    }

    @SuppressLint({"ShowToast"})
    private static void getToast(Context context) {
        if (toast == null) {
            toast = new Toast(context);
        }
        if (view == null) {
            view = Toast.makeText(context, "", 0).getView();
        }
        toast.setView(view);
    }

    public static void showShortToast(Context context, CharSequence charSequence) {
        showToast(context.getApplicationContext(), charSequence, 0);
    }

    public static void showShortToast(Context context, int i) {
        showToast(context.getApplicationContext(), i, 0);
    }

    public static void showLongToast(Context context, CharSequence charSequence) {
        showToast(context.getApplicationContext(), charSequence, 1);
    }

    public static void showLongToast(Context context, int i) {
        showToast(context.getApplicationContext(), i, 1);
    }

    private static void showToast(Context context, CharSequence charSequence, int i) {
        try {
            getToast(context);
            toast.setText(charSequence);
            toast.setDuration(i);
            toast.show();
        } catch (Throwable e) {
            Log.e(AC.TAG, e.getMessage(), e);
        }
    }

    private static void showToast(Context context, int i, int i2) {
        if (i != 0) {
            try {
                getToast(context);
                toast.setText(i);
                toast.setDuration(i2);
                toast.show();
            } catch (Throwable e) {
                Log.e(AC.TAG, e.getMessage(), e);
            }
        }
    }
}
