package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ContactManagerListAdapter */
public class C1838i extends BaseAdapter {
    private List<UserInfo> f5282a = new ArrayList();
    private LayoutInflater f5283b = LayoutInflater.from(this.f5284c);
    private Context f5284c;
    private UserInfo f5285d;

    public C1838i(Context context) {
        this.f5284c = context;
    }

    public void m8898a(List<UserInfo> list) {
        this.f5282a = list;
    }

    public int getCount() {
        return this.f5282a.size();
    }

    public Object getItem(int i) {
        return this.f5282a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1840k c1840k;
        if (view == null) {
            view = this.f5283b.inflate(h.item_managercontactslist, null);
            c1840k = new C1840k();
            c1840k.f5288a = (ImageView) view.findViewById(g.viewpager_list_item_img);
            c1840k.f5289b = (TextView) view.findViewById(g.name_tv);
            c1840k.f5290c = (TextView) view.findViewById(g.menu_tv_phonenumber);
            c1840k.f5291d = (TextView) view.findViewById(g.menu_tv_manager);
            c1840k.f5292e = (TextView) view.findViewById(g.nemu_tv_me);
            c1840k.f5293f = (ImageView) view.findViewById(g.menu_iv_arrow);
            c1840k.f5294g = (ImageView) view.findViewById(g.viewpager_list_item_img_ba);
            c1840k.f5295h = (ImageView) view.findViewById(g.viewpager_list_item_img_add);
            view.setTag(c1840k);
        } else {
            c1840k = (C1840k) view.getTag();
        }
        c1840k.f5288a.setImageBitmap(null);
        if (this.f5282a.size() > 0 && i < this.f5282a.size()) {
            this.f5285d = (UserInfo) this.f5282a.get(i);
        }
        if (this.f5285d != null) {
            if ("addDeviceCode".equals(this.f5285d.deviceCode)) {
                c1840k.f5295h.setImageResource(C1617f.kw_icon_info_add);
                c1840k.f5290c.setVisibility(8);
                c1840k.f5292e.setVisibility(8);
                c1840k.f5291d.setVisibility(8);
                c1840k.f5293f.setVisibility(8);
                c1840k.f5289b.setText(C1680l.IDS_plugin_kidwatch_settings_usermanage_title_new);
                c1840k.f5294g.setVisibility(0);
                c1840k.f5295h.setVisibility(0);
            } else {
                c1840k.f5288a.setImageResource(C1617f.kw_pic_ist_user_common);
                c1840k.f5295h.setVisibility(8);
                c1840k.f5294g.setVisibility(8);
                c1840k.f5290c.setVisibility(0);
                c1840k.f5289b.setText(this.f5285d.nickname);
                c1840k.f5290c.setText(this.f5285d.phoneNum);
                Bitmap a = C1906x.m9695a(this.f5285d.bitmapStr);
                if (a != null) {
                    c1840k.f5288a.setImageBitmap(a);
                }
                if ("2".equals(this.f5285d.privilege)) {
                    c1840k.f5291d.setVisibility(0);
                } else {
                    c1840k.f5291d.setVisibility(8);
                }
                if (this.f5285d.huid.equals(C1462f.m6744i())) {
                    c1840k.f5292e.setVisibility(0);
                } else {
                    c1840k.f5292e.setVisibility(8);
                }
                if (C1462f.m6754n()) {
                    c1840k.f5293f.setVisibility(0);
                } else if (this.f5285d.huid.equals(C1462f.m6744i())) {
                    c1840k.f5293f.setVisibility(0);
                } else {
                    c1840k.f5293f.setVisibility(8);
                }
                String str = "";
                str = this.f5285d.bigHeadIcon;
                C2538c.m12674b("ContactListAdapter", "==ww== contactEntity  url ==" + str);
                if (str != null && !"".equals(str)) {
                    Bitmap b = C1465a.m6770a().m6776b(str);
                    if (b == null || b.isRecycled()) {
                        b = ac.m7222a(this.f5284c, str);
                        if (b == null || b.isRecycled()) {
                            C2538c.m12674b("ContactListAdapter", "  ==ww== mBitmapCache has no Bitmap!!  download  Bitmap!!");
                            C1565a.m7217a(new C1839j(this, i, i), str, this.f5284c);
                        } else {
                            a = C1492l.m6903a(b);
                            if (a != null) {
                                c1840k.f5288a.setImageBitmap(a);
                            }
                        }
                    } else {
                        C2538c.m12674b("ContactListAdapter", "  ==ww==  mBitmapCache has  Bitmap!! -----time==" + new Date().toString());
                        a = C1492l.m6903a(b);
                        if (a != null) {
                            c1840k.f5288a.setImageBitmap(a);
                        }
                    }
                } else if (this.f5285d.type.equals("0")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_ist_user_common);
                } else if (this.f5285d.type.equals("1")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_relation_mid_dad);
                } else if (this.f5285d.type.equals("2")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_relation_mid_mom);
                } else if (this.f5285d.type.equals("3")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_relation_mid_grandpa);
                } else if (this.f5285d.type.equals("4")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_relation_mid_grandma);
                } else if (this.f5285d.type.equals("5")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_user_boy);
                } else if (this.f5285d.type.equals("6")) {
                    c1840k.f5288a.setImageResource(C1617f.kw_pic_user_girl);
                }
            }
        }
        return view;
    }
}
