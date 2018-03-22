package com.huawei.hwid.core.p435d;

import com.huawei.android.app.ActionBarEx;
import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: EmuiUtil */
public class C5174e {
    private static int f18629a = -1;
    private static boolean f18630b = false;
    private static int f18631c;

    static {
        C5174e.m24996b();
    }

    public static boolean m24995a() {
        C5165e.m24906b("EmuiUtil", "emuiType = " + f18629a);
        return f18629a == 50;
    }

    private static void m24996b() {
        f18631c = C5174e.m24997c();
        C5165e.m24904a("EmuiUtil", "getEmuiType emuiVersionCode=" + f18631c);
        if (f18631c >= 11) {
            f18629a = 50;
        } else if (f18631c >= 10) {
            f18629a = 41;
        } else if (f18631c >= 9) {
            f18629a = 40;
        } else if (f18631c >= 8) {
            f18629a = 31;
        } else if (f18631c >= 7) {
            f18629a = 30;
        }
        if (f18629a == -1) {
            String str = "EmotionUI_3.0";
            str = "EmotionUI_3.1";
            str = "EmotionUI_4.0";
            str = "EmotionUI_4.1";
            str = "EmotionUI_5.0";
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.build.version.emui"});
                C5165e.m24904a("EmuiUtil", "isNeed2UseHwEmui :" + str);
                if (str != null) {
                    if (str.contains("EmotionUI_3.0")) {
                        f18629a = 30;
                    } else if (str.contains("EmotionUI_3.1")) {
                        f18629a = 31;
                    } else if (str.contains("EmotionUI_4.0")) {
                        f18629a = 40;
                    } else if (str.contains("EmotionUI_4.1")) {
                        f18629a = 41;
                    } else if (str.contains("EmotionUI_5.0")) {
                        f18629a = 50;
                    }
                }
            } catch (Throwable e) {
                C5165e.m24911d("EmuiUtil", "RuntimeException getEmuiType.", e);
            } catch (Throwable e2) {
                C5165e.m24911d("EmuiUtil", "getEmuiType Exception.", e2);
            }
        }
        f18630b = C5174e.m24998d();
        C5165e.m24904a("EmuiUtil", "init emui version is " + f18629a + ", hasActionBarEx=" + f18630b);
    }

    private static int m24997c() {
        int intValue;
        Object a = C5179j.m25026a("com.huawei.android.os.BuildEx$VERSION", "EMUI_SDK_INT");
        if (a != null) {
            try {
                intValue = ((Integer) a).intValue();
            } catch (ClassCastException e) {
                C5165e.m24910d("EmuiUtil", "getEMUIVersionCode is not a number");
            }
            C5165e.m24906b("EmuiUtil", "the emui version code is::" + intValue);
            return intValue;
        }
        intValue = 0;
        C5165e.m24906b("EmuiUtil", "the emui version code is::" + intValue);
        return intValue;
    }

    private static boolean m24998d() {
        try {
            if (f18629a == -1) {
                return false;
            }
            ActionBarEx.getDragAnimationStage(null);
            return true;
        } catch (Throwable e) {
            C5165e.m24911d("EmuiUtil", "ActionBarEx class not found: ", e);
            return false;
        }
    }
}
