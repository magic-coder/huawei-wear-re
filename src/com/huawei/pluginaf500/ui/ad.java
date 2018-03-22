package com.huawei.pluginaf500.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.fenda.hwbracelet.mode.Alarm;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;

/* compiled from: AlarmRemindActivity */
class ad extends BaseAdapter {
    static final /* synthetic */ boolean f19874a = (!AlarmRemindActivity.class.desiredAssertionStatus());
    final /* synthetic */ AlarmRemindActivity f19875b;
    private Context f19876c;

    public ad(AlarmRemindActivity alarmRemindActivity, Context context) {
        this.f19875b = alarmRemindActivity;
        this.f19876c = context;
    }

    public int getCount() {
        return this.f19875b.f19721g.size();
    }

    public Object getItem(int i) {
        return this.f19875b.f19721g.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        af afVar;
        if (view == null) {
            view = LayoutInflater.from(this.f19876c).inflate(f.alarm_list_item, null);
            afVar = new af();
            if (f19874a || view != null) {
                afVar.f19879a = (TextView) view.findViewById(e.name);
                afVar.f19880b = (TextView) view.findViewById(e.time);
                afVar.f19881c = (CheckBox) view.findViewById(e.cb_on_off);
                view.setTag(afVar);
            } else {
                throw new AssertionError();
            }
        }
        afVar = (af) view.getTag();
        afVar.f19879a.setText(((Alarm) this.f19875b.f19721g.get(i)).getName() == null ? "" : ((Alarm) this.f19875b.f19721g.get(i)).getName());
        afVar.f19880b.setText(((Alarm) this.f19875b.f19721g.get(i)).getTime() == null ? "" : ((Alarm) this.f19875b.f19721g.get(i)).getTime());
        if (((Alarm) this.f19875b.f19721g.get(i)).getOnOff() == 0) {
            afVar.f19881c.setChecked(false);
        } else {
            afVar.f19881c.setChecked(true);
        }
        afVar.f19881c.setOnCheckedChangeListener(new ae(this, i));
        return view;
    }
}
