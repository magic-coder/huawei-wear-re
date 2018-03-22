package com.huawei.ui.homewear21.card.p176a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;

/* compiled from: HeartRateStatusInteractors */
class C2252j extends BroadcastReceiver {
    final /* synthetic */ C2247e f8189a;

    C2252j(C2247e c2247e) {
        this.f8189a = c2247e;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.huawei.bone.action.HEART_RATE_REFRESH".equals(intent.getAction())) {
            DeviceInfo c = C1204c.m5370a(this.f8189a.f8177h).m5447c();
            if (intent.getExtras() == null || c == null || 11 == c.getProductType()) {
                C2538c.m12680e("HeartRateStatusInteractors", "intent.getExtra() is null!");
            } else {
                C2538c.m12680e("HeartRateStatusInteractors", "intent.getExtra() is null!");
            }
        }
    }
}
