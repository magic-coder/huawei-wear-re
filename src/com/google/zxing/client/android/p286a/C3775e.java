package com.google.zxing.client.android.p286a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.C3933j;
import com.google.zxing.client.android.C3815l;
import com.google.zxing.client.android.p286a.p287a.C3767b;
import com.google.zxing.client.android.p286a.p287a.C3770c;
import java.io.IOException;

/* compiled from: CameraManager */
public final class C3775e {
    private static final String f14695a = C3775e.class.getSimpleName();
    private final Context f14696b;
    private final C3773c f14697c;
    private Camera f14698d;
    private C3771a f14699e;
    private Rect f14700f;
    private Rect f14701g;
    private boolean f14702h;
    private boolean f14703i;
    private int f14704j;
    private int f14705k;
    private final C3777g f14706l = new C3777g(this.f14697c);

    public C3775e(Context context) {
        this.f14696b = context;
        this.f14697c = new C3773c(context);
    }

    public synchronized void m18991a(SurfaceHolder surfaceHolder) throws IOException {
        Camera camera = this.f14698d;
        if (camera == null) {
            camera = ((C3767b) new C3770c().m18972a()).mo4310a();
            if (camera == null) {
                throw new IOException();
            }
            this.f14698d = camera;
        }
        Camera camera2 = camera;
        camera2.setPreviewDisplay(surfaceHolder);
        if (!this.f14702h) {
            this.f14702h = true;
            this.f14697c.m18982a(camera2);
            if (this.f14704j > 0 && this.f14705k > 0) {
                m18989a(this.f14704j, this.f14705k);
                this.f14704j = 0;
                this.f14705k = 0;
            }
        }
        Parameters parameters = camera2.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.f14697c.m18983a(camera2, false);
        } catch (RuntimeException e) {
            Log.w(f14695a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(f14695a, "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Parameters parameters2 = camera2.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera2.setParameters(parameters2);
                    this.f14697c.m18983a(camera2, true);
                } catch (RuntimeException e2) {
                    Log.w(f14695a, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized boolean m18993a() {
        return this.f14698d != null;
    }

    public synchronized void m18994b() {
        if (this.f14698d != null) {
            this.f14698d.release();
            this.f14698d = null;
            this.f14700f = null;
            this.f14701g = null;
        }
    }

    public synchronized void m18995c() {
        Camera camera = this.f14698d;
        if (!(camera == null || this.f14703i)) {
            camera.startPreview();
            this.f14703i = true;
            this.f14699e = new C3771a(this.f14696b, this.f14698d);
        }
    }

    public synchronized void m18996d() {
        if (this.f14699e != null) {
            this.f14699e.m18976b();
            this.f14699e = null;
        }
        if (this.f14698d != null && this.f14703i) {
            this.f14698d.stopPreview();
            this.f14706l.m19001a(null, 0);
            this.f14703i = false;
        }
    }

    public synchronized void m18992a(boolean z) {
        try {
            if (!(z == this.f14697c.m18986b(this.f14698d) || this.f14698d == null)) {
                if (this.f14699e != null) {
                    this.f14699e.m18976b();
                }
                this.f14697c.m18985b(this.f14698d, z);
                if (this.f14699e != null) {
                    this.f14699e.m18975a();
                }
            }
        } catch (Exception e) {
            Log.d(f14695a, "setTorch()");
        }
    }

    public synchronized void m18990a(Handler handler, int i) {
        Camera camera = this.f14698d;
        if (camera != null && this.f14703i) {
            this.f14706l.m19001a(handler, i);
            camera.setOneShotPreviewCallback(this.f14706l);
        }
    }

    public synchronized Rect m18997e() {
        Rect rect = null;
        synchronized (this) {
            if (this.f14700f == null) {
                if (this.f14698d != null) {
                    Point b = this.f14697c.m18984b();
                    if (b != null) {
                        int a = C3815l.m19055a(this.f14696b, 200.0f);
                        int i = (b.x - a) / 2;
                        int a2 = (b.y / 4) + C3815l.m19055a(this.f14696b, 10.0f);
                        this.f14700f = new Rect(i, a2, i + a, a + a2);
                        Log.d(f14695a, "Calculated framing rect: " + this.f14700f);
                    }
                }
            }
            rect = this.f14700f;
        }
        return rect;
    }

    public synchronized Rect m18998f() {
        Rect rect = null;
        synchronized (this) {
            if (this.f14701g == null) {
                Rect e = m18997e();
                if (e != null) {
                    Rect rect2 = new Rect(e);
                    Point a = this.f14697c.m18981a();
                    Point b = this.f14697c.m18984b();
                    if (!(a == null || b == null)) {
                        rect2.left = (rect2.left * a.y) / b.x;
                        rect2.right = (rect2.right * a.y) / b.x;
                        rect2.top = (rect2.top * a.x) / b.y;
                        rect2.bottom = (rect2.bottom * a.x) / b.y;
                        this.f14701g = rect2;
                    }
                }
            }
            rect = this.f14701g;
        }
        return rect;
    }

    public synchronized void m18989a(int i, int i2) {
        if (this.f14702h) {
            Point b = this.f14697c.m18984b();
            if (i > b.x) {
                i = b.x;
            }
            if (i2 > b.y) {
                i2 = b.y;
            }
            int i3 = (b.x - i) / 2;
            int i4 = (b.y - i2) / 2;
            this.f14700f = new Rect(i3, i4, i3 + i, i4 + i2);
            Log.d(f14695a, "Calculated manual framing rect: " + this.f14700f);
            this.f14701g = null;
        } else {
            this.f14704j = i;
            this.f14705k = i2;
        }
    }

    public C3933j m18988a(byte[] bArr, int i, int i2) {
        Rect f = m18998f();
        if (f == null) {
            return null;
        }
        C3933j c3933j;
        try {
            c3933j = new C3933j(bArr, i, i2, f.left, f.top, f.width(), f.height(), false);
        } catch (IllegalArgumentException e) {
            Log.e(f14695a, "PlanarYUVLuminanceSource IllegalArgumentException");
            c3933j = null;
        }
        return c3933j;
    }
}
