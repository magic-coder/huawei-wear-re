package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: MainInterators */
class C6757b implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23171a;
    final /* synthetic */ a f23172b;
    final /* synthetic */ C6756a f23173c;

    C6757b(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23173c = c6756a;
        this.f23171a = iBaseResponseCallback;
        this.f23172b = aVar;
    }

    public void onClick(View view) {
        C2538c.c("MainInterators", new Object[]{"showHandleMigrateDialog on click"});
        this.f23171a.onResponse(0, "");
        this.f23172b.dismiss();
    }
}
