package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: AddFenceActivity */
class ad implements OnGeocodeSearchListener {
    final /* synthetic */ AddFenceActivity f5924a;

    ad(AddFenceActivity addFenceActivity) {
        this.f5924a = addFenceActivity;
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        C2538c.m12674b("AddFenceActivity", "==================onRegeocodeSearched rCode:", i + "");
        if (this.f5924a.isFinishing()) {
            C2538c.m12674b("AddFenceActivity", "=====AddFenceActivity 已被销毁，不再更新其UI(etAddress) ");
            return;
        }
        if (i != 0) {
            C2538c.m12674b("AddFenceActivity", "===== 定位失败 ，地理编码失败 ");
        } else if (regeocodeResult == null || regeocodeResult.getRegeocodeAddress() == null || regeocodeResult.getRegeocodeAddress().getFormatAddress() == null) {
            this.f5924a.f5453m.setText("");
            C1483c.m6832c(this.f5924a, this.f5924a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_alert_no_result));
        } else {
            CharSequence charSequence;
            try {
                charSequence = ((("" + regeocodeResult.getRegeocodeAddress().getDistrict()) + regeocodeResult.getRegeocodeAddress().getTownship()) + ((RegeocodeRoad) regeocodeResult.getRegeocodeAddress().getRoads().get(0)).getName()) + ((PoiItem) regeocodeResult.getRegeocodeAddress().getPois().get(0)).toString();
                this.f5924a.f5456p = true;
            } catch (Exception e) {
                Exception exception = e;
                charSequence = regeocodeResult.getRegeocodeAddress().getFormatAddress();
                C2538c.m12680e("AddFenceActivity", "Exception e = " + exception.getMessage());
            }
            if (!"".equals(charSequence)) {
                this.f5924a.f5453m.setText(charSequence);
            }
        }
        if (this.f5924a.f5443c) {
            this.f5924a.f5443c = false;
        }
        if (this.f5924a.f5444d) {
            this.f5924a.f5444d = false;
        }
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }
}
