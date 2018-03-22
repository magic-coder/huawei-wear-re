package com.huawei.hwid.core.p435d;

import android.text.TextUtils;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* compiled from: EmuiUtil */
class C5179j {
    public static Class<?> m25025a(String str) {
        Class<?> cls = null;
        if (!TextUtils.isEmpty(str) && ("com.huawei.android.os.BuildEx$VERSION".equals(str) || "com.huawei.android.immersion.ImmersionStyle".equals(str))) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e) {
                C5165e.m24908c("ReflectionUtils", "className not found:" + C5203g.m25316a(str));
            }
        }
        return cls;
    }

    public static Object m25026a(String str, String str2) {
        Object obj = null;
        Class a = C5179j.m25025a(str);
        if (a != null && !TextUtils.isEmpty(str2) && "com.huawei.android.os.BuildEx$VERSION".equals(str) && "EMUI_SDK_INT".equals(str2)) {
            try {
                AccessibleObject.setAccessible(new Field[]{a.getDeclaredField(str2)}, true);
                obj = r2.get(a);
            } catch (IllegalAccessException e) {
                C5165e.m24908c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException");
            } catch (IllegalArgumentException e2) {
                C5165e.m24908c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException");
            } catch (NoSuchFieldException e3) {
                C5165e.m24908c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException");
            } catch (SecurityException e4) {
                C5165e.m24906b("ReflectionUtils", "not security int method getStaticFieldObj");
            }
        }
        return obj;
    }
}
