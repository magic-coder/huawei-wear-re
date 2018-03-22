package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class ad implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23144a;
    final /* synthetic */ a f23145b;
    final /* synthetic */ C6756a f23146c;

    ad(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23146c = c6756a;
        this.f23144a = iBaseResponseCallback;
        this.f23145b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"showNetworkInviableDialog on click"});
        this.f23144a.onResponse(0, "");
        this.f23145b.dismiss();
    }
}
