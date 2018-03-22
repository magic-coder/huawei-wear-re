package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.homewear21.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HomeFragment */
class C2242z implements OnClickListener {
    final /* synthetic */ C2217a f8158a;

    C2242z(C2217a c2217a) {
        this.f8158a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12674b("HomeFragment", "showLoginFail ok click");
        this.f8158a.aq.dismiss();
        this.f8158a.aq = null;
        this.f8158a.m11507e(i.IDS_settings_restore_factory_settings_progerssdialog_msg);
        this.f8158a.f8004M.m10425b(this.f8158a.bu);
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        c.a().a(BaseApplication.m2632b(), a.cG.a(), hashMap, 0);
    }
}
