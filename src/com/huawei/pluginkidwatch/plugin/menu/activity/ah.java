package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.inputmethod.InputMethodManager;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: AddFenceActivity */
class ah implements OnMapClickListener {
    final /* synthetic */ AddFenceActivity f5928a;

    ah(AddFenceActivity addFenceActivity) {
        this.f5928a = addFenceActivity;
    }

    public void onMapClick(LatLng latLng) {
        this.f5928a.f5453m.clearFocus();
        this.f5928a.f5462v = latLng;
        this.f5928a.m9024a(this.f5928a.f5462v, 800, false);
        LatLng i = this.f5928a.f5462v;
        this.f5928a.m9025a(new LatLonPoint(i.latitude, i.longitude));
        this.f5928a.f5457q.clearFocus();
        this.f5928a.f5453m.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f5928a.getSystemService("input_method");
        if (this.f5928a.getCurrentFocus() != null && this.f5928a.getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f5928a.getCurrentFocus().getWindowToken(), 2);
            this.f5928a.f5457q.clearFocus();
            this.f5928a.f5453m.clearFocus();
        }
    }
}
