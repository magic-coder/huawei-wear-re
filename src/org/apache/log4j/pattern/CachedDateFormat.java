package org.apache.log4j.pattern;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

public final class CachedDateFormat extends DateFormat {
    private static final String DIGITS = "0123456789";
    private static final int MAGIC1 = 654;
    private static final int MAGIC2 = 987;
    private static final String MAGICSTRING1 = "654";
    private static final String MAGICSTRING2 = "987";
    public static final int NO_MILLISECONDS = -2;
    public static final int UNRECOGNIZED_MILLISECONDS = -1;
    private static final String ZERO_STRING = "000";
    private static final long serialVersionUID = 1;
    private StringBuffer cache = new StringBuffer(50);
    private final int expiration;
    private final DateFormat formatter;
    private int millisecondStart;
    private long previousTime;
    private long slotBegin;
    private final Date tmpDate = new Date(0);

    public CachedDateFormat(DateFormat dateFormat, int i) {
        if (dateFormat == null) {
            throw new IllegalArgumentException("dateFormat cannot be null");
        } else if (i < 0) {
            throw new IllegalArgumentException("expiration must be non-negative");
        } else {
            this.formatter = dateFormat;
            this.expiration = i;
            this.millisecondStart = 0;
            this.previousTime = Long.MIN_VALUE;
            this.slotBegin = Long.MIN_VALUE;
        }
    }

    public static int findMillisecondStart(long j, String str, DateFormat dateFormat) {
        int i = MAGIC1;
        long j2 = (j / 1000) * 1000;
        if (j2 > j) {
            j2 -= 1000;
        }
        int i2 = (int) (j - j2);
        String str2 = MAGICSTRING1;
        if (i2 == MAGIC1) {
            i = MAGIC2;
            str2 = MAGICSTRING2;
        }
        String format = dateFormat.format(new Date(((long) i) + j2));
        if (format.length() != str.length()) {
            return -1;
        }
        i = 0;
        while (i < str.length()) {
            if (str.charAt(i) != format.charAt(i)) {
                StringBuffer stringBuffer = new StringBuffer("ABC");
                millisecondFormat(i2, stringBuffer, 0);
                String format2 = dateFormat.format(new Date(j2));
                if (format2.length() == str.length() && r2.regionMatches(0, format, i, r2.length()) && stringBuffer.toString().regionMatches(0, str, i, r2.length()) && "000".regionMatches(0, format2, i, "000".length())) {
                    return i;
                }
                return -1;
            }
            i++;
        }
        return -2;
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(date.getTime(), stringBuffer);
        return stringBuffer;
    }

    public StringBuffer format(long j, StringBuffer stringBuffer) {
        if (j == this.previousTime) {
            stringBuffer.append(this.cache);
        } else if (this.millisecondStart == -1 || j >= this.slotBegin + ((long) this.expiration) || j < this.slotBegin || j >= this.slotBegin + 1000) {
            this.cache.setLength(0);
            this.tmpDate.setTime(j);
            this.cache.append(this.formatter.format(this.tmpDate));
            stringBuffer.append(this.cache);
            this.previousTime = j;
            this.slotBegin = (this.previousTime / 1000) * 1000;
            if (this.slotBegin > this.previousTime) {
                this.slotBegin -= 1000;
            }
            if (this.millisecondStart >= 0) {
                this.millisecondStart = findMillisecondStart(j, this.cache.toString(), this.formatter);
            }
        } else {
            if (this.millisecondStart >= 0) {
                millisecondFormat((int) (j - this.slotBegin), this.cache, this.millisecondStart);
            }
            this.previousTime = j;
            stringBuffer.append(this.cache);
        }
        return stringBuffer;
    }

    private static void millisecondFormat(int i, StringBuffer stringBuffer, int i2) {
        stringBuffer.setCharAt(i2, DIGITS.charAt(i / 100));
        stringBuffer.setCharAt(i2 + 1, DIGITS.charAt((i / 10) % 10));
        stringBuffer.setCharAt(i2 + 2, DIGITS.charAt(i % 10));
    }

    public void setTimeZone(TimeZone timeZone) {
        this.formatter.setTimeZone(timeZone);
        this.previousTime = Long.MIN_VALUE;
        this.slotBegin = Long.MIN_VALUE;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return this.formatter.parse(str, parsePosition);
    }

    public NumberFormat getNumberFormat() {
        return this.formatter.getNumberFormat();
    }

    public static int getMaximumCacheValidity(String str) {
        int indexOf = str.indexOf(83);
        if (indexOf < 0 || indexOf == str.lastIndexOf("SSS")) {
            return 1000;
        }
        return 1;
    }
}
