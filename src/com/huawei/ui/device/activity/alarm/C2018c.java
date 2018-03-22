package com.huawei.ui.device.activity.alarm;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.device.activity.smartalarm.SmartAlarmClockActivity;

/* compiled from: AlarmActivity */
class C2018c implements OnClickListener {
    final /* synthetic */ AlarmActivity f7093a;

    C2018c(AlarmActivity alarmActivity) {
        this.f7093a = alarmActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f7093a, SmartAlarmClockActivity.class);
        intent.putExtra("key_to_smart_alarm_activity", (this.f7093a.f7088x * 100) + this.f7093a.f7089y);
        this.f7093a.startActivityForResult(intent, 0);
    }
}
