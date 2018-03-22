package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hwversionmgr.p079a.C1070g;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.List;

/* compiled from: UpdateListAdapter */
public class ay extends BaseAdapter {
    private List<C1070g> f5251a;
    private LayoutInflater f5252b = LayoutInflater.from(this.f5253c);
    private Context f5253c;

    public ay(Context context, List<C1070g> list) {
        this.f5253c = context;
        this.f5251a = list;
    }

    public int getCount() {
        return this.f5251a.size();
    }

    public Object getItem(int i) {
        return this.f5251a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        az azVar;
        if (view == null) {
            view = this.f5252b.inflate(h.item_update, null);
            azVar = new az();
            azVar.f5254a = (TextView) view.findViewById(g.menu_update_name);
            view.setTag(azVar);
        } else {
            azVar = (az) view.getTag();
        }
        C1070g c1070g = (C1070g) this.f5251a.get(i);
        if (i == 0) {
            azVar.f5254a.setText(c1070g.m4505b());
        } else {
            azVar.f5254a.setText(i + "." + c1070g.m4505b());
        }
        return view;
    }
}
