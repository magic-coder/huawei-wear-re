package com.huawei.ui.device.views.p173b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.e;
import com.huawei.ui.device.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlarmListAdapter */
public class C2189a extends BaseAdapter {
    private Context f7788a = null;
    private List<C2190b> f7789b = new ArrayList();
    private LayoutInflater f7790c;

    public C2189a(Context context, List<C2190b> list) {
        this.f7788a = context;
        if (this.f7788a != null) {
            m11223b(list);
            this.f7790c = LayoutInflater.from(context);
        } else {
            m11223b(list);
            this.f7790c = LayoutInflater.from(context);
        }
    }

    private void m11223b(List<C2190b> list) {
        this.f7789b.clear();
        this.f7789b.addAll(list);
    }

    public void m11224a(List<C2190b> list) {
        this.f7789b.clear();
        this.f7789b.addAll(list);
    }

    public int getCount() {
        return this.f7789b.size();
    }

    public Object getItem(int i) {
        return this.f7789b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return ((C2190b) getItem(i)).m11243h();
    }

    public int getViewTypeCount() {
        return 2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            C2190b c2190b = (C2190b) this.f7789b.get(i);
            switch (c2190b.m11243h()) {
                case 1:
                    C2538c.m12677c("AlarmListAdapter", "view", view + "");
                    if (view == null) {
                        view = this.f7790c.inflate(f.activity_alarm_list_item_black, null);
                    }
                    m11222a(i, view, c2190b);
                    return view;
                default:
                    return view;
            }
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    private void m11222a(int i, View view, C2190b c2190b) {
        TextView textView = (TextView) view.findViewById(e.alarm_time);
        TextView textView2 = (TextView) view.findViewById(e.alarm_content);
        TextView textView3 = (TextView) view.findViewById(e.alarm_repeat);
        Switch switchR = (Switch) view.findViewById(e.event_alarm_switch_btn);
        if (c2190b.m11226a() == 0) {
            switchR.setChecked(false);
        } else if (1 == c2190b.m11226a()) {
            switchR.setChecked(true);
        }
        switchR.setTag(Integer.valueOf(i));
        if (c2190b.m11234c() != null) {
            textView.setText(c2190b.m11234c());
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (c2190b.m11237d() != null) {
            textView2.setText(c2190b.m11237d());
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (c2190b.m11239e() != null) {
            textView3.setText(c2190b.m11239e());
            textView3.setVisibility(0);
            return;
        }
        textView3.setVisibility(8);
    }
}
