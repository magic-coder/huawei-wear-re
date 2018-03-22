package com.huawei.ui.homewear21.p175a;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: LeftMenuFragment */
class ck implements IBaseResponseCallback {
    final /* synthetic */ cf f8128a;

    ck(cf cfVar) {
        this.f8128a = cfVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("LeftMenuFragment", "Enter getUserInfoResponseCallback：err_code = ", Integer.valueOf(i));
        if (i != 0) {
            this.f8128a.f8121o.sendEmptyMessage(1);
        } else if (obj == null) {
            C2538c.m12680e("LeftMenuFragment", "get userinfo success but obtain null objData");
        } else {
            Message message = new Message();
            message.obj = obj;
            message.what = 0;
            this.f8128a.f8121o.sendMessage(message);
        }
    }
}
