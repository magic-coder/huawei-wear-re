package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.p138a.C1392h;

/* compiled from: ProfileSettingActivity */
class bc implements OnClickListener {
    final /* synthetic */ ProfileSettingActivity f6616a;

    bc(ProfileSettingActivity profileSettingActivity) {
        this.f6616a = profileSettingActivity;
    }

    public void onClick(View view) {
        this.f6616a.f6374F.cancel();
        this.f6616a.f6374F = null;
        C2538c.m12674b("KIDWATCH_ProfileSettingActivity", "=============KWCache.getCurDeviceInfo().Sex:" + C1462f.m6748k());
        C1462f.m6718a(C1392h.m6269a(this.f6616a.f6398e, C1462f.m6744i(), this.f6616a.f6380L));
        this.f6616a.finish();
    }
}
