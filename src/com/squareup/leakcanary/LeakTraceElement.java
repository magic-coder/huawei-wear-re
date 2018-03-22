package com.squareup.leakcanary;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class LeakTraceElement implements Serializable {
    public final String className;
    public final Exclusion exclusion;
    public final String extra;
    public final List<String> fields;
    public final Holder holder;
    public final String referenceName;
    public final Type type;

    public enum Holder {
        OBJECT,
        CLASS,
        THREAD,
        ARRAY
    }

    public enum Type {
        INSTANCE_FIELD,
        STATIC_FIELD,
        LOCAL,
        ARRAY_ENTRY
    }

    LeakTraceElement(String str, Type type, Holder holder, String str2, String str3, Exclusion exclusion, List<String> list) {
        this.referenceName = str;
        this.type = type;
        this.holder = holder;
        this.className = str2;
        this.extra = str3;
        this.exclusion = exclusion;
        this.fields = Collections.unmodifiableList(new ArrayList(list));
    }

    public String toString() {
        String str = "";
        if (this.type == Type.STATIC_FIELD) {
            str = str + "static ";
        }
        if (this.holder == Holder.ARRAY || this.holder == Holder.THREAD) {
            str = str + this.holder.name().toLowerCase(Locale.US) + HwAccountConstants.BLANK;
        }
        str = str + this.className;
        if (this.referenceName != null) {
            str = str + "." + this.referenceName;
        } else {
            str = str + " instance";
        }
        if (this.extra != null) {
            str = str + HwAccountConstants.BLANK + this.extra;
        }
        if (this.exclusion != null) {
            return str + " , matching exclusion " + this.exclusion.matching;
        }
        return str;
    }

    public String toDetailedString() {
        String str = "* ";
        if (this.holder == Holder.ARRAY) {
            str = str + "Array of";
        } else if (this.holder == Holder.CLASS) {
            str = str + "Class";
        } else {
            str = str + "Instance of";
        }
        str = str + HwAccountConstants.BLANK + this.className + "\n";
        String str2 = str;
        for (String str3 : this.fields) {
            str2 = str2 + "|   " + str3 + "\n";
        }
        return str2;
    }
}
