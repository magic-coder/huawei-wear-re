package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.mapcore.bm.C3239a;
import com.amap.api.mapcore.util.ba.C3288a;
import java.lang.ref.WeakReference;

/* compiled from: ImageWorker */
public abstract class bd {
    private ba f11482a;
    private C3288a f11483b;
    protected boolean f11484c = false;
    protected Resources f11485d;
    private boolean f11486e = false;
    private final Object f11487f = new Object();

    /* compiled from: ImageWorker */
    public class C3289a extends av<Boolean, Void, Bitmap> {
        final /* synthetic */ bd f11491a;
        private final WeakReference<C3239a> f11492e;

        public C3289a(bd bdVar, C3239a c3239a) {
            this.f11491a = bdVar;
            this.f11492e = new WeakReference(c3239a);
        }

        protected Bitmap m15614a(Boolean... boolArr) {
            Bitmap bitmap = null;
            bf.m15627a("ImageWorker", "doInBackground - starting work", 111);
            boolean booleanValue = boolArr[0].booleanValue();
            Object obj = (C3239a) this.f11492e.get();
            if (obj == null) {
                return null;
            }
            Bitmap bitmap2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.f11130a);
            stringBuilder.append("-");
            stringBuilder.append(obj.f11131b);
            stringBuilder.append("-");
            stringBuilder.append(obj.f11132c);
            String stringBuilder2 = stringBuilder.toString();
            synchronized (this.f11491a.f11487f) {
                while (this.f11491a.f11484c && !m15183d()) {
                    try {
                        this.f11491a.f11487f.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!(this.f11491a.f11482a == null || m15183d() || m15613e() == null || this.f11491a.f11486e)) {
                bitmap = this.f11491a.f11482a.m15579b(stringBuilder2);
            }
            if (!booleanValue || bitmap != null || m15183d() || m15613e() == null || this.f11491a.f11486e) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = this.f11491a.mo4015a(obj);
            }
            if (!(bitmap2 == null || this.f11491a.f11482a == null)) {
                this.f11491a.f11482a.m15578a(stringBuilder2, bitmap2);
            }
            bf.m15627a("ImageWorker", "doInBackground - finished work", 111);
            return bitmap2;
        }

        protected void m15616a(Bitmap bitmap) {
            if (m15183d() || this.f11491a.f11486e) {
                bitmap = null;
            }
            C3239a e = m15613e();
            if (bitmap != null && !bitmap.isRecycled() && e != null) {
                bf.m15627a("ImageWorker", "onPostExecute - setting bitmap: " + e.toString(), 111);
                e.m15163a(bitmap);
            }
        }

        protected void m15618b(Bitmap bitmap) {
            super.mo4016b((Object) bitmap);
            synchronized (this.f11491a.f11487f) {
                this.f11491a.f11487f.notifyAll();
            }
        }

        private C3239a m15613e() {
            C3239a c3239a = (C3239a) this.f11492e.get();
            return this == bd.m15587c(c3239a) ? c3239a : null;
        }
    }

    /* compiled from: ImageWorker */
    public class C3290b extends av<Object, Void, Void> {
        final /* synthetic */ bd f11493a;

        protected C3290b(bd bdVar) {
            this.f11493a = bdVar;
        }

        protected /* synthetic */ Object mo3936a(Object[] objArr) {
            return m15621d(objArr);
        }

        protected Void m15621d(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 0:
                    this.f11493a.m15596c();
                    break;
                case 1:
                    this.f11493a.m15594b();
                    break;
                case 2:
                    this.f11493a.m15597d();
                    break;
                case 3:
                    this.f11493a.m15598e();
                    break;
            }
            return null;
        }
    }

    protected abstract Bitmap mo4015a(Object obj);

    protected bd(Context context) {
        this.f11485d = context.getResources();
    }

    public void m15593a(boolean z, C3239a c3239a) {
        if (c3239a != null) {
            Bitmap bitmap = null;
            if (this.f11482a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c3239a.f11130a);
                stringBuilder.append("-");
                stringBuilder.append(c3239a.f11131b);
                stringBuilder.append("-");
                stringBuilder.append(c3239a.f11132c);
                bitmap = this.f11482a.m15576a(stringBuilder.toString());
            }
            if (bitmap != null) {
                c3239a.m15163a(bitmap);
                return;
            }
            C3289a c3289a = new C3289a(this, c3239a);
            c3239a.f11139j = c3289a;
            c3289a.m15174a(av.f11145d, (Object[]) new Boolean[]{Boolean.valueOf(z)});
        }
    }

    public void m15591a(C3288a c3288a) {
        this.f11483b = c3288a;
        this.f11482a = ba.m15566a(this.f11483b);
        new C3290b(this).m15181c(Integer.valueOf(1));
    }

    public void m15592a(boolean z) {
        this.f11486e = z;
        m15595b(false);
    }

    protected ba m15590a() {
        return this.f11482a;
    }

    public static void m15584a(C3239a c3239a) {
        C3289a c = m15587c(c3239a);
        if (c != null) {
            c.m15177a(true);
            bf.m15627a("ImageWorker", "cancelWork - cancelled work for " + c3239a, 111);
        }
    }

    private static C3289a m15587c(C3239a c3239a) {
        if (c3239a != null) {
            return c3239a.f11139j;
        }
        return null;
    }

    public void m15595b(boolean z) {
        synchronized (this.f11487f) {
            this.f11484c = z;
            if (!this.f11484c) {
                this.f11487f.notifyAll();
            }
        }
    }

    protected void m15594b() {
        if (this.f11482a != null) {
            this.f11482a.m15577a();
        }
    }

    protected void m15596c() {
        if (this.f11482a != null) {
            this.f11482a.m15580b();
        }
    }

    protected void m15597d() {
        if (this.f11482a != null) {
            this.f11482a.m15581c();
        }
    }

    protected void m15598e() {
        if (this.f11482a != null) {
            this.f11482a.m15582d();
            this.f11482a = null;
        }
    }

    public void m15599f() {
        new C3290b(this).m15181c(Integer.valueOf(0));
    }

    public void m15600g() {
        new C3290b(this).m15181c(Integer.valueOf(2));
    }

    public void m15601h() {
        new C3290b(this).m15181c(Integer.valueOf(3));
    }
}
