package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.model.Contact;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: ContactsListActivity */
class cd implements OnItemClickListener {
    final /* synthetic */ ContactsListActivity f5993a;

    cd(ContactsListActivity contactsListActivity) {
        this.f5993a = contactsListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f5993a.f5588L != null && this.f5993a.f5588L.size() > 0 && i < this.f5993a.f5588L.size()) {
            C1497q.m6942a(this.f5993a, "onClickNet", Boolean.valueOf(true));
            this.f5993a.f5583G = (Contact) this.f5993a.f5588L.get(i);
            this.f5993a.f5577A = new C1507h(this.f5993a, 314, 284, h.dialog_contact_edit_modify, m.servicedialog, true);
            this.f5993a.f5622u = (ImageView) this.f5993a.f5577A.findViewById(g.dialog_contact_edit_img);
            ((TextView) this.f5993a.f5577A.findViewById(g.menu_contact_name)).setText(this.f5993a.f5583G.getName());
            ((TextView) this.f5993a.f5577A.findViewById(g.menu_contact_phonenumber)).setText(this.f5993a.f5583G.getPhoneNum());
            if ("".equals(this.f5993a.f5583G.getBigHeadIcon())) {
                this.f5993a.f5622u.setImageBitmap(null);
                Resources resources = this.f5993a.getResources();
                if (this.f5993a.f5583G.type.equals("0")) {
                    this.f5993a.f5622u.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_ist_user_common));
                } else if (this.f5993a.f5583G.type.equals("1")) {
                    this.f5993a.f5622u.setImageBitmap(BitmapFactory.decodeResource(resources, C1617f.kw_pic_relation_mid_dad));
                } else if (this.f5993a.f5583G.type.equals("2")) {
                    this.f5993a.f5622u.setImageResource(C1617f.kw_pic_relation_mid_mom);
                } else if (this.f5993a.f5583G.type.equals("3")) {
                    this.f5993a.f5622u.setImageResource(C1617f.kw_pic_relation_mid_grandpa);
                } else if (this.f5993a.f5583G.type.equals("4")) {
                    this.f5993a.f5622u.setImageResource(C1617f.kw_pic_relation_mid_grandma);
                } else if (this.f5993a.f5583G.type.equals("5")) {
                    this.f5993a.f5622u.setImageResource(C1617f.kw_pic_user_boy);
                } else if (this.f5993a.f5583G.type.equals("6")) {
                    this.f5993a.f5622u.setImageResource(C1617f.kw_pic_user_girl);
                }
            } else {
                this.f5993a.f5584H = C1465a.m6770a().m6776b(this.f5993a.f5583G.getBigHeadIcon());
                if (this.f5993a.f5584H == null) {
                    Contact a = this.f5993a.f5585I.m6261a(this.f5993a.f5583G.getContactId());
                    if (a != null) {
                        this.f5993a.f5584H = this.f5993a.f5623v.m9665a(a.bigHeadIcon);
                    }
                }
                if (this.f5993a.f5584H == null || this.f5993a.f5584H.isRecycled()) {
                    Bitmap a2 = ac.m7222a(this.f5993a, this.f5993a.f5583G.getBigHeadIcon());
                    if (a2 == null || a2.isRecycled()) {
                        this.f5993a.f5622u.setImageResource(C1617f.kw_pic_ist_user_common);
                    } else {
                        this.f5993a.f5622u.setImageBitmap(C1492l.m6903a(a2));
                        a2.recycle();
                    }
                } else {
                    this.f5993a.f5622u.setImageBitmap(C1492l.m6903a(this.f5993a.f5584H));
                    this.f5993a.f5584H.recycle();
                }
            }
            this.f5993a.f5577A.show();
            this.f5993a.f5622u.setOnClickListener(new ce(this));
            this.f5993a.f5610i = (ImageView) this.f5993a.f5577A.findViewById(g.contact_dialog_edit_img);
            ((TextView) this.f5993a.f5577A.findViewById(g.contact_tv_edit)).setOnClickListener(this.f5993a);
            this.f5993a.f5610i.setOnClickListener(new cf(this));
        }
    }
}
