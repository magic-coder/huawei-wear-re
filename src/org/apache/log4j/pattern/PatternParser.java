package org.apache.log4j.pattern;

import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.huawei.ui.main.stories.nps.interactors.mode.TypeParams;
import com.sina.weibo.sdk.constant.WBConstants;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;

public final class PatternParser {
    private static final int CONVERTER_STATE = 1;
    private static final int DOT_STATE = 3;
    private static final char ESCAPE_CHAR = '%';
    private static final Map FILENAME_PATTERN_RULES;
    private static final int LITERAL_STATE = 0;
    private static final int MAX_STATE = 5;
    private static final int MIN_STATE = 4;
    private static final Map PATTERN_LAYOUT_RULES;
    static Class class$org$apache$log4j$pattern$ClassNamePatternConverter;
    static Class class$org$apache$log4j$pattern$DatePatternConverter;
    static Class class$org$apache$log4j$pattern$FileDatePatternConverter;
    static Class class$org$apache$log4j$pattern$FileLocationPatternConverter;
    static Class class$org$apache$log4j$pattern$FullLocationPatternConverter;
    static Class class$org$apache$log4j$pattern$IntegerPatternConverter;
    static Class class$org$apache$log4j$pattern$LevelPatternConverter;
    static Class class$org$apache$log4j$pattern$LineLocationPatternConverter;
    static Class class$org$apache$log4j$pattern$LineSeparatorPatternConverter;
    static Class class$org$apache$log4j$pattern$LoggerPatternConverter;
    static Class class$org$apache$log4j$pattern$MessagePatternConverter;
    static Class class$org$apache$log4j$pattern$MethodLocationPatternConverter;
    static Class class$org$apache$log4j$pattern$NDCPatternConverter;
    static Class class$org$apache$log4j$pattern$PropertiesPatternConverter;
    static Class class$org$apache$log4j$pattern$RelativeTimePatternConverter;
    static Class class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
    static Class class$org$apache$log4j$pattern$ThreadPatternConverter;
    static Class f9185x905a6f24;

    class ReadOnlyMap implements Map {
        private final Map map;

        public ReadOnlyMap(Map map) {
            this.map = map;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public Set entrySet() {
            return this.map.entrySet();
        }

        public Object get(Object obj) {
            return this.map.get(obj);
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public Set keySet() {
            return this.map.keySet();
        }

        public Object put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map map) {
            throw new UnsupportedOperationException();
        }

        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.map.size();
        }

        public Collection values() {
            return this.map.values();
        }
    }

