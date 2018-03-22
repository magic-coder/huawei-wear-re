package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContactsListActivity */
class ce implements OnClickListener {
    final /* synthetic */ cd f5994a;

    ce(cd cdVar) {
        this.f5994a = cdVar;
    }

    public void onClick(View view) {
        Map hashMap = new HashMap();
        hashMap.put("made", "2");
        c.a().a(BaseApplication.m2632b(), a.ab.a(), hashMap, 0);
        this.f5994a.f5993a.startActivity(new Intent(this.f5994a.f5993a, TailorContactActivity.class));
        C1497q.m6943a(this.f5994a.f5993a, "contactname", this.f5994a.f5993a.f5583G.getName());
        C1497q.m6943a(this.f5994a.f5993a, "contactphonenumber", this.f5994a.f5993a.f5583G.getPhoneNum());
        C1497q.m6943a(this.f5994a.f5993a, "contactpicurl", this.f5994a.f5993a.f5583G.getBigHeadIcon());
        C1497q.m6947b(this.f5994a.f5993a, "contactid", this.f5994a.f5993a.f5583G.getContactId());
        C1497q.m6943a(this.f5994a.f5993a, "contactheadcion", this.f5994a.f5993a.f5583G.getBigHeadIcon());
        C1497q.m6943a(this.f5994a.f5993a, "pictype", this.f5994a.f5993a.f5583G.type);
        this.f5994a.f5993a.m9210a(this.f5994a.f5993a.f5577A);
    }
}
