package org.apache.log4j.helpers;

import com.huawei.crowdtestsdk.common.SpecialIssueType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

public class PatternParser {
    static final int CLASS_LOCATION_CONVERTER = 1002;
    private static final int CONVERTER_STATE = 1;
    private static final int DOT_STATE = 3;
    private static final char ESCAPE_CHAR = '%';
    static final int FILE_LOCATION_CONVERTER = 1004;
    static final int FULL_LOCATION_CONVERTER = 1000;
    static final int LEVEL_CONVERTER = 2002;
    static final int LINE_LOCATION_CONVERTER = 1003;
    private static final int LITERAL_STATE = 0;
    private static final int MAX_STATE = 5;
    static final int MESSAGE_CONVERTER = 2004;
    static final int METHOD_LOCATION_CONVERTER = 1001;
    private static final int MIN_STATE = 4;
    static final int NDC_CONVERTER = 2003;
    static final int RELATIVE_TIME_CONVERTER = 2000;
    static final int THREAD_CONVERTER = 2001;
    static Class class$java$text$DateFormat;
    protected StringBuffer currentLiteral = new StringBuffer(32);
    protected FormattingInfo formattingInfo = new FormattingInfo();
    PatternConverter head;
    protected int f9184i;
    protected String pattern;
    protected int patternLength;
    int state;
    PatternConverter tail;

    class BasicPatternConverter extends PatternConverter {
        int type;

        BasicPatternConverter(FormattingInfo formattingInfo, int i) {
            super(formattingInfo);
            this.type = i;
        }

        public String convert(LoggingEvent loggingEvent) {
            switch (this.type) {
                case 2000:
                    return Long.toString(loggingEvent.timeStamp - LoggingEvent.getStartTime());
                case 2001:
                    return loggingEvent.getThreadName();
                case 2002:
                    return loggingEvent.getLevel().toString();
                case 2003:
                    return loggingEvent.getNDC();
                case 2004:
                    return loggingEvent.getRenderedMessage();
                default:
                    return null;
            }
        }
    }

    abstract class NamedPatternConverter extends PatternConverter {
        int precision;

        abstract String getFullyQualifiedName(LoggingEvent loggingEvent);

        NamedPatternConverter(FormattingInfo formattingInfo, int i) {
            super(formattingInfo);
            this.precision = i;
        }

        public String convert(LoggingEvent loggingEvent) {
            String fullyQualifiedName = getFullyQualifiedName(loggingEvent);
            if (this.precision <= 0) {
                return fullyQualifiedName;
            }
            int length = fullyQualifiedName.length();
            int i = length - 1;
            for (int i2 = this.precision; i2 > 0; i2--) {
                i = fullyQualifiedName.lastIndexOf(46, i - 1);
                if (i == -1) {
                    return fullyQualifiedName;
                }
            }
            return fullyQualifiedName.substring(i + 1, length);
        }
    }

    class CategoryPatternConverter extends NamedPatternConverter {
        private final PatternParser this$0;

        CategoryPatternConverter(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            this.this$0 = patternParser;
            super(formattingInfo, i);
        }

        String getFullyQualifiedName(LoggingEvent loggingEvent) {
            return loggingEvent.getLoggerName();
        }
    }

    class ClassNamePatternConverter extends NamedPatternConverter {
        private final PatternParser this$0;

        ClassNamePatternConverter(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            this.this$0 = patternParser;
            super(formattingInfo, i);
        }

        String getFullyQualifiedName(LoggingEvent loggingEvent) {
            return loggingEvent.getLocationInformation().getClassName();
        }
    }

    class DatePatternConverter extends PatternConverter {
        private Date date = new Date();
        private DateFormat df;

        DatePatternConverter(FormattingInfo formattingInfo, DateFormat dateFormat) {
            super(formattingInfo);
            this.df = dateFormat;
        }

        public String convert(LoggingEvent loggingEvent) {
            this.date.setTime(loggingEvent.timeStamp);
            String str = null;
            try {
                str = this.df.format(this.date);
            } catch (Throwable e) {
                LogLog.error("Error occured while converting date.", e);
            }
            return str;
        }
    }

    class LiteralPatternConverter extends PatternConverter {
        private String literal;

        LiteralPatternConverter(String str) {
            this.literal = str;
        }

        public final void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
            stringBuffer.append(this.literal);
        }

