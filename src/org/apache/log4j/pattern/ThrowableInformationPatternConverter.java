package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

public class ThrowableInformationPatternConverter extends LoggingEventPatternConverter {
    private int maxLines = Integer.MAX_VALUE;

    private ThrowableInformationPatternConverter(String[] strArr) {
        super("Throwable", "throwable");
        if (strArr != null && strArr.length > 0) {
            if ("none".equals(strArr[0])) {
                this.maxLines = 0;
            } else if ("short".equals(strArr[0])) {
                this.maxLines = 1;
            } else {
                try {
                    this.maxLines = Integer.parseInt(strArr[0]);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    public static ThrowableInformationPatternConverter newInstance(String[] strArr) {
        return new ThrowableInformationPatternConverter(strArr);
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        if (this.maxLines != 0) {
            ThrowableInformation throwableInformation = loggingEvent.getThrowableInformation();
            if (throwableInformation != null) {
                String[] throwableStrRep = throwableInformation.getThrowableStrRep();
                int length = throwableStrRep.length;
                if (this.maxLines < 0) {
                    length += this.maxLines;
                } else if (length > this.maxLines) {
                    length = this.maxLines;
                }
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(throwableStrRep[i]).append("\n");
                }
            }
        }
    }

    public boolean handlesThrowable() {
        return true;
    }
}
