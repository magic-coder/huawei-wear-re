package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.o.c.a;
import com.huawei.p190v.C2538c;

/* compiled from: STTimeoutActivity */
class aa implements OnClickListener {
    final /* synthetic */ STTimeoutActivity f23295a;

    aa(STTimeoutActivity sTTimeoutActivity) {
        this.f23295a = sTTimeoutActivity;
    }

    public void onClick(View view) {
        C2538c.c(STTimeoutActivity.f23251f, new Object[]{"Enter sure()"});
        a.b(this.f23295a.f23262l);
        this.f23295a.finish();
    }
}
