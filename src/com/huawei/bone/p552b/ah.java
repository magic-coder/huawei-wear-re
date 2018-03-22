package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class ah implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23159a;
    final /* synthetic */ a f23160b;
    final /* synthetic */ C6756a f23161c;

    ah(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23161c = c6756a;
        this.f23159a = iBaseResponseCallback;
        this.f23160b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"cancel click"});
        this.f23159a.onResponse(-1, "");
        this.f23160b.dismiss();
    }
}
