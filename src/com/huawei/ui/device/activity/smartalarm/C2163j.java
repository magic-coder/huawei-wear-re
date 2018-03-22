package com.huawei.ui.device.activity.smartalarm;

import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SmartAlarmClockActivity */
class C2163j implements IBaseResponseCallback {
    final /* synthetic */ SmartAlarmClockActivity f7656a;

    C2163j(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7656a = smartAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        this.f7656a.f7624e = (List) obj;
        if (this.f7656a.f7624e != null && this.f7656a.f7624e.size() != 0) {
            int a = this.f7656a.f7623d.m11187a(this.f7656a.f7628i);
            int p = this.f7656a.m11071h();
            SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) this.f7656a.f7624e.get(0);
            smartAlarmInfo.setSmartAlarmStartTime_hour(a / 100);
            smartAlarmInfo.setSmartAlarmStartTime_mins(a % 100);
            C2538c.m12677c("SmartAlarmClockActivity", "saveUIData!" + (a / 100) + "------" + (a % 100));
            smartAlarmInfo.setSmartAlarmRepeat(this.f7656a.f7632m);
            smartAlarmInfo.setSmartAlarmAheadTime(p);
            smartAlarmInfo.setSmartAlarmEnable(1);
            List arrayList = new ArrayList();
            arrayList.add(smartAlarmInfo);
            this.f7656a.f7622c.m10428b(arrayList, new C2164k(this));
            C2538c.m12677c("SmartAlarmClockActivity", "saveUIData() setDBAlarmClock()=" + smartAlarmInfo.toString());
        }
    }
}
