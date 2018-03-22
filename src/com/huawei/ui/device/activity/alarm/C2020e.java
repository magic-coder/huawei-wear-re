package com.huawei.ui.device.activity.alarm;

import android.os.Message;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.p173b.C2190b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlarmActivity */
class C2020e implements IBaseResponseCallback {
    final /* synthetic */ AlarmActivity f7095a;

    C2020e(AlarmActivity alarmActivity) {
        this.f7095a = alarmActivity;
    }

    public void onResponse(int i, Object obj) {
        int i2 = 0;
        C2538c.m12677c("AlarmActivity", "getEventAlarm() err_code = " + i + ",objData = " + obj);
        if (i == 0 && obj != null) {
            List arrayList = new ArrayList();
            this.f7095a.f7082n = (List) obj;
            C2538c.m12677c("AlarmActivity", "getEventAlarm() mEventAlarmDBList.size() = " + this.f7095a.f7082n.size());
            int i3 = 0;
            while (i2 < this.f7095a.f7082n.size()) {
                EventAlarmInfo eventAlarmInfo = (EventAlarmInfo) this.f7095a.f7082n.get(i2);
                C2190b c2190b = new C2190b();
                C2190b a = c2190b.m11228a(c2190b, eventAlarmInfo, this.f7095a.f7080l, this.f7095a.f7069a, this.f7095a.f7082n, i2);
                i3 = a.m11244i();
                arrayList.add(a);
                i2++;
            }
            Message obtainMessage = this.f7095a.f7066C.obtainMessage();
            obtainMessage.what = 102;
            obtainMessage.obj = arrayList;
            obtainMessage.arg1 = i3;
            this.f7095a.f7066C.sendMessage(obtainMessage);
        }
    }
}
