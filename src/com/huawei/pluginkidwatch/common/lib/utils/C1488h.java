package com.huawei.pluginkidwatch.common.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.huawei.p190v.C2538c;
import java.io.File;

/* compiled from: ExternalStorageUtil */
public class C1488h {
    private static final String f3459a = Environment.getExternalStorageDirectory().getAbsolutePath();
    private static final String f3460b = (f3459a + File.separator + "hwsports" + File.separator + "photos");

    public static boolean m6883a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    public static String m6884b() {
        if (C1488h.m6883a()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        }
        return Environment.getDataDirectory().getAbsolutePath() + "/data/";
    }

    public static int m6880a(Activity activity) {
        try {
            String str = "";
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = Environment.getExternalStorageDirectory().toString();
            } else {
                str = activity.getFilesDir().toString();
            }
            StatFs statFs = new StatFs(str);
            return (int) ((((float) statFs.getAvailableBlocks()) * ((float) statFs.getBlockSize())) / 400000.0f);
        } catch (Exception e) {
            return -2;
        }
    }

    public static String m6881a(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(f3460b + File.separator + "avater");
        } else {
            file = new File(context.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "photos" + File.separator + "avater");
        }
        if (!(file.exists() || file.mkdirs())) {
            C2538c.m12680e("ExternalStorageUtil", "path.mkdirs return false");
        }
        return file.getAbsolutePath();
    }

    public static String m6885b(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(f3460b + File.separator + "avater");
        } else {
            file = new File(context.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "photos" + File.separator + "avater");
        }
        if (!(file.exists() || file.mkdirs())) {
            C2538c.m12680e("ExternalStorageUtil", "path.mkdirs return false");
        }
        return file.getAbsolutePath();
    }

    public static void m6882a(String str) {
        C2538c.m12674b("ExternalStorageUtil", "file extension: " + C1488h.m6886b(str));
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str2 = Environment.getExternalStorageDirectory() + "/kidwatch/SOS/";
            C2538c.m12674b("ExternalStorageUtil", "save path: " + str2);
            String str3 = "SOS_" + (System.currentTimeMillis() + "") + "." + str3;
            C2538c.m12674b("ExternalStorageUtil", "save file name: " + str3);
            return;
        }
        C2538c.m12674b("ExternalStorageUtil", "sd card is null, download fail!");
    }

    public static String m6886b(String str) {
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf > -1 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }
}
