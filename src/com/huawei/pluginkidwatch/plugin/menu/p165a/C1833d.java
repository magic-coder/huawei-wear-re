package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.model.ImportContact;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1906x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ContactImportListAdapter */
public class C1833d extends BaseAdapter {
    private List<ImportContact> f5265a;
    private LayoutInflater f5266b;
    private Context f5267c;
    private HashMap<Integer, Integer> f5268d = new HashMap();

    public C1833d(Context context) {
        this.f5267c = context;
        this.f5265a = new ArrayList();
        this.f5266b = LayoutInflater.from(this.f5267c);
    }

    public void m8885a(List<ImportContact> list) {
        if (list == null || list.size() <= 0) {
            this.f5265a.clear();
        } else {
            this.f5265a.clear();
            this.f5265a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public HashMap<Integer, Integer> m8884a() {
        return this.f5268d;
    }

    public int getCount() {
        return this.f5265a.size();
    }

    public Object getItem(int i) {
        return this.f5265a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1834e c1834e;
        boolean z = false;
        C2538c.m12674b("ContactImportListAdapter", "==ww== i ===psoin==" + i + "getView===========================");
        if (view == null) {
            view = this.f5266b.inflate(h.item_contacts_improt_list, null);
            c1834e = new C1834e(view);
            c1834e.f5269a = (ImageView) view.findViewById(g.viewpager_list_item_img);
            c1834e.f5270b = (TextView) view.findViewById(g.name_tv);
            c1834e.f5272d = (RadioButton) view.findViewById(g.menu_item_re_select);
            c1834e.f5271c = (TextView) view.findViewById(g.phonenumber_tv);
            view.setTag(c1834e);
        } else {
            c1834e = (C1834e) view.getTag();
        }
        c1834e.f5269a.setImageBitmap(null);
        c1834e.f5269a.setBackgroundResource(C1617f.kw_pic_ist_user_common);
        ImportContact importContact = (ImportContact) this.f5265a.get(i);
        if (importContact != null) {
            c1834e.f5270b.setText(importContact.getName());
            c1834e.f5271c.setText(importContact.getPhoneNum());
            RadioButton radioButton = c1834e.f5272d;
            if (this.f5268d.get(Integer.valueOf(i)) != null) {
                z = true;
            }
            radioButton.setChecked(z);
            Bitmap a = C1906x.m9695a(importContact.getImgBitmapStr());
            if (a == null || a.isRecycled()) {
                c1834e.f5269a.setBackgroundResource(C1617f.kw_pic_ist_user_common);
            } else {
                a = C1492l.m6903a(a);
                if (a != null) {
                    c1834e.f5269a.setImageBitmap(a);
                }
            }
        }
        return view;
    }
}
