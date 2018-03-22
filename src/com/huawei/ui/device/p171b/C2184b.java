package com.huawei.ui.device.p171b;

import android.content.Context;
import android.text.format.DateFormat;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: AlarmUtil */
public class C2184b {
    public static String m11195a(int i, Context context) {
        return C2184b.m11199c(C2184b.m11198b(C2184b.m11197a("", context, i), context, i), context, i);
    }

    private static String m11197a(String str, Context context, int i) {
        String string;
        if ((i & 64) == 64) {
            string = context.getResources().getString(i.IDS_sunday);
        } else {
            string = str;
        }
        if ((i & 1) == 1) {
            if (!string.equals("")) {
                string = string + HwAccountConstants.BLANK;
            }
            string = string + context.getResources().getString(i.IDS_monday);
        }
        if ((i & 2) != 2) {
            return string;
        }
        if (!string.equals("")) {
            string = string + HwAccountConstants.BLANK;
        }
        return string + context.getResources().getString(i.IDS_tuesday);
    }

    private static String m11198b(String str, Context context, int i) {
        String str2;
        if ((i & 4) == 4) {
            if (!str.equals("")) {
                str = str + HwAccountConstants.BLANK;
            }
            str2 = str + context.getResources().getString(i.IDS_wednesday);
        } else {
            str2 = str;
        }
        if ((i & 8) == 8) {
            if (!str2.equals("")) {
                str2 = str2 + HwAccountConstants.BLANK;
            }
            str2 = str2 + context.getResources().getString(i.IDS_thursday);
        }
        if ((i & 16) == 16) {
            if (!str2.equals("")) {
                str2 = str2 + HwAccountConstants.BLANK;
            }
            str2 = str2 + context.getResources().getString(i.IDS_friday);
        }
        if ((i & 32) != 32) {
            return str2;
        }
        if (!str2.equals("")) {
            str2 = str2 + HwAccountConstants.BLANK;
        }
        return str2 + context.getResources().getString(i.IDS_saturday);
    }

    private static String m11199c(String str, Context context, int i) {
        String str2;
        if (i == 127) {
            if (!str.equals("")) {
                str = "";
            }
            str2 = str + context.getResources().getString(i.IDS_every_day);
        } else {
            str2 = str;
        }
        if (i == 31) {
            if (!str2.equals("")) {
                str2 = "";
            }
            str2 = str2 + context.getResources().getString(i.IDS_every_day_work);
        }
        if (i != 0) {
            return str2;
        }
        if (!str2.equals("")) {
            str2 = "";
        }
        return str2 + context.getResources().getString(i.IDS_only_once);
    }

    public static String m11196a(Context context, int i) {
        String format;
        ParseException e;
        String str = (i / 100) + ":" + (i % 100);
        try {
            format = DateFormat.getTimeFormat(context.getApplicationContext()).format(Long.valueOf(new SimpleDateFormat("HH:mm").parse(str).getTime()));
            try {
                C2538c.m12677c("AlarmUtil", "getOffsetTimeStr dateFormat offsetStr = " + format);
            } catch (ParseException e2) {
                e = e2;
                C2538c.m12677c("AlarmUtil", "e.getMessage() = " + e.getMessage());
                return format;
            }
        } catch (ParseException e3) {
            ParseException parseException = e3;
            format = str;
            e = parseException;
            C2538c.m12677c("AlarmUtil", "e.getMessage() = " + e.getMessage());
            return format;
        }
        return format;
    }
}
