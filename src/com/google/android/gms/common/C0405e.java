package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.C0424f;

public class C0405e extends DialogFragment {
    private Dialog f332a = null;
    private OnCancelListener f333b = null;

    public static C0405e m487a(Dialog dialog, OnCancelListener onCancelListener) {
        C0405e c0405e = new C0405e();
        Dialog dialog2 = (Dialog) C0424f.m650a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0405e.f332a = dialog2;
        if (onCancelListener != null) {
            c0405e.f333b = onCancelListener;
        }
        return c0405e;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f333b != null) {
            this.f333b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f332a == null) {
            setShowsDialog(false);
        }
        return this.f332a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
