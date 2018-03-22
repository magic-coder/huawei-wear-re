package org.apache.log4j.pattern;

import com.snowballtech.common.code.WSBaseMessageCode;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public final class DatePatternConverter extends LoggingEventPatternConverter {
    private static final String ABSOLUTE_FORMAT = "ABSOLUTE";
    private static final String ABSOLUTE_TIME_PATTERN = "HH:mm:ss,SSS";
    private static final String DATE_AND_TIME_FORMAT = "DATE";
    private static final String DATE_AND_TIME_PATTERN = "dd MMM yyyy HH:mm:ss,SSS";
    private static final String ISO8601_FORMAT = "ISO8601";
    private static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    private final CachedDateFormat df;

    class DefaultZoneDateFormat extends DateFormat {
        private static final long serialVersionUID = 1;
        private final DateFormat dateFormat;

        public DefaultZoneDateFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            this.dateFormat.setTimeZone(TimeZone.getDefault());
            return this.dateFormat.format(date, stringBuffer, fieldPosition);
        }

        public Date parse(String str, ParsePosition parsePosition) {
            this.dateFormat.setTimeZone(TimeZone.getDefault());
            return this.dateFormat.parse(str, parsePosition);
        }
    }

    private DatePatternConverter(String[] strArr) {
        String str;
        int maximumCacheValidity;
        DateFormat dateFormat;
        super(WSBaseMessageCode.HEADER_DATE, "date");
        if (strArr == null || strArr.length == 0) {
            str = null;
        } else {
            str = strArr[0];
        }
        String str2 = (str == null || str.equalsIgnoreCase("ISO8601")) ? ISO8601_PATTERN : str.equalsIgnoreCase("ABSOLUTE") ? ABSOLUTE_TIME_PATTERN : str.equalsIgnoreCase("DATE") ? DATE_AND_TIME_PATTERN : str;
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat(str2);
            maximumCacheValidity = CachedDateFormat.getMaximumCacheValidity(str2);
            dateFormat = simpleDateFormat;
        } catch (Throwable e) {
            LogLog.warn(new StringBuffer().append("Could not instantiate SimpleDateFormat with pattern ").append(str).toString(), e);
            dateFormat = new SimpleDateFormat(ISO8601_PATTERN);
            maximumCacheValidity = 1000;
        }
        if (strArr == null || strArr.length <= 1) {
            dateFormat = new DefaultZoneDateFormat(dateFormat);
        } else {
            dateFormat.setTimeZone(TimeZone.getTimeZone(strArr[1]));
        }
        this.df = new CachedDateFormat(dateFormat, maximumCacheValidity);
    }

    public static DatePatternConverter newInstance(String[] strArr) {
        return new DatePatternConverter(strArr);
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        synchronized (this) {
            this.df.format(loggingEvent.timeStamp, stringBuffer);
        }
    }

    public void format(Object obj, StringBuffer stringBuffer) {
        if (obj instanceof Date) {
            format((Date) obj, stringBuffer);
        }
        super.format(obj, stringBuffer);
    }

    public void format(Date date, StringBuffer stringBuffer) {
        synchronized (this) {
            this.df.format(date.getTime(), stringBuffer);
        }
    }
}
