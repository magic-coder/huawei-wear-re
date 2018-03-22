package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MultiSIMServiceInfo */
public class C1153e {
    private static final String f2438c = C1153e.class.getSimpleName();
    ArrayList<C1155g> f2439a = new ArrayList();
    C1156h f2440b;

    public void m5135a(String str) {
        JSONObject jSONObject;
        int length;
        int i = 0;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2438c, "MultiSIMServiceInfo-parseResponseInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("PairedDeviceList");
        if (optJSONArray != null) {
            length = optJSONArray.length();
        } else {
            length = 0;
        }
        while (i < length) {
            C1155g c1155g = new C1155g();
            c1155g.m5146a(optJSONArray.get(i).toString());
            this.f2439a.add(c1155g);
            i++;
        }
        C1156h c1156h = new C1156h();
        JSONObject optJSONObject = jSONObject.optJSONObject("PrimaryDevice");
        if (optJSONObject != null) {
            c1156h.m5149a(optJSONObject.toString());
        }
        this.f2440b = c1156h;
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2438c, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }

    public ArrayList<C1155g> m5134a() {
        return this.f2439a;
    }

    public C1156h m5136b() {
        return this.f2440b;
    }
}
