package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceItem;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ElectronicFenceActivity */
class dw implements C1378e {
    final /* synthetic */ int f6057a;
    final /* synthetic */ FenceItem f6058b;
    final /* synthetic */ ElectronicFenceActivity f6059c;

    dw(ElectronicFenceActivity electronicFenceActivity, int i, FenceItem fenceItem) {
        this.f6059c = electronicFenceActivity;
        this.f6057a = i;
        this.f6058b = fenceItem;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f6059c.isFinishing()) {
            C2538c.m12674b("ElectronicFenceActivity", "===== changeFenceState 页面已经被杀死，不再去更新");
        } else if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("ElectronicFenceActivity", "=========修改电子围栏状态失败");
            if (1 == this.f6057a) {
                this.f6058b.setmIsOn(false);
                C1483c.m6832c(this.f6059c.f5719o, this.f6059c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_turn_on_fail));
            } else {
                this.f6058b.setmIsOn(true);
                C1483c.m6832c(this.f6059c.f5719o, this.f6059c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_fence_turn_off_fail));
            }
            for (int i = 0; i < this.f6059c.f5708d.size(); i++) {
                if (((FenceItem) this.f6059c.f5708d.get(i)).getmFenceId().equals(this.f6058b.getmFenceId())) {
                    ((FenceItem) this.f6059c.f5708d.get(i)).setmIsOn(this.f6058b.ismIsOn());
                }
            }
            this.f6059c.m9369h();
        } else {
            C2538c.m12674b("ElectronicFenceActivity", "=========修改电子围栏状态成功");
        }
    }
}
