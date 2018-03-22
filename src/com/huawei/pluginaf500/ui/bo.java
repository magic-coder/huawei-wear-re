package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.pluginaf500.h;

/* compiled from: SettingActivity */
class bo implements OnClickListener {
    final /* synthetic */ SettingActivity f19935a;

    bo(SettingActivity settingActivity) {
        this.f19935a = settingActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f19935a.m26514e() == null) {
            Toast.makeText(this.f19935a, h.error_have_not_binded_device, 0).show();
        } else if (TextUtils.isEmpty(this.f19935a.m26514e().m26560b())) {
            Toast.makeText(this.f19935a, h.error_have_not_binded_device, 0).show();
        } else {
            this.f19935a.f.obtainMessage(101).sendToTarget();
            this.f19935a.m26511b();
        }
    }
}
