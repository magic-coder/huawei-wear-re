package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AbsoluteTimeDateFormat extends DateFormat {
    public static final String ABS_TIME_DATE_FORMAT = "ABSOLUTE";
    public static final String DATE_AND_TIME_DATE_FORMAT = "DATE";
    public static final String ISO8601_DATE_FORMAT = "ISO8601";
    private static long previousTime = 0;
    private static char[] previousTimeWithoutMillis = new char[9];
    private static final long serialVersionUID = -388856345976723342L;

    public AbsoluteTimeDateFormat() {
        setCalendar(Calendar.getInstance());
    }

    public AbsoluteTimeDateFormat(TimeZone timeZone) {
        setCalendar(Calendar.getInstance(timeZone));
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        long time = date.getTime();
        int i = (int) (time % 1000);
        if (time - ((long) i) != previousTime || previousTimeWithoutMillis[0] == '\u0000') {
            this.calendar.setTime(date);
            int length = stringBuffer.length();
            int i2 = this.calendar.get(11);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(':');
            i2 = this.calendar.get(12);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(':');
            i2 = this.calendar.get(13);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(',');
            stringBuffer.getChars(length, stringBuffer.length(), previousTimeWithoutMillis, 0);
            previousTime = time - ((long) i);
        } else {
            stringBuffer.append(previousTimeWithoutMillis);
        }
        if (i < 100) {
            stringBuffer.append('0');
        }
        if (i < 10) {
            stringBuffer.append('0');
        }
        stringBuffer.append(i);
        return stringBuffer;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return null;
    }
}
