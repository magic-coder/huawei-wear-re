package com.alipay.sdk.p243a;

import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

final class C3147e implements Runnable {
    final /* synthetic */ C3143a f10521a;
    final /* synthetic */ C3146d f10522b;

    C3147e(C3146d c3146d, C3143a c3143a) {
        this.f10522b = c3146d;
        this.f10521a = c3143a;
    }

    public final void run() {
        int i;
        C3146d c3146d = this.f10522b;
        C3143a c3143a = this.f10521a;
        if (c3143a != null && "toast".equals(c3143a.f10509c)) {
            JSONObject jSONObject = c3143a.f10511e;
            CharSequence optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("duration");
            i = 1;
            if (optInt < DefaultRetryPolicy.DEFAULT_TIMEOUT_MS) {
                i = 0;
            }
            Toast.makeText(c3146d.f10520b, optString, i).show();
            new Timer().schedule(new C3148f(c3146d, c3143a), (long) i);
        }
        i = C3144b.f10513a;
        if (i != C3144b.f10513a) {
            try {
                this.f10522b.m13980a(this.f10521a.f10507a, i);
            } catch (JSONException e) {
            }
        }
    }
}
