package com.huawei.bone.p552b;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6778w implements Runnable {
    final /* synthetic */ int f23204a;
    final /* synthetic */ Object f23205b;
    final /* synthetic */ C6756a f23206c;

    C6778w(C6756a c6756a, int i, Object obj) {
        this.f23206c = c6756a;
        this.f23204a = i;
        this.f23205b = obj;
    }

    public void run() {
        if (this.f23204a == 0) {
            C2538c.b("MainInterators", new Object[]{"notLoginProcess ->login hwid success"});
            if (this.f23206c.m30081a(a.a(BaseApplication.b()).c())) {
                this.f23206c.m30083b(this.f23206c.f23124g, new C6779x(this));
            } else {
                C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 11"});
                this.f23206c.m30102p();
            }
            com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "true", new com.huawei.hwdataaccessmodel.a.c(0));
            com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f23206c.f23124g, String.valueOf(20007), "migrate_provide_login_infomation", "migrate_not_support", new com.huawei.hwdataaccessmodel.a.c(0));
            return;
        }
        C2538c.c("MainInterators", new Object[]{"goToLoginActivity error:" + this.f23205b + "  err_code:" + this.f23204a});
        this.f23206c.m30046c(this.f23204a);
    }
}
