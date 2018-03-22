package com.huawei.pluginkidwatch.plugin.chat;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatActivity */
class ag implements C1378e {
    final /* synthetic */ ChatActivity f4809a;

    ag(ChatActivity chatActivity) {
        this.f4809a = chatActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C2538c.m12674b("ChatActivity", "======getbindusers response:" + baseEntityModel);
            try {
                DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel = (DeviceBindUsersIOEntityModel) baseEntityModel;
                if (!this.f4809a.isFinishing()) {
                    List<UserInfo> list = deviceBindUsersIOEntityModel.userInfos;
                    if (list != null && list.size() > 0) {
                        if (this.f4809a.f4724h == null) {
                            this.f4809a.f4724h = new ArrayList();
                        } else {
                            this.f4809a.f4724h.clear();
                        }
                        this.f4809a.f4724h.addAll(deviceBindUsersIOEntityModel.userInfos);
                        C1462f.m6712A().clear();
                        C1462f.m6713B().clear();
                        for (UserInfo userInfo : list) {
                            C1462f.m6712A().put(userInfo.huid, userInfo.bigHeadIcon);
                            C1462f.m6713B().put(userInfo.huid, userInfo.type);
                        }
                        this.f4809a.f4705M.m8494a(this.f4809a.ae);
                        this.f4809a.m8406c(this.f4809a.f4724h);
                    }
                }
            } catch (Exception e) {
                C2538c.m12674b("ChatActivity", "======getbindusers catch error =" + e.getMessage());
            }
        }
    }
}
