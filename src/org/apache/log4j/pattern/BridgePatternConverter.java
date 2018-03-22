package org.apache.log4j.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.spi.LoggingEvent;

public final class BridgePatternConverter extends PatternConverter {
    private boolean handlesExceptions;
    private LoggingEventPatternConverter[] patternConverters;
    private FormattingInfo[] patternFields;

    public BridgePatternConverter(String str) {
        this.next = null;
        this.handlesExceptions = false;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        PatternParser.parse(str, arrayList, arrayList2, null, PatternParser.getPatternLayoutRules());
        this.patternConverters = new LoggingEventPatternConverter[arrayList.size()];
        this.patternFields = new FormattingInfo[arrayList.size()];
        Iterator it = arrayList2.iterator();
        int i = 0;
        for (Object next : arrayList) {
            if (next instanceof LoggingEventPatternConverter) {
                this.patternConverters[i] = (LoggingEventPatternConverter) next;
                this.handlesExceptions |= this.patternConverters[i].handlesThrowable();
            } else {
                this.patternConverters[i] = new LiteralPatternConverter("");
            }
            if (it.hasNext()) {
                this.patternFields[i] = (FormattingInfo) it.next();
            } else {
                this.patternFields[i] = FormattingInfo.getDefault();
            }
            i++;
        }
    }

    protected String convert(LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        format(stringBuffer, loggingEvent);
        return stringBuffer.toString();
    }

    public void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        for (int i = 0; i < this.patternConverters.length; i++) {
            int length = stringBuffer.length();
            this.patternConverters[i].format(loggingEvent, stringBuffer);
            this.patternFields[i].format(length, stringBuffer);
        }
    }

    public boolean ignoresThrowable() {
        return !this.handlesExceptions;
    }
}
