package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;

/* compiled from: ContactInfoActivity */
class br implements OnClickListener {
    final /* synthetic */ ContactInfoActivity f5976a;

    br(ContactInfoActivity contactInfoActivity) {
        this.f5976a = contactInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if ("".equals(this.f5976a.f5571u)) {
            C1483c.m6832c(this.f5976a, "不允许转移权限给此管理员");
            C2538c.m12674b("ContactInfoActivity", "==ww== 不允许转移权限给此管理员 huid=" + this.f5976a.f5571u);
            return;
        }
        this.f5976a.m9152b(this.f5976a.f5571u);
    }
}
