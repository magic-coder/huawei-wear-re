package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;

public class PushBootReceiver extends PushEventReceiver {
    public void onReceive(Context context, Intent intent) {
        int q = C0660a.m2594q(context);
        C0657e.m2512a("PushLogAC2712", "voteState:" + q);
        if (2 == q && C0660a.m2596s(context)) {
            C0660a.m2562a(context, false);
        } else {
            super.onReceive(context, intent);
        }
    }
}
