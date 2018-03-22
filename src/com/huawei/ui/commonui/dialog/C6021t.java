package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: CustomSingleChoiceDialog */
class C6021t implements OnItemClickListener {
    final /* synthetic */ C6013l f20742a;

    private C6021t(C6013l c6013l) {
        this.f20742a = c6013l;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        for (int i2 = 0; i2 < this.f20742a.f20721i.length; i2++) {
            this.f20742a.f20722j[i2] = false;
        }
        this.f20742a.f20722j[i] = true;
        ((C6018q) this.f20742a.m27574a().getAdapter()).notifyDataSetChanged();
    }
}
