package com.snowballtech.common.log;

public class LogFormatTool {
    private static String SPACE = "   ";
    private static LogFormatTool instance;

    private LogFormatTool() {
    }

    public static LogFormatTool getInstance() {
        if (instance == null) {
            instance = new LogFormatTool();
        }
        return instance;
    }

    public String formatJson(String str) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '[' || charAt == '{') {
                if (i2 - 1 > 0 && str.charAt(i2 - 1) == ':') {
                    stringBuffer.append('\n');
                    stringBuffer.append(indent(i));
                }
                stringBuffer.append(charAt);
                stringBuffer.append('\n');
                i++;
                stringBuffer.append(indent(i));
            } else if (charAt == ']' || charAt == '}') {
                stringBuffer.append('\n');
                i--;
                stringBuffer.append(indent(i));
                stringBuffer.append(charAt);
                if (i2 + 1 < length && str.charAt(i2 + 1) != ',') {
                    stringBuffer.append('\n');
                }
            } else if (charAt == ',') {
                stringBuffer.append(charAt);
                stringBuffer.append('\n');
                stringBuffer.append(indent(i));
            } else {
                stringBuffer.append(charAt);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    private String indent(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(SPACE);
        }
        return stringBuffer.toString();
    }
}
