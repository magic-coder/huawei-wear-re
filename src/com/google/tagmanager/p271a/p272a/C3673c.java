package com.google.tagmanager.p271a.p272a;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/* compiled from: MessageNanoPrinter */
public final class C3673c {
    public static <T extends C3632b> String m18415a(T t) {
        if (t == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            C3673c.m18417a(t.getClass().getSimpleName(), t.getClass(), t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            return "Error printing proto: " + e.getMessage();
        }
    }

    private static void m18417a(String str, Class<?> cls, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException {
        if (C3632b.class.isAssignableFrom(cls)) {
            if (obj != null) {
                stringBuffer2.append(stringBuffer).append(str);
                stringBuffer.append("  ");
                stringBuffer2.append(" <\n");
                for (Field field : cls.getFields()) {
                    int modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!((modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith(HwAccountConstants.SPLIIT_UNDERLINE) || name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE))) {
                        Class type = field.getType();
                        Object obj2 = field.get(obj);
                        if (type.isArray()) {
                            Class componentType = type.getComponentType();
                            if (componentType == Byte.TYPE) {
                                C3673c.m18417a(name, type, obj2, stringBuffer, stringBuffer2);
                            } else {
                                int length = obj2 == null ? 0 : Array.getLength(obj2);
                                for (modifiers = 0; modifiers < length; modifiers++) {
                                    C3673c.m18417a(name, componentType, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                                }
                            }
                        } else {
                            C3673c.m18417a(name, type, obj2, stringBuffer, stringBuffer2);
                        }
                    }
                }
                stringBuffer.delete(stringBuffer.length() - "  ".length(), stringBuffer.length());
                stringBuffer2.append(stringBuffer).append(">\n");
            }
        } else if (obj != null) {
            stringBuffer2.append(stringBuffer).append(C3673c.m18416a(str)).append(": ");
            if (obj instanceof String) {
                stringBuffer2.append("\"").append(C3673c.m18418b((String) obj)).append("\"");
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static String m18416a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static String m18418b(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return C3673c.m18419c(str);
    }

    private static String m18419c(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
