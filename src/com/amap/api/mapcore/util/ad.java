package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ah.C3277a;
import com.amap.api.mapcore.util.dl.C3272a;
import com.amap.api.maps.AMapException;
import java.io.File;
import java.io.IOException;

/* compiled from: NetFileFetch */
public class ad implements C3272a {
    ae f11377a = null;
    long f11378b = 0;
    long f11379c = 0;
    long f11380d;
    boolean f11381e = true;
    C3345z f11382f;
    long f11383g = 0;
    C3271a f11384h;
    private Context f11385i;
    private ah f11386j;
    private String f11387k;
    private dl f11388l;
    private aa f11389m;

    /* compiled from: NetFileFetch */
    public interface C3271a {
        void mo4065d();
    }

    public ad(ae aeVar, String str, Context context, ah ahVar) throws IOException {
        this.f11382f = C3345z.m16317a(context.getApplicationContext());
        this.f11377a = aeVar;
        this.f11385i = context;
        this.f11387k = str;
        this.f11386j = ahVar;
        m15410g();
    }

    private void m15409f() throws IOException {
        dp aiVar = new ai(this.f11387k);
        aiVar.m15468a(1800000);
        aiVar.m15471b(1800000);
        this.f11388l = new dl(aiVar, this.f11378b, this.f11379c);
        this.f11389m = new aa(this.f11377a.m15426b() + File.separator + this.f11377a.m15427c(), this.f11378b);
    }

    private void m15410g() {
        if (this.f11382f.m16332f(this.f11377a.m15429e())) {
            this.f11381e = false;
            m15415l();
            return;
        }
        this.f11378b = 0;
        this.f11379c = 0;
    }

