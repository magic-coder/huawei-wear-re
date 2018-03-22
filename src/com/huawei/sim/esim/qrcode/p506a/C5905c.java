package com.huawei.sim.esim.qrcode.p506a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.huawei.sim.esim.p504a.C5899a;
import java.io.IOException;

/* compiled from: CameraManager */
public final class C5905c {
    static final int f20231a;
    private static final String f20232b = C5905c.class.getSimpleName();
    private static C5905c f20233c;
    private final Context f20234d;
    private final C5904b f20235e;
    private Rect f20236f;
    private Rect f20237g;
    private Camera f20238h;
    private boolean f20239i;
    private boolean f20240j;
    private final boolean f20241k;
    private final C5903a f20242l;
    private final C5907e f20243m;

    static {
        int a;
        try {
            a = C5899a.m27105a(VERSION.SDK);
        } catch (NumberFormatException e) {
            a = 10000;
        }
        f20231a = a;
    }

    public static void m27160a(Context context) {
        synchronized (C5905c.class) {
            if (f20233c == null && context != null) {
                f20233c = new C5905c(context);
            }
        }
    }

    private C5905c(Context context) {
        this.f20234d = context;
        this.f20235e = new C5904b(context);
        this.f20241k = C5899a.m27105a(VERSION.SDK) > 3;
        this.f20243m = new C5907e(this.f20235e, this.f20241k);
        this.f20242l = new C5903a();
    }

    public static C5905c m27159a() {
        C5905c c5905c;
        synchronized (C5905c.class) {
            c5905c = f20233c;
        }
        return c5905c;
    }

    public void m27164b() {
        if (this.f20238h != null) {
            this.f20238h.release();
            this.f20238h = null;
        }
    }

    public void m27163a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f20238h == null) {
            this.f20238h = Camera.open();
            if (this.f20238h == null) {
                throw new IOException();
            }
            this.f20238h.setPreviewDisplay(surfaceHolder);
            if (!this.f20240j) {
                this.f20240j = true;
                this.f20235e.m27153a(this.f20238h);
            }
            this.f20235e.m27156b(this.f20238h);
        }
    }

    public void m27166c() {
        if (this.f20238h != null) {
            this.f20235e.m27154a(this.f20238h, false);
        }
    }

    public void m27167d() {
        if (this.f20238h != null && this.f20239i) {
            if (!this.f20241k) {
                this.f20238h.setPreviewCallback(null);
            }
            this.f20238h.stopPreview();
            this.f20243m.m27174a(null, 0);
            this.f20242l.m27146a(null, 0);
            this.f20239i = false;
        }
    }

    public void m27168e() {
        if (this.f20238h != null && !this.f20239i) {
            this.f20238h.startPreview();
            this.f20239i = true;
        }
    }

    public void m27162a(Handler handler, int i) {
        if (this.f20238h != null && this.f20239i) {
            this.f20242l.m27146a(handler, i);
            this.f20238h.autoFocus(this.f20242l);
        }
    }

    public void m27165b(Handler handler, int i) {
        if (this.f20238h != null && this.f20239i) {
            this.f20243m.m27174a(handler, i);
            if (this.f20241k) {
                this.f20238h.setOneShotPreviewCallback(this.f20243m);
            } else {
                this.f20238h.setPreviewCallback(this.f20243m);
            }
        }
    }

    public Rect m27169f() {
        int i = 720;
        int i2 = 278;
        Point b = this.f20235e.m27155b();
        if (this.f20236f == null) {
            if (this.f20238h == null) {
                return null;
            }
            if (b == null) {
                return null;
            }
            int i3 = (b.x * 3) / 4;
            if (i3 < 278) {
                i = 278;
            } else if (i3 <= 720) {
                i = i3;
            }
            i3 = (b.y * 3) / 4;
            if (i3 >= 278) {
                if (i3 > 480) {
                    i2 = i;
                } else {
                    i2 = i3;
                }
            }
            i3 = (b.x - i) / 2;
            int i4 = ((int) (((double) b.y) - (((double) i2) * 1.9d))) / 2;
            this.f20236f = new Rect(i3, i4, i + i3, i2 + i4);
        }
        return this.f20236f;
    }

    public C5906d m27161a(byte[] bArr, int i, int i2) {
        Rect g = m27170g();
        int d = this.f20235e.m27158d();
        String c = this.f20235e.m27157c();
        switch (d) {
            case 16:
            case 17:
                return new C5906d(bArr, i, i2, g.left, g.top, g.width(), g.height());
            default:
                if ("yuv420p".equals(c)) {
                    return new C5906d(bArr, i, i2, g.left, g.top, g.width(), g.height());
                }
                throw new IllegalArgumentException("Unsupported picture format: " + d + '/' + c);
        }
    }

    public Rect m27170g() {
        if (this.f20237g == null) {
            Rect rect;
            Rect f = m27169f();
            if (f == null) {
                rect = new Rect();
            } else {
                rect = new Rect(f);
            }
            Point a = this.f20235e.m27152a();
            Point b = this.f20235e.m27155b();
            rect.left = (rect.left * a.y) / b.x;
            rect.right = (rect.right * a.y) / b.x;
            rect.top = (rect.top * a.x) / b.y;
            rect.bottom = (a.x * rect.bottom) / b.y;
            this.f20237g = rect;
        }
        return this.f20237g;
    }
}
