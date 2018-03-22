package com.huawei.crowdtestsdk.utils;

import android.app.Dialog;

public class DialogManager {
    public static void showDialog(Dialog dialog) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public static void dismissDialog(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
