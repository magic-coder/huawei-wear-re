package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p546a.C6495d;
import com.tencent.wxop.stat.p546a.C6501g;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

final class ah implements Runnable {
    private Context f22612a = null;
    private Map<String, Integer> f22613b = null;
    private C6547y f22614c = null;

    public ah(Context context) {
        this.f22612a = context;
        this.f22614c = null;
    }

    private static C6543u m29652a(String str, int i) {
        Throwable th;
        C6543u c6543u = new C6543u();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            c6543u.m29812a(str);
            c6543u.m29813b(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            c6543u.m29811a(System.currentTimeMillis() - currentTimeMillis);
            c6543u.m29814b(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                C6546x.f22856q.m29705b(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            C6546x.f22856q.m29705b(th2);
            socket.close();
        } catch (Throwable th22) {
            C6546x.f22856q.m29705b(th22);
        }
        c6543u.m29810a(i2);
        return c6543u;
    }

    private static Map<String, Integer> m29653a() {
        Map<String, Integer> hashMap = new HashMap();
        String a = C6544v.m29817a("__MTA_TEST_SPEED__");
        if (!(a == null || a.trim().length() == 0)) {
            for (String a2 : a2.split(";")) {
                String[] split = a2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            C6546x.f22856q.m29705b(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final void run() {
        try {
            if (this.f22613b == null) {
                this.f22613b = m29653a();
            }
            if (this.f22613b == null || this.f22613b.size() == 0) {
                C6546x.f22856q.m29702a((Object) "empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f22613b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    C6546x.f22856q.m29706c("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    C6546x.f22856q.m29706c("port is null for " + str);
                } else {
                    jSONArray.put(m29652a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).m29809a());
                }
            }
            if (jSONArray.length() != 0) {
                C6495d c6501g = new C6501g(this.f22612a, C6546x.m29858a(this.f22612a, false, this.f22614c), this.f22614c);
                c6501g.m29645a(jSONArray.toString());
                new ai(c6501g).m29659a();
            }
        } catch (Throwable th) {
            C6546x.f22856q.m29705b(th);
        }
    }
}
