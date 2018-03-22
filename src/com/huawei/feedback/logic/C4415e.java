package com.huawei.feedback.logic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.feedback.a.b.a;
import com.huawei.feedback.bean.C4406b;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.p306a.p307a.p308a.C3937a;
import com.huawei.p306a.p307a.p308a.C3938c;
import com.huawei.phoneserviceuni.common.d.c;
import com.huawei.phoneserviceuni.common.p491a.C5755a;
import com.huawei.ui.main.stories.nps.interactors.mode.Url;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FeedbackGetConfig */
public class C4415e implements Runnable {
    private Handler f16398a;
    private Context f16399b;
    private int f16400c;

    public C4415e(Handler handler, Context context, int i) {
        this.f16398a = handler;
        this.f16399b = context;
        this.f16400c = i;
        c.b("FeedbackGetConfig", "FeedbackGetConfig appId== " + i);
    }

    public void run() {
        C3938c a = m21251a();
        if (a != null) {
            try {
                m21253a(a.m19587a());
            } catch (Exception e) {
                c.a(e, "FeedbackGetConfig");
            } catch (Exception e2) {
                c.a(e2, "FeedbackGetConfig");
            }
        }
    }

    private void m21253a(String str) {
        c.a("FeedbackGetConfig", "jsonStr: " + str);
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("status") == 0) {
                jSONObject = jSONObject.optJSONObject("data");
                if (jSONObject != null) {
                    C4406b a = m21252a(jSONObject);
                    c.a("FeedbackGetConfig", "serviceItem: " + a.m21138g());
                    Message message = new Message();
                    message.obj = a;
                    message.what = 1000;
                    this.f16398a.sendMessage(message);
                }
            }
        }
    }

    private C4406b m21252a(JSONObject jSONObject) {
        int i = 0;
        C4406b c4406b = new C4406b();
        if (jSONObject == null) {
            return c4406b;
        }
        int i2;
        JSONObject jSONObject2;
        int optInt;
        c.a("FeedbackGetConfig", "appId: " + this.f16400c);
        JSONArray optJSONArray = jSONObject.optJSONArray("QQService");
        if (optJSONArray != null) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                jSONObject2 = optJSONArray.getJSONObject(i2);
                c.a("FeedbackGetConfig", "qq appId: " + this.f16400c);
                if (jSONObject2.optInt(AppOpenOrDownHelper.APP_ID_PARAM) == this.f16400c) {
                    c4406b.m21127a(jSONObject2.optString("name"));
                    c4406b.m21129b(jSONObject2.optString("qqNum"));
                    break;
                }
            }
        }
        optJSONArray = jSONObject.optJSONArray("netpoliceService");
        if (optJSONArray != null) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                jSONObject2 = optJSONArray.getJSONObject(i2);
                optInt = jSONObject2.optInt(AppOpenOrDownHelper.APP_ID_PARAM);
                c.a("test_ly", "police id: " + optInt);
                if (optInt == this.f16400c) {
                    c4406b.m21131c(jSONObject2.optString("name"));
                    c4406b.m21133d(jSONObject2.optString("url"));
                    break;
                }
            }
        }
        optJSONArray = jSONObject.optJSONArray("exclusiveHotline");
        if (optJSONArray != null) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                jSONObject2 = optJSONArray.getJSONObject(i2);
                optInt = jSONObject2.optInt(AppOpenOrDownHelper.APP_ID_PARAM);
                c.a("test_ly", "hotline id: " + optInt);
                if (optInt == this.f16400c) {
                    c4406b.m21135e(jSONObject2.optString("name"));
                    c4406b.m21137f(jSONObject2.optString("tel"));
                    break;
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("jsEnableDomains");
        if (optJSONArray2 != null) {
            HashSet hashSet = new HashSet();
            while (i < optJSONArray2.length()) {
                hashSet.add(optJSONArray2.getString(i));
                i++;
            }
            a.a().a(this.f16399b, hashSet);
        }
        return c4406b;
    }

    private C3938c m21251a() {
        C3937a c3937a = new C3937a(this.f16399b, "https://", Url.OnLine_Host_Https, "v2/getConfig.htm", m21254b());
        c3937a.m19586a(5000);
        try {
            return c3937a.m19584a();
        } catch (Exception e) {
            c.a(e, "FeedbackGetConfig");
            return null;
        } catch (Exception e2) {
            c.a(e2, "FeedbackGetConfig");
            return null;
        } catch (Exception e22) {
            c.a(e22, "FeedbackGetConfig");
            return null;
        }
    }

    private Map<String, String> m21254b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("dataVersion", "0");
        String b = C5755a.m26428b();
        if (!TextUtils.isEmpty(b) && b.length() >= 5) {
            hashMap.put(UploadFile.DEVICE_IMSI_LABEL, b.substring(0, 5));
        }
        hashMap.put("deviceFlag", Integer.toString(com.huawei.phoneserviceuni.common.d.a.t()));
        return hashMap;
    }
}
