package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a.C1773a;

/* compiled from: AntilossPopupDialogActivity */
class C1795s implements OnClickListener {
    final /* synthetic */ AntilossPopupDialogActivity f4944a;

    C1795s(AntilossPopupDialogActivity antilossPopupDialogActivity) {
        this.f4944a = antilossPopupDialogActivity;
    }

    public void onClick(View view) {
        if (C1773a.m8552a(this.f4944a) != null) {
            C1773a.m8552a(this.f4944a).m8563g();
            C1773a.m8552a(this.f4944a).m8561e();
            C1773a.m8552a(this.f4944a).m8557c();
            C1773a.m8552a(this.f4944a).m8558c(this.f4944a);
        }
        this.f4944a.finish();
    }
}
