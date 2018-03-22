package com.squareup.haha.perflib;

import java.util.Arrays;

public final class Field {
    private final String mName;
    private final Type mType;

    public Field(Type type, String str) {
        this.mType = type;
        this.mName = str;
    }

    public final Type getType() {
        return this.mType;
    }

    public final String getName() {
        return this.mName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        if (this.mType == field.mType && this.mName.equals(field.mName)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.mType, this.mName});
    }
}
