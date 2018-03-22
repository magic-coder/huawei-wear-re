package com.huawei.pluginkidwatch.home;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;

/* compiled from: HomeActivity */
class ag implements OnGeocodeSearchListener {
    final /* synthetic */ String f4169a;
    final /* synthetic */ HomeActivity f4170b;

    ag(HomeActivity homeActivity, String str) {
        this.f4170b = homeActivity;
        this.f4169a = str;
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "==========onRegeocodeSearched rCode:", i + "");
        if (this.f4170b.isFinishing()) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====HomeActivity is finished ");
        } else if (!this.f4169a.equals(C1462f.m6746j())) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "========= getAddress 的回调结果不属于当前所查看的手表，舍弃 ");
        } else if (i == 0 && regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null && regeocodeResult.getRegeocodeAddress().getFormatAddress() != null) {
            String str;
            try {
                String str2 = (("" + regeocodeResult.getRegeocodeAddress().getCity()) + regeocodeResult.getRegeocodeAddress().getTownship()) + ((RegeocodeRoad) regeocodeResult.getRegeocodeAddress().getRoads().get(0)).getName();
                C2538c.m12674b("KIDWATCH_HomeActivity", "==========addressName", str2);
                this.f4170b.aO = str2;
                this.f4170b.aP = ((PoiItem) regeocodeResult.getRegeocodeAddress().getPois().get(0)).toString();
                str = str2;
            } catch (Exception e) {
                Exception exception = e;
                this.f4170b.aP = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                this.f4170b.aO = "";
                str = "";
                if (this.f4170b.aP == null || "null".equals(this.f4170b.aP)) {
                    this.f4170b.aP = "";
                }
                C2538c.m12680e("KIDWATCH_HomeActivity", "Exception e = " + exception.getMessage());
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========Code Result addressName：", str + "");
            C2538c.m12674b("KIDWATCH_HomeActivity", "===========Code Result buildNameText：", this.f4170b.aP);
            if (!"".equals(this.f4170b.aP.trim())) {
                this.f4170b.m7490S();
                this.f4170b.ai();
            }
        }
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }
}
