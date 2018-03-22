package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: SetPhoneNumActivity */
class cm implements C1378e {
    final /* synthetic */ SetPhoneNumActivity f6666a;

    cm(SetPhoneNumActivity setPhoneNumActivity) {
        this.f6666a = setPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6666a.f6529f.setClickable(true);
            C2538c.m12680e(this.f6666a.f6525b, "=====设置电话失败");
            this.f6666a.f6527d.setText("");
            C1483c.m6824a(this.f6666a.f6535l, C1680l.IDS_plugin_kidwatch_settings_verification_code_fail);
            this.f6666a.m10049a(-1);
            return;
        }
        C2538c.m12674b(this.f6666a.f6525b, "=====设置电话ok====");
        if ("infotosetphonenumber".equals(this.f6666a.f6537n)) {
            C2538c.m12674b(this.f6666a.f6525b, "==ww==isFromInfo =" + this.f6666a.f6537n);
            C1497q.m6943a(this.f6666a, "menuinfophone", this.f6666a.f6536m);
            this.f6666a.finish();
            return;
        }
        C1462f.f3372a = this.f6666a.f6526c.getText().toString();
        if (((PhoneNumIOEntityModel) baseEntityModel).type == 1) {
            this.f6666a.m10058f();
        } else {
            this.f6666a.m10056e();
        }
        C1497q.m6942a(this.f6666a.f6535l, "sharedpreferences_exist_phone_number", Boolean.valueOf(true));
    }
}
