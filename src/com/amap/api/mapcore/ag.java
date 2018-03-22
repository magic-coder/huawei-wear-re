package com.amap.api.mapcore;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: IMarkerDelegate */
public interface ag {
    boolean mo3674A();

    int mo3675B();

    int mo3676C();

    int mo3677D();

    int mo3678E();

    boolean mo3679F();

    float mo3680G();

    boolean mo3681H();

    IPoint mo3682I();

    void mo3683a(float f) throws RemoteException;

    void mo3684a(float f, float f2) throws RemoteException;

    void mo3685a(int i) throws RemoteException;

    void mo3686a(int i, int i2);

    void mo3687a(BitmapDescriptor bitmapDescriptor) throws RemoteException;

    void mo3688a(LatLng latLng) throws RemoteException;

    void mo3689a(IPoint iPoint);

    void mo3690a(Object obj);

    void mo3691a(String str) throws RemoteException;

    void mo3692a(ArrayList<BitmapDescriptor> arrayList) throws RemoteException;

    void mo3693a(GL10 gl10, aa aaVar);

    void mo3694a(boolean z) throws RemoteException;

    boolean mo3695a(ag agVar) throws RemoteException;

    void mo3696b(float f);

    void mo3697b(String str) throws RemoteException;

    void mo3698b(boolean z);

    boolean mo3699b() throws RemoteException;

    void mo3700c(boolean z) throws RemoteException;

    boolean mo3701c();

    Rect mo3702d();

    void mo3703d(boolean z) throws RemoteException;

    LatLng mo3704e() throws RemoteException;

    void mo3705e(boolean z) throws RemoteException;

    FPoint mo3706f();

    LatLng mo3707g();

    String mo3708h() throws RemoteException;

    String mo3709i() throws RemoteException;

    String mo3710j() throws RemoteException;

    boolean mo3711k();

    void mo3712l() throws RemoteException;

    void mo3713m() throws RemoteException;

    boolean mo3714n();

    boolean mo3715o() throws RemoteException;

    void mo3716p();

    int mo3717q();

    boolean mo3718r();

    Object mo3719s();

    boolean mo3720t() throws RemoteException;

    float mo3721u();

    int mo3722v() throws RemoteException;

    ArrayList<BitmapDescriptor> mo3723w() throws RemoteException;

    boolean mo3724x();

    void mo3725y();

    void mo3726z() throws RemoteException;
}
