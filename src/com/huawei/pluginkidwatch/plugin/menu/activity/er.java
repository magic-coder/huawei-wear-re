package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1491k;
import com.huawei.pluginkidwatch.common.ui.button.SlipButtonView;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import java.util.List;

/* compiled from: GeneralSettingsActivity */
public class er extends BaseAdapter {
    final /* synthetic */ GeneralSettingsActivity f6087a;
    private LayoutInflater f6088b;
    private List<eu> f6089c = null;

    public er(GeneralSettingsActivity generalSettingsActivity, Context context, List<eu> list) {
        this.f6087a = generalSettingsActivity;
        this.f6088b = LayoutInflater.from(context);
        this.f6089c = list;
    }

    public int getCount() {
        if (this.f6089c == null) {
            return 0;
        }
        return this.f6089c.size();
    }

    public Object getItem(int i) {
        if (this.f6089c == null) {
            return null;
        }
        return this.f6089c.get(i);
    }

    public long getItemId(int i) {
        if (this.f6089c == null) {
            return 0;
        }
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        eu euVar = (eu) this.f6089c.get(i);
        if (euVar == null) {
            C2538c.m12674b("GeneralSettingsAdapter", "getView  null == settingsItem");
        } else {
            et etVar;
            if (view == null) {
                View view2;
                View inflate;
                et etVar2;
                if (1 != euVar.f6101d) {
                    if (euVar.f6101d != 0) {
                        if (3 != euVar.f6101d) {
                            C2538c.m12674b("GeneralSettingsAdapter", " ====www==== getView SELECT_ITEM");
                            inflate = this.f6088b.inflate(h.item_general_settings_select_layout, viewGroup, false);
                            etVar2 = new et(this);
                            etVar2.f6092a = (TextView) inflate.findViewById(g.item_title);
                            etVar2.f6093b = (TextView) inflate.findViewById(g.item_content);
                            switch (C1491k.m6898b(this.f6087a.f5733b, "save_navigation_map")) {
                                case 0:
                                    etVar2.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_need_choice_map));
                                    etVar = etVar2;
                                    view2 = inflate;
                                    break;
                                case 1:
                                    this.f6087a.f5752u.setChecked(true);
                                    this.f6087a.f5753v.setChecked(false);
                                    etVar2.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_gaodemap_title));
                                    etVar = etVar2;
                                    view2 = inflate;
                                    break;
                                case 2:
                                    this.f6087a.f5752u.setChecked(false);
                                    this.f6087a.f5753v.setChecked(true);
                                    etVar2.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_baidumap_title));
                                    etVar = etVar2;
                                    view2 = inflate;
                                    break;
                                case 5:
                                    etVar2.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_need_choice_map));
                                    etVar = etVar2;
                                    view2 = inflate;
                                    break;
                                default:
                                    etVar = etVar2;
                                    view2 = inflate;
                                    break;
                            }
                        }
                        C2538c.m12674b("GeneralSettingsAdapter", " ====www==== getView TITLE_CONTENT_ITEM");
                        inflate = this.f6088b.inflate(h.item_general_settings_title_content_layout, viewGroup, false);
                        etVar2 = new et(this);
                        etVar2.f6092a = (TextView) inflate.findViewById(g.item_title);
                        etVar2.f6093b = (TextView) inflate.findViewById(g.item_content);
                        etVar2.f6093b.setText(String.format(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_Imei_show_content), new Object[]{this.f6087a.f5756y}));
                        etVar = etVar2;
                        view2 = inflate;
                    } else {
                        C2538c.m12674b("GeneralSettingsAdapter", " ====www==== getView SWITCH_ITEM");
                        inflate = this.f6088b.inflate(h.item_general_settings_switch_layout, viewGroup, false);
                        etVar2 = new et(this);
                        etVar2.f6092a = (TextView) inflate.findViewById(g.item_title);
                        etVar2.f6093b = (TextView) inflate.findViewById(g.item_content);
                        etVar2.f6094c = (SlipButtonView) inflate.findViewById(g.item_switch);
                        etVar = etVar2;
                        view2 = inflate;
                    }
                } else {
                    C2538c.m12674b("GeneralSettingsAdapter", " ====www==== getView NORMAL_ITEM");
                    inflate = this.f6088b.inflate(h.item_general_settings_normal_layout, viewGroup, false);
                    etVar2 = new et(this);
                    etVar2.f6092a = (TextView) inflate.findViewById(g.item_title);
                    etVar = etVar2;
                    view2 = inflate;
                }
                view2.setTag(etVar);
                view = view2;
            } else {
                etVar = (et) view.getTag();
            }
            if (etVar == null) {
                C2538c.m12674b("GeneralSettingsAdapter", "getView null == holder ");
            } else {
                etVar.f6095d = i;
                etVar.f6096e = euVar;
                etVar.f6092a.setText(euVar.f6098a);
                if (euVar.f6101d == 0) {
                    etVar.f6093b.setText(euVar.f6099b);
                    etVar.f6094c.setChecked(euVar.f6100c);
                    etVar.f6094c.setOnChangedListener(new es(this, etVar));
                }
            }
        }
        return view;
    }

    public void m9610a(List<eu> list) {
        this.f6089c = list;
        notifyDataSetChanged();
    }

    public void m9609a(View view) {
        if (view != null) {
            et etVar = (et) view.getTag();
            etVar.f6093b = (TextView) view.findViewById(g.item_content);
            switch (C1491k.m6898b(this.f6087a.f5733b, "save_navigation_map")) {
                case 0:
                    etVar.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_need_choice_map));
                    return;
                case 1:
                    etVar.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_gaodemap_title));
                    return;
                case 2:
                    etVar.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_baidumap_title));
                    return;
                case 5:
                    etVar.f6093b.setText(this.f6087a.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_relation_navigation_need_choice_map));
                    return;
                default:
                    return;
            }
        }
    }
}
