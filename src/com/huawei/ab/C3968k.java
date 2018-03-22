package com.huawei.ab;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;

/* compiled from: HWUserInfoMgr */
class C3968k implements IBaseResponseCallback {
    final /* synthetic */ C3966i f15198a;

    C3968k(C3966i c3966i) {
        this.f15198a = c3966i;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            Message obtainMessage = this.f15198a.f15196a.f15176h.obtainMessage();
            obtainMessage.what = 1000;
            obtainMessage.obj = obj;
            this.f15198a.f15196a.f15176h.sendMessage(obtainMessage);
        }
    }
}
