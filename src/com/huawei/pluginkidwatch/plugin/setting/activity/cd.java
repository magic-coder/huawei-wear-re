package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: SetKidWatchNumActivity */
class cd implements C1378e {
    final /* synthetic */ SetKidWatchNumActivity f6656a;

    cd(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6656a = setKidWatchNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b(this.f6656a.f6500b, "============设置手表电话返回 errorCode：" + baseEntityModel.retCode);
        if (baseEntityModel.retCode == 0) {
            this.f6656a.m10031a(this.f6656a.f6516r);
            this.f6656a.m10041g();
            return;
        }
        this.f6656a.f6506h.setClickable(true);
        this.f6656a.f6505g.setText("");
        C1483c.m6824a(this.f6656a, C1680l.IDS_plugin_kidwatch_settings_verification_code_fail);
        this.f6656a.m10028a(-1);
    }
}
