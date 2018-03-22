package com.amap.api.mapcore;

import com.amap.api.mapcore.util.ca;

/* compiled from: MapOverlayImageView */
class ax implements Runnable {
    final /* synthetic */ av f10949a;

    ax(av avVar) {
        this.f10949a = avVar;
    }

    public void run() {
        try {
            this.f10949a.f10937a.mo3833p();
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "redrawInfoWindow post");
            th.printStackTrace();
        }
    }
}
