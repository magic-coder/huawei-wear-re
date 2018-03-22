package com.huawei.ui.device.activity.selectcontact;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ContactMainActivity */
class C2146g implements IBaseResponseCallback {
    final /* synthetic */ ContactMainActivity f7606a;

    C2146g(ContactMainActivity contactMainActivity) {
        this.f7606a = contactMainActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && ((Integer) obj).intValue() == 100000) {
            C2538c.m12677c("ContactMainActivity", "MESSAGE_ADD_SUCCESS_COMMAND()!");
            this.f7606a.f7582r.sendEmptyMessage(1);
            return;
        }
        C2538c.m12680e("ContactMainActivity", "MESSAGE_ADD_FAIL_COMMAND()!");
        this.f7606a.f7582r.sendEmptyMessage(2);
    }
}
