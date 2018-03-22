package com.huawei.bone.p552b;

import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6767l implements Runnable {
    final /* synthetic */ int f23189a;
    final /* synthetic */ Object f23190b;
    final /* synthetic */ C6766k f23191c;

    C6767l(C6766k c6766k, int i, Object obj) {
        this.f23191c = c6766k;
        this.f23189a = i;
        this.f23190b = obj;
    }

    public void run() {
        if (this.f23189a == 0) {
            String str = (String) this.f23190b;
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid currentUserid 2:" + this.f23191c.f23187a});
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid hwidHuid 2:" + str});
            if (TextUtils.isEmpty(this.f23191c.f23187a) || !this.f23191c.f23187a.equals(str)) {
                this.f23191c.f23188b.m30043b(ak.DIFF_WITH_HWID);
                return;
            }
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid updateTempAccountToAccount 2"});
            this.f23191c.f23188b.m30092f();
            if (this.f23191c.f23188b.m30081a(a.a(BaseApplication.b()).c())) {
                this.f23191c.f23188b.m30083b(this.f23191c.f23188b.f23124g, new C6768m(this));
                return;
            }
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 8"});
            this.f23191c.f23188b.m30102p();
            return;
        }
        this.f23191c.f23188b.m30040b(this.f23189a);
    }
}
