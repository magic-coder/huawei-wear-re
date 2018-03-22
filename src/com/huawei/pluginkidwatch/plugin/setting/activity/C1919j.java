package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: BindbyQrActivity */
class C1919j implements OnClickListener {
    final /* synthetic */ String f6684a;
    final /* synthetic */ BindbyQrActivity f6685b;

    C1919j(BindbyQrActivity bindbyQrActivity, String str) {
        this.f6685b = bindbyQrActivity;
        this.f6684a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c(this.f6685b.f6266b, "matb showChangeMainAdministerAccountDialog ok onClick resetManager!!!");
        if (C1492l.m6916b(this.f6685b.f6284t)) {
            this.f6685b.m9782n(this.f6684a);
            return;
        }
        C1483c.m6824a(this.f6685b.f6284t, C1680l.IDS_plugin_kidwatch_common_network_disable);
        this.f6685b.m9766h();
    }
}
