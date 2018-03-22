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

/* compiled from: AddPeroidActivity */
class ar implements C1378e {
    final /* synthetic */ boolean f5940a;
    final /* synthetic */ AlarmItem f5941b;
    final /* synthetic */ AddPeroidActivity f5942c;

    ar(AddPeroidActivity addPeroidActivity, boolean z, AlarmItem alarmItem) {
        this.f5942c = addPeroidActivity;
        this.f5940a = z;
        this.f5941b = alarmItem;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("AddPeroidActivity", "========== entity.setWatchSetting-->onResponse");
        this.f5942c.f5483P.setVisibility(8);
        this.f5942c.f5483P.m7206a(false);
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("AddPeroidActivity", "========== set watch alarm list error");
            this.f5942c.f5489d.setClickable(true);
            if (!this.f5942c.isFinishing()) {
                if (this.f5940a) {
                    C1483c.m6832c(this.f5942c.f5498n, this.f5942c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_contactmanage_delete_fail));
                } else {
                    C1483c.m6832c(this.f5942c.f5498n, this.f5942c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_set_fail));
                }
                this.f5942c.f5497m = false;
                if (this.f5940a && this.f5941b != null) {
                    if (this.f5942c.f5493i == null) {
                        this.f5942c.f5493i = new ArrayList();
                    }
                    this.f5942c.f5493i.add(this.f5941b);
                    this.f5942c.f5509y = this.f5942c.f5493i.size() - 1;
                }
                if (!AddPeroidActivity.f5467h || this.f5942c.f5493i == null || this.f5942c.f5493i.size() < 1) {
                    C2538c.m12680e("AddPeroidActivity", "==========save failure,decline edit item in list");
                    this.f5942c.f5493i.set(this.f5942c.f5509y, this.f5942c.f5484Q);
                    return;
                }
                C2538c.m12680e("AddPeroidActivity", "==========save failure,delete the item in list");
                this.f5942c.f5493i.remove(this.f5942c.f5493i.size() - 1);
                return;
            }
            return;
        }
        C2538c.m12674b("AddPeroidActivity", "========== set watch alarm list Success");
        C1901r.m9678a(true);
        C1895l.m9663a(this.f5942c.f5498n, this.f5942c.f5492g);
        this.f5942c.finish();
    }
}