    static {
        Object class$;
        Map hashMap = new HashMap(17);
        String str = "c";
        if (class$org$apache$log4j$pattern$LoggerPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LoggerPatternConverter");
            class$org$apache$log4j$pattern$LoggerPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LoggerPatternConverter;
        }
        hashMap.put(str, class$);
        str = "logger";
        if (class$org$apache$log4j$pattern$LoggerPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LoggerPatternConverter");
            class$org$apache$log4j$pattern$LoggerPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LoggerPatternConverter;
        }
        hashMap.put(str, class$);
        str = TypeParams.SEARCH_CODE;
        if (class$org$apache$log4j$pattern$ClassNamePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.ClassNamePatternConverter");
            class$org$apache$log4j$pattern$ClassNamePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$ClassNamePatternConverter;
        }
        hashMap.put(str, class$);
        str = "class";
        if (class$org$apache$log4j$pattern$ClassNamePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.ClassNamePatternConverter");
            class$org$apache$log4j$pattern$ClassNamePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$ClassNamePatternConverter;
        }
        hashMap.put(str, class$);
        str = "d";
        if (class$org$apache$log4j$pattern$DatePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.DatePatternConverter");
            class$org$apache$log4j$pattern$DatePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$DatePatternConverter;
        }
        hashMap.put(str, class$);
        str = "date";
        if (class$org$apache$log4j$pattern$DatePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.DatePatternConverter");
            class$org$apache$log4j$pattern$DatePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$DatePatternConverter;
        }
        hashMap.put(str, class$);
        str = "F";
        if (class$org$apache$log4j$pattern$FileLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.FileLocationPatternConverter");
            class$org$apache$log4j$pattern$FileLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$FileLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "file";
        if (class$org$apache$log4j$pattern$FileLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.FileLocationPatternConverter");
            class$org$apache$log4j$pattern$FileLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$FileLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "l";
        if (class$org$apache$log4j$pattern$FullLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.FullLocationPatternConverter");
            class$org$apache$log4j$pattern$FullLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$FullLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "L";
        if (class$org$apache$log4j$pattern$LineLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LineLocationPatternConverter");
            class$org$apache$log4j$pattern$LineLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LineLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "line";
        if (class$org$apache$log4j$pattern$LineLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LineLocationPatternConverter");
            class$org$apache$log4j$pattern$LineLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LineLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "m";
        if (class$org$apache$log4j$pattern$MessagePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.MessagePatternConverter");
            class$org$apache$log4j$pattern$MessagePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$MessagePatternConverter;
        }
        hashMap.put(str, class$);
        str = WBConstants.ACTION_LOG_TYPE_MESSAGE;
        if (class$org$apache$log4j$pattern$MessagePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.MessagePatternConverter");
            class$org$apache$log4j$pattern$MessagePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$MessagePatternConverter;
        }
        hashMap.put(str, class$);
        str = "n";
        if (class$org$apache$log4j$pattern$LineSeparatorPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LineSeparatorPatternConverter");
            class$org$apache$log4j$pattern$LineSeparatorPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LineSeparatorPatternConverter;
        }
        hashMap.put(str, class$);
        str = TypeParams.QUESTION_CHOOSE_MULTI;
        if (class$org$apache$log4j$pattern$MethodLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.MethodLocationPatternConverter");
            class$org$apache$log4j$pattern$MethodLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$MethodLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = Constant.KEY_METHOD;
        if (class$org$apache$log4j$pattern$MethodLocationPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.MethodLocationPatternConverter");
            class$org$apache$log4j$pattern$MethodLocationPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$MethodLocationPatternConverter;
        }
        hashMap.put(str, class$);
        str = "p";
        if (class$org$apache$log4j$pattern$LevelPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LevelPatternConverter");
            class$org$apache$log4j$pattern$LevelPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LevelPatternConverter;
        }
        hashMap.put(str, class$);
        str = "level";
        if (class$org$apache$log4j$pattern$LevelPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.LevelPatternConverter");
            class$org$apache$log4j$pattern$LevelPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$LevelPatternConverter;
        }
        hashMap.put(str, class$);
        str = "r";
        if (class$org$apache$log4j$pattern$RelativeTimePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.RelativeTimePatternConverter");
            class$org$apache$log4j$pattern$RelativeTimePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$RelativeTimePatternConverter;
        }
        hashMap.put(str, class$);
        str = "relative";
        if (class$org$apache$log4j$pattern$RelativeTimePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.RelativeTimePatternConverter");
            class$org$apache$log4j$pattern$RelativeTimePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$RelativeTimePatternConverter;
        }
        hashMap.put(str, class$);
        str = "t";
        if (class$org$apache$log4j$pattern$ThreadPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.ThreadPatternConverter");
            class$org$apache$log4j$pattern$ThreadPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$ThreadPatternConverter;
        }
        hashMap.put(str, class$);
        str = "thread";
        if (class$org$apache$log4j$pattern$ThreadPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.ThreadPatternConverter");
            class$org$apache$log4j$pattern$ThreadPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$ThreadPatternConverter;
        }
        hashMap.put(str, class$);
        str = "x";
        if (class$org$apache$log4j$pattern$NDCPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.NDCPatternConverter");
            class$org$apache$log4j$pattern$NDCPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$NDCPatternConverter;
        }
        hashMap.put(str, class$);
        str = "ndc";
        if (class$org$apache$log4j$pattern$NDCPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.NDCPatternConverter");
            class$org$apache$log4j$pattern$NDCPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$NDCPatternConverter;
        }
        hashMap.put(str, class$);
        str = "X";
        if (class$org$apache$log4j$pattern$PropertiesPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.PropertiesPatternConverter");
            class$org$apache$log4j$pattern$PropertiesPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$PropertiesPatternConverter;
        }
        hashMap.put(str, class$);
        str = "properties";
        if (class$org$apache$log4j$pattern$PropertiesPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.PropertiesPatternConverter");
            class$org$apache$log4j$pattern$PropertiesPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$PropertiesPatternConverter;
        }
        hashMap.put(str, class$);
        str = "sn";
        if (class$org$apache$log4j$pattern$SequenceNumberPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.SequenceNumberPatternConverter");
            class$org$apache$log4j$pattern$SequenceNumberPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
        }
        hashMap.put(str, class$);
        str = "sequenceNumber";
        if (class$org$apache$log4j$pattern$SequenceNumberPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.SequenceNumberPatternConverter");
            class$org$apache$log4j$pattern$SequenceNumberPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$SequenceNumberPatternConverter;
        }
        hashMap.put(str, class$);
        str = "throwable";
        if (f9185x905a6f24 == null) {
            class$ = class$("org.apache.log4j.pattern.ThrowableInformationPatternConverter");
            f9185x905a6f24 = class$;
        } else {
            class$ = f9185x905a6f24;
        }
        hashMap.put(str, class$);
        PATTERN_LAYOUT_RULES = new ReadOnlyMap(hashMap);
        hashMap = new HashMap(4);
        str = "d";
        if (class$org$apache$log4j$pattern$FileDatePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.FileDatePatternConverter");
            class$org$apache$log4j$pattern$FileDatePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$FileDatePatternConverter;
        }
        hashMap.put(str, class$);
        str = "date";
        if (class$org$apache$log4j$pattern$FileDatePatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.FileDatePatternConverter");
            class$org$apache$log4j$pattern$FileDatePatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$FileDatePatternConverter;
        }
        hashMap.put(str, class$);
        str = "i";
        if (class$org$apache$log4j$pattern$IntegerPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.IntegerPatternConverter");
            class$org$apache$log4j$pattern$IntegerPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$IntegerPatternConverter;
        }
        hashMap.put(str, class$);
        str = XMLNode.KEY_INDEX;
        if (class$org$apache$log4j$pattern$IntegerPatternConverter == null) {
            class$ = class$("org.apache.log4j.pattern.IntegerPatternConverter");
            class$org$apache$log4j$pattern$IntegerPatternConverter = class$;
        } else {
            class$ = class$org$apache$log4j$pattern$IntegerPatternConverter;
        }
        hashMap.put(str, class$);
        FILENAME_PATTERN_RULES = new ReadOnlyMap(hashMap);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private PatternParser() {
    }

    public static Map getPatternLayoutRules() {
        return PATTERN_LAYOUT_RULES;
    }

    public static Map getFileNamePatternRules() {
        return FILENAME_PATTERN_RULES;
    }

    private static int extractConverter(char c, String str, int i, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        stringBuffer.setLength(0);
        if (Character.isUnicodeIdentifierStart(c)) {
            stringBuffer.append(c);
            while (i < str.length() && Character.isUnicodeIdentifierPart(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
                stringBuffer2.append(str.charAt(i));
                i++;
            }
        }
        return i;
    }

    private static int extractOptions(String str, int i, List list) {
        while (i < str.length() && str.charAt(i) == '{') {
            int indexOf = str.indexOf(125, i);
            if (indexOf == -1) {
                break;
            }
            list.add(str.substring(i + 1, indexOf));
            i = indexOf + 1;
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parse(java.lang.String r10, java.util.List r11, java.util.List r12, java.util.Map r13, java.util.Map r14) {
        /*
        if (r10 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "pattern";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        r3 = new java.lang.StringBuffer;
        r0 = 32;
        r3.<init>(r0);
        r9 = r10.length();
        r5 = 0;
        r2 = 0;
        r4 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r0 = r2;
    L_0x001c:
        if (r0 >= r9) goto L_0x0176;
    L_0x001e:
        r2 = r0 + 1;
        r0 = r10.charAt(r0);
        switch(r5) {
            case 0: goto L_0x002b;
            case 1: goto L_0x006f;
            case 2: goto L_0x0027;
            case 3: goto L_0x00f6;
            case 4: goto L_0x00b6;
            case 5: goto L_0x013d;
            default: goto L_0x0027;
        };
    L_0x0027:
        r0 = r5;
    L_0x0028:
        r5 = r0;
        r0 = r2;
        goto L_0x001c;
    L_0x002b:
        if (r2 != r9) goto L_0x0032;
    L_0x002d:
        r3.append(r0);
        r0 = r2;
        goto L_0x001c;
    L_0x0032:
        r1 = 37;
        if (r0 != r1) goto L_0x006a;
    L_0x0036:
        r1 = r10.charAt(r2);
        switch(r1) {
            case 37: goto L_0x0063;
            default: goto L_0x003d;
        };
    L_0x003d:
        r1 = r3.length();
        if (r1 == 0) goto L_0x0056;
    L_0x0043:
        r1 = new org.apache.log4j.pattern.LiteralPatternConverter;
        r4 = r3.toString();
        r1.<init>(r4);
        r11.add(r1);
        r1 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r12.add(r1);
    L_0x0056:
        r1 = 0;
        r3.setLength(r1);
        r3.append(r0);
        r0 = 1;
        r4 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        goto L_0x0028;
    L_0x0063:
        r3.append(r0);
        r2 = r2 + 1;
        r0 = r5;
        goto L_0x0028;
    L_0x006a:
        r3.append(r0);
        r0 = r5;
        goto L_0x0028;
    L_0x006f:
        r3.append(r0);
        switch(r0) {
            case 45: goto L_0x008f;
            case 46: goto L_0x00a0;
            default: goto L_0x0075;
        };
    L_0x0075:
        r1 = 48;
        if (r0 < r1) goto L_0x00a2;
    L_0x0079:
        r1 = 57;
        if (r0 > r1) goto L_0x00a2;
    L_0x007d:
        r1 = new org.apache.log4j.pattern.FormattingInfo;
        r5 = r4.isLeftAligned();
        r0 = r0 + -48;
        r4 = r4.getMaxLength();
        r1.<init>(r5, r0, r4);
        r0 = 4;
        r4 = r1;
        goto L_0x0028;
    L_0x008f:
        r0 = new org.apache.log4j.pattern.FormattingInfo;
        r1 = 1;
        r6 = r4.getMinLength();
        r4 = r4.getMaxLength();
        r0.<init>(r1, r6, r4);
        r4 = r0;
        r0 = r5;
        goto L_0x0028;
    L_0x00a0:
        r0 = 3;
        goto L_0x0028;
    L_0x00a2:
        r1 = r10;
        r5 = r13;
        r6 = r14;
        r7 = r11;
        r8 = r12;
        r2 = finalizeConverter(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = 0;
        r4 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r1 = 0;
        r3.setLength(r1);
        goto L_0x0028;
    L_0x00b6:
        r3.append(r0);
        r1 = 48;
        if (r0 < r1) goto L_0x00db;
    L_0x00bd:
        r1 = 57;
        if (r0 > r1) goto L_0x00db;
    L_0x00c1:
        r1 = new org.apache.log4j.pattern.FormattingInfo;
        r6 = r4.isLeftAligned();
        r7 = r4.getMinLength();
        r7 = r7 * 10;
        r0 = r0 + -48;
        r0 = r0 + r7;
        r4 = r4.getMaxLength();
        r1.<init>(r6, r0, r4);
        r4 = r1;
        r0 = r5;
        goto L_0x0028;
    L_0x00db:
        r1 = 46;
        if (r0 != r1) goto L_0x00e2;
    L_0x00df:
        r0 = 3;
        goto L_0x0028;
    L_0x00e2:
        r1 = r10;
        r5 = r13;
        r6 = r14;
        r7 = r11;
        r8 = r12;
        r2 = finalizeConverter(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = 0;
        r4 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r1 = 0;
        r3.setLength(r1);
        goto L_0x0028;
    L_0x00f6:
        r3.append(r0);
        r1 = 48;
        if (r0 < r1) goto L_0x0114;
    L_0x00fd:
        r1 = 57;
        if (r0 > r1) goto L_0x0114;
    L_0x0101:
        r1 = new org.apache.log4j.pattern.FormattingInfo;
        r5 = r4.isLeftAligned();
        r4 = r4.getMinLength();
        r0 = r0 + -48;
        r1.<init>(r5, r4, r0);
        r0 = 5;
        r4 = r1;
        goto L_0x0028;
    L_0x0114:
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r5 = "Error occured in position ";
        r1 = r1.append(r5);
        r1 = r1.append(r2);
        r5 = ".\n Was expecting digit, instead got char \"";
        r1 = r1.append(r5);
        r0 = r1.append(r0);
        r1 = "\".";
        r0 = r0.append(r1);
        r0 = r0.toString();
        org.apache.log4j.helpers.LogLog.error(r0);
        r0 = 0;
        goto L_0x0028;
    L_0x013d:
        r3.append(r0);
        r1 = 48;
        if (r0 < r1) goto L_0x0162;
    L_0x0144:
        r1 = 57;
        if (r0 > r1) goto L_0x0162;
    L_0x0148:
        r1 = new org.apache.log4j.pattern.FormattingInfo;
        r6 = r4.isLeftAligned();
        r7 = r4.getMinLength();
        r4 = r4.getMaxLength();
        r4 = r4 * 10;
        r0 = r0 + -48;
        r0 = r0 + r4;
        r1.<init>(r6, r7, r0);
        r4 = r1;
        r0 = r5;
        goto L_0x0028;
    L_0x0162:
        r1 = r10;
        r5 = r13;
        r6 = r14;
        r7 = r11;
        r8 = r12;
        r2 = finalizeConverter(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = 0;
        r4 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r1 = 0;
        r3.setLength(r1);
        goto L_0x0028;
    L_0x0176:
        r0 = r3.length();
        if (r0 == 0) goto L_0x018f;
    L_0x017c:
        r0 = new org.apache.log4j.pattern.LiteralPatternConverter;
        r1 = r3.toString();
        r0.<init>(r1);
        r11.add(r0);
        r0 = org.apache.log4j.pattern.FormattingInfo.getDefault();
        r12.add(r0);
    L_0x018f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.pattern.PatternParser.parse(java.lang.String, java.util.List, java.util.List, java.util.Map, java.util.Map):void");
    }

    private static PatternConverter createConverter(String str, StringBuffer stringBuffer, Map map, Map map2, List list) {
        String str2 = str;
        Object obj = null;
        for (int length = str.length(); length > 0 && obj == null; length--) {
            str2 = str2.substring(0, length);
            if (map != null) {
                obj = map.get(str2);
            }
            if (obj == null && map2 != null) {
                obj = map2.get(str2);
            }
        }
        if (obj == null) {
            LogLog.error(new StringBuffer().append("Unrecognized format specifier [").append(str).append("]").toString());
            return null;
        }
        Class cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else if (obj instanceof String) {
            try {
                cls = Loader.loadClass((String) obj);
            } catch (Throwable e) {
                LogLog.warn(new StringBuffer().append("Class for conversion pattern %").append(str2).append(" not found").toString(), e);
                return null;
            }
        } else {
            LogLog.warn(new StringBuffer().append("Bad map entry for conversion pattern %").append(str2).append(".").toString());
            return null;
        }
        try {
            obj = cls.getMethod("newInstance", new Class[]{Class.forName("[Ljava.lang.String;")}).invoke(null, new Object[]{(String[]) list.toArray(new String[list.size()])});
            if (obj instanceof PatternConverter) {
                stringBuffer.delete(0, stringBuffer.length() - (str.length() - str2.length()));
                return (PatternConverter) obj;
            }
            LogLog.warn(new StringBuffer().append("Class ").append(cls.getName()).append(" does not extend PatternConverter.").toString());
            return null;
        } catch (Throwable e2) {
            LogLog.error(new StringBuffer().append("Error creating converter for ").append(str).toString(), e2);
            try {
                PatternConverter patternConverter = (PatternConverter) cls.newInstance();
                stringBuffer.delete(0, stringBuffer.length() - (str.length() - str2.length()));
                return patternConverter;
            } catch (Throwable e22) {
                LogLog.error(new StringBuffer().append("Error creating converter for ").append(str).toString(), e22);
            }
        }
    }

    private static int finalizeConverter(char c, String str, int i, StringBuffer stringBuffer, FormattingInfo formattingInfo, Map map, Map map2, List list, List list2) {
        StringBuffer stringBuffer2 = new StringBuffer();
        int extractConverter = extractConverter(c, str, i, stringBuffer2, stringBuffer);
        String stringBuffer3 = stringBuffer2.toString();
        List arrayList = new ArrayList();
        extractConverter = extractOptions(str, extractConverter, arrayList);
        PatternConverter createConverter = createConverter(stringBuffer3, stringBuffer, map, map2, arrayList);
        if (createConverter == null) {
            if (stringBuffer3 == null || stringBuffer3.length() == 0) {
                stringBuffer2 = new StringBuffer("Empty conversion specifier starting at position ");
            } else {
                stringBuffer2 = new StringBuffer("Unrecognized conversion specifier [");
                stringBuffer2.append(stringBuffer3);
                stringBuffer2.append("] starting at position ");
            }
            stringBuffer2.append(Integer.toString(extractConverter));
            stringBuffer2.append(" in conversion pattern.");
            LogLog.error(stringBuffer2.toString());
            list.add(new LiteralPatternConverter(stringBuffer.toString()));
            list2.add(FormattingInfo.getDefault());
        } else {
            list.add(createConverter);
            list2.add(formattingInfo);
            if (stringBuffer.length() > 0) {
                list.add(new LiteralPatternConverter(stringBuffer.toString()));
                list2.add(FormattingInfo.getDefault());
            }
        }
        stringBuffer.setLength(0);
        return extractConverter;
    }
}
