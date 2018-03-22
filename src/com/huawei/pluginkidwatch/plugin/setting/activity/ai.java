package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: InviteManagerActivity */
class ai implements C1378e {
    final /* synthetic */ ah f6589a;

    ai(ah ahVar) {
        this.f6589a = ahVar;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C1506g.m6979b();
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            this.f6589a.f6588a.f6586a.m9836a(this.f6589a.f6588a.f6586a.f6349o.getText().toString(), this.f6589a.f6588a.f6586a.getResources().getString(C1680l.IDS_plugin_kidwatch_settings_invite_manager_msg));
            C1483c.m6824a(this.f6589a.f6588a.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_success);
            C1497q.m6942a(this.f6589a.f6588a.f6586a, "isInvite", Boolean.valueOf(true));
            C1395k a = C1392h.m6269a(this.f6589a.f6588a.f6586a, C1462f.m6744i(), C1462f.m6746j());
            if (!(a == null || a.f3096p == null)) {
                C2538c.m12674b("InviteManagerActivity", "deviceInfo = " + a);
                this.f6589a.f6588a.f6586a.f6356v.mo2508a(a.f3096p, C1462f.m6746j());
            }
            if (this.f6589a.f6588a.f6586a.f6330A) {
                C2538c.m12674b("InviteManagerActivity", "=========从导航进入邀请界面，这是点击back，则直接跳到HomeActivity.java");
                this.f6589a.f6588a.f6586a.m9843d();
            } else {
                C2538c.m12674b("InviteManagerActivity", "=========finish 自己不跳转");
            }
            this.f6589a.f6588a.f6586a.finish();
        } else if (baseEntityModel == null || 13211 != baseEntityModel.retCode) {
            C1483c.m6824a(this.f6589a.f6588a.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_failed);
        } else {
            C1483c.m6824a(this.f6589a.f6588a.f6586a, C1680l.IDS_plugin_kidwatch_settings_invite_failed_ismanager);
        }
    }
}
