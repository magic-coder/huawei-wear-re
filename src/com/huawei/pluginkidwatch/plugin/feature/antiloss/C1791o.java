package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;

/* compiled from: AntilossActivity */
class C1791o implements C1378e {
    final /* synthetic */ AntilossActivity f4940a;

    C1791o(AntilossActivity antilossActivity) {
        this.f4940a = antilossActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            for (UserInfo userInfo : ((DeviceBindUsersIOEntityModel) baseEntityModel).userInfos) {
                C2538c.m12674b("AntilossActivity", "getParentHeadUrl KWCache.getHuaweiHuid() = " + C1462f.m6744i() + " userInfo.huid = " + userInfo.huid);
                if (C1462f.m6744i().equals(userInfo.huid)) {
                    C2538c.m12674b("AntilossActivity", "getParentHeadUrl userInfo.bigHeadIcon = " + userInfo.bigHeadIcon);
                    this.f4940a.f4871B = userInfo;
                    this.f4940a.f4880K.sendEmptyMessage(10);
                    return;
                }
            }
        }
    }
}
