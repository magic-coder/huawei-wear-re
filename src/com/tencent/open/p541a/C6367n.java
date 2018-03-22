package com.tencent.open.p541a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.p532d.C6395h;
import java.io.File;

/* compiled from: ProGuard */
public class C6367n {
    public static C6367n f22149a = null;
    protected static final C6355b f22150c = new C6355b(C6367n.m29109c(), C6359f.f22143r, C6359f.f22137l, C6359f.f22138m, C6359f.f22132g, (long) C6359f.f22139n, 10, C6359f.f22135j, C6359f.f22144s);
    protected C6354a f22151b = new C6354a(f22150c);

    public static C6367n m29103a() {
        if (f22149a == null) {
            synchronized (C6367n.class) {
                if (f22149a == null) {
                    f22149a = new C6367n();
                }
            }
        }
        return f22149a;
    }

    private C6367n() {
    }

    protected void m29113a(int i, String str, String str2, Throwable th) {
        C6366m.f22148a.m29049b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (C6361h.m29090a(C6359f.f22127b, i) && this.f22151b != null) {
            this.f22151b.m29049b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }

    public static final void m29104a(String str, String str2) {
        C6367n.m29103a().m29113a(1, str, str2, null);
    }

    public static final void m29107b(String str, String str2) {
        C6367n.m29103a().m29113a(2, str, str2, null);
    }

    public static final void m29105a(String str, String str2, Throwable th) {
        C6367n.m29103a().m29113a(2, str, str2, th);
    }

    public static final void m29110c(String str, String str2) {
        C6367n.m29103a().m29113a(4, str, str2, null);
    }

    public static final void m29111d(String str, String str2) {
        C6367n.m29103a().m29113a(8, str, str2, null);
    }

    public static final void m29112e(String str, String str2) {
        C6367n.m29103a().m29113a(16, str, str2, null);
    }

    public static final void m29108b(String str, String str2, Throwable th) {
        C6367n.m29103a().m29113a(16, str, str2, th);
    }

    public static void m29106b() {
        synchronized (C6367n.class) {
            C6367n.m29103a().m29114d();
            if (f22149a != null) {
                f22149a = null;
            }
        }
    }

    protected static File m29109c() {
        Object obj;
        String b = C6395h.m29186b();
        if (TextUtils.isEmpty(b)) {
            b = "default";
        }
        String str = C6359f.f22133h + File.separator + b;
        C6364k b2 = C6363j.m29093b();
        if (b2 == null || b2.m29100c() <= C6359f.f22136k) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return new File(Environment.getExternalStorageDirectory(), str);
        }
        return new File(C6395h.m29187c(), str);
    }

    protected void m29114d() {
        if (this.f22151b != null) {
            this.f22151b.m29056a();
            this.f22151b.m29060b();
            this.f22151b = null;
        }
    }
}
