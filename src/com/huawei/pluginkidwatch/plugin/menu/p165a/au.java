package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amap.api.services.core.PoiItem;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PoiListAdapter */
public class au extends BaseAdapter {
    private List<PoiItem> f5238a;
    private LayoutInflater f5239b = LayoutInflater.from(this.f5240c);
    private Context f5240c;

    public au(Context context) {
        this.f5240c = context;
    }

    public int getCount() {
        if (this.f5238a == null) {
            return 0;
        }
        return this.f5238a.size();
    }

    public Object getItem(int i) {
        if (this.f5238a == null) {
            return Integer.valueOf(0);
        }
        return this.f5238a.get(i);
    }

    public long getItemId(int i) {
        if (this.f5238a == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        av avVar;
        if (view == null) {
            view = this.f5239b.inflate(h.item_poi_info, null);
            avVar = new av();
            avVar.f5241a = (TextView) view.findViewById(g.item_poi_descrobe);
            view.setTag(avVar);
        } else {
            avVar = (av) view.getTag();
        }
        avVar.f5241a.setText(((PoiItem) this.f5238a.get(i)).toString());
        return view;
    }

    public void m8874a(ArrayList<PoiItem> arrayList) {
        this.f5238a = arrayList;
        notifyDataSetChanged();
    }
}
