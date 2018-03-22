package cn.com.xy.sms.sdk.p220j.p224d;

import cn.com.xy.sms.p204a.C2909j;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p208d.p211c.C2955v;
import cn.com.xy.sms.sdk.p208d.p211c.ah;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import cn.com.xy.sms.sdk.p229l.C3038c;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C3026b {
    static final ExecutorService f10216a = Executors.newFixedThreadPool(1);
    private static boolean f10217b = false;

    protected static Object m13561a(List<String> list, boolean z, String str, String str2, C2904g c2904g, int i, Object... objArr) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3 = null;
        if (objArr == null) {
            if (i == 0 || i == 2) {
                ah.m13246a(false);
            }
            if (c2904g == null) {
                C2928f.m13182a(C3026b.m13562a((List) list));
                C2928f.m13181a(str);
                return null;
            }
            c2904g.execute(Integer.valueOf(-1));
            C2928f.m13182a(C3026b.m13562a((List) list));
            C2928f.m13181a(str);
            return null;
        }
        if (objArr[0].toString().equals("0") && objArr.length == 2) {
            String optString;
            String obj4 = objArr[1].toString();
            try {
                new StringBuilder("PubInfoManager updateUpdateInfoTime list=").append(list);
                if (!(list == null || list.isEmpty())) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String optString2 : list) {
                        optString2 = new JSONObject(optString2).optString("pubId");
                        if (!C3049n.m13653e(optString2)) {
                            stringBuffer.append("," + optString2);
                        }
                    }
                    if (stringBuffer.length() > 0) {
                        optString2 = stringBuffer.substring(1);
                        stringBuffer.setLength(0);
                        C2922b.m13146a("UPDATE tb_public_info SET updateInfoTime = " + System.currentTimeMillis() + " WHERE pubId IN (" + optString2 + ")");
                    }
                }
            } catch (Throwable th2) {
                try {
                    C2982a.m13415a("XIAOYUAN", "PubInfoNetService handleNetWorkResponse error:" + th2.getMessage(), th2);
                    return obj3;
                } finally {
                    obj3 = C3026b.m13562a((List) list);
                    C2928f.m13182a((List) obj3);
                    C2928f.m13181a(str);
                }
            }
            Map b = C2991i.m13464b(obj4);
            if (b == null || b.size() == 0) {
                if (c2904g != null) {
                    c2904g.execute(new Object[0]);
                }
                if (i == 0 || i == 2) {
                    ah.m13246a(false);
                }
                C2928f.m13182a(C3026b.m13562a((List) list));
                C2928f.m13181a(str);
                return null;
            }
            JSONObject jSONObject = (JSONObject) b.get(b.keySet().iterator().next());
            String optString3 = jSONObject.optString("id");
            if ("0".equals(optString3)) {
                if (c2904g != null) {
                    switch (i) {
                        case 0:
                            JSONObject jSONObject2 = jSONObject;
                            break;
                        case 1:
                            try {
                                String[] strArr = new String[2];
                                JSONArray optJSONArray = jSONObject.optJSONArray("pubMenuInfolist");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    if (!z) {
                                        obj4 = optJSONArray.toString();
                                        C3050o.m13670a(c2904g, obj4, jSONObject.optString("pubId"));
                                        obj = null;
                                        break;
                                    }
                                    strArr[0] = jSONObject.optString("pubName");
                                    strArr[1] = optJSONArray.toString();
                                    C3050o.m13670a(c2904g, strArr[0], strArr[1]);
                                    obj = null;
                                    break;
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                                obj = null;
                                C2982a.m13415a("XIAOYUAN", "PubInfoNetService handleNetWorkResponse: " + th2.getMessage(), th2);
                                if (c2904g != null) {
                                    c2904g.execute("-1");
                                }
                                if (i == 0 || i == 2) {
                                    ah.m13246a(true);
                                }
                                for (String optString22 : b.keySet()) {
                                    C2928f.m13183a((JSONObject) b.get(optString22));
                                }
                                obj2 = obj;
                                ah.m13246a(false);
                                C2928f.m13182a(C3026b.m13562a((List) list));
                                C2928f.m13181a(str);
                                return obj2;
                            }
                        case 2:
                            c2904g.execute(b);
                            break;
                    }
                }
                obj = null;
                if (i == 0 || i == 2) {
                    try {
                        ah.m13246a(true);
                    } catch (Throwable th4) {
                        th2 = th4;
                        C2982a.m13415a("XIAOYUAN", "PubInfoNetService handleNetWorkResponse: " + th2.getMessage(), th2);
                        if (c2904g != null) {
                            c2904g.execute("-1");
                        }
                        ah.m13246a(true);
                        while (r5.hasNext()) {
                            C2928f.m13183a((JSONObject) b.get(optString22));
                        }
                        obj2 = obj;
                        ah.m13246a(false);
                        C2928f.m13182a(C3026b.m13562a((List) list));
                        C2928f.m13181a(str);
                        return obj2;
                    }
                }
                while (r5.hasNext()) {
                    C2928f.m13183a((JSONObject) b.get(optString22));
                }
                obj2 = obj;
            } else {
                if ("1".equals(optString3)) {
                    C2996a.m13499c(str2);
                }
                obj2 = null;
            }
            if (!"0".equals(optString3) && (i == 0 || i == 2)) {
                ah.m13246a(false);
            }
        } else {
            obj2 = null;
        }
        C2928f.m13182a(C3026b.m13562a((List) list));
        C2928f.m13181a(str);
        return obj2;
    }

    private static List<String> m13562a(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String jSONObject : list) {
            try {
                String jSONObject2 = new JSONObject(jSONObject2).getString(Constants.FIELD_APPLET_CONFIG_NUM);
                if (!C3049n.m13653e(jSONObject2)) {
                    arrayList.add(jSONObject2);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoNetService getNums error:" + th.getMessage(), th);
            }
        }
        return arrayList;
    }

    public static void m13563a() {
        C3026b.m13564a(C2937d.UPLOAD_SHARD);
    }

    private static void m13564a(C2937d c2937d) {
        synchronized (C3030f.f10238a) {
            if (f10217b) {
                return;
            }
            f10217b = true;
            f10216a.execute(new C3029e(c2937d));
        }
    }

    public static void m13565a(List<String> list, String str, String str2, String str3, C2904g c2904g, boolean z) {
        try {
            if (C2996a.m13492a(1)) {
                String a = C2909j.m13080a();
                C3038c.m13592a(a, "cn.com.xy.sms.sdk.service.pubInfo.PubInfoNetService", "queryPubInfoByList", list, str, str2, str3, c2904g, Boolean.valueOf(z));
                C3028d c3028d = new C3028d(a, list, str, str2, str3, c2904g, z);
                C2996a.m13495b(str2);
                a = C2991i.m13455a((List) list, str, str2, str3);
                C2982a.m13414a("queryPubInfo", "PubInfoNetService queryPubInfoByList dataString=" + a);
                if (!C3049n.m13653e(a)) {
                    C2996a.m13488a(a, "990005", c3028d, null, z, false, "pubinfo", true);
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "PubInfoNetService queryPubInfoByList: " + th.getMessage(), th);
        }
    }

    public static void m13567a(boolean z, String str, String str2, String str3, String str4, String str5, C2904g c2904g, int i, boolean z2, boolean z3, boolean z4) {
        if (!z4) {
            try {
                if (!C2955v.m13300a(str, str3)) {
                    C2982a.m13414a("pubInfo", "!!!!!!!!!! queryPubInfoRequest num: " + str + " areaCode: " + str3);
                    C3050o.m13669a(c2904g, "");
                    return;
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "PubInfoNetService queryPubInfoRequest: " + th.getMessage(), th);
                return;
            }
        }
        C2982a.m13414a("pubInfo", "########## queryPubInfoRequest num: " + str + " areaCode: " + str3);
        C2996a.m13495b(str4);
        String a = C2909j.m13080a();
        C3038c.m13592a(a, "cn.com.xy.sms.sdk.service.pubInfo.PubInfoNetService", "queryPubInfoRequest", Boolean.valueOf(false), str, str2, str3, str4, str5, c2904g, Integer.valueOf(i), Boolean.valueOf(false), Boolean.valueOf(z3), Boolean.valueOf(z4));
        C3027c c3027c = new C3027c(a, false, str, str2, str3, str4, str5, c2904g, i, false, z3, z4);
        if (C2996a.m13491a()) {
            a = C2991i.m13451a(str, str2, str3, str4, str5);
            if (C3049n.m13653e(a)) {
                C3050o.m13669a(c2904g, "");
                return;
            }
            C2996a.m13488a(a, "990005", c3027c, str2, false, false, "pubinfo", true);
            return;
        }
        C3050o.m13669a(c2904g, "");
    }

    public static void m13568b() {
        C3026b.m13564a(C2937d.UPLOAD_PUBINFO_SIGN);
    }

    public static void m13569c() {
        C3026b.m13564a(C2937d.UPLOAD_PUBINFO_CMD);
    }
}
