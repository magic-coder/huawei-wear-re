package com.huawei.pluginkidwatch.plugin.setting.p167b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.List;

/* compiled from: HistoryListAdapter */
public class C1939d extends BaseAdapter {
    private LayoutInflater f6723a;
    private List<C1941f> f6724b = null;

    public C1939d(Context context) {
        this.f6723a = LayoutInflater.from(context);
    }

    public int getCount() {
        if (this.f6724b == null) {
            return 0;
        }
        return this.f6724b.size();
    }

    public Object getItem(int i) {
        if (this.f6724b == null) {
            return null;
        }
        return this.f6724b.get(i);
    }

    public long getItemId(int i) {
        if (this.f6724b == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1940e c1940e;
        if (view == null) {
            C2538c.m12674b("AlarmListAdapter", "getView convertView == null");
            view = this.f6723a.inflate(h.reward_history_list_item, viewGroup, false);
            c1940e = new C1940e();
            c1940e.f6725a = (TextView) view.findViewById(g.item_tv_history_content);
            c1940e.f6726b = (TextView) view.findViewById(g.item_tv_histpry_hope);
            c1940e.f6727c = (TextView) view.findViewById(g.item_tv_histpry_time);
            c1940e.f6729e = view.findViewById(g.feature_reward_view_line_start);
            c1940e.f6728d = view.findViewById(g.feature_reward_view_line_mid);
            c1940e.f6730f = view.findViewById(g.feature_reward_view_line_end);
            view.setTag(c1940e);
        } else {
            c1940e = (C1940e) view.getTag();
        }
        C1941f c1941f = (C1941f) this.f6724b.get(i);
        if (c1941f == null || c1940e == null) {
            C2538c.m12674b("AlarmListAdapter", "getView  null == historyItem || null == holder ");
        } else {
            C2538c.m12674b("AlarmListAdapter", "====================holder.describe", c1941f.m10159b());
            c1940e.f6725a.setText(c1941f.m10159b());
            c1940e.f6726b.setText(c1941f.m10161c());
            c1940e.f6727c.setText(c1941f.m10163d());
            m10155a(c1940e, i);
        }
        return view;
    }

    private void m10155a(C1940e c1940e, int i) {
        if (this.f6724b != null) {
            if (1 == this.f6724b.size()) {
                c1940e.f6729e.setVisibility(8);
                c1940e.f6728d.setVisibility(8);
                c1940e.f6730f.setVisibility(8);
            } else if (i == 0) {
                c1940e.f6729e.setVisibility(0);
                c1940e.f6728d.setVisibility(8);
                c1940e.f6730f.setVisibility(8);
            } else if (i == this.f6724b.size() - 1) {
                c1940e.f6729e.setVisibility(8);
                c1940e.f6728d.setVisibility(8);
                c1940e.f6730f.setVisibility(0);
            } else {
                c1940e.f6729e.setVisibility(8);
                c1940e.f6728d.setVisibility(0);
                c1940e.f6730f.setVisibility(8);
            }
        }
    }

    public void m10156a(List<C1941f> list) {
        this.f6724b = list;
        notifyDataSetChanged();
    }
}
