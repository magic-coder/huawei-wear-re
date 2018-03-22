package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.util.au;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GroundOverlayDelegateImp */
public class C3363z implements ae {
    private aa f11940a;
    private BitmapDescriptor f11941b;
    private LatLng f11942c;
    private float f11943d;
    private float f11944e;
    private LatLngBounds f11945f;
    private float f11946g;
    private float f11947h;
    private boolean f11948i = true;
    private float f11949j = 0.0f;
    private float f11950k = 0.5f;
    private float f11951l = 0.5f;
    private String f11952m;
    private FloatBuffer f11953n = null;
    private FloatBuffer f11954o;
    private int f11955p;
    private boolean f11956q = false;
    private boolean f11957r = false;

    public C3363z(aa aaVar) {
        this.f11940a = aaVar;
        try {
            this.f11952m = mo3883c();
        } catch (Throwable e) {
            ca.m15831a(e, "GroundOverlayDelegateImp", "create");
            e.printStackTrace();
        }
    }

    public void mo3880b() throws RemoteException {
        this.f11940a.mo3818f(this.f11955p);
        this.f11940a.mo3800a(mo3883c());
        this.f11940a.mo3816e(false);
    }

    public String mo3883c() throws RemoteException {
        if (this.f11952m == null) {
            this.f11952m = C3347v.m16333a("GroundOverlay");
        }
        return this.f11952m;
    }

    public void mo3873a(float f) throws RemoteException {
        this.f11947h = f;
        this.f11940a.mo3746M();
        this.f11940a.mo3816e(false);
    }

    public float mo3884d() throws RemoteException {
        return this.f11947h;
    }

    public void mo3877a(boolean z) throws RemoteException {
        this.f11948i = z;
        this.f11940a.mo3816e(false);
    }

    public boolean mo3885e() throws RemoteException {
        return this.f11948i;
    }

    public boolean mo3879a(ai aiVar) throws RemoteException {
        if (equals(aiVar) || aiVar.mo3883c().equals(mo3883c())) {
            return true;
        }
        return false;
    }

    public int mo3886f() throws RemoteException {
        return super.hashCode();
    }

    public void mo3887g() throws RemoteException {
        this.f11957r = false;
        if (this.f11942c == null) {
            m16399q();
        } else if (this.f11945f == null) {
            m16398p();
        } else {
            m16400r();
        }
    }

    private void m16398p() {
        if (this.f11942c != null) {
            double cos = ((double) this.f11943d) / ((6371000.79d * Math.cos(this.f11942c.latitude * 0.01745329251994329d)) * 0.01745329251994329d);
            double d = ((double) this.f11944e) / 111194.94043265979d;
            this.f11945f = new LatLngBounds(new LatLng(this.f11942c.latitude - (((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11951l)) * d), this.f11942c.longitude - (((double) this.f11950k) * cos)), new LatLng((d * ((double) this.f11951l)) + this.f11942c.latitude, (cos * ((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11950k))) + this.f11942c.longitude));
            m16400r();
        }
    }

    private void m16399q() {
        if (this.f11945f != null) {
            LatLng latLng = this.f11945f.southwest;
            LatLng latLng2 = this.f11945f.northeast;
            this.f11942c = new LatLng(latLng.latitude + (((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11951l)) * (latLng2.latitude - latLng.latitude)), latLng.longitude + (((double) this.f11950k) * (latLng2.longitude - latLng.longitude)));
            this.f11943d = (float) (((6371000.79d * Math.cos(this.f11942c.latitude * 0.01745329251994329d)) * (latLng2.longitude - latLng.longitude)) * 0.01745329251994329d);
            this.f11944e = (float) (((latLng2.latitude - latLng.latitude) * 6371000.79d) * 0.01745329251994329d);
            m16400r();
        }
    }

