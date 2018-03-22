package cn.com.xy.sms.sdk.p218i;

import android.os.Process;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2950q;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.p217a.C2988f;
import cn.com.xy.sms.sdk.p229l.C3049n;
import org.json.JSONObject;

public final class C3008a extends Thread {
    private static boolean f10167a = false;

    public static synchronized void m13531a() {
        synchronized (C3008a.class) {
            if (!f10167a) {
                f10167a = true;
                new C3008a().start();
            }
        }
    }

    private void m13532a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                C2988f.m13430a(jSONObject.optString("emContent"));
                if (jSONObject != null) {
                    try {
                        String optString = jSONObject.optString("emVersion");
                        if (C3049n.m13653e(optString)) {
                            optString = "";
                        }
                        C2922b.m13134a("tb_emergency_queue", "emVersion = ?", new String[]{optString});
                    } catch (Throwable th) {
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (Throwable th2) {
                    C2982a.m13415a("XIAOYUAN", "handleEmergency: " + th2.getMessage(), th2);
                }
                m13532a(C2950q.m13287a());
                return;
            } catch (Throwable th22) {
                C2982a.m13415a("XIAOYUAN", "handleEmergency: " + th22.getMessage(), th22);
            }
        } else {
            f10167a = false;
            return;
        }
        m13532a(C2950q.m13287a());
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        try {
            setName("xiaoyuan_EmergencyQueue");
            Process.setThreadPriority(C3013f.f10174b);
            try {
                Thread.sleep(1000);
                m13532a(C2950q.m13287a());
            } catch (Throwable th) {
            }
            z = false;
        } catch (Throwable th2) {
            z = th2;
            C2982a.m13415a("XIAOYUAN", "run: " + z.getMessage(), z);
            return;
        } finally {
            z2 = 
/*
Method generation error in method: cn.com.xy.sms.sdk.i.a.run():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r4_2 'z2' boolean) = (r4_0 'z2' boolean), (r0_7 'z' boolean) in method: cn.com.xy.sms.sdk.i.a.run():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 21 more

*/
        }
