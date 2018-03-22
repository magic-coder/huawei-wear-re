package com.huawei.hwid.core.p430b.p431a;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.C5180k;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: HttpStatusCode */
public class C5139b {
    private static final SparseIntArray f18567a = new SparseIntArray();
    private static final SparseIntArray f18568b = new SparseIntArray();

    static {
        f18568b.put(70002057, 70002003);
        f18568b.put(70002059, 70002001);
        f18568b.put(70002060, 70002001);
    }

    public static String m24807a(Context context, int i) {
        f18567a.put(70002044, C5180k.m25027a(context, "CS_bind_devices_excess"));
        f18567a.put(70002019, C5180k.m25027a(context, "CS_email_already_verified"));
        f18567a.put(70001104, C5180k.m25027a(context, "CS_overload_message"));
        f18567a.put(70002067, C5180k.m25027a(context, "CS_area_not_support_service"));
        f18567a.put(70002076, C5180k.m25027a(context, "CS_overload_message"));
        String str = "";
        if (f18567a.get(i) == 0) {
            return str;
        }
        if (70002044 != i) {
            return context.getString(f18567a.get(i));
        }
        return context.getString(f18567a.get(i), new Object[]{HwAccountConstants.PORATL_ADDRESS});
    }

    public static int m24806a(Bundle bundle, int i) {
        if (bundle == null || i == 0) {
            C5165e.m24906b("HttpStatusCode", "bundle or errorCode is null");
            return i;
        } else if (200 != bundle.getInt("responseCode") || f18568b.get(i) == 0) {
            return i;
        } else {
            i = f18568b.get(i);
            C5165e.m24912e("HttpStatusCode", "transform errorCode = " + i + ", to " + i);
            return i;
        }
    }
}
