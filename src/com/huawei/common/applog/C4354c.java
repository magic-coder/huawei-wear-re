package com.huawei.common.applog;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: LogWrite */
public final class C4354c {
    private static int f16183a = 3;
    private static BufferedWriter f16184b = null;
    private static boolean f16185c = false;
    private static boolean f16186d = false;
    private static String f16187e = null;
    private static String f16188f = null;
    private static int f16189g = 204800;

    /* compiled from: LogWrite */
    class C4353a implements Serializable, Comparator<File> {
        private C4353a() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m20925a((File) obj, (File) obj2);
        }

        public int m20925a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    public static void m20927a(int i, String str, int i2, boolean z) {
        f16186d = z;
        if (i > 0) {
            f16189g = i;
        }
        if (i2 > 0) {
            if (i2 > 50) {
                i2 = 50;
            }
            f16183a = i2;
        }
        if (str != null) {
            f16187e = str;
            f16185c = true;
        } else {
            f16185c = false;
        }
        if (f16185c) {
            File file = new File(f16187e);
            if (file.exists() || file.mkdirs()) {
                C4354c.m20928a(f16187e, C4354c.m20931b());
            }
        }
    }

    private static void m20928a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("LogWrite", "createNewLogFile Exception");
            return;
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null && listFiles.length >= f16183a) {
            try {
                Arrays.sort(listFiles, new C4353a());
            } catch (IllegalArgumentException e) {
                Log.e("LogWrite", "Arrays sort IllegalArgumentException");
            }
            C4354c.m20930a(listFiles);
        }
        OutputStream fileOutputStream = new FileOutputStream(new File(str, str2));
        synchronized (C4354c.class) {
            if (f16184b != null) {
                try {
                    f16184b.close();
                } catch (IOException e2) {
                    Log.e("LogWrite", "createNewLogFile IOException");
                }
            }
            try {
                f16184b = new BufferedWriter(new OutputStreamWriter(fileOutputStream, GameManager.DEFAULT_CHARSET));
                f16188f = str2;
            } catch (IOException e3) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    Log.e("LogWrite", "createNewLogFile out.close Exception");
                }
            }
        }
    }

    private static boolean m20930a(File[] fileArr) {
        if (fileArr == null || fileArr.length <= 0) {
            return false;
        }
        return fileArr[0].delete();
    }

    private static void m20932b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e("LogWrite", "openLogFile Exception");
            return;
        }
        OutputStream fileOutputStream = new FileOutputStream(new File(str, str2), true);
        synchronized (C4354c.class) {
            try {
                f16184b = new BufferedWriter(new OutputStreamWriter(fileOutputStream, GameManager.DEFAULT_CHARSET));
                f16188f = str2;
            } catch (IOException e) {
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e("LogWrite", "openLogFile out.close Exception");
                }
            }
        }
    }

    private static String m20931b() {
        return Process.myPid() + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(Calendar.getInstance().getTime()) + ".log";
    }

    public static void m20926a() {
        synchronized (C4354c.class) {
            if (f16184b != null) {
                try {
                    f16184b.close();
                } catch (IOException e) {
                    Log.e("LogWrite", "shutdown IOException");
                }
            }
            f16184b = null;
        }
    }

    public static void m20929a(String str, String str2, String str3, Throwable th) {
        synchronized (C4354c.class) {
            try {
                if (TextUtils.isEmpty(f16187e) || TextUtils.isEmpty(f16188f)) {
                    Log.e("LogWrite", "wtf Exception");
                    return;
                }
                if (new File(f16187e, f16188f).length() > ((long) f16189g)) {
                    C4354c.m20928a(f16187e, C4354c.m20931b());
                } else if (f16184b == null) {
                    C4354c.m20932b(f16187e, f16188f);
                }
                f16184b.append(String.format(Locale.getDefault(), "%s: %s/%s: %s", new Object[]{C4354c.m20933c(), str, str2, str3 + '\n' + Log.getStackTraceString(th)}));
                f16184b.flush();
            } catch (IOException e) {
                Log.e("LogWrite", "wtf IOException");
            }
        }
    }

    private static String m20933c() {
        return new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(Calendar.getInstance().getTime());
    }
}
