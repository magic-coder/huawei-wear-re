package com.huawei.openalliance.ad.utils.db;

import com.huawei.openalliance.ad.utils.C1345b;
import com.huawei.openalliance.ad.utils.C1364h;
import java.io.File;
import java.util.ArrayList;

class C1358b implements Runnable {
    final /* synthetic */ ArrayList f2944a;
    final /* synthetic */ C1357a f2945b;

    C1358b(C1357a c1357a, ArrayList arrayList) {
        this.f2945b = c1357a;
        this.f2944a = arrayList;
    }

    public void run() {
        String str = C1364h.m6075b(this.f2945b.f2942c) + File.separator + "hiad" + File.separator;
        String str2 = C1364h.m6077c(this.f2945b.f2942c) + File.separator + "hiad" + File.separator;
        C1345b.m5936a(str, this.f2944a);
        C1345b.m5936a(str2, this.f2944a);
    }
}
