package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: SetPhoneNumActivity */
class ci implements C1378e {
    final /* synthetic */ SetPhoneNumActivity f6662a;

    ci(SetPhoneNumActivity setPhoneNumActivity) {
        this.f6662a = setPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        CommonRetOModel commonRetOModel = (CommonRetOModel) baseEntityModel;
        if (commonRetOModel.retCode == 0 && commonRetOModel.data != null && !"".equals(commonRetOModel.data)) {
            this.f6662a.f6526c.setText(commonRetOModel.data);
            this.f6662a.f6526c.setSelection(commonRetOModel.data.length());
            C1497q.m6942a(this.f6662a.f6535l, "sharedpreferences_exist_phone_number", Boolean.valueOf(true));
        }
    }
}
