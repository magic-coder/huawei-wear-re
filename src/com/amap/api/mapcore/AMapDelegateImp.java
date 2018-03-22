package com.amap.api.mapcore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.mapcore.C3259o.C3258a;
import com.amap.api.mapcore.aq.C3221a;
import com.amap.api.mapcore.ay.C3237a;
import com.amap.api.mapcore.util.C3300c;
import com.amap.api.mapcore.util.C3300c.C3213a;
import com.amap.api.mapcore.util.C3310d;
import com.amap.api.mapcore.util.C3310d.C3223a;
import com.amap.api.mapcore.util.C3320f;
import com.amap.api.mapcore.util.au;
import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.bk;
import com.amap.api.mapcore.util.bm;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.AMap$CancelableCallback;
import com.amap.api.maps.AMap$InfoWindowAdapter;
import com.amap.api.maps.AMap$OnCacheRemoveListener;
import com.amap.api.maps.AMap$OnCameraChangeListener;
import com.amap.api.maps.AMap$OnInfoWindowClickListener;
import com.amap.api.maps.AMap$OnMapClickListener;
import com.amap.api.maps.AMap$OnMapLoadedListener;
import com.amap.api.maps.AMap$OnMapLongClickListener;
import com.amap.api.maps.AMap$OnMapScreenShotListener;
import com.amap.api.maps.AMap$OnMapTouchListener;
import com.amap.api.maps.AMap$OnMarkerClickListener;
import com.amap.api.maps.AMap$OnMarkerDragListener;
import com.amap.api.maps.AMap$OnMyLocationChangeListener;
import com.amap.api.maps.AMap$OnPOIClickListener;
import com.amap.api.maps.AMap$OnPolylineClickListener;
import com.amap.api.maps.AMap$onMapPrintScreenListener;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.android.volley.DefaultRetryPolicy;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.GLMapResManager;
import com.autonavi.amap.mapcore.GLMapResManager.MapViewMode;
import com.autonavi.amap.mapcore.GLMapResManager.MapViewModeState;
import com.autonavi.amap.mapcore.GLMapResManager.MapViewTime;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager;
import com.autonavi.amap.mapcore.SelectedMapPoi;
import com.autonavi.amap.mapcore.VMapDataCache;
import com.huawei.datatype.SportType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.log4j.net.SyslogAppender;

public class AMapDelegateImp implements Renderer, aa {
    private static final double az = Math.log(2.0d);
    private MapCore f10821A;
    private Context f10822B;
    private C3228a f10823C = null;
    private MapProjection f10824D;
    private GestureDetector f10825E;
    private ScaleGestureDetector f10826F;
    private C3310d f10827G;
    private SurfaceHolder f10828H = null;
    private ay f10829I;
    private bq f10830J;
    private ar f10831K;
    private C3262q f10832L;
    private bi f10833M;
    private aq f10834N;
    private AMap$OnMyLocationChangeListener f10835O;
    private AMap$OnMarkerClickListener f10836P;
    private AMap$OnPolylineClickListener f10837Q;
    private AMap$OnMarkerDragListener f10838R;
    private AMap$OnMapLoadedListener f10839S;
    private AMap$OnCameraChangeListener f10840T;
    private AMap$OnMapClickListener f10841U;
    private AMap$OnMapTouchListener f10842V;
    private AMap$OnPOIClickListener f10843W;
    private AMap$OnMapLongClickListener f10844X;
    private AMap$OnInfoWindowClickListener f10845Y;
    private AMap$InfoWindowAdapter f10846Z;
    float f10847a = 10.0f;
    private boolean aA = true;
    private boolean aB = false;
    private boolean aC = false;
    private boolean aD = false;
    private boolean aE = true;
    private boolean aF = false;
    private boolean aG = false;
    private boolean aH = false;
    private Boolean aI = Boolean.valueOf(false);
    private boolean aJ = false;
    private boolean aK = true;
    private boolean aL = false;
    private Handler aM = new Handler();
    private C3266s aN = new C3266s();
    private boolean aO;
    private volatile boolean aP = false;
    private volatile boolean aQ = false;
    private Handler aR = new Handler();
    private Runnable aS = new C3251i(this);
    private volatile boolean aT = false;
    private boolean aU = false;
    private boolean aV = false;
    private boolean aW = false;
    private boolean aX = false;
    private Marker aY = null;
    private ag aZ = null;
    private AMap$InfoWindowAdapter aa;
    private View ab;
    private ag ac;
    private bg ad;
    private al ae;
    private ap af;
    private LocationSource ag;
    private Rect ah = new Rect();
    private C3255l ai;
    private C3300c aj;
    private ba ak;
    private C3257n al;
    private int am = 0;
    private int an = 0;
    private AMap$CancelableCallback ao = null;
    private int ap = 0;
    private Drawable aq = null;
    private Location ar;
    private AMap$onMapPrintScreenListener as = null;
    private AMap$OnMapScreenShotListener at = null;
    private Handler au = new Handler();
    private C3320f av = null;
    private C3259o aw = null;
    private Timer ax;
    private TimeChangedReceiver ay = null;
    float f10848b = 0.0f;
    private boolean ba = false;
    private boolean bb = false;
    private boolean bc = false;
    private int bd = 0;
    private boolean be = false;
    private Thread bf = new C3245c(this);
    private LatLngBounds bg = null;
    private boolean bh = false;
    private boolean bi = false;
    private boolean bj = false;
    private int bk;
    private int bl;
    private Handler bm = new C3247e(this);
    private Runnable bn = new C3248f(this);
    private Runnable bo = new C3249g(this);
    private boolean bp = false;
    private C3212a bq = new C3250h(this);
    float f10849c = 0.0f;
    public av f10850d;
    au f10851e = new au(this);
    br f10852f;
    bn f10853g;
    C3347v f10854h = null;
    GLMapResManager f10855i = null;
    ad f10856j = null;
    Runnable f10857k;
    final Handler f10858l = new C3246d(this);
    CustomRenderer f10859m;
    private int f10860n = -1;
    private int f10861o = -1;
    private Bitmap f10862p = null;
    private Bitmap f10863q = null;
    private int f10864r = 221010267;
    private int f10865s = 101697799;
    private final int[] f10866t = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
    private CopyOnWriteArrayList<Integer> f10867u = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<Integer> f10868v = new CopyOnWriteArrayList();
    private MapViewTime f10869w = MapViewTime.DAY;
    private MapViewMode f10870x = MapViewMode.NORAML;
    private MapViewModeState f10871y = MapViewModeState.NORMAL;
    private int f10872z = 1;

    class C32042 implements Runnable {
        final /* synthetic */ AMapDelegateImp f10748a;

        C32042(AMapDelegateImp aMapDelegateImp) {
            this.f10748a = aMapDelegateImp;
        }

