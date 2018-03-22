package com.huawei.hwid.p423a;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* compiled from: HwBuildEx */
public class C5061a {
    public static final String f18272a = C5061a.m24354a("ro.build.version.emui", "");

    /* compiled from: HwBuildEx */
    public class C5060a {
        public static final int f18271a = C5061a.m24353a("ro.build.hw_emui_api_level", 0);
    }

    public static String m24354a(String str, String str2) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        Log.e("HwBuildEx", "An exception occurred while reading: EMUI_VERSION");
        return str2;
    }

    public static int m24353a(String str, int i) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            i = ((Integer) cls.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (ClassNotFoundException e) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        } catch (NoSuchMethodException e2) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        } catch (IllegalAccessException e3) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        } catch (IllegalArgumentException e4) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        } catch (InvocationTargetException e5) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        } catch (ClassCastException e6) {
            Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
            return i;
        }
        return i;
    }
}
