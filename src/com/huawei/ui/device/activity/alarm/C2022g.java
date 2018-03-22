package com.huawei.ui.device.activity.alarm;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: AlarmActivity */
class C2022g implements IBaseResponseCallback {
    final /* synthetic */ AlarmActivity f7097a;

    C2022g(AlarmActivity alarmActivity) {
        this.f7097a = alarmActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("AlarmActivity", "updateEventAlarmUI() err_code = " + i);
        if (i == 0) {
            this.f7097a.f7082n = (List) obj;
            C2538c.m12677c("AlarmActivity", "updateEventAlarmUI() mEventAlarmDBList.size = " + this.f7097a.f7082n.size());
            Message obtainMessage = this.f7097a.f7066C.obtainMessage();
            obtainMessage.what = 104;
            this.f7097a.f7066C.sendMessage(obtainMessage);
        }
    }
}
