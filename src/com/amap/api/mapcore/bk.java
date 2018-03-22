package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES10;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TextOptions;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: TextDelegateImp */
class bk implements an {
    private static int f11100a = 0;
    private Runnable f11101A = new bl(this);
    private boolean f11102B = false;
    private boolean f11103C = false;
    private float f11104b = 0.0f;
    private float f11105c = 0.0f;
    private int f11106d = 4;
    private int f11107e = 32;
    private FPoint f11108f = new FPoint();
    private int f11109g;
    private Bitmap f11110h;
    private FloatBuffer f11111i = null;
    private String f11112j;
    private LatLng f11113k;
    private float f11114l = 0.5f;
    private float f11115m = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private boolean f11116n = true;
    private av f11117o;
    private FloatBuffer f11118p;
    private Object f11119q;
    private String f11120r;
    private int f11121s;
    private int f11122t;
    private int f11123u;
    private Typeface f11124v;
    private float f11125w;
    private Rect f11126x = new Rect();
    private Paint f11127y = new Paint();
    private Handler f11128z = new Handler();

    private static String m15095d(String str) {
        f11100a++;
        return str + f11100a;
    }

    public void mo3683a(float f) {
        this.f11105c = f;
        this.f11104b = (((-f) % 360.0f) + 360.0f) % 360.0f;
        m15087Q();
    }

    public boolean mo3724x() {
        return this.f11102B;
    }

    public synchronized void mo3725y() {
        if (this.f11102B) {
            try {
                mo3699b();
                if (this.f11110h != null) {
                    this.f11110h.recycle();
                    this.f11110h = null;
                }
                if (this.f11118p != null) {
                    this.f11118p.clear();
                    this.f11118p = null;
                }
                if (this.f11111i != null) {
                    this.f11111i.clear();
                    this.f11111i = null;
                }
                this.f11113k = null;
                this.f11119q = null;
            } catch (Throwable th) {
                ca.m15831a(th, "TextDelegateImp", "realdestroy");
                th.printStackTrace();
                Log.d("destroy erro", "TextDelegateImp destroy");
            }
        }
    }

    public void mo3716p() {
        try {
            this.f11102B = true;
            if (!(this.f11117o == null || this.f11117o.f10937a == null)) {
                this.f11117o.f10937a.mo3747N();
            }
            this.f11109g = 0;
        } catch (Throwable th) {
            ca.m15831a(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "TextDelegateImp destroy");
        }
    }

    public bk(TextOptions textOptions, av avVar) throws RemoteException {
        this.f11117o = avVar;
        if (textOptions.getPosition() != null) {
            this.f11113k = textOptions.getPosition();
        }
        mo3932b(textOptions.getAlignX(), textOptions.getAlignY());
        this.f11116n = textOptions.isVisible();
        this.f11120r = textOptions.getText();
        this.f11121s = textOptions.getBackgroundColor();
        this.f11122t = textOptions.getFontColor();
        this.f11123u = textOptions.getFontSize();
        this.f11119q = textOptions.getObject();
        this.f11125w = textOptions.getZIndex();
        this.f11124v = textOptions.getTypeface();
        this.f11112j = mo3708h();
        mo3683a(textOptions.getRotate());
        m15086P();
        mo3718r();
    }

