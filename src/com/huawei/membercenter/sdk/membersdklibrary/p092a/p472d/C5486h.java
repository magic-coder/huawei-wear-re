package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Base64;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p469a.C5467a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Utils */
public final class C5486h {
    public static void m26202a(Exception exception, String str) {
        if (exception != null) {
            C5482d.m26186d(str, exception.getMessage());
        }
    }

    private static String m26213c(String str) {
        Object cls;
        Method declaredMethod;
        Exception e;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
            } catch (ClassNotFoundException e2) {
                e = e2;
                C5486h.m26202a(e, "MemberSDk_Utils[systemPropertiesGet]");
                declaredMethod = null;
                if (declaredMethod != null) {
                    try {
                        return (String) declaredMethod.invoke(cls, new Object[]{str});
                    } catch (Exception e3) {
                        C5486h.m26202a(e3, "MemberSDk_Utils[systemPropertiesGet]");
                        return null;
                    } catch (Exception e32) {
                        C5486h.m26202a(e32, "MemberSDk_Utils[systemPropertiesGet]");
                        return null;
                    } catch (Exception e322) {
                        C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet]");
                    }
                }
                return null;
            } catch (NoSuchMethodException e4) {
                e322 = e4;
                C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet]");
                declaredMethod = null;
                if (declaredMethod != null) {
                    return (String) declaredMethod.invoke(cls, new Object[]{str});
                }
                return null;
            }
        } catch (ClassNotFoundException e5) {
            e322 = e5;
            cls = null;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet]");
            declaredMethod = null;
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(cls, new Object[]{str});
            }
            return null;
        } catch (NoSuchMethodException e6) {
            e322 = e6;
            cls = null;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet]");
            declaredMethod = null;
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(cls, new Object[]{str});
            }
            return null;
        }
        if (declaredMethod != null) {
            return (String) declaredMethod.invoke(cls, new Object[]{str});
        }
        return null;
    }

    public static String m26199a(String str, String str2) {
        Object cls;
        Exception e;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                method = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
            } catch (ClassNotFoundException e2) {
                e = e2;
                C5486h.m26202a(e, "MemberSDk_Utils[systemPropertiesGet2]");
                if (method == null) {
                    return str2;
                }
                try {
                    return (String) method.invoke(cls, new Object[]{str, str2});
                } catch (Exception e3) {
                    C5486h.m26202a(e3, "MemberSDk_Utils[systemPropertiesGet2]");
                    return str2;
                } catch (Exception e32) {
                    C5486h.m26202a(e32, "MemberSDk_Utils[systemPropertiesGet2]");
                    return str2;
                } catch (Exception e322) {
                    C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet2]");
                    return str2;
                }
            } catch (NoSuchMethodException e4) {
                e322 = e4;
                C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet2]");
                if (method == null) {
                    return str2;
                }
                return (String) method.invoke(cls, new Object[]{str, str2});
            }
        } catch (ClassNotFoundException e5) {
            e322 = e5;
            cls = method;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet2]");
            if (method == null) {
                return str2;
            }
            return (String) method.invoke(cls, new Object[]{str, str2});
        } catch (NoSuchMethodException e6) {
            e322 = e6;
            cls = method;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGet2]");
            if (method == null) {
                return str2;
            }
            return (String) method.invoke(cls, new Object[]{str, str2});
        }
        if (method == null) {
            return str2;
        }
        return (String) method.invoke(cls, new Object[]{str, str2});
    }

    public static boolean m26206a(String str, boolean z) {
        Object cls;
        Exception e;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                method = cls.getDeclaredMethod("getBoolean", new Class[]{String.class, String.class});
            } catch (ClassNotFoundException e2) {
                e = e2;
                C5486h.m26202a(e, "MemberSDk_Utils[systemPropertiesGetBoolean]");
                if (method != null) {
                    try {
                        z = ((Boolean) method.invoke(cls, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
                    } catch (Exception e3) {
                        C5486h.m26202a(e3, "MemberSDk_Utils[systemPropertiesGetBoolean]");
                    } catch (Exception e32) {
                        C5486h.m26202a(e32, "MemberSDk_Utils[systemPropertiesGetBoolean]");
                    } catch (Exception e322) {
                        C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGetBoolean]");
                    }
                }
                return z;
            } catch (NoSuchMethodException e4) {
                e322 = e4;
                C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGetBoolean]");
                if (method != null) {
                    z = ((Boolean) method.invoke(cls, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
                }
                return z;
            }
        } catch (ClassNotFoundException e5) {
            e322 = e5;
            cls = method;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGetBoolean]");
            if (method != null) {
                z = ((Boolean) method.invoke(cls, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
            }
            return z;
        } catch (NoSuchMethodException e6) {
            e322 = e6;
            cls = method;
            C5486h.m26202a(e322, "MemberSDk_Utils[systemPropertiesGetBoolean]");
            if (method != null) {
                z = ((Boolean) method.invoke(cls, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
            }
            return z;
        }
        if (method != null) {
            z = ((Boolean) method.invoke(cls, new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        return z;
    }

    private static int m26192a(String str, String str2, int i) {
        Class cls = null;
        try {
            cls = Class.forName(str);
        } catch (Exception e) {
            C5486h.m26202a(e, "MemberSDk_Utils[getIntFiled]");
        }
        if (cls != null) {
            try {
                i = cls.getField(str2).getInt(null);
            } catch (Exception e2) {
                C5486h.m26202a(e2, "MemberSDk_Utils[getIntFiled]");
            } catch (Exception e22) {
                C5486h.m26202a(e22, "MemberSDk_Utils[getIntFiled]");
            } catch (Exception e222) {
                C5486h.m26202a(e222, "MemberSDk_Utils[getIntFiled]");
            }
        }
        return i;
    }

    private static Object m26207b(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C5482d.m26186d("MemberSDk_Utils", "invokeFun 参数有误");
            return cls;
        }
        Class cls2;
        try {
            cls2 = Class.forName(str);
        } catch (Exception e) {
            C5486h.m26202a(e, "MemberSDk_Utils[invokeFun]");
            cls2 = cls;
        }
        if (cls2 == null) {
            return cls;
        }
        Object newInstance;
        try {
            newInstance = cls2.newInstance();
        } catch (Exception e2) {
            C5486h.m26202a(e2, "MemberSDk_Utils[invokeFun]");
        } catch (Exception e22) {
            C5486h.m26202a(e22, "MemberSDk_Utils[invokeFun]");
        }
        return C5486h.m26193a(cls2, newInstance, str2, clsArr, objArr);
    }

    public static Object m26194a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C5482d.m26183a("MemberSDk_Utils", "invokeStaticFun 参数有误");
        } else {
            Class cls2;
            try {
                cls2 = Class.forName(str);
            } catch (Exception e) {
                C5486h.m26202a(e, "MemberSDk_Utils[invokeStaticFun]");
                cls2 = cls;
            }
            if (cls2 != null) {
                Method declaredMethod;
                try {
                    declaredMethod = cls2.getDeclaredMethod(str2, clsArr);
                } catch (Exception e2) {
                    C5486h.m26202a(e2, "MemberSDk_Utils[invokeStaticFun]");
                    Object obj = cls;
                }
                if (declaredMethod != null) {
                    try {
                        invoke = declaredMethod.invoke(cls2, objArr);
                    } catch (Exception e22) {
                        C5486h.m26202a(e22, "MemberSDk_Utils[invokeStaticFun]");
                    } catch (Exception e222) {
                        C5486h.m26202a(e222, "MemberSDk_Utils[invokeStaticFun]");
                    } catch (Exception e2222) {
                        C5486h.m26202a(e2222, "MemberSDk_Utils[invokeStaticFun]");
                    }
                }
            }
        }
        return invoke;
    }

    public static Object m26193a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        Object invoke;
        Method method2 = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (Exception e) {
            C5486h.m26202a(e, "MemberSDk_Utils[invokeFun]");
            method = method2;
        }
        if (method != null) {
            try {
                invoke = method.invoke(obj, objArr);
            } catch (Exception e2) {
                C5486h.m26202a(e2, "MemberSDk_Utils[invokeFun]");
            } catch (Exception e22) {
                C5486h.m26202a(e22, "MemberSDk_Utils[invokeFun]");
            } catch (Exception e222) {
                C5486h.m26202a(e222, "MemberSDk_Utils[invokeFun]");
            }
        }
        return invoke;
    }

    public static String m26196a(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Exception e) {
                    C5486h.m26202a(e, "MemberSDk_Utils[readStream]");
                } finally {
                    C5486h.m26201a(byteArrayOutputStream, "MemberSDk_Utils");
                }
            }
            str = byteArrayOutputStream.toString(GameManager.DEFAULT_CHARSET);
        }
        return str;
    }

    public static void m26201a(OutputStream outputStream, String str) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
                C5486h.m26202a(e, str + "[closeStream]");
            }
        }
    }

    public static void m26200a(InputStream inputStream, String str) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
                C5486h.m26202a(e, str + "[closeStream]");
            }
        }
    }

    private static String m26198a(String str, Long l) {
        String str2 = null;
        try {
            str2 = new SimpleDateFormat(str, Locale.getDefault()).format(new Date(l.longValue()));
        } catch (IllegalArgumentException e) {
            C5482d.m26186d("MemberSDk_Utils", "getFormatTimeString IllegalArgumentException");
        }
        return str2;
    }

    public static String m26195a() {
        StringBuffer stringBuffer = new StringBuffer();
        String a = C5486h.m26198a("yyyyMMddHHmmssSSS", Long.valueOf(System.currentTimeMillis()));
        int nextInt = (new SecureRandom().nextInt(10000) + 10000) % 10000;
        if (nextInt < 1000) {
            nextInt += 1000;
        }
        stringBuffer.append(a).append(nextInt);
        String stringBuffer2 = stringBuffer.toString();
        C5482d.m26183a("MemberSDk_Utils", "creatSalt salt" + stringBuffer2);
        return stringBuffer2;
    }

    public static String m26197a(String str) {
        byte[] bArr = null;
        for (int i = 0; i < 3; i++) {
            bArr = C5486h.m26211b("TDID", str);
            if (bArr != null && bArr.length != 0) {
                C5482d.m26186d("MemberSDk_Utils", "Succeed to get sign at " + i + "times");
                break;
            }
            C5482d.m26186d("MemberSDk_Utils", "Fail to get sign at " + i + "times");
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    private static byte[] m26211b(String str, String str2) {
        if (-1 == C5486h.m26192a("com.huawei.attestation.HwAttestationManager", "KEY_INDEX_HWCLOUD", -1)) {
            C5482d.m26186d("MemberSDk_Utils", "getSign keyIndexHwcloud == -1");
            return new byte[0];
        }
        if (-1 == C5486h.m26192a("com.huawei.attestation.HwAttestationManager", "DEVICE_ID_TYPE_EMMC", -1)) {
            C5482d.m26186d("MemberSDk_Utils", "getSign deviceIdTypeEmmc == -1");
            return new byte[0];
        }
        byte[] bArr = null;
        try {
            bArr = str2.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C5482d.m26186d("MemberSDk_Utils", "getSign UnsupportedEncodingException");
        }
        Object b = C5486h.m26207b("com.huawei.attestation.HwAttestationManager", "getAttestationSignature", new Class[]{Integer.TYPE, Integer.TYPE, String.class, byte[].class}, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3), str, bArr});
        if (b != null) {
            bArr = (byte[]) b;
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        C5482d.m26186d("MemberSDk_Utils", "getSign fail");
        return bArr;
    }

    public static String m26208b() {
        return Build.DISPLAY;
    }

    public static String m26212c() {
        return C5486h.m26213c("ro.product.brand");
    }

    private static String m26215e() {
        String country = Locale.getDefault().getCountry();
        return country != null ? country : "";
    }

    private static String m26216f() {
        String language = Locale.getDefault().getLanguage();
        return language != null ? language : "";
    }

    public static String m26214d() {
        String f = C5486h.m26216f();
        return (f + "-" + C5486h.m26215e()).toLowerCase(Locale.US);
    }

    public static boolean m26205a(String str, String str2, boolean z) {
        Class cls = null;
        try {
            cls = Class.forName(str);
        } catch (Exception e) {
            C5486h.m26202a(e, "MemberSDk_Utils[getBooleanFiled]");
        }
        if (cls != null) {
            try {
                AccessibleObject declaredField = cls.getDeclaredField(str2);
                C5486h.m26203a(declaredField);
                z = declaredField.getBoolean(null);
            } catch (Exception e2) {
                C5486h.m26202a(e2, "MemberSDk_Utils[getBooleanFiled]");
            } catch (Exception e22) {
                C5486h.m26202a(e22, "MemberSDk_Utils[getBooleanFiled]");
            } catch (Exception e222) {
                C5486h.m26202a(e222, "MemberSDk_Utils[getBooleanFiled]");
            }
        }
        return z;
    }

    private static void m26203a(AccessibleObject accessibleObject) {
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
    }

    public static boolean m26204a(Context context) {
        return C5486h.m26209b(context) && C5486h.m26217g();
    }

    private static boolean m26209b(Context context) {
        if (context == null) {
            C5482d.m26186d("MemberSDk_Utils", "isSystemApp context is null");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (!(applicationInfo == null || (applicationInfo.flags & 1) == 0)) {
                C5482d.m26184b("MemberSDk_Utils", "is System App");
                return true;
            }
        } catch (NameNotFoundException e) {
            C5482d.m26186d("MemberSDk_Utils", "isSystemApp: NameNotFoundException");
        }
        C5482d.m26184b("MemberSDk_Utils", "not System App");
        return false;
    }

    private static boolean m26217g() {
        boolean z = true;
        try {
            Class cls = Class.forName("android.telephony.HwTelephonyManager");
            if (cls == null) {
                return false;
            }
            AccessibleObject declaredField = cls.getDeclaredField("SUPPORT_SYSTEMAPP_GET_DEVICEID");
            C5486h.m26203a(declaredField);
            if (declaredField.getInt(cls) != 1) {
                z = false;
            }
            return z;
        } catch (ClassNotFoundException e) {
            C5482d.m26186d("MemberSDk_Utils", "supportNewPermissionCheck: ClassNotFoundException");
            C5482d.m26184b("MemberSDk_Utils", "not support New Permission");
            return false;
        } catch (NoSuchFieldException e2) {
            C5482d.m26186d("MemberSDk_Utils", "supportNewPermissionCheck: NoSuchFieldException");
            C5482d.m26184b("MemberSDk_Utils", "not support New Permission");
            return false;
        } catch (IllegalAccessException e3) {
            C5482d.m26186d("MemberSDk_Utils", "supportNewPermissionCheck: IllegalAccessException");
            C5482d.m26184b("MemberSDk_Utils", "not support New Permission");
            return false;
        } catch (IllegalArgumentException e4) {
            C5482d.m26186d("MemberSDk_Utils", "supportNewPermissionCheck: IllegalArgumentException");
            C5482d.m26184b("MemberSDk_Utils", "not support New Permission");
            return false;
        } catch (Exception e5) {
            C5486h.m26202a(e5, "MemberSDk_Utils[supportNewPermissionCheck]");
            C5482d.m26184b("MemberSDk_Utils", "not support New Permission");
            return false;
        }
    }

    public static boolean m26210b(String str) {
        for (String equals : C5467a.f19321a) {
            if (equals.equals(str)) {
                C5482d.m26183a("MemberSDk_Utils", "is watch app ");
                return true;
            }
        }
        C5482d.m26183a("MemberSDk_Utils", "not watch app ");
        return false;
    }
}
