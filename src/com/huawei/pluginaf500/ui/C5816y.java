package com.huawei.pluginaf500.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: AlarmRemindActivity */
class C5816y implements OnItemClickListener {
    final /* synthetic */ AlarmRemindActivity f19983a;

    C5816y(AlarmRemindActivity alarmRemindActivity) {
        this.f19983a = alarmRemindActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.f19983a, AlarmEditActivity.class);
        intent.putExtra("alarm", (Parcelable) this.f19983a.f19721g.get(i));
        this.f19983a.startActivity(intent);
    }
}
