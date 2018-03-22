package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class bc implements OnClickListener {
    final /* synthetic */ HomeActivity f4267a;

    bc(HomeActivity homeActivity) {
        this.f4267a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int b = C1093a.m4739a(BaseApplication.m2632b()).m4749b();
        C2538c.m12674b("KIDWATCH_HomeActivity", "showAppReLoginDialog... setPositiveButton... loginType = ", Integer.valueOf(b));
        Intent intent = new Intent();
        intent.setClassName(this.f4267a.f4109F, "com.huawei.bone.root.SplashActivity");
        intent.setPackage(this.f4267a.f4109F.getPackageName());
        intent.addFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        this.f4267a.f4109F.startActivity(intent);
    }
}
