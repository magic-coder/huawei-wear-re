package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: IPolygonDelegate */
public interface aj extends ai {
    void mo3894a(int i) throws RemoteException;

    void mo3895a(List<LatLng> list) throws RemoteException;

    boolean mo3896a(LatLng latLng) throws RemoteException;

    void mo3897b(float f) throws RemoteException;

    void mo3898b(int i) throws RemoteException;

    float mo3899h() throws RemoteException;

    int mo3900i() throws RemoteException;

    List<LatLng> mo3901l() throws RemoteException;

    int mo3902m() throws RemoteException;
}
