package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.ui.listview.C1522b;
import com.huawei.pluginkidwatch.d;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceSwitchAdapter */
public class C1599z extends BaseAdapter {
    private List<C1522b> f4009a = new ArrayList();
    private Context f4010b;

    public C1599z(Context context, List<C1522b> list) {
        this.f4010b = context;
        if (list != null && list.size() > 0) {
            this.f4009a.clear();
            this.f4009a.addAll(list);
        }
    }

    public void m7369a(ArrayList<C1522b> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f4009a.clear();
            this.f4009a.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        if (this.f4009a != null) {
            return this.f4009a.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        if (this.f4009a != null) {
            return this.f4009a.get(i);
        }
        return Integer.valueOf(0);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f4010b).inflate(h.commonui_paired_device_item_layout, null);
        ab abVar = new ab();
        abVar.f3828a = (TextView) inflate.findViewById(g.device_name);
        abVar.f3831d = (ImageView) inflate.findViewById(g.device_status_icon_kone);
        abVar.f3829b = (ImageView) inflate.findViewById(g.device_type_icon);
        abVar.f3830c = (TextView) inflate.findViewById(g.device_battery_value);
        abVar.f3833f = (ImageView) inflate.findViewById(g.device_battery);
        abVar.f3832e = (TextView) inflate.findViewById(g.device_connect_state);
        abVar.f3834g = (LinearLayout) inflate.findViewById(g.device_info_bottom);
        abVar.f3835h = (ImageView) inflate.findViewById(g.device_iv_right_icon);
        inflate.setTag(abVar);
        abVar.f3828a.setText(((C1522b) this.f4009a.get(i)).m7034a());
        m7365a(i, abVar);
        return inflate;
    }

    private void m7365a(int i, ab abVar) {
        int b = ((C1522b) this.f4009a.get(i)).m7038b();
        boolean e = ((C1522b) this.f4009a.get(i)).m7042e();
        boolean c = ((C1522b) this.f4009a.get(i)).m7040c();
        switch (b) {
            case 5:
                if (e) {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_kidswatch_select);
                    abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_color));
                } else {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_kidswatch_1);
                    abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_not_selected_color));
                }
                abVar.f3834g.setVisibility(8);
                return;
            case 7:
                if (e) {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_kidswatch_select);
                    abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_color));
                } else {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_kidswatch_1);
                    abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_not_selected_color));
                }
                abVar.f3834g.setVisibility(8);
                return;
            case 97:
                m7368b(abVar);
                return;
            case 98:
                m7366a(abVar);
                return;
            case 99:
                m7367a(abVar, e);
                return;
            case 100:
                m7366a(abVar);
                if (c) {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_phone_select);
                    return;
                } else {
                    abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_phone);
                    return;
                }
            default:
                return;
        }
    }

    private void m7366a(ab abVar) {
        abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_add);
        abVar.f3832e.setVisibility(8);
        abVar.f3831d.setVisibility(8);
        abVar.f3830c.setVisibility(8);
        abVar.f3833f.setVisibility(8);
        abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_not_selected_color));
        abVar.f3834g.setVisibility(8);
    }

    private void m7368b(ab abVar) {
        abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_backbone);
        abVar.f3832e.setVisibility(8);
        abVar.f3831d.setVisibility(8);
        abVar.f3830c.setVisibility(8);
        abVar.f3833f.setVisibility(8);
        abVar.f3828a.setTextColor(this.f4010b.getResources().getColor(d.item_tv_device_name_not_selected_color));
        abVar.f3834g.setVisibility(8);
        abVar.f3835h.setVisibility(8);
    }

    private void m7367a(ab abVar, boolean z) {
        if (z) {
            abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_colourband_select);
        } else {
            abVar.f3829b.setImageResource(C1617f.mid_popup_list_ic_colourband);
        }
        abVar.f3832e.setVisibility(8);
        abVar.f3831d.setVisibility(8);
        abVar.f3830c.setVisibility(8);
        abVar.f3833f.setVisibility(8);
    }
}
