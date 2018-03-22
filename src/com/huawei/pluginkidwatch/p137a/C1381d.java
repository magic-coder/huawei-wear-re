package com.huawei.pluginkidwatch.p137a;

import android.content.Context;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: KidWatchUtil */
final class C1381d implements a<Boolean> {
    final /* synthetic */ Context f2974a;

    C1381d(Context context) {
        this.f2974a = context;
    }

    public void m6185a(Boolean bool, String str, boolean z) {
        C2538c.m12677c("KidWatchUtil", "============matb requestPhoneNumber getManagerNum isSuccess = " + z);
        if (z) {
            C1497q.m6942a(this.f2974a, "sharedpreferences_exist_phone_number", Boolean.valueOf(true));
            C1377a.m6175d(str);
            return;
        }
        C1497q.m6942a(this.f2974a, "sharedpreferences_exist_phone_number", Boolean.valueOf(false));
        C1377a.m6174c(str);
    }
}
