package com.huawei.hwbtsdk.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceScanListActivity */
class C4663b implements OnItemClickListener {
    final /* synthetic */ BTDeviceScanListActivity f17077a;

    C4663b(BTDeviceScanListActivity bTDeviceScanListActivity) {
        this.f17077a = bTDeviceScanListActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.a("01", 1, "BTDeviceScanListActivity", new Object[]{"onItemClick: id is " + j});
        BTSDKApi.a(this.f17077a.f17065i).a(j);
        this.f17077a.m22397c();
    }
}
