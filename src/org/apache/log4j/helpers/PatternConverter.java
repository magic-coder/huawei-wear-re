package org.apache.log4j.helpers;

import com.huawei.hwid.core.constants.HwAccountConstants;
import org.apache.log4j.spi.LoggingEvent;

public abstract class PatternConverter {
    static String[] SPACES = new String[]{HwAccountConstants.BLANK, "  ", "    ", "        ", "                ", "                                "};
    boolean leftAlign = false;
    int max = Integer.MAX_VALUE;
    int min = -1;
    public PatternConverter next;

    protected abstract String convert(LoggingEvent loggingEvent);

    protected PatternConverter() {
    }

    protected PatternConverter(FormattingInfo formattingInfo) {
        this.min = formattingInfo.min;
        this.max = formattingInfo.max;
        this.leftAlign = formattingInfo.leftAlign;
    }

    public void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        String convert = convert(loggingEvent);
        if (convert != null) {
            int length = convert.length();
            if (length > this.max) {
                stringBuffer.append(convert.substring(length - this.max));
            } else if (length >= this.min) {
                stringBuffer.append(convert);
            } else if (this.leftAlign) {
                stringBuffer.append(convert);
                spacePad(stringBuffer, this.min - length);
            } else {
                spacePad(stringBuffer, this.min - length);
                stringBuffer.append(convert);
            }
        } else if (this.min > 0) {
            spacePad(stringBuffer, this.min);
        }
    }

    public void spacePad(StringBuffer stringBuffer, int i) {
        while (i >= 32) {
            stringBuffer.append(SPACES[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                stringBuffer.append(SPACES[i2]);
            }
        }
    }
}
