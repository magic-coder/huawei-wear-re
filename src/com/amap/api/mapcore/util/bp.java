package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.sina.weibo.sdk.component.GameManager;
import com.snowballtech.business.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigManager */
public class bp {

    /* compiled from: ConfigManager */
    public class C3294a {
        public JSONObject f11524a;
        public JSONObject f11525b;
        public JSONObject f11526c;
        public C3291a f11527d;
        public C3293c f11528e;
        public C3292b f11529f;

        /* compiled from: ConfigManager */
        public class C3291a {
            public boolean f11517a;
            public boolean f11518b;
        }

        /* compiled from: ConfigManager */
        public class C3292b {
            public String f11519a;
            public String f11520b;
        }

        /* compiled from: ConfigManager */
        public class C3293c {
            public String f11521a;
            public String f11522b;
            public String f11523c;
        }
    }

    /* compiled from: ConfigManager */
    class C3295b extends dp {
        private Context f11530a;
        private bv f11531b;
        private String f11532c = "";

        C3295b(Context context, bv bvVar, String str) {
            this.f11530a = context;
            this.f11531b = bvVar;
            this.f11532c = str;
        }

        public Map<String, String> mo4004c() {
            Map<String, String> hashMap = new HashMap();
            hashMap.put("User-Agent", this.f11531b.m15794c());
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f11531b.m15793b(), this.f11531b.m15791a()}));
            hashMap.put("logversion", "2.0");
            return hashMap;
        }

        public Map<String, String> mo4003b() {
            Object q = bq.m15739q(this.f11530a);
            if (!TextUtils.isEmpty(q)) {
                q = bs.m15758b(new StringBuilder(q).reverse().toString());
            }
            Map hashMap = new HashMap();
            hashMap.put(SMSKeyInfo.TAG_KEY, bm.m15690f(this.f11530a));
            hashMap.put("opertype", this.f11532c);
            hashMap.put("plattype", "android");
            hashMap.put(BuildConfig.environment, this.f11531b.m15791a());
            hashMap.put("version", this.f11531b.m15793b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", VERSION.SDK_INT + "");
            hashMap.put("deviceId", q);
            hashMap.put("abitype", Build.CPU_ABI);
            hashMap.put("ext", this.f11531b.m15795d());
            String a = bo.m15699a();
            String a2 = bo.m15702a(this.f11530a, a, bw.m15805b(hashMap));
            hashMap.put("ts", a);
            hashMap.put("scode", a2);
            return hashMap;
        }

        public String mo4002a() {
            return "https://restapi.amap.com/v3/config/resource?";
        }
    }

    public static C3294a m15711a(byte[] bArr) {
        boolean z = false;
        C3294a c3294a = new C3294a();
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, GameManager.DEFAULT_CHARSET));
                    if ("1".equals(m15712a(jSONObject, "status")) && jSONObject.has("result")) {
                        jSONObject = jSONObject.getJSONObject("result");
                        if (jSONObject != null) {
                            boolean b;
                            JSONObject jSONObject2;
                            if (bw.m15802a(jSONObject, JoinConstants.EXCEPTION)) {
                                b = m15717b(jSONObject.getJSONObject(JoinConstants.EXCEPTION));
                            } else {
                                b = false;
                            }
                            if (bw.m15802a(jSONObject, "common")) {
                                z = m15716a(jSONObject.getJSONObject("common"));
                            }
                            C3291a c3291a = new C3291a();
                            c3291a.f11517a = b;
                            c3291a.f11518b = z;
                            c3294a.f11527d = c3291a;
                            if (jSONObject.has("sdkupdate")) {
                                jSONObject2 = jSONObject.getJSONObject("sdkupdate");
                                C3293c c3293c = new C3293c();
                                m15714a(jSONObject2, c3293c);
                                c3294a.f11528e = c3293c;
                            }
                            if (bw.m15802a(jSONObject, "sdkcoordinate")) {
                                jSONObject2 = jSONObject.getJSONObject("sdkcoordinate");
                                C3292b c3292b = new C3292b();
                                m15713a(jSONObject2, c3292b);
                                c3294a.f11529f = c3292b;
                            }
                            if (bw.m15802a(jSONObject, "callamap")) {
                                c3294a.f11525b = jSONObject.getJSONObject("callamap");
                            }
                            if (bw.m15802a(jSONObject, "ca")) {
                                c3294a.f11526c = jSONObject.getJSONObject("ca");
                            }
                            if (bw.m15802a(jSONObject, "locate")) {
                                c3294a.f11524a = jSONObject.getJSONObject("locate");
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                cd.m15825a(e, "ConfigManager", "loadConfig");
            } catch (Throwable e2) {
                cd.m15825a(e2, "ConfigManager", "loadConfig");
            } catch (Throwable e22) {
                cd.m15825a(e22, "ConfigManager", "loadConfig");
            }
        }
        return c3294a;
    }

    public static C3294a m15710a(Context context, bv bvVar, String str) {
        try {
            return m15711a(new dk().m16061a(new C3295b(context, bvVar, str)));
        } catch (Throwable e) {
            cd.m15825a(e, "ConfigManager", "loadConfig");
            return new C3294a();
        } catch (Throwable e2) {
            cd.m15825a(e2, "ConfigManager", "loadConfig");
            return new C3294a();
        }
    }

    private static boolean m15715a(String str) {
        if (str != null && str.equals("1")) {
            return true;
        }
        return false;
    }

    public static String m15712a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) {
            return str2;
        }
        return jSONObject.optString(str);
    }

    private static void m15713a(JSONObject jSONObject, C3292b c3292b) {
        if (jSONObject != null) {
            try {
                String a = m15712a(jSONObject, "md5");
                String a2 = m15712a(jSONObject, "url");
                c3292b.f11520b = a;
                c3292b.f11519a = a2;
            } catch (Throwable e) {
                cd.m15825a(e, "ConfigManager", "parseSDKCoordinate");
            } catch (Throwable e2) {
                cd.m15825a(e2, "ConfigManager", "parseSDKCoordinate");
            }
        }
    }

    private static void m15714a(JSONObject jSONObject, C3293c c3293c) {
        if (jSONObject != null) {
            try {
                Object a = m15712a(jSONObject, "md5");
                Object a2 = m15712a(jSONObject, "url");
                Object a3 = m15712a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    c3293c.f11521a = a2;
                    c3293c.f11522b = a;
                    c3293c.f11523c = a3;
                }
            } catch (Throwable e) {
                cd.m15825a(e, "ConfigManager", "parseSDKUpdate");
            } catch (Throwable e2) {
                cd.m15825a(e2, "ConfigManager", "parseSDKUpdate");
            }
        }
    }

    private static boolean m15716a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                z = m15715a(m15712a(jSONObject.getJSONObject("commoninfo"), "com_isupload"));
            } catch (Throwable e) {
                cd.m15825a(e, "ConfigManager", "parseCommon");
            } catch (Throwable e2) {
                cd.m15825a(e2, "ConfigManager", "parseCommon");
            }
        }
        return z;
    }

    private static boolean m15717b(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null) {
            try {
                z = m15715a(m15712a(jSONObject.getJSONObject("exceptinfo"), "ex_isupload"));
            } catch (Throwable e) {
                cd.m15825a(e, "ConfigManager", "parseException");
            } catch (Throwable e2) {
                cd.m15825a(e2, "ConfigManager", "parseException");
            }
        }
        return z;
    }
}
