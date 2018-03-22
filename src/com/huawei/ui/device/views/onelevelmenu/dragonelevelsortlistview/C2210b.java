package com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MenuDragListAdapter */
class C2210b implements OnClickListener {
    final /* synthetic */ int f7947a;
    final /* synthetic */ C2209a f7948b;

    C2210b(C2209a c2209a, int i) {
        this.f7948b = c2209a;
        this.f7947a = i;
    }

    public void onClick(View view) {
        this.f7948b.f7937a.remove(this.f7947a);
        this.f7948b.notifyDataSetChanged();
        this.f7948b.f7945i.mo2637a();
    }
}
