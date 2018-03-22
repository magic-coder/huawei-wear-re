package com.huawei.ui.device.activity.alarm;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlarmActivity */
class C2023h implements OnCheckedChangeListener {
    final /* synthetic */ AlarmActivity f7098a;

    C2023h(AlarmActivity alarmActivity) {
        this.f7098a = alarmActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i;
        C2538c.m12677c("AlarmActivity", "==once== onCheckedChanged isChecked = " + z);
        AlarmActivity.f7064t = z;
        if (AlarmActivity.f7064t) {
            i = 1;
        } else {
            i = 0;
        }
        List arrayList = new ArrayList();
        if (this.f7098a.f7085u == null) {
            C2538c.m12677c("AlarmActivity", "null == mSmartAlarmInfo");
            return;
        }
        C2538c.m12677c("AlarmActivity", "==once== onCheckedChanged mSmartAlarmInfo hour = " + this.f7098a.f7085u.getSmartAlarmStartTime_hour() + ", Mins = " + this.f7098a.f7085u.getSmartAlarmStartTime_mins());
        this.f7098a.f7085u.setSmartAlarmEnable(i);
        arrayList.add(this.f7098a.f7085u);
        this.f7098a.f7079k.m10428b(arrayList, new C2024i(this));
    }
}
