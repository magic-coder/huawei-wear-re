package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: EditPhoneNumActivity */
class df implements C1378e {
    final /* synthetic */ EditPhoneNumActivity f6029a;

    df(EditPhoneNumActivity editPhoneNumActivity) {
        this.f6029a = editPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel.retCode != 0) {
            C2538c.m12674b(this.f6029a.f5661b, "==========获取验证码失败====" + baseEntityModel.retCode);
            if (!C1492l.m6916b(this.f6029a.f5671l)) {
                C2538c.m12674b(this.f6029a.f5661b, "==========Network is unavailable====");
                C1483c.m6824a(this.f6029a.f5671l, C1680l.IDS_plugin_kidwatch_common_network_disable);
            } else if (baseEntityModel.retCode == 13208) {
                C1483c.m6832c(this.f6029a.f5671l, "短信发送失败,请重试");
            } else {
                C1483c.m6824a(this.f6029a.f5671l, C1680l.IDS_plugin_kidwatch_settings_verification_get_fail);
            }
            this.f6029a.m9299a(-1);
            return;
        }
        C2538c.m12674b(this.f6029a.f5661b, "==========获取验证码成功====");
        this.f6029a.f5668i.setText(C1680l.IDS_plugin_kidwatch_settings_verification_sendto_phone);
    }
}
