package com.huawei.bone.p552b;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: MainInterators */
class ag implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23156a;
    final /* synthetic */ a f23157b;
    final /* synthetic */ C6756a f23158c;

    ag(C6756a c6756a, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23158c = c6756a;
        this.f23156a = iBaseResponseCallback;
        this.f23157b = aVar;
    }

    public void onClick(View view) {
        this.f23156a.onResponse(0, "");
        this.f23157b.dismiss();
    }
}