    private void m16400r() {
        if (this.f11945f != null) {
            float[] fArr = new float[12];
            FPoint fPoint = new FPoint();
            FPoint fPoint2 = new FPoint();
            FPoint fPoint3 = new FPoint();
            FPoint fPoint4 = new FPoint();
            this.f11940a.mo3764a(this.f11945f.southwest.latitude, this.f11945f.southwest.longitude, fPoint);
            this.f11940a.mo3764a(this.f11945f.southwest.latitude, this.f11945f.northeast.longitude, fPoint2);
            this.f11940a.mo3764a(this.f11945f.northeast.latitude, this.f11945f.northeast.longitude, fPoint3);
            this.f11940a.mo3764a(this.f11945f.northeast.latitude, this.f11945f.southwest.longitude, fPoint4);
            if (this.f11946g != 0.0f) {
                double d = (double) (fPoint2.f13252x - fPoint.f13252x);
                double d2 = (double) (fPoint2.f13253y - fPoint3.f13253y);
                DPoint dPoint = new DPoint();
                dPoint.f13250x = ((double) fPoint.f13252x) + (((double) this.f11950k) * d);
                dPoint.f13251y = ((double) fPoint.f13253y) - (((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11951l)) * d2);
                m16396a(dPoint, 0.0d, 0.0d, d, d2, fPoint);
                m16396a(dPoint, d, 0.0d, d, d2, fPoint2);
                m16396a(dPoint, d, d2, d, d2, fPoint3);
                m16396a(dPoint, 0.0d, d2, d, d2, fPoint4);
            }
            fArr[0] = fPoint.f13252x;
            fArr[1] = fPoint.f13253y;
            fArr[2] = 0.0f;
            fArr[3] = fPoint2.f13252x;
            fArr[4] = fPoint2.f13253y;
            fArr[5] = 0.0f;
            fArr[6] = fPoint3.f13252x;
            fArr[7] = fPoint3.f13253y;
            fArr[8] = 0.0f;
            fArr[9] = fPoint4.f13252x;
            fArr[10] = fPoint4.f13253y;
            fArr[11] = 0.0f;
            if (this.f11953n == null) {
                this.f11953n = bk.m15659a(fArr);
            } else {
                this.f11953n = bk.m15660a(fArr, this.f11953n);
            }
        }
    }

    private void m16396a(DPoint dPoint, double d, double d2, double d3, double d4, FPoint fPoint) {
        double d5 = d - (((double) this.f11950k) * d3);
        double d6 = (((double) (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11951l)) * d4) - d2;
        double d7 = ((double) (-this.f11946g)) * 0.01745329251994329d;
        fPoint.f13252x = (float) (dPoint.f13250x + ((Math.cos(d7) * d5) + (Math.sin(d7) * d6)));
        fPoint.f13253y = (float) (((d6 * Math.cos(d7)) - (d5 * Math.sin(d7))) + dPoint.f13251y);
    }

    private void m16401s() {
        if (this.f11941b != null) {
            int width = this.f11941b.getWidth();
            float width2 = ((float) width) / ((float) this.f11941b.getBitmap().getWidth());
            float height = ((float) this.f11941b.getHeight()) / ((float) this.f11941b.getBitmap().getHeight());
            this.f11954o = bk.m15659a(new float[]{0.0f, height, width2, height, width2, 0.0f, 0.0f, 0.0f});
        }
    }

    public void mo3876a(GL10 gl10) throws RemoteException {
        if (!this.f11948i) {
            return;
        }
        if ((this.f11942c != null || this.f11945f != null) && this.f11941b != null) {
            if (!this.f11956q) {
                Bitmap bitmap = this.f11941b.getBitmap();
                if (!(bitmap == null || bitmap.isRecycled())) {
                    if (this.f11955p == 0) {
                        this.f11955p = this.f11940a.mo3744K();
                        if (this.f11955p == 0) {
                            int[] iArr = new int[]{0};
                            gl10.glGenTextures(1, iArr, 0);
                            this.f11955p = iArr[0];
                        }
                    } else {
                        gl10.glDeleteTextures(1, new int[]{this.f11955p}, 0);
                    }
                    bk.m15643a(gl10, this.f11955p, bitmap);
                }
                this.f11956q = true;
            }
            if (this.f11943d != 0.0f || this.f11944e != 0.0f) {
                m16397a(gl10, this.f11955p, this.f11953n, this.f11954o);
                this.f11957r = true;
            }
        }
    }

