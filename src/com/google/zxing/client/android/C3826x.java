package com.google.zxing.client.android;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: VersionUtil */
public class C3826x {
    private static final String f14840a = C3826x.class.getSimpleName();
    private static int f14841b;

    static {
        C3826x.m19091b();
    }

    private static void m19091b() {
        f14841b = C3826x.m19092c();
    }

    public static boolean m19090a() {
        return f14841b >= 11;
    }

    private static int m19092c() {
        int intValue;
        Object a = C3826x.m19089a("com.huawei.android.os.BuildEx$VERSION", "EMUI_SDK_INT");
        if (a != null) {
            try {
                intValue = ((Integer) a).intValue();
            } catch (ClassCastException e) {
                Log.w(f14840a, "getEMUIVersionCode is not a number");
            }
            Log.i(f14840a, "the emui version code is::" + intValue);
            return intValue;
        }
        intValue = 0;
        Log.i(f14840a, "the emui version code is::" + intValue);
        return intValue;
    }

    public static Object m19089a(String str, String str2) {
        Object obj = null;
        Class a = C3826x.m19088a(str);
        if (a != null && !TextUtils.isEmpty(str2) && "com.huawei.android.os.BuildEx$VERSION".equals(str) && "EMUI_SDK_INT".equals(str2)) {
            try {
                AccessibleObject.setAccessible(new Field[]{a.getDeclaredField(str2)}, true);
                obj = r2.get(a);
            } catch (IllegalAccessException e) {
                Log.w(f14840a, "Exception in getFieldObj :: IllegalAccessException");
            } catch (IllegalArgumentException e2) {
                Log.w(f14840a, "Exception in getFieldObj :: IllegalArgumentException");
            } catch (NoSuchFieldException e3) {
                Log.w(f14840a, "Exception in getFieldObj :: NoSuchFieldException");
            } catch (SecurityException e4) {
                Log.w(f14840a, "not security int method getStaticFieldObj");
            }
        }
        return obj;
    }

    public static Class<?> m19088a(String str) {
        Class<?> cls = null;
        if (!TextUtils.isEmpty(str) && ("com.huawei.android.os.BuildEx$VERSION".equals(str) || "com.huawei.android.immersion.ImmersionStyle".equals(str))) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e) {
                Log.w(f14840a, "className not found:" + str);
            }
        }
        return cls;
    }
}
