package cn.com.xy.sms.sdk.p208d.p211c;

import cn.com.xy.sms.sdk.p215g.C2982a;
import java.util.ArrayList;
import java.util.List;

public final class af {
    public String f9952a;
    public String f9953b;
    public int f9954c;
    public int f9955d = 0;
    public int f9956e = 0;
    public List<C2946m> f9957f;

    public final void m13236a(C2946m c2946m) {
        if (this.f9957f == null) {
            this.f9957f = new ArrayList();
        }
        this.f9957f.add(c2946m);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (hashCode() == obj.hashCode()) {
                return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            af afVar = (af) obj;
            if (this.f9952a == null || !this.f9952a.equals(afVar.f9952a)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "equals: " + th.getMessage(), th);
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return "Sceneconfig [sceneId=" + this.f9952a + ", sceneVersion=" + this.f9953b + ", isDownload=" + this.f9955d + "]";
    }
}