    private void m16397a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(TradeCode.BUSINESS_ORDER_SETTING_VER2);
            gl10.glTexEnvf(8960, 8704, 8448.0f);
            gl10.glBlendFunc(1, 771);
            gl10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - this.f11949j);
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

    public void mo3890j() {
        try {
            mo3880b();
            if (this.f11941b != null) {
                Bitmap bitmap = this.f11941b.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    this.f11941b = null;
                }
            }
            if (this.f11954o != null) {
                this.f11954o.clear();
                this.f11954o = null;
            }
            if (this.f11953n != null) {
                this.f11953n.clear();
                this.f11953n = null;
            }
            this.f11942c = null;
            this.f11945f = null;
        } catch (Throwable th) {
            ca.m15831a(th, "GroundOverlayDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
        }
    }

    public boolean mo3878a() {
        if (this.f11945f == null) {
            return false;
        }
        LatLngBounds G = this.f11940a.mo3741G();
        if (G == null) {
            return true;
        }
        if (G.contains(this.f11945f) || this.f11945f.intersects(G)) {
            return true;
        }
        return false;
    }

    public void mo4076a(LatLng latLng) throws RemoteException {
        this.f11942c = latLng;
        m16398p();
        this.f11940a.mo3816e(false);
    }

    public LatLng mo4081h() throws RemoteException {
        return this.f11942c;
    }

    public void mo4078b(float f) throws RemoteException {
        au.m15523b(f >= 0.0f, "Width must be non-negative");
        if (!this.f11956q || this.f11943d == f) {
            this.f11943d = f;
            this.f11944e = f;
        } else {
            this.f11943d = f;
            this.f11944e = f;
            m16398p();
        }
        this.f11940a.mo3816e(false);
    }

    public void mo4074a(float f, float f2) throws RemoteException {
        boolean z = true;
        au.m15523b(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        au.m15523b(z, "Height must be non-negative");
        if (!this.f11956q || this.f11943d == f || this.f11944e == f2) {
            this.f11943d = f;
            this.f11944e = f2;
        } else {
            this.f11943d = f;
            this.f11944e = f2;
            m16398p();
        }
        this.f11940a.mo3816e(false);
    }

    public float mo4082i() throws RemoteException {
        return this.f11943d;
    }

    public float mo4083l() throws RemoteException {
        return this.f11944e;
    }

    public void mo4077a(LatLngBounds latLngBounds) throws RemoteException {
        this.f11945f = latLngBounds;
        m16399q();
        this.f11940a.mo3816e(false);
    }

    public LatLngBounds mo4084m() throws RemoteException {
        return this.f11945f;
    }

    public void mo4079c(float f) throws RemoteException {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (!this.f11956q || ((double) Math.abs(this.f11946g - f2)) >= 1.0E-7d) {
            this.f11946g = f2;
        } else {
            this.f11946g = f2;
            m16400r();
        }
        this.f11940a.mo3816e(false);
    }

    public float mo4085n() throws RemoteException {
        return this.f11946g;
    }

    public void mo4080d(float f) throws RemoteException {
        boolean z = f >= 0.0f && f <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        au.m15523b(z, "Transparency must be in the range [0..1]");
        this.f11949j = f;
        this.f11940a.mo3816e(false);
    }

    public float mo4086o() throws RemoteException {
        return this.f11949j;
    }

    public void mo4075a(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        this.f11941b = bitmapDescriptor;
        m16401s();
        if (this.f11956q) {
            this.f11956q = false;
        }
        this.f11940a.mo3816e(false);
    }

    public void m16413b(float f, float f2) throws RemoteException {
        this.f11950k = f;
        this.f11951l = f2;
        this.f11940a.mo3816e(false);
    }

    public boolean mo3891k() {
        return this.f11957r;
    }
}
