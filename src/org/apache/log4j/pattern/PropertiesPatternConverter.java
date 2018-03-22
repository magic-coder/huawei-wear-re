package org.apache.log4j.pattern;

import java.util.Set;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.MDCKeySetExtractor;
import org.apache.log4j.spi.LoggingEvent;

public final class PropertiesPatternConverter extends LoggingEventPatternConverter {
    private final String option;

    private PropertiesPatternConverter(String[] strArr) {
        String stringBuffer = (strArr == null || strArr.length <= 0) ? "Properties" : new StringBuffer().append("Property{").append(strArr[0]).append("}").toString();
        super(stringBuffer, "property");
        if (strArr == null || strArr.length <= 0) {
            this.option = null;
        } else {
            this.option = strArr[0];
        }
    }

    public static PropertiesPatternConverter newInstance(String[] strArr) {
        return new PropertiesPatternConverter(strArr);
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        if (this.option == null) {
            stringBuffer.append("{");
            try {
                Set propertyKeySet = MDCKeySetExtractor.INSTANCE.getPropertyKeySet(loggingEvent);
                if (propertyKeySet != null) {
                    for (Object next : propertyKeySet) {
                        stringBuffer.append("{").append(next).append(",").append(loggingEvent.getMDC(next.toString())).append("}");
                    }
                }
            } catch (Throwable e) {
                LogLog.error("Unexpected exception while extracting MDC keys", e);
            }
            stringBuffer.append("}");
            return;
        }
        Object mdc = loggingEvent.getMDC(this.option);
        if (mdc != null) {
            stringBuffer.append(mdc);
        }
    }
}
