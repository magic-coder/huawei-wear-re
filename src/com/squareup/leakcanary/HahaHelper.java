package com.squareup.leakcanary;

import com.sina.weibo.sdk.component.GameManager;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.squareup.haha.perflib.ArrayInstance;
import com.squareup.haha.perflib.ClassInstance;
import com.squareup.haha.perflib.ClassInstance.FieldValue;
import com.squareup.haha.perflib.ClassObj;
import com.squareup.haha.perflib.Field;
import com.squareup.haha.perflib.Instance;
import com.squareup.haha.perflib.Type;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class HahaHelper {
    private static final Set<String> WRAPPER_TYPES = new HashSet(Arrays.asList(new String[]{Boolean.class.getName(), Character.class.getName(), Float.class.getName(), Double.class.getName(), Byte.class.getName(), Short.class.getName(), Integer.class.getName(), Long.class.getName()}));

    static String fieldToString(Entry<Field, Object> entry) {
        return fieldToString((Field) entry.getKey(), entry.getValue());
    }

    static String fieldToString(FieldValue fieldValue) {
        return fieldToString(fieldValue.getField(), fieldValue.getValue());
    }

    static String fieldToString(Field field, Object obj) {
        return field.getName() + " = " + obj;
    }

    static String threadName(Instance instance) {
        Object fieldValue = fieldValue(classInstanceValues(instance), "name");
        if (fieldValue == null) {
            return "Thread name not available";
        }
        return asString(fieldValue);
    }

    static boolean extendsThread(ClassObj classObj) {
        for (ClassObj classObj2 = classObj; classObj2.getSuperClassObj() != null; classObj2 = classObj2.getSuperClassObj()) {
            if (classObj.getClassName().equals(Thread.class.getName())) {
                return true;
            }
        }
        return false;
    }

    static String asString(Object obj) {
        Instance instance = (Instance) obj;
        List classInstanceValues = classInstanceValues(instance);
        Integer num = (Integer) fieldValue(classInstanceValues, "count");
        Preconditions.checkNotNull(num, "count");
        if (num.intValue() == 0) {
            return "";
        }
        Object fieldValue = fieldValue(classInstanceValues, "value");
        Preconditions.checkNotNull(fieldValue, "value");
        ArrayInstance arrayInstance;
        if (isCharArray(fieldValue)) {
            arrayInstance = (ArrayInstance) fieldValue;
            Integer valueOf = Integer.valueOf(0);
            if (hasField(classInstanceValues, ParamKey.OFFSET)) {
                valueOf = (Integer) fieldValue(classInstanceValues, ParamKey.OFFSET);
                Preconditions.checkNotNull(valueOf, ParamKey.OFFSET);
            }
            return new String(arrayInstance.asCharArray(valueOf.intValue(), num.intValue()));
        } else if (isByteArray(fieldValue)) {
            arrayInstance = (ArrayInstance) fieldValue;
            try {
                Method declaredMethod = ArrayInstance.class.getDeclaredMethod("asRawByteArray", new Class[]{Integer.TYPE, Integer.TYPE});
                declaredMethod.setAccessible(true);
                return new String((byte[]) declaredMethod.invoke(arrayInstance, new Object[]{Integer.valueOf(0), num}), Charset.forName(GameManager.DEFAULT_CHARSET));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            } catch (Throwable e22) {
                throw new RuntimeException(e22);
            }
        } else {
            throw new UnsupportedOperationException("Could not find char array in " + instance);
        }
    }

    public static boolean isPrimitiveWrapper(Object obj) {
        if (obj instanceof ClassInstance) {
            return WRAPPER_TYPES.contains(((ClassInstance) obj).getClassObj().getClassName());
        }
        return false;
    }

    public static boolean isPrimitiveOrWrapperArray(Object obj) {
        if (!(obj instanceof ArrayInstance)) {
            return false;
        }
        ArrayInstance arrayInstance = (ArrayInstance) obj;
        if (arrayInstance.getArrayType() != Type.OBJECT) {
            return true;
        }
        return WRAPPER_TYPES.contains(arrayInstance.getClassObj().getClassName());
    }

    private static boolean isCharArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.CHAR;
    }

    private static boolean isByteArray(Object obj) {
        return (obj instanceof ArrayInstance) && ((ArrayInstance) obj).getArrayType() == Type.BYTE;
    }

    static List<FieldValue> classInstanceValues(Instance instance) {
        return ((ClassInstance) instance).getValues();
    }

    static <T> T fieldValue(List<FieldValue> list, String str) {
        for (FieldValue fieldValue : list) {
            if (fieldValue.getField().getName().equals(str)) {
                return fieldValue.getValue();
            }
        }
        throw new IllegalArgumentException("Field " + str + " does not exists");
    }

    static boolean hasField(List<FieldValue> list, String str) {
        for (FieldValue field : list) {
            if (field.getField().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private HahaHelper() {
        throw new AssertionError();
    }
}
