package com.huawei.bone.p552b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: MainInterators */
class ae implements OnClickListener {
    final /* synthetic */ ak f23147a;
    final /* synthetic */ MergeUserAllDataReq f23148b;
    final /* synthetic */ Context f23149c;
    final /* synthetic */ IBaseResponseCallback f23150d;
    final /* synthetic */ a f23151e;
    final /* synthetic */ C6756a f23152f;

    ae(C6756a c6756a, ak akVar, MergeUserAllDataReq mergeUserAllDataReq, Context context, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23152f = c6756a;
        this.f23147a = akVar;
        this.f23148b = mergeUserAllDataReq;
        this.f23149c = context;
        this.f23150d = iBaseResponseCallback;
        this.f23151e = aVar;
    }

    public void onClick(View view) {
        this.f23152f.m30080a(this.f23147a);
        C2538c.b("MainInterators", new Object[]{"mergeUserAllDataReq:" + this.f23148b.toString()});
        this.f23152f.m30034a(this.f23148b, this.f23149c, this.f23150d);
        this.f23151e.dismiss();
        this.f23152f.f23134q = false;
    }
}
