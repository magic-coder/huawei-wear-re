package org.apache.log4j.pattern;

import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

public final class LevelPatternConverter extends LoggingEventPatternConverter {
    private static final LevelPatternConverter INSTANCE = new LevelPatternConverter();
    private static final int TRACE_INT = 5000;

    private LevelPatternConverter() {
        super("Level", "level");
    }

    public static LevelPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        stringBuffer.append(loggingEvent.getLevel().toString());
    }

    public String getStyleClass(Object obj) {
        if (!(obj instanceof LoggingEvent)) {
            return "level";
        }
        switch (((LoggingEvent) obj).getLevel().toInt()) {
            case 5000:
                return "level trace";
            case 10000:
                return "level debug";
            case 20000:
                return "level info";
            case 30000:
                return "level warn";
            case Priority.ERROR_INT /*40000*/:
                return "level error";
            case 50000:
                return "level fatal";
            default:
                return new StringBuffer().append("level ").append(((LoggingEvent) obj).getLevel().toString()).toString();
        }
    }
}
