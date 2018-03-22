package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: PopupOverlay */
class bg implements ag {
    private boolean f10749a = false;
    private int f10750b = 0;
    private int f10751c = 0;
    private FloatBuffer f10752d = null;
    private String f10753e;
    private FPoint f10754f;
    private BitmapDescriptor f10755g;
    private boolean f10756h = true;
    private FloatBuffer f10757i;
    private Object f10758j;
    private int f10759k;
    private aa f10760l = null;
    private MapProjection f10761m = null;
    private float f10762n = 0.5f;
    private float f10763o = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private boolean f10764p;
    private boolean f10765q = false;
    private boolean f10766r = true;
    private int f10767s = 20;

    public boolean mo3724x() {
        return this.f10749a;
    }

    public void mo3725y() {
        if (this.f10749a) {
            try {
                mo3699b();
                if (this.f10755g != null) {
                    Bitmap bitmap = this.f10755g.getBitmap();
                    if (bitmap != null) {
                        bitmap.recycle();
                        this.f10755g = null;
                    }
                }
                if (this.f10757i != null) {
                    this.f10757i.clear();
                    this.f10757i = null;
                }
                if (this.f10752d != null) {
                    this.f10752d.clear();
                    this.f10752d = null;
                }
                this.f10754f = null;
                this.f10758j = null;
                this.f10759k = 0;
            } catch (Throwable th) {
                ca.m15831a(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
    }

    private void m14237b(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f10759k = 0;
            this.f10755g = bitmapDescriptor;
        }
    }

    public bg(MarkerOptions markerOptions, aa aaVar) {
        this.f10760l = aaVar;
        this.f10761m = aaVar.mo3809c();
        m14237b(markerOptions.getIcon());
        this.f10750b = markerOptions.getInfoWindowOffsetX();
        this.f10751c = markerOptions.getInfoWindowOffsetY();
        this.f10756h = markerOptions.isVisible();
        this.f10753e = mo3708h();
        mo3718r();
    }

    public int m14247J() {
        try {
            return m14249L().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    public int m14248K() {
        try {
            return m14249L().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    public Rect mo3702d() {
        return null;
    }

    public boolean mo3699b() {
        m14234M();
        if (this.f10759k != 0) {
            this.f10760l.mo3818f(this.f10759k);
        }
        return true;
    }

    private void m14234M() {
        if (this.f10760l != null) {
            this.f10760l.mo3816e(false);
        }
    }

    public LatLng mo3704e() {
        return null;
    }

    public String mo3708h() {
        if (this.f10753e == null) {
            this.f10753e = "PopupOverlay";
        }
        return this.f10753e;
    }

    public void m14257a(FPoint fPoint) {
        if (fPoint == null || !fPoint.equals(this.f10754f)) {
            this.f10754f = fPoint;
        }
    }

    public void mo3688a(LatLng latLng) {
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

    public void mo3692a(ArrayList<BitmapDescriptor> arrayList) {
    }

    public ArrayList<BitmapDescriptor> mo3723w() {
        return null;
    }

    public void mo3687a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f10755g = bitmapDescriptor;
            this.f10765q = false;
            if (this.f10757i != null) {
                this.f10757i.clear();
                this.f10757i = null;
            }
            m14234M();
        }
    }

    public BitmapDescriptor m14249L() {
        return this.f10755g;
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
        if (!this.f10756h && z) {
            this.f10764p = true;
        }
        this.f10756h = z;
    }

    public boolean mo3715o() {
        return this.f10756h;
    }

    public void mo3684a(float f, float f2) {
        if (this.f10762n != f || this.f10763o != f2) {
            this.f10762n = f;
            this.f10763o = f2;
        }
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
        if (this.f10754f == null) {
            return false;
        }
        IPoint iPoint = new IPoint();
        this.f10760l.mo3809c().map2Win(this.f10754f.f13252x, this.f10754f.f13253y, iPoint);
        int J = m14247J();
        int K = m14248K();
        int i = (int) (((float) (iPoint.f13273x + this.f10750b)) - (((float) J) * this.f10762n));
        int i2 = (int) (((float) (iPoint.f13274y + this.f10751c)) + (((float) K) * (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f10763o)));
        if (i - J > this.f10760l.mo3827k() || i < (-J) * 2 || i2 < (-K) * 2 || i2 - K > this.f10760l.mo3829l() || this.f10755g == null) {
            return false;
        }
        J = this.f10755g.getWidth();
        float width = ((float) J) / ((float) this.f10755g.getBitmap().getWidth());
        float height = ((float) this.f10755g.getHeight()) / ((float) this.f10755g.getBitmap().getHeight());
        if (this.f10757i == null) {
            this.f10757i = bk.m15659a(new float[]{0.0f, height, width, height, width, 0.0f, 0.0f, 0.0f});
        }
        float[] fArr = new float[]{(float) i, (float) (this.f10760l.mo3829l() - i2), 0.0f, (float) (i + J), (float) (this.f10760l.mo3829l() - i2), 0.0f, (float) (J + i), (float) ((this.f10760l.mo3829l() - i2) + K), 0.0f, (float) i, (float) ((this.f10760l.mo3829l() - i2) + K), 0.0f};
        if (this.f10752d == null) {
            this.f10752d = bk.m15659a(fArr);
        } else {
            this.f10752d = bk.m15660a(fArr, this.f10752d);
        }
        return true;
    }

    private void m14235a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
            gl10.glBlendFunc(1, 771);
            gl10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            gl10.glEnable(3553);
            gl10.glEnableClientState(32884);
            gl10.glEnableClientState(32888);
            gl10.glBindTexture(3553, i);
            gl10.glVertexPointer(3, 5126, 0, floatBuffer);
            gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            gl10.glDrawArrays(6, 0, 4);
            gl10.glDisableClientState(32884);
            gl10.glDisableClientState(32888);
            gl10.glDisable(3553);
            gl10.glDisable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
        }
    }

    public void m14262a(GL10 gl10) {
        if (this.f10756h && this.f10754f != null && m14249L() != null) {
            if (!this.f10765q) {
                try {
                    if (this.f10759k != 0) {
                        gl10.glDeleteTextures(1, new int[]{this.f10759k}, 0);
                        this.f10760l.mo3818f(this.f10759k);
                    }
                    this.f10759k = m14236b(gl10);
                    if (this.f10755g != null) {
                        Bitmap bitmap = this.f10755g.getBitmap();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            bk.m15643a(gl10, this.f10759k, bitmap);
                        }
                        this.f10765q = true;
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "PopupOverlay", "drawMarker");
                    th.printStackTrace();
                    return;
                }
            }
            if (mo3718r()) {
                gl10.glLoadIdentity();
                gl10.glViewport(0, 0, this.f10760l.mo3827k(), this.f10760l.mo3829l());
                gl10.glMatrixMode(5889);
                gl10.glLoadIdentity();
                gl10.glOrthof(0.0f, (float) this.f10760l.mo3827k(), 0.0f, (float) this.f10760l.mo3829l(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, GroundOverlayOptions.NO_DIMENSION);
                m14235a(gl10, this.f10759k, this.f10752d, this.f10757i);
                if (this.f10764p) {
                    mo3727a();
                    this.f10764p = false;
                }
            }
        }
    }

    public void mo3727a() {
    }

    private int m14236b(GL10 gl10) {
        int K = this.f10760l.mo3744K();
        if (K != 0) {
            return K;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public boolean mo3701c() {
        return this.f10766r;
    }

    public void mo3685a(int i) {
        if (i <= 1) {
            this.f10767s = 1;
        } else {
            this.f10767s = i;
        }
    }

    public void mo3690a(Object obj) {
        this.f10758j = obj;
    }

    public Object mo3719s() {
        return this.f10758j;
    }

    public void mo3703d(boolean z) {
    }

    public boolean mo3720t() {
        return false;
    }

    public int mo3722v() {
        return this.f10767s;
    }

    public LatLng mo3707g() {
        return null;
    }

    public void mo3726z() {
    }

    public void mo3705e(boolean z) throws RemoteException {
        m14234M();
    }

    public boolean mo3674A() {
        return false;
    }

    public void mo3683a(float f) throws RemoteException {
    }

    public void mo3716p() {
    }

    public void mo3693a(GL10 gl10, aa aaVar) {
    }

    public float mo3721u() {
        return 0.0f;
    }

    public void m14267b(int i, int i2) throws RemoteException {
        this.f10750b = i;
        this.f10751c = i2;
    }

    public int mo3675B() {
        return this.f10750b;
    }

    public int mo3676C() {
        return this.f10751c;
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
        return this.f10754f;
    }

    public boolean mo3679F() {
        return false;
    }

    public void mo3696b(float f) {
    }

    public float mo3680G() {
        return 0.0f;
    }

    public boolean mo3681H() {
        return false;
    }

    public void mo3698b(boolean z) {
    }

    public void mo3689a(IPoint iPoint) {
    }

    public IPoint mo3682I() {
        return null;
    }
}
