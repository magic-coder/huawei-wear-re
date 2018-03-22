package com.amap.api.mapcore.util;

/* compiled from: SDKInfo */
public class bv {
    String f11557a;
    String f11558b;
    String f11559c;
    private boolean f11560d;
    private String f11561e;
    private String[] f11562f;

    /* compiled from: SDKInfo */
    public class C3299a {
        private String f11551a;
        private String f11552b;
        private String f11553c;
        private boolean f11554d = true;
        private String f11555e = "standard";
        private String[] f11556f = null;

        public C3299a(String str, String str2, String str3) {
            this.f11551a = str2;
            this.f11553c = str3;
            this.f11552b = str;
        }

        public C3299a m15788a(boolean z) {
            this.f11554d = z;
            return this;
        }

        public C3299a m15787a(String str) {
            this.f11555e = str;
            return this;
        }

        public C3299a m15789a(String[] strArr) {
            this.f11556f = (String[]) strArr.clone();
            return this;
        }

        public bv m15790a() throws bl {
            if (this.f11556f != null) {
                return new bv();
            }
            throw new bl("sdk packages is null");
        }
    }

    private bv(C3299a c3299a) {
        this.f11560d = true;
        this.f11561e = "standard";
        this.f11562f = null;
        this.f11557a = c3299a.f11551a;
        this.f11559c = c3299a.f11552b;
        this.f11558b = c3299a.f11553c;
        this.f11560d = c3299a.f11554d;
        this.f11561e = c3299a.f11555e;
        this.f11562f = c3299a.f11556f;
    }

    public void m15792a(boolean z) {
        this.f11560d = z;
    }

    public String m15791a() {
        return this.f11559c;
    }

    public String m15793b() {
        return this.f11557a;
    }

    public String m15794c() {
        return this.f11558b;
    }

    public String m15795d() {
        return this.f11561e;
    }

    public boolean m15796e() {
        return this.f11560d;
    }

    public String[] m15797f() {
        return (String[]) this.f11562f.clone();
    }
}
