package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.io.IOException;

/* compiled from: CameraManager */
public final class C1947d {
    static final int f6761a;
    private static final String f6762b = C1947d.class.getSimpleName();
    private static C1947d f6763c;
    private final C1946c f6764d;
    private Camera f6765e;
    private Rect f6766f;
    private Rect f6767g;
    private boolean f6768h;
    private boolean f6769i;
    private final boolean f6770j;
    private final C1949f f6771k;
    private final C1944a f6772l;

    static {
        int d;
        try {
            d = C1492l.m6920d(VERSION.SDK);
        } catch (NumberFormatException e) {
            d = 10000;
        }
        f6761a = d;
    }

    public static void m10194a(Context context) {
        synchronized (C1947d.class) {
            if (f6763c == null && context != null) {
                f6763c = new C1947d(context);
            }
        }
    }

    public static C1947d m10193a() {
        C1947d c1947d;
        synchronized (C1947d.class) {
            c1947d = f6763c;
        }
        return c1947d;
    }

    private C1947d(Context context) {
        this.f6764d = new C1946c(context);
        this.f6770j = C1492l.m6920d(VERSION.SDK) > 3;
        this.f6771k = new C1949f(this.f6764d, this.f6770j);
        this.f6772l = new C1944a();
    }

    public void m10197a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f6765e == null) {
            this.f6765e = Camera.open();
            if (this.f6765e == null) {
                throw new IOException();
            }
            this.f6765e.setPreviewDisplay(surfaceHolder);
            if (!this.f6768h) {
                this.f6768h = true;
                this.f6764d.m10187a(this.f6765e);
            }
            this.f6764d.m10190b(this.f6765e);
        }
    }

    public void m10198b() {
        if (this.f6765e != null) {
            this.f6765e.release();
            this.f6765e = null;
        }
    }

    public void m10200c() {
        if (this.f6765e != null) {
            this.f6764d.m10188a(this.f6765e, false);
        }
    }

    public void m10201d() {
        if (this.f6765e != null && !this.f6769i) {
            this.f6765e.startPreview();
            this.f6769i = true;
        }
    }

    public void m10202e() {
        if (this.f6765e != null && this.f6769i) {
            if (!this.f6770j) {
                this.f6765e.setPreviewCallback(null);
            }
            this.f6765e.stopPreview();
            this.f6771k.m10208a(null, 0);
            this.f6772l.m10178a(null, 0);
            this.f6769i = false;
        }
    }

    public void m10196a(Handler handler, int i) {
        if (this.f6765e != null && this.f6769i) {
            this.f6771k.m10208a(handler, i);
            if (this.f6770j) {
                this.f6765e.setOneShotPreviewCallback(this.f6771k);
            } else {
                this.f6765e.setPreviewCallback(this.f6771k);
            }
        }
    }

    public void m10199b(Handler handler, int i) {
        if (this.f6765e != null && this.f6769i) {
            this.f6772l.m10178a(handler, i);
            this.f6765e.autoFocus(this.f6772l);
        }
    }

    public Rect m10203f() {
        int i = 720;
        int i2 = 278;
        Point b = this.f6764d.m10189b();
        if (this.f6766f == null) {
            if (this.f6765e == null) {
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
            int i4 = ((int) (((double) b.y) - (((double) i2) * 1.2d))) / 2;
            this.f6766f = new Rect(i3, i4, i + i3, i2 + i4);
        }
        return this.f6766f;
    }

    public Rect m10204g() {
        if (this.f6767g == null) {
            Rect rect;
            Rect f = m10203f();
            if (f == null) {
                rect = new Rect();
            } else {
                rect = new Rect(f);
            }
            Point a = this.f6764d.m10186a();
            Point b = this.f6764d.m10189b();
            rect.left = (rect.left * a.y) / b.x;
            rect.right = (rect.right * a.y) / b.x;
            rect.top = (rect.top * a.x) / b.y;
            rect.bottom = (a.x * rect.bottom) / b.y;
            this.f6767g = rect;
        }
        return this.f6767g;
    }

    public C1948e m10195a(byte[] bArr, int i, int i2) {
        Rect g = m10204g();
        int c = this.f6764d.m10191c();
        String d = this.f6764d.m10192d();
        switch (c) {
            case 16:
            case 17:
                return new C1948e(bArr, i, i2, g.left, g.top, g.width(), g.height());
            default:
                if ("yuv420p".equals(d)) {
                    return new C1948e(bArr, i, i2, g.left, g.top, g.width(), g.height());
                }
                throw new IllegalArgumentException("Unsupported picture format: " + c + '/' + d);
        }
    }
}
