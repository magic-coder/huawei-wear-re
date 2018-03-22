package com.huawei.pluginaf500.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.widget.Toast;
import com.huawei.pluginaf500.h;

/* compiled from: SettingActivity */
class br implements OnKeyListener {
    final /* synthetic */ SettingActivity f19938a;

    br(SettingActivity settingActivity) {
        this.f19938a = settingActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        Toast.makeText(this.f19938a, this.f19938a.getString(h.is_synning), 0).show();
        return true;
    }
}
