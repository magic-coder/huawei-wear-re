package com.amap.api.maps;

import android.location.Location;
import android.os.RemoteException;
import com.amap.api.mapcore.aa;
import com.amap.api.mapcore.util.au;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.List;

public final class AMap {
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private final aa f126a;
    private UiSettings f127b;
    private Projection f128c;
    private MyTrafficStyle f129d;

    protected AMap(aa aaVar) {
        this.f126a = aaVar;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.f126a.q();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        return this.f126a.r();
    }

    public final float getMinZoomLevel() {
        return this.f126a.s();
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.f126a.a(cameraUpdate.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.f126a.b(cameraUpdate.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.f126a.a(cameraUpdate.a(), cancelableCallback);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        try {
            au.b(j > 0, "durationMs must be positive");
            this.f126a.a(cameraUpdate.a(), j, cancelableCallback);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.f126a.t();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        try {
            return new NavigateArrow(this.f126a.a(navigateArrowOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f126a.a(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f126a.a(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Arc addArc(ArcOptions arcOptions) {
        try {
            return new Arc(this.f126a.a(arcOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f126a.a(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return new GroundOverlay(this.f126a.a(groundOverlayOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.f126a.a(markerOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Text addText(TextOptions textOptions) {
        try {
            return this.f126a.a(textOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) {
        try {
            return this.f126a.a(arrayList, z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            return this.f126a.L();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return this.f126a.a(tileOverlayOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.f126a.u();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear(boolean z) {
        try {
            this.f126a.g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.f126a.v();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.f126a.b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.f126a.w();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTrafficEnabled(boolean z) {
        try {
            this.f126a.h(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void showMapText(boolean z) {
        try {
            this.f126a.i(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void showIndoorMap(boolean z) {
        try {
            this.f126a.j(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        try {
            this.f129d = myTrafficStyle;
            this.f126a.a(myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public MyTrafficStyle getMyTrafficStyle() {
        return this.f129d;
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.f126a.x();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.f126a.k(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Location getMyLocation() {
        try {
            return this.f126a.y();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.f126a.a(locationSource);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.f126a.a(myLocationStyle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationType(int i) {
        try {
            this.f126a.a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationRotateAngle(float f) {
        try {
            this.f126a.a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.f127b == null) {
                this.f127b = new UiSettings(this.f126a.z());
            }
            return this.f127b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            if (this.f128c == null) {
                this.f128c = new Projection(this.f126a.A());
            }
            return this.f128c;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.f126a.a(onCameraChangeListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.f126a.a(onMapClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.f126a.a(onMapTouchListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.f126a.a(onPOIClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.f126a.a(onMyLocationChangeListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.f126a.a(onMapLongClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.f126a.a(onMarkerClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.f126a.a(onPolylineClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.f126a.a(onMarkerDragListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.f126a.a(onInfoWindowClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.f126a.a(infoWindowAdapter);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.f126a.a(onMapLoadedListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapPrintScreen(onMapPrintScreenListener com_amap_api_maps_AMap_onMapPrintScreenListener) {
        this.f126a.a(com_amap_api_maps_AMap_onMapPrintScreenListener);
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.f126a.a(onMapScreenShotListener);
    }

    public float getScalePerPixel() {
        try {
            return this.f126a.J();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void runOnDrawFrame() {
        this.f126a.e(false);
    }

    public void removecache() {
        try {
            this.f126a.T();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.f126a.a(onCacheRemoveListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.f126a.a(customRenderer);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPointToCenter(int i, int i2) {
        try {
            this.f126a.a(i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapTextZIndex(int i) {
        try {
            this.f126a.g(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLoadOfflineData(boolean z) {
        try {
            this.f126a.n(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapTextZIndex() {
        try {
            return this.f126a.Q();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public static String getVersion() {
        return "3.2.0.1";
    }

    public void reloadMap() {
        this.f126a.W();
    }
}
