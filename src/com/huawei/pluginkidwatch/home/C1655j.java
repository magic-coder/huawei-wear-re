package com.huawei.pluginkidwatch.home;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.LocationData;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatus;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: HomeActivity */
class C1655j implements C1378e {
    final /* synthetic */ boolean f4355a;
    final /* synthetic */ HomeActivity f4356b;

    C1655j(HomeActivity homeActivity, boolean z) {
        this.f4356b = homeActivity;
        this.f4355a = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f4356b.isFinishing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============== getWatchStatus Activity is finished");
            this.f4356b.m7456B();
        } else if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====entity.getWatchStatusInSOS return Success");
            WatchStatusIOModel watchStatusIOModel = (WatchStatusIOModel) baseEntityModel;
            if (watchStatusIOModel.watchStatus == null || watchStatusIOModel.watchStatus.lastLocation == null) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "========== No Position info");
                return;
            }
            WatchStatus watchStatus = watchStatusIOModel.watchStatus;
            LocationData locationData = watchStatus.lastLocation;
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== getWatchStatus getWatchStatusInSOS shareVersion" + C1491k.m6899b(this.f4356b.f4109F, C1462f.m6746j() + "beforeVersion", ""));
            if (!C1491k.m6899b(this.f4356b.f4109F, C1462f.m6746j() + "beforeVersion", "").equals(watchStatus.version)) {
                C1491k.m6897a(this.f4356b.f4109F, C1462f.m6746j() + "beforeVersion", watchStatus.version);
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== getWatchStatus getWatchStatusInSOS KWCache.getDeviceCode()" + C1462f.m6746j());
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== getWatchStatus getWatchStatusInSOS KWCache.DEVICE_VERSION" + C1462f.m6750l());
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== getWatchStatus getWatchStatusInSOS temStatus.version" + watchStatus.version);
            if (!(C1462f.m6750l().equals(watchStatus.version) || this.f4356b.bw == null)) {
                this.f4356b.bw.m7672a(C1462f.m6746j());
            }
            C1462f.m6735e("".equals(watchStatus.version) ? "" : watchStatus.version);
            C1497q.m6941a(this.f4356b.f4109F, "main_map_last_time_of_updata_status", System.currentTimeMillis());
            watchStatus.lastLocation.name = "";
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====mLocationData:" + locationData.toString());
            if (watchStatus.deviceCode != C1492l.m6920d(C1462f.m6746j())) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "==========watchstatus.devicecode!=kwcache.devicecode,return");
            } else if (locationData.lon > 73.0d && locationData.lon < 136.0d && System.currentTimeMillis() - locationData.time < 120000) {
                this.f4356b.m7456B();
                this.f4356b.m7531a(watchStatus, locationData, true);
            } else if (this.f4355a) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "==========getWatchStatusInSOS Time not ok===");
            } else {
                C2538c.m12680e("KIDWATCH_HomeActivity", "==========Time not ok begin getEmergencyLocation===");
                this.f4356b.m7458C();
            }
        } else if (baseEntityModel != null && 13206 == baseEntityModel.retCode) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====您已被删除管理员权限");
            this.f4356b.m7456B();
            this.f4356b.as();
            C1483c.m6824a(this.f4356b.f4109F, C1680l.IDS_plugin_kidwatch_main_no_privalage);
            this.f4356b.m7607l();
        } else if (!C1492l.m6916b(this.f4356b.f4109F)) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====Network ERROR!!");
            this.f4356b.m7456B();
            this.f4356b.m7631x();
            C1483c.m6824a(this.f4356b.f4109F, C1680l.IDS_plugin_kidwatch_common_network_not_stable);
        } else if (this.f4355a) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "===== getWatchStatusInSOS enter esle");
        } else {
            C2538c.m12680e("KIDWATCH_HomeActivity", "===== start getEmergencyLocation");
            this.f4356b.m7458C();
        }
    }
}
