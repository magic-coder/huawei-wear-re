package com.huawei.ui.main.stories.p177a.p178a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.af.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.a.a.c;

/* compiled from: UserProfileInteractors */
public class C2278b {
    private Context f8270a = BaseApplication.m2632b();
    private String f8271b = "";

    public boolean m11721a() {
        Object a = C0996a.m3612a(this.f8270a, String.valueOf(10009), "key_auto_update_switch");
        C2538c.m12677c("UserProfileInteractors", "getWLANAutoUpdate get auto ota checkbox status value = " + a);
        if (TextUtils.isEmpty(a) || !a.equalsIgnoreCase("1")) {
            return false;
        }
        return true;
    }

    public void m11720a(boolean z) {
        this.f8271b = z ? "1" : "2";
        C2538c.m12677c("UserProfileInteractors", "setWLANAutoUpdate enter state = " + z + ", mAutoUpdateSwitch = " + this.f8271b);
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(this.f8270a, String.valueOf(10009), "key_auto_update_switch", this.f8271b, c0993c);
        new c(this).start();
        a a = a.a(this.f8270a);
        if (a == null) {
            C2538c.m12680e("UserProfileInteractors", "mHwCombineMigrateMgr is null");
        } else {
            a.f(this.f8271b, false);
        }
    }
}
