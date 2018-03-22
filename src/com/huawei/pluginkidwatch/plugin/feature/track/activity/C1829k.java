package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.amap.api.services.core.LatLonPoint;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import java.util.TimerTask;

/* compiled from: TrackActivity */
class C1829k extends TimerTask {
    final /* synthetic */ TrackActivity f5144a;

    private C1829k(TrackActivity trackActivity) {
        this.f5144a = trackActivity;
    }

    public void run() {
        C2538c.m12674b("KIDWATCH_TrackActivity", "TrivingTimerTask is enter!");
        C1506g.m6979b();
        this.f5144a.ar = false;
        int size = this.f5144a.f5081G.size();
        int i = 0;
        while (i < size) {
            LatLonPoint latLonPoint = (LatLonPoint) this.f5144a.f5081G.get(i);
            if (!(this.f5144a.f5083I.contains(latLonPoint) || this.f5144a.f5082H == null || this.f5144a.f5082H.size() <= i)) {
                C2538c.m12674b("KIDWATCH_TrackActivity", "TrivingTimerTask is enter startPoint = " + latLonPoint.toString() + ",endPoint = " + ((LatLonPoint) this.f5144a.f5082H.get(i)).toString());
                this.f5144a.m8744d(latLonPoint, r1);
            }
            i++;
        }
    }
}
