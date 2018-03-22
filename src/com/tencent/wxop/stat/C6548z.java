package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.p547b.C6507b;
import com.tencent.wxop.stat.p547b.C6511f;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6523r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class C6548z {
    private static C6548z f22865g = null;
    private List<String> f22866a = null;
    private volatile int f22867b = 2;
    private volatile String f22868c = "";
    private volatile HttpHost f22869d = null;
    private C6511f f22870e = null;
    private int f22871f = 0;
    private Context f22872h = null;
    private C6507b f22873i = null;

    private C6548z(Context context) {
        this.f22872h = context.getApplicationContext();
        this.f22870e = new C6511f();
        C6534l.m29802a(context);
        this.f22873i = C6517l.m29740c();
        m29901j();
        this.f22866a = new ArrayList(10);
        this.f22866a.add("117.135.169.101");
        this.f22866a.add("140.207.54.125");
        this.f22866a.add("180.153.8.53");
        this.f22866a.add("120.198.203.175");
        this.f22866a.add("14.17.43.18");
        this.f22866a.add("163.177.71.186");
        this.f22866a.add("111.30.131.31");
        this.f22866a.add("123.126.121.167");
        this.f22866a.add("123.151.152.111");
        this.f22866a.add("113.142.45.79");
        this.f22866a.add("123.138.162.90");
        this.f22866a.add("103.7.30.94");
        m29909g();
    }

    public static C6548z m29898a(Context context) {
        if (f22865g == null) {
            synchronized (C6548z.class) {
                if (f22865g == null) {
                    f22865g = new C6548z(context);
                }
            }
        }
        return f22865g;
    }

    private static boolean m29899b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private String m29900i() {
        try {
            String str = "pingma.qq.com";
            if (!C6548z.m29899b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.f22873i.m29705b(e);
        }
        return "";
    }

    private void m29901j() {
        this.f22867b = 0;
        this.f22869d = null;
        this.f22868c = null;
    }

    public final HttpHost m29902a() {
        return this.f22869d;
    }

    public final void m29903a(String str) {
        if (C6544v.m29830b()) {
            this.f22873i.m29702a("updateIpList " + str);
        }
        try {
            if (C6517l.m29742c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (C6517l.m29742c(string)) {
                            for (String str2 : string.split(";")) {
                                String str22;
                                if (C6517l.m29742c(str22)) {
                                    String[] split = str22.split(":");
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (C6548z.m29899b(str22) && !this.f22866a.contains(str22)) {
                                            if (C6544v.m29830b()) {
                                                this.f22873i.m29702a("add new ip:" + str22);
                                            }
                                            this.f22866a.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.f22873i.m29705b(e);
        }
        this.f22871f = new Random().nextInt(this.f22866a.size());
    }

    public final String m29904b() {
        return this.f22868c;
    }

    public final int m29905c() {
        return this.f22867b;
    }

    public final void m29906d() {
        this.f22871f = (this.f22871f + 1) % this.f22866a.size();
    }

    public final boolean m29907e() {
        return this.f22867b == 1;
    }

    public final boolean m29908f() {
        return this.f22867b != 0;
    }

    final void m29909g() {
        if (C6523r.m29791e(this.f22872h)) {
            if (C6544v.f22811g) {
                String i = m29900i();
                if (C6544v.m29830b()) {
                    this.f22873i.m29702a("remoteIp ip is " + i);
                }
                if (C6517l.m29742c(i)) {
                    String str;
                    if (this.f22866a.contains(i)) {
                        str = i;
                    } else {
                        str = (String) this.f22866a.get(this.f22871f);
                        if (C6544v.m29830b()) {
                            this.f22873i.m29706c(i + " not in ip list, change to:" + str);
                        }
                    }
                    C6544v.m29832c("http://" + str + ":80/mstat/report");
                }
            }
            this.f22868c = C6517l.m29757k(this.f22872h);
            if (C6544v.m29830b()) {
                this.f22873i.m29702a("NETWORK name:" + this.f22868c);
            }
            if (C6517l.m29742c(this.f22868c)) {
                if ("WIFI".equalsIgnoreCase(this.f22868c)) {
                    this.f22867b = 1;
                } else {
                    this.f22867b = 2;
                }
                this.f22869d = C6517l.m29733a(this.f22872h);
            }
            if (C6546x.m29867a()) {
                C6546x.m29875c(this.f22872h);
                return;
            }
            return;
        }
        if (C6544v.m29830b()) {
            this.f22873i.m29702a((Object) "NETWORK TYPE: network is close.");
        }
        m29901j();
    }

    public final void m29910h() {
        this.f22872h.getApplicationContext().registerReceiver(new as(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
