package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.amap.api.mapcore.C3264r;
import com.amap.api.mapcore.util.bi;
import com.amap.api.mapcore.util.bk;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveStep;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DrivingRouteOverlay extends C3381b {
    private DrivePath f12198a;
    private List<LatLonPoint> f12199b;
    private List<Marker> f12200c;
    private boolean f12201d;
    private Context f12202e;
    private PolylineOptions f12203f;

    public /* bridge */ /* synthetic */ void setNodeIconVisibility(boolean z) {
        super.setNodeIconVisibility(z);
    }

    public /* bridge */ /* synthetic */ void zoomToSpan() {
        super.zoomToSpan();
    }

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        this(context, aMap, drivePath, latLonPoint, latLonPoint2, null);
        this.f12202e = context;
    }

    public DrivingRouteOverlay(Context context, AMap aMap, DrivePath drivePath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, List<LatLonPoint> list) {
        super(context);
        this.f12200c = new ArrayList();
        this.f12201d = true;
        this.mAMap = aMap;
        this.f12198a = drivePath;
        this.startPoint = C3382a.m16539a(latLonPoint);
        this.endPoint = C3382a.m16539a(latLonPoint2);
        this.f12199b = list;
        this.f12202e = context;
    }

    public void addToMap() {
        m16522a();
        try {
            List steps = this.f12198a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                DriveStep driveStep = (DriveStep) steps.get(i);
                LatLng a = C3382a.m16539a(m16521a(driveStep));
                if (i >= steps.size() - 1) {
                    m16524a(m16525b(driveStep), this.endPoint);
                } else if (i == 0) {
                    m16523a(this.startPoint, a);
                }
                m16528c(driveStep);
            }
            addStartAndEndMarker();
            m16527c();
            m16526b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m16522a() {
        this.f12203f = null;
        this.f12203f = new PolylineOptions();
        this.f12203f.color(getDriveColor()).width(getRouteWidth());
    }

    private void m16526b() {
        addPolyLine(this.f12203f);
    }

    private LatLonPoint m16521a(DriveStep driveStep) {
        return (LatLonPoint) driveStep.getPolyline().get(0);
    }

    private LatLonPoint m16525b(DriveStep driveStep) {
        return (LatLonPoint) driveStep.getPolyline().get(driveStep.getPolyline().size() - 1);
    }

    private void m16524a(LatLonPoint latLonPoint, LatLng latLng) {
        m16523a(C3382a.m16539a(latLonPoint), latLng);
    }

    private void m16523a(LatLng latLng, LatLng latLng2) {
        this.f12203f.add(latLng, latLng2);
    }

    private void m16528c(DriveStep driveStep) {
        this.f12203f.addAll(C3382a.m16540a(driveStep.getPolyline()));
    }

    private void m16527c() {
        if (this.f12199b != null && this.f12199b.size() > 0) {
            for (int i = 0; i < this.f12199b.size(); i++) {
                LatLonPoint latLonPoint = (LatLonPoint) this.f12199b.get(i);
                if (latLonPoint != null) {
                    this.f12200c.add(this.mAMap.addMarker(new MarkerOptions().position(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude())).visible(this.f12201d).icon(m16529d()).title("途经点")));
                }
            }
        }
    }

    protected LatLngBounds getLatLngBounds() {
        Builder builder = LatLngBounds.builder();
        builder.include(new LatLng(this.startPoint.latitude, this.startPoint.longitude));
        builder.include(new LatLng(this.endPoint.latitude, this.endPoint.longitude));
        if (this.f12199b != null && this.f12199b.size() > 0) {
            for (int i = 0; i < this.f12199b.size(); i++) {
                builder.include(new LatLng(((LatLonPoint) this.f12199b.get(i)).getLatitude(), ((LatLonPoint) this.f12199b.get(i)).getLongitude()));
            }
        }
        return builder.build();
    }

    public void setThroughPointIconVisibility(boolean z) {
        try {
            this.f12201d = z;
            if (this.f12200c != null && this.f12200c.size() > 0) {
                for (int i = 0; i < this.f12200c.size(); i++) {
                    ((Marker) this.f12200c.get(i)).setVisible(z);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private BitmapDescriptor m16529d() {
        InputStream open;
        Throwable th;
        Throwable th2;
        Throwable th3;
        BitmapDescriptor fromBitmap;
        Bitmap a;
        InputStream inputStream = null;
        try {
            Bitmap decodeStream;
            open = bi.m15630a(this.f12202e).open("amap_throughpoint.png");
            try {
                decodeStream = BitmapFactory.decodeStream(open);
            } catch (Throwable th22) {
                th = th22;
                Object obj = inputStream;
                th3 = th;
                try {
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th32) {
                            th32.printStackTrace();
                        }
                    }
                    fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                    a.recycle();
                    return fromBitmap;
                } catch (Throwable th4) {
                    th22 = th4;
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Throwable th322) {
                            th322.printStackTrace();
                        }
                    }
                    throw th22;
                }
            }
            try {
                a = bk.m15649a(decodeStream, C3264r.f11365a);
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable th3222) {
                        th3222.printStackTrace();
                    }
                }
            } catch (Throwable th222) {
                th = th222;
                a = decodeStream;
                th3222 = th;
                th3222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                a.recycle();
                return fromBitmap;
            }
        } catch (Throwable th5) {
            th222 = th5;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw th222;
        }
        fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
        a.recycle();
        return fromBitmap;
    }

    public void removeFromMap() {
        try {
            super.removeFromMap();
            if (this.f12200c != null && this.f12200c.size() > 0) {
                for (int i = 0; i < this.f12200c.size(); i++) {
                    ((Marker) this.f12200c.get(i)).remove();
                }
                this.f12200c.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
