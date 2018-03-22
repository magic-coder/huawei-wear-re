package org.apache.log4j.pattern;

import com.unionpay.tsmservice.data.Constant;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

public final class MethodLocationPatternConverter extends LoggingEventPatternConverter {
    private static final MethodLocationPatternConverter INSTANCE = new MethodLocationPatternConverter();

    private MethodLocationPatternConverter() {
        super("Method", Constant.KEY_METHOD);
    }

    public static MethodLocationPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        if (locationInformation != null) {
            stringBuffer.append(locationInformation.getMethodName());
        }
    }
}
