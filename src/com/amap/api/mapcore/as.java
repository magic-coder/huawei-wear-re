package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.util.bf;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.model.CameraPosition;
import com.android.volley.DefaultRetryPolicy;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: MapFragmentDelegateImp */
public class as implements af {
    public static volatile Context f10925a;
    public static int f10926c = 0;
    public static int f10927d = 1;
    public int f10928b = 0;
    private aa f10929e;
    private int f10930f = 0;
    private AMapOptions f10931g;

    public as(int i) {
        int i2 = 0;
        if (i > 0) {
            i2 = 1;
        }
        this.f10930f = i2;
    }

    public void mo3864a(Context context) {
        if (context != null) {
            f10925a = context.getApplicationContext();
        }
    }

    public void mo3866a(AMapOptions aMapOptions) {
        this.f10931g = aMapOptions;
    }

    public aa mo3861a() throws RemoteException {
        if (this.f10929e == null) {
            if (f10925a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f10925a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                C3264r.f11365a = 0.5f;
            } else if (i <= SyslogAppender.LOG_LOCAL4) {
                C3264r.f11365a = 0.8f;
            } else if (i <= 240) {
                C3264r.f11365a = 0.87f;
            } else if (i <= 320) {
                C3264r.f11365a = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            } else if (i <= 480) {
                C3264r.f11365a = 1.5f;
            } else if (i <= 640) {
                C3264r.f11365a = 1.8f;
            } else {
                C3264r.f11365a = 0.9f;
            }
            if (this.f10930f == f10926c) {
                this.f10929e = new C3252j(f10925a).m15265a();
            } else {
                this.f10929e = new C3254k(f10925a).mo3978a();
            }
        }
        return this.f10929e;
    }

    public void mo3863a(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        f10925a = activity.getApplicationContext();
        this.f10931g = aMapOptions;
    }

    public void mo3865a(Bundle bundle) throws RemoteException {
        bf.m15627a("MapFragmentDelegateImp", "onCreate", 113);
    }

    public View mo3860a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        if (this.f10929e == null) {
            if (f10925a == null && layoutInflater != null) {
                f10925a = layoutInflater.getContext().getApplicationContext();
            }
            if (f10925a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f10925a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                C3264r.f11365a = 0.5f;
            } else if (i <= SyslogAppender.LOG_LOCAL4) {
                C3264r.f11365a = 0.6f;
            } else if (i <= 240) {
                C3264r.f11365a = 0.87f;
            } else if (i <= 320) {
                C3264r.f11365a = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            } else if (i <= 480) {
                C3264r.f11365a = 1.5f;
            } else if (i <= 640) {
                C3264r.f11365a = 1.8f;
            } else {
                C3264r.f11365a = 0.9f;
            }
            if (this.f10930f == f10926c) {
                this.f10929e = new C3252j(f10925a).m15265a();
            } else {
                this.f10929e = new C3254k(f10925a).mo3978a();
            }
            this.f10929e.mo3822h(this.f10928b);
        }
        try {
            if (this.f10931g == null && bundle != null) {
                byte[] byteArray = bundle.getByteArray("MapOptions");
                if (byteArray != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(byteArray, 0, byteArray.length);
                    obtain.setDataPosition(0);
                    this.f10931g = AMapOptions.CREATOR.createFromParcel(obtain);
                }
            }
            m14838b(this.f10931g);
            bf.m15627a("MapFragmentDelegateImp", "onCreateView", 113);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f10929e.mo3738C();
    }

    void m14838b(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.f10929e != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.f10929e.mo3776a(C3259o.m15331a(camera.target, camera.zoom, camera.bearing, camera.tilt));
            }
            ap z = this.f10929e.mo3843z();
            z.mo3972h(aMapOptions.getRotateGesturesEnabled().booleanValue());
            z.mo3966e(aMapOptions.getScrollGesturesEnabled().booleanValue());
            z.mo3970g(aMapOptions.getTiltGesturesEnabled().booleanValue());
            z.mo3960b(aMapOptions.getZoomControlsEnabled().booleanValue());
            z.mo3968f(aMapOptions.getZoomGesturesEnabled().booleanValue());
            z.mo3962c(aMapOptions.getCompassEnabled().booleanValue());
            z.mo3957a(aMapOptions.getScaleControlsEnabled().booleanValue());
            z.mo3956a(aMapOptions.getLogoPosition());
            this.f10929e.mo3803b(aMapOptions.getMapType());
            this.f10929e.mo3819f(aMapOptions.getZOrderOnTop().booleanValue());
        }
    }

    public void mo3867b() throws RemoteException {
        if (this.f10929e != null) {
            this.f10929e.mo3811d();
        }
    }

    public void mo3869c() throws RemoteException {
        if (this.f10929e != null) {
            this.f10929e.mo3814e();
        }
    }

    public void mo3870d() throws RemoteException {
    }

    public void mo3871e() throws RemoteException {
        if (this.f10929e != null) {
            this.f10929e.mo3838u();
            this.f10929e.mo3817f();
            this.f10929e = null;
        }
    }

    public void mo3872f() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    public void mo3868b(Bundle bundle) throws RemoteException {
        if (this.f10929e != null) {
            if (this.f10931g == null) {
                this.f10931g = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                this.f10931g = this.f10931g.camera(mo3861a().mo3830l(false));
                this.f10931g.writeToParcel(obtain, 0);
                bundle.putByteArray("MapOptions", obtain.marshall());
            } catch (Throwable th) {
            }
        }
    }

    public void mo3862a(int i) {
        this.f10928b = i;
        if (this.f10929e != null) {
            this.f10929e.mo3822h(i);
        }
    }
}
