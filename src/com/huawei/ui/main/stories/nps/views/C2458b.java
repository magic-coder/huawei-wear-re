package com.huawei.ui.main.stories.nps.views;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: NpsAdapter */
class C2458b implements OnClickListener {
    final /* synthetic */ int f8830a;
    final /* synthetic */ C2457a f8831b;

    C2458b(C2457a c2457a, int i) {
        this.f8831b = c2457a;
        this.f8830a = i;
    }

    public void onClick(View view) {
        for (String put : this.f8831b.f8826b.keySet()) {
            this.f8831b.f8826b.put(put, Boolean.valueOf(false));
        }
        this.f8831b.f8826b.put(String.valueOf(this.f8830a), Boolean.valueOf(true));
        this.f8831b.f8829e.sendEmptyMessage(this.f8830a);
        this.f8831b.notifyDataSetChanged();
    }
}
