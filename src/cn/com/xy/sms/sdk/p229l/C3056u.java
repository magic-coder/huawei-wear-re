package cn.com.xy.sms.sdk.p229l;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import cn.com.xy.sms.p204a.C2906g;
import cn.com.xy.sms.sdk.p205a.C2904g;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p208d.C2920a;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2960c;
import cn.com.xy.sms.sdk.p208d.C2961d;
import cn.com.xy.sms.sdk.p208d.C2970m;
import cn.com.xy.sms.sdk.p208d.p209a.C2918a;
import cn.com.xy.sms.sdk.p208d.p211c.C2941h;
import cn.com.xy.sms.sdk.p208d.p211c.C2947n;
import cn.com.xy.sms.sdk.p208d.p211c.C2951r;
import cn.com.xy.sms.sdk.p208d.p211c.C2952s;
import cn.com.xy.sms.sdk.p208d.p211c.ae;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p214f.C2978a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import cn.com.xy.sms.sdk.p216h.p217a.C2995m;
import cn.com.xy.sms.sdk.p220j.p224d.C3026b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class C3056u {
    public static boolean f10306a = false;
    private static boolean f10307b = false;
    private static final Object f10308c = new Object();
    private static boolean f10309d = false;

    private static List<String> m13719a(String str) {
        List<String> list = null;
        if (str != null) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String[] list2 = file.list();
                if (!(list2 == null || list2.length == 0)) {
                    list = new ArrayList();
                    for (String str2 : list2) {
                        int lastIndexOf = str2.lastIndexOf(HwAccountConstants.SPLIIT_UNDERLINE);
                        if (lastIndexOf != -1) {
                            list.add(str2.substring(0, lastIndexOf));
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void m13720a() {
        try {
            synchronized (f10308c) {
                if (f10307b) {
                    f10307b = false;
                    f10306a = true;
                    return;
                }
                f10307b = true;
                C3056u.m13725c();
                C3059x.m13732a();
                C3048m.m13631a();
                C2973a.m13386h();
                C3056u.m13724b();
                C3026b.m13568b();
                f10307b = false;
                f10306a = true;
            }
        } catch (Throwable th) {
            try {
                C2982a.m13415a("XIAOYUAN", "checkInit: " + th.getMessage(), th);
            } finally {
                f10307b = false;
                f10306a = true;
            }
        }
    }

    private static void m13721a(File file) {
        SQLiteDatabase a;
        Throwable th;
        SQLiteStatement sQLiteStatement = null;
        if (file != null) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    a = C2918a.m13119a();
                    sQLiteStatement = a.compileStatement("INSERT INTO tb_regex(scene_id,match_id,regex_text,version_code,regex_type)VALUES(?,?,?,?,?)");
                    a.beginTransaction();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        try {
                            String trim = readLine.substring(0, readLine.indexOf(",")).trim();
                            readLine = readLine.substring(readLine.indexOf(",") + 1, readLine.length());
                            String trim2 = readLine.substring(0, readLine.indexOf(",")).trim();
                            readLine = readLine.substring(readLine.indexOf(",") + 1, readLine.length());
                            String trim3 = readLine.substring(0, readLine.indexOf(",")).trim();
                            readLine = readLine.substring(readLine.indexOf(",") + 1, readLine.length());
                            String trim4 = readLine.substring(0, readLine.indexOf(",")).trim();
                            readLine = readLine.substring(readLine.indexOf(",") + 1, readLine.length()).trim();
                            sQLiteStatement.bindString(1, trim);
                            sQLiteStatement.bindString(2, trim2);
                            sQLiteStatement.bindString(3, readLine);
                            sQLiteStatement.bindString(4, trim4);
                            sQLiteStatement.bindString(5, trim3);
                            sQLiteStatement.executeInsert();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (a != null) {
                        try {
                            if (a.inTransaction()) {
                                a.setTransactionSuccessful();
                                a.endTransaction();
                            }
                        } catch (Throwable th3) {
                            C2982a.m13415a("XIAOYUAN", "insertRegex: " + th3.getMessage(), th3);
                        }
                        if (sQLiteStatement != null) {
                            sQLiteStatement.close();
                        }
                        C2918a.m13122a(a);
                    }
                    try {
                        bufferedReader.close();
                    } catch (Throwable th32) {
                        C2982a.m13415a("XIAOYUAN", "insertRegex: " + th32.getMessage(), th32);
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    a = null;
                    if (a != null) {
                        if (a.inTransaction()) {
                            a.setTransactionSuccessful();
                            a.endTransaction();
                        }
                        if (sQLiteStatement != null) {
                            sQLiteStatement.close();
                        }
                        C2918a.m13122a(a);
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th32;
                }
            } catch (Throwable th5) {
                th32 = th5;
                a = null;
                bufferedReader = null;
                if (a != null) {
                    if (a.inTransaction()) {
                        a.setTransactionSuccessful();
                        a.endTransaction();
                    }
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    C2918a.m13122a(a);
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th32;
            }
        }
    }

    public static void m13722a(String str, int i) {
        if (!C3055t.m13704a(C2917a.m13113f() + str)) {
            return;
        }
        if (i == 0) {
            C2961d.m13321a(C2917a.m13105a());
        } else if (i == 1) {
            C2920a.m13127a(C2917a.m13105a());
        }
    }

    private static boolean m13723a(String str, String str2) {
        if (C3049n.m13653e(str) || str.length() > 15) {
            return true;
        }
        try {
            try {
                return Long.valueOf(str2).longValue() > Long.valueOf(str).longValue();
            } catch (NumberFormatException e) {
                return false;
            }
        } catch (NumberFormatException e2) {
            return true;
        }
    }

    public static void m13724b() {
        try {
            String d = C2947n.m13284d(C2917a.m13105a(), "SCENE_CENSUS_ONLINE");
            boolean a = C2973a.m13366a(0);
            boolean a2 = C2973a.m13366a(1);
            if ("1".equals(d) || a) {
                String a3 = C3040e.m13603a("yyyyMMdd");
                d = C2947n.m13284d(C2917a.m13105a(), "LastSceneCountActionUpdate");
                if (d == null ? true : C3040e.m13606a(a3, C3040e.m13605a(d, "yyyyMMdd", 1), "yyyyMMdd")) {
                    d = ae.m13587a(a3);
                    if (!C3049n.m13653e(d)) {
                        C2904g afVar = new af(a3);
                        if (C2996a.m13491a()) {
                            C2996a.m13487a(d, "990005", afVar, C2996a.f10129a, true);
                        }
                    }
                }
                String a4 = C3040e.m13603a("yyyyMMdd");
                d = C2947n.m13284d(C2917a.m13105a(), "LastMenuActionCountActionUpdate");
                boolean a5 = d == null ? true : C3040e.m13606a(a4, C3040e.m13605a(d, "yyyyMMdd", 1), "yyyyMMdd");
                C2996a.m13496b(null);
                if (a5) {
                    try {
                        String jSONArray = C2941h.m13256a(a4).toString();
                        if (!C3049n.m13653e(jSONArray)) {
                            C2996a.m13490a("menuclick", jSONArray, new ab(a4), true, false, true, null);
                        }
                    } catch (Throwable th) {
                        C2982a.m13415a("XIAOYUAN", "MenuActionCountActionUatil: " + th.getMessage(), th);
                    }
                }
            } else if ("2".equals(d) || a2) {
                C3048m.m13635b();
            }
        } catch (Throwable th2) {
            C2982a.m13415a("XIAOYUAN", "checkInit: " + th2.getMessage(), th2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m13725c() {
        /*
        r8 = 0;
        r7 = 0;
        r1 = f10308c;
        monitor-enter(r1);
        r0 = f10309d;	 Catch:{ all -> 0x0061 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0061 }
    L_0x000a:
        return;
    L_0x000b:
        r0 = 1;
        f10309d = r0;	 Catch:{ all -> 0x0061 }
        monitor-exit(r1);	 Catch:{ all -> 0x0061 }
        r0 = "init_xiaoyuan_sdk";
        r1 = "0";
        cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13274a(r0, r1);	 Catch:{ Throwable -> 0x0064 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0064 }
        r2 = java.util.concurrent.Executors.newSingleThreadExecutor();	 Catch:{ Throwable -> 0x0064 }
        r3 = new cn.com.xy.sms.sdk.l.v;	 Catch:{ Throwable -> 0x0064 }
        r3.<init>();	 Catch:{ Throwable -> 0x0064 }
        r2.execute(r3);	 Catch:{ Throwable -> 0x0064 }
        r2.shutdown();	 Catch:{ Throwable -> 0x0064 }
        cn.com.xy.sms.sdk.p229l.C3056u.m13726d();	 Catch:{ Throwable -> 0x0064 }
    L_0x002c:
        r4 = 10;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Throwable -> 0x0064 }
        r3 = r2.awaitTermination(r4, r3);	 Catch:{ Throwable -> 0x0064 }
        if (r3 == 0) goto L_0x002c;
    L_0x0036:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0064 }
        r4 = "xiaoyuan_init";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0064 }
        r6 = "new initInerData 总耗时 time: ";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0064 }
        r0 = r2 - r0;
        r0 = r5.append(r0);	 Catch:{ Throwable -> 0x0064 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0064 }
        r1 = 0;
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r0, r1);	 Catch:{ Throwable -> 0x0064 }
        r0 = "init_xiaoyuan_sdk";
        r1 = "1";
        cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13274a(r0, r1);
        r0 = cn.com.xy.sms.sdk.p229l.C3041f.m13609b();
        r0.m13096a(r8, r7);
        goto L_0x000a;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0064:
        r0 = move-exception;
        r1 = "XIAOYUAN";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r3 = "initInerData: error: ";
        r2.<init>(r3);	 Catch:{ all -> 0x008d }
        r3 = r0.getMessage();	 Catch:{ all -> 0x008d }
        r2 = r2.append(r3);	 Catch:{ all -> 0x008d }
        r2 = r2.toString();	 Catch:{ all -> 0x008d }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r1, r2, r0);	 Catch:{ all -> 0x008d }
        r0 = "init_xiaoyuan_sdk";
        r1 = "1";
        cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13274a(r0, r1);
        r0 = cn.com.xy.sms.sdk.p229l.C3041f.m13609b();
        r0.m13096a(r8, r7);
        goto L_0x000a;
    L_0x008d:
        r0 = move-exception;
        r1 = "init_xiaoyuan_sdk";
        r2 = "1";
        cn.com.xy.sms.sdk.p208d.p211c.C2947n.m13274a(r1, r2);
        r1 = cn.com.xy.sms.sdk.p229l.C3041f.m13609b();
        r1.m13096a(r8, r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.l.u.c():void");
    }

    public static void m13726d() {
        Object obj = 1;
        String str = null;
        try {
            String a;
            String h = C3055t.m13718h("duoqu_parse_version.txt");
            if (!C3049n.m13653e(h)) {
                a = C2906g.m13077a(C2917a.m13105a(), "SMART_ALGORITHM_PVER");
                if (C3049n.m13653e(a) || h.compareTo(a) > 0) {
                    C2906g.m13078a(C2917a.m13105a(), "SMART_ALGORITHM_PVER", h);
                }
            }
            h = C3055t.m13716f("duoqu_parse_version.txt");
            if (!"-1".equals(h) && h.contains("=")) {
                obj = null;
            }
            if (obj != null) {
                try {
                    C2951r a2 = C2952s.m13290a("parseUtilMain");
                    if (!(a2 == null || C3049n.m13653e(a2.f10018b))) {
                        new StringBuilder("name:").append(a2.f10017a).append(",version:").append(a2.f10018b);
                        str = a2.f10018b;
                    }
                    String f = C3055t.m13716f("duoqu_parse_version.txt");
                    new StringBuilder("localVersion=").append(str).append(" assetVersion=").append(f);
                    if (C3049n.m13653e(str) || C3056u.m13723a(str, f)) {
                        C2947n.m13280a(false);
                        C2947n.m13274a("sms_sdk_init", "0");
                        C3050o.m13674a(C3055t.m13693a().open("duoqu_parse.zip"), "parse.zip", C2917a.m13109b(), true, f, true);
                        C2960c.m13315a(C2917a.m13105a());
                        C3059x.m13736b();
                        C3056u.m13731i();
                        C2947n.m13274a("sms_sdk_init", "1");
                    }
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "oldInitAlgorithm: " + th.getMessage(), th);
                }
                try {
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm.so", C2917a.m13109b() + "libxy-algorithm.so");
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm-64.so", C2917a.m13109b() + "libxy-algorithm-64.so");
                    C3055t.m13712d(C2917a.m13110c());
                    return;
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th2.getMessage(), th2);
                    return;
                }
            }
            HashMap h2 = C3056u.m13730h();
            if (h2 == null) {
                C2982a.m13415a("initduoqu_parse", "assets下缺少duoqu_parse_version.txt文件，无法进行算法更新", null);
                try {
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm.so", C2917a.m13109b() + "libxy-algorithm.so");
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm-64.so", C2917a.m13109b() + "libxy-algorithm-64.so");
                    C3055t.m13712d(C2917a.m13110c());
                } catch (Throwable th22) {
                    C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th22.getMessage(), th22);
                }
            } else if (h2.isEmpty()) {
                try {
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm.so", C2917a.m13109b() + "libxy-algorithm.so");
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm-64.so", C2917a.m13109b() + "libxy-algorithm-64.so");
                    C3055t.m13712d(C2917a.m13110c());
                } catch (Throwable th222) {
                    C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th222.getMessage(), th222);
                }
            } else {
                C2947n.m13274a("sms_sdk_init", "0");
                a = C2917a.m13110c();
                String b = C2917a.m13109b();
                C3050o.m13674a(C3055t.m13693a().open("duoqu_parse.zip"), "parse.zip", a, false, null, false);
                Set<Entry> entrySet = h2.entrySet();
                List a3 = C3056u.m13719a(b);
                List arrayList = new ArrayList();
                StringBuilder stringBuilder = new StringBuilder();
                if (a3 != null) {
                    try {
                        C2960c.m13314a(0, -2);
                    } catch (Throwable th2222) {
                        try {
                            C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th2222.getMessage(), th2222);
                            if (a3 != null) {
                                C2960c.m13320c();
                                C2960c.m13314a(-2, 0);
                            }
                        } catch (Throwable th22222) {
                            C2982a.m13415a("XIAOYUAN", th22222.getMessage(), th22222);
                        }
                    }
                }
                int i = 0;
                for (Entry entry : entrySet) {
                    h = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (!(C3049n.m13653e(h) || C3049n.m13653e(str2))) {
                        String trim = h.replace(".jar", "").trim();
                        if (a3 != null && a3.contains(trim)) {
                            C3055t.m13700a(b, new StringBuilder(String.valueOf(trim)).append(HwAccountConstants.SPLIIT_UNDERLINE).toString(), ".jar", null);
                            C3055t.m13707b(new StringBuilder(String.valueOf(trim)).append(HwAccountConstants.SPLIIT_UNDERLINE).toString(), ".dex", null);
                            C2973a.m13362a(trim);
                        }
                        InputStream b2 = C3055t.m13706b(new StringBuilder(String.valueOf(a)).append(h).toString());
                        if (b2 != null) {
                            C3055t.m13709c(new StringBuilder(String.valueOf(b)).append(h).toString());
                            C3055t.m13694a(b, h, b2);
                            C3055t.m13699a(b, new StringBuilder(String.valueOf(trim)).append(".jar").toString(), new StringBuilder(String.valueOf(trim)).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).append(".jar").toString());
                            if ("parseUtilMain".equals(trim)) {
                                C2973a.m13359a();
                            } else if ("OnlineUpdateCycleConfig".equals(trim)) {
                                C2973a.m13374b();
                            } else if ("ParseVerifyCodeValidTime".equals(trim)) {
                                C2973a.m13379c();
                            }
                        }
                        int i2 = i + 1;
                        if (i2 > 300) {
                            stringBuilder.setLength(stringBuilder.length() - 10);
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                            i2 = 0;
                        }
                        stringBuilder.append("SELECT '");
                        stringBuilder.append(trim);
                        stringBuilder.append("'name,'");
                        stringBuilder.append(str2.trim());
                        stringBuilder.append("'version,");
                        stringBuilder.append(C2952s.m13293b(trim));
                        stringBuilder.append(" is_use UNION ALL ");
                        String stringBuilder2 = new StringBuilder(String.valueOf(a)).append(trim).append(".sql").toString();
                        File file = new File(stringBuilder2);
                        if (file.exists() && file.isFile()) {
                            stringBuilder2 = C3049n.m13659j(stringBuilder2);
                            if (C3049n.m13653e(stringBuilder2)) {
                                file = null;
                            } else {
                                trim = C2995m.m13476a(a, new StringBuilder(String.valueOf(trim)).append(".txt").toString());
                                if (C3049n.m13653e(trim)) {
                                    file = null;
                                } else if (!stringBuilder2.equals(trim)) {
                                    file = null;
                                }
                            }
                        } else {
                            file = null;
                        }
                        if (file != null) {
                            try {
                                C3056u.m13721a(file);
                                i = i2;
                            } catch (Throwable th222222) {
                                C2982a.m13415a("XIAOYUAN", th222222.getMessage(), th222222);
                            }
                        }
                        i = i2;
                    }
                }
                if (a3 != null) {
                    try {
                        C2960c.m13320c();
                        C2960c.m13314a(-2, 0);
                    } catch (Throwable th2222222) {
                        C2982a.m13415a("XIAOYUAN", th2222222.getMessage(), th2222222);
                    }
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.setLength(stringBuilder.length() - 10);
                    arrayList.add(stringBuilder.toString());
                }
                if (arrayList.size() > 0) {
                    C2952s.m13295b(arrayList);
                }
                C2947n.m13274a("BEFORE_HAND_PARSE_SMS_TIME", String.valueOf(System.currentTimeMillis()));
                if (h2.containsKey("parseUtilMain.jar")) {
                    C2947n.m13277a();
                    List arrayList2 = new ArrayList();
                    arrayList2.add("ParseUtilCasual");
                    arrayList2.add("ParseUtilEC");
                    arrayList2.add("ParseUtilFinanceL");
                    arrayList2.add("ParseUtilFinanceM");
                    arrayList2.add("ParseUtilFinanceS");
                    arrayList2.add("ParseUtilLife");
                    arrayList2.add("ParseUtilMove");
                    arrayList2.add("ParseUtilTelecom");
                    arrayList2.add("ParseUtilTravel");
                    arrayList2.add("ParseUtilUnicom");
                    C2952s.m13289a(arrayList2);
                }
                C3059x.m13736b();
                C3056u.m13731i();
                C2947n.m13274a("sms_sdk_init", "1");
                try {
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm.so", C2917a.m13109b() + "libxy-algorithm.so");
                    C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm-64.so", C2917a.m13109b() + "libxy-algorithm-64.so");
                    C3055t.m13712d(C2917a.m13110c());
                } catch (Throwable th22222222) {
                    C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th22222222.getMessage(), th22222222);
                }
            }
        } catch (Throwable th222222222) {
            try {
                C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th222222222.getMessage(), th222222222);
                C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm.so", C2917a.m13109b() + "libxy-algorithm.so");
                C3055t.m13698a(C2917a.m13110c() + "libxy-algorithm-64.so", C2917a.m13109b() + "libxy-algorithm-64.so");
                C3055t.m13712d(C2917a.m13110c());
            } catch (Throwable th2222222222) {
                C2982a.m13415a("XIAOYUAN", "initAlgorithm: " + th2222222222.getMessage(), th2222222222);
            }
        }
    }

    public static void m13727e() {
        String d = C2947n.m13284d(C2917a.m13105a(), "PublicLogoVersion");
        String f = C3055t.m13716f("duoqu_publiclogo_version.txt");
        if (C3049n.m13653e(d) || C3056u.m13723a(d, f)) {
            try {
                C3050o.m13673a(C3055t.m13693a().open("duoqu_publiclogo.zip"), "duoqu_publiclogo.zip", C2917a.m13107a("duoqu_publiclogo"));
                C2947n.m13274a("PublicLogoVersion", f);
            } catch (Throwable e) {
                C2982a.m13415a("XIAOYUAN", "initPublicLogo: " + e.getMessage(), e);
            } catch (Throwable e2) {
                C2982a.m13415a("XIAOYUAN", "initPublicLogo: " + e2.getMessage(), e2);
            }
        }
    }

    public static void m13728f() {
        String d = C2947n.m13284d(C2917a.m13105a(), "DrawableVersion");
        String f = C3055t.m13716f("duoqu_drawable_version.txt");
        if (C3049n.m13653e(d) || C3056u.m13723a(d, f)) {
            try {
                C3050o.m13673a(C3055t.m13693a().open("duoqu_drawable.zip"), "drawable.zip", C2917a.m13113f());
                File file = new File(C2917a.m13113f() + File.separator + "init.sql");
                if (file.exists() && ae.m13235b(10) != -1) {
                    if (C2922b.m13148a(file, true)) {
                        C2947n.m13274a("hasImportDrawableData", "true");
                        C2947n.m13274a("DrawableVersion", f);
                    }
                    ae.m13234a();
                    ae.m13235b(0);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "initDrawble: " + th.getMessage(), th);
            }
        }
    }

    public static void m13729g() {
        String d = C2947n.m13284d(C2917a.m13105a(), "MenuVersion");
        String f = C3055t.m13716f("duoqu_nqsql_version.txt");
        if (C3049n.m13653e(d) || C3056u.m13723a(d, f)) {
            try {
                C3050o.m13673a(C3055t.m13693a().open("duoqu_nqsql.zip"), "duoqu_nqsql.zip", C2917a.m13114g());
                C2970m.m13339a();
                C2947n.m13274a("MenuVersion", f);
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "initMenuData: " + th.getMessage(), th);
            }
        }
    }

    private static HashMap<String, String> m13730h() {
        List<String> g = C3055t.m13717g("duoqu_parse_version.txt");
        if (g == null || g.isEmpty()) {
            return null;
        }
        HashMap b = C2952s.m13294b();
        HashMap<String, String> hashMap = new HashMap();
        for (String split : g) {
            String split2;
            String[] split3 = split2.split("=");
            if (split3.length == 2) {
                String str = split3[0];
                String str2 = split3[1];
                if (!(C3049n.m13653e(str) || C3049n.m13653e(str2))) {
                    split2 = str.replace(".jar", "");
                    boolean a = (b == null || b.isEmpty() || !b.containsKey(split2)) ? true : C3056u.m13723a((String) b.get(split2), str2);
                    if (a) {
                        hashMap.put(str, str2);
                    }
                }
            }
        }
        return hashMap;
    }

    private static void m13731i() {
        C2978a.f10090a.execute(new C3058w());
    }
}
