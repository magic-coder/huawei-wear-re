package com.tencent.connect.p193b;

/* compiled from: ProGuard */
public class C6284w {
    private String f21857a;
    private String f21858b;
    private String f21859c;
    private int f21860d = 1;
    private long f21861e = -1;

    public C6284w(String str) {
        this.f21857a = str;
    }

    public boolean m28848a() {
        return this.f21858b != null && System.currentTimeMillis() < this.f21861e;
    }

    public String m28849b() {
        return this.f21857a;
    }

    public void m28846a(String str) {
        this.f21857a = str;
    }

    public String m28851c() {
        return this.f21858b;
    }

    public void m28847a(String str, String str2) throws NumberFormatException {
        this.f21858b = str;
        this.f21861e = 0;
        if (str2 != null) {
            this.f21861e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public String m28852d() {
        return this.f21859c;
    }

    public void m28850b(String str) {
        this.f21859c = str;
    }
}
