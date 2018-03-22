package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1408x;

/* compiled from: TrackActivity */
class C1826h implements OnGeocodeSearchListener {
    final /* synthetic */ TrackActivity f5136a;

    C1826h(TrackActivity trackActivity) {
        this.f5136a = trackActivity;
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        C2538c.m12674b("KIDWATCH_TrackActivity", "==================onRegeocodeSearched rCode:", i + "");
        if (this.f5136a.isFinishing()) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=====TrackActivity 已被销毁，不再更新其UI(etAddress) ");
        } else if (i == 0 && regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null && regeocodeResult.getRegeocodeAddress().getFormatAddress() != null) {
            Object obj;
            String str = "";
            LatLonPoint point = regeocodeResult.getRegeocodeQuery().getPoint();
            try {
                String str2 = ((str + regeocodeResult.getRegeocodeAddress().getCity()) + regeocodeResult.getRegeocodeAddress().getTownship()) + ((RegeocodeRoad) regeocodeResult.getRegeocodeAddress().getRoads().get(0)).getName();
                this.f5136a.f5088N = str2;
                this.f5136a.f5089O = ((PoiItem) regeocodeResult.getRegeocodeAddress().getPois().get(0)).toString();
                obj = str2;
            } catch (Exception e) {
                Exception exception = e;
                str = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                this.f5136a.f5089O = str;
                if (this.f5136a.f5089O == null || "null".equals(this.f5136a.f5089O)) {
                    this.f5136a.f5089O = "";
                }
                C2538c.m12680e("KIDWATCH_TrackActivity", "Exception e = " + exception.getMessage());
            }
            if (!"".equals(obj) && !"".equals(this.f5136a.f5089O.trim()) && this.f5136a.f5090P.lat == point.getLatitude() && this.f5136a.f5090P.lon == point.getLongitude()) {
                if (this.f5136a.ai) {
                    m8795a();
                }
                this.f5136a.m8745d(this.f5136a.f5090P);
            }
        }
    }

    private void m8795a() {
        C1408x c1408x = new C1408x();
        c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
        c1408x.f3187a = this.f5136a.f5115p;
        c1408x.f3188b = String.valueOf(this.f5136a.f5090P.time);
        c1408x.f3189c = this.f5136a.f5090P.lon;
        c1408x.f3191e = this.f5136a.f5090P.lat;
        c1408x.f3194h = this.f5136a.f5090P.name;
        c1408x.f3195i = this.f5136a.f5090P.radius;
        c1408x.f3197k = this.f5136a.f5089O;
        c1408x.f3198l = this.f5136a.f5088N;
        c1408x.f3196j = this.f5136a.f5090P.type;
        c1408x.f3199m = this.f5136a.f5090P.endTime;
        c1408x.f3200n = this.f5136a.f5090P.data1;
        c1408x.f3201o = this.f5136a.f5090P.data2;
        C1392h.m6267a(this.f5136a.f5101b, c1408x);
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }
}
