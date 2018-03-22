package com.huawei.ui.commonui.p514d;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.C6033j;
import com.huawei.ui.commonui.C6034k;

/* compiled from: Utils */
public class C5999c {
    private static final String f20608a = C5999c.class.getSimpleName();

    public static int m27451a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int m27450a(Context context) {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            C2538c.e(f20608a, new Object[]{"Exception e = " + e.getMessage()});
        }
        return i;
    }

    public static boolean m27453b(Context context) {
        return C5999c.m27454c(context) || C5999c.m27455d(context);
    }

    public static boolean m27454c(Context context) {
        if (context == null) {
            C2538c.d(f20608a, new Object[]{"isChineseSimplified() context is null"});
            return false;
        } else if (PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH.equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage()) && PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equalsIgnoreCase(context.getResources().getConfiguration().locale.getCountry())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m27455d(Context context) {
        if (context == null) {
            C2538c.d(f20608a, new Object[]{"isEnglish() context is null"});
            return false;
        } else if ("en".equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean m27456e(Context context) {
        if (context == null) {
            C2538c.d(f20608a, new Object[]{"isRTLLanguage() context is null"});
            return false;
        } else if ("ar".equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage()) || "iw".equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage()) || "fa".equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage()) || "ur".equalsIgnoreCase(context.getResources().getConfiguration().locale.getLanguage())) {
            return true;
        } else {
            return false;
        }
    }

    public static float m27449a(Paint paint, String str) {
        return paint.measureText(str);
    }

    public static float m27448a(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static String m27457f(Context context) {
        C2538c.c(f20608a, new Object[]{"enter getMetisProductName:"});
        String str = null;
        if (context != null) {
            str = context.getResources().getConfiguration().locale.getCountry();
            C2538c.c(f20608a, new Object[]{"strCountryCode=" + str});
            if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(str)) {
                str = context.getResources().getString(C6034k.IDS_device_metis_name_honor_watch_s1);
            } else if ("RU".equals(str) || "IN".equals(str)) {
                str = context.getResources().getString(C6034k.IDS_device_metis_name_honor_watch_s1);
            } else {
                str = context.getResources().getString(C6034k.IDS_device_metis_name_title_1);
            }
            C2538c.c(f20608a, new Object[]{"name=" + str});
        }
        return str;
    }

    public static String m27458g(Context context) {
        C2538c.c(f20608a, new Object[]{"enter getMetisProductName:"});
        String str = null;
        if (context != null) {
            str = context.getResources().getConfiguration().locale.getCountry();
            C2538c.c(f20608a, new Object[]{"strCountryCode=" + str});
            if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(str)) {
                str = context.getResources().getString(C6034k.IDS_select_device_talkband_a1);
            } else if ("IN".equals(str)) {
                str = context.getResources().getString(C6034k.IDS_select_device_talkband_a2overseas);
            } else {
                str = context.getResources().getString(C6034k.IDS_select_device_talkband_a1overseas);
            }
            C2538c.c(f20608a, new Object[]{"name=" + str});
        }
        return str;
    }

    public static String m27459h(Context context) {
        C2538c.c(f20608a, new Object[]{"enter getB0ProductName:"});
        String str = null;
        if (context != null) {
            str = context.getResources().getConfiguration().locale.getCountry();
            C2538c.c(f20608a, new Object[]{"strCountryCode:" + str});
            if (PayManagerSettingSwitchDialog.COUNTRY_CODE_CN.equals(str)) {
                str = context.getResources().getString(C6034k.IDS_app_display_name_b0);
            } else if ("RU".equals(str) || "FR".equals(str) || "IN".equals(str) || "MY".equals(str) || "US".equals(str)) {
                str = context.getResources().getString(C6034k.IDS_app_display_name_b0_1);
            } else {
                str = context.getResources().getString(C6034k.IDS_app_display_name_b0);
            }
            C2538c.c(f20608a, new Object[]{"name:" + str});
        }
        return str;
    }

    public static String m27452a(Context context, long j) {
        if (context == null) {
            return "";
        }
        int i;
        float f;
        String format;
        float f2 = (float) j;
        int i2 = C6033j.IDS_hwh_size_byteShort;
        if (f2 > 900.0f) {
            i2 = C6033j.IDS_device_upgrade_file_size_kb;
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            i2 = C6033j.IDS_device_upgrade_file_size_mb;
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            i2 = C6033j.IDS_hwh_size_gigabyteShort;
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            i2 = C6033j.IDS_hwh_size_terabyteShort_unit;
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            i = C6033j.IDS_hwh_size_petabyteShort_unit;
            f = f2 / 1024.0f;
        } else {
            i = i2;
            f = f2;
        }
        if (f < DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            format = String.format("%.2f", new Object[]{Float.valueOf(f)});
        } else if (f < 10.0f) {
            format = String.format("%.2f", new Object[]{Float.valueOf(f)});
        } else if (f < 100.0f) {
            format = String.format("%.2f", new Object[]{Float.valueOf(f)});
        } else {
            format = String.format("%.0f", new Object[]{Float.valueOf(f)});
        }
        String str = "";
        try {
            return context.getResources().getQuantityString(i, Math.round(Float.parseFloat(format)), new Object[]{format});
        } catch (NotFoundException e) {
            C2538c.c(f20608a, new Object[]{"exception:" + e.getMessage()});
            return str;
        } catch (NumberFormatException e2) {
            C2538c.c(f20608a, new Object[]{"exception:" + e2.getMessage()});
            return str;
        }
    }
}
