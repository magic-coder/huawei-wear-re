package com.huawei.appmarket.sdk.foundation.p367e;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import java.io.File;

public class C4287d {
    public static String m20692a(Context context) {
        if (C4287d.m20693a()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    return externalFilesDir.getAbsolutePath();
                }
            } catch (Throwable e) {
                C4241a.m20530a("StorageUtils", "getExternalFilesDir exception, use memory card folder.", e);
            }
        }
        return context.getFilesDir().getAbsolutePath();
    }

    public static boolean m20693a() {
        return "mounted".equals(Environment.getExternalStorageState()) || !C4287d.m20694b();
    }

    @TargetApi(9)
    protected static boolean m20694b() {
        return C4289f.m20697a() ? Environment.isExternalStorageRemovable() : true;
    }
}
