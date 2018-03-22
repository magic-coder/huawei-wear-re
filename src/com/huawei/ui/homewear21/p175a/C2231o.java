package com.huawei.ui.homewear21.p175a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.activity.adddevice.AddDeviceActivity;

/* compiled from: HomeFragment */
class C2231o implements OnClickListener {
    final /* synthetic */ C2217a f8145a;

    C2231o(C2217a c2217a) {
        this.f8145a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "Enter pairedListener onClick");
        this.f8145a.aF();
        this.f8145a.f8041z.startActivity(new Intent(this.f8145a.f8041z, AddDeviceActivity.class));
    }
}
