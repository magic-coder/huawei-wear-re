package com.huawei.sim.esim.view;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C4713a;
import com.huawei.p190v.C2538c;
import com.huawei.p464l.p465a.C5417c;

import java.util.HashMap;

/* compiled from: WirelessManagerAcitivity */
class an implements OnClickListener {
    final /* synthetic */ WirelessManagerAcitivity f20435a;

    an(WirelessManagerAcitivity wirelessManagerAcitivity) {
        this.f20435a = wirelessManagerAcitivity;
    }

    public void onClick(View view) {
        C2538c.c("WirelessManagerAcitivity", new Object[]{"onclick multisim"});
        C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.MULTISIM_1170001.m22567a(), new HashMap(), 0);
        if (this.f20435a.m27261a()) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName("com.huawei.hwmultisim", "com.huawei.hwmultisim.views.IntroduceActivity"));
                this.f20435a.startActivity(intent);
                return;
            } catch (Exception e) {
                C2538c.e("WirelessManagerAcitivity", new Object[]{"can not start multisim apk"});
                this.f20435a.m27260d();
                return;
            }
        }
        this.f20435a.m27260d();
    }
}
