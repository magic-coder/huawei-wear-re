package com.huawei.ui.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiMobileServiceSettingDialog */
class ag implements OnClickListener {
    final /* synthetic */ ae f20638a;
    final /* synthetic */ af f20639b;

    ag(af afVar, ae aeVar) {
        this.f20639b = afVar;
        this.f20638a = aeVar;
    }

    public void onClick(View view) {
        C2538c.c(ae.f20633a, new Object[]{"----- onClick 如何设置...."});
        this.f20638a.dismiss();
        ae.m27494b(this.f20639b.f20634a, 0);
    }
}
