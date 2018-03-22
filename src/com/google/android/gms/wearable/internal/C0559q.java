package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.C0531q;
import com.google.android.gms.wearable.C0558p;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C0559q implements C0558p {
    private Uri f1069a;
    private byte[] f1070b;
    private Map<String, C0531q> f1071c;

    public C0559q(C0558p c0558p) {
        this.f1069a = c0558p.getUri();
        this.f1070b = c0558p.getData();
        Map hashMap = new HashMap();
        for (Entry entry : c0558p.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put((String) entry.getKey(), (C0531q) ((C0531q) entry.getValue()).freeze());
            }
        }
        this.f1071c = Collections.unmodifiableMap(hashMap);
    }

    public C0558p m2199a() {
        return this;
    }

    public String m2200a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        String valueOf = String.valueOf(this.f1069a);
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        valueOf = String.valueOf(this.f1070b == null ? "null" : Integer.valueOf(this.f1070b.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 9).append(", dataSz=").append(valueOf).toString());
        stringBuilder.append(", numAssets=" + this.f1071c.size());
        if (z && !this.f1071c.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.f1071c.entrySet()) {
                String str2 = (String) entry.getKey();
                valueOf = String.valueOf(((C0531q) entry.getValue()).getId());
                stringBuilder.append(new StringBuilder(((String.valueOf(str).length() + 2) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append(str).append(str2).append(": ").append(valueOf).toString());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public /* synthetic */ Object freeze() {
        return m2199a();
    }

    public Map<String, C0531q> getAssets() {
        return this.f1071c;
    }

    public byte[] getData() {
        return this.f1070b;
    }

    public Uri getUri() {
        return this.f1069a;
    }

    public String toString() {
        return m2200a(Log.isLoggable("DataItem", 3));
    }
}