        public String convert(LoggingEvent loggingEvent) {
            return this.literal;
        }
    }

    class LocationPatternConverter extends PatternConverter {
        private final PatternParser this$0;
        int type;

        LocationPatternConverter(PatternParser patternParser, FormattingInfo formattingInfo, int i) {
            this.this$0 = patternParser;
            super(formattingInfo);
            this.type = i;
        }

        public String convert(LoggingEvent loggingEvent) {
            LocationInfo locationInformation = loggingEvent.getLocationInformation();
            switch (this.type) {
                case 1000:
                    return locationInformation.fullInfo;
                case 1001:
                    return locationInformation.getMethodName();
                case 1003:
                    return locationInformation.getLineNumber();
                case 1004:
                    return locationInformation.getFileName();
                default:
                    return null;
            }
        }
    }

    class MDCPatternConverter extends PatternConverter {
        private String key;

        MDCPatternConverter(FormattingInfo formattingInfo, String str) {
            super(formattingInfo);
            this.key = str;
        }

        public String convert(LoggingEvent loggingEvent) {
            if (this.key == null) {
                StringBuffer stringBuffer = new StringBuffer("{");
                Map properties = loggingEvent.getProperties();
                if (properties.size() > 0) {
                    Object[] toArray = properties.keySet().toArray();
                    Arrays.sort(toArray);
                    for (int i = 0; i < toArray.length; i++) {
                        stringBuffer.append('{');
                        stringBuffer.append(toArray[i]);
                        stringBuffer.append(',');
                        stringBuffer.append(properties.get(toArray[i]));
                        stringBuffer.append('}');
                    }
                }
                stringBuffer.append('}');
                return stringBuffer.toString();
            }
            Object mdc = loggingEvent.getMDC(this.key);
            if (mdc == null) {
                return null;
            }
            return mdc.toString();
        }
    }

    public PatternParser(String str) {
        this.pattern = str;
        this.patternLength = str.length();
        this.state = 0;
    }

    private void addToList(PatternConverter patternConverter) {
        if (this.head == null) {
            this.tail = patternConverter;
            this.head = patternConverter;
            return;
        }
        this.tail.next = patternConverter;
        this.tail = patternConverter;
    }

    protected String extractOption() {
        if (this.f9184i < this.patternLength && this.pattern.charAt(this.f9184i) == '{') {
            int indexOf = this.pattern.indexOf(125, this.f9184i);
            if (indexOf > this.f9184i) {
                String substring = this.pattern.substring(this.f9184i + 1, indexOf);
                this.f9184i = indexOf + 1;
                return substring;
            }
        }
        return null;
    }

    protected int extractPrecisionOption() {
        Throwable th;
        int i = 0;
        String extractOption = extractOption();
        if (extractOption == null) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(extractOption);
            if (parseInt > 0) {
                return parseInt;
            }
            try {
                LogLog.error(new StringBuffer().append("Precision option (").append(extractOption).append(") isn't a positive integer.").toString());
                return 0;
            } catch (Throwable e) {
                Throwable th2 = e;
                i = parseInt;
                th = th2;
            }
        } catch (NumberFormatException e2) {
            th = e2;
            LogLog.error(new StringBuffer().append("Category option \"").append(extractOption).append("\" not a decimal integer.").toString(), th);
            return i;
        }
    }

    public PatternConverter parse() {
        this.f9184i = 0;
        while (this.f9184i < this.patternLength) {
            String str = this.pattern;
            int i = this.f9184i;
            this.f9184i = i + 1;
            char charAt = str.charAt(i);
            switch (this.state) {
                case 0:
                    if (this.f9184i != this.patternLength) {
                        if (charAt != ESCAPE_CHAR) {
                            this.currentLiteral.append(charAt);
                            break;
                        }
                        switch (this.pattern.charAt(this.f9184i)) {
                            case '%':
                                this.currentLiteral.append(charAt);
                                this.f9184i++;
                                break;
                            case 'n':
                                this.currentLiteral.append(Layout.LINE_SEP);
                                this.f9184i++;
                                break;
                            default:
                                if (this.currentLiteral.length() != 0) {
                                    addToList(new LiteralPatternConverter(this.currentLiteral.toString()));
                                }
                                this.currentLiteral.setLength(0);
                                this.currentLiteral.append(charAt);
                                this.state = 1;
                                this.formattingInfo.reset();
                                break;
                        }
                    }
                    this.currentLiteral.append(charAt);
                    break;
                case 1:
                    this.currentLiteral.append(charAt);
                    switch (charAt) {
                        case '-':
                            this.formattingInfo.leftAlign = true;
                            break;
                        case '.':
                            this.state = 3;
                            break;
                        default:
                            if (charAt >= '0' && charAt <= '9') {
                                this.formattingInfo.min = charAt - 48;
                                this.state = 4;
                                break;
                            }
                            finalizeConverter(charAt);
                            break;
                    }
                case 3:
                    this.currentLiteral.append(charAt);
                    if (charAt >= '0' && charAt <= '9') {
                        this.formattingInfo.max = charAt - 48;
                        this.state = 5;
                        break;
                    }
                    LogLog.error(new StringBuffer().append("Error occured in position ").append(this.f9184i).append(".\n Was expecting digit, instead got char \"").append(charAt).append("\".").toString());
                    this.state = 0;
                    break;
                    break;
                case 4:
                    this.currentLiteral.append(charAt);
                    if (charAt < '0' || charAt > '9') {
                        if (charAt != '.') {
                            finalizeConverter(charAt);
                            break;
                        }
                        this.state = 3;
                        break;
                    }
                    this.formattingInfo.min = (charAt - 48) + (this.formattingInfo.min * 10);
                    break;
                case 5:
                    this.currentLiteral.append(charAt);
                    if (charAt >= '0' && charAt <= '9') {
                        this.formattingInfo.max = (charAt - 48) + (this.formattingInfo.max * 10);
                        break;
                    }
                    finalizeConverter(charAt);
                    this.state = 0;
                    break;
                    break;
                default:
                    break;
            }
        }
        if (this.currentLiteral.length() != 0) {
            addToList(new LiteralPatternConverter(this.currentLiteral.toString()));
        }
        return this.head;
    }

    protected void finalizeConverter(char c) {
        PatternConverter classNamePatternConverter;
        Class class$;
        switch (c) {
            case 'C':
                classNamePatternConverter = new ClassNamePatternConverter(this, this.formattingInfo, extractPrecisionOption());
                this.currentLiteral.setLength(0);
                break;
            case 'F':
                classNamePatternConverter = new LocationPatternConverter(this, this.formattingInfo, 1004);
                this.currentLiteral.setLength(0);
                break;
            case 'L':
                classNamePatternConverter = new LocationPatternConverter(this, this.formattingInfo, 1003);
                this.currentLiteral.setLength(0);
                break;
            case 'M':
                classNamePatternConverter = new LocationPatternConverter(this, this.formattingInfo, 1001);
                this.currentLiteral.setLength(0);
                break;
            case 'X':
                classNamePatternConverter = new MDCPatternConverter(this.formattingInfo, extractOption());
                this.currentLiteral.setLength(0);
                break;
            case 'c':
                classNamePatternConverter = new CategoryPatternConverter(this, this.formattingInfo, extractPrecisionOption());
                this.currentLiteral.setLength(0);
                break;
            case 'd':
                DateFormat iSO8601DateFormat;
                String str = AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT;
                String extractOption = extractOption();
                if (extractOption == null) {
                    extractOption = str;
                }
                if (extractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.ISO8601_DATE_FORMAT)) {
                    iSO8601DateFormat = new ISO8601DateFormat();
                } else if (extractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.ABS_TIME_DATE_FORMAT)) {
                    iSO8601DateFormat = new AbsoluteTimeDateFormat();
                } else if (extractOption.equalsIgnoreCase(AbsoluteTimeDateFormat.DATE_AND_TIME_DATE_FORMAT)) {
                    iSO8601DateFormat = new DateTimeDateFormat();
                } else {
                    try {
                        iSO8601DateFormat = new SimpleDateFormat(extractOption);
                    } catch (Throwable e) {
                        LogLog.error(new StringBuffer().append("Could not instantiate SimpleDateFormat with ").append(extractOption).toString(), e);
                        str = "org.apache.log4j.helpers.ISO8601DateFormat";
                        if (class$java$text$DateFormat == null) {
                            class$ = class$("java.text.DateFormat");
                            class$java$text$DateFormat = class$;
                        } else {
                            class$ = class$java$text$DateFormat;
                        }
                        iSO8601DateFormat = (DateFormat) OptionConverter.instantiateByClassName(str, class$, null);
                    }
                }
                PatternConverter datePatternConverter = new DatePatternConverter(this.formattingInfo, iSO8601DateFormat);
                this.currentLiteral.setLength(0);
                classNamePatternConverter = datePatternConverter;
                break;
            case 'l':
                classNamePatternConverter = new LocationPatternConverter(this, this.formattingInfo, 1000);
                this.currentLiteral.setLength(0);
                break;
            case 'm':
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, 2004);
                this.currentLiteral.setLength(0);
                break;
            case 'p':
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, 2002);
                this.currentLiteral.setLength(0);
                break;
            case 'r':
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, 2000);
                this.currentLiteral.setLength(0);
                break;
            case SpecialIssueType.BUG_TYPE_ID_CHARGE /*116*/:
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, 2001);
                this.currentLiteral.setLength(0);
                break;
            case 'x':
                classNamePatternConverter = new BasicPatternConverter(this.formattingInfo, 2003);
                this.currentLiteral.setLength(0);
                break;
            default:
                LogLog.error(new StringBuffer().append("Unexpected char [").append(c).append("] at position ").append(this.f9184i).append(" in conversion patterrn.").toString());
                classNamePatternConverter = new LiteralPatternConverter(this.currentLiteral.toString());
                this.currentLiteral.setLength(0);
                break;
        }
        addConverter(classNamePatternConverter);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected void addConverter(PatternConverter patternConverter) {
        this.currentLiteral.setLength(0);
        addToList(patternConverter);
        this.state = 0;
        this.formattingInfo.reset();
    }
}
