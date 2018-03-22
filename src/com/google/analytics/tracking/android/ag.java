package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: GAServiceProxy */
class ag {
    private final Map<String, String> f14052a;
    private final long f14053b;
    private final String f14054c;
    private final List<Command> f14055d;

    public ag(Map<String, String> map, long j, String str, List<Command> list) {
        this.f14052a = map;
        this.f14053b = j;
        this.f14054c = str;
        this.f14055d = list;
    }

    public Map<String, String> m18208a() {
        return this.f14052a;
    }

    public long m18209b() {
        return this.f14053b;
    }

    public String m18210c() {
        return this.f14054c;
    }

    public List<Command> m18211d() {
        return this.f14055d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PATH: ");
        stringBuilder.append(this.f14054c);
        if (this.f14052a != null) {
            stringBuilder.append("  PARAMS: ");
            for (Entry entry : this.f14052a.entrySet()) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append(",  ");
            }
        }
        return stringBuilder.toString();
    }
}
