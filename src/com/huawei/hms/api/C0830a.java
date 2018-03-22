package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.internal.C0840a;
import com.huawei.hms.api.internal.C0845e;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p048c.C0914a;

/* compiled from: HuaweiApiAvailabilityImpl */
final class C0830a extends HuaweiApiAvailability {
    private static final C0830a f1320a = new C0830a();

    private C0830a() {
    }

    public static C0830a m2943a() {
        return f1320a;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        C0852a.m3001a(context, "context must not be null.");
        return C0845e.m2995a(context);
    }

    public boolean isUserResolvableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public void resolveError(Activity activity, int i, int i2) {
        C0852a.m3001a(activity, "activity must not be null.");
        C0852a.m3002a("must be called on ui-thread.");
        C0887a.m3094b("HuaweiApiAvailabilityImpl", "Enter resolveError, errorCode: " + i);
        switch (i) {
            case 1:
            case 2:
                C0914a.m3196a(activity, i2);
                return;
            case 6:
                C0830a.m2944a(activity, C0840a.class.getName(), i2);
                return;
            default:
                return;
        }
    }

    private static void m2944a(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, BridgeActivity.class);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, str);
        activity.startActivityForResult(intent, i);
    }
}
