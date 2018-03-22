package org.apache.log4j.pattern;

import java.util.Date;

public final class IntegerPatternConverter extends PatternConverter {
    private static final IntegerPatternConverter INSTANCE = new IntegerPatternConverter();

    private IntegerPatternConverter() {
        super("Integer", "integer");
    }

    public static IntegerPatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    public void format(Object obj, StringBuffer stringBuffer) {
        if (obj instanceof Integer) {
            stringBuffer.append(obj.toString());
        }
        if (obj instanceof Date) {
            stringBuffer.append(Long.toString(((Date) obj).getTime()));
        }
    }
}
