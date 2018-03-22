package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;

public final class LiteralPatternConverter extends LoggingEventPatternConverter {
    private final String literal;

    public LiteralPatternConverter(String str) {
        super("Literal", "literal");
        this.literal = str;
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        stringBuffer.append(this.literal);
    }

    public void format(Object obj, StringBuffer stringBuffer) {
        stringBuffer.append(this.literal);
    }
}
