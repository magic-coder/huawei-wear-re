package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: ContactInfoActivity */
class bk implements OnClickListener {
    final /* synthetic */ ContactInfoActivity f5966a;

    bk(ContactInfoActivity contactInfoActivity) {
        this.f5966a = contactInfoActivity;
    }

    public void onClick(View view) {
        Object obj = this.f5966a.f5545R.getText().toString();
        if (obj == null || "".equals(obj.trim())) {
            C1483c.m6824a(this.f5966a, C1680l.IDS_plugin_kidwatch_settings_relation_info);
        }
        if (!C1492l.m6917b(this.f5966a.f5545R.getText().toString().replace(String.valueOf('·'), "").replace(HwAccountConstants.BLANK, ""))) {
            C1483c.m6824a(this.f5966a, C1680l.IDS_plugin_kidwatch_common_illegal);
        } else if (!"".equals(obj)) {
            this.f5966a.f5559i.setText(obj);
            this.f5966a.f5533F.nickname = obj;
            this.f5966a.f5544Q.cancel();
            this.f5966a.f5544Q = null;
            this.f5966a.m9140a(this.f5966a.f5568r);
            this.f5966a.m9150b(this.f5966a.f5533F);
            C2538c.m12674b("ContactInfoActivity", "========Enter other ok");
        }
    }
}
