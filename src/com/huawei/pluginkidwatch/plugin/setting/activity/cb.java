package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: SetKidWatchNumActivity */
class cb implements C1378e {
    final /* synthetic */ SetKidWatchNumActivity f6654a;

    cb(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6654a = setKidWatchNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b(this.f6654a.f6500b, "=========WatchSecurityCodeCallBack" + baseEntityModel.retCode);
        if (baseEntityModel.retCode != 0) {
            C1483c.m6824a(this.f6654a, C1680l.IDS_plugin_kidwatch_settings_verification_get_fail);
            this.f6654a.m10028a(-1);
            return;
        }
        C1483c.m6824a(this.f6654a, C1680l.IDS_plugin_kidwatch_settings_verification_sendto_watch);
    }
}
