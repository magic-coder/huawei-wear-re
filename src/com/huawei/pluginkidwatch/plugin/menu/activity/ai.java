package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.CameraUpdateFactory;

/* compiled from: AddFenceActivity */
class ai implements CancelableCallback {
    final /* synthetic */ AddFenceActivity f5929a;

    ai(AddFenceActivity addFenceActivity) {
        this.f5929a = addFenceActivity;
    }

    public void onFinish() {
        this.f5929a.f5446f.animateCamera(CameraUpdateFactory.zoomTo(16.05f), 200, this.f5929a.ag);
    }

    public void onCancel() {
        this.f5929a.f5446f.animateCamera(CameraUpdateFactory.zoomTo(16.05f), 200, this.f5929a.ag);
    }
}
