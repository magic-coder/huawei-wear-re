package com.tencent.open.p542b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
public class C6373b implements Serializable {
    public final HashMap<String, String> f22171a = new HashMap();

    public C6373b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f22171a.put(str, bundle.getString(str));
            }
        }
    }
}
