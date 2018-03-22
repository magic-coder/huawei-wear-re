package com.alipay.sdk.p243a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class C3146d {
    C3145c f10519a;
    Context f10520b;

    public C3146d(Context context, C3145c c3145c) {
        this.f10520b = context;
        this.f10519a = c3145c;
    }

    public final void m13979a(C3143a c3143a) throws JSONException {
        if (TextUtils.isEmpty(c3143a.f10509c)) {
            m13980a(c3143a.f10507a, C3144b.f10515c);
            return;
        }
        Runnable c3147e = new C3147e(this, c3143a);
        if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : null) != null) {
            c3147e.run();
        } else {
            new Handler(Looper.getMainLooper()).post(c3147e);
        }
    }

    public final void m13980a(String str, int i) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(HwAccountConstants.EXTRA_OPLOG_ERROR, i - 1);
            C3143a c3143a = new C3143a("callback");
            c3143a.f10511e = jSONObject;
            c3143a.f10507a = str;
            this.f10519a.mo3669a(c3143a);
        }
    }
}
