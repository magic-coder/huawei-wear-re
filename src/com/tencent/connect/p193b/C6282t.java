package com.tencent.connect.p193b;

import java.util.HashMap;

/* compiled from: ProGuard */
public class C6282t {
    public static C6282t f21849a;
    static final /* synthetic */ boolean f21850d;
    private static int f21851e = 0;
    public HashMap<String, C6283u> f21852b = new HashMap();
    public final String f21853c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    static {
        boolean z;
        if (C6282t.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f21850d = z;
    }

    public static C6282t m28838a() {
        if (f21849a == null) {
            f21849a = new C6282t();
        }
        return f21849a;
    }

    public C6283u m28841a(String str) {
        return (C6283u) this.f21852b.get(str);
    }

    public static int m28839b() {
        int i = f21851e + 1;
        f21851e = i;
        return i;
    }

    public String m28842a(C6283u c6283u) {
        int b = C6282t.m28839b();
        try {
            this.f21852b.put("" + b, c6283u);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b;
    }

    public void m28844b(String str) {
        this.f21852b.remove(str);
    }

    public String m28845c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] toCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = toCharArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(toCharArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }

    public String m28843a(String str, String str2) {
        return m28840b(str, str2);
    }

    private String m28840b(String str, String str2) {
        int i = 0;
        if (f21850d || str.length() % 2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int length = str2.length();
            int length2 = str.length() / 2;
            int i2 = 0;
            while (i < length2) {
                stringBuilder.append((char) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) ^ str2.charAt(i2)));
                i2 = (i2 + 1) % length;
                i++;
            }
            return stringBuilder.toString();
        }
        throw new AssertionError();
    }
}