    public void m15417a() {
        try {
            ag.m15456b("start FileFetch " + this.f11387k);
            if (bk.m15679c(this.f11385i)) {
                m15412i();
                if (bn.f11512a != 1) {
                    ag.m15456b("start filefetch  auth exception");
                    if (this.f11386j != null) {
                        this.f11386j.mo4055a(C3277a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!m15411h()) {
                    this.f11381e = true;
                }
                if (this.f11381e) {
                    this.f11380d = m15421b();
                    if (this.f11380d == -1) {
                        ag.m15453a("File Length is not known!");
                    } else if (this.f11380d == -2) {
                        ag.m15453a("File is not access!");
                    } else {
                        this.f11379c = this.f11380d;
                    }
                    this.f11378b = 0;
                }
                if (this.f11386j != null) {
                    this.f11386j.mo4058l();
                }
                m15409f();
                this.f11388l.m16065a(this);
                return;
            }
            ag.m15456b("start filefetch  network exception");
            if (this.f11386j != null) {
                this.f11386j.mo4055a(C3277a.network_exception);
            }
        } catch (Throwable e) {
            ca.m15831a(e, "SiteFileFetch", "download");
            if (this.f11386j != null) {
                this.f11386j.mo4055a(C3277a.amap_exception);
            }
        } catch (IOException e2) {
            if (this.f11386j != null) {
                this.f11386j.mo4055a(C3277a.file_io_exception);
            }
        }
    }

    private boolean m15411h() {
        String str = this.f11377a.m15426b() + File.separator + this.f11377a.m15427c();
        if (new File(str).length() >= 10 || new File(str.substring(0, str.indexOf(".tmp"))).exists()) {
            return true;
        }
        return false;
    }

    private void m15412i() throws AMapException {
        if (bn.f11512a == -1) {
            int i = 0;
            while (i < 3) {
                try {
                    if (!bn.m15698b(this.f11385i, bk.m15681e())) {
                        i++;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m15421b() throws java.io.IOException {
        /*
        r5 = this;
        r2 = -1;
        r0 = new java.net.URL;
        r1 = r5.f11377a;
        r1 = r1.m15425a();
        r0.<init>(r1);
        r0 = r0.openConnection();
        r0 = (java.net.HttpURLConnection) r0;
        r1 = "User-Agent";
        r3 = com.amap.api.mapcore.C3264r.f11368d;
        r0.setRequestProperty(r1, r3);
        r1 = r0.getResponseCode();
        r3 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r1 < r3) goto L_0x0027;
    L_0x0021:
        r5.m15407a(r1);
        r0 = -2;
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = 1;
    L_0x0028:
        r3 = r0.getHeaderFieldKey(r1);
        if (r3 == 0) goto L_0x0043;
    L_0x002e:
        r4 = "Content-Length";
        r4 = r3.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0040;
    L_0x0036:
        r0 = r0.getHeaderField(r3);
        r0 = java.lang.Integer.parseInt(r0);
    L_0x003e:
        r0 = (long) r0;
        goto L_0x0026;
    L_0x0040:
        r1 = r1 + 1;
        goto L_0x0028;
    L_0x0043:
        r0 = r2;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ad.b():long");
    }

    private void m15413j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f11377a != null && currentTimeMillis - this.f11383g > 500) {
            m15414k();
            this.f11383g = currentTimeMillis;
            m15408a(this.f11378b);
        }
    }

    private void m15414k() {
        this.f11382f.m16325a(this.f11377a.m15429e(), this.f11377a.m15428d(), this.f11380d, this.f11378b, this.f11379c);
    }

    private void m15408a(long j) {
        if (this.f11380d > 0 && this.f11386j != null) {
            this.f11386j.mo4054a(this.f11380d, j);
            this.f11383g = System.currentTimeMillis();
        }
    }

    private boolean m15415l() {
        if (!this.f11382f.m16332f(this.f11377a.m15429e())) {
            return false;
        }
        this.f11380d = (long) this.f11382f.m16330d(this.f11377a.m15429e());
        long[] a = this.f11382f.m16327a(this.f11377a.m15429e(), 0);
        this.f11378b = a[0];
        this.f11379c = a[1];
        return true;
    }

    private void m15407a(int i) {
        System.err.println("Error Code : " + i);
    }

    public void m15422c() {
        if (this.f11388l != null) {
            this.f11388l.m16064a();
        } else {
            ag.m15456b("downlaodmnager is null when site stop");
        }
    }

    public void mo3998d() {
        if (this.f11386j != null) {
            this.f11386j.mo4060n();
        }
        m15414k();
    }

    public void mo3999e() {
        m15413j();
        if (this.f11386j != null) {
            this.f11386j.mo4059m();
        }
        if (this.f11389m != null) {
            this.f11389m.m15390a();
        }
        m15416m();
        if (this.f11384h != null) {
            this.f11384h.mo4065d();
        }
    }

    private void m15416m() {
        String str = this.f11377a.m15426b() + File.separator + this.f11377a.m15427c();
        File file = new File(str);
        String substring = str.substring(0, str.indexOf(".tmp"));
        file.renameTo(new File(substring));
        ag.m15453a("NetFileFetch Done, Rename " + str + " ==> " + substring);
    }

    public void mo3996a(Throwable th) {
        ag.m15456b("onException: " + th.getMessage());
        if (this.f11386j != null) {
            this.f11386j.mo4055a(C3277a.network_exception);
        }
        if (th instanceof IOException) {
            ag.m15456b("这里报 io excepiton 需要处理一下");
        } else if (this.f11389m != null) {
            this.f11389m.m15390a();
        }
    }

    public void mo3997a(byte[] bArr, long j) {
        try {
            this.f11389m.m15389a(bArr);
            this.f11378b = j;
            m15413j();
        } catch (Throwable e) {
            e.printStackTrace();
            ca.m15831a(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            if (this.f11386j != null) {
                this.f11386j.mo4055a(C3277a.file_io_exception);
            }
            if (this.f11388l != null) {
                this.f11388l.m16064a();
            }
        }
    }

    public void m15418a(C3271a c3271a) {
        this.f11384h = c3271a;
    }
}