        public void run() {
            try {
                this.f10748a.mo3775a(this.f10748a.ac);
            } catch (Throwable th) {
                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "showInfoWindow postDelayed");
                th.printStackTrace();
            }
        }
    }

    class C32075 implements Runnable {
        final /* synthetic */ AMapDelegateImp f10771a;

        C32075(AMapDelegateImp aMapDelegateImp) {
            this.f10771a = aMapDelegateImp;
        }

        public void run() {
            this.f10771a.f10834N.setVisibility(8);
        }
    }

    class C32086 implements Runnable {
        final /* synthetic */ AMapDelegateImp f10772a;

        C32086(AMapDelegateImp aMapDelegateImp) {
            this.f10772a = aMapDelegateImp;
        }

        public void run() {
            try {
                this.f10772a.f10834N.setVisibility(0);
                this.f10772a.f10834N.m14824a(this.f10772a.av.f11759h);
                this.f10772a.f10834N.m14823a(this.f10772a.av.f11754c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class C32097 implements AMap$InfoWindowAdapter {
        final /* synthetic */ AMapDelegateImp f10773a;

        C32097(AMapDelegateImp aMapDelegateImp) {
            this.f10773a = aMapDelegateImp;
        }

        public View getInfoWindow(Marker marker) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            return null;
        }
    }

    class C32108 implements Runnable {
        final /* synthetic */ AMapDelegateImp f10774a;

        C32108(AMapDelegateImp aMapDelegateImp) {
            this.f10774a = aMapDelegateImp;
        }

        public void run() {
            this.f10774a.f10858l.obtainMessage(19).sendToTarget();
        }
    }

    class C32119 implements Runnable {
        final /* synthetic */ AMapDelegateImp f10775a;

        C32119(AMapDelegateImp aMapDelegateImp) {
            this.f10775a = aMapDelegateImp;
        }

        public void run() {
            try {
                this.f10775a.f10821A.destroy();
                this.f10775a.f10821A = null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class TimeChangedReceiver extends BroadcastReceiver {
        final /* synthetic */ AMapDelegateImp f10776a;

        public TimeChangedReceiver(AMapDelegateImp aMapDelegateImp) {
            this.f10776a = aMapDelegateImp;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.DATE_CHANGED".equals(action)) {
            }
            if ("android.intent.action.TIME_SET".equals(action)) {
                this.f10776a.f10858l.sendEmptyMessage(22);
            }
        }
    }

    abstract class C3212a implements Runnable {
        boolean f10777b;
        boolean f10778c;
        MapViewMode f10779d;
        MapViewTime f10780e;
        MapViewModeState f10781f;

        private C3212a() {
            this.f10777b = false;
            this.f10778c = false;
        }

        public void run() {
            this.f10777b = false;
        }
    }

    class C3214b implements C3213a {
        Float f10782a;
        Float f10783b;
        IPoint f10784c;
        float f10785d;
        C3259o f10786e;
        final /* synthetic */ AMapDelegateImp f10787f;
        private float f10788g;
        private float f10789h;
        private float f10790i;
        private float f10791j;
        private float f10792k;

        private C3214b(AMapDelegateImp aMapDelegateImp) {
            this.f10787f = aMapDelegateImp;
            this.f10782a = null;
            this.f10783b = null;
            this.f10784c = new IPoint();
            this.f10785d = 0.0f;
            this.f10786e = C3259o.m15323a();
        }

        public void mo3731a(float f, float f2, float f3, float f4, float f5) {
            this.f10788g = f2;
            this.f10790i = f3;
            this.f10789h = f4;
            this.f10791j = f5;
            this.f10792k = (this.f10791j - this.f10790i) / (this.f10789h - this.f10788g);
            this.f10782a = null;
            this.f10783b = null;
            if (this.f10787f.bj) {
                this.f10786e.f11323a = C3258a.changeGeoCenterZoomTiltBearing;
                this.f10787f.mo3773a(this.f10787f.bk, this.f10787f.bl, this.f10784c);
                this.f10786e.f11337o = this.f10784c;
                this.f10786e.f11336n = this.f10787f.bj;
            } else {
                this.f10786e.f11323a = C3258a.changeTilt;
            }
            this.f10786e.f11326d = this.f10787f.f10824D.getMapZoomer();
            this.f10786e.f11329g = this.f10787f.f10824D.getMapAngle();
        }

        public boolean mo3732a(MotionEvent motionEvent, float f, float f2, float f3, float f4) {
            try {
                if (!this.f10787f.af.mo3971g()) {
                    return true;
                }
                if (this.f10787f.aW || this.f10787f.bb) {
                    return true;
                }
                if (this.f10783b == null) {
                    this.f10783b = Float.valueOf(f4);
                }
                if (this.f10782a == null) {
                    this.f10782a = Float.valueOf(f2);
                }
                float f5 = this.f10790i - f2;
                float f6 = this.f10791j - f4;
                float f7 = this.f10788g - f;
                float f8 = this.f10789h - f3;
                if (((double) Math.abs(this.f10792k - ((f4 - f2) / (f3 - f)))) >= 0.2d || (((f5 <= 0.0f || f6 <= 0.0f) && (f5 >= 0.0f || f6 >= 0.0f)) || ((f7 < 0.0f || f8 < 0.0f) && (f7 > 0.0f || f8 > 0.0f)))) {
                    return false;
                }
                f6 = (this.f10782a.floatValue() - f2) / 4.0f;
                this.f10787f.aV = true;
                f5 = this.f10787f.f10824D.getCameraHeaderAngle();
                if (f5 > 45.0f) {
                    f5 = 45.0f;
                }
                this.f10785d = f5 - f6;
                this.f10786e.f11328f = this.f10785d;
                this.f10787f.f10851e.m14847a(this.f10786e);
                this.f10782a = Float.valueOf(f2);
                this.f10783b = Float.valueOf(f4);
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return true;
            }
        }

        public void mo3730a() {
            if (!this.f10787f.aW) {
                try {
                    if (!this.f10787f.af.mo3969f()) {
                        return;
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                try {
                    this.f10787f.mo3806b(C3259o.m15338c());
                } catch (Throwable e2) {
                    ca.m15831a(e2, "AMapDelegateImpGLSurfaceView", "onMultiTouchSingleTap");
                    e2.printStackTrace();
                }
            }
        }
    }

    class C3218c implements OnDoubleTapListener {
        final /* synthetic */ AMapDelegateImp f10799a;

        private C3218c(AMapDelegateImp aMapDelegateImp) {
            this.f10799a = aMapDelegateImp;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onDoubleTap(android.view.MotionEvent r6) {
            /*
            r5 = this;
            r4 = 1;
            r0 = r5.f10799a;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.af;	 Catch:{ RemoteException -> 0x000e }
            r0 = r0.mo3969f();	 Catch:{ RemoteException -> 0x000e }
            if (r0 != 0) goto L_0x0012;
        L_0x000d:
            return r4;
        L_0x000e:
            r0 = move-exception;
            r0.printStackTrace();
        L_0x0012:
            r0 = r5.f10799a;
            r0 = r0.bd;
            if (r0 > r4) goto L_0x000d;
        L_0x001a:
            r0 = r5.f10799a;
            r0.bc = r4;
            r0 = r5.f10799a;
            r0 = r0.f10824D;
            r0 = r0.getMapZoomer();
            r1 = r5.f10799a;
            r1 = r1.mo3835r();
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x000d;
        L_0x0033:
            r0 = r6.getX();
            r1 = r6.getY();
            r0 = (int) r0;
            r1 = (int) r1;
            r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r3 = new android.graphics.Point;
            r3.<init>(r0, r1);
            r0 = com.amap.api.mapcore.C3259o.m15326a(r2, r3);
            r1 = r5.f10799a;	 Catch:{ RemoteException -> 0x004e }
            r1.mo3806b(r0);	 Catch:{ RemoteException -> 0x004e }
            goto L_0x000d;
        L_0x004e:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onDoubleTap";
            com.amap.api.mapcore.util.ca.m15831a(r0, r1, r2);
            r0.printStackTrace();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImp.c.onDoubleTap(android.view.MotionEvent):boolean");
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
            this.f10799a.ba = false;
            if (this.f10799a.be) {
                this.f10799a.be = false;
            } else {
                if (this.f10799a.ab != null) {
                    if (this.f10799a.f10850d.m14864a(new Rect(this.f10799a.ab.getLeft(), this.f10799a.ab.getTop(), this.f10799a.ab.getRight(), this.f10799a.ab.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        if (this.f10799a.f10845Y != null) {
                            ag d = this.f10799a.f10850d.m14870d();
                            if (d.mo3715o()) {
                                this.f10799a.f10845Y.onInfoWindowClick(new Marker(d));
                            }
                        }
                    }
                }
                try {
                    if (this.f10799a.f10850d.m14866b(motionEvent)) {
                        final ag d2 = this.f10799a.f10850d.m14870d();
                        if (d2 != null && d2.mo3715o()) {
                            Marker marker = new Marker(d2);
                            if (this.f10799a.f10836P != null) {
                                if (this.f10799a.f10836P.onMarkerClick(marker) || this.f10799a.f10850d.m14855a() <= 0) {
                                    this.f10799a.f10850d.m14868c(d2);
                                } else {
                                    this.f10799a.au.postDelayed(new Runnable(this) {
                                        final /* synthetic */ C3218c f10794b;

                                        public void run() {
                                            try {
                                                this.f10794b.f10799a.mo3775a(d2);
                                            } catch (Throwable th) {
                                                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "onSingleTapUp showInfoWindow");
                                                th.printStackTrace();
                                            }
                                        }
                                    }, 20);
                                    if (!(this.f10799a.f10850d.m14870d() == null || d2.mo3679F())) {
                                        LatLng g = d2.mo3707g();
                                        if (g != null) {
                                            IPoint iPoint = new IPoint();
                                            this.f10799a.mo3765a(g.latitude, g.longitude, iPoint);
                                            this.f10799a.mo3776a(C3259o.m15334a(iPoint));
                                        }
                                    }
                                }
                            }
                            this.f10799a.f10850d.m14868c(d2);
                        }
                    } else {
                        DPoint dPoint;
                        if (this.f10799a.f10841U != null) {
                            dPoint = new DPoint();
                            this.f10799a.mo3771a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                            this.f10799a.f10841U.onMapClick(new LatLng(dPoint.f13251y, dPoint.f13250x));
                        }
                        if (this.f10799a.f10837Q != null) {
                            dPoint = new DPoint();
                            this.f10799a.mo3771a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint);
                            LatLng latLng = new LatLng(dPoint.f13251y, dPoint.f13250x);
                            if (latLng != null) {
                                ai a = this.f10799a.f10854h.m16337a(latLng);
                                if (a != null) {
                                    this.f10799a.f10837Q.onPolylineClick(new Polyline((ak) a));
                                }
                            }
                        }
                        this.f10799a.m14584a(new Runnable(this) {
                            final /* synthetic */ C3218c f10798b;

                            public void run() {
                                final Poi a = this.f10798b.f10799a.m14454a((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                                if (this.f10798b.f10799a.f10843W != null && a != null) {
                                    this.f10798b.f10799a.f10858l.post(new Runnable(this) {
                                        final /* synthetic */ C32172 f10796b;

                                        public void run() {
                                            this.f10796b.f10798b.f10799a.f10843W.onPOIClick(a);
                                        }
                                    });
                                }
                            }
                        });
                    }
                } catch (Throwable e) {
                    ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "onSingleTapUp moveCamera");
                    e.printStackTrace();
                } catch (Throwable e2) {
                    ca.m15831a(e2, "AMapDelegateImpGLSurfaceView", "onSingleTapUp");
                    e2.printStackTrace();
                }
            }
            return true;
        }
    }

    class C3219d implements OnGestureListener {
        FPoint f10800a;
        IPoint f10801b;
        IPoint f10802c;
        C3259o f10803d;
        final /* synthetic */ AMapDelegateImp f10804e;

        private C3219d(AMapDelegateImp aMapDelegateImp) {
            this.f10804e = aMapDelegateImp;
            this.f10800a = new FPoint();
            this.f10801b = new IPoint();
            this.f10802c = new IPoint();
            this.f10803d = C3259o.m15334a(this.f10802c);
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f10804e.ba = false;
            if (!this.f10804e.bc) {
                try {
                    this.f10804e.mo3837t();
                } catch (Throwable e) {
                    ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "onDown");
                    e.printStackTrace();
                }
            }
            this.f10804e.bc = false;
            this.f10804e.bd = 0;
            this.f10800a.f13252x = motionEvent.getX();
            this.f10800a.f13253y = motionEvent.getY();
            this.f10804e.mo3773a((int) this.f10800a.f13252x, (int) this.f10800a.f13253y, this.f10801b);
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onFling(android.view.MotionEvent r11, android.view.MotionEvent r12, float r13, float r14) {
            /*
            r10 = this;
            r4 = 0;
            r9 = 1;
            r0 = r10.f10804e;
            r0.ba = r4;
            r0 = r10.f10804e;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.af;	 Catch:{ RemoteException -> 0x0014 }
            r0 = r0.mo3967e();	 Catch:{ RemoteException -> 0x0014 }
            if (r0 != 0) goto L_0x001f;
        L_0x0013:
            return r9;
        L_0x0014:
            r0 = move-exception;
            r1 = "AMapDelegateImpGLSurfaceView";
            r2 = "onFling";
            com.amap.api.mapcore.util.ca.m15831a(r0, r1, r2);
            r0.printStackTrace();
        L_0x001f:
            r0 = r10.f10804e;
            r0 = r0.aj;
            r0 = r0.m15820a();
            if (r0 != 0) goto L_0x0013;
        L_0x002b:
            r0 = r11.getEventTime();
            r2 = r10.f10804e;
            r2 = r2.aj;
            r2 = r2.m15822b();
            r0 = r0 - r2;
            r2 = 30;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x0013;
        L_0x0040:
            r0 = r10.f10804e;
            r0 = r0.mo3827k();
            r1 = r10.f10804e;
            r1 = r1.mo3829l();
            r6 = r0 * 2;
            r8 = r1 * 2;
            r2 = r10.f10804e;
            r0 = r0 / 2;
            r2.am = r0;
            r0 = r10.f10804e;
            r1 = r1 / 2;
            r0.an = r1;
            r0 = r10.f10804e;
            r1 = 0;
            r0.ao = r1;
            r0 = r10.f10804e;
            r0 = r0.ab;
            if (r0 == 0) goto L_0x0096;
        L_0x006c:
            r0 = r10.f10804e;
            r0 = r0.ac;
            if (r0 == 0) goto L_0x0096;
        L_0x0074:
            r0 = r10.f10804e;
            r0 = r0.ac;
            r0 = r0.mo3679F();
            if (r0 != 0) goto L_0x0096;
        L_0x0080:
            r0 = r10.f10804e;
            r0.aK = r4;
            r0 = r10.f10804e;
            r0 = r0.ad;
            if (r0 == 0) goto L_0x0096;
        L_0x008d:
            r0 = r10.f10804e;
            r0 = r0.ad;
            r0.mo3700c(r9);
        L_0x0096:
            r0 = r10.f10804e;
            r0 = r0.al;
            r1 = r10.f10804e;
            r1 = r1.am;
            r2 = r10.f10804e;
            r2 = r2.an;
            r3 = -r13;
            r3 = (int) r3;
            r3 = r3 * 3;
            r3 = r3 / 5;
            r4 = -r14;
            r4 = (int) r4;
            r4 = r4 * 3;
            r4 = r4 / 5;
            r5 = -r6;
            r7 = -r8;
            r0.m15308a(r1, r2, r3, r4, r5, r6, r7, r8);
            r0 = r10.f10804e;
            r0 = r0.f10853g;
            if (r0 == 0) goto L_0x0013;
        L_0x00bf:
            r0 = r10.f10804e;
            r0 = r0.f10853g;
            r0.m15219b(r9);
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.AMapDelegateImp.d.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f10804e.ba = false;
            this.f10804e.aZ = this.f10804e.f10850d.m14857a(motionEvent);
            if (this.f10804e.f10838R != null && this.f10804e.aZ != null && this.f10804e.aZ.mo3711k()) {
                this.f10804e.aY = new Marker(this.f10804e.aZ);
                LatLng position = this.f10804e.aY.getPosition();
                LatLng g = this.f10804e.aZ.mo3707g();
                IPoint iPoint = new IPoint();
                this.f10804e.mo3802b(g.latitude, g.longitude, iPoint);
                iPoint.f13274y -= 60;
                DPoint dPoint = new DPoint();
                this.f10804e.mo3771a(iPoint.f13273x, iPoint.f13274y, dPoint);
                this.f10804e.aY.setPosition(new LatLng((position.latitude + dPoint.f13251y) - g.latitude, (dPoint.f13250x + position.longitude) - g.longitude));
                this.f10804e.f10850d.m14868c(this.f10804e.aZ);
                this.f10804e.f10838R.onMarkerDragStart(this.f10804e.aY);
                this.f10804e.aX = true;
            } else if (this.f10804e.f10844X != null) {
                DPoint dPoint2 = new DPoint();
                this.f10804e.mo3771a((int) motionEvent.getX(), (int) motionEvent.getY(), dPoint2);
                this.f10804e.f10844X.onMapLongClick(new LatLng(dPoint2.f13251y, dPoint2.f13250x));
                this.f10804e.be = true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f10804e.ba = true;
            if ((!this.f10804e.al.m15311a() && this.f10804e.al.m15321j() == 1) || this.f10804e.aj.m15820a() || motionEvent2.getEventTime() - this.f10804e.aj.m15822b() < 30) {
                this.f10804e.ba = false;
            } else if (motionEvent2.getPointerCount() >= 2) {
                this.f10804e.ba = false;
            } else {
                try {
                    if (!this.f10804e.af.mo3967e()) {
                        this.f10804e.ba = false;
                    } else if (this.f10804e.bd > 1) {
                        this.f10804e.ba = false;
                    } else {
                        if (!(this.f10804e.ab == null || this.f10804e.ac == null || this.f10804e.ac.mo3679F() || this.f10804e.ad == null)) {
                            this.f10804e.ad.mo3700c(true);
                        }
                        IPoint iPoint = new IPoint();
                        this.f10804e.mo3773a((int) motionEvent2.getX(), (int) motionEvent2.getY(), iPoint);
                        int i = this.f10801b.f13273x - iPoint.f13273x;
                        int i2 = this.f10801b.f13274y - iPoint.f13274y;
                        IPoint iPoint2 = new IPoint();
                        this.f10804e.f10824D.getGeoCenter(iPoint2);
                        this.f10802c.f13273x = i + iPoint2.f13273x;
                        this.f10802c.f13274y = i2 + iPoint2.f13274y;
                        this.f10803d.f11337o = this.f10802c;
                        this.f10804e.f10851e.m14847a(this.f10803d);
                    }
                } catch (Throwable th) {
                    ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "onScroll");
                    th.printStackTrace();
                }
            }
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    class C3222e implements C3221a {
        final /* synthetic */ AMapDelegateImp f10806a;

        class C32201 implements Runnable {
            final /* synthetic */ C3222e f10805a;

            C32201(C3222e c3222e) {
                this.f10805a = c3222e;
            }

            public void run() {
                this.f10805a.f10806a.f10821A.setIndoorBuildingToBeActive(this.f10805a.f10806a.av.f11754c, this.f10805a.f10806a.av.f11755d, this.f10805a.f10806a.av.f11756e);
            }
        }

        private C3222e(AMapDelegateImp aMapDelegateImp) {
            this.f10806a = aMapDelegateImp;
        }

        public void mo3733a(int i) {
            if (this.f10806a.av != null) {
                this.f10806a.av.f11755d = this.f10806a.av.f11758g[i];
                this.f10806a.av.f11754c = this.f10806a.av.f11759h[i];
                this.f10806a.mo3816e(false);
                this.f10806a.m14584a(new C32201(this));
            }
        }
    }

    class C3224f implements C3223a {
        float f10807a;
        float f10808b;
        IPoint f10809c;
        C3259o f10810d;
        final /* synthetic */ AMapDelegateImp f10811e;

        private C3224f(AMapDelegateImp aMapDelegateImp) {
            this.f10811e = aMapDelegateImp;
            this.f10807a = 0.0f;
            this.f10808b = 0.0f;
            this.f10809c = new IPoint();
            this.f10810d = C3259o.m15323a();
        }

        public boolean mo3734a(C3310d c3310d) {
            if (this.f10811e.aV) {
                return false;
            }
            float b = c3310d.m15984b();
            this.f10807a += b;
            if (!this.f10811e.bb && Math.abs(this.f10807a) <= BitmapDescriptorFactory.HUE_ORANGE && Math.abs(this.f10807a) <= 350.0f) {
                return true;
            }
            this.f10811e.bb = true;
            this.f10808b = b + this.f10811e.f10824D.getMapAngle();
            this.f10810d.f11329g = this.f10808b;
            this.f10811e.f10851e.m14847a(this.f10810d);
            this.f10807a = 0.0f;
            return true;
        }

        public boolean mo3735b(C3310d c3310d) {
            try {
                if (!this.f10811e.af.mo3973h()) {
                    return false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (this.f10811e.bj) {
                this.f10810d.f11336n = this.f10811e.bj;
                this.f10810d.f11323a = C3258a.changeBearingGeoCenter;
                this.f10811e.mo3773a(this.f10811e.bk, this.f10811e.bl, this.f10809c);
                this.f10810d.f11337o = this.f10809c;
            } else {
                this.f10810d.f11323a = C3258a.changeBearing;
            }
            this.f10811e.bb = false;
            this.f10807a = 0.0f;
            this.f10811e.bd = 2;
            if (this.f10811e.aV || ((float) this.f10811e.m14625m()) / 8.0f >= c3310d.m15980c()) {
                return false;
            }
            return true;
        }

        public void mo3736c(C3310d c3310d) {
            this.f10807a = 0.0f;
            if (this.f10811e.bb) {
                this.f10811e.bb = false;
                C3259o a = C3259o.m15323a();
                a.f11338p = true;
                this.f10811e.f10851e.m14847a(a);
            }
            this.f10811e.ah();
        }
    }

    class C3225g implements OnScaleGestureListener {
        C3259o f10812a;
        final /* synthetic */ AMapDelegateImp f10813b;
        private float f10814c;
        private IPoint f10815d;

        private C3225g(AMapDelegateImp aMapDelegateImp) {
            this.f10813b = aMapDelegateImp;
            this.f10814c = 0.0f;
            this.f10815d = new IPoint();
            this.f10812a = C3259o.m15323a();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!this.f10813b.aV) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (this.f10813b.aW || ((double) scaleFactor) > 1.08d || ((double) scaleFactor) < 0.92d) {
                    this.f10813b.aW = true;
                    scaleFactor = (float) (Math.log((double) scaleFactor) / AMapDelegateImp.az);
                    this.f10812a.f11326d = bk.m15640a(scaleFactor + this.f10814c);
                    this.f10813b.f10851e.m14847a(this.f10812a);
                }
            }
            return false;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            try {
                if (!this.f10813b.af.mo3969f() || this.f10813b.bd < 2) {
                    return false;
                }
            } catch (Throwable e) {
                ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "onScaleBegin");
                e.printStackTrace();
            }
            this.f10813b.bd = 2;
            if (this.f10813b.aV) {
                return false;
            }
            if (this.f10813b.bj) {
                this.f10812a.f11336n = this.f10813b.bj;
                this.f10812a.f11323a = C3258a.changeGeoCenterZoom;
                this.f10813b.mo3773a(this.f10813b.bk, this.f10813b.bl, this.f10815d);
                this.f10812a.f11337o = this.f10815d;
            } else {
                this.f10812a.f11323a = C3258a.zoomTo;
            }
            this.f10813b.aW = false;
            this.f10814c = this.f10813b.f10824D.getMapZoomer();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f10814c = 0.0f;
            if (this.f10813b.aW) {
                this.f10813b.aW = false;
                C3259o a = C3259o.m15323a();
                a.f11338p = true;
                this.f10813b.f10851e.m14847a(a);
            }
            this.f10813b.ah();
        }
    }

    class C3226h extends TimerTask {
        AMapDelegateImp f10816a;
        final /* synthetic */ AMapDelegateImp f10817b;

        public C3226h(AMapDelegateImp aMapDelegateImp, AMapDelegateImp aMapDelegateImp2) {
            this.f10817b = aMapDelegateImp;
            this.f10816a = aMapDelegateImp2;
        }

        public void run() {
            if (!this.f10817b.aP || this.f10817b.aQ || !this.f10817b.f10854h.m16346d()) {
                this.f10817b.f10856j.requestRender();
            } else if (!this.f10817b.f10850d.m14869c()) {
                this.f10817b.f10856j.requestRender();
            }
        }
    }

    class C3227i implements Runnable {
        final /* synthetic */ AMapDelegateImp f10818a;
        private Context f10819b;
        private AMap$OnCacheRemoveListener f10820c;

        public C3227i(AMapDelegateImp aMapDelegateImp, Context context, AMap$OnCacheRemoveListener aMap$OnCacheRemoveListener) {
            this.f10818a = aMapDelegateImp;
            this.f10819b = context;
            this.f10820c = aMap$OnCacheRemoveListener;
        }

        public void run() {
            Throwable th;
            boolean z;
            Throwable th2;
            boolean z2;
            try {
                boolean z3;
                Context applicationContext = this.f10819b.getApplicationContext();
                String b = bk.m15673b(applicationContext);
                String a = bk.m15654a(applicationContext);
                boolean z4 = this.f10818a.m14466a(new File(b));
                if (z4) {
                    try {
                        if (this.f10818a.m14466a(new File(a))) {
                            z3 = true;
                            this.f10818a.f10821A.setParameter(2601, 1, 0, 0, 0);
                            if (this.f10820c != null) {
                                this.f10820c.onRemoveCacheFinish(z3);
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        z2 = z4;
                        this.f10818a.f10821A.setParameter(2601, 1, 0, 0, 0);
                        if (this.f10820c != null) {
                            this.f10820c.onRemoveCacheFinish(z2);
                        }
                        throw th2;
                    }
                }
                z3 = false;
                try {
                    this.f10818a.f10821A.setParameter(2601, 1, 0, 0, 0);
                    if (this.f10820c != null) {
                        this.f10820c.onRemoveCacheFinish(z3);
                    }
                } catch (Throwable th32) {
                    th32.printStackTrace();
                }
            } catch (Throwable th4) {
                th2 = th4;
                z2 = true;
                this.f10818a.f10821A.setParameter(2601, 1, 0, 0, 0);
                if (this.f10820c != null) {
                    this.f10820c.onRemoveCacheFinish(z2);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C3227i;
        }
    }

    public MapCore m14544a() {
        return this.f10821A;
    }

    public int mo3801b() {
        return this.f10860n;
    }

    public MapProjection mo3809c() {
        if (this.f10824D == null) {
            this.f10824D = this.f10821A.getMapstate();
        }
        return this.f10824D;
    }

    public void m14585a(GL10 gl10) {
        int i = 0;
        if (!this.aL) {
            int[] iArr = new int[500];
            gl10.glGenTextures(500, iArr, 0);
            while (i < iArr.length) {
                this.f10867u.add(Integer.valueOf(iArr[i]));
                i++;
            }
            this.aL = true;
        }
    }

    public AMapDelegateImp(ad adVar, Context context, AttributeSet attributeSet) {
        C3264r.f11367c = bm.m15687c(context);
        this.f10856j = adVar;
        this.f10856j.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10822B = context;
        this.f10821A = new MapCore(this.f10822B);
        this.f10823C = new C3228a(this);
        this.f10821A.setMapCallback(this.f10823C);
        ab();
        this.f10855i = new GLMapResManager(this, context);
        this.ae = new bh(this);
        this.ai = new C3255l(this);
        this.af = new bo(this);
        this.f10825E = new GestureDetector(context, new C3219d());
        this.f10825E.setOnDoubleTapListener(new C3218c());
        this.f10825E.setIsLongpressEnabled(true);
        this.f10826F = new ScaleGestureDetector(context, new C3225g());
        this.f10827G = new C3310d(context, new C3224f());
        this.aj = new C3300c(context, new C3214b());
        this.f10829I = new ay(this, context, this) {
            final /* synthetic */ AMapDelegateImp f10747a;

            protected void mo3673a() {
                super.mo3673a();
                this.f10747a.au.removeCallbacks(this.f10747a.bo);
                this.f10747a.au.post(this.f10747a.bn);
            }
        };
        this.f10854h = new C3347v(this);
        this.f10830J = new bq(this.f10822B, this);
        this.f10833M = new bi(this.f10822B, this);
        this.f10834N = new aq(this.f10822B);
        this.f10853g = new bn(this.f10822B, this);
        this.f10852f = new br(this.f10822B, this);
        this.f10831K = new ar(this.f10822B, this.f10851e, this);
        this.f10832L = new C3262q(this.f10822B, this.f10851e, this);
        this.f10850d = new av(this.f10822B, attributeSet, this);
        this.f10830J.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10833M.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10829I.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10853g.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10852f.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10850d.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        this.f10831K.setBackgroundColor(Color.argb(255, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG, FitnessSleepType.HW_FITNESS_SLEEP_WRONG));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f10829I.addView((View) this.f10856j, 0, layoutParams);
        this.f10829I.addView(this.f10850d, new C3237a(layoutParams));
        this.f10829I.addView(this.f10830J, layoutParams);
        this.f10829I.addView(this.f10833M, layoutParams);
        this.f10829I.addView(this.f10853g, layoutParams);
        this.f10829I.addView(this.f10834N, new LayoutParams(-2, -2));
        this.f10834N.m14822a(new C3222e());
        this.f10829I.addView(this.f10852f, new C3237a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        this.f10829I.addView(this.f10831K, new C3237a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        try {
            if (!this.af.mo3965d()) {
                this.f10831K.setVisibility(8);
            }
        } catch (Throwable e) {
            ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "locationView gone");
            e.printStackTrace();
        }
        this.f10829I.addView(this.f10832L, new C3237a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 51));
        this.f10832L.setVisibility(8);
        this.al = new C3257n(context);
        this.ak = new ba(this, context);
        this.aa = new C32097(this);
        this.f10846Z = this.aa;
        adVar.setRenderer(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        this.ay = new TimeChangedReceiver(this);
        this.f10822B.registerReceiver(this.ay, intentFilter);
        this.f10852f.setId(AutoTestConfig.ZoomControllerViewId);
        this.f10833M.setId(AutoTestConfig.ScaleControlsViewId);
        this.f10831K.setId(AutoTestConfig.MyLocationViewId);
        this.f10832L.setId(AutoTestConfig.CompassViewId);
    }

    public void mo3779a(C3268u c3268u) {
        this.aN.m15371a(c3268u);
    }

    public void mo3791a(AMap$OnMyLocationChangeListener aMap$OnMyLocationChangeListener) {
        this.f10835O = aMap$OnMyLocationChangeListener;
    }

    public void mo3811d() {
        bf.m15627a(bf.f11497a, hashCode() + " onResume ", 111);
        ad();
        if (this.f10823C != null) {
            this.f10823C.onResume(this.f10821A);
            mo3816e(false);
        }
        if (this.f10853g != null) {
            this.f10853g.m15223e();
        }
        if (this.ak != null) {
            this.ak.m14957b();
        }
        this.aO = false;
    }

    public void mo3814e() {
        bf.m15627a(bf.f11497a, hashCode() + " onPause ", 111);
        this.aO = true;
        ae();
        if (this.f10823C != null) {
            this.f10823C.onPause();
        }
        if (this.f10853g != null) {
            this.f10853g.m15222d();
        }
        if (this.ak != null) {
            this.ak.m14952a();
        }
        VMapDataCache.getInstance().reset();
    }

    private void ab() {
        if (!this.aB) {
            this.f10821A.newMap();
            this.f10824D = this.f10821A.getMapstate();
            this.f10824D.setGeoCenter(this.f10864r, this.f10865s);
            this.f10824D.setMapAngle(this.f10849c);
            this.f10824D.setMapZoomer(this.f10847a);
            this.f10824D.setCameraHeaderAngle(this.f10848b);
            ac();
            this.aB = true;
        }
    }

    private void ac() {
        try {
            mo3826j(false);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void mo3797a(MyLocationStyle myLocationStyle) {
        if (this.ak != null) {
            this.ak.m14956a(myLocationStyle);
        }
    }

    public void mo3768a(int i) {
        if (this.ak != null) {
            this.ak.m14954a(i);
        }
    }

    public void mo3766a(float f) throws RemoteException {
        if (this.ak != null) {
            this.ak.m14953a(f);
        }
    }

    public void mo3774a(Location location) throws RemoteException {
        if (location != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            try {
                if (!this.aA || this.ag == null) {
                    this.ak.m14958c();
                    this.ak = null;
                    return;
                }
                if (this.ak == null || this.ar == null) {
                    if (this.ak == null) {
                        this.ak = new ba(this, this.f10822B);
                    }
                    mo3776a(C3259o.m15330a(latLng, this.f10824D.getMapZoomer()));
                }
                this.ak.m14955a(location);
                if (!(this.f10835O == null || (this.ar != null && this.ar.getBearing() == location.getBearing() && this.ar.getAccuracy() == location.getAccuracy() && this.ar.getLatitude() == location.getLatitude() && this.ar.getLongitude() == location.getLongitude()))) {
                    this.f10835O.onMyLocationChange(location);
                }
                this.ar = new Location(location);
                mo3816e(false);
            } catch (Throwable e) {
                ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "showMyLocationOverlay");
                e.printStackTrace();
            }
        }
    }

    public void mo3798a(boolean z) {
        if (this.f10852f != null) {
            if (z) {
                this.f10852f.setVisibility(0);
            } else {
                this.f10852f.setVisibility(8);
            }
        }
    }

    public void mo3817f() {
        bf.m15627a(bf.f11497a, hashCode() + " destroy ", 111);
        this.aI = Boolean.valueOf(true);
        try {
            ae();
            if (this.f10863q != null) {
                this.f10863q.recycle();
                this.f10863q = null;
            }
            if (this.f10862p != null) {
                this.f10862p.recycle();
                this.f10862p = null;
            }
            if (!(this.f10858l == null || this.f10857k == null)) {
                this.f10858l.removeCallbacks(this.f10857k);
                this.f10857k = null;
            }
            if (this.aR != null) {
                this.aR.removeCallbacks(this.aS);
            }
            if (this.ay != null) {
                this.f10822B.unregisterReceiver(this.ay);
            }
            if (this.f10852f != null) {
                this.f10852f.m15263a();
            }
            if (this.f10833M != null) {
                this.f10833M.m15079a();
            }
            if (this.f10830J != null) {
                this.f10830J.m15251a();
            }
            if (this.f10831K != null) {
                this.f10831K.m14827a();
            }
            if (this.f10832L != null) {
                this.f10832L.m15368a();
            }
            if (this.f10853g != null) {
                this.f10853g.m15218b();
                this.f10853g.m15224f();
            }
            if (this.f10854h != null) {
                this.f10854h.m16338a();
            }
            if (this.f10850d != null) {
                this.f10850d.m14872e();
            }
            if (this.f10834N != null) {
                this.f10834N.m14825b();
            }
            if (this.bf != null) {
                this.bf.interrupt();
                this.bf = null;
            }
            if (this.f10823C != null) {
                this.f10823C.OnMapDestory(this.f10821A);
                this.f10821A.setMapCallback(null);
                this.f10823C = null;
            }
            mo3739D();
            bk.m15662a(this.aq);
            if (this.f10867u != null) {
                this.f10867u.clear();
            }
            if (this.f10868v != null) {
                this.f10868v.clear();
            }
            if (this.f10821A != null) {
                m14584a(new C32119(this));
                Thread.sleep(200);
            }
            if (this.f10829I != null) {
                this.f10829I.removeAllViews();
                this.f10829I = null;
            }
            ca.m15833c();
            bf.m15627a(MapTilsCacheAndResManager.AUTONAVI_PATH, "完全释放", 113);
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "destroy");
            bf.m15627a(MapTilsCacheAndResManager.AUTONAVI_PATH, "没有完全释放" + th.getMessage(), 111);
            th.printStackTrace();
        }
    }

    public void mo3807b(boolean z) {
        if (this.f10831K != null) {
            if (z) {
                this.f10831K.setVisibility(0);
            } else {
                this.f10831K.setVisibility(8);
            }
        }
    }

    public void mo3810c(boolean z) {
        if (this.f10832L != null) {
            if (z) {
                this.f10832L.setVisibility(0);
                this.f10832L.m15369b();
                return;
            }
            this.f10832L.setVisibility(8);
        }
    }

    void m14611g() {
        this.f10858l.obtainMessage(14).sendToTarget();
    }

    public void mo3813d(boolean z) {
        if (this.f10833M != null) {
            if (z) {
                this.f10833M.setVisibility(0);
                m14614h();
                return;
            }
            this.f10833M.m15081a("");
            this.f10833M.m15080a(0);
            this.f10833M.setVisibility(8);
        }
    }

    void m14614h() {
        this.f10858l.sendEmptyMessage(15);
    }

    void m14617i() {
        if (this.f10833M != null) {
            try {
                LatLng latLng = mo3834q().target;
                float f = this.f10847a;
                if (this.aB) {
                    f = this.f10824D.getMapZoomer();
                }
                double d = (double) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                int cos = (int) (d * (((double) this.f10866t[(int) f]) / ((double) ((float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) f)))))));
                String b = bk.m15672b(this.f10866t[(int) f]);
                this.f10833M.m15080a(cos);
                this.f10833M.m15081a(b);
                this.f10833M.invalidate();
            } catch (Throwable th) {
                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }

    public boolean mo3800a(String str) throws RemoteException {
        mo3816e(false);
        return this.f10854h.m16345c(str);
    }

    public synchronized void mo3816e(boolean z) {
        if (!z) {
            this.aQ = false;
            this.aR.removeCallbacks(this.aS);
            this.aP = false;
        } else if (!(this.aP || this.aQ)) {
            this.aQ = true;
            this.aR.postDelayed(this.aS, 6000);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        if (!this.aI.booleanValue() && !this.aO) {
            try {
                if (this.bp) {
                    this.bp = false;
                    m14474c(gl10);
                }
                gl10.glColor4f(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.5f);
                gl10.glClear(16640);
                this.f10821A.setGL(gl10);
                this.f10821A.drawFrame(gl10);
                m14585a(gl10);
                this.f10853g.m15216a(gl10);
                this.f10854h.m16341a(gl10, false, this.ap);
                this.f10850d.m14863a(gl10);
                this.aN.m15370a(gl10);
                if (this.ad != null) {
                    this.ad.m14262a(gl10);
                }
                if (this.aJ) {
                    this.f10858l.obtainMessage(16, m14447a(0, 0, m14625m(), m14627n(), gl10)).sendToTarget();
                    this.aJ = false;
                }
                if (!this.al.m15311a()) {
                    this.f10858l.sendEmptyMessage(13);
                }
                if (!this.aC) {
                    this.f10858l.sendEmptyMessage(11);
                    this.aC = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public Rect mo3825j() {
        return this.ah;
    }

    public int mo3827k() {
        return this.ah.width();
    }

    public int mo3829l() {
        return this.ah.height();
    }

    public int m14625m() {
        return this.f10856j.getWidth();
    }

    public int m14627n() {
        return this.f10856j.getHeight();
    }

    public void mo3770a(int i, int i2, int i3, int i4) {
        if (this.aB) {
            this.f10821A.setParameter(2201, 1, 1, 1, 1);
            this.f10821A.setParameter(2202, i, i2, i3, i4);
        }
    }

    private synchronized void ad() {
        if (this.ax != null) {
            ae();
        }
        if (this.ax == null) {
            this.ax = new Timer();
        }
        this.ax.schedule(new C3226h(this, this), 0, 25);
    }

    private synchronized void ae() {
        if (this.ax != null) {
            this.ax.cancel();
            this.ax = null;
        }
    }

    private synchronized void af() {
        try {
            if (!this.aT) {
                this.f10855i.setStyleData();
                this.f10855i.setIconsData(true);
                this.f10855i.setTrafficTexture(true);
                this.f10855i.setOtherMapTexture(true);
                this.f10855i.setRoadGuideTexture(true);
                this.f10855i.setBkTexture(true);
                this.aT = true;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "setInternaltexture");
            bf.m15627a("amapv3.2", "mapInitError", 112);
            th.printStackTrace();
        }
    }

    public int mo3832o() {
        return this.f10861o;
    }

    public void mo3833p() {
        try {
            if (this.aK && this.ab != null && this.ac != null) {
                C3237a c3237a = (C3237a) this.ab.getLayoutParams();
                if (c3237a != null) {
                    Rect d = this.ac.mo3702d();
                    if (d != null && d.height() != 0 && d.width() != 0) {
                        int D = this.ac.mo3677D() + this.ac.mo3675B();
                        int E = (this.ac.mo3678E() + this.ac.mo3676C()) + 2;
                        c3237a.f10950a = this.ac.mo3706f();
                        c3237a.f10951b = D;
                        c3237a.f10952c = E;
                        if (this.ad != null) {
                            this.ad.m14257a(this.ac.mo3706f());
                            this.ad.m14267b(D, E);
                        }
                    } else {
                        return;
                    }
                }
                this.f10829I.onLayout(false, 0, 0, 0, 0);
                mo3816e(false);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    public void mo3819f(boolean z) {
        this.f10856j.setZOrderOnTop(z);
    }

    public CameraPosition mo3834q() throws RemoteException {
        return mo3830l(this.bj);
    }

    public float mo3835r() {
        return 19.0f;
    }

    public float mo3836s() {
        return 3.0f;
    }

    public void mo3776a(C3259o c3259o) throws RemoteException {
        if (this.aO) {
            this.f10851e.m14852f();
        }
        if (c3259o.f11323a == C3258a.newLatLngBounds) {
            boolean z = m14625m() > 0 && m14627n() > 0;
            au.m15521a(z, (Object) "the map must have a size");
        }
        mo3837t();
        c3259o.f11338p = true;
        c3259o.f11336n = this.bj;
        this.f10851e.m14847a(c3259o);
    }

    public void mo3806b(C3259o c3259o) throws RemoteException {
        mo3778a(c3259o, null);
    }

    public void mo3778a(C3259o c3259o, AMap$CancelableCallback aMap$CancelableCallback) throws RemoteException {
        mo3777a(c3259o, 250, aMap$CancelableCallback);
    }

    public void mo3777a(C3259o c3259o, long j, AMap$CancelableCallback aMap$CancelableCallback) throws RemoteException {
        if (c3259o.f11323a == C3258a.newLatLngBounds) {
            boolean z = m14625m() > 0 && m14627n() > 0;
            au.m15521a(z, (Object) "the map must have a size");
        }
        if (!this.al.m15311a()) {
            this.al.m15310a(true);
            if (this.ao != null) {
                this.ao.onCancel();
            }
        }
        this.al.m15313b(this.bj);
        this.ao = aMap$CancelableCallback;
        if (this.aG) {
            this.aH = true;
        }
        this.aF = false;
        IPoint iPoint;
        if (c3259o.f11323a == C3258a.scrollBy) {
            if (c3259o.f11324b == 0.0f && c3259o.f11325c == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            this.al.m15313b(false);
            iPoint = new IPoint();
            this.f10824D.getGeoCenter(iPoint);
            IPoint iPoint2 = new IPoint();
            mo3773a((m14625m() / 2) + ((int) c3259o.f11324b), (m14627n() / 2) + ((int) c3259o.f11325c), iPoint2);
            this.al.m15309a(new AccelerateDecelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, this.f10824D.getMapZoomer(), this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), iPoint2.f13273x - iPoint.f13273x, iPoint2.f13274y - iPoint.f13274y, 0.0f, 0.0f, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.zoomIn) {
            r6 = this.f10824D.getMapZoomer();
            r11 = bk.m15640a(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT + r6) - r6;
            if (r11 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, r6, this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.zoomOut) {
            r6 = this.f10824D.getMapZoomer();
            r11 = bk.m15640a(r6 - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) - r6;
            if (r11 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, r6, this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.zoomTo) {
            r6 = this.f10824D.getMapZoomer();
            r11 = bk.m15640a(c3259o.f11326d) - r6;
            if (r11 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, r6, this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), 0, 0, r11, 0.0f, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.zoomBy) {
            this.al.m15313b(false);
            float f = c3259o.f11327e;
            r6 = this.f10824D.getMapZoomer();
            r11 = bk.m15640a(r6 + f) - r6;
            if (r11 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            Point point = c3259o.f11335m;
            IPoint iPoint3 = new IPoint();
            this.f10824D.getGeoCenter(iPoint3);
            r9 = 0;
            r10 = 0;
            IPoint iPoint4 = new IPoint();
            int i;
            if (point != null) {
                mo3773a(point.x, point.y, iPoint4);
                r3 = iPoint3.f13273x - iPoint4.f13273x;
                i = iPoint3.f13274y - iPoint4.f13274y;
                r9 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r10 = (int) ((((double) i) / Math.pow(2.0d, (double) f)) - ((double) i));
            } else if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint4);
                r3 = iPoint3.f13273x - iPoint4.f13273x;
                i = iPoint3.f13274y - iPoint4.f13274y;
                r9 = (int) ((((double) r3) / Math.pow(2.0d, (double) f)) - ((double) r3));
                r10 = (int) ((((double) i) / Math.pow(2.0d, (double) f)) - ((double) i));
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint3.f13273x, iPoint3.f13274y, r6, this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), r9, r10, r11, 0.0f, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.newCameraPosition) {
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            r3 = new IPoint();
            CameraPosition cameraPosition = c3259o.f11330h;
            MapProjection.lonlat2Geo(cameraPosition.target.longitude, cameraPosition.target.latitude, r3);
            r6 = this.f10824D.getMapZoomer();
            r9 = r3.f13273x - iPoint.f13273x;
            r10 = r3.f13274y - iPoint.f13274y;
            r11 = bk.m15640a(cameraPosition.zoom) - r6;
            r7 = this.f10824D.getMapAngle();
            r12 = (cameraPosition.bearing % 360.0f) - (r7 % 360.0f);
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            r8 = this.f10824D.getCameraHeaderAngle();
            r13 = bk.m15641a(cameraPosition.tilt, r6) - r8;
            if (r9 == 0 && r10 == 0 && r11 == 0.0f && r12 == 0.0f && r13 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.al.m15309a(new AccelerateInterpolator());
                this.al.m15307a(iPoint.f13273x, iPoint.f13274y, r6, r7, r8, r9, r10, r11, r12, r13, j);
            }
        } else if (c3259o.f11323a == C3258a.changeBearing) {
            r7 = this.f10824D.getMapAngle();
            r12 = (c3259o.f11329g % 360.0f) - (r7 % 360.0f);
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            if (r12 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, this.f10824D.getMapZoomer(), r7, this.f10824D.getCameraHeaderAngle(), 0, 0, 0.0f, r12, 0.0f, j);
        } else if (c3259o.f11323a == C3258a.changeTilt) {
            r8 = this.f10824D.getCameraHeaderAngle();
            r13 = c3259o.f11328f - r8;
            if (r13 == 0.0f) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            this.al.m15309a(new AccelerateInterpolator());
            this.al.m15307a(iPoint.f13273x, iPoint.f13274y, this.f10824D.getMapZoomer(), this.f10824D.getMapAngle(), r8, 0, 0, 0.0f, 0.0f, r13, j);
        } else if (c3259o.f11323a == C3258a.changeCenter) {
            iPoint = new IPoint();
            if (this.bj) {
                mo3773a(this.bk, this.bl, iPoint);
            } else {
                this.f10824D.getGeoCenter(iPoint);
            }
            r9 = c3259o.f11337o.f13273x - iPoint.f13273x;
            r10 = c3259o.f11337o.f13274y - iPoint.f13274y;
            if (r9 == 0 && r10 == 0) {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            } else {
                this.al.m15309a(new AccelerateDecelerateInterpolator());
                this.al.m15307a(iPoint.f13273x, iPoint.f13274y, this.f10824D.getMapZoomer(), this.f10824D.getMapAngle(), this.f10824D.getCameraHeaderAngle(), r9, r10, 0.0f, 0.0f, 0.0f, j);
            }
        } else if (c3259o.f11323a == C3258a.newLatLngBounds || c3259o.f11323a == C3258a.newLatLngBoundsWithSize) {
            int i2;
            this.al.m15313b(false);
            if (c3259o.f11323a == C3258a.newLatLngBounds) {
                r3 = m14625m();
                r9 = m14627n();
                i2 = r3;
            } else {
                r3 = c3259o.f11333k;
                r9 = c3259o.f11334l;
                i2 = r3;
            }
            float mapAngle = this.f10824D.getMapAngle() % 360.0f;
            float cameraHeaderAngle = this.f10824D.getCameraHeaderAngle();
            r12 = -mapAngle;
            if (Math.abs(r12) >= BitmapDescriptorFactory.HUE_CYAN) {
                r12 -= Math.signum(r12) * 360.0f;
            }
            r13 = -cameraHeaderAngle;
            LatLngBounds latLngBounds = c3259o.f11331i;
            int i3 = c3259o.f11332j;
            IPoint iPoint5 = new IPoint();
            this.f10824D.getGeoCenter(iPoint5);
            float mapZoomer = this.f10824D.getMapZoomer();
            this.al.m15309a(new AccelerateInterpolator());
            iPoint = new IPoint();
            r3 = new IPoint();
            MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
            MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, r3);
            r10 = iPoint.f13273x - r3.f13273x;
            int i4 = r3.f13274y - iPoint.f13274y;
            if (r10 > 0 || i4 > 0) {
                int i5 = (iPoint.f13273x + r3.f13273x) / 2;
                int i6 = (iPoint.f13274y + r3.f13274y) / 2;
                IPoint iPoint6 = new IPoint();
                mo3802b((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) / 2.0d, (latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) / 2.0d, iPoint6);
                int i7;
                if ((!this.ah.contains(iPoint6.f13273x, iPoint6.f13274y) ? 1 : null) == null) {
                    r3 = i2 - (i3 * 2);
                    i7 = r9 - (i3 * 2);
                    if (r3 <= 0) {
                        r3 = 1;
                    }
                    if (i7 <= 0) {
                        i7 = 1;
                    }
                    r11 = bk.m15640a((float) ((int) (Math.min(Math.log(((double) this.f10824D.getMapLenWithWin(r3)) / ((double) this.f10824D.getMapLenWithGeo(r10))) / Math.log(2.0d), Math.log(((double) this.f10824D.getMapLenWithWin(i7)) / ((double) this.f10824D.getMapLenWithGeo(i4))) / Math.log(2.0d)) + ((double) mapZoomer)))) - mapZoomer;
                    r9 = i5 - iPoint5.f13273x;
                    r10 = i6 - iPoint5.f13274y;
                    if (r9 == 0 && r10 == 0 && r11 == 0.0f) {
                        this.f10858l.obtainMessage(17).sendToTarget();
                        return;
                    } else {
                        this.al.m15309a(new DecelerateInterpolator());
                        this.al.m15307a(iPoint5.f13273x, iPoint5.f13274y, mapZoomer, mapAngle, cameraHeaderAngle, r9, r10, r11, r12, r13, j);
                    }
                } else {
                    final AMap$CancelableCallback aMap$CancelableCallback2 = this.ao;
                    final LatLngBounds latLngBounds2 = latLngBounds;
                    final int i8 = i2;
                    final int i9 = r9;
                    final int i10 = i3;
                    final long j2 = j;
                    this.ao = new AMap$CancelableCallback(this) {
                        final /* synthetic */ AMapDelegateImp f10733g;

                        public void onFinish() {
                            try {
                                this.f10733g.mo3777a(C3259o.m15333a(latLngBounds2, i8, i9, i10), j2, aMap$CancelableCallback2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        public void onCancel() {
                            if (aMap$CancelableCallback2 != null) {
                                aMap$CancelableCallback2.onCancel();
                            }
                        }
                    };
                    i4 = ((iPoint5.f13273x + i5) / 2) - iPoint5.f13273x;
                    r10 = ((iPoint5.f13274y + i6) / 2) - iPoint5.f13274y;
                    i7 = (int) bk.m15639a((double) (((float) mo3827k()) / 2.0f), (double) (((float) mo3829l()) / 2.0f), (double) Math.abs(i5 - iPoint5.f13273x), (double) Math.abs(i6 - iPoint5.f13274y));
                    r11 = i7 == 0 ? 0.0f : ((float) i7) - mapZoomer;
                    if (r11 >= 0.0f) {
                        r11 = 0.0f;
                    }
                    this.aF = true;
                    this.al.m15307a(iPoint5.f13273x, iPoint5.f13274y, mapZoomer, mapAngle, cameraHeaderAngle, i4, r10, r11, r12 / 2.0f, r13 / 2.0f, j / 2);
                }
            } else {
                this.f10858l.obtainMessage(17).sendToTarget();
                return;
            }
        } else {
            c3259o.f11338p = true;
            this.f10851e.m14847a(c3259o);
        }
        mo3816e(false);
    }

    public void mo3837t() throws RemoteException {
        if (!this.al.m15311a()) {
            this.al.m15310a(true);
            m14587a(true, null);
            if (this.ao != null) {
                this.ao.onCancel();
            }
            if (!(this.ab == null || this.ad == null)) {
                this.ab.setVisibility(0);
            }
            this.ao = null;
        }
        mo3816e(false);
    }

    public ak mo3758a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        ai bfVar = new bf(this.f10854h);
        bfVar.mo3904a(polylineOptions.getColor());
        bfVar.mo3907b(polylineOptions.isGeodesic());
        bfVar.mo3910c(polylineOptions.isDottedLine());
        bfVar.mo3905a(polylineOptions.getPoints());
        bfVar.mo3877a(polylineOptions.isVisible());
        bfVar.mo3906b(polylineOptions.getWidth());
        bfVar.mo3873a(polylineOptions.getZIndex());
        bfVar.m15059d(polylineOptions.isUseTexture());
        if (polylineOptions.getColorValues() != null) {
            bfVar.m15060e(polylineOptions.getColorValues());
            bfVar.m15061e(polylineOptions.isUseGradient());
        }
        if (polylineOptions.getCustomTexture() != null) {
            bfVar.m15040a(polylineOptions.getCustomTexture());
        }
        if (polylineOptions.getCustomTextureList() != null) {
            bfVar.m15055c(polylineOptions.getCustomTextureList());
            bfVar.m15058d(polylineOptions.getCustomTextureIndex());
        }
        this.f10854h.m16339a(bfVar);
        mo3816e(false);
        return bfVar;
    }

    public ah mo3756a(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        ai bbVar = new bb(this);
        bbVar.mo3874a(navigateArrowOptions.getTopColor());
        bbVar.mo3875a(navigateArrowOptions.getPoints());
        bbVar.mo3877a(navigateArrowOptions.isVisible());
        bbVar.mo3881b(navigateArrowOptions.getWidth());
        bbVar.mo3873a(navigateArrowOptions.getZIndex());
        this.f10854h.m16339a(bbVar);
        mo3816e(false);
        return bbVar;
    }

    public aj mo3757a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        ai beVar = new be(this);
        beVar.mo3894a(polygonOptions.getFillColor());
        beVar.mo3895a(polygonOptions.getPoints());
        beVar.mo3877a(polygonOptions.isVisible());
        beVar.mo3897b(polygonOptions.getStrokeWidth());
        beVar.mo3873a(polygonOptions.getZIndex());
        beVar.mo3898b(polygonOptions.getStrokeColor());
        this.f10854h.m16339a(beVar);
        mo3816e(false);
        return beVar;
    }

    public ac mo3754a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        ai c3260p = new C3260p(this);
        c3260p.mo3989b(circleOptions.getFillColor());
        c3260p.mo3987a(circleOptions.getCenter());
        c3260p.mo3877a(circleOptions.isVisible());
        c3260p.mo3988b(circleOptions.getStrokeWidth());
        c3260p.mo3873a(circleOptions.getZIndex());
        c3260p.mo3986a(circleOptions.getStrokeColor());
        c3260p.mo3985a(circleOptions.getRadius());
        this.f10854h.m16339a(c3260p);
        mo3816e(false);
        return c3260p;
    }

    public ab mo3753a(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        ai c3256m = new C3256m(this);
        c3256m.mo3981a(arcOptions.getStrokeColor());
        c3256m.m15284a(arcOptions.getStart());
        c3256m.m15291b(arcOptions.getPassed());
        c3256m.m15293c(arcOptions.getEnd());
        c3256m.mo3877a(arcOptions.isVisible());
        c3256m.mo3982b(arcOptions.getStrokeWidth());
        c3256m.mo3873a(arcOptions.getZIndex());
        this.f10854h.m16339a(c3256m);
        mo3816e(false);
        return c3256m;
    }

    public ae mo3755a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        ai c3363z = new C3363z(this);
        c3363z.m16413b(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        c3363z.mo4074a(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        c3363z.mo4075a(groundOverlayOptions.getImage());
        c3363z.mo4076a(groundOverlayOptions.getLocation());
        c3363z.mo4077a(groundOverlayOptions.getBounds());
        c3363z.mo4079c(groundOverlayOptions.getBearing());
        c3363z.mo4080d(groundOverlayOptions.getTransparency());
        c3363z.mo3877a(groundOverlayOptions.isVisible());
        c3363z.mo3873a(groundOverlayOptions.getZIndex());
        this.f10854h.m16339a(c3363z);
        mo3816e(false);
        return c3363z;
    }

    public Marker mo3760a(MarkerOptions markerOptions) throws RemoteException {
        if (markerOptions == null) {
            return null;
        }
        ag azVar = new az(markerOptions, this.f10850d);
        this.f10850d.m14859a(azVar);
        mo3816e(false);
        return new Marker(azVar);
    }

    public Text mo3761a(TextOptions textOptions) throws RemoteException {
        if (textOptions == null) {
            return null;
        }
        ag bkVar = new bk(textOptions, this.f10850d);
        this.f10850d.m14859a(bkVar);
        mo3816e(false);
        return new Text(bkVar);
    }

    public ArrayList<Marker> mo3763a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        int i = 0;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList();
        try {
            MarkerOptions markerOptions;
            if (arrayList.size() == 1) {
                markerOptions = (MarkerOptions) arrayList.get(0);
                if (markerOptions != null) {
                    arrayList2.add(mo3760a(markerOptions));
                    if (z && markerOptions.getPosition() != null) {
                        mo3776a(C3259o.m15330a(markerOptions.getPosition(), 18.0f));
                    }
                    return arrayList2;
                }
            }
            final Builder builder = LatLngBounds.builder();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                int i3;
                markerOptions = (MarkerOptions) arrayList.get(i2);
                if (arrayList.get(i2) != null) {
                    arrayList2.add(mo3760a(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                        i3 = i + 1;
                        i2++;
                        i = i3;
                    }
                }
                i3 = i;
                i2++;
                i = i3;
            }
            if (z && i > 0) {
                if (this.aC) {
                    this.f10858l.postDelayed(new Runnable(this) {
                        final /* synthetic */ AMapDelegateImp f10735b;

                        public void run() {
                            try {
                                this.f10735b.mo3776a(C3259o.m15332a(builder.build(), 50));
                            } catch (Throwable th) {
                            }
                        }
                    }, 50);
                } else {
                    this.aw = C3259o.m15332a(builder.build(), 50);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public TileOverlay mo3762a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        ao bmVar = new bm(tileOverlayOptions, this.f10853g);
        this.f10853g.m15215a(bmVar);
        mo3816e(false);
        return new TileOverlay(bmVar);
    }

    public void mo3838u() throws RemoteException {
        try {
            mo3821g(false);
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + th.getMessage());
            th.printStackTrace();
        }
    }

    public void mo3821g(boolean z) throws RemoteException {
        String str = null;
        try {
            String d;
            mo3739D();
            if (this.ak != null) {
                if (z) {
                    d = this.ak.m14959d();
                    str = this.ak.m14960e();
                    this.f10854h.m16343b(str);
                    this.f10853g.m15218b();
                    this.f10850d.m14862a(d);
                    mo3816e(false);
                }
                this.ak.m14961f();
            }
            d = null;
            this.f10854h.m16343b(str);
            this.f10853g.m15218b();
            this.f10850d.m14862a(d);
            mo3816e(false);
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "clear");
            Log.d("amapApi", "AMapDelegateImpGLSurfaceView clear erro" + th.getMessage());
            th.printStackTrace();
        }
    }

    public int mo3839v() throws RemoteException {
        return this.f10872z;
    }

    public void mo3803b(int i) throws RemoteException {
        if (i == 1) {
            try {
                m14582a(MapViewMode.NORAML, MapViewTime.DAY);
            } catch (Throwable th) {
                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "setMaptype");
                th.printStackTrace();
                return;
            }
        } else if (i == 2) {
            m14582a(MapViewMode.SATELLITE, MapViewTime.DAY);
        } else if (i == 3) {
            m14583a(MapViewMode.NORAML, MapViewTime.NIGHT, MapViewModeState.NAVI_CAR);
        } else if (i == 4) {
            m14583a(MapViewMode.NORAML, MapViewTime.DAY, MapViewModeState.NAVI_CAR);
        }
        mo3816e(false);
    }

    public void m14582a(MapViewMode mapViewMode, MapViewTime mapViewTime) {
        m14583a(mapViewMode, mapViewTime, MapViewModeState.NORMAL);
    }

    public void m14583a(MapViewMode mapViewMode, MapViewTime mapViewTime, MapViewModeState mapViewModeState) {
        if (this.f10869w != mapViewTime || this.f10870x != mapViewMode || this.f10871y != mapViewModeState) {
            if (this.aD) {
                final MapViewTime mapViewTime2 = this.f10869w;
                final MapViewMode mapViewMode2 = this.f10870x;
                MapViewModeState mapViewModeState2 = this.f10871y;
                if (this.aT && this.aB) {
                    final MapViewTime mapViewTime3 = mapViewTime;
                    final MapViewMode mapViewMode3 = mapViewMode;
                    final MapViewModeState mapViewModeState3 = mapViewModeState;
                    m14584a(new Runnable(this) {
                        final /* synthetic */ AMapDelegateImp f10742f;

                        class C32021 implements Runnable {
                            final /* synthetic */ AnonymousClass12 f10736a;

                            C32021(AnonymousClass12 anonymousClass12) {
                                this.f10736a = anonymousClass12;
                            }

                            public void run() {
                                this.f10736a.f10742f.ai();
                            }
                        }

                        public void run() {
                            String styleName = this.f10742f.f10855i.getStyleName();
                            String iconName = this.f10742f.f10855i.getIconName();
                            this.f10742f.f10869w = mapViewTime3;
                            this.f10742f.f10870x = mapViewMode3;
                            this.f10742f.f10871y = mapViewModeState3;
                            String styleName2 = this.f10742f.f10855i.getStyleName();
                            String iconName2 = this.f10742f.f10855i.getIconName();
                            if (this.f10742f.f10870x == MapViewMode.SATELLITE || this.f10742f.f10869w == MapViewTime.NIGHT || mapViewTime2 == MapViewTime.NIGHT || mapViewMode2 == MapViewMode.SATELLITE) {
                                this.f10742f.f10858l.post(new C32021(this));
                            }
                            this.f10742f.f10821A.setParameter(2501, 0, 0, 0, 0);
                            if (!styleName.equals(styleName2)) {
                                this.f10742f.f10855i.setStyleData();
                            }
                            if (this.f10742f.f10870x == MapViewMode.SATELLITE || mapViewMode2 == MapViewMode.SATELLITE) {
                                this.f10742f.f10821A.setParameter(TradeCode.ALIPAY_ONE_KEY_SIGN, this.f10742f.f10870x == MapViewMode.SATELLITE ? 1 : 0, 0, 0, 0);
                            }
                            if (this.f10742f.f10869w == MapViewTime.NIGHT || mapViewTime2 == MapViewTime.NIGHT) {
                                int i;
                                MapCore d = this.f10742f.f10821A;
                                if (this.f10742f.f10869w == MapViewTime.NIGHT) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                d.setParameter(2401, i, 0, 0, 0);
                                this.f10742f.f10855i.setRoadGuideTexture(true);
                                this.f10742f.f10855i.setBkTexture(true);
                            }
                            if (!iconName.equals(iconName2)) {
                                this.f10742f.f10855i.setIconsData(true);
                            }
                            this.f10742f.f10855i.setTrafficTexture(true);
                            if (this.f10742f.f10871y != null) {
                                this.f10742f.f10821A.setParameter(2013, this.f10742f.f10870x.ordinal(), this.f10742f.f10869w.ordinal(), this.f10742f.f10871y.ordinal(), 0);
                            }
                            this.f10742f.f10821A.setParameter(2501, 1, 1, 0, 0);
                        }
                    });
                    return;
                }
                this.bq.f10779d = mapViewMode;
                this.bq.f10780e = mapViewTime;
                this.bq.f10777b = true;
                return;
            }
            this.f10869w = mapViewTime;
            this.f10870x = mapViewMode;
            this.f10871y = mapViewModeState;
        }
    }

    public boolean mo3840w() throws RemoteException {
        return this.aU;
    }

    public void mo3823h(boolean z) throws RemoteException {
        this.aU = z;
        this.f10851e.m14846a(new at(2).m14843a(z));
    }

    public void mo3824i(final boolean z) throws RemoteException {
        m14584a(new Runnable(this) {
            final /* synthetic */ AMapDelegateImp f10744b;

            public void run() {
                if (this.f10744b.f10821A != null) {
                    int i;
                    MapCore d = this.f10744b.f10821A;
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    d.setParameter(1024, i, 0, 0, 0);
                }
            }
        });
    }

    public void mo3826j(boolean z) throws RemoteException {
        if (z) {
            this.f10821A.setParameter(Constant.CALLBACK_GET_APP_STATUS, 1, 0, 0, 0);
            return;
        }
        this.f10821A.setParameter(Constant.CALLBACK_GET_APP_STATUS, 0, 0, 0, 0);
        this.f10858l.post(new Runnable(this) {
            final /* synthetic */ AMapDelegateImp f10745a;

            {
                this.f10745a = r1;
            }

            public void run() {
                this.f10745a.f10834N.setVisibility(8);
            }
        });
    }

    public boolean mo3841x() throws RemoteException {
        return this.aA;
    }

    public void mo3828k(boolean z) throws RemoteException {
        try {
            if (this.ag == null) {
                this.f10831K.m14828a(false);
            } else if (z) {
                this.ag.activate(this.ai);
                this.f10831K.m14828a(true);
                if (this.ak == null) {
                    this.ak = new ba(this, this.f10822B);
                }
            } else {
                if (this.ak != null) {
                    this.ak.m14958c();
                    this.ak = null;
                }
                this.ar = null;
                this.ag.deactivate();
            }
            if (!z) {
                this.af.mo3964d(z);
            }
            this.aA = z;
            mo3816e(false);
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
            th.printStackTrace();
        }
    }

    public Location mo3842y() throws RemoteException {
        if (this.ag != null) {
            return this.ai.f11242a;
        }
        return null;
    }

    public void mo3796a(LocationSource locationSource) throws RemoteException {
        try {
            this.ag = locationSource;
            if (locationSource != null) {
                this.f10831K.m14828a(true);
            } else {
                this.f10831K.m14828a(false);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "setLocationSource");
            th.printStackTrace();
        }
    }

    public ap mo3843z() throws RemoteException {
        return this.af;
    }

    public al mo3737A() throws RemoteException {
        return this.ae;
    }

    public void mo3782a(AMap$OnCameraChangeListener aMap$OnCameraChangeListener) throws RemoteException {
        this.f10840T = aMap$OnCameraChangeListener;
    }

    void m14580a(CameraPosition cameraPosition) {
        Message message = new Message();
        message.what = 10;
        message.obj = cameraPosition;
        this.f10858l.sendMessage(message);
    }

    public AMap$OnCameraChangeListener m14509B() throws RemoteException {
        return this.f10840T;
    }

    public void mo3784a(AMap$OnMapClickListener aMap$OnMapClickListener) throws RemoteException {
        this.f10841U = aMap$OnMapClickListener;
    }

    public void mo3788a(AMap$OnMapTouchListener aMap$OnMapTouchListener) throws RemoteException {
        this.f10842V = aMap$OnMapTouchListener;
    }

    public void mo3792a(AMap$OnPOIClickListener aMap$OnPOIClickListener) throws RemoteException {
        this.f10843W = aMap$OnPOIClickListener;
    }

    public void mo3786a(AMap$OnMapLongClickListener aMap$OnMapLongClickListener) throws RemoteException {
        this.f10844X = aMap$OnMapLongClickListener;
    }

    public void mo3789a(AMap$OnMarkerClickListener aMap$OnMarkerClickListener) throws RemoteException {
        this.f10836P = aMap$OnMarkerClickListener;
    }

    public void mo3793a(AMap$OnPolylineClickListener aMap$OnPolylineClickListener) throws RemoteException {
        this.f10837Q = aMap$OnPolylineClickListener;
    }

    public void mo3790a(AMap$OnMarkerDragListener aMap$OnMarkerDragListener) throws RemoteException {
        this.f10838R = aMap$OnMarkerDragListener;
    }

    public void mo3785a(AMap$OnMapLoadedListener aMap$OnMapLoadedListener) throws RemoteException {
        this.f10839S = aMap$OnMapLoadedListener;
    }

    public void mo3783a(AMap$OnInfoWindowClickListener aMap$OnInfoWindowClickListener) throws RemoteException {
        this.f10845Y = aMap$OnInfoWindowClickListener;
    }

    public void mo3780a(AMap$InfoWindowAdapter aMap$InfoWindowAdapter) throws RemoteException {
        if (aMap$InfoWindowAdapter == null) {
            this.f10846Z = this.aa;
        } else {
            this.f10846Z = aMap$InfoWindowAdapter;
        }
    }

    public View mo3738C() throws RemoteException {
        return this.f10829I;
    }

    public float m14590b(float f) throws RemoteException {
        return bk.m15640a(f);
    }

    public float mo3808c(int i) {
        if (this.aB) {
            return this.f10824D.getMapLenWithWin(i);
        }
        return 0.0f;
    }

    public void mo3771a(int i, int i2, DPoint dPoint) {
        m14462a(this.f10824D, i, i2, dPoint);
    }

    private void m14462a(MapProjection mapProjection, int i, int i2, DPoint dPoint) {
        if (this.aB) {
            FPoint fPoint = new FPoint();
            mapProjection.win2Map(i, i2, fPoint);
            IPoint iPoint = new IPoint();
            mapProjection.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
            MapProjection.geo2LonLat(iPoint.f13273x, iPoint.f13274y, dPoint);
        }
    }

    public void mo3773a(int i, int i2, IPoint iPoint) {
        if (this.aB) {
            FPoint fPoint = new FPoint();
            this.f10824D.win2Map(i, i2, fPoint);
            this.f10824D.map2Geo(fPoint.f13252x, fPoint.f13253y, iPoint);
        }
    }

    public void m14596b(int i, int i2, IPoint iPoint) {
        if (this.aB) {
            FPoint fPoint = new FPoint();
            this.f10824D.geo2Map(i, i2, fPoint);
            this.f10824D.map2Win(fPoint.f13252x, fPoint.f13253y, iPoint);
        }
    }

    public void mo3764a(double d, double d2, FPoint fPoint) {
        if (this.aB) {
            IPoint iPoint = new IPoint();
            MapProjection.lonlat2Geo(d2, d, iPoint);
            this.f10824D.geo2Map(iPoint.f13273x, iPoint.f13274y, fPoint);
        }
    }

    public void mo3765a(double d, double d2, IPoint iPoint) {
        MapProjection.lonlat2Geo(d2, d, iPoint);
    }

    public void mo3772a(int i, int i2, FPoint fPoint) {
        if (this.aB) {
            this.f10824D.win2Map(i, i2, fPoint);
        }
    }

    public void mo3805b(int i, int i2, FPoint fPoint) {
        if (this.aB) {
            this.f10824D.geo2Map(i2, i, fPoint);
        }
    }

    public void mo3767a(float f, float f2, IPoint iPoint) {
        if (this.aB) {
            this.f10824D.map2Geo(f, f2, iPoint);
        }
    }

    public void mo3804b(int i, int i2, DPoint dPoint) {
        MapProjection.geo2LonLat(i, i2, dPoint);
    }

    public void mo3802b(double d, double d2, IPoint iPoint) {
        if (this.aB) {
            IPoint iPoint2 = new IPoint();
            FPoint fPoint = new FPoint();
            MapProjection.lonlat2Geo(d2, d, iPoint2);
            this.f10824D.geo2Map(iPoint2.f13273x, iPoint2.f13274y, fPoint);
            this.f10824D.map2Win(fPoint.f13252x, fPoint.f13253y, iPoint);
        }
    }

    private LatLng ag() {
        if (!this.aB) {
            return null;
        }
        DPoint dPoint = new DPoint();
        IPoint iPoint = new IPoint();
        this.f10824D.getGeoCenter(iPoint);
        MapProjection.geo2LonLat(iPoint.f13273x, iPoint.f13274y, dPoint);
        return new LatLng(dPoint.f13251y, dPoint.f13250x, false);
    }

    public CameraPosition mo3830l(boolean z) {
        if (!this.aB) {
            return null;
        }
        LatLng latLng;
        if (z) {
            DPoint dPoint = new DPoint();
            mo3771a(this.bk, this.bl, dPoint);
            latLng = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
        } else {
            latLng = ag();
        }
        return CameraPosition.builder().target(latLng).bearing(this.f10824D.getMapAngle()).tilt(this.f10824D.getCameraHeaderAngle()).zoom(this.f10824D.getMapZoomer()).build();
    }

    private void ah() {
        if (this.be) {
            this.be = false;
        }
        if (this.ba) {
            this.ba = false;
            C3259o a = C3259o.m15323a();
            a.f11338p = true;
            this.f10851e.m14847a(a);
        }
        if (this.aV) {
            this.aV = false;
            a = C3259o.m15323a();
            a.f11338p = true;
            this.f10851e.m14847a(a);
        }
        this.aW = false;
        this.aX = false;
        if (this.f10838R != null && this.aY != null) {
            this.f10838R.onMarkerDragEnd(this.aY);
            this.aY = null;
        }
    }

    private void m14469b(MotionEvent motionEvent) throws RemoteException {
        if (this.aX && this.aY != null) {
            int x = (int) motionEvent.getX();
            int y = (int) (motionEvent.getY() - 60.0f);
            LatLng g = this.aZ.mo3707g();
            LatLng e = this.aZ.mo3704e();
            DPoint dPoint = new DPoint();
            mo3771a(x, y, dPoint);
            this.aY.setPosition(new LatLng((e.latitude + dPoint.f13251y) - g.latitude, (dPoint.f13250x + e.longitude) - g.longitude));
            this.f10838R.onMarkerDrag(this.aY);
        }
    }

    public boolean mo3799a(MotionEvent motionEvent) {
        if (!this.bh) {
            return false;
        }
        mo3816e(false);
        if (motionEvent.getAction() == SportType.SPORT_TYPE_CLIMB_STAIRS) {
            this.bd = motionEvent.getPointerCount();
        }
        this.f10825E.onTouchEvent(motionEvent);
        this.aj.m15821a(motionEvent);
        this.f10826F.onTouchEvent(motionEvent);
        this.f10827G.m15543a(motionEvent);
        if (motionEvent.getAction() == 2) {
            try {
                m14469b(motionEvent);
            } catch (Throwable e) {
                ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "onDragMarker");
                e.printStackTrace();
            }
        }
        if (motionEvent.getAction() == 1) {
            ah();
        }
        mo3816e(false);
        if (this.f10842V != null) {
            this.bm.removeMessages(1);
            Message obtainMessage = this.bm.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = MotionEvent.obtain(motionEvent);
            obtainMessage.sendToTarget();
        }
        return true;
    }

    public void mo3775a(ag agVar) throws RemoteException {
        int i = -2;
        if (agVar != null) {
            if ((agVar.mo3709i() != null || agVar.mo3710j() != null) && this.f10846Z != null) {
                mo3739D();
                this.ac = agVar;
                if (this.aC) {
                    int i2;
                    Marker marker = new Marker(agVar);
                    this.ab = this.f10846Z.getInfoWindow(marker);
                    try {
                        if (this.aq == null) {
                            this.aq = bc.m14987a(this.f10822B, "infowindow_bg.9.png");
                        }
                    } catch (Throwable th) {
                        ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "showInfoWindow decodeDrawableFromAsset");
                        th.printStackTrace();
                    }
                    if (this.ab == null) {
                        this.ab = this.f10846Z.getInfoContents(marker);
                    }
                    View linearLayout = new LinearLayout(this.f10822B);
                    if (this.ab != null) {
                        if (this.ab.getBackground() == null) {
                            this.ab.setBackgroundDrawable(this.aq);
                        }
                        linearLayout.addView(this.ab);
                    } else {
                        linearLayout.setBackgroundDrawable(this.aq);
                        View textView = new TextView(this.f10822B);
                        textView.setText(agVar.mo3709i());
                        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        View textView2 = new TextView(this.f10822B);
                        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        textView2.setText(agVar.mo3710j());
                        linearLayout.setOrientation(1);
                        linearLayout.addView(textView);
                        linearLayout.addView(textView2);
                    }
                    this.ab = linearLayout;
                    LayoutParams layoutParams = this.ab.getLayoutParams();
                    this.ab.setDrawingCacheEnabled(true);
                    this.ab.setDrawingCacheQuality(0);
                    agVar.mo3702d();
                    int D = agVar.mo3677D() + agVar.mo3675B();
                    int E = (agVar.mo3678E() + agVar.mo3676C()) + 2;
                    if (layoutParams != null) {
                        i2 = layoutParams.width;
                        i = layoutParams.height;
                    } else {
                        i2 = -2;
                    }
                    layoutParams = new C3237a(i2, i, agVar.mo3706f(), D, E, 81);
                    Bitmap a;
                    BitmapDescriptor fromBitmap;
                    if (this.ad == null) {
                        a = bk.m15651a(this.ab);
                        fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                        a.recycle();
                        this.ad = new bg(this, new MarkerOptions().icon(fromBitmap), this) {
                            final /* synthetic */ AMapDelegateImp f10768a;

                            public void mo3727a() {
                                this.f10768a.au.removeCallbacks(this.f10768a.bn);
                                this.f10768a.au.post(this.f10768a.bo);
                            }
                        };
                        this.ad.m14257a(agVar.mo3706f());
                        this.ad.m14267b(D, E);
                    } else {
                        this.ad.m14257a(agVar.mo3706f());
                        this.ad.m14267b(D, E);
                        a = bk.m15651a(this.ab);
                        fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                        a.recycle();
                        this.ad.mo3687a(fromBitmap);
                    }
                    this.f10829I.addView(this.ab, layoutParams);
                    agVar.mo3698b(true);
                    return;
                }
                this.au.postDelayed(new C32042(this), 100);
            }
        }
    }

    public void mo3739D() {
        if (this.ab != null) {
            this.ab.clearFocus();
            this.f10829I.removeView(this.ab);
            bk.m15662a(this.ab.getBackground());
            bk.m15662a(this.aq);
            if (this.ad != null) {
                this.ad.mo3700c(false);
            }
            this.ab = null;
        }
        this.ac = null;
    }

    public float mo3740E() {
        return this.f10824D.getMapZoomer();
    }

    void m14513F() {
        this.f10858l.obtainMessage(18).sendToTarget();
    }

    public LatLngBounds mo3741G() {
        return this.bg;
    }

    public LatLngBounds mo3759a(LatLng latLng, float f) {
        int m = m14625m();
        int n = m14627n();
        if (m <= 0 || n <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        MapProjection mapProjection = new MapProjection(this.f10821A);
        mapProjection.setCameraHeaderAngle(0.0f);
        mapProjection.setMapAngle(0.0f);
        mapProjection.setGeoCenter(iPoint.f13273x, iPoint.f13274y);
        mapProjection.setMapZoomer(f);
        mapProjection.recalculate();
        DPoint dPoint = new DPoint();
        m14462a(mapProjection, 0, 0, dPoint);
        LatLng latLng2 = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
        m14462a(mapProjection, m, n, dPoint);
        LatLng latLng3 = new LatLng(dPoint.f13251y, dPoint.f13250x, false);
        mapProjection.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    void m14515H() {
        if (!this.bh) {
            this.f10856j.setBackgroundColor(0);
            this.f10830J.setBackgroundColor(0);
            this.f10833M.setBackgroundColor(0);
            this.f10829I.setBackgroundColor(0);
            this.f10853g.setBackgroundColor(0);
            if (this.f10852f != null) {
                this.f10852f.setBackgroundColor(0);
            }
            this.f10850d.setBackgroundColor(0);
            this.f10831K.setBackgroundColor(0);
            this.bh = true;
        }
    }

    public Point mo3742I() {
        if (this.f10830J == null) {
            return null;
        }
        return this.f10830J.m15255c();
    }

    public static Bitmap m14447a(int i, int i2, int i3, int i4, GL10 gl10) {
        try {
            int[] iArr = new int[(i3 * i4)];
            int[] iArr2 = new int[(i3 * i4)];
            Buffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = iArr[(i5 * i3) + i6];
                    iArr2[(((i4 - i5) - 1) * i3) + i6] = ((i7 & -16711936) | ((i7 << 16) & 16711680)) | ((i7 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i4);
            return createBitmap;
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    public void mo3794a(AMap$onMapPrintScreenListener aMap$onMapPrintScreenListener) {
        this.as = aMap$onMapPrintScreenListener;
        this.aJ = true;
        mo3816e(false);
    }

    public void mo3787a(AMap$OnMapScreenShotListener aMap$OnMapScreenShotListener) {
        this.at = aMap$OnMapScreenShotListener;
        this.aJ = true;
        mo3816e(false);
    }

    public void mo3812d(int i) {
        if (this.f10830J != null) {
            this.f10830J.m15252a(i);
            this.f10830J.invalidate();
            if (this.f10833M.getVisibility() == 0) {
                this.f10833M.invalidate();
            }
        }
    }

    public void mo3815e(int i) {
        if (this.f10852f != null) {
            C3237a c3237a = (C3237a) this.f10852f.getLayoutParams();
            if (i == 0) {
                c3237a.f10953d = 16;
            } else if (i == 1) {
                c3237a.f10953d = 80;
            }
            this.f10829I.updateViewLayout(this.f10852f, c3237a);
        }
    }

    public float mo3743J() {
        try {
            LatLng latLng = mo3834q().target;
            float f = this.f10847a;
            if (this.aB) {
                f = this.f10824D.getMapZoomer();
            }
            return (float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) f) * 256.0d));
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    void m14626m(boolean z) {
        int i;
        Handler handler = this.f10858l;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.obtainMessage(20, i, 0).sendToTarget();
    }

    protected void m14587a(boolean z, CameraPosition cameraPosition) {
        if (this.f10840T != null && this.al.m15311a() && this.f10856j.isEnabled()) {
            if (cameraPosition == null) {
                try {
                    cameraPosition = mo3834q();
                } catch (Throwable e) {
                    ca.m15831a(e, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
                    e.printStackTrace();
                }
            }
            this.f10840T.onCameraChangeFinish(cameraPosition);
        }
    }

    public void mo3818f(int i) {
        if (this.f10868v.contains(Integer.valueOf(i))) {
            this.f10867u.add(Integer.valueOf(i));
            this.f10868v.remove(this.f10868v.indexOf(Integer.valueOf(i)));
        }
    }

    public int mo3744K() {
        Integer valueOf = Integer.valueOf(0);
        if (this.f10867u.size() > 0) {
            valueOf = (Integer) this.f10867u.get(0);
            this.f10867u.remove(0);
            this.f10868v.add(valueOf);
        }
        return valueOf.intValue();
    }

    public List<Marker> mo3745L() {
        boolean z = m14625m() > 0 && m14627n() > 0;
        au.m15521a(z, (Object) "地图未初始化完成！");
        return this.f10850d.m14874f();
    }

    public void mo3746M() {
        this.f10854h.m16342b();
    }

    public void mo3747N() {
        this.bi = true;
    }

    public boolean m14522O() {
        return this.bi;
    }

    public void m14523P() {
        if (this.f10850d != null) {
            this.f10850d.m14875g();
        }
        this.bi = false;
    }

    public void mo3769a(int i, int i2) {
        if (this.f10823C != null) {
            this.bj = true;
            this.f10823C.m14654a(i, i2);
            this.bk = i;
            this.bl = i2;
        }
    }

    public void mo3820g(int i) {
        this.ap = i;
    }

    public int mo3748Q() {
        return this.ap;
    }

    public boolean mo3749R() {
        return this.aC;
    }

    public C3257n mo3750S() {
        return this.al;
    }

    public void mo3831n(final boolean z) throws RemoteException {
        m14584a(new Runnable(this) {
            final /* synthetic */ AMapDelegateImp f10770b;

            public void run() {
                int i;
                MapCore d = this.f10770b.f10821A;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                d.setParameter(2601, i, 0, 0, 0);
            }
        });
    }

    public void mo3751T() {
        mo3781a(null);
    }

    public void mo3781a(AMap$OnCacheRemoveListener aMap$OnCacheRemoveListener) {
        if (this.aM != null) {
            try {
                this.f10821A.setParameter(2601, 0, 0, 0, 0);
                Runnable c3227i = new C3227i(this, this.f10822B, aMap$OnCacheRemoveListener);
                this.aM.removeCallbacks(c3227i);
                this.aM.post(c3227i);
            } catch (Throwable th) {
                ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "removecache");
                th.printStackTrace();
            }
        }
    }

    private boolean m14466a(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!m14466a(listFiles[i])) {
                    return false;
                } else {
                    listFiles[i].delete();
                }
            }
        }
        return true;
    }

    public void m14528U() {
        if (this.f10854h != null) {
            this.f10854h.m16344c();
        }
        if (this.f10850d != null) {
            this.f10850d.m14865b();
        }
        if (this.f10859m != null) {
            this.f10859m.OnMapReferencechanged();
        }
    }

    public void mo3822h(int i) {
        this.f10856j.setVisibility(i);
    }

    public void m14562a(C3320f c3320f) {
        if (c3320f == null) {
            if (!(this.f10824D.getMapZoomer() < 17.0f || this.av == null || this.av.f11763l == null)) {
                IPoint iPoint = new IPoint();
                m14596b(this.av.f11763l.f13273x, this.av.f11763l.f13274y, iPoint);
                if (this.ah.contains(iPoint.f13273x, iPoint.f13274y)) {
                    return;
                }
            }
            if (this.f10834N.getVisibility() == 0) {
                this.av.f11763l = null;
                this.f10858l.post(new C32075(this));
            }
        } else if (this.av == null || !this.av.f11756e.equals(c3320f.f11756e) || this.f10834N.getVisibility() != 0) {
            if (this.av == null || !this.av.f11756e.equals(c3320f.f11756e)) {
                this.av = c3320f;
                this.av.f11763l = new IPoint();
                this.f10824D.getGeoCenter(this.av.f11763l);
            }
            this.f10858l.post(new C32086(this));
        }
    }

    private Poi m14454a(int i, int i2, int i3) {
        if (!this.aC) {
            return null;
        }
        try {
            SelectedMapPoi GetSelectedMapPoi = this.f10821A.GetSelectedMapPoi(i, i2, i3);
            if (GetSelectedMapPoi == null) {
                return null;
            }
            DPoint dPoint = new DPoint();
            MapProjection.geo2LonLat(GetSelectedMapPoi.mapx, GetSelectedMapPoi.mapy, dPoint);
            return new Poi(GetSelectedMapPoi.name, new LatLng(dPoint.f13251y, dPoint.f13250x, false), GetSelectedMapPoi.poiid);
        } catch (Throwable th) {
            return null;
        }
    }

    public void mo3795a(CustomRenderer customRenderer) {
        this.f10859m = customRenderer;
    }

    public Context m14529V() {
        return this.f10822B;
    }

    public void m14584a(Runnable runnable) {
        if (this.f10856j != null) {
            this.f10856j.queueEvent(runnable);
        }
    }

    private void m14470b(GL10 gl10) {
        ad();
        this.f10821A.setGL(gl10);
        af();
        this.f10821A.surfaceCreate(gl10);
        if (this.f10862p == null || this.f10862p.isRecycled()) {
            this.f10862p = bk.m15648a(this.f10822B, "lineTexture.png");
        }
        if (this.f10863q == null || this.f10863q.isRecycled()) {
            this.f10863q = bk.m15648a(this.f10822B, "lineDashTexture.png");
        }
        this.f10860n = bk.m15645a(gl10, this.f10862p);
        this.f10861o = bk.m15646a(gl10, this.f10863q, true);
        this.f10862p = null;
        mo3816e(false);
        if (!this.aD) {
            try {
                this.bf.setName("AuthThread");
                this.bf.start();
                this.aD = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f10856j.setRenderMode(0);
        try {
            m14470b(gl10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f10859m != null) {
            this.f10859m.onSurfaceCreated(gl10, eGLConfig);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.ah = new Rect(0, 0, i, i2);
        try {
            m14463a(gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m14463a(GL10 gl10, int i, int i2) {
        int i3 = 2;
        int i4 = 120;
        int i5 = 50;
        this.f10821A.setGL(gl10);
        this.f10821A.surfaceChange(gl10, i, i2);
        int i6 = this.f10822B.getResources().getDisplayMetrics().densityDpi;
        float f = this.f10822B.getResources().getDisplayMetrics().density;
        af();
        int i7 = 100;
        if (i6 <= 120) {
            i3 = 1;
        } else if (i6 <= SyslogAppender.LOG_LOCAL4) {
            if (Math.max(i, i2) <= 480) {
                i6 = 120;
            } else {
                i6 = 100;
                i4 = SyslogAppender.LOG_LOCAL4;
            }
            i3 = 1;
            i5 = i4;
            i7 = i6;
        } else if (i6 <= 240) {
            if (Math.min(i, i2) >= 1000) {
                i7 = 60;
                i5 = 200;
            } else {
                i7 = 70;
                i5 = 150;
            }
        } else if (i6 <= 320) {
            i3 = 3;
            i7 = 50;
            i5 = 180;
        } else if (i6 <= 480) {
            i3 = 3;
            i7 = 50;
            i5 = 300;
        } else {
            i7 = 40;
            i5 = 360;
            i3 = 4;
        }
        this.f10821A.setParameter(2051, i7, i5, (int) (f * 100.0f), i3);
        this.f10821A.setParameter(1001, 0, 0, 0, 0);
        this.f10821A.setParameter(1021, 1, 0, 0, 0);
        this.f10821A.setParameter(1022, 1, 0, 0, 0);
        this.f10821A.setParameter(1023, 1, 0, 0, 0);
        this.f10821A.setParameter(1024, 1, 0, 0, 0);
        mo3816e(false);
        if (this.f10857k == null) {
            this.f10857k = new C32108(this);
        }
        this.f10858l.postDelayed(this.f10857k, 300);
        if (this.f10859m != null) {
            this.f10859m.onSurfaceChanged(gl10, i, i2);
        }
    }

    private void m14474c(GL10 gl10) {
        this.aB = false;
        this.aC = false;
        if (this.f10824D != null) {
            IPoint iPoint = new IPoint();
            this.f10824D.getGeoCenter(iPoint);
            this.f10847a = this.f10824D.getMapZoomer();
            this.f10849c = this.f10824D.getMapAngle();
            this.f10848b = this.f10824D.getCameraHeaderAngle();
            this.f10864r = iPoint.f13273x;
            this.f10865s = iPoint.f13274y;
        }
        ae();
        this.aI = Boolean.valueOf(true);
        if (this.f10821A != null) {
            try {
                this.f10821A.destroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f10821A.setMapCallback(null);
            this.f10821A = null;
        }
        if (this.f10824D != null) {
            this.f10824D.recycle();
            this.f10824D = null;
        }
        VMapDataCache.getInstance().reset();
        this.f10851e.m14845a();
        this.f10851e = new au(this);
        this.f10821A = new MapCore(this.f10822B);
        this.f10821A.setMapCallback(this.f10823C);
        this.f10855i = new GLMapResManager(this, this.f10822B);
        this.ae = new bh(this);
        if (!this.aB) {
            ab();
        }
        this.f10823C.onResume(this.f10821A);
        this.aT = false;
        m14470b(gl10);
        m14463a(gl10, this.ah.width(), this.ah.height());
        this.aI = Boolean.valueOf(false);
    }

    public void mo3752W() {
        this.bp = true;
    }

    public MapViewTime m14531X() {
        return this.f10869w;
    }

    public MapViewMode m14532Y() {
        return this.f10870x;
    }

    public MapViewModeState m14533Z() {
        return this.f10871y;
    }

    private void ai() {
        if (this.f10870x == MapViewMode.SATELLITE || this.f10869w == MapViewTime.NIGHT) {
            this.f10830J.m15253a(true);
        } else {
            this.f10830J.m15253a(false);
        }
    }
}
