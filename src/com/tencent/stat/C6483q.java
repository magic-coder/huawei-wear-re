package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p544a.C6443b;
import com.tencent.stat.p544a.C6446d;
import com.tencent.stat.p545b.C6463m;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class C6483q implements Runnable {
    private Context f22529a = null;
    private Map<String, Integer> f22530b = null;

    public C6483q(Context context, Map<String, Integer> map) {
        this.f22529a = context;
        if (map != null) {
            this.f22530b = map;
        }
    }

    private C6469b m29585a(String str, int i) {
        C6469b c6469b = new C6469b();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            c6469b.m29500a(str);
            c6469b.m29501b(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            c6469b.m29499a(System.currentTimeMillis() - currentTimeMillis);
            c6469b.m29502b(inetSocketAddress.getAddress().getHostAddress());
            if (socket != null) {
                socket.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable th) {
                    C6474g.f22503i.m29411f(th);
                }
            }
        } catch (Exception e) {
            Exception exception = e;
            i2 = -1;
            C6474g.f22503i.m29406b(exception);
            if (socket != null) {
                socket.close();
            }
        } catch (Throwable th2) {
            C6474g.f22503i.m29411f(th2);
        }
        c6469b.m29498a(i2);
        return c6469b;
    }

    private Map<String, Integer> m29586a() {
        Map<String, Integer> hashMap = new HashMap();
        String a = C6470c.m29505a("__MTA_TEST_SPEED__", null);
        if (!(a == null || a.trim().length() == 0)) {
            for (String a2 : a2.split(";")) {
                String[] split = a2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Exception e) {
                            C6474g.f22503i.m29406b(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (C6463m.m29465h(this.f22529a)) {
                if (this.f22530b == null) {
                    this.f22530b = m29586a();
                }
                if (this.f22530b == null || this.f22530b.size() == 0) {
                    C6474g.f22503i.m29409d("empty domain list.");
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (Entry entry : this.f22530b.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null || str.length() == 0) {
                        C6474g.f22503i.m29409d("empty domain name.");
                    } else if (((Integer) entry.getValue()) == null) {
                        C6474g.f22503i.m29409d("port is null for " + str);
                    } else {
                        jSONArray.put(m29585a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).m29497a());
                    }
                }
                if (jSONArray.length() != 0) {
                    C6443b c6446d = new C6446d(this.f22529a, C6474g.m29552a(this.f22529a, false));
                    c6446d.m29373a(jSONArray.toString());
                    if (C6474g.m29560c(this.f22529a) != null) {
                        C6474g.m29560c(this.f22529a).post(new C6484r(c6446d));
                    }
                }
            }
        } catch (Throwable th) {
            C6474g.f22503i.m29411f(th);
        }
    }
}
