package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HandleFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ElectronicFenceActivity */
class dt implements C1378e {
    final /* synthetic */ HandleFenceIOEntityModel f6051a;
    final /* synthetic */ ElectronicFenceActivity f6052b;

    dt(ElectronicFenceActivity electronicFenceActivity, HandleFenceIOEntityModel handleFenceIOEntityModel) {
        this.f6052b = electronicFenceActivity;
        this.f6051a = handleFenceIOEntityModel;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f6052b.isFinishing()) {
            C2538c.m12674b("ElectronicFenceActivity", "===== setWatchSetting 页面已经被杀死，不再去更新");
            return;
        }
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            this.f6052b.m9364e();
            C1483c.m6832c(this.f6052b.f5719o, this.f6052b.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_electronic_delete_fence_failure));
            C2538c.m12674b("ElectronicFenceActivity", "========电子围栏删除失败   fenceId：" + this.f6051a.fenceId);
        } else {
            C2538c.m12674b("ElectronicFenceActivity", "========电子围栏删除成功   fenceId：" + this.f6051a.fenceId);
            if (this.f6052b.f5716l.size() > 0) {
                this.f6052b.m9361d();
            } else if (this.f6052b.f5718n != 0) {
                this.f6052b.onBackClick(new View(this.f6052b.f5719o));
            }
        }
        this.f6052b.f5712h.setClickable(true);
    }
}
