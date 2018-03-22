package cn.com.xy.sms.sdk.p229l;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.p211c.C2939f;
import cn.com.xy.sms.sdk.p208d.p211c.C2946m;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2949p;
import cn.com.xy.sms.sdk.p208d.p211c.ab;
import cn.com.xy.sms.sdk.p208d.p211c.ac;
import cn.com.xy.sms.sdk.p208d.p211c.ae;
import cn.com.xy.sms.sdk.p208d.p211c.af;
import cn.com.xy.sms.sdk.p208d.p211c.ag;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2991i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.helpers.FileWatchdog;

public class C3048m {
    private static final Map<String, Long> f10296a = new HashMap();

    public static List<String> m13629a(String str) {
        return !C3049n.m13653e(str) ? Arrays.asList(str.replaceAll("；", ";").split(";")) : null;
    }

    static /* synthetic */ Set m13630a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Set hashSet = new HashSet();
        for (af afVar : list) {
            hashSet.add(afVar.f9952a);
        }
        return hashSet;
    }

    public static void m13631a() {
        if (C2996a.m13491a()) {
            if (System.currentTimeMillis() > C2947n.m13273a("LastSceneConfigUpdate", 0, C2917a.m13105a()) + C2973a.m13350a(10, 1209600000)) {
                C3048m.m13633a(ag.m13238a(0), 0, true);
                C3048m.m13633a(ag.m13238a(1), 1, true);
                C2947n.m13274a("LastSceneConfigUpdate", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            }
            if (System.currentTimeMillis() > C2947n.m13273a("LastSceneRuleUpdate", 0, C2917a.m13105a()) + C2973a.m13350a(11, 1209600000)) {
                C3048m.m13637b(ae.m13233a(0), 0);
                C3048m.m13637b(ae.m13233a(1), 1);
                C2947n.m13274a("LastSceneRuleUpdate", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            }
        }
    }

    public static void m13632a(List<af> list, int i) {
        try {
            if (((list.isEmpty() ? 0 : 1) & (list != null ? 1 : 0)) != 0) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    af afVar = (af) list.get(i2);
                    if (afVar != null) {
                        afVar.f9955d = 1;
                        String str = afVar.f9952a;
                        C2922b.m13134a("tb_scenerule_config", i == 1 ? "scene_id=? and sceneType = " + i : "scene_id=? and sceneType != 1", new String[]{str});
                        new StringBuilder("insertOrUpdate=").append(afVar);
                        ag.m13237a(afVar, i);
                        C3048m.m13640d(afVar.f9957f, i);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    public static void m13633a(List<af> list, int i, boolean z) {
        int i2;
        if (!(list == null || list.isEmpty())) {
            int i3 = 0;
            while (i3 < list.size()) {
                try {
                    if (C3048m.m13638b(((af) list.get(i3)).toString())) {
                        i2 = i3;
                    } else {
                        list.remove(i3);
                        i2 = i3 - 1;
                    }
                    i3 = i2 + 1;
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "SceneconfigUtil distinctRequestScenceAndRecordLastRequestSceneTime error:" + th.getMessage(), th);
                }
            }
        }
        if (list != null && !list.isEmpty()) {
            ag.m13240a((List) list, i);
            while (true) {
                i2 = list.size();
                if (i2 > 0) {
                    List arrayList = new ArrayList();
                    if (i2 > 10) {
                        i2 = 10;
                    }
                    arrayList.addAll(list.subList(0, i2));
                    try {
                        if (C2996a.m13491a() && C2996a.m13492a(2)) {
                            String b = C2991i.m13463b(arrayList);
                            if (!C3049n.m13653e(b)) {
                                C2996a.m13482a(0, i, b, new ag(arrayList, i, z), C2996a.m13498c() + "queryscene", true);
                            }
                        }
                    } catch (Throwable th2) {
                        C2982a.m13415a("XIAOYUAN", "SceneconfigUtil doRequestScenceConfig error" + th2.getMessage(), th2);
                    }
                    list.removeAll(arrayList);
                } else {
                    return;
                }
            }
        }
    }

    public static void m13634a(List<af> list, ArrayList<String> arrayList, int i) {
        int i2 = 1;
        int i3 = arrayList != null ? 1 : 0;
        try {
            if (arrayList.isEmpty()) {
                i2 = 0;
            }
            if ((i2 & i3) != 0) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String str = (String) arrayList.get(i4);
                    if (!C2939f.m13251a(str)) {
                        String str2 = "";
                        C2962e a = C2922b.m13139a("tb_xml_res_download", new String[]{"id", "scene_id", "url", "status", "pos"}, "url = ? ", new String[]{str});
                        if (a == null || a.m13323a() <= 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("scene_id", str2);
                            contentValues.put("url", str);
                            contentValues.put("status", Integer.valueOf(0));
                            contentValues.put("pos", Integer.valueOf(0));
                            contentValues.put("sceneType", Integer.valueOf(i));
                            contentValues.put("insert_time", Long.valueOf(System.currentTimeMillis()));
                            C2922b.m13135a("tb_xml_res_download", contentValues);
                        }
                        C2962e.m13322a(a, true);
                        C3039d.m13597a(str);
                    }
                }
                C3039d.m13598a(false);
            }
        } catch (Throwable th) {
        }
    }

    public static void m13635b() {
        Object obj = 1;
        try {
            Long valueOf = Long.valueOf(C2947n.m13273a("PostCount", 0, C2917a.m13105a()));
            long a = C2947n.m13273a("LastPostIccidSceneTime", 0, C2917a.m13105a());
            if (a == 0) {
                C2947n.m13274a("LastPostIccidSceneTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
                a = System.currentTimeMillis();
            }
            new StringBuilder("System.currentTimeMillis()=").append(System.currentTimeMillis());
            if (valueOf.longValue() == 0) {
                if (System.currentTimeMillis() <= C2973a.m13350a(12, 1209600000) + a) {
                    obj = null;
                }
                new StringBuilder("time+Constant.FirstpostqueryIccidScene=").append(a).append(C2973a.m13350a(12, 1209600000));
            } else {
                if (System.currentTimeMillis() <= C2973a.m13350a(13, 5184000000L) + a) {
                    obj = null;
                }
                new StringBuilder("time+Constant.postqueryIccidScene=").append(a).append(C2973a.m13350a(13, 5184000000L));
            }
            if (obj != null) {
                List a2 = C2949p.m13286a();
                StringBuffer stringBuffer = new StringBuffer();
                if (!a2.isEmpty()) {
                    for (int i = 0; i < a2.size(); i++) {
                        stringBuffer.append(new StringBuilder(String.valueOf(((af) a2.get(i)).f9952a)).append(",").append(((af) a2.get(i)).f9954c).append(";").toString());
                    }
                    C2904g c3036a = new C3036a();
                    if (C2996a.m13491a()) {
                        String a3 = C2991i.m13450a(C3049n.m13658i(C2978a.m13392a(C2917a.m13105a())), "1", C3050o.m13682c(C2917a.m13105a()), stringBuffer.toString());
                        if (!C3049n.m13653e(a3)) {
                            C2996a.m13487a(a3, "990005", c3036a, C2996a.f10129a, true);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "postqueryIccidScene: " + th.getMessage(), th);
        }
    }

    static /* synthetic */ void m13636b(List list) {
        if (list != null && !list.isEmpty()) {
            try {
                for (af afVar : list) {
                    synchronized (f10296a) {
                        Long l = (Long) f10296a.get(afVar.toString());
                        if (l != null && System.currentTimeMillis() - l.longValue() > FileWatchdog.DEFAULT_DELAY) {
                            f10296a.remove(afVar.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "SceneconfigUtil removeLastRequestSceneTime error:" + th.getMessage(), th);
            }
        }
    }

    public static void m13637b(List<C2946m> list, int i) {
        if (list != null && !list.isEmpty()) {
            while (true) {
                int size = list.size();
                if (size > 0) {
                    List arrayList = new ArrayList();
                    if (size > 10) {
                        size = 10;
                    }
                    arrayList.addAll(list.subList(0, size));
                    try {
                        if (C2996a.m13491a() && C2996a.m13492a(2)) {
                            String a = C2991i.m13453a(arrayList);
                            if (!C3049n.m13653e(a)) {
                                C2996a.m13482a(0, i, a, new ah(i), C2996a.m13498c(), true);
                            }
                        }
                    } catch (Throwable th) {
                        C2982a.m13415a("XIAOYUAN", "SceneconfigUtil doRequestQuerySceneRuleRequest error: " + th.getMessage(), th);
                    }
                    list.removeAll(arrayList);
                } else {
                    return;
                }
            }
        }
    }

    private static boolean m13638b(String str) {
        synchronized (f10296a) {
            Long l = (Long) f10296a.get(str);
            if (l == null || System.currentTimeMillis() > l.longValue() + FileWatchdog.DEFAULT_DELAY) {
                f10296a.put(str, Long.valueOf(System.currentTimeMillis()));
                return true;
            }
            return false;
        }
    }

    private static void m13640d(List<C2946m> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (C2946m c2946m : list) {
                if (c2946m != null) {
                    ae.m13232a(c2946m, i);
                    String str = c2946m.f9997c;
                    List<String> a = C3048m.m13629a(c2946m.f10005k);
                    if (!(a == null || a.isEmpty())) {
                        for (String str2 : a) {
                            if (!ac.m13223a(str2)) {
                                ab abVar = new ab();
                                abVar.f9951e = 0;
                                abVar.f9948b = str;
                                abVar.f9950d = 0;
                                abVar.f9949c = str2;
                                ac.m13220a(abVar);
                                C3044i.m13615a(str2);
                            }
                        }
                        C3044i.m13616a(false);
                    }
                }
            }
        }
    }
}
