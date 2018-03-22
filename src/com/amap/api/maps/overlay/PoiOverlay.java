package com.amap.api.maps.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PoiOverlay {
    private List<PoiItem> f12204a;
    private AMap f12205b;
    private ArrayList<Marker> f12206c = new ArrayList();

    public PoiOverlay(AMap aMap, List<PoiItem> list) {
        this.f12205b = aMap;
        this.f12204a = list;
    }

    public void addToMap() {
        int i = 0;
        while (i < this.f12204a.size()) {
            try {
                Marker addMarker = this.f12205b.addMarker(m16531a(i));
                addMarker.setObject(Integer.valueOf(i));
                this.f12206c.add(addMarker);
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    public void removeFromMap() {
        Iterator it = this.f12206c.iterator();
        while (it.hasNext()) {
            ((Marker) it.next()).remove();
        }
    }

    public void zoomToSpan() {
        try {
            if (this.f12204a != null && this.f12204a.size() > 0 && this.f12205b != null) {
                if (this.f12204a.size() == 1) {
                    this.f12205b.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(((PoiItem) this.f12204a.get(0)).getLatLonPoint().getLatitude(), ((PoiItem) this.f12204a.get(0)).getLatLonPoint().getLongitude()), 18.0f));
                    return;
                }
                this.f12205b.moveCamera(CameraUpdateFactory.newLatLngBounds(m16530a(), 5));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private LatLngBounds m16530a() {
        Builder builder = LatLngBounds.builder();
        for (int i = 0; i < this.f12204a.size(); i++) {
            builder.include(new LatLng(((PoiItem) this.f12204a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f12204a.get(i)).getLatLonPoint().getLongitude()));
        }
        return builder.build();
    }

    private MarkerOptions m16531a(int i) {
        return new MarkerOptions().position(new LatLng(((PoiItem) this.f12204a.get(i)).getLatLonPoint().getLatitude(), ((PoiItem) this.f12204a.get(i)).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i)).icon(getBitmapDescriptor(i));
    }

    protected BitmapDescriptor getBitmapDescriptor(int i) {
        return null;
    }

    protected String getTitle(int i) {
        return ((PoiItem) this.f12204a.get(i)).getTitle();
    }

    protected String getSnippet(int i) {
        return ((PoiItem) this.f12204a.get(i)).getSnippet();
    }

    public int getPoiIndex(Marker marker) {
        for (int i = 0; i < this.f12206c.size(); i++) {
            if (((Marker) this.f12206c.get(i)).equals(marker)) {
                return i;
            }
        }
        return -1;
    }

    public PoiItem getPoiItem(int i) {
        if (i < 0 || i >= this.f12204a.size()) {
            return null;
        }
        return (PoiItem) this.f12204a.get(i);
    }
}
