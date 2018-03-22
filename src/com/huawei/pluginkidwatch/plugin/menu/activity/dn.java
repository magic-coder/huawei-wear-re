package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1507h;
import com.huawei.pluginkidwatch.g;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.m;
import com.huawei.pluginkidwatch.plugin.menu.p165a.ag;

/* compiled from: ElectronicFenceActivity */
class dn implements OnItemLongClickListener {
    final /* synthetic */ ElectronicFenceActivity f6041a;

    dn(ElectronicFenceActivity electronicFenceActivity) {
        this.f6041a = electronicFenceActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.m12674b("ElectronicFenceActivity", "============mFenceLongPressListener long press ");
        ag agVar = (ag) view.getTag();
        this.f6041a.f5710f = new C1507h(this.f6041a.f5719o, SdkConstants.REQUEST_CAMERA_VIDEO, 60, h.dialog_contact_longtouch_delete, m.servicedialog, true);
        this.f6041a.f5710f.show();
        ((TextView) this.f6041a.f5710f.findViewById(g.menu_tv_delete)).setOnClickListener(new C1861do(this, i, agVar));
        return true;
    }
}
