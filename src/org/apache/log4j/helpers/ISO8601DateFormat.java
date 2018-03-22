package org.apache.log4j.helpers;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

public class ISO8601DateFormat extends AbsoluteTimeDateFormat {
    private static long lastTime = 0;
    private static char[] lastTimeString = new char[20];
    private static final long serialVersionUID = -759840745298755296L;

    public ISO8601DateFormat(TimeZone timeZone) {
        super(timeZone);
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        long time = date.getTime();
        int i = (int) (time % 1000);
        if (time - ((long) i) != lastTime || lastTimeString[0] == '\u0000') {
            String str;
            this.calendar.setTime(date);
            int length = stringBuffer.length();
            stringBuffer.append(this.calendar.get(1));
            switch (this.calendar.get(2)) {
                case 0:
                    str = "-01-";
                    break;
                case 1:
                    str = "-02-";
                    break;
                case 2:
                    str = "-03-";
                    break;
                case 3:
                    str = "-04-";
                    break;
                case 4:
                    str = "-05-";
                    break;
                case 5:
                    str = "-06-";
                    break;
                case 6:
                    str = "-07-";
                    break;
                case 7:
                    str = "-08-";
                    break;
                case 8:
                    str = "-09-";
                    break;
                case 9:
                    str = "-10-";
                    break;
                case 10:
                    str = "-11-";
                    break;
                case 11:
                    str = "-12-";
                    break;
                default:
                    str = "-NA-";
                    break;
            }
            stringBuffer.append(str);
            int i2 = this.calendar.get(5);
            if (i2 < 10) {
                stringBuffer.append('0');
            }
            stringBuffer.append(i2);
            stringBuffer.append(' ');
            i2 = this.calendar.get(11);
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
            stringBuffer.getChars(length, stringBuffer.length(), lastTimeString, 0);
            lastTime = time - ((long) i);
        } else {
            stringBuffer.append(lastTimeString);
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
