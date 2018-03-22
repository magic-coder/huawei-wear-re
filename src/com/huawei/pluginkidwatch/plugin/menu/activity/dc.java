package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;

/* compiled from: EditPhoneNumActivity */
class dc implements C1378e {
    final /* synthetic */ EditPhoneNumActivity f6026a;

    dc(EditPhoneNumActivity editPhoneNumActivity) {
        this.f6026a = editPhoneNumActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        CommonRetOModel commonRetOModel = (CommonRetOModel) baseEntityModel;
        if (commonRetOModel.retCode == 0 && commonRetOModel.data != null && !"".equals(commonRetOModel.data)) {
            this.f6026a.f5662c.setText(commonRetOModel.data);
            this.f6026a.f5662c.setSelection(commonRetOModel.data.length());
        }
    }
}
