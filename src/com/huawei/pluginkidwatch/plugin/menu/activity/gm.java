package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.DeleteWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: TailorContactActivity */
class gm implements OnClickListener {
    final /* synthetic */ gk f6156a;

    gm(gk gkVar) {
        this.f6156a = gkVar;
    }

    public void onClick(View view) {
        C1506g.m6978a(this.f6156a.f6154a, this.f6156a.f6154a.getResources().getString(C1680l.IDS_plugin_kidwatch_common_deleting), false);
        DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel = new DeleteWatchContactIOEntityModel();
        deleteWatchContactIOEntityModel.deviceCode = C1462f.m6746j();
        deleteWatchContactIOEntityModel.id = C1497q.m6948c(this.f6156a.f6154a, "contactid");
        this.f6156a.f6154a.f5903j.mo2476a(deleteWatchContactIOEntityModel, new gn(this));
    }
}
