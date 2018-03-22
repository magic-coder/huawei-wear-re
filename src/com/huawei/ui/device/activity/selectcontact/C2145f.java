package com.huawei.ui.device.activity.selectcontact;

import com.huawei.hwcommonmodel.d.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.device.i;

/* compiled from: ContactMainActivity */
class C2145f extends c {
    final /* synthetic */ ContactMainActivity f7605a;

    C2145f(ContactMainActivity contactMainActivity) {
        this.f7605a = contactMainActivity;
    }

    public void m11041a() {
        C2538c.m12677c("ContactMainActivity", "onGranted()");
        this.f7605a.m11014l();
    }

    public void m11042a(String str) {
        C2538c.m12680e("ContactMainActivity", "onDenied()");
        a.b(this.f7605a.f7568c, i.IDS_contact_have_no_permission_to_read);
    }
}
