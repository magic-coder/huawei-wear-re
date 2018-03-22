package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

public class SequenceNumberPatternConverter extends LoggingEventPatternConverter {
    private static final SequenceNumberPatternConverter INSTANCE = new SequenceNumberPatternConverter();

    private SequenceNumberPatternConverter() {
        super("Sequence Number", "sn");
    }

    public static SequenceNumberPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        stringBuffer.append("0");
    }
}
