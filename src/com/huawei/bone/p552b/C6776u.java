package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6776u implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23200a;
    final /* synthetic */ a f23201b;
    final /* synthetic */ C6756a f23202c;

    C6776u(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23202c = c6756a;
        this.f23200a = iBaseResponseCallback;
        this.f23201b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"showAPPOuttimeDialog on click"});
        this.f23200a.onResponse(0, "");
        this.f23201b.dismiss();
    }
}
