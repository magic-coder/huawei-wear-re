package com.amap.api.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amap.api.mapcore.aa;
import com.amap.api.mapcore.af;
import com.amap.api.mapcore.as;
import com.amap.api.maps.model.RuntimeRemoteException;

public class TextureMapView extends FrameLayout {
    private af f11987a;
    private AMap f11988b;
    private int f11989c = 0;

    public TextureMapView(Context context) {
        super(context);
        getMapFragmentDelegate().mo3864a(context);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11989c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().mo3864a(context);
        getMapFragmentDelegate().mo3862a(this.f11989c);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11989c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().mo3864a(context);
        getMapFragmentDelegate().mo3862a(this.f11989c);
    }

    public TextureMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        getMapFragmentDelegate().mo3864a(context);
        getMapFragmentDelegate().mo3866a(aMapOptions);
    }

    protected af getMapFragmentDelegate() {
        if (this.f11987a == null) {
            this.f11987a = new as(as.f10927d);
        }
        return this.f11987a;
    }

    public AMap getMap() {
        try {
            aa a = getMapFragmentDelegate().mo3861a();
            if (a == null) {
                return null;
            }
            if (this.f11988b == null) {
                this.f11988b = new AMap(a);
            }
            return this.f11988b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().mo3860a(null, null, bundle), new LayoutParams(-1, -1));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().mo3867b();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().mo3869c();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().mo3871e();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().mo3872f();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().mo3868b(bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        getMapFragmentDelegate().mo3862a(i);
    }
}
