package com.huawei.ui.device.activity.alarm;

import android.os.Handler;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.g;
import com.huawei.ui.device.views.p173b.C2189a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlarmActivity */
class C2025j extends Handler {
    WeakReference<AlarmActivity> f7100a;
    final /* synthetic */ AlarmActivity f7101b;

    C2025j(AlarmActivity alarmActivity, AlarmActivity alarmActivity2) {
        this.f7101b = alarmActivity;
        this.f7100a = new WeakReference(alarmActivity2);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (((AlarmActivity) this.f7100a.get()) != null) {
            switch (message.what) {
                case 100:
                    C2538c.m12677c("AlarmActivity", "MESSAGE_UPDATE_SMART_ALARM_UI");
                    this.f7101b.m10592f();
                    return;
                case 102:
                    C2538c.m12677c("AlarmActivity", "MESSAGE_UPDATE_EVENT_ALARM_UI mAlarmListAdapter = " + this.f7101b.f7084p + " mEventAlarmItemList = " + this.f7101b.f7083o);
                    List list = (List) message.obj;
                    if (this.f7101b.f7083o == null) {
                        this.f7101b.f7083o = new ArrayList();
                    } else {
                        this.f7101b.f7083o.clear();
                    }
                    for (int i = 0; i < list.size(); i++) {
                        this.f7101b.f7083o.add(list.get(i));
                    }
                    if (this.f7101b.f7084p != null) {
                        this.f7101b.f7084p.m11224a(this.f7101b.f7083o);
                        this.f7101b.f7084p.notifyDataSetChanged();
                    } else {
                        this.f7101b.f7084p = new C2189a(this.f7101b, this.f7101b.f7083o);
                        this.f7101b.f7070b.setAdapter(this.f7101b.f7084p);
                    }
                    C2538c.m12677c("AlarmActivity", "mEventAlarmItemList.size() = " + this.f7101b.f7083o.size());
                    if (5 <= this.f7101b.f7083o.size()) {
                        this.f7101b.f7071c.setEnabled(false);
                        this.f7101b.f7072d.setImageResource(g.ic_add_disable);
                    } else {
                        this.f7101b.f7071c.setEnabled(true);
                        this.f7101b.f7072d.setImageResource(g.ic_toolbar_add);
                    }
                    C2538c.m12677c("AlarmActivity", "alarm---------------msg.arg1 = " + message.arg1);
                    if (1 == message.arg1) {
                        this.f7101b.f7079k.m10419a(this.f7101b.f7082n, new C2026k(this));
                        return;
                    }
                    return;
                case 104:
                    C2538c.m12677c("AlarmActivity", "MESSAGE_UPDATE_EVENT_UI_COMMAND  mEventAlarmDBList.size() = " + this.f7101b.f7082n.size());
                    this.f7101b.m10596h();
                    if (this.f7101b.f7084p != null) {
                        this.f7101b.f7084p.m11224a(this.f7101b.f7083o);
                        this.f7101b.f7084p.notifyDataSetChanged();
                        if (5 <= this.f7101b.f7082n.size()) {
                            this.f7101b.f7071c.setEnabled(false);
                            this.f7101b.f7072d.setImageResource(g.ic_add_disable);
                            return;
                        }
                        this.f7101b.f7071c.setEnabled(true);
                        this.f7101b.f7072d.setImageResource(g.ic_toolbar_add);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
