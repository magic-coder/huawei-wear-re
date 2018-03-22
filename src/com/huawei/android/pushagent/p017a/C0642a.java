package com.huawei.android.pushagent.p017a;

public class C0642a {
    public String f1153a;
    public Object f1154b;
    public Class f1155c;

    public C0642a(String str, Class cls, Object obj) {
        this.f1153a = str;
        this.f1155c = cls;
        this.f1154b = obj;
    }

    public C0642a(String str, Class cls, String str2) {
        this.f1153a = str;
        this.f1155c = cls;
        m2364a(str2);
    }

    public void m2364a(String str) {
        if (String.class == this.f1155c) {
            this.f1154b = str;
        } else if (Integer.class == this.f1155c) {
            this.f1154b = Integer.valueOf(Integer.parseInt(str));
        } else if (Long.class == this.f1155c) {
            this.f1154b = Long.valueOf(Long.parseLong(str));
        } else if (Boolean.class == this.f1155c) {
            this.f1154b = Boolean.valueOf(Boolean.parseBoolean(str));
        } else {
            this.f1154b = null;
        }
    }

    public String toString() {
        return new StringBuffer().append(this.f1153a).append(":").append(this.f1154b).append(":").append(this.f1155c.getSimpleName()).toString();
    }
}
