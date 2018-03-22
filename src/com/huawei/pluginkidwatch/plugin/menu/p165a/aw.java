package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.listview.C1521a;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.util.List;

/* compiled from: SosContactSortListAdapter */
public class aw extends C1521a {
    private Context f5242a;
    private LayoutInflater f5243b = LayoutInflater.from(this.f5242a);
    private List<UserInfo> f5244c;

    public aw(Context context, List<UserInfo> list) {
        this.f5242a = context;
        this.f5244c = list;
    }

    public int mo2611a() {
        return this.f5244c.size();
    }

    public Object mo2613a(int i) {
        if (i >= this.f5244c.size()) {
            return null;
        }
        return this.f5244c.get(i);
    }

    public long mo2614b(int i) {
        return (long) i;
    }

    public View mo2612a(int i, View view, ViewGroup viewGroup) {
        ax axVar;
        if (view == null) {
            view = this.f5243b.inflate(h.item_managercontactslist, null);
            axVar = new ax();
            axVar.f5245a = (TextView) view.findViewById(g.name_tv);
            axVar.f5246b = (TextView) view.findViewById(g.menu_tv_phonenumber);
            axVar.f5247c = (ImageView) view.findViewById(g.viewpager_list_item_img);
            axVar.f5248d = (ImageView) view.findViewById(g.menu_iv_arrow);
            axVar.f5249e = (TextView) view.findViewById(g.nemu_tv_me);
            axVar.f5250f = (TextView) view.findViewById(g.menu_tv_manager);
            view.setTag(axVar);
        } else {
            axVar = (ax) view.getTag();
        }
        UserInfo userInfo = (UserInfo) this.f5244c.get(i);
        if (userInfo != null) {
            Bitmap a = C1906x.m9695a(userInfo.bitmapStr);
            if (a != null) {
                axVar.f5247c.setImageBitmap(a);
            }
            if ("2".equals(userInfo.privilege)) {
                axVar.f5250f.setVisibility(0);
            } else {
                axVar.f5250f.setVisibility(8);
            }
            if (userInfo.huid.equals(C1462f.m6744i())) {
                axVar.f5249e.setVisibility(0);
            } else {
                axVar.f5249e.setVisibility(8);
            }
            axVar.f5248d.setVisibility(8);
            axVar.f5245a.setText(userInfo.nickname);
            axVar.f5246b.setText(userInfo.phoneNum);
            String str = userInfo.bigHeadIcon;
            if (!"".equals(str) && str != null) {
                Bitmap b = C1465a.m6770a().m6776b(str);
                if (b == null || b.isRecycled()) {
                    b = ac.m7222a(this.f5242a, str);
                    if (b == null || b.isRecycled()) {
                        axVar.f5247c.setImageResource(C1617f.kw_pic_ist_user_common);
                    } else {
                        b = C1492l.m6903a(b);
                        if (b != null) {
                            axVar.f5247c.setImageBitmap(b);
                        }
                    }
                } else {
                    axVar.f5247c.setImageBitmap(C1492l.m6903a(b));
                }
            } else if (userInfo.type.equals("0")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_ist_user_common);
            } else if (userInfo.type.equals("1")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_relation_mid_dad);
            } else if (userInfo.type.equals("2")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_relation_mid_mom);
            } else if (userInfo.type.equals("3")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_relation_mid_grandpa);
            } else if (userInfo.type.equals("4")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_relation_mid_grandma);
            } else if (userInfo.type.equals("5")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_user_boy);
            } else if (userInfo.type.equals("6")) {
                axVar.f5247c.setImageResource(C1617f.kw_pic_user_girl);
            }
        }
        return view;
    }
}
