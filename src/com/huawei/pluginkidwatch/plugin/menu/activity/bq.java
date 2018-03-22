package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.Intent;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;

/* compiled from: ContactInfoActivity */
class bq implements C1378e {
    final /* synthetic */ ContactInfoActivity f5975a;

    bq(ContactInfoActivity contactInfoActivity) {
        this.f5975a = contactInfoActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            C1392h.m6283a(this.f5975a, C1462f.m6748k());
            C1392h.m6306d(this.f5975a, C1462f.m6746j());
            C1392h.m6310e(this.f5975a, C1462f.m6746j());
            C1462f.m6718a(null);
            C1462f.m6731d("");
            C1462f.m6722a(true);
            C1497q.m6943a(this.f5975a, "sharedpreferences_watch_device_code", "");
            C1497q.m6942a(this.f5975a, "resutunbindall", Boolean.valueOf(true));
            C1497q.m6943a(this.f5975a, "managerphonenumber", "");
            Intent intent = new Intent();
            intent.setClassName(this.f5975a, "com.huawei.pluginkidwatch.HomeActivity");
            this.f5975a.startActivity(intent);
            this.f5975a.finish();
        } else if (!this.f5975a.isFinishing()) {
            C1483c.m6824a(this.f5975a, C1680l.IDS_plugin_kidwatch_menu_reset_failed);
        }
    }
}
