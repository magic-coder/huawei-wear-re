package com.huawei.openalliance.ad.p112a.p122h;

import com.amap.api.location.LocationManagerProxy;
import com.huawei.openalliance.ad.p112a.p113a.C1214a;
import com.huawei.openalliance.ad.p112a.p113a.C1235b;
import com.huawei.openalliance.ad.p112a.p113a.C1238e;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.huawei.openalliance.ad.utils.C1365i;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1288g {
    public static String m5690a(String str, C1211a c1211a) {
        if (C1365i.m6081a(str)) {
            C1336d.m5888c("InterConfusion", "original string is null!");
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return c1211a instanceof C1214a ? C1288g.m5691a(jSONObject) : c1211a instanceof C1235b ? C1288g.m5692b(jSONObject) : c1211a instanceof C1238e ? C1288g.m5694d(jSONObject) : str;
        } catch (JSONException e) {
            C1336d.m5888c("InterConfusion", "parse original string to json failed!");
            return str;
        } catch (Exception e2) {
            C1336d.m5888c("InterConfusion", "parse original string to json failed!");
            return str;
        }
    }

    private static String m5691a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            JSONObject jSONObject2;
            if (!jSONObject.isNull("device")) {
                jSONObject2 = jSONObject.getJSONObject("device");
                jSONObject2.put("androidid", "******");
                jSONObject2.put("imei", "******");
                jSONObject2.put("mac", "******");
                jSONObject2.put("userAccount", "******");
            }
            if (!jSONObject.isNull(LocationManagerProxy.NETWORK_PROVIDER)) {
                jSONObject2 = jSONObject.getJSONObject(LocationManagerProxy.NETWORK_PROVIDER);
                jSONObject2.put("cellInfo", "******");
                jSONObject2.put("wifiInfo", "******");
            }
        } catch (JSONException e) {
            jSONObject.remove("device");
            jSONObject.remove(LocationManagerProxy.NETWORK_PROVIDER);
            C1336d.m5888c("InterConfusion", "fail to confuse adcontentreq");
        }
        return jSONObject.toString();
    }

    private static String m5692b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            JSONArray jSONArray;
            int i;
            if (!jSONObject.isNull("multiad")) {
                try {
                    jSONArray = jSONObject.getJSONArray("multiad");
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (!jSONArray.isNull(i)) {
                            C1288g.m5693c((JSONObject) jSONArray.get(i));
                        }
                    }
                } catch (JSONException e) {
                    C1336d.m5888c("InterConfusion", "fail to confuse adcontentrsp");
                }
            }
            if (!jSONObject.isNull("sloganList")) {
                try {
                    jSONArray = jSONObject.getJSONArray("sloganList");
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (!jSONArray.isNull(i)) {
                            ((JSONObject) jSONArray.get(i)).put("paramfromserver", "******");
                        }
                    }
                } catch (JSONException e2) {
                    C1336d.m5888c("InterConfusion", "fail to confuse adcontentrsp");
                }
            }
        } catch (Exception e3) {
            jSONObject.remove("multiad");
            C1336d.m5888c("InterConfusion", "fail to confuse adcontentrsp");
        }
        return jSONObject.toString();
    }

    private static void m5693c(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull("content")) {
            JSONArray jSONArray = jSONObject.getJSONArray("content");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!jSONArray.isNull(i)) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    jSONObject2.put("paramfromserver", "******");
                    if (!jSONObject2.isNull("impmonitorurl")) {
                        jSONObject2.put("impmonitorurl", "******");
                    }
                    if (!jSONObject2.isNull("clickmonitorurl")) {
                        jSONObject2.put("clickmonitorurl", "******");
                    }
                }
            }
        }
    }

    private static String m5694d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        try {
            if (!jSONObject.isNull("event")) {
                JSONArray jSONArray = jSONObject.getJSONArray("event");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!jSONArray.isNull(i)) {
                        ((JSONObject) jSONArray.get(i)).put("paramfromserver", "******");
                    }
                }
            }
        } catch (JSONException e) {
            C1336d.m5888c("InterConfusion", "fail to confuse eventreq");
        } catch (Exception e2) {
            jSONObject.remove("event");
            C1336d.m5888c("InterConfusion", "fail to confuse eventreq");
        }
        return jSONObject.toString();
    }
}
