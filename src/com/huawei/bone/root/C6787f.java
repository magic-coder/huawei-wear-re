package com.huawei.bone.root;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.hihealth.c.be;
import com.huawei.hwdatamigrate.hihealth.c.bf;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MainActivity */
class C6787f implements Runnable {
    final /* synthetic */ MainActivity f23325a;

    C6787f(MainActivity mainActivity) {
        this.f23325a = mainActivity;
    }

    public void run() {
        ArrayList b = be.a().b(a.a(BaseApplication.b()).c());
        if (b == null || b.size() <= 0) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"Enter checkMigrageNotice no data"});
            return;
        }
        Iterator it = b.iterator();
        while (it.hasNext()) {
            bf bfVar = (bf) it.next();
            be.a().a(bfVar.a(), bfVar.b());
        }
        this.f23325a.f23221l.sendEmptyMessage(101);
    }
}
