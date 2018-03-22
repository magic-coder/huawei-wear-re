package com.google.zxing.client.p285a;

import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: CalendarParsedResult */
public final class C3749g extends C3743q {
    private static final Pattern f14581a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] f14582b = new long[]{LightCloudConstants.LightCloud_INTERVAL_TIME, 86400000, 3600000, FileWatchdog.DEFAULT_DELAY, 1000};
    private static final Pattern f14583c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private static final DateFormat f14584d = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private static final DateFormat f14585e = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    private final String f14586f;
    private final Date f14587g;
    private final boolean f14588h;
    private final Date f14589i;
    private final boolean f14590j;
    private final String f14591k;
    private final String f14592l;
    private final String[] f14593m;
    private final String f14594n;
    private final double f14595o;
    private final double f14596p;

    static {
        f14584d.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public C3749g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(C3759r.CALENDAR);
        this.f14586f = str;
        try {
            this.f14587g = C3749g.m18888a(str2);
            if (str3 == null) {
                long a = C3749g.m18886a((CharSequence) str4);
                this.f14589i = a < 0 ? null : new Date(a + this.f14587g.getTime());
            } else {
                try {
                    this.f14589i = C3749g.m18888a(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            this.f14588h = str2.length() == 8;
            boolean z = str3 != null && str3.length() == 8;
            this.f14590j = z;
            this.f14591k = str5;
            this.f14592l = str6;
            this.f14593m = strArr;
            this.f14594n = str7;
            this.f14595o = d;
            this.f14596p = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(100);
        C3743q.m18840a(this.f14586f, stringBuilder);
        C3743q.m18840a(C3749g.m18887a(this.f14588h, this.f14587g), stringBuilder);
        C3743q.m18840a(C3749g.m18887a(this.f14590j, this.f14589i), stringBuilder);
        C3743q.m18840a(this.f14591k, stringBuilder);
        C3743q.m18840a(this.f14592l, stringBuilder);
        C3743q.m18841a(this.f14593m, stringBuilder);
        C3743q.m18840a(this.f14594n, stringBuilder);
        return stringBuilder.toString();
    }

    private static Date m18888a(String str) throws ParseException {
        if (!f14583c.matcher(str).matches()) {
            throw new ParseException(str, 0);
        } else if (str.length() == 8) {
            return f14584d.parse(str);
        } else {
            if (str.length() != 16 || str.charAt(15) != 'Z') {
                return f14585e.parse(str);
            }
            Date parse = f14585e.parse(str.substring(0, 15));
            Calendar gregorianCalendar = new GregorianCalendar();
            long time = parse.getTime() + ((long) gregorianCalendar.get(15));
            gregorianCalendar.setTime(new Date(time));
            return new Date(time + ((long) gregorianCalendar.get(16)));
        }
    }

    private static String m18887a(boolean z, Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dateInstance;
        if (z) {
            dateInstance = DateFormat.getDateInstance(2);
        } else {
            dateInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateInstance.format(date);
    }

    private static long m18886a(CharSequence charSequence) {
        long j = -1;
        if (charSequence != null) {
            Matcher matcher = f14581a.matcher(charSequence);
            if (matcher.matches()) {
                j = 0;
                for (int i = 0; i < f14582b.length; i++) {
                    String group = matcher.group(i + 1);
                    if (group != null) {
                        j += ((long) Integer.parseInt(group)) * f14582b[i];
                    }
                }
            }
        }
        return j;
    }
}
