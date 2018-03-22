package com.huawei.hwid.update.p449a;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckResponse */
class C5257b {
    private final String f18907a;
    private String f18908b = "";
    private String f18909c = "";

    public C5257b(String str) {
        this.f18907a = str;
    }

    public String m25481a() {
        if (!"0".equals(this.f18908b) || this.f18909c == null || this.f18909c.isEmpty()) {
            return null;
        }
        return C5257b.m25480b(this.f18909c);
    }

    public String toString() {
        try {
            return new JSONObject(this.f18907a).toString(2);
        } catch (JSONException e) {
            return this.f18907a;
        }
    }

    public static C5257b m25479a(String str) {
        C5257b c5257b = new C5257b(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            c5257b.f18908b = jSONObject.getString("status");
            if (!"0".equals(c5257b.f18908b)) {
                return c5257b;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("components");
            if (0 >= jSONArray.length()) {
                return c5257b;
            }
            c5257b.f18909c = jSONArray.getJSONObject(0).getString("url");
            return c5257b;
        } catch (JSONException e) {
            C5165e.m24910d("CheckResponse", "In parseResponse, Failed to parse json for check-update response." + e.getMessage());
            return new C5257b(str);
        }
    }

    private static String m25480b(String str) {
        int length = str.length();
        int i = -1;
        while (length > 0 && str.charAt(length - 1) == '/') {
            i = length;
            length--;
        }
        if (i == -1) {
            return str + "/";
        }
        return str.substring(0, i);
    }
}
