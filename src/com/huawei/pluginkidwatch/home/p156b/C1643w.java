package com.huawei.pluginkidwatch.home.p156b;

import android.content.Context;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: HomeUtil */
final class C1643w implements C1378e {
    final /* synthetic */ Context f4257a;
    final /* synthetic */ C1413d f4258b;

    C1643w(Context context, C1413d c1413d) {
        this.f4257a = context;
        this.f4258b = c1413d;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C1483c.m6824a(this.f4257a, C1680l.IDS_plugin_kidwatch_menu_shutdown_failed);
            return;
        }
        C1642v.m7776a(this.f4257a, this.f4258b);
        C1483c.m6824a(this.f4257a, C1680l.IDS_plugin_kidwatch_menu_shutdown_success);
    }
}
