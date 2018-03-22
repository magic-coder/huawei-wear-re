package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.C0402j;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C0531q;
import com.google.android.gms.wearable.C0558p;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.cookie.ClientCookie;

public final class C0561s extends C0402j implements C0558p {
    private final int f1072c;

    public C0561s(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f1072c = i2;
    }

    public C0558p m2204a() {
        return new C0559q(this);
    }

    public String m2205a(boolean z) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        String valueOf = String.valueOf(getUri());
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        String valueOf2 = String.valueOf(data == null ? "null" : Integer.valueOf(data.length));
        stringBuilder.append(new StringBuilder(String.valueOf(valueOf2).length() + 9).append(", dataSz=").append(valueOf2).toString());
        stringBuilder.append(", numAssets=" + assets.size());
        if (z && !assets.isEmpty()) {
            stringBuilder.append(", assets=[");
            valueOf = "";
            for (Entry entry : assets.entrySet()) {
                String str = (String) entry.getKey();
                valueOf2 = String.valueOf(((C0531q) entry.getValue()).getId());
                stringBuilder.append(new StringBuilder(((String.valueOf(valueOf).length() + 2) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(": ").append(valueOf2).toString());
                valueOf = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public /* synthetic */ Object freeze() {
        return m2204a();
    }

    public Map<String, C0531q> getAssets() {
        Map<String, C0531q> hashMap = new HashMap(this.f1072c);
        for (int i = 0; i < this.f1072c; i++) {
            C0557p c0557p = new C0557p(this.a, this.b + i);
            if (c0557p.getDataItemKey() != null) {
                hashMap.put(c0557p.getDataItemKey(), c0557p);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return m475c("data");
    }

    public Uri getUri() {
        return Uri.parse(m474b(ClientCookie.PATH_ATTR));
    }

    public String toString() {
        return m2205a(Log.isLoggable("DataItem", 3));
    }
}
