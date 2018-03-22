package com.huawei.pluginaf500.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.fenda.hwbracelet.mode.Alarm;

/* compiled from: AlarmEditListActivity */
class C5808q implements OnItemClickListener {
    final /* synthetic */ AlarmEditListActivity f19970a;

    C5808q(AlarmEditListActivity alarmEditListActivity) {
        this.f19970a = alarmEditListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Alarm alarm = (Alarm) this.f19970a.f19713g.get(i);
        Intent intent = new Intent(this.f19970a, AlarmEditActivity.class);
        intent.putExtra("alarm", alarm);
        this.f19970a.startActivity(intent);
    }
}
