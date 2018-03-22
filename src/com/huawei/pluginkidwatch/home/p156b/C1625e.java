package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatus;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: CheckNewVersionUtils */
class C1625e implements C1378e {
    final /* synthetic */ Context f4224a;
    final /* synthetic */ boolean f4225b;
    final /* synthetic */ C1624d f4226c;

    C1625e(C1624d c1624d, Context context, boolean z) {
        this.f4226c = c1624d;
        this.f4224a = context;
        this.f4225b = z;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== entity.getWatchStatus " + baseEntityModel.retCode);
            WatchStatus watchStatus = ((WatchStatusIOModel) baseEntityModel).watchStatus;
            if (watchStatus == null || watchStatus.version == null || "".equals(watchStatus.version)) {
                if (!this.f4225b) {
                    this.f4226c.m7689a(this.f4226c.f4218q);
                    C1483c.m6824a(this.f4226c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_check_watch_cur_version_fail);
                }
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== getImeiAndCheckNewVersion getWatchStatus KWCache.DEVICE_VERSION=  null");
                return;
            }
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== temStatus " + watchStatus.toString());
            C1462f.m6735e(watchStatus.version);
            C1491k.m6897a(this.f4226c.f4215n, C1462f.m6746j() + "beforeVersion", watchStatus.version);
            C1491k.m6897a(this.f4226c.f4215n, C1462f.m6746j() + "kiwatchUpdateVersion", watchStatus.version);
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== getImeiAndCheckNewVersion getWatchStatus KWCache.DEVICE_VERSION= " + watchStatus.version);
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==shareImei" + this.f4226c.f4211h);
            this.f4226c.f4221v = C1497q.m6945b(this.f4226c.f4215n, C1462f.m6746j() + "IMEI", "");
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==shareImei" + this.f4226c.f4221v);
            if ("".equals(this.f4226c.f4221v) || this.f4226c.f4221v == null) {
                this.f4226c.m7696c(this.f4224a, this.f4225b);
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==have Imei no" + this.f4226c.f4211h);
                return;
            }
            this.f4226c.m7738b(this.f4224a, this.f4225b);
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww==have Imei yes" + this.f4226c.f4211h);
        } else if (!this.f4225b) {
            this.f4226c.m7689a(this.f4226c.f4218q);
            if (!this.f4226c.f4213j) {
                C1483c.m6824a(this.f4226c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_check_watch_cur_version_fail);
            }
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== getImeiAndCheckNewVersion onResponse =null");
        }
    }
}
