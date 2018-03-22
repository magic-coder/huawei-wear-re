package com.huawei.hms.update.p045a;

import com.huawei.hms.support.log.C0887a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckResponse */
class C0895b {
    private final String f1453a;
    private String f1454b = "";
    private String f1455c = "";

    public C0895b(String str) {
        this.f1453a = str;
    }

    public String m3127a() {
        if (!"0".equals(this.f1454b) || this.f1455c == null || this.f1455c.isEmpty()) {
            return null;
        }
        return C0895b.m3126b(this.f1455c);
    }

    public String toString() {
        try {
            return new JSONObject(this.f1453a).toString(2);
        } catch (JSONException e) {
            return this.f1453a;
        }
    }

    public static C0895b m3125a(String str) {
        C0895b c0895b = new C0895b(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            c0895b.f1454b = jSONObject.getString("status");
            if (!"0".equals(c0895b.f1454b)) {
                return c0895b;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("components");
            if (0 >= jSONArray.length()) {
                return c0895b;
            }
            c0895b.f1455c = jSONArray.getJSONObject(0).getString("url");
            return c0895b;
        } catch (JSONException e) {
            C0887a.m3098d("CheckResponse", "In parseResponse, Failed to parse json for check-update response." + e.getMessage());
            return new C0895b(str);
        }
    }

    private static String m3126b(String str) {
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
