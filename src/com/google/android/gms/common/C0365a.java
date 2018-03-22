package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C0424f;

public class C0365a extends DialogFragment {
    private Dialog f262a = null;
    private OnCancelListener f263b = null;

    public static C0365a m326a(Dialog dialog, OnCancelListener onCancelListener) {
        C0365a c0365a = new C0365a();
        Dialog dialog2 = (Dialog) C0424f.m650a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0365a.f262a = dialog2;
        if (onCancelListener != null) {
            c0365a.f263b = onCancelListener;
        }
        return c0365a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f263b != null) {
            this.f263b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f262a == null) {
            setShowsDialog(false);
        }
        return this.f262a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
