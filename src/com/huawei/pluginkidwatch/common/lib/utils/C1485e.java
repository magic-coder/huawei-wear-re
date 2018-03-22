package com.huawei.pluginkidwatch.common.lib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: DateUtil */
public class C1485e {
    private static Map<Integer, String> f3458a = new HashMap();

    public static Date m6850a() {
        return Calendar.getInstance().getTime();
    }

    public static Date m6852a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, -1);
        return instance.getTime();
    }

    public static Date m6860b(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, 1);
        return instance.getTime();
    }

    public static boolean m6855a(Date date, Date date2) {
        String d = C1485e.m6867d(date);
        C2538c.m12674b("DateUtil", "dateYMDEqual: strDate1 = " + d + ", strDate2 = " + C1485e.m6867d(date2));
        return d.equals(C1485e.m6867d(date2));
    }

    public static boolean m6865c(Date date) {
        return C1485e.m6855a(C1485e.m6850a(), date);
    }

    public static String m6867d(Date date) {
        C2538c.m12674b("DateUtil", "getStartAndEndDayOfCurrentMonth() getDataBaseDate enter format(day) = " + date);
        return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(date);
    }

    public static Date m6851a(String str) {
        Date date = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                C2538c.m12674b("DateUtil", "getStartAndEndDayOfCurrentMonth() getDataBaseDate enter parse(day) = " + str);
                date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
            } catch (ParseException e) {
                C2538c.m12680e("DateUtil", "Exception e = " + e.getMessage());
            }
        }
        return date;
    }

    public static int m6856b() {
        Calendar instance = Calendar.getInstance();
        return instance.get(5) + ((instance.get(1) * 10000) + ((instance.get(2) + 1) * 100));
    }

    public static String m6857b(String str) {
        String substring = str.substring(8, 10);
        String substring2 = str.substring(10);
        StringBuffer stringBuffer = new StringBuffer();
        if (Integer.parseInt(substring) < 10) {
            substring = str.substring(9, 10);
        }
        if (Integer.parseInt(substring) >= 13) {
            substring = String.valueOf(Integer.parseInt(substring) - 12);
        } else if (substring.equals("0")) {
            substring = "12";
        }
        stringBuffer.append(substring);
        stringBuffer.append(":");
        stringBuffer.append(substring2);
        return stringBuffer.toString();
    }

    public static String m6863c(String str) {
        String substring = str.substring(8, 10);
        String substring2 = str.substring(10);
        StringBuffer stringBuffer = new StringBuffer();
        if (Integer.parseInt(substring) < 10) {
            substring = str.substring(9, 10);
        }
        stringBuffer.append(substring);
        stringBuffer.append(":");
        stringBuffer.append(substring2);
        return stringBuffer.toString();
    }

    public static String m6848a(Context context, String str) {
        if (Integer.parseInt(str.substring(8, 10)) < 12) {
            return context.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_am);
        }
        return context.getResources().getString(C1680l.IDS_plugin_kidwatch_menu_notification_history_pm);
    }

    public static String m6861c() {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
    }

    public static Date m6853a(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, -i);
        return instance.getTime();
    }

    public static int m6845a(String str, String str2) {
        long j;
        long j2 = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            j2 = simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(str2).getTime();
            j = (((j2 / 1000) / 60) / 60) / 24;
        } catch (ParseException e) {
            ParseException parseException = e;
            j = j2;
            ParseException parseException2 = parseException;
            C2538c.m12680e("DateUtil", "Exception e = " + parseException2.getMessage());
        }
        return (int) j;
    }

    public static String m6866d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, 4));
        stringBuffer.append(str.substring(5, 7));
        stringBuffer.append(str.substring(8, 10));
        return stringBuffer.toString();
    }

    public static int m6868e(String str) {
        String substring = str.substring(8, 10);
        if (Integer.parseInt(substring) < 10) {
            substring = str.substring(9, 10);
        }
        return Integer.parseInt(substring);
    }

    public static int m6869f(String str) {
        String substring = str.substring(10);
        if (Integer.parseInt(substring) < 10) {
            substring = str.substring(11);
        }
        return Integer.parseInt(substring);
    }

    public static String m6846a(int i) {
        int i2 = i / 60;
        String str = i2 + "";
        int i3 = i % 60;
        String str2 = i3 + "";
        if (i2 < 10) {
            str = "0" + i2;
        }
        if (i3 < 10) {
            str2 = "0" + i3;
        }
        return str + ":" + str2;
    }

    static {
        f3458a.put(Integer.valueOf(1), "yyyy-MM-dd");
        f3458a.put(Integer.valueOf(2), "yyyy/MM/dd");
        f3458a.put(Integer.valueOf(3), "yyyy年MM月dd日");
        f3458a.put(Integer.valueOf(4), "yyyyMMdd");
        f3458a.put(Integer.valueOf(5), "dd/MM/yyyy");
        f3458a.put(Integer.valueOf(6), "yyyy年MM月");
        f3458a.put(Integer.valueOf(7), "MM/dd");
        f3458a.put(Integer.valueOf(8), "HH:mm");
    }

    public static String m6849a(Date date, String str) {
        if (!f3458a.containsValue(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        if (date == null) {
            return null;
        }
        return simpleDateFormat.format(date);
    }

    public static String m6847a(long j) {
        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date(j));
    }

    public static Date m6859b(long j) {
        if (j > 0) {
            return new Date(j);
        }
        return null;
    }

    public static String m6862c(long j) {
        if (j <= 0) {
            return "00:00:00";
        }
        return "00:" + new SimpleDateFormat("mm:ss").format(Long.valueOf(j));
    }

    public static String m6858b(String str, String str2) {
        ParseException e;
        if (!f3458a.containsValue(str2)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat;
        Date parse;
        try {
            simpleDateFormat = new SimpleDateFormat(str2);
            try {
                parse = simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                e = e2;
                C2538c.m12680e("DateUtil", "Exception e = " + e.getMessage());
                parse = null;
                if (parse != null) {
                    return null;
                }
                return simpleDateFormat.format(C1485e.m6852a(parse));
            }
        } catch (ParseException e3) {
            e = e3;
            simpleDateFormat = null;
            C2538c.m12680e("DateUtil", "Exception e = " + e.getMessage());
            parse = null;
            if (parse != null) {
                return simpleDateFormat.format(C1485e.m6852a(parse));
            }
            return null;
        }
        if (parse != null) {
            return simpleDateFormat.format(C1485e.m6852a(parse));
        }
        return null;
    }

    public static String m6864c(String str, String str2) {
        Date parse;
        ParseException e;
        if (!f3458a.containsValue(str2)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat;
        try {
            simpleDateFormat = new SimpleDateFormat(str2);
            try {
                parse = simpleDateFormat.parse(str);
            } catch (ParseException e2) {
                e = e2;
                C2538c.m12680e("DateUtil", "Exception e = " + e.getMessage());
                parse = null;
                if (parse == null) {
                    return null;
                }
                return simpleDateFormat.format(C1485e.m6860b(parse));
            }
        } catch (ParseException e3) {
            e = e3;
            simpleDateFormat = null;
            C2538c.m12680e("DateUtil", "Exception e = " + e.getMessage());
            parse = null;
            if (parse == null) {
                return simpleDateFormat.format(C1485e.m6860b(parse));
            }
            return null;
        }
        if (parse == null) {
            return null;
        }
        return simpleDateFormat.format(C1485e.m6860b(parse));
    }

    public static String m6870g(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, 4));
        stringBuffer.append("-");
        stringBuffer.append(str.substring(4, 6));
        stringBuffer.append("-");
        stringBuffer.append(str.substring(6, 8));
        return stringBuffer.toString();
    }

    public static boolean m6854a(Context context) {
        DateFormat dateFormat = new DateFormat();
        return DateFormat.is24HourFormat(context);
    }
}
