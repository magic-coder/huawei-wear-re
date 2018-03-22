package com.huawei.ui.device.activity.selectcontact;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ContactOrderbyActivity */
class C2149j implements IBaseResponseCallback {
    final /* synthetic */ ContactOrderbyActivity f7610a;

    C2149j(ContactOrderbyActivity contactOrderbyActivity) {
        this.f7610a = contactOrderbyActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && ((Integer) obj).intValue() == 100000) {
            C2538c.m12677c(this.f7610a.f7583a, "MESSAGE_ORDERBY_SUCCESS_COMMAND()!");
            this.f7610a.f7589g.sendEmptyMessage(1);
            return;
        }
        C2538c.m12680e(this.f7610a.f7583a, "MESSAGE_ORDERBY_FAIL_COMMAND()!");
        this.f7610a.f7589g.sendEmptyMessage(2);
    }
}
