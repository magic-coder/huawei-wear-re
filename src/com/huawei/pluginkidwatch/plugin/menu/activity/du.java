package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HandleFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ElectronicFenceActivity */
class du implements C1378e {
    final /* synthetic */ HandleFenceIOEntityModel f6053a;
    final /* synthetic */ int f6054b;
    final /* synthetic */ ElectronicFenceActivity f6055c;

    du(ElectronicFenceActivity electronicFenceActivity, HandleFenceIOEntityModel handleFenceIOEntityModel, int i) {
        this.f6055c = electronicFenceActivity;
        this.f6053a = handleFenceIOEntityModel;
        this.f6054b = i;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f6055c.isFinishing()) {
            C2538c.m12674b("ElectronicFenceActivity", "===== setWatchSetting 页面已经被杀死，不再去更新");
        } else if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C1483c.m6832c(this.f6055c.f5719o, this.f6055c.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_delete_fence_failure));
            C2538c.m12674b("ElectronicFenceActivity", "========电子围栏删除失败   fenceId：" + this.f6053a.fenceId);
        } else {
            C2538c.m12674b("ElectronicFenceActivity", "========电子围栏删除成功   fenceId：" + this.f6053a.fenceId);
            if (this.f6055c.f5708d != null && this.f6054b <= this.f6055c.f5708d.size()) {
                this.f6055c.f5708d.remove(this.f6054b);
                this.f6055c.m9369h();
            }
        }
    }
}
