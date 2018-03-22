package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;

/* compiled from: IMapFragmentDelegate */
public interface af {
    View mo3860a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException;

    aa mo3861a() throws RemoteException;

    void mo3862a(int i);

    void mo3863a(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException;

    void mo3864a(Context context);

    void mo3865a(Bundle bundle) throws RemoteException;

    void mo3866a(AMapOptions aMapOptions);

    void mo3867b() throws RemoteException;

    void mo3868b(Bundle bundle) throws RemoteException;

    void mo3869c() throws RemoteException;

    void mo3870d() throws RemoteException;

    void mo3871e() throws RemoteException;

    void mo3872f() throws RemoteException;
}
