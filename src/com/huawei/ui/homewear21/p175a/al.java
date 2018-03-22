package com.huawei.ui.homewear21.p175a;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class al implements IBaseResponseCallback {
    final /* synthetic */ C2217a f8053a;

    al(C2217a c2217a) {
        this.f8053a = c2217a;
    }

    public void onResponse(int i, Object obj) {
        if (i != 0) {
            C2538c.m12680e("HomeFragment", "updateNoDisturb() fail!");
        } else if (obj == null) {
            C2538c.m12680e("HomeFragment", "updateNoDisturb() success but get null objData!");
        } else {
            Message message = new Message();
            message.obj = obj;
            message.what = 10;
            this.f8053a.bu.sendMessage(message);
        }
    }
}
