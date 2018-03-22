package com.google.zxing.client.p285a;

/* compiled from: ParsedResult */
public abstract class C3743q {
    private final C3759r f14543a;

    public abstract String mo4309a();

    protected C3743q(C3759r c3759r) {
        this.f14543a = c3759r;
    }

    public final C3759r m18843b() {
        return this.f14543a;
    }

    public final String toString() {
        return mo4309a();
    }

    public static void m18840a(String str, StringBuilder stringBuilder) {
        if (str != null && !str.isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(str);
        }
    }

    public static void m18841a(String[] strArr, StringBuilder stringBuilder) {
        if (strArr != null) {
            for (String a : strArr) {
                C3743q.m18840a(a, stringBuilder);
            }
        }
    }
}
