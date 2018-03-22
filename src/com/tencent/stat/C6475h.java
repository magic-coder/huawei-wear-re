package com.tencent.stat;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.System;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6456f;
import com.tencent.stat.p545b.C6463m;
import com.tencent.stat.p545b.C6468r;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class C6475h {
    private static C6475h f22506b = null;
    private C6452b f22507a = C6463m.m29449b();
    private boolean f22508c = false;
    private boolean f22509d = false;
    private boolean f22510e = false;
    private Context f22511f = null;

    private C6475h(Context context) {
        this.f22511f = context.getApplicationContext();
        this.f22508c = m29568b(context);
        this.f22509d = m29570d(context);
        this.f22510e = m29569c(context);
    }

    public static synchronized C6475h m29567a(Context context) {
        C6475h c6475h;
        synchronized (C6475h.class) {
            if (f22506b == null) {
                f22506b = new C6475h(context);
            }
            c6475h = f22506b;
        }
        return c6475h;
    }

    private boolean m29568b(Context context) {
        if (C6463m.m29446a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        this.f22507a.m29411f("Check permission failed: android.permission.WRITE_EXTERNAL_STORAGE");
        return false;
    }

    private boolean m29569c(Context context) {
        if (C6463m.m29446a(context, "android.permission.WRITE_SETTINGS")) {
            return true;
        }
        this.f22507a.m29411f("Check permission failed: android.permission.WRITE_SETTINGS");
        return false;
    }

    private boolean m29570d(Context context) {
        return C6463m.m29455d() < 14 ? m29568b(context) : true;
    }

    public boolean m29571a(String str, String str2) {
        C6468r.m29496b(this.f22511f, str, str2);
        return true;
    }

    public String m29572b(String str, String str2) {
        return C6468r.m29493a(this.f22511f, str, str2);
    }

    public boolean m29573c(String str, String str2) {
        if (!this.f22508c) {
            return false;
        }
        try {
            C6456f.m29417a(Environment.getExternalStorageDirectory() + "/" + "Tencent/mta");
            File file = new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt");
            if (file != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(str + "," + str2);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            }
            return true;
        } catch (Throwable th) {
            this.f22507a.m29409d(th);
            return false;
        }
    }

    public String m29574d(String str, String str2) {
        if (!this.f22508c) {
            return null;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt");
            if (file != null) {
                for (String split : C6456f.m29418a(file)) {
                    String[] split2 = split.split(",");
                    if (split2.length == 2 && split2[0].equals(str)) {
                        return split2[1];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            this.f22507a.m29409d("Tencent/mta/.mid.txt not found.");
        } catch (Throwable th) {
            this.f22507a.m29409d(th);
        }
        return null;
    }

    public boolean m29575e(String str, String str2) {
        if (!this.f22510e) {
            return false;
        }
        System.putString(this.f22511f.getContentResolver(), str, str2);
        return true;
    }

    public String m29576f(String str, String str2) {
        return !this.f22510e ? str2 : System.getString(this.f22511f.getContentResolver(), str);
    }
}
