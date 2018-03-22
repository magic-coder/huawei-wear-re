package com.huawei.wallet.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.utils.log.LogC;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"SimpleDateFormat"})
public class TimeUtil {
    public static String m28480a(String str) {
        SimpleDateFormat simpleDateFormat;
        if (TextUtils.isEmpty(str)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            simpleDateFormat = new SimpleDateFormat(str);
        }
        return simpleDateFormat.format(new Date());
    }

    public static Date m28483a(String str, String str2) {
        Date date = null;
        if (!(StringUtil.m28479a(str, true) || StringUtil.m28479a(str2, true))) {
            C2538c.c("TimeUtil", new Object[]{"parseString2Date dateStr : " + str + " format ：" + str2});
            try {
                date = new SimpleDateFormat(str2).parse(str);
            } catch (ParseException e) {
                C2538c.e("TimeUtil", new Object[]{"parseDateStr ParseException e : " + e.getMessage(), Boolean.valueOf(true)});
            }
        }
        return date;
    }

    public static String m28482a(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static boolean m28485b(String str, String str2) {
        if (StringUtil.m28479a(str, true) || StringUtil.m28479a(str2, true)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setLenient(false);
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse == null) {
                return false;
            }
            if (parse.after(new Date()) || m28484a(parse, new Date(), str2)) {
                return true;
            }
            return false;
        } catch (ParseException e) {
            LogC.m28534d("parseDateStr ParseException e : " + e.getMessage(), true);
            return false;
        }
    }

    public static boolean m28486c(String str, String str2) {
        if (StringUtil.m28479a(str, true) || StringUtil.m28479a(str2, true)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        simpleDateFormat.setLenient(false);
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse == null || !parse.after(new Date())) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            LogC.m28534d("parseDateStr ParseException e : " + e.getMessage(), true);
            return false;
        }
    }

    public static boolean m28484a(Date date, Date date2, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    public static String m28481a(String str, String str2, String str3) {
        C2538c.c("TimeUtil", new Object[]{"parseFormatString2String　date : " + str});
        Date a = m28483a(str, str2);
        if (a == null) {
            C2538c.c("TimeUtil", new Object[]{"parseString2D　date : " + str});
            return str;
        }
        C2538c.c("TimeUtil", new Object[]{"parseString2D is null "});
        return m28482a(a, str3);
    }
}
