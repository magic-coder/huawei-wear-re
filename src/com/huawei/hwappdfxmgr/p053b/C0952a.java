package com.huawei.hwappdfxmgr.p053b;

import android.content.Context;
import android.os.Process;
import com.huawei.hwappdfxmgr.b.b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: CrashHandler */
public class C0952a implements UncaughtExceptionHandler {
    private static final String f1542a = C0952a.class.getSimpleName();
    private static C0952a f1543b = new C0952a();
    private static final Object f1544g = new Object();
    private UncaughtExceptionHandler f1545c;
    private DateFormat f1546d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);
    private Context f1547e;
    private String f1548f;

    private C0952a() {
    }

    public static C0952a m3323a() {
        C0952a c0952a;
        synchronized (f1544g) {
            c0952a = f1543b;
        }
        return c0952a;
    }

    public void m3329a(Context context) {
        C2538c.m12677c(f1542a, "init()");
        this.f1547e = context;
        this.f1545c = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f1548f = BaseApplication.m2632b().getFilesDir().getAbsolutePath() + "/log/" + BaseApplication.m2632b().getPackageName();
        C2538c.m12674b(f1542a, "path = " + this.f1548f);
        new Thread(new b(this, new File(this.f1548f))).start();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C2538c.m12680e(f1542a, "uncaughtException()");
        if (m3325a(th) || this.f1545c == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                C2538c.m12680e(f1542a, e.getMessage());
            } finally {
                Process.killProcess(Process.myPid());
            }
        } else {
            this.f1545c.uncaughtException(thread, th);
        }
    }

    private boolean m3325a(Throwable th) {
        if (th == null) {
            C2538c.m12677c(f1542a, "handleException() ex null");
            return false;
        }
        C2538c.m12677c(f1542a, "handleException()");
        C2538c.m12680e(f1542a, th, th.getMessage());
        Map hashMap = new HashMap();
        hashMap.put("Exception", th.getMessage());
        c.a().a(this.f1547e, a.cm.a(), hashMap, 0);
        c.a().a(this.f1547e);
        m3327b(th);
        return true;
    }

    private void m3327b(Throwable th) {
        FileOutputStream fileOutputStream;
        FileNotFoundException e;
        Throwable th2;
        Exception e2;
        C2538c.m12677c(f1542a, "saveCrashInfo()");
        try {
            String format = this.f1546d.format(new Date());
            fileOutputStream = new FileOutputStream(m3328c(), true);
            try {
                PrintStream printStream = new PrintStream(fileOutputStream, false, GameManager.DEFAULT_CHARSET);
                printStream.print(format + "\n");
                th.printStackTrace(printStream);
                printStream.flush();
                printStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        C2538c.m12680e(f1542a, "close fos fail", e3);
                    }
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                try {
                    C2538c.m12680e(f1542a, "a FileNotFoundException occured while writing file...", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e32) {
                            C2538c.m12680e(f1542a, "close fos fail", e32);
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            C2538c.m12680e(f1542a, "close fos fail", e5);
                        }
                    }
                    throw th2;
                }
            } catch (Exception e6) {
                e2 = e6;
                C2538c.m12680e(f1542a, "an Exception occured while writing file...", e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e322) {
                        C2538c.m12680e(f1542a, "close fos fail", e322);
                    }
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream = null;
            C2538c.m12680e(f1542a, "a FileNotFoundException occured while writing file...", e);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Exception e8) {
            e2 = e8;
            fileOutputStream = null;
            C2538c.m12680e(f1542a, "an Exception occured while writing file...", e2);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th2;
        }
    }

    private File m3328c() {
        File file = new File(this.f1548f + "/huawei_crashLog_0.txt");
        if (file.exists() && file.length() > 1048576) {
            File file2 = new File(this.f1548f + "/huawei_crashLog_" + 2 + ".txt");
            if (!file2.exists() || file2.delete()) {
                int i = 1;
                while (i >= 0) {
                    File file3 = new File(this.f1548f + "/huawei_crashLog_" + i + ".txt");
                    if (!file3.exists() || file3.renameTo(new File(this.f1548f + "/huawei_crashLog_" + (i + 1) + ".txt"))) {
                        i--;
                    } else {
                        C2538c.m12679d(f1542a, "rename log file failed");
                        return null;
                    }
                }
            }
            C2538c.m12679d(f1542a, "delete log file failed");
            return null;
        }
        return file;
    }
}
