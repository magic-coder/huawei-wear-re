package com.huawei.ui.homewear21.p175a;

import android.app.Activity;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class ba implements IBaseResponseCallback {
    final /* synthetic */ az f8072a;

    ba(az azVar) {
        this.f8072a = azVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter overabroadcheckGoHealthForBind err_code:" + i);
        if (i == 0 && obj != null && (obj instanceof String)) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter overabroadcheckGoHealthForBind objData:" + obj);
            String str = "";
            if (String.valueOf(true).equals((String) obj)) {
                C0996a.m3611a(this.f8072a.f8069a.f8041z, String.valueOf(10000), "homefragment_time_of_show_goto_health", System.currentTimeMillis() + "", new C0993c());
                Activity activity = this.f8072a.f8069a.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new bb(this));
                }
            }
        }
    }
}
