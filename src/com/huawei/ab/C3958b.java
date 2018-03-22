package com.huawei.ab;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: HWUserInfoMgr */
class C3958b implements IBaseResponseCallback {
    final /* synthetic */ C3956a f15180a;

    C3958b(C3956a c3956a) {
        this.f15180a = c3956a;
    }

    public void onResponse(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"err_code :" + i});
        if (i == 0) {
            Message obtainMessage = this.f15180a.f15176h.obtainMessage();
            obtainMessage.what = 1000;
            obtainMessage.obj = obj;
            this.f15180a.f15176h.sendMessage(obtainMessage);
        }
    }
}
