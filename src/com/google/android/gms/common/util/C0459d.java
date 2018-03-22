package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.cy;

public class C0459d {
    public static boolean m812a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (cy.m1181b(context).m1177a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
