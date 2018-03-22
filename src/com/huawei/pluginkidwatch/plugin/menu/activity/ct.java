package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;

/* compiled from: ContactsListActivity */
public class ct implements OnPageChangeListener {
    final /* synthetic */ ContactsListActivity f6014a;

    public ct(ContactsListActivity contactsListActivity) {
        this.f6014a = contactsListActivity;
    }

    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                this.f6014a.f5613l.setVisibility(0);
                this.f6014a.f5609h.setVisibility(0);
                this.f6014a.f5608g.setVisibility(8);
                this.f6014a.f5607f.setBackgroundResource(C1617f.kw_img_circle);
                this.f6014a.f5607f.setVisibility(0);
                this.f6014a.f5609h.setBackgroundResource(C1617f.kw_icon_add1);
                this.f6014a.f5594R.setVisibility(0);
                this.f6014a.f5595S.setVisibility(0);
                this.f6014a.f5613l.setText(C1680l.IDS_plugin_kidwatch_menu_contactmanage_add_contact);
                this.f6014a.f5613l.setVisibility(0);
                return;
            case 1:
                this.f6014a.f5607f.setVisibility(8);
                this.f6014a.f5608g.setBackgroundResource(C1617f.kw_img_circle);
                this.f6014a.f5608g.setVisibility(0);
                this.f6014a.f5609h.setBackgroundResource(C1617f.kw_icon_sort_info);
                this.f6014a.f5613l.setText(C1680l.IDS_plugin_kidwatch_common_sort);
                this.f6014a.f5613l.setVisibility(0);
                if (C1462f.m6754n()) {
                    this.f6014a.f5613l.setVisibility(0);
                    this.f6014a.f5609h.setVisibility(0);
                    this.f6014a.f5594R.setVisibility(0);
                    this.f6014a.f5595S.setVisibility(0);
                    return;
                }
                this.f6014a.f5613l.setVisibility(8);
                this.f6014a.f5609h.setVisibility(8);
                this.f6014a.f5594R.setVisibility(8);
                this.f6014a.f5595S.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageScrollStateChanged(int i) {
    }
}
