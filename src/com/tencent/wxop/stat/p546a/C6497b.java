package com.tencent.wxop.stat.p546a;

import org.json.JSONArray;
import org.json.JSONObject;

public final class C6497b {
    public String f22574a;
    public JSONArray f22575b;
    public JSONObject f22576c = null;

    public C6497b(String str) {
        this.f22574a = str;
        this.f22576c = new JSONObject();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6497b)) {
            return false;
        }
        return toString().equals(((C6497b) obj).toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.f22574a).append(",");
        if (this.f22575b != null) {
            stringBuilder.append(this.f22575b.toString());
        }
        if (this.f22576c != null) {
            stringBuilder.append(this.f22576c.toString());
        }
        return stringBuilder.toString();
    }
}
