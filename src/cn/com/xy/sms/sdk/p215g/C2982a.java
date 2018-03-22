package cn.com.xy.sms.sdk.p215g;

import android.util.Log;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p229l.C3041f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class C2982a {
    public static boolean f10101a = false;
    public static boolean f10102b = false;
    private static SimpleDateFormat f10103c = null;

    private static synchronized SimpleDateFormat m13413a() {
        SimpleDateFormat simpleDateFormat;
        synchronized (C2982a.class) {
            if (f10103c == null) {
                f10103c = new SimpleDateFormat("yyyy.MM.dd");
            }
            simpleDateFormat = f10103c;
        }
        return simpleDateFormat;
    }

    public static void m13414a(String str, String str2) {
        if (f10101a) {
            Log.e(str, str2);
        }
        C2982a.m13416b(str, str2);
    }

    public static void m13415a(String str, String str2, Throwable th) {
        while (true) {
            if (f10101a) {
                Log.e(str, str2, th);
            }
            C2982a.m13416b(str, str2);
            try {
                C3041f.m13609b().m13099a(str, str2, th);
                break;
            } catch (Throwable th2) {
                th = th2;
                str = "XIAOYUAN";
                str2 = "e: " + th.getMessage();
            }
        }
    }

    public static void m13416b(String str, String str2) {
        if (f10102b) {
            try {
                SimpleDateFormat a = C2982a.m13413a();
                synchronized (a) {
                    String format = a.format(Long.valueOf(System.currentTimeMillis()));
                    String str3 = C2917a.m13112e() + File.separator + "logs";
                    File file = new File(str3);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    PrintStream printStream = new PrintStream(new FileOutputStream(new StringBuilder(String.valueOf(str3)).append(File.separator).append(format).append(".ll.log").toString(), true));
                    printStream.println(new StringBuilder(String.valueOf(str)).append("  ").append(str2).append(" time=").append(System.currentTimeMillis()).toString());
                    printStream.close();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "writeLogToFile: " + th.getMessage(), th);
            }
        }
    }
}
