package com.huawei.sim.multisim;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C4713a;
import com.huawei.p190v.C2538c;
import com.huawei.p464l.p465a.C5417c;

import java.util.HashMap;

/* compiled from: MultiSimConfigActivity */
class C5958i implements OnClickListener {
    final /* synthetic */ MultiSimConfigActivity f20531a;

    C5958i(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20531a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"user choose unbind"});
        this.f20531a.af.dismiss();
        this.f20531a.af = null;
        C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.MULTISIM_1170005.m22567a(), new HashMap(), 0);
        this.f20531a.m27280N();
    }
}
