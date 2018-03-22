package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.graphics.BitmapFactory;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.entity.model.WatchContactModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1391g;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;
import com.huawei.pluginkidwatch.common.ui.view.ac;

/* compiled from: TailorContactActivity */
class gx implements C1378e {
    final /* synthetic */ gw f6170a;

    gx(gw gwVar) {
        this.f6170a = gwVar;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6170a.f6169a.f5877C.removeCallbacks(this.f6170a.f6169a.f5881G);
            C2538c.m12674b("TailorContactActivity", "==ww== tailor model ==  调接口失败");
            C1506g.m6979b();
            if (baseEntityModel != null) {
                if ("".equals(((WatchContactModel) baseEntityModel).retMsg)) {
                    C1483c.m6824a(this.f6170a.f6169a, C1680l.IDS_plugin_kidwatch_common_network_timeout_try);
                    return;
                } else {
                    C1483c.m6824a(this.f6170a.f6169a, C1680l.IDS_plugin_kidwatch_menu_contactmanage_tailor_fail);
                    return;
                }
            }
            return;
        }
        this.f6170a.f6169a.f5877C.removeCallbacks(this.f6170a.f6169a.f5881G);
        C1506g.m6979b();
        C1391g c1391g = new C1391g(this.f6170a.f6169a.getApplicationContext());
        WatchContactModel watchContactModel = (WatchContactModel) baseEntityModel;
        Contact contact = new Contact();
        contact.setName(this.f6170a.f6169a.f5897d.getText().toString());
        contact.setPhoneNum(this.f6170a.f6169a.f5898e.getText().toString());
        contact.setContactId(C1497q.m6948c(this.f6170a.f6169a, "contactid"));
        contact.setType(this.f6170a.f6169a.f5879E);
        if (this.f6170a.f6169a.f5876B == null || "".equals(this.f6170a.f6169a.f5876B)) {
            contact.setBigHeadIcon("");
        } else {
            contact.setBigHeadIcon(this.f6170a.f6169a.f5876B);
        }
        C2538c.m12674b("TailorContactActivity", "setWatchContact success  response :  headicon==" + watchContactModel.retMsg + ", contactID==" + C1497q.m6948c(this.f6170a.f6169a, "contactid"));
        c1391g.m6259a(contact);
        C1395k a = C1392h.m6269a(this.f6170a.f6169a, C1462f.m6744i(), C1462f.m6746j());
        if (!(a == null || a.f3096p == null)) {
            this.f6170a.f6169a.f5903j.mo2508a(a.f3096p, C1462f.m6746j());
        }
        if (!"".equals(this.f6170a.f6169a.f5876B)) {
            ac.m7223a(this.f6170a.f6169a, this.f6170a.f6169a.f5876B, BitmapFactory.decodeByteArray(this.f6170a.f6169a.f5878D, 0, this.f6170a.f6169a.f5878D.length));
        }
        this.f6170a.f6169a.finish();
    }
}
