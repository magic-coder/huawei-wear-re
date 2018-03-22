package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.List;

/* compiled from: FenceModeAdapter */
public class ad extends BaseAdapter {
    private static boolean f5159e = false;
    private LayoutInflater f5160a;
    private List<FenceItem> f5161b = null;
    private Context f5162c;
    private Handler f5163d = null;

    public static boolean m8817a() {
        return f5159e;
    }

    public static void m8816a(boolean z) {
        f5159e = z;
    }

    public ad(Context context) {
        this.f5162c = context;
        this.f5160a = LayoutInflater.from(context);
    }

    public void m8818a(Handler handler) {
        this.f5163d = handler;
    }

    public int getCount() {
        if (this.f5161b == null) {
            return 0;
        }
        return this.f5161b.size();
    }

    public Object getItem(int i) {
        if (this.f5161b == null) {
            return null;
        }
        return this.f5161b.get(i);
    }

    public long getItemId(int i) {
        long j = (long) i;
        if (this.f5161b == null) {
            return 0;
        }
        return j;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        if (view == null) {
            C2538c.m12674b("FenceModeAdapter", "getView convertView == null");
            view = this.f5160a.inflate(h.item_electronic_fence_info, viewGroup, false);
            agVar = new ag();
            agVar.f5169b = (TextView) view.findViewById(g.item_tv_fence_content);
            agVar.f5168a = (TextView) view.findViewById(g.item_tv_fence_title);
            agVar.f5172e = (SlipButtonView) view.findViewById(g.item_elec_fence_switch);
            agVar.f5170c = (CheckBox) view.findViewById(g.cb_Select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        FenceItem fenceItem = (FenceItem) this.f5161b.get(i);
        if (fenceItem == null || agVar == null) {
            C2538c.m12674b("FenceModeAdapter", "getView  null == fenceItem || null == holder ");
        } else {
            agVar.f5171d = fenceItem;
            if (fenceItem.getmFenceRadius() < 300) {
                fenceItem.setmFenceRadius(300);
            }
            if ("".equals(fenceItem.getmFenceAddress().trim())) {
                agVar.f5169b.setText(fenceItem.getmFenceRadius() + this.f5162c.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_distance_metre));
            } else {
                agVar.f5169b.setText(fenceItem.getmFenceRadius() + this.f5162c.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_sport_distance_metre) + ", " + fenceItem.getmFenceAddress());
            }
            agVar.f5168a.setText(fenceItem.getmFenceName());
            agVar.f5172e.setChecked(fenceItem.ismIsOn());
            agVar.f5172e.setOnChangedListener(new ae(this, agVar));
            agVar.f5170c.setOnCheckedChangeListener(new af(this, agVar));
            if (fenceItem.ismIsShowCheck()) {
                agVar.f5170c.setVisibility(0);
                agVar.f5172e.setVisibility(8);
            } else {
                agVar.f5170c.setVisibility(8);
                agVar.f5172e.setVisibility(0);
            }
            if (fenceItem.ismIsSelected() != agVar.f5170c.isChecked()) {
                C2538c.m12674b("MessageModeAdapter", "getView fenceItem.mIsSelected != holder.cbSelect.isChecked");
                ad.m8816a(true);
                agVar.f5170c.setChecked(fenceItem.ismIsSelected());
                ad.m8816a(false);
            }
        }
        return view;
    }

    public void m8819a(List<FenceItem> list) {
        this.f5161b = list;
        notifyDataSetChanged();
    }
}
