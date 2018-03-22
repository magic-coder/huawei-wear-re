package com.amap.api.services.core;

/* compiled from: SDKInfo */
public class ad {
    String f12314a;
    String f12315b;
    String f12316c;
    private boolean f12317d;
    private String f12318e;
    private String[] f12319f;

    /* compiled from: SDKInfo */
    public class C3390a {
        private String f12308a;
        private String f12309b;
        private String f12310c;
        private boolean f12311d = true;
        private String f12312e = "standard";
        private String[] f12313f = null;

        public C3390a(String str, String str2, String str3) {
            this.f12308a = str2;
            this.f12310c = str3;
            this.f12309b = str;
        }

        public C3390a m16610a(boolean z) {
            this.f12311d = z;
            return this;
        }

        public C3390a m16609a(String str) {
            this.f12312e = str;
            return this;
        }

        public C3390a m16611a(String[] strArr) {
            this.f12313f = (String[]) strArr.clone();
            return this;
        }

        public ad m16612a() throws C3433v {
            if (this.f12313f != null) {
                return new ad();
            }
            throw new C3433v("sdk packages is null");
        }
    }

    private ad(C3390a c3390a) {
        this.f12317d = true;
        this.f12318e = "standard";
        this.f12319f = null;
        this.f12314a = c3390a.f12308a;
        this.f12316c = c3390a.f12309b;
        this.f12315b = c3390a.f12310c;
        this.f12317d = c3390a.f12311d;
        this.f12318e = c3390a.f12312e;
        this.f12319f = c3390a.f12313f;
    }

    public String m16613a() {
        return this.f12316c;
    }

    public String m16614b() {
        return this.f12314a;
    }

    public String m16615c() {
        return this.f12315b;
    }

    public String m16616d() {
        return this.f12318e;
    }

    public boolean m16617e() {
        return this.f12317d;
    }

    public String[] m16618f() {
        return (String[]) this.f12319f.clone();
    }
}
