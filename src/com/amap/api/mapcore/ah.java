package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: INavigateArrowDelegate */
public interface ah extends ai {
    void mo3874a(int i) throws RemoteException;

    void mo3875a(List<LatLng> list) throws RemoteException;

    void mo3881b(float f) throws RemoteException;

    void mo3882b(int i) throws RemoteException;

    float mo3888h() throws RemoteException;

    int mo3889i() throws RemoteException;

    int mo3892l() throws RemoteException;

    List<LatLng> mo3893m() throws RemoteException;
}
