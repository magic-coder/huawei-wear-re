package com.huawei.pluginkidwatch.home;

import com.huawei.hwid.core.constants.HwAccountConstants;
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
import com.huawei.pluginkidwatch.home.p156b.C1638r;

/* compiled from: HomeActivity */
class C1654i implements C1378e {
    final /* synthetic */ boolean f4351a;
    final /* synthetic */ boolean f4352b;
    final /* synthetic */ boolean f4353c;
    final /* synthetic */ HomeActivity f4354d;

    C1654i(HomeActivity homeActivity, boolean z, boolean z2, boolean z3) {
        this.f4354d = homeActivity;
        this.f4351a = z;
        this.f4352b = z2;
        this.f4353c = z3;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f4354d.isFinishing()) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "============== getWatchStatus Activity is finished");
            return;
        }
        this.f4354d.f4131c.removeCallbacks(this.f4354d.cl);
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====entity.getWatchStatus return Success");
            WatchStatusIOModel watchStatusIOModel = (WatchStatusIOModel) baseEntityModel;
            if (watchStatusIOModel.watchStatus == null || watchStatusIOModel.watchStatus.lastLocation == null) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "========== No Position info");
                return;
            }
            WatchStatus watchStatus = watchStatusIOModel.watchStatus;
            LocationData locationData = watchStatus.lastLocation;
            if (!(C1462f.m6750l().equals(watchStatus.version) || this.f4354d.bw == null)) {
                this.f4354d.bw.m7672a(C1462f.m6746j());
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== getWatchStatus shareVersion" + C1491k.m6899b(this.f4354d.f4109F, C1462f.m6746j() + "beforeVersion", ""));
            if (!C1491k.m6899b(this.f4354d.f4109F, C1462f.m6746j() + "beforeVersion", "").equals(watchStatus.version)) {
                C1491k.m6897a(this.f4354d.f4109F, C1462f.m6746j() + "beforeVersion", watchStatus.version);
            }
            if (this.f4354d.f4132d != null && this.f4354d.f4132d.isAdded()) {
                if (C1638r.m7766d() != null) {
                    this.f4354d.f4132d.f4298d.setVisibility(0);
                } else {
                    this.f4354d.f4132d.f4298d.setVisibility(8);
                }
                C2538c.m12674b("KIDWATCH_HomeActivity", "===www=========== CheckUpdateVersionFactory.getVersionMsg()" + C1638r.m7766d());
                this.f4354d.f4132d.f4298d.setText(C1638r.m7766d());
            }
            this.f4354d.m7645g();
            C1462f.m6735e("".equals(watchStatus.version) ? "" : watchStatus.version);
            C1497q.m6941a(this.f4354d.f4109F, "main_map_last_time_of_updata_status", System.currentTimeMillis());
            watchStatus.lastLocation.name = "";
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====mLocationData:" + locationData.toString());
            if (watchStatus.deviceCode != C1492l.m6920d(C1462f.m6746j())) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "==========watchstatus.devicecode!=kwcache.devicecode,return");
                return;
            }
            if (locationData.lon <= 73.0d || locationData.lon >= 136.0d) {
                C2538c.m12680e("KIDWATCH_HomeActivity", "==========Not In China===");
                this.f4354d.m7583d(this.f4352b);
            } else {
                this.f4354d.m7531a(watchStatus, locationData, this.f4351a);
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====getWatchStatus mUpdateInteractors getOnKidwatchHomeAppUpdateState is :" + this.f4354d.cb.m11743k());
            if (!this.f4353c) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=====getWatchStatus isForceUpdateChangeDevice : " + this.f4353c + " checkNewVersionOrForceUpdate!");
                C1638r.m7757a(this.f4354d.f4109F);
                if (this.f4354d.f4131c != null) {
                    this.f4354d.f4131c.sendEmptyMessageDelayed(10060, 3000);
                }
            }
        } else if (baseEntityModel == null || 13206 != baseEntityModel.retCode) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====entity.getWatchStatus return error");
            this.f4354d.m7585e(this.f4352b);
            C2538c.m12674b("KIDWATCH_HomeActivity", "==www=== checkWatchNewVersion()====getSwatchStatusFailed1");
        } else {
            C2538c.m12680e("KIDWATCH_HomeActivity", "=====您已被删除管理员权限");
            C1483c.m6824a(this.f4354d.f4109F, C1680l.IDS_plugin_kidwatch_main_no_privalage);
            this.f4354d.m7607l();
        }
        if (!this.f4352b && this.f4351a) {
            this.f4354d.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }
        this.f4354d.f4131c.removeCallbacks(this.f4354d.cl);
    }
}
