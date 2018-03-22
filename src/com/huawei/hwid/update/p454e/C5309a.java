package com.huawei.hwid.update.p454e;

import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.update.p454e.p455a.C5306a;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* compiled from: UpdateUtils */
public abstract class C5309a {
    public static String m25667a(Context context) {
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

    public static String m25669b(Context context) {
        Object a = C5309a.m25668a("ro.product.locale.region");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String d = C5309a.m25671d(context);
        return TextUtils.isEmpty(d) ? "" : d;
    }

    private static String m25671d(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.locale != null) {
            String country = configuration.locale.getCountry();
            if (country != null) {
                return country;
            }
        }
        return "";
    }

    private static String m25668a(String str) {
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
        C5165e.m24910d("UpdateUtils", "An exception occurred while reading: " + str);
        return "";
    }

    public static boolean m25670c(Context context) {
        Object a = C5309a.m25668a("ro.product.locale.region");
        if (TextUtils.isEmpty(a)) {
            a = C5309a.m25671d(context);
            if (TextUtils.isEmpty(a)) {
                return C5309a.m25672e(context).startsWith(HwAccountConstants.DEFAULT_COUNTRY_MNC) ? true : true;
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

    private static String m25672e(Context context) {
        Object obj;
        CharSequence charSequence = "";
        C5306a a = C5306a.m25651a();
        if (a != null) {
            CharSequence a2;
            int b = a.mo4677b();
            if (b == -1 || 5 == a.m25654b(b)) {
                a2 = a.mo4676a(b);
                if (TextUtils.isEmpty(a2)) {
                    a2 = a.m25656c(b);
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
