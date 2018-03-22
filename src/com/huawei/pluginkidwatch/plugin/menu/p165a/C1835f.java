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
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.util.Date;
import java.util.List;

/* compiled from: ContactListAdapter */
public class C1835f extends BaseAdapter {
    private List<Contact> f5273a;
    private LayoutInflater f5274b = LayoutInflater.from(this.f5275c);
    private Context f5275c;
    private Contact f5276d;

    public C1835f(Context context, List<Contact> list) {
        this.f5275c = context;
        this.f5273a = list;
    }

    public int getCount() {
        return this.f5273a.size();
    }

    public Object getItem(int i) {
        return this.f5273a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1837h c1837h;
        if (view == null) {
            view = this.f5274b.inflate(h.item_ordinarycontactslist, null);
            c1837h = new C1837h();
            c1837h.f5279a = (ImageView) view.findViewById(g.viewpager_list_item_img);
            c1837h.f5280b = (TextView) view.findViewById(g.name_tv);
            c1837h.f5281c = (TextView) view.findViewById(g.menu_tv_phonenumber);
            view.setTag(c1837h);
        } else {
            c1837h = (C1837h) view.getTag();
        }
        c1837h.f5279a.setImageBitmap(null);
        c1837h.f5279a.setImageResource(C1617f.kw_pic_ist_user_common);
        if (this.f5273a.size() > 0 && i < this.f5273a.size()) {
            this.f5276d = (Contact) this.f5273a.get(i);
        }
        if (this.f5276d != null) {
            c1837h.f5280b.setText(this.f5276d.getName());
            c1837h.f5281c.setText(this.f5276d.getPhoneNum());
            Bitmap a = C1906x.m9695a(this.f5276d.bitmapStr);
            if (a != null) {
                c1837h.f5279a.setImageBitmap(a);
            }
            String str = "";
            str = this.f5276d.getBigHeadIcon();
            C2538c.m12674b("ContactListAdapter", "==ww== contactEntity  url ==" + str);
            if (str == null || "".equals(str)) {
                m8888a(c1837h);
            } else {
                m8887a(i, c1837h, str);
            }
        }
        return view;
    }

    private void m8887a(int i, C1837h c1837h, String str) {
        Bitmap b = C1465a.m6770a().m6776b(str);
        if (b == null || b.isRecycled()) {
            b = ac.m7222a(this.f5275c, str);
            if (b == null || b.isRecycled()) {
                C2538c.m12674b("ContactListAdapter", "  ==ww== mBitmapCache has no Bitmap!!,download  Bitmap!!");
                m8889a(str, i);
                return;
            }
            b = C1492l.m6903a(b);
            if (b != null) {
                c1837h.f5279a.setImageBitmap(b);
                return;
            }
            return;
        }
        C2538c.m12674b("ContactListAdapter", "  ==ww==  mBitmapCache has  Bitmap!! -----time==" + new Date().toString());
        b = C1492l.m6903a(b);
        if (b != null) {
            c1837h.f5279a.setImageBitmap(b);
        }
    }

    private void m8889a(String str, int i) {
        C1565a.m7217a(new C1836g(this, i, i), str, this.f5275c);
    }

    private void m8888a(C1837h c1837h) {
        if (this.f5276d.type.equals("0")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_ist_user_common);
        } else if (this.f5276d.type.equals("1")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_relation_mid_dad);
        } else if (this.f5276d.type.equals("2")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_relation_mid_mom);
        } else if (this.f5276d.type.equals("3")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_relation_mid_grandpa);
        } else if (this.f5276d.type.equals("4")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_relation_mid_grandma);
        } else if (this.f5276d.type.equals("5")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_user_boy);
        } else if (this.f5276d.type.equals("6")) {
            c1837h.f5279a.setImageResource(C1617f.kw_pic_user_girl);
        }
    }
}
