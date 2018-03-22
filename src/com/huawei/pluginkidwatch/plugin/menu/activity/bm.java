package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.graphics.BitmapFactory;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.view.ac;

/* compiled from: ContactInfoActivity */
class bm implements C1378e {
    final /* synthetic */ ContactInfoActivity f5971a;

    bm(ContactInfoActivity contactInfoActivity) {
        this.f5971a = contactInfoActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        this.f5971a.f5536I.removeCallbacks(this.f5971a.f5541N);
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            this.f5971a.f5536I.sendEmptyMessage(11);
            C2538c.m12674b("ContactInfoActivity", "==ww==  setInfoToCloud success");
            C1395k a = C1392h.m6269a(this.f5971a, C1462f.m6744i(), C1462f.m6746j());
            C2538c.m12674b("ContactInfoActivity", "deviceInfo = " + a);
            if (a.f3096p != null) {
                C2538c.m12674b("ContactInfoActivity", "deviceInfo.BtMac = " + a.f3096p);
                this.f5971a.f5570t.mo2508a(a.f3096p, C1462f.m6746j());
            }
            C1497q.m6942a(this.f5971a, "diteManger", Boolean.valueOf(true));
            if (!"".equals(this.f5971a.f5549V)) {
                C2538c.m12674b("ContactInfoActivity", "==ww==  contactinfoactivity put bitmap to ImageSaveRead  url= " + this.f5971a.f5549V);
                ac.m7223a(this.f5971a, this.f5971a.f5549V, BitmapFactory.decodeByteArray(this.f5971a.f5534G, 0, this.f5971a.f5534G.length));
            }
        } else if (baseEntityModel == null || 13206 != baseEntityModel.retCode) {
            C2538c.m12674b("ContactInfoActivity", "==ww==  setInfoToCloud fail");
            this.f5971a.f5536I.sendEmptyMessage(56);
        } else {
            C1483c.m6824a(this.f5971a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_edit_no_pri);
            this.f5971a.f5536I.sendEmptyMessage(11);
        }
    }
}
