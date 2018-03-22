package com.huawei.pluginaf500.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.fenda.hwbracelet.mode.Alarm;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;

/* compiled from: AlarmEditListActivity */
class C5813v extends BaseAdapter {
    static final /* synthetic */ boolean f19975a = (!AlarmEditListActivity.class.desiredAssertionStatus());
    final /* synthetic */ AlarmEditListActivity f19976b;
    private Context f19977c;

    public C5813v(AlarmEditListActivity alarmEditListActivity, Context context) {
        this.f19976b = alarmEditListActivity;
        this.f19977c = context;
    }

    public int getCount() {
        return this.f19976b.f19713g.size();
    }

    public Object getItem(int i) {
        return this.f19976b.f19713g.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C5815x c5815x;
        if (view == null) {
            view = LayoutInflater.from(this.f19977c).inflate(f.alarm_edit_item, null);
            c5815x = new C5815x();
            if (f19975a || view != null) {
                c5815x.f19980a = (TextView) view.findViewById(e.name);
                c5815x.f19981b = (TextView) view.findViewById(e.time);
                c5815x.f19982c = (ImageView) view.findViewById(e.btn_delete);
                view.setTag(c5815x);
            } else {
                throw new AssertionError();
            }
        }
        c5815x = (C5815x) view.getTag();
        Alarm alarm = (Alarm) this.f19976b.f19713g.get(i);
        c5815x.f19980a.setText(alarm.getName() == null ? "" : alarm.getName());
        c5815x.f19981b.setText(alarm.getTime() == null ? "" : alarm.getTime());
        c5815x.f19982c.setOnClickListener(new C5814w(this, alarm));
        return view;
    }
}
