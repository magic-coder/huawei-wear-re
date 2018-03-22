package com.huawei.bone.p552b;

import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6763h implements Runnable {
    final /* synthetic */ int f23182a;
    final /* synthetic */ Object f23183b;
    final /* synthetic */ C6762g f23184c;

    C6763h(C6762g c6762g, int i, Object obj) {
        this.f23184c = c6762g;
        this.f23182a = i;
        this.f23183b = obj;
    }

    public void run() {
        if (this.f23182a == 0) {
            String str = (String) this.f23183b;
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid currentUserid:" + this.f23184c.f23181a.f23179b});
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid hwidHuid:" + str});
            if (TextUtils.isEmpty(this.f23184c.f23181a.f23179b) || !str.equals(this.f23184c.f23181a.f23179b)) {
                this.f23184c.f23181a.f23180c.f23177a.m30043b(ak.DIFF_WITH_HWID);
                return;
            }
            C2538c.b("MainInterators", new Object[]{"getHuidInHwid updateTempAccountToAccount"});
            this.f23184c.f23181a.f23180c.f23177a.m30092f();
            if (this.f23184c.f23181a.f23180c.f23177a.m30081a(a.a(BaseApplication.b()).c())) {
                this.f23184c.f23181a.f23180c.f23177a.m30083b(this.f23184c.f23181a.f23180c.f23177a.f23124g, new C6764i(this));
                return;
            }
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 5"});
            this.f23184c.f23181a.f23180c.f23177a.m30102p();
        } else if (190110 == this.f23182a) {
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess NO_NEED_LOGIN 11"});
            this.f23184c.f23181a.f23180c.f23177a.m30102p();
        } else if (35 == this.f23182a) {
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 请升级 2"});
            C6756a c6756a = this.f23184c.f23181a.f23180c.f23177a;
            c6756a.f23123e++;
            this.f23184c.f23181a.f23180c.f23177a.f23122d = true;
        } else if (40 == this.f23182a) {
            C2538c.c("MainInterators", new Object[]{"BIND_SERVICE_SYSTEM_ERROR."});
            this.f23184c.f23181a.f23180c.f23177a.m30071x();
        } else if (3002 == this.f23182a) {
            C2538c.c("MainInterators", new Object[]{"ERROR_OPER_CANCEL."});
            this.f23184c.f23181a.f23180c.f23177a.f23126i.finish();
        } else {
            C2538c.e("MainInterators", new Object[]{"ERROR getHuidInHwid 1"});
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 6"});
            this.f23184c.f23181a.f23180c.f23177a.m30102p();
        }
    }
}
