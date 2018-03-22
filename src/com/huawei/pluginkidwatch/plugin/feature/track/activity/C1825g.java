package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.amap.api.services.core.LatLonPoint;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.LocationData;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1408x;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import java.util.ArrayList;

/* compiled from: TrackActivity */
class C1825g implements Runnable {
    final /* synthetic */ String f5134a;
    final /* synthetic */ TrackActivity f5135b;

    C1825g(TrackActivity trackActivity, String str) {
        this.f5135b = trackActivity;
        this.f5134a = str;
    }

    public void run() {
        if (this.f5135b.ai) {
            C1408x c1408x = new C1408x();
            c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
            c1408x.f3187a = C1485e.m6866d(this.f5134a);
            this.f5135b.f5115p = c1408x.f3187a;
            C2538c.m12674b("KIDWATCH_TrackActivity", "======getDayTrackData1111=========");
            this.f5135b.f5117r.sendEmptyMessageDelayed(4, 500);
            ArrayList c = C1392h.m6300c(this.f5135b.f5101b, c1408x);
            this.f5135b.f5117r.removeMessages(4);
            C2538c.m12674b("KIDWATCH_TrackActivity", "======getDayTrackData2222=========");
            if (c.size() > 0) {
                for (int i = 0; i < c.size(); i++) {
                    C1408x c1408x2 = (C1408x) c.get(i);
                    LocationData locationData = new LocationData();
                    locationData.time = C1492l.m6922f(c1408x2.f3188b);
                    locationData.lon = c1408x2.f3189c;
                    locationData.lat = c1408x2.f3191e;
                    locationData.name = c1408x2.f3194h;
                    locationData.radius = c1408x2.f3195i;
                    locationData.type = c1408x2.f3196j;
                    locationData.endTime = c1408x2.f3199m;
                    locationData.data1 = c1408x2.f3200n;
                    locationData.data2 = c1408x2.f3201o;
                    if (!this.f5134a.equals(C1485e.m6861c())) {
                        if (c1408x2.f3187a.equals(C1485e.m6866d(this.f5135b.f5105f.getText().toString().trim()))) {
                            this.f5135b.f5079E.add(locationData);
                            this.f5135b.f5080F.add(new LatLonPoint(locationData.lat, locationData.lon));
                        } else {
                            C1506g.m6979b();
                            return;
                        }
                    } else if (locationData.time <= System.currentTimeMillis()) {
                        if (c1408x2.f3187a.equals(C1485e.m6866d(this.f5135b.f5105f.getText().toString().trim()))) {
                            this.f5135b.f5079E.add(locationData);
                            this.f5135b.f5080F.add(new LatLonPoint(locationData.lat, locationData.lon));
                        } else {
                            C1506g.m6979b();
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                this.f5135b.m8700a(1, null);
                return;
            }
            this.f5135b.m8700a(3, c1408x.f3187a);
            return;
        }
        this.f5135b.m8700a(3, C1485e.m6866d(this.f5134a));
    }
}
