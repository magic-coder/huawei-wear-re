package com.squareup.leakcanary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackedReference {
    public final String className;
    public final List<String> fields;
    public final String key;
    public final String name;

    public TrackedReference(String str, String str2, String str3, List<String> list) {
        this.key = str;
        this.name = str2;
        this.className = str3;
        this.fields = Collections.unmodifiableList(new ArrayList(list));
    }
}
