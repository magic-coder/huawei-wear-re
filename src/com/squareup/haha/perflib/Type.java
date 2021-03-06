package com.squareup.haha.perflib;

import com.squareup.haha.guava.collect.Maps;
import java.util.Map;

public enum Type {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, Type> sTypeMap;
    private int mId;
    private int mSize;

    static {
        sTypeMap = Maps.newHashMap();
        Type[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            Type type = values[i];
            sTypeMap.put(Integer.valueOf(type.mId), type);
            i++;
        }
    }

    private Type(int i, int i2) {
        this.mId = i;
        this.mSize = i2;
    }

    public static Type getType(int i) {
        return (Type) sTypeMap.get(Integer.valueOf(i));
    }

    public final int getSize() {
        return this.mSize;
    }

    public final int getTypeId() {
        return this.mId;
    }

    public static String getClassNameOfPrimitiveArray(Type type) {
        switch (type) {
            case BOOLEAN:
                return "boolean[]";
            case CHAR:
                return "char[]";
            case FLOAT:
                return "float[]";
            case DOUBLE:
                return "double[]";
            case BYTE:
                return "byte[]";
            case SHORT:
                return "short[]";
            case INT:
                return "int[]";
            case LONG:
                return "long[]";
            default:
                throw new IllegalArgumentException("OBJECT type is not a primitive type");
        }
    }
}
