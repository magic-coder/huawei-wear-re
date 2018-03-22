package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: MainInterators */
class ac implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23141a;
    final /* synthetic */ a f23142b;
    final /* synthetic */ C6756a f23143c;

    ac(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23143c = c6756a;
        this.f23141a = iBaseResponseCallback;
        this.f23142b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"showNetworkErrorDialog on click"});
        this.f23141a.onResponse(0, "");
        this.f23142b.dismiss();
    }
}
