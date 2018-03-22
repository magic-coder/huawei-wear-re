package com.huawei.hms.update.p051f;

import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p051f.p052a.C0947a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* compiled from: UpdateUtils */
public abstract class C0950a {
    public static String m3305a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.locale != null) {
            String language = configuration.locale.getLanguage();
            String country = configuration.locale.getCountry();
            if (!(language == null || country == null)) {
                return language.toLowerCase(Locale.getDefault()) + '_' + country.toUpperCase(Locale.getDefault());
            }
        }
        return "";
    }

    public static String m3307b(Context context) {
        Object a = C0950a.m3306a("ro.product.locale.region");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String d = C0950a.m3309d(context);
        return TextUtils.isEmpty(d) ? "" : d;
    }

    private static String m3309d(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.locale != null) {
            String country = configuration.locale.getCountry();
            if (country != null) {
                return country;
            }
        }
        return "";
    }

    private static String m3306a(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        } catch (IllegalAccessException e3) {
        } catch (IllegalArgumentException e4) {
        } catch (InvocationTargetException e5) {
        } catch (ClassCastException e6) {
        }
        C0887a.m3098d("UpdateUtils", "An exception occurred while reading: " + str);
        return "";
    }

    public static boolean m3308c(Context context) {
        Object a = C0950a.m3306a("ro.product.locale.region");
        if (TextUtils.isEmpty(a)) {
            a = C0950a.m3309d(context);
            if (TextUtils.isEmpty(a)) {
                return C0950a.m3310e(context).startsWith(HwAccountConstants.DEFAULT_COUNTRY_MNC) ? true : true;
            } else {
                if (HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(a)) {
                    return true;
                }
                return false;
            }
        } else if (HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE.equalsIgnoreCase(a)) {
            return true;
        } else {
            return false;
        }
    }

    private static String m3310e(Context context) {
        Object obj;
        CharSequence charSequence = "";
        C0947a a = C0947a.m3289a();
        if (a != null) {
            CharSequence a2;
            int b = a.mo2285b();
            if (b == -1 || 5 == a.m3292b(b)) {
                a2 = a.mo2284a(b);
                if (TextUtils.isEmpty(a2)) {
                    a2 = a.m3294c(b);
                }
            } else {
                a2 = charSequence;
            }
            obj = a2;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                obj = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(obj)) {
                    obj = telephonyManager.getSubscriberId();
                }
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return HwAccountConstants.DEFAULT_DEVICEPLMN;
        }
        return obj.substring(0, 5);
    }
}
