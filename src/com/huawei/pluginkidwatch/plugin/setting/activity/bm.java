package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ProfileSettingActivity */
class bm extends Handler {
    final /* synthetic */ ProfileSettingActivity f6634a;

    bm(ProfileSettingActivity profileSettingActivity) {
        this.f6634a = profileSettingActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                if (!this.f6634a.f6394Z) {
                    this.f6634a.m9864B();
                    return;
                }
                return;
            case 2:
                this.f6634a.f6379K.removeCallbacks(this.f6634a.f6392X);
                C1506g.m6979b();
                C1483c.m6824a(this.f6634a, C1680l.IDS_plugin_kidwatch_menu_option_failed);
                return;
            default:
                return;
        }
    }
}
