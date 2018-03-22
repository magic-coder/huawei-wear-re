package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.xy.sms.sdk.p208d.p211c.C2946m;
import cn.com.xy.sms.sdk.p208d.p211c.af;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3042g;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class C2990h {
    private static String m13436a(Element element, String str) {
        NodeList elementsByTagName = element.getElementsByTagName(str);
        return (elementsByTagName == null || elementsByTagName.getLength() <= 0) ? "" : C3042g.m13612a(elementsByTagName.item(0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> m13437a(java.lang.String r23) {
        /*
        r4 = 0;
        r8 = 0;
        r6 = 0;
        r2 = "";
        r0 = r23;
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13643a(r0, r2);	 Catch:{ Throwable -> 0x017c }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r3 = 0;
    L_0x0010:
        return r3;
    L_0x0011:
        r13 = r2.getDocumentElement();	 Catch:{ Throwable -> 0x017c }
        r2 = "em";
        r14 = r13.getElementsByTagName(r2);	 Catch:{ Throwable -> 0x017c }
        r2 = "jars";
        r15 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x017c }
        r2 = "jarVersion";
        r16 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x017c }
        r2 = "downLoadUrl";
        r17 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x017c }
        r2 = "pver";
        r18 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x017c }
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r15);	 Catch:{ Throwable -> 0x017c }
        if (r2 != 0) goto L_0x003f;
    L_0x0039:
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r16);	 Catch:{ Throwable -> 0x017c }
        if (r2 == 0) goto L_0x0047;
    L_0x003f:
        r2 = r14.getLength();	 Catch:{ Throwable -> 0x017c }
        if (r2 != 0) goto L_0x0047;
    L_0x0045:
        r3 = 0;
        goto L_0x0010;
    L_0x0047:
        r3 = new java.util.HashMap;	 Catch:{ Throwable -> 0x017c }
        r3.<init>();	 Catch:{ Throwable -> 0x017c }
        r10 = -1;
        if (r14 == 0) goto L_0x007c;
    L_0x0050:
        r2 = r14.getLength();	 Catch:{ Throwable -> 0x0199 }
        if (r2 <= 0) goto L_0x007c;
    L_0x0056:
        r19 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0199 }
        r19.<init>();	 Catch:{ Throwable -> 0x0199 }
        r2 = 0;
        r12 = r2;
    L_0x005d:
        r2 = r14.getLength();	 Catch:{ Throwable -> 0x0199 }
        if (r12 < r2) goto L_0x00eb;
    L_0x0063:
        r2 = "EM_VERSION";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0199 }
        r5 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0199 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0199 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0199 }
        cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13274a(r2, r4);	 Catch:{ Throwable -> 0x0199 }
        r2 = "emergencyArray";
        r0 = r19;
        r3.put(r2, r0);	 Catch:{ Throwable -> 0x0199 }
    L_0x007c:
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r15);	 Catch:{ Throwable -> 0x0199 }
        if (r2 != 0) goto L_0x0010;
    L_0x0082:
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r16);	 Catch:{ Throwable -> 0x0199 }
        if (r2 != 0) goto L_0x0010;
    L_0x0088:
        r2 = ",";
        r10 = r15.split(r2);	 Catch:{ Throwable -> 0x0199 }
        r2 = ",";
        r0 = r16;
        r11 = r0.split(r2);	 Catch:{ Throwable -> 0x0199 }
        r2 = ",";
        r0 = r17;
        r12 = r0.split(r2);	 Catch:{ Throwable -> 0x0199 }
        r2 = ",";
        r0 = r18;
        r14 = r0.split(r2);	 Catch:{ Throwable -> 0x0199 }
        r2 = r10.length;	 Catch:{ Throwable -> 0x0199 }
        r4 = r11.length;	 Catch:{ Throwable -> 0x0199 }
        if (r2 != r4) goto L_0x0010;
    L_0x00aa:
        r2 = r11.length;	 Catch:{ Throwable -> 0x0199 }
        r4 = r12.length;	 Catch:{ Throwable -> 0x0199 }
        if (r2 != r4) goto L_0x0010;
    L_0x00ae:
        r2 = "delaystart";
        r2 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x0199 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x0199 }
        if (r4 != 0) goto L_0x00bf;
    L_0x00ba:
        r4 = java.lang.Long.parseLong(r2);	 Catch:{ Throwable -> 0x0199 }
        r8 = r4;
    L_0x00bf:
        r2 = "delayend";
        r2 = cn.com.xy.sms.sdk.p216h.p217a.C2990h.m13436a(r13, r2);	 Catch:{ Throwable -> 0x0199 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x0199 }
        if (r4 != 0) goto L_0x01a0;
    L_0x00cb:
        r4 = java.lang.Long.parseLong(r2);	 Catch:{ Throwable -> 0x0199 }
    L_0x00cf:
        r6 = 0;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 > 0) goto L_0x00d8;
    L_0x00d5:
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
    L_0x00d8:
        r6 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0199 }
        r6.<init>();	 Catch:{ Throwable -> 0x0199 }
        r2 = 0;
    L_0x00de:
        r7 = r10.length;	 Catch:{ Throwable -> 0x0199 }
        if (r2 < r7) goto L_0x0145;
    L_0x00e1:
        r2 = "updataJars";
        r3.put(r2, r6);	 Catch:{ Throwable -> 0x0199 }
        r2 = r3;
    L_0x00e8:
        r3 = r2;
        goto L_0x0010;
    L_0x00eb:
        r20 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0199 }
        r20.<init>();	 Catch:{ Throwable -> 0x0199 }
        r2 = r14.item(r12);	 Catch:{ Throwable -> 0x0199 }
        r4 = cn.com.xy.sms.sdk.p229l.C3042g.m13612a(r2);	 Catch:{ Throwable -> 0x0199 }
        r2 = (org.w3c.dom.Element) r2;	 Catch:{ Throwable -> 0x0199 }
        r5 = "version";
        r2 = r2.getAttribute(r5);	 Catch:{ Throwable -> 0x0199 }
        r5 = "emContent";
        r0 = r20;
        r0.put(r5, r4);	 Catch:{ Throwable -> 0x0199 }
        r4 = "emVersion";
        r0 = r20;
        r0.put(r4, r2);	 Catch:{ Throwable -> 0x0199 }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x0126 }
        if (r4 != 0) goto L_0x0143;
    L_0x0115:
        r4 = java.lang.Long.parseLong(r2);	 Catch:{ Throwable -> 0x0126 }
        r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0143;
    L_0x011d:
        r19.put(r20);	 Catch:{ Throwable -> 0x0199 }
        r2 = r12 + 1;
        r10 = r4;
        r12 = r2;
        goto L_0x005d;
    L_0x0126:
        r2 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0199 }
        r21 = "parseJarsUpdateRespose ";
        r0 = r21;
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0199 }
        r21 = r2.getLocalizedMessage();	 Catch:{ Throwable -> 0x0199 }
        r0 = r21;
        r5 = r5.append(r0);	 Catch:{ Throwable -> 0x0199 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0199 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r2);	 Catch:{ Throwable -> 0x0199 }
    L_0x0143:
        r4 = r10;
        goto L_0x011d;
    L_0x0145:
        r7 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0199 }
        r7.<init>();	 Catch:{ Throwable -> 0x0199 }
        r13 = "name";
        r15 = r10[r2];	 Catch:{ Throwable -> 0x0199 }
        r7.put(r13, r15);	 Catch:{ Throwable -> 0x0199 }
        r13 = "version";
        r15 = r11[r2];	 Catch:{ Throwable -> 0x0199 }
        r7.put(r13, r15);	 Catch:{ Throwable -> 0x0199 }
        r13 = "url";
        r15 = r12[r2];	 Catch:{ Throwable -> 0x0199 }
        r7.put(r13, r15);	 Catch:{ Throwable -> 0x0199 }
        r13 = r14.length;	 Catch:{ Throwable -> 0x0199 }
        if (r13 <= r2) goto L_0x016b;
    L_0x0164:
        r13 = "pver";
        r15 = r14[r2];	 Catch:{ Throwable -> 0x0199 }
        r7.put(r13, r15);	 Catch:{ Throwable -> 0x0199 }
    L_0x016b:
        r13 = "delayStart";
        r7.put(r13, r8);	 Catch:{ Throwable -> 0x0199 }
        r13 = "delayEnd";
        r7.put(r13, r4);	 Catch:{ Throwable -> 0x0199 }
        r6.put(r7);	 Catch:{ Throwable -> 0x0199 }
        r2 = r2 + 1;
        goto L_0x00de;
    L_0x017c:
        r2 = move-exception;
        r3 = r2;
        r2 = r4;
    L_0x017f:
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;
        r6 = "parseJarsUpdateRespose: ";
        r5.<init>(r6);
        r6 = r3.getMessage();
        r5 = r5.append(r6);
        r5 = r5.toString();
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r3);
        goto L_0x00e8;
    L_0x0199:
        r2 = move-exception;
        r22 = r2;
        r2 = r3;
        r3 = r22;
        goto L_0x017f;
    L_0x01a0:
        r4 = r6;
        goto L_0x00cf;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.h.a.h.a(java.lang.String):java.util.Map<java.lang.String, java.lang.Object>");
    }

    public static List<C2946m> m13438b(String str) {
        List<C2946m> arrayList = new ArrayList();
        try {
            Document a = C3049n.m13643a(str, "");
            if (a == null) {
                return null;
            }
            NodeList elementsByTagName;
            if (C2982a.f10101a) {
                elementsByTagName = a.getElementsByTagName("SceneRule");
            } else {
                elementsByTagName = a.getElementsByTagName("SceneRule");
            }
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                C2946m c2946m = new C2946m();
                NodeList childNodes = ((Element) elementsByTagName.item(i)).getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    Node item = childNodes.item(i2);
                    if (item.getNodeType() == (short) 1) {
                        String nodeName = item.getNodeName();
                        if ("sceneId".equalsIgnoreCase(nodeName)) {
                            c2946m.f9997c = C3042g.m13612a(item);
                        } else if ("sceneRuleVersion".equalsIgnoreCase(nodeName)) {
                            c2946m.f9995a = C3042g.m13612a(item);
                        } else if ("province".equalsIgnoreCase(nodeName)) {
                            c2946m.f9998d = C3042g.m13612a(item);
                        } else if ("id".equalsIgnoreCase(nodeName)) {
                            c2946m.f9996b = C3042g.m13612a(item);
                        } else if ("operator".equalsIgnoreCase(nodeName)) {
                            c2946m.f9999e = C3042g.m13612a(item);
                        } else if ("expire_date".equalsIgnoreCase(nodeName)) {
                            c2946m.f10000f = C3042g.m13612a(item);
                        } else if ("fun_call".equalsIgnoreCase(nodeName)) {
                            c2946m.f10001g = Integer.parseInt(C3042g.m13612a(item));
                        } else if ("fun_acc_url".equalsIgnoreCase(nodeName)) {
                            c2946m.f10002h = Integer.parseInt(C3042g.m13612a(item));
                        } else if ("fun_reply_sms".equalsIgnoreCase(nodeName)) {
                            c2946m.f10003i = Integer.parseInt(C3042g.m13612a(item));
                        } else if ("fun_config".equalsIgnoreCase(nodeName)) {
                            c2946m.f10004j = C3042g.m13612a(item);
                        } else if ("res_urls".equalsIgnoreCase(nodeName)) {
                            c2946m.f10005k = C3042g.m13612a(item);
                        } else if ("s_version".equalsIgnoreCase(nodeName)) {
                            c2946m.f10006l = C3042g.m13612a(item);
                        } else if ("scene_page_conf".equalsIgnoreCase(nodeName)) {
                            c2946m.f10007m = C3042g.m13612a(item);
                        }
                    }
                }
                arrayList.add(c2946m);
            }
            return arrayList;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "parseQuerySceneRuleResponse: " + th.getMessage(), th);
        }
    }

    public static boolean m13439c(String str) {
        try {
            Document a = C3049n.m13643a(str, "");
            if (a == null) {
                return false;
            }
            NodeList elementsByTagName = a.getDocumentElement().getElementsByTagName("rstCode");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return false;
            }
            String str2 = C3042g.m13612a(elementsByTagName.item(0)).toString();
            return !C3049n.m13653e(str2) && str2.equals("0");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m13440d(String str) {
        try {
            Document a = C3049n.m13643a(str, "");
            if (a == null) {
                return false;
            }
            NodeList elementsByTagName = a.getDocumentElement().getElementsByTagName("rstCode");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return false;
            }
            String str2 = C3042g.m13612a(elementsByTagName.item(0)).toString();
            return !C3049n.m13653e(str2) && str2.equals("0");
        } catch (Throwable th) {
            return false;
        }
    }

    public static HashMap<String, Object> m13441e(String str) {
        HashMap<String, Object> hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Document a = C3049n.m13643a(str, "");
        if (a == null) {
            return null;
        }
        NodeList elementsByTagName;
        if (C2982a.f10101a) {
            elementsByTagName = a.getElementsByTagName("Scene");
        } else {
            elementsByTagName = a.getElementsByTagName("Scene");
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            int i2;
            int i3;
            af afVar = new af();
            Element element = (Element) elementsByTagName.item(i);
            NodeList childNodes = element.getChildNodes();
            for (i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node item = childNodes.item(i2);
                if (item.getNodeType() == (short) 1) {
                    String nodeName = item.getNodeName();
                    if ("sceneId".equalsIgnoreCase(nodeName)) {
                        afVar.f9952a = C3042g.m13612a(item);
                    } else if ("sceneVersion".equalsIgnoreCase(nodeName)) {
                        afVar.f9953b = C3042g.m13612a(item);
                    }
                }
            }
            childNodes = element.getElementsByTagName("SceneRule");
            if (childNodes != null) {
                int length = childNodes.getLength();
                i2 = 0;
                while (i2 < length) {
                    try {
                        C2946m c2946m = new C2946m();
                        NodeList childNodes2 = ((Element) childNodes.item(i2)).getChildNodes();
                        for (i3 = 0; i3 < childNodes2.getLength(); i3++) {
                            Node item2 = childNodes2.item(i3);
                            if (item2.getNodeType() == (short) 1) {
                                String nodeName2 = item2.getNodeName();
                                if (item2.getNodeType() == (short) 1) {
                                    if ("sceneId".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f9997c = C3042g.m13612a(item2);
                                    } else if ("sceneRuleVersion".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f9995a = C3042g.m13612a(item2);
                                    } else if ("province".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f9998d = C3042g.m13612a(item2);
                                    } else if ("id".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f9996b = C3042g.m13612a(item2);
                                    } else if ("operator".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f9999e = C3042g.m13612a(item2);
                                    } else if ("expire_date".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10000f = C3042g.m13612a(item2);
                                    } else if ("fun_call".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10001g = Integer.parseInt(C3042g.m13612a(item2));
                                    } else if ("fun_acc_url".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10002h = Integer.parseInt(C3042g.m13612a(item2));
                                    } else if ("fun_reply_sms".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10003i = Integer.parseInt(C3042g.m13612a(item2));
                                    } else if ("fun_config".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10004j = C3042g.m13612a(item2);
                                    } else if ("res_urls".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10005k = C3042g.m13612a(item2);
                                    } else if ("s_version".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10006l = C3042g.m13612a(item2);
                                    } else if ("scene_page_conf".equalsIgnoreCase(nodeName2)) {
                                        c2946m.f10007m = C3042g.m13612a(item2);
                                    }
                                }
                            }
                        }
                        afVar.m13236a(c2946m);
                        i2++;
                    } catch (Throwable th) {
                        C2982a.m13415a("XIAOYUAN", "parseQuerySceneRecordResponse: " + th.getMessage(), th);
                    }
                }
                continue;
            }
            arrayList.add(afVar);
        }
        NodeList elementsByTagName2 = a.getElementsByTagName("SceneUrl");
        ArrayList arrayList2 = new ArrayList();
        if (elementsByTagName2 != null) {
            for (i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                String a2 = C3042g.m13612a(elementsByTagName2.item(i3));
                if (!C3049n.m13653e(a2)) {
                    arrayList2.add(a2);
                }
            }
        }
        hashMap.put("sceneUrllist", arrayList2);
        hashMap.put("sceneconfigList", arrayList);
        return hashMap;
    }

    public static JSONArray m13442f(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            Document a = C3049n.m13643a(str, "");
            if (a == null) {
                return null;
            }
            String str2;
            Object str3;
            Element documentElement = a.getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName("code");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                str2 = C3042g.m13612a(elementsByTagName.item(0)).toString();
                if (C3049n.m13653e(str2) || !"0".equals(str2)) {
                    return null;
                }
            }
            str2 = "";
            NodeList elementsByTagName2 = documentElement.getElementsByTagName("res_type");
            if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                String str4 = str2;
            } else {
                str3 = C3042g.m13612a(elementsByTagName2.item(0)).toString();
            }
            NodeList elementsByTagName3 = a.getElementsByTagName("res");
            for (int i = 0; i < elementsByTagName3.getLength(); i++) {
                JSONObject jSONObject = new JSONObject();
                Node node = (Element) elementsByTagName3.item(i);
                String attribute = node.getAttribute("version");
                String attribute2 = node.getAttribute("del_history");
                jSONObject.put("res_version", attribute);
                jSONObject.put("del_history", attribute2);
                jSONObject.put("res_url", C3042g.m13612a(node));
                jSONObject.put("res_type", str3);
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th) {
            return null;
        }
    }
}
