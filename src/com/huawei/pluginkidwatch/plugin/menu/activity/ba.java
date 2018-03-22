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

/* compiled from: AlarmActivity */
class ba implements OnItemLongClickListener {
    final /* synthetic */ AlarmActivity f5954a;

    ba(AlarmActivity alarmActivity) {
        this.f5954a = alarmActivity;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5954a.f5511b = new C1507h(this.f5954a.f5515f, SdkConstants.REQUEST_CAMERA_VIDEO, 60, h.dialog_contact_longtouch_delete, m.servicedialog, true);
        this.f5954a.f5511b.show();
        ((TextView) this.f5954a.f5511b.findViewById(g.menu_tv_delete)).setOnClickListener(new bb(this, i));
        return true;
    }
}
