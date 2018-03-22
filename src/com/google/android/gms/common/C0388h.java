package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.an;
import com.google.android.gms.common.util.C0462g;
import com.google.android.gms.internal.cy;
import net.sqlcipher.database.SQLiteDatabase;

public class C0388h {
    private static final C0388h f304a = new C0388h();
    public static final int f305b = C0391p.f311b;

    C0388h() {
    }

    static String m413b(@Nullable Context context, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f305b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(cy.m1181b(context).m1180b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int mo1742a(Context context) {
        int b = C0391p.m451b(context);
        return C0391p.m453b(context, b) ? 18 : b;
    }

    @Nullable
    public PendingIntent mo1743a(Context context, int i, int i2) {
        return mo1744a(context, i, i2, null);
    }

    @Nullable
    public PendingIntent mo1744a(Context context, int i, int i2, @Nullable String str) {
        Intent b = mo1747b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    public boolean mo1745a(int i) {
        return C0391p.m452b(i);
    }

    public boolean m418a(Context context, String str) {
        return C0391p.m450a(context, str);
    }

    @Nullable
    @Deprecated
    public Intent mo1746b(int i) {
        return mo1747b(null, i, null);
    }

    @Nullable
    public Intent mo1747b(Context context, int i, @Nullable String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !C0462g.m818b(context)) ? an.m620a("com.google.android.gms", C0388h.m413b(context, str)) : an.m618a();
            case 3:
                return an.m619a("com.google.android.gms");
            default:
                return null;
        }
    }

    public boolean mo1748b(Context context, int i) {
        return C0391p.m453b(context, i);
    }

    public String mo1749c(int i) {
        return C0391p.m446a(i);
    }

    public void m423c(Context context) {
        C0391p.m456e(context);
    }
}
