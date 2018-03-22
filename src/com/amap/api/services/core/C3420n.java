package com.amap.api.services.core;

import android.content.Context;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.snowballtech.business.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.json.JSONObject;

/* compiled from: ManifestManager */
class C3420n extends bt {
    private Context f12491a;
    private String f12492b;

    public C3420n(Context context) {
        this.f12491a = context;
        this.f12492b = C3434w.m16993f(context);
    }

    public C3421o m16965a() {
        String str = "feachManifest";
        try {
            bs a = bs.m16858a(false);
            m16563a(ac.m16598a(this.f12491a));
            return m16961a(a.m16868a((bt) this));
        } catch (Throwable e) {
            C3409d.m16881a(e, "ManifestManager", str);
            return null;
        }
    }

    private JSONObject m16962a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    private String m16964b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optString(str);
    }

    private boolean m16963a(String str) {
        if (str != null && str.equals("1")) {
            return true;
        }
        return false;
    }

    private C3421o m16961a(byte[] bArr) {
        String str = "loadData";
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("status");
            if ("0".equals(optString) || !"1".equals(optString)) {
                return null;
            }
            JSONObject a = m16962a(jSONObject, "result");
            return new C3421o(m16963a(m16964b(m16962a(m16962a(a, "common"), "commoninfo"), "com_isupload")), m16963a(m16964b(m16962a(m16962a(a, JoinConstants.EXCEPTION), "exceptinfo"), "ex_isupload")));
        } catch (Throwable e) {
            C3409d.m16881a(e, "ManifestManager", str);
            return null;
        } catch (Throwable e2) {
            C3409d.m16881a(e2, "ManifestManager", str);
            return null;
        }
    }

    public Map<String, String> d_() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("User-Agent", "AMAP SDK Android Search 2.5.0");
        return hashMap;
    }

    public Map<String, String> c_() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(SMSKeyInfo.TAG_KEY, this.f12492b);
        hashMap.put("opertype", "common;exception");
        hashMap.put("plattype", "android");
        hashMap.put(BuildConfig.environment, "sea");
        hashMap.put("version", "2.5.0");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(this.f12492b);
        stringBuffer.append("&opertype=common;exception");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append("sea");
        stringBuffer.append("&version=").append("2.5.0");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = ae.m16619a(stringBuffer.toString());
        String a2 = C3436y.m16996a();
        hashMap.put("ts", a2);
        hashMap.put("scode", C3436y.m17000a(this.f12491a, a2, a));
        return hashMap;
    }

    public String mo4103b() {
        return C3408c.m16874a() + "/config/resource";
    }

    public HttpEntity mo4099e() {
        return null;
    }
}
