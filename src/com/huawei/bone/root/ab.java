package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: STTimeoutActivity */
class ab implements OnClickListener {
    final /* synthetic */ STTimeoutActivity f23296a;

    ab(STTimeoutActivity sTTimeoutActivity) {
        this.f23296a = sTTimeoutActivity;
    }

    public void onClick(View view) {
        C2538c.c(STTimeoutActivity.f23251f, new Object[]{"Enter cancle()"});
        this.f23296a.finish();
    }
}
