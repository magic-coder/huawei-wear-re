package com.huawei.pluginaf500.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.huawei.hwcommonmodel.p064d.C4725b;
import com.huawei.p190v.C2538c;

import java.io.File;

/* compiled from: CommonUtil */
public class C5821d {
    private static String f20005a = (Environment.getExternalStorageDirectory() + "/");
    private static final String[] f20006b = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    public static String m26900a() {
        return f20005a + "DCIM/Camera/";
    }

    public static String[] m26906b() {
        return (String[]) f20006b.clone();
    }

    private C5821d() {
    }

    public static int m26898a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static void m26901a(int i, Context context) {
    }

    public static void m26903a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            synchronized (C5821d.class) {
                boolean mkdirs = file.mkdirs();
                C2538c.c("CommonUtil", new Object[]{"isExist mkdir ret=" + mkdirs});
            }
        }
    }

    public static int m26899a(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            return ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        }
        return 0;
    }

    public static int m26905b(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            return ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        }
        return 0;
    }

    public static int m26907c(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            return ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        }
        return 0;
    }

    public static boolean m26904a(Context context, String[] strArr) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        C2538c.c("CommonUtil", new Object[]{"hasPermission =" + C4725b.m22616a(context, strArr)});
        return C4725b.m22616a(context, strArr);
    }

    public static void m26902a(Activity activity, String[] strArr) {
        C4725b.m22614a(activity, strArr, new C5822e());
    }
}
