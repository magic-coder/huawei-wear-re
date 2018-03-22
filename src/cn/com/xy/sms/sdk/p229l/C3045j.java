package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class C3045j {
    public static Object m13620a(JSONObject jSONObject, String str) {
        if (!(str == null || jSONObject == null)) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.get(str);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "getValueFromJsonObject: " + th.getMessage(), th);
            }
        }
        return null;
    }

    public static String m13621a(JSONObject jSONObject) {
        return C3045j.m13622a(jSONObject, null, null);
    }

    public static String m13622a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return "";
        }
        try {
            jSONObject.put("id", jSONObject.optString("pubId"));
            jSONObject.put("name", jSONObject.optString("pubName"));
            jSONObject.put("classifyName", jSONObject.optString("pubType"));
            jSONObject.put("weiboName", jSONObject.optString("weiBoName"));
            jSONObject.put("weiboUrl", jSONObject.optString("weiBoUrl"));
            jSONObject.put("weixin", jSONObject.optString("weiXin"));
            jSONObject.put("logo", jSONObject.optString("rectLogoName"));
            jSONObject.put("logoc", jSONObject.optString("circleLogoName"));
            jSONObject.put("website", jSONObject.optString("webSite"));
            JSONArray optJSONArray = jSONObject.optJSONArray("pubNumInfolist");
            Object obj = (C3049n.m13653e(str) || C3049n.m13653e(str2)) ? null : 1;
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                jSONObject.put("pubnum", "");
            } else {
                int length = optJSONArray.length();
                JSONArray jSONArray = new JSONArray();
                String str3 = null;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
                    JSONObject jSONObject3 = new JSONObject();
                    String optString = jSONObject2.optString(Constants.FIELD_APPLET_CONFIG_NUM);
                    String optString2 = jSONObject2.optString("areaCode");
                    if (obj != null && optString2.contains(str2) && (str.equals(optString) || (optString.contains("*") && str.startsWith(optString.replace("*", ""))))) {
                        str3 = jSONObject2.optString("purpose");
                    }
                    jSONObject3.put("purpose", jSONObject2.optString("purpose"));
                    jSONObject3.put(Constants.FIELD_APPLET_CONFIG_NUM, optString);
                    jSONObject3.put("areaCode", optString2);
                    jSONObject3.put("extend", jSONObject2.optString("extend"));
                    jSONArray.put(jSONObject3);
                }
                if (!C3049n.m13653e(str3)) {
                    jSONObject.put("purpose", str3);
                }
                jSONObject.put("pubnum", jSONArray);
            }
            jSONObject.remove("pubId");
            jSONObject.remove("pubName");
            jSONObject.remove("pubType");
            jSONObject.remove("pubTypeCode");
            jSONObject.remove("weiXin");
            jSONObject.remove("weiBoName");
            jSONObject.remove("weiBoUrl");
            jSONObject.remove("introduce");
            jSONObject.remove(UserInfo.ADDRESS);
            jSONObject.remove("faxNum");
            jSONObject.remove("webSite");
            jSONObject.remove("versionCode");
            jSONObject.remove("email");
            jSONObject.remove("parentPubId");
            jSONObject.remove("slogan");
            jSONObject.remove("rectLogoName");
            jSONObject.remove("circleLogoName");
            jSONObject.remove("extend");
            jSONObject.remove("pubNumInfolist");
            jSONObject.remove("loadMenuTime");
            jSONObject.remove("updateInfoTime");
            jSONObject.remove("hasmenu");
            return jSONObject.toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoToJson: " + th.getMessage(), th);
            return "";
        }
    }

    public static JSONObject m13623a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Class cls = obj.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                jSONObject.put(field.getName(), field.get(obj));
            }
            jSONObject.put("objectToJson", true);
            jSONObject.put("className", cls.getName());
            return jSONObject;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "parseObjectToJson obj:" + obj + " error:" + th.getMessage(), th);
            return null;
        }
    }

    public static JSONObject m13624a(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    return new JSONObject(map);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "changeMapToJason: " + th, th);
                return null;
            }
        }
        return null;
    }

    public static JSONObject m13625a(JSONObject jSONObject, String... strArr) {
        if (strArr == null || jSONObject == null) {
            return null;
        }
        int length = strArr.length;
        if (length == 0 || length % 2 != 0) {
            return null;
        }
        int i = 0;
        while (i < length) {
            try {
                if (!(strArr[i] == null || strArr[i + 1] == null)) {
                    jSONObject.put(strArr[i], strArr[i + 1]);
                }
                i += 2;
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "getJsonObject: " + e.getMessage(), e);
                return null;
            }
        }
        return jSONObject;
    }
}
