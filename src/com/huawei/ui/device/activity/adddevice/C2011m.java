package com.huawei.ui.device.activity.adddevice;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.views.p172a.C2188d;

/* compiled from: AddDeviceActivity */
class C2011m implements OnClickListener {
    C2188d f7050a;
    final /* synthetic */ AddDeviceActivity f7051b;

    public C2011m(AddDeviceActivity addDeviceActivity, C2188d c2188d) {
        this.f7051b = addDeviceActivity;
        this.f7050a = c2188d;
    }

    public void onClick(View view) {
        C2538c.m12677c("AddDeviceActivity", "MyOnClickListener(): item.getID()=" + this.f7050a.m11212a());
        this.f7051b.f6985J.sendEmptyMessage(13);
        if (-1 != this.f7050a.m11212a()) {
            switch (this.f7050a.m11212a()) {
                case 1:
                    this.f7051b.m10497b(1);
                    return;
                case 2:
                    this.f7051b.m10497b(2);
                    return;
                case 3:
                    this.f7051b.m10497b(3);
                    return;
                case 4:
                    this.f7051b.m10497b(4);
                    return;
                case 5:
                    this.f7051b.m10536q();
                    return;
                default:
                    return;
            }
        }
    }
}
