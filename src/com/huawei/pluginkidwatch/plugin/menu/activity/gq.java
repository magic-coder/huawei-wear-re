package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;

/* compiled from: TailorContactActivity */
class gq implements OnClickListener {
    final /* synthetic */ TailorContactActivity f6160a;

    gq(TailorContactActivity tailorContactActivity) {
        this.f6160a = tailorContactActivity;
    }

    public void onClick(View view) {
        if (this.f6160a.f5904k == null) {
            this.f6160a.f5904k = new C1507h(this.f6160a, SdkConstants.REQUEST_CAMERA_VIDEO, 150, h.dialog_contact_cancle, m.servicedialog, false);
            this.f6160a.f5904k.show();
        }
        this.f6160a.f5904k.findViewById(g.menu_tv_cancle).setOnClickListener(new gr(this));
        this.f6160a.f5904k.findViewById(g.menu_tv_sure).setOnClickListener(new gs(this));
    }
}
