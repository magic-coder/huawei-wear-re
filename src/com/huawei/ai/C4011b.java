package com.huawei.ai;

import android.os.IBinder.DeathRecipient;
import android.util.Log;

/* compiled from: AuthenticationManager */
class C4011b implements DeathRecipient {
    final /* synthetic */ C4010a f15301a;

    C4011b(C4010a c4010a) {
        this.f15301a = c4010a;
    }

    public void binderDied() {
        Log.e("AuthenticationManager", "xFinger--authentication service binderDied");
        if (this.f15301a.f15299f != null) {
            this.f15301a.f15299f.onNoMatch(2101);
            Log.d("AuthenticationManager", "xFinger--IDENTIFY_FAILED_FPSERVICE_CRASHED");
        }
    }
}
