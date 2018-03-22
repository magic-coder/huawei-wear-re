package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class af implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23153a;
    final /* synthetic */ a f23154b;
    final /* synthetic */ C6756a f23155c;

    af(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23155c = c6756a;
        this.f23153a = iBaseResponseCallback;
        this.f23154b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"cancel click"});
        this.f23153a.onResponse(-1, "");
        this.f23154b.dismiss();
        this.f23155c.f23134q = false;
    }
}
