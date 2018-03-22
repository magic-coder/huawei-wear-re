package com.huawei.ui.device.activity.adddevice;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import com.huawei.ui.device.views.p172a.C2187c;

/* compiled from: AddDeviceChildActivity */
class C2015q implements OnClickListener {
    C2187c f7058a;
    final /* synthetic */ AddDeviceChildActivity f7059b;

    public C2015q(AddDeviceChildActivity addDeviceChildActivity, C2187c c2187c) {
        this.f7059b = addDeviceChildActivity;
        this.f7058a = c2187c;
    }

    public void onClick(View view) {
        boolean z = true;
        C2538c.m12677c("AddDeviceChildActivity", "MyOnClickListener(): item.getID()=" + this.f7058a.m11202a());
        this.f7059b.f7025d = this.f7059b.f7024c.m10384a();
        if (this.f7058a.m11206b() == null || !this.f7058a.m11206b().equals(BaseApplication.m2632b().getString(i.IDS_app_display_name_porc))) {
            z = false;
        }
        if (this.f7059b.f7025d == null) {
            this.f7059b.m10552a(this.f7058a.m11202a(), this.f7058a.m11209c(), z);
        } else if (((3 == this.f7058a.m11202a() || 10 == this.f7058a.m11202a()) && this.f7059b.f7025d.getDeviceIdentify().equalsIgnoreCase("AndroidWear")) || 2 == this.f7058a.m11202a() || 9 == this.f7058a.m11202a() || -3 == this.f7058a.m11202a()) {
            this.f7059b.m10552a(this.f7058a.m11202a(), this.f7058a.m11209c(), z);
        } else {
            this.f7059b.m10556b(this.f7058a.m11202a(), this.f7058a.m11209c(), z);
        }
    }
}
