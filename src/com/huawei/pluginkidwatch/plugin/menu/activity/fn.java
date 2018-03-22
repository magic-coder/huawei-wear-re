package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: PeroidActivity */
class fn implements OnItemLongClickListener {
    final /* synthetic */ PeroidActivity f6126a;

    fn(PeroidActivity peroidActivity) {
        this.f6126a = peroidActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6126a.f5796b = new C1507h(this.f6126a.f5800f, SdkConstants.REQUEST_CAMERA_VIDEO, 60, h.dialog_contact_longtouch_delete, m.servicedialog, true);
        this.f6126a.f5796b.show();
        ((TextView) this.f6126a.f5796b.findViewById(g.menu_tv_delete)).setOnClickListener(new fo(this, i));
        return true;
    }
}
