package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class C0423e {
    private final List<String> f431a;
    private final Object f432b;

    private C0423e(Object obj) {
        this.f432b = C0424f.m649a(obj);
        this.f431a = new ArrayList();
    }

    public C0423e m648a(String str, Object obj) {
        List list = this.f431a;
        String str2 = (String) C0424f.m649a((Object) str);
        String valueOf = String.valueOf(String.valueOf(obj));
        list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
        return this;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(100).append(this.f432b.getClass().getSimpleName()).append('{');
        int size = this.f431a.size();
        for (int i = 0; i < size; i++) {
            append.append((String) this.f431a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
