package com.huawei.p461i;

import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import java.util.List;

/* compiled from: HWAlarmManager */
class C5398f implements IBaseResponseCallback {
    final /* synthetic */ C5397e f19214a;

    C5398f(C5397e c5397e) {
        this.f19214a = c5397e;
    }

    public void onResponse(int i, Object obj) {
        List list = (List) obj;
        if (list.size() == 0) {
            list.add(new SmartAlarmInfo());
            this.f19214a.f19213a.m25960b(list, null);
        }
    }
}
