package com.huawei.hwid.core.p435d.p437b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.File;

/* compiled from: ILogX */
public abstract class C5161b {
    static String f18611a = "";

    /* compiled from: ILogX */
    class C5160a {
        static String m24876a(Context context) {
            String str = C5160a.m24878b(context) + "/Log/";
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return str;
            }
            return null;
        }

        private static String m24878b(Context context) {
            if (C5160a.m24877a()) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    return externalFilesDir.getAbsolutePath();
                }
            }
            return context.getFilesDir().getAbsolutePath();
        }

        private static boolean m24877a() {
            if ("mounted".equals(Environment.getExternalStorageState()) || !C5160a.m24879b()) {
                return true;
            }
            return false;
        }

        @TargetApi(9)
        private static boolean m24879b() {
            if (VERSION.SDK_INT >= 9) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        }
    }

    abstract void mo4637a(String str, String str2);

    abstract void mo4638a(String str, String str2, Throwable th);

    abstract void mo4639b(String str, String str2);

    abstract void mo4640b(String str, String str2, Throwable th);

    abstract void mo4641c(String str, String str2);

    static String m24880a(Context context) {
        String str = "";
        if (context != null && "com.huawei.hwid".equals(context.getPackageName())) {
            try {
                str = "HwID_APK_log[" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + "]:";
            } catch (NameNotFoundException e) {
                Log.e("hwid", "getVersionTag error" + e.getMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return HwAccountConstants.HWID_SDK_LOG;
        }
        return str;
    }
}
