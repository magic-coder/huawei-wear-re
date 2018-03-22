package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.g;

/* compiled from: AddFenceActivity */
class af implements OnClickListener {
    final /* synthetic */ AddFenceActivity f5926a;

    af(AddFenceActivity addFenceActivity) {
        this.f5926a = addFenceActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AddFenceActivity", "==================getStreetNameListener --> onClick ");
        if (view.getId() == g.menu_elec_new_fence_getposition) {
            this.f5926a.f5451k.startAnimation(this.f5926a.aa);
            this.f5926a.f5451k.setClickable(false);
            this.f5926a.f5442b = true;
            this.f5926a.m9053k();
        } else if (view.getId() == g.menu_elec_new_fence_searchpoi && this.f5926a.f5453m.isFocused()) {
            C2538c.m12674b("AddFenceActivity", "================== 开始关键字搜索 ");
            this.f5926a.mo2518d();
        }
    }
}
