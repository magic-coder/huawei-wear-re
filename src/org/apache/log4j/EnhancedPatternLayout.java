package org.apache.log4j;

import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.pattern.BridgePatternConverter;
import org.apache.log4j.pattern.BridgePatternParser;
import org.apache.log4j.spi.LoggingEvent;

public class EnhancedPatternLayout extends Layout {
    public static final String DEFAULT_CONVERSION_PATTERN = "%m%n";
    public static final String PATTERN_RULE_REGISTRY = "PATTERN_RULE_REGISTRY";
    public static final String TTCC_CONVERSION_PATTERN = "%r [%t] %p %c %x - %m%n";
    protected final int BUF_SIZE;
    protected final int MAX_CAPACITY;
    private String conversionPattern;
    private boolean handlesExceptions;
    private PatternConverter head;

    public EnhancedPatternLayout() {
        this("%m%n");
    }

    public EnhancedPatternLayout(String str) {
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.conversionPattern = str;
        if (str == null) {
            str = "%m%n";
        }
        this.head = createPatternParser(str).parse();
        if (this.head instanceof BridgePatternConverter) {
            boolean z;
            if (((BridgePatternConverter) this.head).ignoresThrowable()) {
                z = false;
            } else {
                z = true;
            }
            this.handlesExceptions = z;
            return;
        }
        this.handlesExceptions = false;
    }

    public void setConversionPattern(String str) {
        this.conversionPattern = OptionConverter.convertSpecialChars(str);
        this.head = createPatternParser(this.conversionPattern).parse();
        if (this.head instanceof BridgePatternConverter) {
            boolean z;
            if (((BridgePatternConverter) this.head).ignoresThrowable()) {
                z = false;
            } else {
                z = true;
            }
            this.handlesExceptions = z;
            return;
        }
        this.handlesExceptions = false;
    }

    public String getConversionPattern() {
        return this.conversionPattern;
    }

    protected PatternParser createPatternParser(String str) {
        return new BridgePatternParser(str);
    }

    public void activateOptions() {
    }

    public String format(LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        for (PatternConverter patternConverter = this.head; patternConverter != null; patternConverter = patternConverter.next) {
            patternConverter.format(stringBuffer, loggingEvent);
        }
        return stringBuffer.toString();
    }

    public boolean ignoresThrowable() {
        return !this.handlesExceptions;
    }
}
