package com.huawei.sim.multisim;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

/* compiled from: MultiSimConfigActivity */
class C5963n implements OnClickListener {
    final /* synthetic */ int f20540a;
    final /* synthetic */ CheckBox f20541b;
    final /* synthetic */ C5962m f20542c;

    C5963n(C5962m c5962m, int i, CheckBox checkBox) {
        this.f20542c = c5962m;
        this.f20540a = i;
        this.f20541b = checkBox;
    }

    public void onClick(View view) {
        for (int i = 0; i < this.f20542c.f20538d.length; i++) {
            this.f20542c.f20538d[i] = false;
        }
        this.f20542c.f20538d[this.f20540a] = this.f20541b.isChecked();
        this.f20542c.notifyDataSetChanged();
        if (this.f20542c.f20539e != null) {
            this.f20542c.f20539e.onItemClick(null, view, this.f20540a, -1);
        }
    }
}
