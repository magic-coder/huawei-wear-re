package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.CameraUpdateFactory;

/* compiled from: AddFenceActivity */
class aj implements CancelableCallback {
    final /* synthetic */ AddFenceActivity f5930a;

    aj(AddFenceActivity addFenceActivity) {
        this.f5930a = addFenceActivity;
    }

    public void onFinish() {
        this.f5930a.f5446f.animateCamera(CameraUpdateFactory.zoomTo(16.0f), 100, this.f5930a.ah);
    }

    public void onCancel() {
        this.f5930a.f5446f.animateCamera(CameraUpdateFactory.zoomTo(16.0f), 100, this.f5930a.ah);
    }
}
