package com.huawei.openalliance.ad.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.File;

public class C1364h {
    public static String m6073a(Context context) {
        if (C1364h.m6074a()) {
            String c = C1364h.m6077c(context);
            if (c != null) {
                return c;
            }
        }
        return C1364h.m6075b(context);
    }

    public static boolean m6074a() {
        return "mounted".equals(Environment.getExternalStorageState()) || !C1364h.m6076b();
    }

    public static String m6075b(Context context) {
        if (context == null) {
            return "";
        }
        File filesDir = context.getFilesDir();
        return filesDir == null ? "" : filesDir.getAbsolutePath();
    }

    @TargetApi(9)
    protected static boolean m6076b() {
        return C1367k.m6082a() ? Environment.isExternalStorageRemovable() : true;
    }

    public static String m6077c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        } catch (Exception e) {
            C1336d.m5888c("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }
}
