package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.ez;
import java.util.ArrayList;

public class ac extends Exception {
    private final ArrayMap<ez<?>, ConnectionResult> f271a;

    public ac(ArrayMap<ez<?>, ConnectionResult> arrayMap) {
        this.f271a = arrayMap;
    }

    public ArrayMap<ez<?>, ConnectionResult> m337a() {
        return this.f271a;
    }

    public ConnectionResult m338a(ad<? extends C0344b> adVar) {
        ez b = adVar.m344b();
        C0424f.m658b(this.f271a.get(b) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.f271a.get(b);
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (ez ezVar : this.f271a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f271a.get(ezVar);
            if (connectionResult.isSuccess()) {
                obj = null;
            }
            String valueOf = String.valueOf(ezVar.m1468a());
            String valueOf2 = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }
}
