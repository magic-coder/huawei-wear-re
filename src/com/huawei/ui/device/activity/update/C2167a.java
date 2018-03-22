package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DeviceOtaActivity */
class C2167a implements OnClickListener {
    final /* synthetic */ DeviceOtaActivity f7747a;

    C2167a(DeviceOtaActivity deviceOtaActivity) {
        this.f7747a = deviceOtaActivity;
    }

    public void onClick(View view) {
        this.f7747a.onBackPressed();
    }
}
