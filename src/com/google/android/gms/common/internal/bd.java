package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cy;

public class bd {
    private static Object f427a = new Object();
    private static boolean f428b;
    private static String f429c;
    private static int f430d;

    public static int m643a(Context context) {
        m644b(context);
        return f430d;
    }

    private static void m644b(Context context) {
        synchronized (f427a) {
            if (f428b) {
                return;
            }
            f428b = true;
            try {
                Bundle bundle = cy.m1181b(context).m1177a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f429c = bundle.getString("com.google.app.id");
                f430d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
