package com.amap.api.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.aa;
import com.amap.api.mapcore.af;
import com.amap.api.mapcore.as;
import com.amap.api.maps.model.RuntimeRemoteException;

public class TextureSupportMapFragment extends Fragment {
    private AMap f11990a;
    private af f11991b;

    public static TextureSupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public static TextureSupportMapFragment newInstance(AMapOptions aMapOptions) {
        TextureSupportMapFragment textureSupportMapFragment = new TextureSupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MapOptions", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        textureSupportMapFragment.setArguments(bundle);
        return textureSupportMapFragment;
    }

    protected af getMapFragmentDelegate() {
        if (this.f11991b == null) {
            this.f11991b = new as(as.f10927d);
        }
        this.f11991b.mo3864a(getActivity());
        return this.f11991b;
    }

    public AMap getMap() {
        af mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            aa a = mapFragmentDelegate.mo3861a();
            if (a == null) {
                return null;
            }
            if (this.f11990a == null) {
                this.f11990a = new AMap(a);
            }
            return this.f11990a;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().mo3863a(activity, new AMapOptions(), bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate().mo3860a(layoutInflater, viewGroup, bundle);
    }

    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate().mo3867b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate().mo3869c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onDestroyView() {
        try {
            getMapFragmentDelegate().mo3870d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        try {
            getMapFragmentDelegate().mo3871e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().mo3872f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().mo3868b(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            getMapFragmentDelegate().mo3862a(0);
        } else {
            getMapFragmentDelegate().mo3862a(8);
        }
    }
}