    private void m15086P() {
        if (this.f11120r != null && this.f11120r.trim().length() > 0) {
            try {
                this.f11127y.setTypeface(this.f11124v);
                this.f11127y.setSubpixelText(true);
                this.f11127y.setAntiAlias(true);
                this.f11127y.setStrokeWidth(5.0f);
                this.f11127y.setStrokeCap(Cap.ROUND);
                this.f11127y.setTextSize((float) this.f11123u);
                this.f11127y.setTextAlign(Align.CENTER);
                this.f11127y.setColor(this.f11122t);
                FontMetrics fontMetrics = this.f11127y.getFontMetrics();
                int i = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i2 = (int) (((((float) i) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                this.f11127y.getTextBounds(this.f11120r, 0, this.f11120r.length(), this.f11126x);
                Bitmap createBitmap = Bitmap.createBitmap(this.f11126x.width() + 6, i, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.f11121s);
                canvas.drawText(this.f11120r, (float) (this.f11126x.centerX() + 3), (float) i2, this.f11127y);
                this.f11110h = createBitmap;
                this.f11118p = com.amap.api.mapcore.util.bk.m15659a(new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f, 0.0f, 0.0f});
            } catch (Throwable th) {
                ca.m15831a(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    public synchronized boolean mo3699b() {
        m15087Q();
        this.f11116n = false;
        return this.f11117o.m14867b((ag) this);
    }

    private void m15087Q() {
        if (this.f11117o.f10937a != null) {
            this.f11117o.f10937a.mo3816e(false);
        }
    }

    public LatLng mo3704e() {
        return this.f11113k;
    }

    public String mo3708h() {
        if (this.f11112j == null) {
            this.f11112j = m15095d("Text");
        }
        return this.f11112j;
    }

    public void mo3688a(LatLng latLng) {
        this.f11113k = latLng;
        mo3718r();
        m15087Q();
    }

    public void mo3691a(String str) {
    }

    public String mo3709i() {
        return null;
    }

    public void mo3697b(String str) {
    }

    public String mo3710j() {
        return null;
    }

    public void mo3694a(boolean z) {
    }

    public synchronized void mo3692a(ArrayList<BitmapDescriptor> arrayList) {
    }

    public synchronized ArrayList<BitmapDescriptor> mo3723w() {
        return null;
    }

    public synchronized void mo3687a(BitmapDescriptor bitmapDescriptor) {
    }

    public boolean mo3711k() {
        return false;
    }

    public void mo3712l() {
    }

    public void mo3713m() {
    }

    public boolean mo3714n() {
        return false;
    }

    public void mo3700c(boolean z) {
        if (this.f11116n != z) {
            this.f11116n = z;
            m15087Q();
        }
    }

    public boolean mo3715o() {
        return this.f11116n;
    }

    public void mo3696b(float f) {
        this.f11125w = f;
        this.f11117o.m14876h();
    }

    public float mo3680G() {
        return this.f11125w;
    }

    public void mo3684a(float f, float f2) {
    }

    public boolean mo3695a(ag agVar) throws RemoteException {
        if (equals(agVar) || agVar.mo3708h().equals(mo3708h())) {
            return true;
        }
        return false;
    }

    public int mo3717q() {
        return super.hashCode();
    }

    public boolean mo3718r() {
        if (this.f11113k == null) {
            return false;
        }
        this.f11117o.f10937a.mo3764a(this.f11113k.latitude, this.f11113k.longitude, this.f11108f);
        return true;
    }

    private void m15091a(aa aaVar) throws RemoteException {
        float[] a = com.amap.api.mapcore.util.bk.m15669a(aaVar, 0, this.f11108f, this.f11104b, this.f11110h.getWidth(), this.f11110h.getHeight(), this.f11114l, this.f11115m);
        if (this.f11111i == null) {
            this.f11111i = com.amap.api.mapcore.util.bk.m15659a(a);
        } else {
            this.f11111i = com.amap.api.mapcore.util.bk.m15660a(a, this.f11111i);
        }
        if (this.f11109g != 0) {
            m15090a(this.f11109g, this.f11111i, this.f11118p);
        }
    }

    private void m15090a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != 0 && floatBuffer != null && floatBuffer2 != null) {
            GLES10.glEnable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
            GLES10.glBlendFunc(1, 771);
            GLES10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            GLES10.glEnable(3553);
            GLES10.glEnableClientState(32884);
            GLES10.glEnableClientState(32888);
            GLES10.glBindTexture(3553, i);
            GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
            GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            GLES10.glDrawArrays(6, 0, 4);
            GLES10.glDisableClientState(32884);
            GLES10.glDisableClientState(32888);
            GLES10.glDisable(3553);
            GLES10.glDisable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
        }
    }

    public void mo3693a(GL10 gl10, aa aaVar) {
        if (this.f11116n && this.f11113k != null && this.f11110h != null) {
            if (!this.f11103C) {
                try {
                    if (!(this.f11110h == null || this.f11110h.isRecycled())) {
                        if (this.f11109g == 0) {
                            this.f11109g = m15089a(gl10);
                        }
                        com.amap.api.mapcore.util.bk.m15671b(gl10, this.f11109g, this.f11110h, false);
                        this.f11103C = true;
                        this.f11110h.recycle();
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "TextDelegateImp", "loadtexture");
                    th.printStackTrace();
                    return;
                }
            }
            try {
                m15091a(aaVar);
            } catch (Throwable th2) {
                ca.m15831a(th2, "TextDelegateImp", "drawMarker");
            }
        }
    }

    private int m15089a(GL10 gl10) {
        int K = this.f11117o.f10937a.mo3744K();
        if (K != 0) {
            return K;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public boolean mo3701c() {
        return true;
    }

    public void mo3685a(int i) {
    }

    public void mo3690a(Object obj) {
        this.f11119q = obj;
    }

    public Object mo3719s() {
        return this.f11119q;
    }

    public void mo3703d(boolean z) {
    }

    public boolean mo3720t() {
        return false;
    }

    public int mo3722v() {
        return 0;
    }

    public LatLng mo3707g() {
        return this.f11113k;
    }

    public void mo3726z() {
        this.f11117o.m14868c(this);
    }

    public void mo3705e(boolean z) throws RemoteException {
    }

    public boolean mo3674A() {
        return false;
    }

    public float mo3721u() {
        return this.f11105c;
    }

    public int mo3675B() {
        return 0;
    }

    public int mo3676C() {
        return 0;
    }

    public void mo3686a(int i, int i2) {
    }

    public int mo3677D() {
        return 0;
    }

    public int mo3678E() {
        return 0;
    }

    public FPoint mo3706f() {
        return this.f11108f;
    }

    public boolean mo3679F() {
        return false;
    }

    public Rect mo3702d() {
        return null;
    }

    public void mo3934c(String str) throws RemoteException {
        this.f11120r = str;
        m15088R();
    }

    public String mo3929a() throws RemoteException {
        return this.f11120r;
    }

    public void mo3931b(int i) throws RemoteException {
        this.f11121s = i;
        m15088R();
    }

    public int mo3923J() throws RemoteException {
        return this.f11121s;
    }

    public void mo3933c(int i) throws RemoteException {
        this.f11122t = i;
        m15088R();
    }

    public int mo3924K() throws RemoteException {
        return this.f11122t;
    }

    public void mo3935d(int i) throws RemoteException {
        this.f11123u = i;
        m15088R();
    }

    public int mo3925L() throws RemoteException {
        return this.f11123u;
    }

    public void mo3930a(Typeface typeface) throws RemoteException {
        this.f11124v = typeface;
        m15088R();
    }

    public Typeface mo3926M() throws RemoteException {
        return this.f11124v;
    }

    public void mo3932b(int i, int i2) throws RemoteException {
        this.f11106d = i;
        switch (i) {
            case 1:
                this.f11114l = 0.0f;
                break;
            case 2:
                this.f11114l = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                break;
            case 4:
                this.f11114l = 0.5f;
                break;
            default:
                this.f11114l = 0.5f;
                break;
        }
        this.f11107e = i2;
        switch (i2) {
            case 8:
                this.f11115m = 0.0f;
                break;
            case 16:
                this.f11115m = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                break;
            case 32:
                this.f11115m = 0.5f;
                break;
            default:
                this.f11115m = 0.5f;
                break;
        }
        m15087Q();
    }

    public int mo3927N() throws RemoteException {
        return this.f11106d;
    }

    public int mo3928O() {
        return this.f11107e;
    }

    private void m15088R() {
        this.f11128z.removeCallbacks(this.f11101A);
        this.f11128z.post(this.f11101A);
    }

    public boolean mo3681H() {
        LatLngBounds G = this.f11117o.f10937a.mo3741G();
        if (this.f11113k == null || G == null) {
            return true;
        }
        return G.contains(this.f11113k);
    }

    public void mo3698b(boolean z) {
    }

    public void mo3689a(IPoint iPoint) {
    }

    public IPoint mo3682I() {
        return null;
    }
}
