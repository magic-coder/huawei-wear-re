package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1895l;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1901r;
import java.util.ArrayList;

/* compiled from: AddAlarmActivity */
class C1864g implements C1378e {
    final /* synthetic */ boolean f6141a;
    final /* synthetic */ AlarmItem f6142b;
    final /* synthetic */ AddAlarmActivity f6143c;

    C1864g(AddAlarmActivity addAlarmActivity, boolean z, AlarmItem alarmItem) {
        this.f6143c = addAlarmActivity;
        this.f6141a = z;
        this.f6142b = alarmItem;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("AddAlarmActivity", "========== entity.setWatchSetting-->onResponse");
        this.f6143c.f5355O.setVisibility(8);
        this.f6143c.f5355O.m7206a(false);
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("AddAlarmActivity", "========== set watch alarm list error");
            this.f6143c.f5361f.setClickable(true);
            if (!this.f6143c.isFinishing()) {
                if (this.f6141a) {
                    C1483c.m6832c(this.f6143c.f5349I, this.f6143c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail));
                } else {
                    C1483c.m6832c(this.f6143c.f5349I, this.f6143c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
                }
                this.f6143c.f5345E = false;
                if (this.f6141a && this.f6142b != null) {
                    if (this.f6143c.f5379y == null) {
                        this.f6143c.f5379y = new ArrayList();
                    }
                    this.f6143c.f5379y.add(this.f6142b);
                    this.f6143c.f5343C = this.f6143c.f5379y.size() - 1;
                }
                if (!AddAlarmActivity.f5340r || this.f6143c.f5379y == null || this.f6143c.f5379y.size() < 1) {
                    C2538c.m12680e("AddAlarmActivity", "==========save failure,decline edit item in list");
                    if (this.f6143c.f5343C >= 0 && this.f6143c.f5343C < this.f6143c.f5379y.size()) {
                        this.f6143c.f5379y.set(this.f6143c.f5343C, this.f6143c.f5356P);
                        return;
                    }
                    return;
                }
                C2538c.m12680e("AddAlarmActivity", "==========save failure,delete the item in list");
                this.f6143c.f5379y.remove(this.f6143c.f5379y.size() - 1);
                return;
            }
            return;
        }
        C2538c.m12674b("AddAlarmActivity", "========== set watch alarm list Success");
        C1901r.m9678a(true);
        C1895l.m9663a(this.f6143c.f5349I, this.f6143c.f5369n);
        this.f6143c.finish();
    }
}
