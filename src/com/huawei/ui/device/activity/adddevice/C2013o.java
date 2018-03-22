package com.huawei.ui.device.activity.adddevice;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.ah;

/* compiled from: AddDeviceChildActivity */
class C2013o implements OnClickListener {
    final /* synthetic */ int f7053a;
    final /* synthetic */ String f7054b;
    final /* synthetic */ boolean f7055c;
    final /* synthetic */ AddDeviceChildActivity f7056d;

    C2013o(AddDeviceChildActivity addDeviceChildActivity, int i, String str, boolean z) {
        this.f7056d = addDeviceChildActivity;
        this.f7053a = i;
        this.f7054b = str;
        this.f7055c = z;
    }

    public void onClick(View view) {
        C2538c.m12677c("AddDeviceChildActivity", "showReplaceDeviceDialog():点击同意切换设备");
        this.f7056d.m10552a(this.f7053a, this.f7054b, this.f7055c);
        ah.m10316a(this.f7056d.f7022a).m10350q();
        C2538c.m12677c("AddDeviceChildActivity", "清除升级inter数据");
    }
}
