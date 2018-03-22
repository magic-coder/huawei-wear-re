package com.huawei.ui.main.stories.nps.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: SingleFragment */
class C2440o implements OnItemClickListener {
    final /* synthetic */ C2438m f8781a;

    C2440o(C2438m c2438m) {
        this.f8781a = c2438m;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        for (int i2 = 0; i2 < this.f8781a.f8772c.size(); i2++) {
            if (i == i2) {
                this.f8781a.f8779j.put(i2 + "", Boolean.valueOf(true));
            } else {
                this.f8781a.f8779j.put(i2 + "", Boolean.valueOf(false));
            }
        }
        this.f8781a.f8777h.notifyDataSetChanged();
        this.f8781a.m12222a();
    }
}
