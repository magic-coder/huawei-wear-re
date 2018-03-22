package com.tencent.open.yyb;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6434j {
    private WebView f22318a;
    private Activity f22319b;

    public C6434j(Activity activity, WebView webView) {
        this.f22319b = activity;
        this.f22318a = webView;
    }

    public void m29328a() {
        m29332a("clickCallback", 0, null, "");
    }

    public int m29335b() {
        return 1;
    }

    public void m29330a(String str) {
        C6367n.m29107b("openSDK_LOG", "-->invoke : url = " + str);
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        C6367n.m29107b("openSDK_LOG", "-->invoke : hostAsMethodName = " + host);
        if (!TextUtils.isEmpty(host)) {
            int i;
            List pathSegments = parse.getPathSegments();
            String str2 = null;
            if (pathSegments == null || pathSegments.size() <= 0) {
                i = 0;
            } else {
                i = C6412y.m29268j((String) pathSegments.get(0));
                if (pathSegments.size() > 1) {
                    str2 = (String) pathSegments.get(1);
                }
            }
            C6367n.m29107b("openSDK_LOG", "-->invoke : seqid = " + i + " callbackName = " + str2);
            if (host.equals("callBatch")) {
                try {
                    JSONArray jSONArray = new JSONArray(parse.getQueryParameter("param"));
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String string = jSONObject.getString(Constant.KEY_METHOD);
                        int i3 = jSONObject.getInt("seqid");
                        String optString = jSONObject.optString("callback");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("args");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("jsb://").append(string).append("/").append(i3).append("/").append(!TextUtils.isEmpty(optString) ? optString : "").append(LocationInfo.NA);
                        if (jSONObject2 != null) {
                            Iterator keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                stringBuilder.append(str3).append("=").append(Uri.encode(Uri.decode(jSONObject2.getString(str3)))).append(SNBConstant.FILTER);
                            }
                        }
                        m29326a(Uri.parse(stringBuilder.toString()), string, i3, optString);
                    }
                    return;
                } catch (Exception e) {
                    if (!TextUtils.isEmpty(str2)) {
                        m29331a(str2, i, host, -5);
                        return;
                    }
                    return;
                }
            }
            m29326a(parse, host, i, str2);
        }
    }

    private void m29326a(Uri uri, String str, int i, String str2) {
        C6367n.m29107b("openSDK_LOG", "-->callAMethod : uri = " + uri);
        if (m29327b(str)) {
            try {
                C6434j.class.getDeclaredMethod(str, new Class[]{Uri.class, Integer.TYPE, String.class, String.class}).invoke(this, new Object[]{uri, Integer.valueOf(i), str, str2});
            } catch (Exception e) {
                C6367n.m29107b("openSDK_LOG", "-->callAMethod : Exception = " + e.getMessage());
                e.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                    m29331a(str2, i, str, -3);
                }
            }
        } else if (!TextUtils.isEmpty(str2)) {
            m29331a(str2, i, str, -5);
        }
    }

    private boolean m29327b(String str) {
        return true;
    }

    public void m29337c() {
        m29332a("readyCallback", 1, null, "true");
    }

    public void m29329a(int i) {
        Map hashMap = new HashMap();
        hashMap.put("type", i + "");
        m29333a("shareCallback", 0, null, "0", hashMap);
    }

    public void m29336b(int i) {
        Map hashMap = new HashMap();
        hashMap.put("type", i + "");
        m29333a("shareCallback", 0, null, "1", hashMap);
    }

    public void m29332a(String str, int i, String str2, String str3) {
        m29333a(str, i, str2, str3, null);
    }

    public void m29333a(String str, int i, String str2, String str3, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", 0);
                jSONObject.put("data", str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(Constant.KEY_METHOD, str2);
                }
                jSONObject.put("seqid", i);
                if (map != null) {
                    for (String str4 : map.keySet()) {
                        jSONObject.put(str4, map.get(str4));
                    }
                }
                m29334a(str, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m29331a(String str, int i, String str2, int i2) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", -1);
                jSONObject.put("code", i2);
                jSONObject.put(Constant.KEY_METHOD, str2);
                jSONObject.put("seqid", i);
                m29334a(str, jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m29334a(String str, String str2) {
        if (this.f22318a != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!").append(str).append("){");
            stringBuffer.append(str);
            stringBuffer.append("(");
            stringBuffer.append(str2);
            stringBuffer.append(")}");
            this.f22318a.loadUrl(stringBuffer.toString());
        }
    }
}
