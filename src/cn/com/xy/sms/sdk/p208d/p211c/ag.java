package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.C2962e;
import cn.com.xy.sms.sdk.p208d.C2964g;
import cn.com.xy.sms.sdk.p208d.p210b.C2921a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ag {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m13237a(cn.com.xy.sms.sdk.p208d.p211c.af r11, int r12) {
        /*
        r10 = 1;
        r0 = -1;
        r3 = 0;
        r2 = r11.f9952a;	 Catch:{ Throwable -> 0x009e }
        r2 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r2);	 Catch:{ Throwable -> 0x009e }
        if (r2 != 0) goto L_0x0037;
    L_0x000c:
        r2 = "tb_scene_config";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x009e }
        r5 = 0;
        r6 = "scene_id";
        r4[r5] = r6;	 Catch:{ Throwable -> 0x009e }
        r5 = "scene_id = ?  and sceneType = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x009e }
        r7 = 0;
        r8 = r11.f9952a;	 Catch:{ Throwable -> 0x009e }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x009e }
        r7 = 1;
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e }
        r9 = java.lang.String.valueOf(r12);	 Catch:{ Throwable -> 0x009e }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x009e }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x009e }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x009e }
        r3 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x009e }
    L_0x0037:
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x009e }
        r2.<init>();	 Catch:{ Throwable -> 0x009e }
        r4 = r11.f9953b;	 Catch:{ Throwable -> 0x009e }
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r4);	 Catch:{ Throwable -> 0x009e }
        if (r4 != 0) goto L_0x004c;
    L_0x0044:
        r4 = "sceneVersion";
        r5 = r11.f9953b;	 Catch:{ Throwable -> 0x009e }
        r2.put(r4, r5);	 Catch:{ Throwable -> 0x009e }
    L_0x004c:
        r4 = "scene_id";
        r5 = r11.f9952a;	 Catch:{ Throwable -> 0x009e }
        r2.put(r4, r5);	 Catch:{ Throwable -> 0x009e }
        r4 = "sceneType";
        r5 = java.lang.Integer.valueOf(r12);	 Catch:{ Throwable -> 0x009e }
        r2.put(r4, r5);	 Catch:{ Throwable -> 0x009e }
        r4 = "isCheck";
        r5 = r11.f9955d;	 Catch:{ Throwable -> 0x009e }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x009e }
        r2.put(r4, r5);	 Catch:{ Throwable -> 0x009e }
        if (r3 == 0) goto L_0x0096;
    L_0x006b:
        r4 = r3.m13323a();	 Catch:{ Throwable -> 0x009e }
        if (r4 <= 0) goto L_0x0096;
    L_0x0071:
        r4 = "tb_scene_config";
        r5 = "scene_id = ? and sceneType = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x009e }
        r7 = 0;
        r8 = r11.f9952a;	 Catch:{ Throwable -> 0x009e }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x009e }
        r7 = 1;
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e }
        r9 = java.lang.String.valueOf(r12);	 Catch:{ Throwable -> 0x009e }
        r8.<init>(r9);	 Catch:{ Throwable -> 0x009e }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x009e }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x009e }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r4, r2, r5, r6);	 Catch:{ Throwable -> 0x009e }
    L_0x0092:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
    L_0x0095:
        return r0;
    L_0x0096:
        r4 = "tb_scene_config";
        r0 = cn.com.xy.sms.sdk.p208d.C2922b.m13135a(r4, r2);	 Catch:{ Throwable -> 0x009e }
        goto L_0x0092;
    L_0x009e:
        r2 = move-exception;
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bb }
        r6 = "insertOrUpdate: ";
        r5.<init>(r6);	 Catch:{ all -> 0x00bb }
        r6 = r2.getMessage();	 Catch:{ all -> 0x00bb }
        r5 = r5.append(r6);	 Catch:{ all -> 0x00bb }
        r5 = r5.toString();	 Catch:{ all -> 0x00bb }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r2);	 Catch:{ all -> 0x00bb }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
        goto L_0x0095;
    L_0x00bb:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r3, r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ag.a(cn.com.xy.sms.sdk.d.c.af, int):long");
    }

    public static List<af> m13238a(int i) {
        String str;
        List<af> arrayList = new ArrayList();
        if (i == 1) {
            try {
                str = "sceneType = " + i + " and isUse" + " = 1";
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "queryAllSceneconfig: " + th.getMessage(), th);
            } finally {
                C2962e.m13322a(null, true);
            }
        } else {
            str = "sceneType != 1 and isUse = 1";
        }
        C2962e a = C2922b.m13139a("tb_scene_config", new String[]{"scene_id", "sceneVersion", "useCount"}, str, null);
        if (a != null && a.m13323a() > 0) {
            int a2 = a.m13325a("scene_id");
            int a3 = a.m13325a("sceneVersion");
            int a4 = a.m13325a("useCount");
            while (a.m13327b()) {
                af afVar = new af();
                afVar.f9952a = a.m13328c(a2);
                afVar.f9953b = a.m13328c(a3);
                afVar.f9954c = a.m13324a(a4);
                arrayList.add(afVar);
            }
        }
        C2962e.m13322a(a, true);
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m13239a(java.util.HashMap<java.lang.String, java.lang.String> r10) {
        /*
        r9 = 1;
        r0 = "titleNo";
        r0 = r10.get(r0);
        r0 = (java.lang.String) r0;
        r2 = new cn.com.xy.sms.sdk.d.c.af;
        r2.<init>();
        r2.f9952a = r0;
        r2.f9954c = r9;
        r1 = 0;
        r0 = r2.f9952a;	 Catch:{ Throwable -> 0x00ac }
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x00ac }
        if (r0 != 0) goto L_0x0042;
    L_0x001c:
        r0 = "tb_scene_config";
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x00ac }
        r4 = 0;
        r5 = "scene_id";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00ac }
        r4 = 1;
        r5 = "isUse";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00ac }
        r4 = 2;
        r5 = "useCount";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x00ac }
        r4 = "scene_id = ? ";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00ac }
        r6 = 0;
        r7 = r2.f9952a;	 Catch:{ Throwable -> 0x00ac }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00ac }
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r0, r3, r4, r5);	 Catch:{ Throwable -> 0x00ac }
    L_0x0042:
        if (r1 == 0) goto L_0x0050;
    L_0x0044:
        r0 = r1.m13323a();	 Catch:{ Throwable -> 0x00ac }
        if (r0 <= 0) goto L_0x0050;
    L_0x004a:
        r0 = r1.m13327b();	 Catch:{ Throwable -> 0x00ac }
        if (r0 != 0) goto L_0x0054;
    L_0x0050:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r9);
    L_0x0053:
        return;
    L_0x0054:
        r0 = "useCount";
        r0 = r1.m13325a(r0);	 Catch:{ Throwable -> 0x00ac }
        r0 = r1.m13324a(r0);	 Catch:{ Throwable -> 0x00ac }
        r0 = r0 + 1;
        r3 = 1;
        r2.f9956e = r3;	 Catch:{ Throwable -> 0x00ac }
        r2.f9954c = r0;	 Catch:{ Throwable -> 0x00ac }
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ac }
        r0.<init>();	 Catch:{ Throwable -> 0x00ac }
        r3 = "useCount";
        r4 = r2.f9954c;	 Catch:{ Throwable -> 0x00ac }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x00ac }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ac }
        r3 = "isUse";
        r4 = r2.f9956e;	 Catch:{ Throwable -> 0x00ac }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x00ac }
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x00ac }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ac }
        r4 = "values:";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00ac }
        r3.append(r0);	 Catch:{ Throwable -> 0x00ac }
        r3 = "tb_scene_config";
        r4 = "scene_id = ? ";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00ac }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ac }
        r8 = r2.f9952a;	 Catch:{ Throwable -> 0x00ac }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x00ac }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ac }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ac }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00ac }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r3, r0, r4, r5);	 Catch:{ Throwable -> 0x00ac }
        goto L_0x004a;
    L_0x00ac:
        r0 = move-exception;
        r2 = "XIAOYUAN";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c9 }
        r4 = "insertOrUpdate: ";
        r3.<init>(r4);	 Catch:{ all -> 0x00c9 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x00c9 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c9 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c9 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r3, r0);	 Catch:{ all -> 0x00c9 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r9);
        goto L_0x0053;
    L_0x00c9:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ag.a(java.util.HashMap):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m13240a(java.util.List<cn.com.xy.sms.sdk.p208d.p211c.af> r12, int r13) {
        /*
        r11 = 1;
        if (r12 == 0) goto L_0x0009;
    L_0x0003:
        r0 = r12.isEmpty();
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r2 = r12.iterator();
    L_0x000e:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0009;
    L_0x0014:
        r0 = r2.next();
        r0 = (cn.com.xy.sms.sdk.p208d.p211c.af) r0;
        if (r0 == 0) goto L_0x000e;
    L_0x001c:
        r3 = r0.f9952a;
        r0 = r0.f9953b;
        r1 = 0;
        r4 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r3);	 Catch:{ Throwable -> 0x00a4 }
        if (r4 != 0) goto L_0x0050;
    L_0x0027:
        r4 = "tb_scene_config";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x00a4 }
        r6 = 0;
        r7 = "scene_id";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x00a4 }
        r6 = "scene_id = ? and sceneType = ?";
        r7 = 2;
        r7 = new java.lang.String[r7];	 Catch:{ Throwable -> 0x00a4 }
        r8 = 0;
        r7[r8] = r3;	 Catch:{ Throwable -> 0x00a4 }
        r8 = 1;
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a4 }
        r10 = java.lang.String.valueOf(r13);	 Catch:{ Throwable -> 0x00a4 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x00a4 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x00a4 }
        r7[r8] = r9;	 Catch:{ Throwable -> 0x00a4 }
        r1 = cn.com.xy.sms.sdk.p208d.C2922b.m13139a(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00a4 }
    L_0x0050:
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00a4 }
        r4.<init>();	 Catch:{ Throwable -> 0x00a4 }
        r5 = "scene_id";
        r4.put(r5, r3);	 Catch:{ Throwable -> 0x00a4 }
        r5 = "sceneType";
        r6 = java.lang.Integer.valueOf(r13);	 Catch:{ Throwable -> 0x00a4 }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00a4 }
        r5 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r0);	 Catch:{ Throwable -> 0x00a4 }
        if (r5 != 0) goto L_0x0071;
    L_0x006b:
        r5 = "sceneVersion";
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00a4 }
    L_0x0071:
        if (r1 == 0) goto L_0x009d;
    L_0x0073:
        r0 = r1.m13323a();	 Catch:{ Throwable -> 0x00a4 }
        if (r0 <= 0) goto L_0x009d;
    L_0x0079:
        r0 = "tb_scene_config";
        r5 = "scene_id = ? and sceneType = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x00a4 }
        r7 = 0;
        r6[r7] = r3;	 Catch:{ Throwable -> 0x00a4 }
        r3 = 1;
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a4 }
        r8 = java.lang.String.valueOf(r13);	 Catch:{ Throwable -> 0x00a4 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00a4 }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00a4 }
        r6[r3] = r7;	 Catch:{ Throwable -> 0x00a4 }
        cn.com.xy.sms.sdk.p208d.C2922b.m13133a(r0, r4, r5, r6);	 Catch:{ Throwable -> 0x00a4 }
    L_0x0098:
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r11);
        goto L_0x000e;
    L_0x009d:
        r0 = "tb_scene_config";
        cn.com.xy.sms.sdk.p208d.C2922b.m13135a(r0, r4);	 Catch:{ Throwable -> 0x00a4 }
        goto L_0x0098;
    L_0x00a4:
        r0 = move-exception;
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c2 }
        r5 = "insertOrupdate: ";
        r4.<init>(r5);	 Catch:{ all -> 0x00c2 }
        r5 = r0.getMessage();	 Catch:{ all -> 0x00c2 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x00c2 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c2 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r0);	 Catch:{ all -> 0x00c2 }
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r11);
        goto L_0x000e;
    L_0x00c2:
        r0 = move-exception;
        cn.com.xy.sms.sdk.p208d.C2962e.m13322a(r1, r11);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.d.c.ag.a(java.util.List, int):void");
    }

    public static void m13241a(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            try {
                int size = set.size();
                C2964g.m13329a("tb_scene_config", C2921a.m13130a(null, "isUse", "1", "useCount", "0"), "scene_id IN(" + ah.m13243a(size) + ")", (String[]) set.toArray(new String[size]));
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "SceneconfigManager setIsUseAndResetUseCount error:" + th.getMessage(), th);
            }
        }
    }
}
