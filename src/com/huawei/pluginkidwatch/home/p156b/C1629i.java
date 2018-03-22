package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.hwversionmgr.p079a.C1067b;
import com.huawei.hwversionmgr.utils.p083a.C1074a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: CheckNewVersionUtils */
class C1629i extends C1074a {
    final /* synthetic */ boolean f4232a;
    final /* synthetic */ Context f4233b;
    final /* synthetic */ C1624d f4234c;

    C1629i(C1624d c1624d, boolean z, Context context) {
        this.f4234c = c1624d;
        this.f4232a = z;
        this.f4233b = context;
    }

    public void mo2345a(int i) {
        this.f4234c.mo2556a(false);
        C1497q.m6942a(this.f4234c.f4215n, C1462f.m6746j(), Boolean.valueOf(false));
        switch (i) {
            case 0:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== handleCheckFailed  FAILED_REASON_NOTFOUND==" + i);
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== handleCheckFailed  FAILED_REASON_NOTFOUND + KWCache.DEVICE_VERSION==" + C1462f.m6750l());
                if (!(C1462f.m6750l() == null || "".equals(C1462f.m6750l()))) {
                    this.f4234c.mo2557a(false, -1, null, this.f4234c.m7745h());
                }
                if (!this.f4232a) {
                    this.f4234c.m7689a(this.f4234c.f4218q);
                    if (!this.f4234c.f4213j) {
                        C1483c.m6824a(this.f4234c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_already_new);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== handleCheckFailed FAILED_REASON_NETWORK= = " + i);
                if (!this.f4232a) {
                    this.f4234c.m7689a(this.f4234c.f4218q);
                    if (!this.f4234c.f4213j) {
                        C1483c.m6824a(this.f4234c.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_check_new_version_failed);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo2346a(C1067b c1067b) {
        if (c1067b != null) {
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== handleCheckSuccess arg0==" + c1067b.toString());
            C1497q.m6942a(this.f4234c.f4215n, C1462f.m6746j(), Boolean.valueOf(true));
            this.f4234c.f4207d = c1067b.f2100d + "/full/" + c1067b.f2113q;
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== downLoadUrl==" + this.f4234c.f4207d);
            this.f4234c.f4206c = (int) c1067b.f2106j;
            this.f4234c.f4205b = c1067b.f2110n;
            this.f4234c.f4208e = c1067b.f2098b;
            this.f4234c.f4209f = c1067b.f2109m;
            C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== get Force ruleAttr==" + c1067b.f2121y);
            C1491k.m6897a(this.f4234c.f4215n, C1462f.m6746j() + "ruleAttr", c1067b.f2121y);
            if (!this.f4234c.f4213j) {
                this.f4234c.m7681a(this.f4233b);
            }
        }
    }
}
