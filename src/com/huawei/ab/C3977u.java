package com.huawei.ab;

import com.huawei.p190v.C2538c;

/* compiled from: HWUserProfileMgr */
class C3977u implements Runnable {
    final /* synthetic */ m f15216a;

    C3977u(m mVar) {
        this.f15216a = mVar;
    }

    public void run() {
        int i = 1;
        while (i < 6) {
            try {
                C3978v.m19705b(i);
                i++;
            } catch (OutOfMemoryError e) {
                C2538c.e("HWUserProfileMgr", new Object[]{"reuploadUserPrivacy OutOfMemoryError"});
                return;
            }
        }
    }
}
