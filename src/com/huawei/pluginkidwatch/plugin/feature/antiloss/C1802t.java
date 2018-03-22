package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;

/* compiled from: AntilossPopupDialogActivity */
class C1802t implements OnClickListener {
    final /* synthetic */ AntilossPopupDialogActivity f4964a;

    C1802t(AntilossPopupDialogActivity antilossPopupDialogActivity) {
        this.f4964a = antilossPopupDialogActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AntilossPopupDialogActivity", "=========Make Call to Baby");
        this.f4964a.m8546c();
        this.f4964a.m8544b();
        this.f4964a.m8549e();
        if (C1773a.m8552a(this.f4964a) != null) {
            C1773a.m8552a(this.f4964a).m8563g();
            C1773a.m8552a(this.f4964a).m8557c();
        }
        this.f4964a.finish();
    }
}
