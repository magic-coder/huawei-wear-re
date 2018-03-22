package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;

/* compiled from: IGroundOverlayDelegate */
public interface ae extends ai {
    void mo4074a(float f, float f2) throws RemoteException;

    void mo4075a(BitmapDescriptor bitmapDescriptor) throws RemoteException;

    void mo4076a(LatLng latLng) throws RemoteException;

    void mo4077a(LatLngBounds latLngBounds) throws RemoteException;

    void mo4078b(float f) throws RemoteException;

    void mo4079c(float f) throws RemoteException;

    void mo4080d(float f) throws RemoteException;

    LatLng mo4081h() throws RemoteException;

    float mo4082i() throws RemoteException;

    float mo4083l() throws RemoteException;

    LatLngBounds mo4084m() throws RemoteException;

    float mo4085n() throws RemoteException;

    float mo4086o() throws RemoteException;
}
