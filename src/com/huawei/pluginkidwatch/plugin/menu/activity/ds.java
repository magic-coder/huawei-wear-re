package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.util.Iterator;

/* compiled from: ElectronicFenceActivity */
class ds implements OnClickListener {
    final /* synthetic */ ElectronicFenceActivity f6050a;

    ds(ElectronicFenceActivity electronicFenceActivity) {
        this.f6050a = electronicFenceActivity;
    }

    public void onClick(View view) {
        if (this.f6050a.f5718n == 0) {
            C2538c.m12674b("=============LIST_MODE == m_currentMode", new Object[0]);
            if (this.f6050a.f5708d == null || this.f6050a.f5708d.size() <= 0) {
                C2538c.m12674b("=============No Elec Fence ,So Don't Show The Delete Model====", new Object[0]);
                return;
            } else {
                this.f6050a.m9365f();
                return;
            }
        }
        synchronized (this.f6050a.f5708d) {
            Iterator it = this.f6050a.f5708d.iterator();
            while (it.hasNext()) {
                FenceItem fenceItem = (FenceItem) it.next();
                if (fenceItem.ismIsSelected() && C1492l.m6919c(fenceItem.getmFenceId())) {
                    this.f6050a.f5716l.add(Integer.valueOf(C1492l.m6920d(fenceItem.getmFenceId())));
                }
            }
        }
        if (this.f6050a.f5716l == null || this.f6050a.f5716l.size() == 0) {
            C1483c.m6832c(this.f6050a.getApplicationContext(), this.f6050a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_toast_delte_str));
            return;
        }
        this.f6050a.m9354a(this.f6050a.f5716l);
        this.f6050a.m9367g();
        this.f6050a.m9361d();
    }
}
