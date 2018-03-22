package com.huawei.hms.update.p045a;

import android.content.Context;
import android.os.Environment;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.p039c.C0853b;
import com.huawei.hms.p039c.C0854c;
import com.huawei.hms.p039c.C0858f;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p045a.p046a.C0890a;
import com.huawei.hms.update.p045a.p046a.C0891b;
import com.huawei.hms.update.p045a.p046a.C0892c;
import com.huawei.hms.update.p047b.C0909a;
import com.huawei.hms.update.p047b.C0910d;
import com.huawei.hms.update.p047b.C0911b;
import com.huawei.hms.update.provider.UpdateProvider;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: OtaUpdateDownload */
public class C0899f implements C0890a {
    private final Context f1473a;
    private final C0910d f1474b = new C0911b();
    private C0891b f1475c;
    private File f1476d;
    private final C0896c f1477e = new C0896c();

    public C0899f(Context context) {
        this.f1473a = context.getApplicationContext();
    }

    private synchronized void m3156b(C0891b c0891b) {
        this.f1475c = c0891b;
    }

    private synchronized void m3153a(int i, int i2, int i3) {
        if (this.f1475c != null) {
            this.f1475c.mo2269a(i, i2, i3, this.f1476d);
        }
    }

    public Context mo2264a() {
        return this.f1473a;
    }

    public void mo2267b() {
        C0887a.m3094b("OtaUpdateDownload", "Enter cancel.");
        m3156b(null);
        this.f1474b.mo2275b();
    }

    public void mo2265a(C0891b c0891b) {
        throw new IllegalStateException("Not supported.");
    }

    public void mo2266a(C0891b c0891b, C0892c c0892c) {
        C0852a.m3001a(c0891b, "callback must not be null.");
        C0887a.m3094b("OtaUpdateDownload", "Enter downloadPackage.");
        m3156b(c0891b);
        if (c0892c == null || !c0892c.m3120a()) {
            C0887a.m3098d("OtaUpdateDownload", "In downloadPackage, Invalid update info.");
            m3153a(2201, 0, 0);
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f1476d = UpdateProvider.getLocalFile(this.f1473a, "hms/HwMobileService.apk");
            if (this.f1476d == null) {
                C0887a.m3098d("OtaUpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
                m3153a(2204, 0, 0);
                return;
            }
            File parentFile = this.f1476d.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                C0887a.m3098d("OtaUpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
                m3153a(2201, 0, 0);
                return;
            } else if (parentFile.getUsableSpace() < ((long) (c0892c.f1437c * 3))) {
                C0887a.m3098d("OtaUpdateDownload", "In downloadPackage, No space for downloading file.");
                m3153a(2203, 0, 0);
                return;
            } else {
                try {
                    m3160a(c0892c);
                    return;
                } catch (C0909a e) {
                    C0887a.m3096c("OtaUpdateDownload", "In downloadPackage, Canceled to download the update file.");
                    m3153a(2101, 0, 0);
                    return;
                }
            }
        }
        C0887a.m3098d("OtaUpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
        m3153a(2204, 0, 0);
    }

    private static boolean m3155a(String str, File file) {
        byte[] a = C0858f.m3021a(file);
        if (a != null) {
            return C0853b.m3006b(a, true).equalsIgnoreCase(str);
        }
        return false;
    }

    void m3160a(C0892c c0892c) throws C0909a {
        C0887a.m3094b("OtaUpdateDownload", "Enter downloadPackage.");
        OutputStream outputStream = null;
        try {
            this.f1477e.m3130a(mo2264a());
            if (!this.f1477e.m3134b(c0892c.f1436b, c0892c.f1437c, c0892c.f1438d)) {
                this.f1477e.m3132a(c0892c.f1436b, c0892c.f1437c, c0892c.f1438d);
                outputStream = m3152a(this.f1476d, c0892c.f1437c);
            } else if (this.f1477e.m3133b() != this.f1477e.m3129a()) {
                outputStream = m3152a(this.f1476d, c0892c.f1437c);
                outputStream.m3162a((long) this.f1477e.m3133b());
            } else if (C0899f.m3155a(c0892c.f1438d, this.f1476d)) {
                m3153a(2000, 0, 0);
                return;
            } else {
                this.f1477e.m3132a(c0892c.f1436b, c0892c.f1437c, c0892c.f1438d);
                outputStream = m3152a(this.f1476d, c0892c.f1437c);
            }
            int a = this.f1474b.mo2273a(c0892c.f1436b, outputStream, this.f1477e.m3133b(), this.f1477e.m3129a());
            if (a != 200 && a != 206) {
                C0887a.m3098d("OtaUpdateDownload", "In DownloadHelper.downloadPackage, Download the package, HTTP code: " + a);
                m3153a(2201, 0, 0);
                this.f1474b.mo2274a();
                C0854c.m3010a(outputStream);
            } else if (C0899f.m3155a(c0892c.f1438d, this.f1476d)) {
                m3153a(2000, 0, 0);
                this.f1474b.mo2274a();
                C0854c.m3010a(outputStream);
            } else {
                m3153a(2202, 0, 0);
                this.f1474b.mo2274a();
                C0854c.m3010a(outputStream);
            }
        } catch (IOException e) {
            C0887a.m3098d("OtaUpdateDownload", "In DownloadHelper.downloadPackage, Failed to download." + e.getMessage());
            m3153a(2201, 0, 0);
        } finally {
            this.f1474b.mo2274a();
            C0854c.m3010a(outputStream);
        }
    }

    private C0900h m3152a(File file, int i) throws IOException {
        return new C0901g(this, file, i, i);
    }
}
