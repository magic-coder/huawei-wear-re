package com.huawei.bone.root;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.up.b.a;

/* compiled from: SplashActivity */
class an implements a {
    final /* synthetic */ am f23312a;

    an(am amVar) {
        this.f23312a = amVar;
    }

    public void m30204a(Bundle bundle) {
        if (bundle != null) {
            Object string = bundle.getString("userID", "");
            C2538c.b("SplashActivity", new Object[]{"huid = " + string});
            if (!TextUtils.isEmpty(string)) {
                com.huawei.login.ui.login.a.a(BaseApplication.b()).a(string);
            }
        }
    }

    public void m30203a(int i) {
    }
}
