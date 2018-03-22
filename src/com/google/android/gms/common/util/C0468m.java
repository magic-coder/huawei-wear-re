package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0452q;
import com.google.android.gms.internal.cy;

public final class C0468m {
    public static boolean m833a(Context context, int i) {
        boolean z = false;
        if (!C0468m.m834a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C0452q.m785a(context).m789a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m834a(Context context, int i, String str) {
        return cy.m1181b(context).m1179a(i, str);
    }
}
