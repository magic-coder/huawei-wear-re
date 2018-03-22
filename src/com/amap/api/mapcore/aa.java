package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
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
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IAMapDelegate */
public interface aa {
    al mo3737A() throws RemoteException;

    View mo3738C() throws RemoteException;

    void mo3739D();

    float mo3740E();

    LatLngBounds mo3741G();

    Point mo3742I();

    float mo3743J() throws RemoteException;

    int mo3744K();

    List<Marker> mo3745L() throws RemoteException;

    void mo3746M();

    void mo3747N();

    int mo3748Q() throws RemoteException;

    boolean mo3749R();

    C3257n mo3750S();

    void mo3751T() throws RemoteException;

    void mo3752W();

    ab mo3753a(ArcOptions arcOptions) throws RemoteException;

    ac mo3754a(CircleOptions circleOptions) throws RemoteException;

    ae mo3755a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    ah mo3756a(NavigateArrowOptions navigateArrowOptions) throws RemoteException;

    aj mo3757a(PolygonOptions polygonOptions) throws RemoteException;

    ak mo3758a(PolylineOptions polylineOptions) throws RemoteException;

    LatLngBounds mo3759a(LatLng latLng, float f);

    Marker mo3760a(MarkerOptions markerOptions) throws RemoteException;

    Text mo3761a(TextOptions textOptions) throws RemoteException;

    TileOverlay mo3762a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    ArrayList<Marker> mo3763a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException;

    void mo3764a(double d, double d2, FPoint fPoint);

    void mo3765a(double d, double d2, IPoint iPoint);

    void mo3766a(float f) throws RemoteException;

    void mo3767a(float f, float f2, IPoint iPoint);

    void mo3768a(int i) throws RemoteException;

    void mo3769a(int i, int i2) throws RemoteException;

    void mo3770a(int i, int i2, int i3, int i4) throws RemoteException;

    void mo3771a(int i, int i2, DPoint dPoint);

    void mo3772a(int i, int i2, FPoint fPoint);

    void mo3773a(int i, int i2, IPoint iPoint);

    void mo3774a(Location location) throws RemoteException;

    void mo3775a(ag agVar) throws RemoteException;

    void mo3776a(C3259o c3259o) throws RemoteException;

    void mo3777a(C3259o c3259o, long j, AMap$CancelableCallback aMap$CancelableCallback) throws RemoteException;

    void mo3778a(C3259o c3259o, AMap$CancelableCallback aMap$CancelableCallback) throws RemoteException;

    void mo3779a(C3268u c3268u);

    void mo3780a(AMap$InfoWindowAdapter aMap$InfoWindowAdapter) throws RemoteException;

    void mo3781a(AMap$OnCacheRemoveListener aMap$OnCacheRemoveListener) throws RemoteException;

    void mo3782a(AMap$OnCameraChangeListener aMap$OnCameraChangeListener) throws RemoteException;

    void mo3783a(AMap$OnInfoWindowClickListener aMap$OnInfoWindowClickListener) throws RemoteException;

    void mo3784a(AMap$OnMapClickListener aMap$OnMapClickListener) throws RemoteException;

    void mo3785a(AMap$OnMapLoadedListener aMap$OnMapLoadedListener) throws RemoteException;

    void mo3786a(AMap$OnMapLongClickListener aMap$OnMapLongClickListener) throws RemoteException;

    void mo3787a(AMap$OnMapScreenShotListener aMap$OnMapScreenShotListener);

    void mo3788a(AMap$OnMapTouchListener aMap$OnMapTouchListener) throws RemoteException;

    void mo3789a(AMap$OnMarkerClickListener aMap$OnMarkerClickListener) throws RemoteException;

    void mo3790a(AMap$OnMarkerDragListener aMap$OnMarkerDragListener) throws RemoteException;

    void mo3791a(AMap$OnMyLocationChangeListener aMap$OnMyLocationChangeListener) throws RemoteException;

    void mo3792a(AMap$OnPOIClickListener aMap$OnPOIClickListener) throws RemoteException;

    void mo3793a(AMap$OnPolylineClickListener aMap$OnPolylineClickListener) throws RemoteException;

    void mo3794a(AMap$onMapPrintScreenListener aMap$onMapPrintScreenListener);

    void mo3795a(CustomRenderer customRenderer) throws RemoteException;

    void mo3796a(LocationSource locationSource) throws RemoteException;

    void mo3797a(MyLocationStyle myLocationStyle) throws RemoteException;

    void mo3798a(boolean z);

    boolean mo3799a(MotionEvent motionEvent);

    boolean mo3800a(String str) throws RemoteException;

    int mo3801b();

    void mo3802b(double d, double d2, IPoint iPoint);

    void mo3803b(int i) throws RemoteException;

    void mo3804b(int i, int i2, DPoint dPoint);

    void mo3805b(int i, int i2, FPoint fPoint);

    void mo3806b(C3259o c3259o) throws RemoteException;

    void mo3807b(boolean z);

    float mo3808c(int i);

    MapProjection mo3809c();

    void mo3810c(boolean z);

    void mo3811d();

    void mo3812d(int i);

    void mo3813d(boolean z);

    void mo3814e();

    void mo3815e(int i);

    void mo3816e(boolean z);

    void mo3817f();

    void mo3818f(int i);

    void mo3819f(boolean z) throws RemoteException;

    void mo3820g(int i) throws RemoteException;

    void mo3821g(boolean z) throws RemoteException;

    void mo3822h(int i);

    void mo3823h(boolean z) throws RemoteException;

    void mo3824i(boolean z) throws RemoteException;

    Rect mo3825j();

    void mo3826j(boolean z) throws RemoteException;

    int mo3827k();

    void mo3828k(boolean z) throws RemoteException;

    int mo3829l();

    CameraPosition mo3830l(boolean z);

    void mo3831n(boolean z) throws RemoteException;

    int mo3832o();

    void mo3833p();

    CameraPosition mo3834q() throws RemoteException;

    float mo3835r();

    float mo3836s();

    void mo3837t() throws RemoteException;

    void mo3838u() throws RemoteException;

    int mo3839v() throws RemoteException;

    boolean mo3840w() throws RemoteException;

    boolean mo3841x() throws RemoteException;

    Location mo3842y() throws RemoteException;

    ap mo3843z() throws RemoteException;
}
