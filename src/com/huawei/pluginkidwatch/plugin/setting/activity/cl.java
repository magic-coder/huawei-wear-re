package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: SetPhoneNumActivity */
class cl implements C1378e {
    final /* synthetic */ SetPhoneNumActivity f6665a;

    cl(SetPhoneNumActivity setPhoneNumActivity) {
        this.f6665a = setPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode != 0) {
            C2538c.m12674b(this.f6665a.f6525b, "==========获取验证码失败====" + baseEntityModel.retCode);
            if (!C1492l.m6916b(this.f6665a.f6535l)) {
                C2538c.m12674b(this.f6665a.f6525b, "==========Network is unavailable====");
                C1483c.m6824a(this.f6665a.f6535l, C1680l.IDS_plugin_kidwatch_common_network_disable);
            } else if (baseEntityModel.retCode == 13208) {
                C1483c.m6832c(this.f6665a.f6535l, "短信发送失败,请重试");
            } else {
                C1483c.m6824a(this.f6665a.f6535l, C1680l.IDS_plugin_kidwatch_settings_verification_get_fail);
            }
            this.f6665a.m10049a(-1);
            return;
        }
        C2538c.m12674b(this.f6665a.f6525b, "==========获取验证码成功====");
        this.f6665a.f6532i.setText(C1680l.IDS_plugin_kidwatch_settings_verification_sendto_phone);
    }
}
