package com.amap.api.maps.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.amap.api.mapcore.C3264r;
import com.amap.api.mapcore.util.bi;
import com.amap.api.mapcore.util.bk;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BusLineOverlay {
    private BusLineItem f12181a;
    private AMap f12182b;
    private ArrayList<Marker> f12183c = new ArrayList();
    private Polyline f12184d;
    private List<BusStationItem> f12185e;
    private BitmapDescriptor f12186f;
    private BitmapDescriptor f12187g;
    private BitmapDescriptor f12188h;
    private Context f12189i;

    public BusLineOverlay(Context context, AMap aMap, BusLineItem busLineItem) {
        this.f12189i = context;
        this.f12181a = busLineItem;
        this.f12182b = aMap;
        this.f12185e = this.f12181a.getBusStations();
    }

    public void addToMap() {
        int i = 1;
        try {
            this.f12184d = this.f12182b.addPolyline(new PolylineOptions().addAll(C3382a.m16540a(this.f12181a.getDirectionsCoordinates())).color(getBusColor()).width(getBuslineWidth()));
            if (this.f12185e.size() >= 1) {
                while (i < this.f12185e.size() - 1) {
                    this.f12183c.add(this.f12182b.addMarker(m16499a(i)));
                    i++;
                }
                this.f12183c.add(this.f12182b.addMarker(m16499a(0)));
                this.f12183c.add(this.f12182b.addMarker(m16499a(this.f12185e.size() - 1)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeFromMap() {
        if (this.f12184d != null) {
            this.f12184d.remove();
        }
        try {
            Iterator it = this.f12183c.iterator();
            while (it.hasNext()) {
                ((Marker) it.next()).remove();
            }
            m16500a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m16500a() {
        if (this.f12186f != null) {
            this.f12186f.recycle();
            this.f12186f = null;
        }
        if (this.f12187g != null) {
            this.f12187g.recycle();
            this.f12187g = null;
        }
        if (this.f12188h != null) {
            this.f12188h.recycle();
            this.f12188h = null;
        }
    }

    public void zoomToSpan() {
        if (this.f12182b != null) {
            try {
                List directionsCoordinates = this.f12181a.getDirectionsCoordinates();
                if (directionsCoordinates != null && directionsCoordinates.size() > 0) {
                    this.f12182b.moveCamera(CameraUpdateFactory.newLatLngBounds(m16498a(directionsCoordinates), 5));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private LatLngBounds m16498a(List<LatLonPoint> list) {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.include(new LatLng(((LatLonPoint) list.get(i)).getLatitude(), ((LatLonPoint) list.get(i)).getLongitude()));
        }
        return builder.build();
    }

    private MarkerOptions m16499a(int i) {
        MarkerOptions snippet = new MarkerOptions().position(new LatLng(((BusStationItem) this.f12185e.get(i)).getLatLonPoint().getLatitude(), ((BusStationItem) this.f12185e.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i));
        if (i == 0) {
            snippet.icon(getStartBitmapDescriptor());
        } else if (i == this.f12185e.size() - 1) {
            snippet.icon(getEndBitmapDescriptor());
        } else {
            snippet.anchor(0.5f, 0.5f);
            snippet.icon(getBusBitmapDescriptor());
        }
        return snippet;
    }

    protected BitmapDescriptor getStartBitmapDescriptor() {
        this.f12186f = m16497a("amap_start.png");
        return this.f12186f;
    }

    protected BitmapDescriptor getEndBitmapDescriptor() {
        this.f12187g = m16497a("amap_end.png");
        return this.f12187g;
    }

    protected BitmapDescriptor getBusBitmapDescriptor() {
        this.f12188h = m16497a("amap_bus.png");
        return this.f12188h;
    }

    protected String getTitle(int i) {
        return ((BusStationItem) this.f12185e.get(i)).getBusStationName();
    }

    protected String getSnippet(int i) {
        return "";
    }

    public int getBusStationIndex(Marker marker) {
        for (int i = 0; i < this.f12183c.size(); i++) {
            if (((Marker) this.f12183c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public BusStationItem getBusStationItem(int i) {
        if (i < 0 || i >= this.f12185e.size()) {
            return null;
        }
        return (BusStationItem) this.f12185e.get(i);
    }

    protected int getBusColor() {
        return Color.parseColor("#537edc");
    }

    protected float getBuslineWidth() {
        return 18.0f;
    }

    private BitmapDescriptor m16497a(String str) {
        Bitmap a;
        IOException e;
        IOException iOException;
        BitmapDescriptor fromBitmap;
        Throwable th;
        Throwable th2;
        Throwable th3;
        Object obj;
        InputStream inputStream;
        InputStream inputStream2 = null;
        InputStream open;
        try {
            open = bi.m15630a(this.f12189i).open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                try {
                    a = bk.m15649a(decodeStream, C3264r.f11365a);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    a = decodeStream;
                    e2 = iOException;
                    try {
                        e2.printStackTrace();
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                        a.recycle();
                        return fromBitmap;
                    } catch (Throwable th4) {
                        th = th4;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    a = decodeStream;
                    th3 = th2;
                    th3.printStackTrace();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                    a.recycle();
                    return fromBitmap;
                }
            } catch (IOException e32) {
                iOException = e32;
                obj = inputStream2;
                e2222 = iOException;
                e2222.printStackTrace();
                if (open != null) {
                    open.close();
                }
                fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                a.recycle();
                return fromBitmap;
            } catch (Throwable th52) {
                th2 = th52;
                obj = inputStream2;
                th3 = th2;
                th3.printStackTrace();
                if (open != null) {
                    open.close();
                }
                fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
                a.recycle();
                return fromBitmap;
            }
        } catch (IOException e322) {
            open = inputStream2;
            inputStream = inputStream2;
            e2222 = e322;
            a = inputStream;
            e2222.printStackTrace();
            if (open != null) {
                open.close();
            }
            fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
            a.recycle();
            return fromBitmap;
        } catch (Throwable th6) {
            th52 = th6;
            open = inputStream2;
            if (open != null) {
                open.close();
            }
            throw th52;
        }
        fromBitmap = BitmapDescriptorFactory.fromBitmap(a);
        a.recycle();
        return fromBitmap;
    }
}
