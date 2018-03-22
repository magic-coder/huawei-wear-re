package cn.com.xy.sms.sdk.p208d.p211c;

import android.content.ContentValues;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2924b;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2925c;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2928f;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p220j.p224d.C3026b;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3050o;
import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C2934a {
    private static String m13201a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() >= 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("<shardItem sign=\"");
                    stringBuilder.append(jSONObject.getString("contentSign"));
                    stringBuilder.append("\" attr1=\"");
                    stringBuilder.append(jSONObject.getString(XMLNode.KEY_INDEX));
                    stringBuilder.append("\" attr2=\"");
                    stringBuilder.append(jSONObject.getString("mod"));
                    stringBuilder.append("\" eof=\"");
                    stringBuilder.append(jSONObject.getString("eof"));
                    stringBuilder.append("\">");
                    stringBuilder.append(jSONObject.getString("characterSequence"));
                    stringBuilder.append("</shardItem>");
                    return stringBuilder.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager parseShardItem: " + th.getMessage(), th);
                return "";
            }
        }
        return "";
    }

    private static List<ai> m13202a(C2937d c2937d, int i) {
        C2962e a;
        Throwable th;
        try {
            a = C2922b.m13141a(false, "tb_update_task", new String[]{"id", "content", "t_group"}, "t_group = ?", new String[]{c2937d.toString()}, null, null, null, String.valueOf(i));
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        List<ai> arrayList = new ArrayList();
                        while (a.m13327b()) {
                            ai aiVar = new ai();
                            aiVar.f9959b = a.m13326b(a.m13325a("id"));
                            aiVar.f9958a = a.m13328c(a.m13325a("content"));
                            aiVar.f9960c = a.m13328c(a.m13325a("t_group"));
                            arrayList.add(aiVar);
                        }
                        C2962e.m13322a(a, true);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C2962e.m13322a(a, true);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }

    public static void m13203a(ai aiVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", aiVar.f9958a);
            contentValues.put("t_group", aiVar.f9960c);
            contentValues.put("t_version", Long.valueOf(0));
            C2922b.m13135a("tb_update_task", contentValues);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateTaskManager addTask(TaskInfo info): " + th.getMessage(), th);
        }
    }

    public static synchronized void m13204a(C2937d c2937d) {
        synchronized (C2934a.class) {
            try {
                if (C2937d.UPDATE_PUBINFO == c2937d) {
                    ai b = C2934a.m13207b(c2937d);
                    if (b != null) {
                        C2942i a = C2943j.m13258a(C2917a.m13105a());
                        List b2 = C2928f.m13185b(b.f9958a);
                        C2904g c2935b = new C2935b(b);
                        String str = "";
                        String str2 = "";
                        if (a != null) {
                            str = a.f9987i;
                            str2 = a.f9980b;
                        }
                        C3026b.m13565a(b2, str, str2, "3", c2935b, true);
                    }
                } else if (C2937d.UPLOAD_PUBINFO_SIGN == c2937d) {
                    C2934a.m13206a(C2934a.m13202a(c2937d, 20), c2937d);
                } else if (C2937d.UPLOAD_PUBINFO_CMD == c2937d) {
                    C2934a.m13206a(C2934a.m13202a(c2937d, 20), c2937d);
                } else if (C2937d.UPLOAD_SHARD == c2937d) {
                    C2934a.m13206a(C2934a.m13202a(c2937d, 10), c2937d);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager doTask: " + th.getMessage(), th);
            }
        }
    }

    public static void m13205a(String str, C2937d c2937d, int i) {
        try {
            C2922b.m13135a("tb_update_task", C2921a.m13130a(null, "content", str, "t_group", c2937d.toString(), "t_version", String.valueOf(i)));
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "UpdateTaskManager addTask(String content, TaskGroup taskGroup, int version): " + th.getMessage(), th);
        }
    }

    private static void m13206a(List<ai> list, C2937d c2937d) {
        String str = null;
        if (list != null && list.size() != 0) {
            try {
                if (C2947n.m13281a(C2917a.m13105a(), "smartsms_enhance", true) && C3050o.m13664a(C2917a.m13105a(), 2) != -1) {
                    C2904g c2936c = new C2936c(list, c2937d);
                    if (C2937d.UPLOAD_PUBINFO_SIGN == c2937d) {
                        str = C2934a.m13209c(list);
                    } else if (C2937d.UPLOAD_PUBINFO_CMD == c2937d) {
                        str = C2934a.m13210d(list);
                    } else if (C2937d.UPLOAD_SHARD == c2937d) {
                        str = C2934a.m13212f(list);
                    }
                    if (!C3049n.m13653e(str)) {
                        C2996a.m13488a(str, "990005", c2936c, null, false, false, "pubinfo", true);
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager executeUploadPubInfo: " + th.getMessage(), th);
            }
        }
    }

    private static ai m13207b(C2937d c2937d) {
        Throwable th;
        C2962e a;
        try {
            String str = "t_group = ?";
            if (C2937d.UPDATE_PUBINFO == c2937d) {
                str = new StringBuilder(String.valueOf(str)).append(" OR t_group IS NULL OR t_group = '' ").toString();
            }
            a = C2922b.m13141a(false, "tb_update_task", new String[]{"id", "content", "t_group"}, str, new String[]{c2937d.toString()}, null, null, null, "1");
            if (a != null) {
                try {
                    if (a.m13323a() > 0) {
                        if (a.m13327b()) {
                            ai aiVar = new ai();
                            aiVar.f9959b = a.m13326b(a.m13325a("id"));
                            aiVar.f9958a = a.m13328c(a.m13325a("content"));
                            aiVar.f9960c = a.m13328c(a.m13325a("t_group"));
                            C2962e.m13322a(a, true);
                            return aiVar;
                        }
                        C2962e.m13322a(a, true);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        C2982a.m13415a("XIAOYUAN", "UpdateTaskManager queryNextTask(TaskGroup taskGroup): " + th.getMessage(), th);
                        C2962e.m13322a(a, true);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        C2962e.m13322a(a, true);
                        throw th;
                    }
                }
            }
            C2962e.m13322a(a, true);
            return null;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            C2962e.m13322a(a, true);
            throw th;
        }
    }

    private static String m13208b(List<ai> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (ai aiVar : list) {
                        stringBuilder.append(aiVar.f9959b);
                        stringBuilder.append(",");
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        return stringBuilder.toString();
                    }
                    return null;
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager getTaskIds: " + th.getMessage(), th);
            }
        }
        return null;
    }

    private static String m13209c(List<ai> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    List<C2924b> e = C2934a.m13211e(list);
                    if (e == null || e.size() <= 0) {
                        return null;
                    }
                    CharSequence stringBuilder = new StringBuilder();
                    for (C2924b c2924b : e) {
                        if (!C3049n.m13653e(c2924b.f9916b)) {
                            stringBuilder.append("<num sign=\"" + c2924b.f9916b + "\">");
                            stringBuilder.append(c2924b.f9915a);
                            stringBuilder.append("</num>");
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        return null;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>");
                    stringBuilder2.append("<QueryPubInfoRequest>");
                    stringBuilder2.append("<allNums type=\"1\" >");
                    stringBuilder2.append(stringBuilder);
                    stringBuilder2.append("</allNums>");
                    stringBuilder2.append("</QueryPubInfoRequest>");
                    return stringBuilder2.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager uploadPubInfoSignReqeustContent: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    private static String m13210d(List<ai> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    List<C2924b> e = C2934a.m13211e(list);
                    if (e == null || e.size() <= 0) {
                        return null;
                    }
                    CharSequence stringBuilder = new StringBuilder();
                    for (C2924b c2924b : e) {
                        if (!C3049n.m13653e(c2924b.f9918d)) {
                            String[] split = c2924b.f9918d.split(";&XY_PIX&;");
                            for (String append : split) {
                                stringBuilder.append(append);
                            }
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        return null;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>");
                    stringBuilder2.append("<QueryPubInfoRequest>");
                    stringBuilder2.append("<unSubscribe type=\"1\">");
                    stringBuilder2.append(stringBuilder);
                    stringBuilder2.append("</unSubscribe>");
                    stringBuilder2.append("</QueryPubInfoRequest>");
                    return stringBuilder2.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager uploadCMDReqeustContent: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    private static List<C2924b> m13211e(List<ai> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        List arrayList = new ArrayList();
        for (ai aiVar : list) {
            if (!(aiVar == null || aiVar.f9958a == null)) {
                arrayList.addAll(Arrays.asList(aiVar.f9958a.split(";")));
            }
        }
        if (!C2925c.m13169a()) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuffer stringBuffer = new StringBuffer(Constants.FIELD_APPLET_CONFIG_NUM);
        stringBuffer.append(" IN(");
        stringBuffer.append(ah.m13243a(size));
        stringBuffer.append(")");
        if (!C3049n.m13653e(null)) {
            stringBuffer.append(null);
        }
        return C2925c.m13161a(stringBuffer.toString(), (String[]) arrayList.toArray(new String[size]), Integer.MAX_VALUE);
    }

    private static String m13212f(List<ai> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    CharSequence stringBuilder = new StringBuilder();
                    for (ai aiVar : list) {
                        JSONArray jSONArray = new JSONArray(aiVar.f9958a);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(C2934a.m13201a(jSONArray.getJSONObject(i)));
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        return null;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>");
                    stringBuilder2.append("<QueryPubInfoRequest>");
                    stringBuilder2.append("<shard>");
                    stringBuilder2.append(stringBuilder);
                    stringBuilder2.append("</shard>");
                    stringBuilder2.append("</QueryPubInfoRequest>");
                    return stringBuilder2.toString();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "UpdateTaskManager uploadShardReqeustContent: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }
}
