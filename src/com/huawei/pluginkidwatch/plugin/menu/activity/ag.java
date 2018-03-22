package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: AddFenceActivity */
class ag implements OnCameraChangeListener {
    final /* synthetic */ AddFenceActivity f5927a;

    ag(AddFenceActivity addFenceActivity) {
        this.f5927a = addFenceActivity;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (!this.f5927a.f5443c) {
            this.f5927a.f5443c = true;
        }
        this.f5927a.f5462v = cameraPosition.target;
        if (this.f5927a.f5450j != null) {
            this.f5927a.f5450j.setPosition(cameraPosition.target);
        }
        if (this.f5927a.f5464x != null) {
            this.f5927a.f5464x.setCenter(cameraPosition.target);
        }
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        this.f5927a.m9023a(cameraPosition.target);
    }
}
