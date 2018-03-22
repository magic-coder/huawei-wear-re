package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.p174c.C2194c;
import java.util.HashMap;

/* compiled from: HomeFragment */
class C2220d implements OnItemClickListener {
    final /* synthetic */ C2217a f8130a;

    C2220d(C2217a c2217a) {
        this.f8130a = c2217a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2194c c2194c;
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Device onItemClick: parent = " + adapterView + ",+view = " + view + ",+position = " + i + "+idLong = " + j);
        synchronized (this.f8130a.aX) {
            c2194c = (C2194c) this.f8130a.al.get(i);
        }
        C2538c.m12661a("MainUI", 1, "HomeFragment", "onItemClick: id = " + c2194c.m11256a());
        switch (c2194c.m11256a()) {
            case 13:
                this.f8130a.m11550e();
                return;
            case 14:
                this.f8130a.f8004M.m10417a(this.f8130a.bu);
                c.a().a(BaseApplication.m2632b(), a.cG.a(), new HashMap(), 0);
                return;
            case 29:
                if (C0977d.m3555e(this.f8130a.f7992A)) {
                    this.f8130a.m11551f();
                    return;
                }
                C2538c.m12661a("MainUI", 0, "HomeFragment", "no net to ID_DEVICE_SETTING_UPDATE_EPHEMERIS");
                this.f8130a.bu.sendEmptyMessage(4);
                return;
            default:
                return;
        }
    }
}
