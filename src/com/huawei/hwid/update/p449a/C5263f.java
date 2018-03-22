package com.huawei.hwid.update.p449a;

import android.content.Context;
import android.os.Environment;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.d.a;
import com.huawei.hwid.p075d.C5206b;
import com.huawei.hwid.p075d.C5207c;
import com.huawei.hwid.p075d.C5210e;
import com.huawei.hwid.update.p449a.p450a.C5252a;
import com.huawei.hwid.update.p449a.p450a.C5253b;
import com.huawei.hwid.update.p449a.p450a.C5254c;
import com.huawei.hwid.update.p451b.C5271a;
import com.huawei.hwid.update.p451b.C5272d;
import com.huawei.hwid.update.p451b.C5273b;
import com.huawei.hwid.update.provider.UpdateProvider;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: OtaUpdateDownload */
public class C5263f implements C5252a {
    private final Context f18932a;
    private final C5272d f18933b = new C5273b();
    private C5253b f18934c;
    private File f18935d;
    private final C5258c f18936e = new C5258c();

    public C5263f(Context context) {
        this.f18932a = context.getApplicationContext();
    }

    private synchronized void m25512b(C5253b c5253b) {
        this.f18934c = c5253b;
    }

    private synchronized void m25509a(int i, int i2, int i3) {
        if (this.f18934c != null) {
            this.f18934c.mo4656a(i, i2, i3, this.f18935d);
        }
    }

    public Context mo4651a() {
        return this.f18932a;
    }

    public void mo4654b() {
        C5165e.m24906b("OtaUpdateDownload", "Enter cancel.");
        m25512b(null);
        this.f18933b.mo4662b();
    }

    public void mo4652a(C5253b c5253b) {
        throw new IllegalStateException("Not supported.");
    }

    public void mo4653a(C5253b c5253b, C5254c c5254c) {
        a.a(c5253b, "callback must not be null.");
        C5165e.m24906b("OtaUpdateDownload", "Enter downloadPackage.");
        m25512b(c5253b);
        if (c5254c == null || !c5254c.m25474a()) {
            C5165e.m24910d("OtaUpdateDownload", "In downloadPackage, Invalid update info.");
            m25509a(2201, 0, 0);
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f18935d = UpdateProvider.a(this.f18932a, "hms/HwMobileService.apk");
            if (this.f18935d == null) {
                C5165e.m24910d("OtaUpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
                m25509a(2204, 0, 0);
                return;
            }
            File parentFile = this.f18935d.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                C5165e.m24910d("OtaUpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
                m25509a(2201, 0, 0);
                return;
            } else if (parentFile.getUsableSpace() < ((long) (c5254c.f18891c * 3))) {
                C5165e.m24910d("OtaUpdateDownload", "In downloadPackage, No space for downloading file.");
                m25509a(2203, 0, 0);
                return;
            } else {
                try {
                    m25516a(c5254c);
                    return;
                } catch (C5271a e) {
                    C5165e.m24908c("OtaUpdateDownload", "In downloadPackage, Canceled to download the update file.");
                    m25509a(2101, 0, 0);
                    return;
                }
            }
        }
        C5165e.m24910d("OtaUpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
        m25509a(2204, 0, 0);
    }

    private static boolean m25511a(String str, File file) {
        byte[] a = C5210e.m25342a(file);
        if (a != null) {
            return C5206b.m25330b(a, true).equalsIgnoreCase(str);
        }
        return false;
    }

    void m25516a(C5254c c5254c) throws C5271a {
        C5165e.m24906b("OtaUpdateDownload", "Enter downloadPackage.");
        OutputStream outputStream = null;
        try {
            this.f18936e.m25484a(mo4651a());
            if (!this.f18936e.m25488b(c5254c.f18890b, c5254c.f18891c, c5254c.f18892d)) {
                this.f18936e.m25486a(c5254c.f18890b, c5254c.f18891c, c5254c.f18892d);
                outputStream = m25508a(this.f18935d, c5254c.f18891c);
            } else if (this.f18936e.m25487b() != this.f18936e.m25483a()) {
                outputStream = m25508a(this.f18935d, c5254c.f18891c);
                outputStream.m25505a((long) this.f18936e.m25487b());
            } else if (C5263f.m25511a(c5254c.f18892d, this.f18935d)) {
                m25509a(2000, 0, 0);
                return;
            } else {
                this.f18936e.m25486a(c5254c.f18890b, c5254c.f18891c, c5254c.f18892d);
                outputStream = m25508a(this.f18935d, c5254c.f18891c);
            }
            int a = this.f18933b.mo4660a(c5254c.f18890b, outputStream, this.f18936e.m25487b(), this.f18936e.m25483a());
            if (a != 200 && a != 206) {
                C5165e.m24910d("OtaUpdateDownload", "In DownloadHelper.downloadPackage, Download the package, HTTP code: " + a);
                m25509a(2201, 0, 0);
                this.f18933b.mo4661a();
                C5207c.m25334a(outputStream);
            } else if (C5263f.m25511a(c5254c.f18892d, this.f18935d)) {
                m25509a(2000, 0, 0);
                this.f18933b.mo4661a();
                C5207c.m25334a(outputStream);
            } else {
                C5165e.m24906b("OtaUpdateDownload", "verifyHash error");
                m25509a(2202, 0, 0);
                this.f18933b.mo4661a();
                C5207c.m25334a(outputStream);
            }
        } catch (IOException e) {
            C5165e.m24910d("OtaUpdateDownload", "In DownloadHelper.downloadPackage, Failed to download." + e.getMessage());
            m25509a(2201, 0, 0);
        } finally {
            this.f18933b.mo4661a();
            C5207c.m25334a(outputStream);
        }
    }

    private C5261g m25508a(File file, final int i) throws IOException {
        return new C5261g(this, file, i) {
            final /* synthetic */ C5263f f18929b;
            private long f18930c = 0;
            private int f18931d = this.f18929b.f18936e.m25487b();

            public void write(byte[] bArr, int i, int i2) throws IOException {
                super.write(bArr, i, i2);
                this.f18931d += i2;
                if (this.f18931d > 209715200) {
                    C5165e.m24906b("OtaUpdateDownload", "received is too larger");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f18930c) > 1000) {
                    this.f18930c = currentTimeMillis;
                    m25506a(this.f18931d);
                }
                if (this.f18931d == i) {
                    m25506a(this.f18931d);
                }
            }

            private void m25506a(int i) {
                this.f18929b.f18936e.m25485a(this.f18929b.mo4651a(), i);
                this.f18929b.m25509a(2100, i, i);
            }
        };
    }
}
