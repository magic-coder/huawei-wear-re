package com.huawei.ui.device.activity.notification;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.b.a;
import com.huawei.l.a.c;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotificationSettingActivity */
class C2096c implements OnCheckedChangeListener {
    final /* synthetic */ NotificationSettingActivity f7412a;

    C2096c(NotificationSettingActivity notificationSettingActivity) {
        this.f7412a = notificationSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Object obj;
        C2538c.m12677c("NotificationSettingActivity", "mNotificationSwitch clicked : isChecked = " + z);
        String str = "";
        if (z) {
            if (!this.f7412a.f7398i.m10304a()) {
                C2538c.m12677c("NotificationSettingActivity", "mNotificationSwitch isAuthorizeEnabled = false");
                this.f7412a.f7398i.m10301a(this.f7412a.f7392c);
            }
            obj = "1";
        } else {
            obj = "0";
            if (this.f7412a.f7398i.m10304a()) {
                C2538c.m12677c("NotificationSettingActivity", "mNotificationSwitch isAuthorizeEnabled = true");
                this.f7412a.m10847c();
            }
        }
        Map hashMap = new HashMap();
        hashMap.put("click", "1");
        hashMap.put("status", obj);
        c.a().a(this.f7412a.f7392c, a.cV.a(), hashMap, 0);
        C2538c.m12677c("NotificationSettingActivity", "BI save notification click event finish, key = " + str);
    }
}
