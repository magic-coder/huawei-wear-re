package com.huawei.ui.device.activity.selectcontact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.ui.device.views.selectcontact.C2214d;

/* compiled from: ContactSelectNumberDialog */
class C2151l implements OnItemClickListener {
    final /* synthetic */ ContactSelectNumberDialog f7612a;

    C2151l(ContactSelectNumberDialog contactSelectNumberDialog) {
        this.f7612a = contactSelectNumberDialog;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        for (int i2 = 0; i2 < C2214d.m11362a().size(); i2++) {
            C2214d.m11362a().put(Integer.valueOf(i2), Boolean.valueOf(false));
        }
        C2214d.m11362a().put(Integer.valueOf(i), Boolean.valueOf(true));
        this.f7612a.f7593d.notifyDataSetChanged();
    }
}
