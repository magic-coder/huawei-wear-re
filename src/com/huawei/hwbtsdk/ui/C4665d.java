package com.huawei.hwbtsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbtsdk.C6700e;
import com.huawei.hwbtsdk.p059c.BTSDKApi;

/* compiled from: BTDeviceScanListActivity */
class C4665d implements OnClickListener {
    final /* synthetic */ BTDeviceScanListActivity f17079a;

    C4665d(BTDeviceScanListActivity bTDeviceScanListActivity) {
        this.f17079a = bTDeviceScanListActivity;
    }

    public void onClick(View view) {
        this.f17079a.f17064h.setClickable(false);
        this.f17079a.f17057a.setDisplayedChild(0);
        this.f17079a.f17061e.reset();
        this.f17079a.f17061e.start();
        this.f17079a.f17058b.setText(C6700e.IDS_btsdk_scan_tip);
        BTSDKApi.a(this.f17079a.f17065i).d();
        BTSDKApi.a(this.f17079a.f17065i).b();
    }
}
