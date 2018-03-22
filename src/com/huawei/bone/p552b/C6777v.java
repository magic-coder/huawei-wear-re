package com.huawei.bone.p552b;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: MainInterators */
class C6777v implements IBaseResponseCallback {
    final /* synthetic */ C6756a f23203a;

    C6777v(C6756a c6756a) {
        this.f23203a = c6756a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("MainInterators", new Object[]{"goToLoginActivity : err_code = " + i});
        Message message = new Message();
        message.what = 100;
        message.arg1 = i;
        message.obj = obj;
        this.f23203a.f23125h.sendMessage(message);
    }
}
