package com.huawei.hms.p039c;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: Util */
public class C0859g {
    public static boolean m3028a() {
        Object a;
        Object a2;
        String str;
        String str2 = "";
        String str3 = "";
        try {
            a = C0859g.m3024a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.language"});
            a2 = C0859g.m3024a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.region"});
            if (a != null) {
                str2 = (String) a;
            }
            if (a2 != null) {
                a = (String) a2;
            } else {
                str = str3;
            }
            a2 = str2;
        } catch (Exception e) {
            Exception exception = e;
            str = str2;
            C0887a.m3098d("Util", "can not get language and region:" + exception.getMessage());
            String str4 = str;
            str = str3;
        }
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(a)) {
            return C0859g.m3029b();
        }
        return PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(a2) && HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(a);
    }

    public static boolean m3029b() {
        return HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(Locale.getDefault().getCountry());
    }

    public static Object m3024a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Object invoke;
        Class cls = null;
        if (clsArr == null || objArr == null || clsArr.length != objArr.length) {
            C0887a.m3092a("Util", "invokeFun params invalid");
        } else {
            Object a = C0859g.m3023a(str);
            if (a != null) {
                Class cls2;
                Method method;
                try {
                    cls2 = Class.forName(str);
                } catch (ClassNotFoundException e) {
                    C0887a.m3098d("Util", "can not find class:" + str);
                    cls2 = cls;
                }
                if (cls2 != null) {
                    try {
                        method = cls2.getMethod(str2, clsArr);
                    } catch (NoSuchMethodException e2) {
                        C0887a.m3098d("Util", "can not find method:" + str2);
                    }
                    if (method != null) {
                        try {
                            invoke = method.invoke(a, objArr);
                        } catch (IllegalAccessException e3) {
                            C0887a.m3098d("Util", "method can not invoke:" + e3.getMessage());
                        } catch (IllegalArgumentException e4) {
                            C0887a.m3098d("Util", "method can not invoke:" + e4.getMessage());
                        } catch (InvocationTargetException e5) {
                            C0887a.m3098d("Util", "method can not invoke:" + e5.getMessage());
                        }
                    }
                }
                Object obj = cls;
                if (method != null) {
                    invoke = method.invoke(a, objArr);
                }
            }
        }
        return invoke;
    }

    public static Object m3023a(String str) {
        Class cls;
        Object newInstance;
        Class cls2 = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            C0887a.m3098d("Util", "can not find class:" + str);
            cls = cls2;
        }
        if (cls != null) {
            try {
                newInstance = cls.newInstance();
            } catch (InstantiationException e2) {
                C0887a.m3098d("Util", "class creat instance error :" + e2.getMessage());
            } catch (IllegalAccessException e3) {
                C0887a.m3098d("Util", "class creat instance error :" + e3.getMessage());
            }
        }
        return newInstance;
    }

    public static String m3025a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            C0887a.m3098d("Util", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("com.huawei.hms.client.appid");
                if (obj != null) {
                    return String.valueOf(obj);
                }
            }
            C0887a.m3098d("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (NameNotFoundException e) {
            C0887a.m3098d("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        }
    }

    public static String m3026a(Context context, String str) {
        if (context == null) {
            C0887a.m3098d("Util", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            C0887a.m3098d("Util", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (NameNotFoundException e) {
            C0887a.m3098d("Util", "In getAppName, Failed to get app name.");
            return "";
        } catch (NotFoundException e2) {
            C0887a.m3098d("Util", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static void m3027a(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            C0887a.m3098d("Util", "On unBindServiceException:" + e.getMessage());
        }
    }
}
