package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.internal.bn;

public abstract class aa implements OnClickListener {
    public static aa m519a(Activity activity, Intent intent, int i) {
        return new ab(intent, activity, i);
    }

    public static aa m520a(@NonNull bn bnVar, Intent intent, int i) {
        return new ac(intent, bnVar, i);
    }

    protected abstract void mo1758a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo1758a();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
