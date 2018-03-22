package com.huawei.ui.device.activity.donotdisturb;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.ui.device.p171b.C2183a;

/* compiled from: NoDisturbSettingActivity */
class C2053c implements OnClickListener {
    final /* synthetic */ int f7194a;
    final /* synthetic */ NoDisturbSettingActivity f7195b;

    C2053c(NoDisturbSettingActivity noDisturbSettingActivity, int i) {
        this.f7195b = noDisturbSettingActivity;
        this.f7194a = i;
    }

    public void onClick(View view) {
        if (this.f7194a == 0) {
            this.f7195b.f7161B = C2183a.m11184a(null).m11187a(this.f7195b.f7187v);
        } else {
            this.f7195b.f7162C = C2183a.m11184a(null).m11187a(this.f7195b.f7188w);
        }
        this.f7195b.m10691g();
        this.f7195b.f7183r.setText(this.f7195b.f7163D);
        this.f7195b.f7184s.setText(this.f7195b.f7164E);
    }
}
