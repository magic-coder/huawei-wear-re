package cn.com.xy.sms.sdk.p216h.p217a;

import android.content.ContentValues;
import android.telephony.TelephonyManager;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p208d.p211c.C2942i;
import cn.com.xy.sms.sdk.p208d.p211c.C2943j;
import cn.com.xy.sms.sdk.p208d.p211c.C2946m;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2948o;
import cn.com.xy.sms.sdk.p208d.p211c.C2951r;
import cn.com.xy.sms.sdk.p208d.p211c.af;
import cn.com.xy.sms.sdk.p208d.p211c.ah;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2924b;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2931i;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2932j;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2933k;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2998b;
import cn.com.xy.sms.sdk.p216h.C3006k;
import cn.com.xy.sms.sdk.p229l.C3041f;
import cn.com.xy.sms.sdk.p229l.C3042g;
import cn.com.xy.sms.sdk.p229l.C3045j;
import cn.com.xy.sms.sdk.p229l.C3049n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.SiteCountryInfo;
import com.huawei.hwid.core.datatype.UserInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class C2991i {
    public static int f10118a = 0;
    public static int f10119b = 1;
    private static final ExecutorService f10120c = Executors.newSingleThreadExecutor();
    private static int f10121d = -1;
    private static String f10122e = null;

    public static String m13443a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (C2917a.f9899i.equals(C2998b.f10154a)) {
                jSONObject.put("secdata", "XYSELF_" + System.currentTimeMillis());
            } else {
                jSONObject.put("secdata", C3006k.f10165k + HwAccountConstants.SPLIIT_UNDERLINE + System.currentTimeMillis());
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil QueryNewTokenRequest: " + e.getMessage(), e);
            return "";
        }
    }

    public static String m13444a(String str) {
        StringBuffer c = C2991i.m13467c();
        c.append("<QueryToken>");
        c.append("<sdkVersion>");
        c.append(C2973a.m13384f());
        c.append("</sdkVersion>");
        c.append("<iccid>" + str + "</iccid>");
        c.append("</QueryToken>");
        return c.toString();
    }

    public static String m13445a(String str, int i) {
        StringBuffer c = C2991i.m13467c();
        c.append("<checkResourseRequest>");
        c.append("<sdk_version>");
        c.append(C2973a.m13384f());
        c.append("</sdk_version>");
        c.append("<res_type>");
        c.append(i);
        c.append("</res_type>");
        c.append("<res_version>");
        c.append(str);
        c.append("</res_version>");
        c.append("</checkResourseRequest>");
        return c.toString();
    }

    public static String m13446a(String str, int i, int i2) {
        StringBuffer c = C2991i.m13467c();
        c.append("<UpdatePublicInfoRequest>");
        c.append("<PublicInfoVersion>");
        c.append(str);
        c.append("</PublicInfoVersion>");
        c.append("<status>");
        c.append(i);
        c.append("</status>");
        c.append("<count>");
        c.append(i2);
        c.append("</count>");
        c.append("</UpdatePublicInfoRequest>");
        return c.toString();
    }

    public static String m13447a(String str, Object obj) {
        try {
            if (C3049n.m13653e(str) || obj == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("area", str);
            if (obj instanceof String) {
                if (!C3049n.m13653e((String) obj)) {
                    jSONArray.put((String) obj);
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2 == null || jSONArray2.length() <= 0) {
                    return null;
                }
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.optString(i));
                }
            }
            jSONObject.put("arr", jSONArray);
            return jSONObject.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil getQueryPubIdReq: " + e.getMessage(), e);
            return "";
        }
    }

    private static String m13448a(String str, String str2) {
        if (C3049n.m13653e(str) || C3049n.m13653e(str2)) {
            return null;
        }
        CharSequence stringBuilder = new StringBuilder();
        for (String str3 : str2.split(";&XY_PIX&;")) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append(C2991i.m13470f(str3));
        }
        if (stringBuilder.length() == 0) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("<numSign sign=\"").append(stringBuilder).append("\">");
        stringBuilder2.append(str);
        stringBuilder2.append("</numSign>");
        return stringBuilder2.toString();
    }

    public static String m13449a(String str, String str2, String str3) {
        StringBuffer c = C2991i.m13467c();
        String e = C2991i.m13469e(str2);
        if (e == null) {
            e = "";
        }
        c.append("<QueryLocationRequest>");
        c.append("<cNum>");
        c.append(str);
        c.append("</cNum>");
        c.append("<iccid>" + str2 + "</iccid>");
        c.append("<num>" + str3 + "</num>");
        c.append("<mid>" + e + "</mid>");
        c.append("</QueryLocationRequest>");
        return c.toString();
    }

    public static String m13450a(String str, String str2, String str3, String str4) {
        StringBuffer c = C2991i.m13467c();
        c.append("<queryIccidSceneRequest>");
        c.append("<iccid>");
        c.append(str);
        c.append("</iccid>");
        c.append("<cmd>" + str2 + "</cmd>");
        c.append("<imei>" + str3 + "</imei>");
        c.append("<sceneId>" + str4 + "</sceneId>");
        c.append("</queryIccidSceneRequest>");
        return c.toString();
    }

    public static String m13451a(String str, String str2, String str3, String str4, String str5) {
        C2924b a = !C2925c.m13169a() ? null : C2925c.m13160a(C3049n.m13646b(str), true);
        String str6 = a == null ? "" : a.f9917c;
        try {
            StringBuffer c = C2991i.m13467c();
            c.append("<QueryPubInfoRequest>");
            c.append("<cnum>");
            if (str2 != null) {
                str6 = str2;
            }
            c.append(str6);
            c.append("</cnum>");
            c.append("<areaCode>" + str3 + "</areaCode>");
            c.append("<iccid>" + str4 + "</iccid>");
            c.append("<type>" + str5 + "</type>");
            StringBuffer stringBuffer = new StringBuffer();
            if ("1".equals(str5)) {
                if (a != null) {
                    Object obj = a.f9919e == 1 ? 1 : null;
                    if (!(obj == null || C3049n.m13653e(a.f9916b))) {
                        c.append("<sign>");
                        c.append(C2991i.m13471g(a.f9916b));
                        c.append("</sign>");
                        int a2 = C2928f.m13174a(a.f9915a, str3);
                        if (a2 != -1) {
                            stringBuffer.append(" f=\"").append(a2).append("\" ");
                        }
                    }
                    Object obj2 = a.f9920f == 1 ? 1 : null;
                    if (!(obj2 == null || C3049n.m13653e(a.f9918d))) {
                        str6 = C2991i.m13448a(str, a.f9918d);
                        if (!C3049n.m13653e(str6)) {
                            c.append("<unSubscribe>");
                            c.append(str6);
                            c.append("</unSubscribe>");
                        }
                    }
                    Object obj3 = a.f9926l == 1 ? 1 : null;
                    if (!(obj3 == null || C3049n.m13653e(a.f9925k))) {
                        c.append("<ec>");
                        c.append(a.f9925k);
                        c.append("</ec>");
                    }
                    if (!(obj == null && obj2 == null && obj3 == null)) {
                        C2925c.m13164a(a.f9915a, 0, 0);
                    }
                }
                str6 = C2991i.m13461b(str, 10);
                if (!C3049n.m13653e(str6)) {
                    c.append("<shard>");
                    c.append(str6);
                    c.append("</shard>");
                }
            }
            c.append("<num");
            if (stringBuffer.length() > 0) {
                c.append(stringBuffer);
            }
            c.append(">");
            c.append(str);
            c.append("</num>");
            c.append("</QueryPubInfoRequest>");
            return c.toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil QueryPubInfoRequest: " + th.getMessage(), th);
            return null;
        }
    }

    public static String m13452a(String str, String str2, Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("phone", str);
            jSONObject.put("iccid", str2);
            if (!(map == null || map.isEmpty())) {
                jSONObject.put("cnum", map.get("cnum"));
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil QueryOperatorRequest: " + e.getMessage(), e);
            return "";
        }
    }

    public static String m13453a(List<C2946m> list) {
        Object obj = null;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    StringBuffer c = C2991i.m13467c();
                    c.append("<QuerySceneRuleRequest>");
                    c.append("<SceneRuleList>");
                    if (!(list == null || list.isEmpty())) {
                        int size = list.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2;
                            C2946m c2946m = (C2946m) list.get(i);
                            if (C3049n.m13653e(c2946m.f9995a)) {
                                obj2 = obj;
                            } else {
                                c.append("<SceneRule>");
                                c.append("<id>");
                                c.append(c2946m.f9996b);
                                c.append("</id>");
                                c.append("<version>");
                                c.append(c2946m.f9995a);
                                c.append("</version>");
                                c.append("</SceneRule>");
                                obj2 = 1;
                            }
                            i++;
                            obj = obj2;
                        }
                    }
                    c.append("</SceneRuleList>");
                    c.append("<clientVersion>");
                    c.append(C2973a.m13384f());
                    c.append("</clientVersion>");
                    c.append("</QuerySceneRuleRequest>");
                    return obj == null ? null : c.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "ServerUtil getQuerySceneRuleRequest: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    private static String m13454a(List<String> list, int i) {
        if (list.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String b : list) {
            String b2 = C2991i.m13461b(b2, 5);
            if (!C3049n.m13653e(b2)) {
                stringBuilder.append(b2);
            }
        }
        return stringBuilder.toString();
    }

    public static String m13455a(List<String> list, String str, String str2, String str3) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    String a;
                    Map map;
                    StringBuffer c = C2991i.m13467c();
                    c.append("<QueryPubInfoRequest>");
                    c.append("<areaCode>" + str + "</areaCode>");
                    c.append("<iccid>" + str2 + "</iccid>");
                    c.append("<type>" + str3 + "</type>");
                    List<JSONObject> arrayList = new ArrayList();
                    List arrayList2 = new ArrayList();
                    List arrayList3 = new ArrayList();
                    for (String a2 : list) {
                        if (!arrayList3.contains(a2)) {
                            arrayList3.add(a2);
                            JSONObject jSONObject = new JSONObject(a2);
                            arrayList.add(jSONObject);
                            arrayList2.add(jSONObject.optString(Constants.FIELD_APPLET_CONFIG_NUM));
                        }
                    }
                    if ("1".equals(str3)) {
                        Map a3 = ah.m13244a(arrayList2);
                        String a4 = C2991i.m13454a(arrayList2, 5);
                        if (!C3049n.m13653e(a4)) {
                            c.append("<shard>");
                            c.append(a4);
                            c.append("</shard>");
                        }
                        map = a3;
                    } else {
                        map = null;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    List arrayList4 = new ArrayList();
                    boolean a5 = C2925c.m13169a();
                    for (JSONObject jSONObject2 : arrayList) {
                        String optString = jSONObject2.optString(Constants.FIELD_APPLET_CONFIG_NUM);
                        String optString2 = jSONObject2.optString("name");
                        String optString3 = jSONObject2.optString("cmd");
                        String optString4 = jSONObject2.optString("ec");
                        int optInt = jSONObject2.optInt("nameType", -1);
                        int optInt2 = jSONObject2.optInt("markTime");
                        int optInt3 = jSONObject2.optInt("markCmd");
                        int optInt4 = jSONObject2.optInt("markEC");
                        if (!C3049n.m13653e(optString)) {
                            StringBuffer stringBuffer3 = null;
                            if ("1".equals(str3)) {
                                StringBuffer stringBuffer4 = new StringBuffer();
                                Object obj = optInt2 == 1 ? 1 : null;
                                if (!(!a5 || obj == null || C3049n.m13653e(optString2))) {
                                    stringBuffer4.append("\" sign=\"").append(C2991i.m13471g(optString2));
                                    if (optInt != -1) {
                                        stringBuffer4.append("\" f=\"").append(optInt);
                                    }
                                }
                                Map map2 = map == null ? null : (Map) map.get(optString);
                                if (!(map2 == null || map2.isEmpty())) {
                                    stringBuffer4.append("\" ac=\"").append((CharSequence) map2.get("ac"));
                                    stringBuffer4.append("\" rc=\"").append((CharSequence) map2.get("rc"));
                                    stringBuffer4.append("\" dt=\"").append((CharSequence) map2.get("dt"));
                                }
                                Object obj2 = optInt3 == 1 ? 1 : null;
                                if (!(obj2 == null || C3049n.m13653e(optString3))) {
                                    a2 = C2991i.m13448a(optString, optString3);
                                    if (!C3049n.m13653e(a2)) {
                                        stringBuffer2.append(a2);
                                    }
                                }
                                Object obj3 = optInt4 == 1 ? 1 : null;
                                if (!(obj3 == null || C3049n.m13653e(optString4))) {
                                    stringBuffer4.append("\" ec=\"").append(optString4);
                                }
                                if (!(obj == null && obj2 == null && obj3 == null)) {
                                    arrayList4.add(optString);
                                }
                                stringBuffer3 = stringBuffer4;
                            }
                            stringBuffer.append("<num ver=\"").append(jSONObject2.optString("version"));
                            if (stringBuffer3 != null && stringBuffer3.length() > 0) {
                                stringBuffer.append(stringBuffer3);
                            }
                            stringBuffer.append("\" >");
                            stringBuffer.append(optString);
                            stringBuffer.append("</num>");
                        }
                    }
                    if (stringBuffer.length() > 0) {
                        c.append("<allNums>");
                        c.append(stringBuffer);
                        c.append("</allNums>");
                    }
                    if (stringBuffer2.length() > 0) {
                        c.append("<unSubscribe>");
                        c.append(stringBuffer2);
                        c.append("</unSubscribe>");
                    }
                    c.append("</QueryPubInfoRequest>");
                    if (arrayList4.size() > 0) {
                        C2925c.m13168a(arrayList4, 0, 0);
                    }
                    return c.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "ServerUtil QueryPubInfoWithListReqBody: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    public static String m13456a(List<C2951r> list, Map<String, String> map, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int i = 0;
        int c = C2947n.m13283c(C2917a.m13105a(), "ONLINE_UPDATE_SDK_PERIOD");
        int i2 = c <= 0 ? 1 : c;
        int i3 = 0;
        while (i3 < list.size()) {
            C2951r c2951r = (C2951r) list.get(i3);
            if (!z || System.currentTimeMillis() >= c2951r.f10020d + C2973a.m13350a(8, 86400000 * ((long) i2))) {
                int i4 = i + 1;
                if (i3 != 0) {
                    stringBuffer.append(",");
                    stringBuffer2.append(",");
                }
                stringBuffer.append(c2951r.f10017a);
                Object obj = c2951r.f10017a;
                if (obj.startsWith("PU")) {
                    obj = obj.replace("PU", "");
                }
                String str2 = (String) map.get(obj);
                if (!C3049n.m13653e(str2)) {
                    stringBuffer.append(str2);
                }
                stringBuffer2.append(c2951r.f10018b);
                String str3 = c2951r.f10017a;
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("update_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                    C2922b.m13133a("tb_jar_list", contentValues, "name = ? ", new String[]{str3});
                    c = i4;
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "ServerUtil getUpdateJarsRequest: " + th.getMessage(), th);
                    return null;
                }
            }
            c = i;
            i3++;
            i = c;
        }
        if (i == 0) {
            return null;
        }
        StringBuffer c2 = C2991i.m13467c();
        c2.append("<UpdateRecognitionJarRequest>");
        c2.append("<reqVersion>");
        c2.append(C2973a.m13383e());
        c2.append("</reqVersion>");
        c2.append("<jarVersion>");
        c2.append(stringBuffer2.toString());
        c2.append("</jarVersion>");
        c2.append("<jarname>");
        c2.append(stringBuffer.toString());
        c2.append("</jarname>");
        c2.append("<emVer>");
        c2.append(str);
        c2.append("</emVer>");
        c2.append("</UpdateRecognitionJarRequest>");
        return c2.toString();
    }

    private static Map<String, JSONObject> m13457a(Document document) {
        Map<String, JSONObject> hashMap = new HashMap();
        NodeList elementsByTagName = document.getElementsByTagName("info");
        Element documentElement = document.getDocumentElement();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            JSONObject jSONObject = new JSONObject();
            Element element = (Element) elementsByTagName.item(i);
            String attribute = element.getAttribute("pubId");
            NodeList childNodes = element.getChildNodes();
            try {
                jSONObject.put("id", C3042g.m13611a(documentElement, "rstCode"));
                jSONObject.put("rid", element.getAttribute("rid"));
                jSONObject.put("logoType", "0");
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "ServerUtil generateInfo getContentByTag: " + e.getMessage(), e);
            }
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node item = childNodes.item(i2);
                if (item.getNodeType() == (short) 1) {
                    String nodeName = item.getNodeName();
                    try {
                        if ("pubId".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("pubId", C3042g.m13612a(item));
                        } else if ("pubName".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("pubName", C3042g.m13612a(item));
                        } else if ("pubType".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("pubType", C3042g.m13612a(item));
                        } else if ("pubTypeCode".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("classifyCode", C3042g.m13612a(item));
                        } else if ("weiXin".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("weiXin", C3042g.m13612a(item));
                        } else if ("weiBoName".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("weiBoName", C3042g.m13612a(item));
                        } else if ("weiBoUrl".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("weiBoUrl", C3042g.m13612a(item));
                        } else if ("introduce".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("introduce", C3042g.m13612a(item));
                        } else if (UserInfo.ADDRESS.equalsIgnoreCase(nodeName)) {
                            jSONObject.put(UserInfo.ADDRESS, C3042g.m13612a(item));
                        } else if ("faxNum".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("faxNum", C3042g.m13612a(item));
                        } else if ("website".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("webSite", C3042g.m13612a(item));
                        } else if ("versionCode".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("versionCode", C3042g.m13612a(item));
                        } else if ("email".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("email", C3042g.m13612a(item));
                        } else if ("parentPubId".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("parentPubId", C3042g.m13612a(item));
                        } else if ("slogan".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("slogan", C3042g.m13612a(item));
                        } else if ("rectLogoName".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("rectLogoName", C3042g.m13612a(item));
                        } else if ("circleLogoName".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("circleLogoName", C3042g.m13612a(item));
                        } else if ("extend".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("extend", C3042g.m13612a(item));
                        } else if ("moveWebsite".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("moveWebsite", C3042g.m13612a(item));
                        } else if ("corpLevel".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("corpLevel", C3042g.m13612a(item));
                        } else if ("istl".equalsIgnoreCase(nodeName)) {
                            jSONObject.put("logoType", C3042g.m13612a(item));
                        }
                    } catch (Throwable e2) {
                        C2982a.m13415a("XIAOYUAN", "ServerUtil generateInfo: " + e2.getMessage(), e2);
                    }
                }
            }
            hashMap.put(attribute, jSONObject);
        }
        return hashMap;
    }

    private static void m13458a(Map<String, JSONObject> map, Document document) {
        NodeList elementsByTagName = document.getElementsByTagName("menuList");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            JSONObject jSONObject;
            JSONArray jSONArray = new JSONArray();
            HashMap hashMap = new HashMap();
            Element element = (Element) elementsByTagName.item(i);
            String attribute = element.getAttribute("pubId");
            NodeList elementsByTagName2 = element.getElementsByTagName("menu");
            int i2 = 0;
            while (i2 < elementsByTagName2.getLength()) {
                NodeList childNodes = ((Element) elementsByTagName2.item(i2)).getChildNodes();
                JSONObject jSONObject2 = new JSONObject();
                for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                    String nodeName;
                    Node item = childNodes.item(i3);
                    if (item.getNodeType() == (short) 1) {
                        nodeName = item.getNodeName();
                        try {
                            if ("menuCode".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("menuCode", C3042g.m13612a(item));
                            } else if ("menuName".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("menuName", C3042g.m13612a(item));
                            } else if ("menuDesc".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("menuDesc", C3042g.m13612a(item));
                            } else if ("menuType".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("menuType", C3042g.m13612a(item));
                            } else if ("sendTo".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("sendTo", C3042g.m13612a(item));
                            } else if ("sp".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("sp", C3042g.m13612a(item));
                            } else if (SiteCountryInfo.TAG_SMS.equalsIgnoreCase(nodeName)) {
                                jSONObject2.put(SiteCountryInfo.TAG_SMS, C3042g.m13612a(item));
                            } else if ("url".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("url", C3042g.m13612a(item));
                            } else if ("phoneNum".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("phoneNum", C3042g.m13612a(item));
                            } else if ("extend".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("extend", C3042g.m13612a(item));
                            } else if ("extendVal".equalsIgnoreCase(nodeName)) {
                                jSONObject2.put("extendVal", C3042g.m13612a(item));
                            }
                        } catch (Throwable th) {
                            C2982a.m13415a("XIAOYUAN", "ServerUtil generateMenuList error: " + th.getMessage(), th);
                        }
                    }
                }
                jSONObject2.put("pubId", attribute);
                String optString = jSONObject2.optString("menuType");
                Object optString2 = jSONObject2.optString("actionData");
                if (!"menu".equalsIgnoreCase(optString) && C3049n.m13653e((String) optString2)) {
                    new StringBuilder("actionType=").append(optString).append(" pubMenuInfo=").append(jSONObject2);
                    if (C3049n.m13653e(optString)) {
                        optString2 = "";
                    } else {
                        StringBuffer stringBuffer = new StringBuffer();
                        String toLowerCase = !optString.startsWith("WEB_") ? optString.toLowerCase() : optString;
                        if ("reply_sms".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"send_code\":\"" + jSONObject2.optString(SiteCountryInfo.TAG_SMS) + "\",");
                            stringBuffer.append("\"phone\":\"" + jSONObject2.optString("sendTo") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("send_sms".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"send_code\":\"" + jSONObject2.optString(SiteCountryInfo.TAG_SMS) + "\",");
                            stringBuffer.append("\"phone\":\"" + jSONObject2.optString("sendTo") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("access_url".equalsIgnoreCase(toLowerCase) || "open_url".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"url\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("down_url".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"url\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("download".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"url\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString(QuickPayUtil.STR_SOURCE_PKG_PARAM) + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"extend\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("weibo_url".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"url\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("call_phone".equalsIgnoreCase(toLowerCase) || "call".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"phoneNum\":\"" + jSONObject2.optString("phoneNum") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("map_site".equalsIgnoreCase(toLowerCase) || "open_map".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"address\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("open_map_list".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"address\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("repayment".equalsIgnoreCase(toLowerCase) || "zfb_repayment".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"appDownUrl\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if (LogUploadOperator.RESULT_CODE_RECHARGE_DES.equalsIgnoreCase(toLowerCase) || "zfb_recharge".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"sp\":\"" + jSONObject2.optString("sp") + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"appDownUrl\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("open_app".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"appDownUrl\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("open_app_url".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"appDownUrl\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else if ("WEB_TRAFFIC_ORDER".equalsIgnoreCase(toLowerCase)) {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"sp\":\"" + jSONObject2.optString("sp") + "\",");
                            stringBuffer.append("\"appName\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"appDownUrl\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        } else {
                            stringBuffer.append("{");
                            stringBuffer.append("\"type\":\"" + toLowerCase + "\",");
                            stringBuffer.append("\"extend\":\"" + jSONObject2.optString("extend") + "\",");
                            stringBuffer.append("\"url\":\"" + jSONObject2.optString("url") + "\",");
                            stringBuffer.append("\"menuName\":\"" + jSONObject2.optString("menuName") + "\",");
                            stringBuffer.append("\"publicId\":\"" + jSONObject2.optString("pubId") + "\",");
                            stringBuffer.append("\"extendVal\":\"" + jSONObject2.optString("extendVal") + "\"");
                            stringBuffer.append("}");
                        }
                        optString2 = C3049n.m13654f(stringBuffer.toString());
                    }
                }
                jSONObject2.put("actionData", optString2);
                try {
                    String str = "name";
                    nodeName = "type";
                    String str2 = "action_data";
                    String str3 = "secondmenu";
                    String str4 = "pubId";
                    String str5 = "extend";
                    String str6 = "menuCode";
                    String optString3 = jSONObject2.optString("menuCode");
                    String optString4 = jSONObject2.optString("menuName");
                    String optString5 = jSONObject2.optString("extend");
                    String optString6 = jSONObject2.optString("pubId");
                    JSONObject a;
                    if (optString3.length() == 2) {
                        if ("menu".equalsIgnoreCase(optString)) {
                            a = C3045j.m13625a(jSONObject2, str6, optString3, str4, optString6, str5, optString5, str, optString4, nodeName, optString);
                            jSONObject = (JSONObject) hashMap.get(optString3);
                            optString2 = jSONObject != null ? jSONObject.optJSONArray(str3) : null;
                            if (optString2 == null) {
                                optString2 = new JSONArray();
                            }
                            a.put(str3, optString2);
                            hashMap.put(optString3, a);
                            jSONObject = a;
                        } else {
                            optString2 = C3045j.m13625a(jSONObject2, str6, optString3, str4, optString6, str5, optString5, str, optString4, nodeName, optString, str2, optString2);
                        }
                        if (optString2 != null) {
                            jSONArray.put(optString2);
                        }
                        i2++;
                    } else {
                        if (optString3.length() == 4) {
                            a = C3045j.m13625a(jSONObject2, str6, optString3, str4, optString6, str5, optString5, str, optString4, nodeName, optString, str2, optString2);
                            str = optString3.substring(0, 2);
                            jSONObject = (JSONObject) hashMap.get(str);
                            if (jSONObject != null) {
                                jSONObject.optJSONArray(str3).put(a);
                            } else {
                                jSONObject = new JSONObject();
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(a);
                                jSONObject.put(str3, jSONArray2);
                                hashMap.put(str, jSONObject);
                            }
                        }
                        i2++;
                    }
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "ServerUtil generateMenuList: " + th2.getMessage(), th2);
                }
            }
            hashMap.clear();
            jSONObject = (JSONObject) map.get(attribute);
            if (jSONObject != null) {
                jSONObject.put("pubMenuInfolist", jSONArray);
            }
        }
    }

    private static void m13459a(Element element, String str, C2937d c2937d, int i) {
        if (element != null) {
            try {
                if (!C3049n.m13653e(str)) {
                    NodeList elementsByTagName = element.getElementsByTagName(str);
                    if (elementsByTagName != null && elementsByTagName.getLength() != 0) {
                        String a = C3042g.m13612a(elementsByTagName.item(0));
                        if (!C3049n.m13653e(a)) {
                            f10120c.execute(new C2993k(a, c2937d, 0));
                        }
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "ServerUtil parseUploadTask taskGroup:" + c2937d + " error:" + th.getMessage(), th);
            }
        }
    }

    public static String m13460b() {
        if (C3049n.m13653e(f10122e)) {
            C2942i a = C2943j.m13258a(C2917a.m13105a());
            if (!(a == null || C3049n.m13653e(a.f9980b))) {
                f10122e = C2994l.m13472a(a.f9980b);
            }
        }
        return C3049n.m13653e(f10122e) ? "" : f10122e;
    }

    private static String m13461b(String str, int i) {
        if (C3049n.m13653e(str) || i <= 0) {
            return null;
        }
        List a;
        if (C2933k.STATUS_NOT_REQUEST != C2933k.ALL) {
            a = C2932j.m13198a("num=? AND status=? ", new String[]{str, C2933k.STATUS_NOT_REQUEST.toString()}, i);
        } else {
            a = C2932j.m13198a("num=? ", new String[]{str}, i);
        }
        if (a == null || a.isEmpty()) {
            return null;
        }
        try {
            List arrayList = new ArrayList();
            CharSequence stringBuilder = new StringBuilder();
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    stringBuilder.append(";");
                }
                String str2 = ((C2931i) a.get(i2)).f9940b;
                stringBuilder.append(str2);
                arrayList.add(str2);
            }
            C2932j.m13197a(arrayList, C2933k.STATUS_HAS_REQUEST);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<shardSign sign=\"").append(stringBuilder).append("\">");
            stringBuilder2.append(str);
            stringBuilder2.append("</shardSign>");
            return stringBuilder2.toString();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil createShardSignMessage: " + th.getMessage(), th);
            return null;
        }
    }

    public static String m13462b(String str, String str2, Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("phone", str);
            jSONObject.put("msg", str2);
            if (!(map == null || map.isEmpty())) {
                jSONObject.put("cnum", map.get("cnum"));
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil QueryOperatorMsgRequest: " + e.getMessage(), e);
            return "";
        }
    }

    public static String m13463b(List<af> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    StringBuffer c = C2991i.m13467c();
                    c.append("<QuerySceneRequest>");
                    c.append("<SceneList>");
                    if (!(list == null || list.isEmpty())) {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            af afVar = (af) list.get(i);
                            c.append("<Scene count='" + afVar.f9954c + "'>");
                            c.append("<sceneId >");
                            c.append(afVar.f9952a);
                            c.append("</sceneId>");
                            c.append("<sceneVersion>");
                            String str = afVar.f9953b;
                            if (C3049n.m13653e(str)) {
                                str = "-1";
                            }
                            c.append(str);
                            c.append("</sceneVersion>");
                            c.append("</Scene>");
                        }
                    }
                    c.append("</SceneList>");
                    c.append("<clientVersion>");
                    c.append(C2973a.m13384f());
                    c.append("</clientVersion>");
                    c.append("</QuerySceneRequest>");
                    return c.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "ServerUtil getQuerySceneRequest: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    public static Map<String, JSONObject> m13464b(String str) {
        if (C3049n.m13653e(str)) {
            return null;
        }
        int i = f10121d;
        HashMap hashMap = new HashMap();
        try {
            Document a = C3049n.m13643a(str, "");
            if (a == null) {
                return null;
            }
            Element documentElement = a.getDocumentElement();
            if (C3042g.m13610a(C3042g.m13611a(documentElement, "rstCode")) == f10121d) {
                return null;
            }
            Map<String, JSONObject> a2 = C2991i.m13457a(a);
            C2991i.m13465b((Map) a2, a);
            C2991i.m13458a((Map) a2, a);
            C2991i.m13459a(documentElement, "rstSign", C2937d.UPLOAD_PUBINFO_SIGN, 0);
            C2991i.m13459a(documentElement, "subSign", C2937d.UPLOAD_PUBINFO_CMD, 0);
            if (documentElement != null) {
                NodeList elementsByTagName = documentElement.getElementsByTagName("shaSign");
                if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                    elementsByTagName = elementsByTagName.item(0).getChildNodes();
                    if (!(elementsByTagName == null || elementsByTagName.getLength() == 0)) {
                        f10120c.execute(new C2992j(elementsByTagName));
                    }
                }
            }
            return a2;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil parsePubInfoRespose: " + th.getMessage(), th);
            return null;
        }
    }

    private static void m13465b(Map<String, JSONObject> map, Document document) {
        NodeList elementsByTagName = document.getElementsByTagName("pubNumList");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Element element = (Element) elementsByTagName.item(i);
            String attribute = element.getAttribute("pubId");
            NodeList elementsByTagName2 = element.getElementsByTagName("pubNum");
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                element = (Element) elementsByTagName2.item(i2);
                NodeList childNodes = element.getChildNodes();
                JSONObject jSONObject = new JSONObject();
                if (element.hasAttribute("f")) {
                    jSONObject.put("nameType", element.getAttribute("f"));
                }
                for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                    Node item = childNodes.item(i3);
                    if (item.getNodeType() == (short) 1) {
                        String nodeName = item.getNodeName();
                        try {
                            if (Constants.FIELD_APPLET_CONFIG_NUM.equalsIgnoreCase(nodeName)) {
                                jSONObject.put(Constants.FIELD_APPLET_CONFIG_NUM, C3042g.m13612a(item));
                            } else if ("purpose".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("purpose", C3042g.m13612a(item));
                            } else if ("areaCode".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("areaCode", C3042g.m13612a(item));
                            } else if ("type".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("type", C3042g.m13612a(item));
                            } else if ("main".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("main", C3042g.m13612a(item));
                            } else if ("communication".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("communication", C3042g.m13612a(item));
                            } else if ("extend".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("extend", C3042g.m13612a(item));
                            } else if ("ntype".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("ntype", C3042g.m13612a(item));
                            } else if ("len".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("len", C3042g.m13612a(item));
                            } else if ("maxlen".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("maxlen", C3042g.m13612a(item));
                            } else if ("minlen".equalsIgnoreCase(nodeName)) {
                                jSONObject.put("minlen", C3042g.m13612a(item));
                            }
                        } catch (Throwable e) {
                            C2982a.m13415a("XIAOYUAN", "ServerUtil generateNumList: " + e.getMessage(), e);
                        }
                    }
                }
                if (!C3049n.m13653e(attribute)) {
                    jSONObject.put("pubId", attribute);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = (JSONObject) map.get(attribute);
            if (jSONObject2 != null) {
                jSONObject2.put("pubNumInfolist", jSONArray);
            }
        }
    }

    public static C2948o m13466c(String str) {
        C2948o c2948o = new C2948o();
        try {
            Document a = C3049n.m13643a(str, "");
            if (a != null) {
                Element documentElement = a.getDocumentElement();
                int a2 = C3042g.m13610a(C3042g.m13611a(documentElement, "rstCode"));
                if (a2 == 0) {
                    c2948o.f10012c = C3042g.m13611a(documentElement, "areacode");
                    c2948o.f10013d = C3042g.m13611a(documentElement, "province");
                    c2948o.f10014e = C3042g.m13611a(documentElement, "city");
                    c2948o.f10015f = C3042g.m13611a(documentElement, "operator");
                } else {
                    c2948o.f10010a = a2;
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil parseQueryLocationRespose: " + th.getMessage(), th);
        }
        return c2948o;
    }

    private static StringBuffer m13467c() {
        return new StringBuffer("<?xml version='1.0' encoding='utf-8'?>");
    }

    public static String m13468d(String str) {
        Document a = C3049n.m13643a(str, "");
        return a == null ? null : C3042g.m13611a(a.getDocumentElement(), SNBConstant.FIELD_TOKEN);
    }

    private static String m13469e(String str) {
        String str2 = null;
        try {
            String optString;
            Object obj;
            Object optString2;
            JSONObject c = C3041f.m13609b().m13104c(0);
            JSONObject c2 = C3041f.m13609b().m13104c(1);
            if (c != null) {
                String optString3 = c.optString("iccid");
                optString = c.optString("mid");
                obj = optString3;
            } else {
                optString = null;
                obj = null;
            }
            if (c2 != null) {
                optString2 = c2.optString("iccid");
                str2 = c2.optString("mid");
            } else {
                optString2 = null;
            }
            if (!C3049n.m13653e(str)) {
                if (str.equals(obj) && !C3049n.m13653e(optString)) {
                    return optString;
                }
                if (str.equals(optString2) && !C3049n.m13653e(str2)) {
                    return str2;
                }
            }
            return C3049n.m13653e(optString) ? !C3049n.m13653e(str2) ? str2 : ((TelephonyManager) C2917a.m13105a().getSystemService("phone")).getSubscriberId() : optString;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil getMid error:" + th.getMessage(), th);
            return "";
        }
    }

    private static String m13470f(String str) {
        if (C3049n.m13653e(str)) {
            return "";
        }
        try {
            return C2994l.m13472a(str.trim());
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil getSha256EncodeSafeCMD: " + e.getMessage(), e);
            return "";
        }
    }

    private static String m13471g(String str) {
        if (C3049n.m13653e(str)) {
            return "";
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : str.split(";")) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(";");
                }
                stringBuilder.append(C2994l.m13472a(str2.trim()));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil getSha256EncodeSafeName: " + e.getMessage(), e);
            return "";
        }
    }
}
