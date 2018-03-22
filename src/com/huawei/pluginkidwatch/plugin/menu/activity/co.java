package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: ContactsListActivity */
class co implements C1378e {
    final /* synthetic */ ContactsListActivity f6009a;

    co(ContactsListActivity contactsListActivity) {
        this.f6009a = contactsListActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6009a.f5626y.removeCallbacks(this.f6009a.ab);
            C1506g.m6979b();
            return;
        }
        this.f6009a.f5626y.removeCallbacks(this.f6009a.ab);
        DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel = (DeviceBindUsersIOEntityModel) baseEntityModel;
        if (!this.f6009a.isFinishing()) {
            UserInfo userInfo;
            this.f6009a.f5589M.clear();
            this.f6009a.f5589M.addAll(deviceBindUsersIOEntityModel.userInfos);
            this.f6009a.m9216a(this.f6009a.f5589M);
            String str = "";
            StringBuilder stringBuilder = new StringBuilder();
            for (UserInfo userInfo2 : this.f6009a.f5589M) {
                if (userInfo2.huid.equals(C1462f.m6744i()) && "2".equals(userInfo2.privilege)) {
                    C1462f.m6736e(true);
                    C1395k a = C1392h.m6269a(this.f6009a.f5600X, C1462f.m6744i(), C1462f.m6746j());
                    a.f3097q = userInfo2.huid;
                    C1392h.m6297b(this.f6009a.f5600X, a);
                }
                stringBuilder.append(SNBConstant.FILTER + userInfo2.phoneNum);
            }
            str = stringBuilder.toString();
            if (!"".equals(str) && str.length() > 1) {
                str = str.substring(1, str.length());
            }
            C2538c.m12674b("ContactsListActivity", "==ww== allPhoneNumber =" + str);
            C1497q.m6943a(this.f6009a, "managerphonenumber", str);
            C1462f.m6721a(this.f6009a.f5589M);
            if (C1462f.m6754n() && deviceBindUsersIOEntityModel.userInfos.size() < 5) {
                userInfo2 = new UserInfo();
                userInfo2.deviceCode = "addDeviceCode";
                this.f6009a.f5589M.add(userInfo2);
            }
            if (!this.f6009a.isFinishing()) {
                this.f6009a.f5597U.clear();
                this.f6009a.f5597U.addAll(this.f6009a.f5589M);
                this.f6009a.f5625x.m8898a(this.f6009a.f5597U);
                this.f6009a.f5625x.notifyDataSetChanged();
                this.f6009a.m9208a(this.f6009a.f5621t);
                if (1 == this.f6009a.f5606e.getCurrentItem()) {
                    if (C1462f.m6754n()) {
                        this.f6009a.f5594R.setVisibility(0);
                        this.f6009a.f5595S.setVisibility(0);
                        this.f6009a.f5609h.setVisibility(0);
                        this.f6009a.f5613l.setVisibility(0);
                        this.f6009a.f5609h.setBackgroundResource(C1617f.kw_icon_sort_info);
                        this.f6009a.f5613l.setText(C1680l.IDS_plugin_kidwatch_common_sort);
                    } else {
                        this.f6009a.f5594R.setVisibility(8);
                        this.f6009a.f5595S.setVisibility(8);
                        this.f6009a.f5609h.setVisibility(8);
                        this.f6009a.f5613l.setVisibility(8);
                    }
                }
                C1506g.m6979b();
            }
        }
    }
}
