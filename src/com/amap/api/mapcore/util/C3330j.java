package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineInitHandler */
public class C3330j extends aj<String, C3329i> {
    protected /* synthetic */ Object mo4064b(String str) throws AMapException {
        return m16180a(str);
    }

    public C3330j(Context context, String str) {
        super(context, str);
        getClass();
        m15468a(5000);
        getClass();
        m15471b(50000);
    }

    public String mo4002a() {
        return "http://restapi.amap.com/v3/config/version";
    }

    protected C3329i m16180a(String str) throws AMapException {
        C3329i c3329i = new C3329i();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("offlinemap")) {
                jSONObject = jSONObject.getJSONObject("offlinemap");
                String optString = jSONObject.optString("update", "");
                if (optString.equals("0")) {
                    c3329i.m16178a(false);
                } else if (optString.equals("1")) {
                    c3329i.m16178a(true);
                }
                c3329i.m16177a(jSONObject.optString("version", ""));
            }
        } catch (Throwable th) {
            ca.m15831a(th, "OfflineInitHandler", "loadData parseJson");
        }
        return c3329i;
    }

    public Map<String, String> mo4003b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("mapver", this.a);
        hashMap.put("output", "json");
        hashMap.put(SMSKeyInfo.TAG_KEY, bm.m15690f(this.d));
        hashMap.put("opertype", "offlinemap_with_province_vfour");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mapver=").append((String) this.a);
        stringBuffer.append("&output=json");
        stringBuffer.append("&key=").append(bm.m15690f(this.d));
        stringBuffer.append("&opertype=offlinemap_with_province_vfour");
        String a = bw.m15798a(stringBuffer.toString());
        String a2 = bo.m15699a();
        hashMap.put("ts", a2);
        hashMap.put("scode", bo.m15702a(this.d, a2, a));
        return hashMap;
    }
}
