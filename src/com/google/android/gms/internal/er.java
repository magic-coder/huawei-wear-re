package com.google.android.gms.internal;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class er {
    public static <T extends eq> String m1440a(T t) {
        String str;
        String valueOf;
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            m1442a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            str = "Error printing proto: ";
            valueOf = String.valueOf(e.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (InvocationTargetException e2) {
            str = "Error printing proto: ";
            valueOf = String.valueOf(e2.getMessage());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        }
    }

    private static String m1441a(String str) {
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

    private static void m1442a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj != null) {
            if (obj instanceof eq) {
                int modifiers;
                String name;
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer).append(m1441a(str)).append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    modifiers = field.getModifiers();
                    name = field.getName();
                    if (!("cachedSize".equals(name) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith(HwAccountConstants.SPLIIT_UNDERLINE) || name.endsWith(HwAccountConstants.SPLIIT_UNDERLINE))) {
                        Class type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray()) {
                            m1442a(name, obj2, stringBuffer, stringBuffer2);
                        } else if (type.getComponentType() == Byte.TYPE) {
                            m1442a(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (modifiers = 0; modifiers < length2; modifiers++) {
                                m1442a(name, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        try {
                            name = "has";
                            name3 = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(name3.length() != 0 ? name.concat(name3) : new String(name), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                try {
                                    name = "get";
                                    name3 = String.valueOf(substring);
                                    m1442a(substring, cls.getMethod(name3.length() != 0 ? name.concat(name3) : new String(name), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                                } catch (NoSuchMethodException e) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer).append(">\n");
                    return;
                }
                return;
            }
            stringBuffer2.append(stringBuffer).append(m1441a(str)).append(": ");
            if (obj instanceof String) {
                stringBuffer2.append("\"").append(m1444b((String) obj)).append("\"");
            } else if (obj instanceof byte[]) {
                m1443a((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static void m1443a(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 92 || i == 34) {
                stringBuffer.append('\\').append((char) i);
            } else if (i < 32 || i >= 127) {
                stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(i)}));
            } else {
                stringBuffer.append((char) i);
            }
        }
        stringBuffer.append('\"');
    }

    private static String m1444b(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = String.valueOf(str.substring(0, 200)).concat("[...]");
        }
        return m1445c(str);
    }

    private static String m1445c(String str) {
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
