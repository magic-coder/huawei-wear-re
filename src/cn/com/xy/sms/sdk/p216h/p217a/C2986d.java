package cn.com.xy.sms.sdk.p216h.p217a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class C2986d {
    private int f10109a;
    private boolean f10110b = false;
    private int f10111c = -1;
    private String f10112d;
    private String f10113e;
    private String[] f10114f;
    private Map<String, String> f10115g;
    private String f10116h;

    public C2986d(int i, String str) {
        this.f10109a = i;
        this.f10116h = str;
        m13423d();
    }

    private void m13423d() {
        for (String str : this.f10116h.split("\\s(?=-[a-zA-Z]+)")) {
            if (str.equals("-noWait")) {
                this.f10110b = true;
            } else if (str.startsWith("-wait=")) {
                this.f10111c = Integer.valueOf(str.substring(6)).intValue();
            } else if (str.startsWith("-ids=")) {
                this.f10114f = str.substring(5).split(",");
                this.f10110b = true;
            } else if (str.startsWith("-domain=")) {
                this.f10112d = str.substring(8);
            } else if (str.startsWith("-sql=")) {
                this.f10113e = str.substring(5);
            } else {
                if (this.f10115g == null) {
                    this.f10115g = new HashMap();
                }
                String[] split = str.split("=");
                if (split.length < 2) {
                    this.f10115g.put(split[0], "true");
                } else {
                    this.f10115g.put(split[0], split[1]);
                }
            }
        }
    }

    public final int m13424a() {
        return this.f10109a;
    }

    public final String m13425b() {
        return this.f10113e;
    }

    public final String[] m13426c() {
        return this.f10114f;
    }

    public final String toString() {
        return new StringBuffer("cmd : ").append(this.f10116h).append("\n targetTo interface:").append(this.f10109a == 0 ? "all" : Integer.valueOf(this.f10109a)).append("\n execute right now? ").append(this.f10110b).append("\n just for this ids:").append(this.f10114f == null ? "all" : Arrays.toString(this.f10114f)).append("\n reset Wait Date Period to ").append(this.f10111c == -1 ? "no change" : Integer.valueOf(this.f10111c)).append("\n reset Domain Url to ").append(this.f10112d == null ? "no change" : this.f10112d).append("\n sql:").append(this.f10113e == null ? "nosql to execute" : this.f10113e).append("\n other cmd:" + this.f10115g).toString();
    }
}
