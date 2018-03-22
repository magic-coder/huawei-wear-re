package com.tencent.open.p541a;

import android.os.Environment;

/* compiled from: ProGuard */
public final class C6363j {
    public static boolean m29092a() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static C6364k m29093b() {
        if (C6363j.m29092a()) {
            return C6364k.m29094b(Environment.getExternalStorageDirectory());
        }
        return null;
    }
}
