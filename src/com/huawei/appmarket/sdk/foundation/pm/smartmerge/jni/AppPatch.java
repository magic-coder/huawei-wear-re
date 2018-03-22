package com.huawei.appmarket.sdk.foundation.pm.smartmerge.jni;

import android.content.Context;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.p367e.C4282b;
import com.huawei.appmarket.sdk.service.p372b.C4292a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AppPatch {
    private static AppPatch f15978a;

    public static synchronized AppPatch m20703a() {
        AppPatch appPatch;
        synchronized (AppPatch.class) {
            if (f15978a == null) {
                f15978a = new AppPatch();
                f15978a.m20705c();
            }
            appPatch = f15978a;
        }
        return appPatch;
    }

    private String m20704b() {
        InputStream open;
        OutputStream openFileOutput;
        Throwable e;
        Throwable th;
        String str = "libapppatch.so";
        Context b = C4292a.m20708a().m20709b();
        String str2 = b.getFilesDir() + "/" + str;
        if (!new File(str2).exists()) {
            try {
                open = b.getAssets().open(str);
                try {
                    int available = open.available();
                    byte[] bArr = new byte[available];
                    if (open.read(bArr) != available) {
                        C4282b.m20664a(null);
                        C4282b.m20663a(open);
                        return null;
                    }
                    openFileOutput = b.openFileOutput(str, 0);
                    try {
                        openFileOutput.write(bArr);
                        C4282b.m20664a(openFileOutput);
                        C4282b.m20663a(open);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            C4241a.m20530a("Bspatch", "exception:copySoFile failed", e);
                            C4282b.m20664a(openFileOutput);
                            C4282b.m20663a(open);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            C4282b.m20664a(openFileOutput);
                            C4282b.m20663a(open);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    openFileOutput = null;
                    C4241a.m20530a("Bspatch", "exception:copySoFile failed", e);
                    C4282b.m20664a(openFileOutput);
                    C4282b.m20663a(open);
                    return null;
                } catch (Throwable e4) {
                    openFileOutput = null;
                    th = e4;
                    C4282b.m20664a(openFileOutput);
                    C4282b.m20663a(open);
                    throw th;
                }
            } catch (IOException e5) {
                e4 = e5;
                openFileOutput = null;
                open = null;
                C4241a.m20530a("Bspatch", "exception:copySoFile failed", e4);
                C4282b.m20664a(openFileOutput);
                C4282b.m20663a(open);
                return null;
            } catch (Throwable e42) {
                openFileOutput = null;
                open = null;
                th = e42;
                C4282b.m20664a(openFileOutput);
                C4282b.m20663a(open);
                throw th;
            }
        }
        return str2;
    }

    private void m20705c() {
        try {
            System.loadLibrary("apppatch");
        } catch (Throwable e) {
            C4241a.m20530a("Bspatch", "loadLibrary error, trying to load lib from local agagin", e);
            m20706d();
        } catch (Throwable e2) {
            C4241a.m20530a("Bspatch", "load exception!", e2);
        }
    }

    private void m20706d() {
        try {
            String b = m20704b();
            if (b != null) {
                System.load(b);
            }
        } catch (Throwable e) {
            C4241a.m20530a("Bspatch", "loadlibFromlocal error:" + null, e);
        }
    }

    private native int patch(String str, String str2, String str3);

    public synchronized int m20707a(String str, String str2, String str3) {
        File file = new File(str2);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                C4241a.m20530a("Bspatch", "merginDiffPatch ", e);
            }
        }
        return patch(str, str2, str3);
    }
}
