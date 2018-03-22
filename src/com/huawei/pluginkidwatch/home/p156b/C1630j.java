package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.hwversionmgr.utils.p083a.C1076c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import java.util.List;

/* compiled from: CheckNewVersionUtils */
class C1630j extends C1076c {
    final /* synthetic */ Context f4235a;
    final /* synthetic */ C1624d f4236b;

    C1630j(C1624d c1624d, Context context) {
        this.f4236b = c1624d;
        this.f4235a = context;
    }

    public void mo2348a(List<C1070g> list) {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== get fetchChangeLog = success");
        this.f4236b.m7682a(this.f4235a, (List) list);
        C1491k.m6896a(this.f4236b.f4215n, C1462f.m6746j() + "isHaveChangeLog", Boolean.valueOf(true));
        this.f4236b.m7741d();
        this.f4236b.m7689a(this.f4236b.f4218q);
    }

    public void mo2347a() {
        C2538c.m12674b("KIDWATCH_CheckNewVersionUtils", "==ww== get fetchChangeLog = failed");
        this.f4236b.m7689a(this.f4236b.f4218q);
        C1483c.m6824a(this.f4236b.f4215n, C1680l.IDS_plugin_kidwatch_menu_update_failed);
        this.f4236b.mo2556a(false);
        if (C1462f.m6750l() != null && !"".equals(C1462f.m6750l())) {
            this.f4236b.mo2557a(false, -1, null, this.f4236b.m7745h());
        }
    }
}
