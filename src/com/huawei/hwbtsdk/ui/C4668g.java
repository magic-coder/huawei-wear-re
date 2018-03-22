package com.huawei.hwbtsdk.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.p190v.C2538c;

/* compiled from: BTDialogActivity */
class C4668g implements OnItemClickListener {
    final /* synthetic */ BTDialogActivity f17082a;

    C4668g(BTDialogActivity bTDialogActivity) {
        this.f17082a = bTDialogActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2538c.a("01", 1, "BTDialogActivity", new Object[]{"onItemClick: id is " + j});
        BTSDKApi.a(this.f17082a).a(j);
        this.f17082a.m22415f();
        this.f17082a.m22418i();
    }
}
