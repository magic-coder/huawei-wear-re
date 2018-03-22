package com.huawei.ab;

import android.os.Bundle;
import android.os.Message;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;
import com.huawei.up.p404b.C4694a;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: HWUserInfoMgr */
class C3962e implements C3961b {
    final /* synthetic */ CountDownLatch f15186a;
    final /* synthetic */ boolean f15187b;
    final /* synthetic */ boolean f15188c;
    final /* synthetic */ C4694a f15189d;
    final /* synthetic */ C3956a f15190e;

    C3962e(C3956a c3956a, CountDownLatch countDownLatch, boolean z, boolean z2, C4694a c4694a) {
        this.f15190e = c3956a;
        this.f15186a = countDownLatch;
        this.f15187b = z;
        this.f15188c = z2;
        this.f15189d = c4694a;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"fetchUserData onSuccess"});
        this.f15186a.countDown();
        List list = (List) obj;
        if (list.size() > 0) {
            Message obtainMessage = this.f15190e.f15176h.obtainMessage();
            obtainMessage.what = 1004;
            obtainMessage.obj = list.get(0);
            if (this.f15187b) {
                obtainMessage.arg1 = 1;
            } else {
                obtainMessage.arg1 = 0;
            }
            this.f15190e.f15176h.sendMessage(obtainMessage);
            if (this.f15188c && this.f15189d != null) {
                this.f15189d.mo4558a(new Bundle());
                return;
            }
            return;
        }
        C2538c.c("HWUserInfoMgr", new Object[]{"fetchUserData data size = 0"});
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"fetchUserData onFailure"});
        this.f15186a.countDown();
        this.f15190e.m19649a(this.f15188c, this.f15189d);
    }
}
