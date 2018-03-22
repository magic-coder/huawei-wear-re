package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.ImportContact;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.plugin.menu.p165a.C1834e;

/* compiled from: ImportContactActivity */
class ew implements OnItemClickListener {
    final /* synthetic */ ImportContactActivity f6104a;

    ew(ImportContactActivity importContactActivity) {
        this.f6104a = importContactActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImportContact importContact = (ImportContact) this.f6104a.f5769l.getItem(i);
        C1497q.m6942a(this.f6104a, "importcontactboolean", Boolean.valueOf(true));
        if (importContact != null) {
            C2538c.m12674b("ImportContactActivity", " ==ww== importContact ==" + importContact.toString());
            C1497q.m6943a(this.f6104a, "importcontactnumber", importContact.getPhoneNum());
            if (!"".equals(importContact.getImgBitmapStr())) {
                C1497q.m6943a(this.f6104a, "importcontactimg", importContact.getImgBitmapStr());
            }
        } else {
            C1497q.m6943a(this.f6104a, "importcontactimg", "");
        }
        C1834e c1834e = new C1834e(view);
        this.f6104a.f5777t = true;
        c1834e.f5272d.setChecked(true);
        this.f6104a.f5769l.m8884a().clear();
        this.f6104a.f5769l.m8884a().put(Integer.valueOf(i), Integer.valueOf(100));
        this.f6104a.f5769l.notifyDataSetChanged();
    }
}
