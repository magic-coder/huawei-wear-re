package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

/* compiled from: CustomSingleChoiceDialog */
class C6019r implements OnClickListener {
    final /* synthetic */ int f20737a;
    final /* synthetic */ CheckBox f20738b;
    final /* synthetic */ C6018q f20739c;

    C6019r(C6018q c6018q, int i, CheckBox checkBox) {
        this.f20739c = c6018q;
        this.f20737a = i;
        this.f20738b = checkBox;
    }

    public void onClick(View view) {
        for (int i = 0; i < this.f20739c.f20735d.length; i++) {
            this.f20739c.f20735d[i] = false;
        }
        this.f20739c.f20735d[this.f20737a] = this.f20738b.isChecked();
        this.f20739c.notifyDataSetChanged();
        if (this.f20739c.f20736e != null) {
            this.f20739c.f20736e.onItemClick(null, view, this.f20737a, -1);
        }
    }
}
