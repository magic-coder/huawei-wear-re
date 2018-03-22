package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.pluginkidwatch.g;

/* compiled from: ContactImportListAdapter */
public class C1834e {
    public ImageView f5269a;
    public TextView f5270b;
    public TextView f5271c;
    public RadioButton f5272d;

    public C1834e(View view) {
        this.f5272d = (RadioButton) view.findViewById(g.menu_item_re_select);
        this.f5270b = (TextView) view.findViewById(g.name_tv);
        this.f5269a = (ImageView) view.findViewById(g.viewpager_list_item_img);
    }
}
