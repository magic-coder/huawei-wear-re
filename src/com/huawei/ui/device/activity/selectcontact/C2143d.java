package com.huawei.ui.device.activity.selectcontact;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: ContactDeleteActivity */
class C2143d implements IBaseResponseCallback {
    final /* synthetic */ ContactDeleteActivity f7602a;

    C2143d(ContactDeleteActivity contactDeleteActivity) {
        this.f7602a = contactDeleteActivity;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && ((Integer) obj).intValue() == 100000) {
            C2538c.m12677c(this.f7602a.f7553e, "MESSAGE_DELETE_SUCCESS_COMMAND()!");
            this.f7602a.f7564p.sendEmptyMessage(1);
            return;
        }
        C2538c.m12680e(this.f7602a.f7553e, "MESSAGE_DELETE_FAIL_COMMAND()!");
        this.f7602a.f7564p.sendEmptyMessage(2);
    }
}
