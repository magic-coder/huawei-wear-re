package com.huawei.ui.device.activity.notification;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwmessagenotifymgr.a.a;
import com.huawei.hwmessagenotifymgr.notifymanager.C1035a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationSettingActivity */
class C2102i implements OnCheckedChangeListener {
    final /* synthetic */ int f7418a;
    final /* synthetic */ C2101h f7419b;

    C2102i(C2101h c2101h, int i) {
        this.f7419b = c2101h;
        this.f7418a = i;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        a aVar = (a) this.f7419b.f7417a.f7399j.get(this.f7418a);
        C2538c.m12661a("03", 1, "NotificationSettingActivity", "getView() ", "onCheckedChanged-----position: " + this.f7418a + " Checked : " + z + " AppName : " + aVar.b() + " PkgName: " + aVar.c() + " AuthorizeFlag: " + aVar.d());
        int i = z ? 1 : 0;
        if (i != aVar.d()) {
            aVar.a(i);
            this.f7419b.f7417a.f7398i.m10302a(aVar.c(), i);
            Intent intent = new Intent("com.huawei.bone.ACTION_NOTIFICATION_AUTHORIZED_CHANGED");
            intent.putExtra(SNBConstant.FIELD_PKG, aVar.c());
            intent.putExtra("authorized_flag", i);
            this.f7419b.f7417a.f7403p.sendBroadcast(intent);
        }
        if ("com.tencent.mm".equals(aVar.c()) || "com.android.mms".equals(aVar.c()) || "com.tencent.mobileqq".equals(aVar.c()) || "com.tencent.mqq".equals(aVar.c())) {
            C0996a.m3611a(this.f7419b.f7417a.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG", "true", null);
            C2538c.m12677c("NotificationSettingActivity", "set ture :" + C0996a.m3612a(this.f7419b.f7417a.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG"));
        }
        if ("com.huawei.intelligent".equals(aVar.c())) {
            C0996a.m3611a(this.f7419b.f7417a.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG_ADD", "true", null);
            if (C0972a.m3499a() != null && C0972a.m3499a().isSupportMidware()) {
                C1035a.m4176b().m4181a(this.f7419b.f7417a.f7398i.m10304a(), z);
            }
            C2538c.m12677c("NotificationSettingActivity", "set ture :" + C0996a.m3612a(this.f7419b.f7417a.f7392c, String.valueOf(10001), "KEY_NOTIFICATION_SETTINGS_FIRST_OPEN_FLAG_ADD"));
        }
    }
}
