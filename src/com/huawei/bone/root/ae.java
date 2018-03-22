package com.huawei.bone.root;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ab.m;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwdatamigrate.common.b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: ServiceAreaActivity */
class ae implements OnClickListener {
    final /* synthetic */ ServiceAreaActivity f23299a;

    ae(ServiceAreaActivity serviceAreaActivity) {
        this.f23299a = serviceAreaActivity;
    }

    public void onClick(View view) {
        C2538c.c("ServiceAreaActivity", new Object[]{"startBtn setOnClickListener strCountryName = " + r0 + "  strCountry = " + b.h(this.f23299a.f23267a.getText().toString())});
        if (d.b(BaseApplication.b(), b.h(this.f23299a.f23267a.getText().toString()))) {
            m.a(BaseApplication.b()).b("1");
            C2538c.c("ServiceAreaActivity", new Object[]{"judgeIfInAccountArea HWUserProfileMgr.ACCOUNT_AREA !"});
        } else {
            m.a(BaseApplication.b()).b("2");
            C2538c.c("ServiceAreaActivity", new Object[]{"judgeIfInAccountArea HWUserProfileMgr.NO_ACCOUNT_AREA !"});
        }
        if (!this.f23299a.f23270d) {
            Intent intent = new Intent();
            intent.setClass(BaseApplication.b(), SplashActivity.class);
            intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
            this.f23299a.startActivity(intent);
        }
        this.f23299a.finish();
    }
}
