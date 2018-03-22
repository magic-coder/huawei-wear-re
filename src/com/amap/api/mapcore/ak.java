package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: IPolylineDelegate */
public interface ak extends ai {
    LatLng mo3903a(LatLng latLng);

    void mo3904a(int i) throws RemoteException;

    void mo3905a(List<LatLng> list) throws RemoteException;

    void mo3906b(float f) throws RemoteException;

    void mo3907b(boolean z) throws RemoteException;

    boolean mo3908b(LatLng latLng);

    void mo3909c(float f);

    void mo3910c(boolean z);

    float mo3911h() throws RemoteException;

    int mo3912i() throws RemoteException;

    List<LatLng> mo3913l() throws RemoteException;

    boolean mo3914m();

    boolean mo3915n();
}
