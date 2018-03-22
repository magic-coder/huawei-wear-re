package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: DeviceUtil */
public class C5479b {
    public static String m26181a() {
        String str;
        String str2 = "";
        try {
            str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.serialno"});
        } catch (NoSuchMethodException e) {
            C5482d.m26186d("DeviceUtil", "getSN NoSuchMethodException");
            str = str2;
        } catch (IllegalAccessException e2) {
            C5482d.m26186d("DeviceUtil", "getSN IllegalAccessException");
            str = str2;
        } catch (ClassNotFoundException e3) {
            C5482d.m26186d("DeviceUtil", "getSN ClassNotFoundException");
            str = str2;
        } catch (IllegalArgumentException e4) {
            C5482d.m26186d("DeviceUtil", "getSN IllegalArgumentException");
            str = str2;
        } catch (InvocationTargetException e5) {
            C5482d.m26186d("DeviceUtil", "getSN InvocationTargetException");
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.SERIAL;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
