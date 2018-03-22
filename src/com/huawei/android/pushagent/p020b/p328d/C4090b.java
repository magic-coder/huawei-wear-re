package com.huawei.android.pushagent.p020b.p328d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.a.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p017a.C4060c.C4059a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class C4090b {
    private static C4090b f15479e = null;
    private int f15480a = 3;
    private long f15481b = 600000;
    private long f15482c = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    private long f15483d = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    private int f15484f = 0;
    private ArrayList f15485g = new ArrayList();

    class C4088a implements Comparable {
        private long f15472a;
        private boolean f15473b;

        C4088a() {
        }

        public int m20062a(C4088a c4088a) {
            return (int) ((m20063a() - c4088a.m20063a()) / 1000);
        }

        public long m20063a() {
            return this.f15472a;
        }

        public void m20064a(long j) {
            this.f15472a = j;
        }

        public void m20065a(boolean z) {
            this.f15473b = z;
        }

        public boolean m20066a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                String[] split = str.split(";");
                if (split.length < 2) {
                    e.d("PushLogAC2712", "load connectinfo " + str + " error");
                    return false;
                }
                this.f15472a = Long.parseLong(split[0]);
                this.f15473b = Boolean.parseBoolean(split[1]);
                return true;
            } catch (Throwable e) {
                e.c("PushLogAC2712", "load connectinfo " + str + " error:" + e.toString(), e);
                return false;
            }
        }

        public boolean m20067b() {
            return this.f15473b;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m20062a((C4088a) obj);
        }

        public boolean equals(Object obj) {
            return this == obj ? true : obj == null ? false : getClass() != obj.getClass() ? false : !(obj instanceof C4088a) ? false : this.f15473b == ((C4088a) obj).f15473b && this.f15472a == ((C4088a) obj).f15472a;
        }

        public int hashCode() {
            return (this.f15473b ? 1 : 0) + ((((int) (this.f15472a ^ (this.f15472a >>> 32))) + 527) * 31);
        }

        public String toString() {
            if (this.f15472a <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f15472a).append(";").append(this.f15473b);
            return stringBuffer.toString();
        }
    }

    public enum C4089b {
        SOCKET_CLOSE,
        SOCKET_CONNECTED,
        TRS_QUERIED,
        NETWORK_CHANGE
    }

    private C4090b() {
    }

    public static synchronized C4090b m20068a(Context context) {
        C4090b c4090b;
        synchronized (C4090b.class) {
            if (f15479e == null) {
                f15479e = new C4090b();
            }
            if (f15479e.f15485g.isEmpty()) {
                f15479e.m20074c(context);
            }
            c4090b = f15479e;
        }
        return c4090b;
    }

    private void m20069a(Context context, boolean z) {
        C4088a c4088a;
        e.a("PushLogAC2712", "save connection info " + z);
        long currentTimeMillis = System.currentTimeMillis();
        Collection arrayList = new ArrayList();
        Iterator it = this.f15485g.iterator();
        while (it.hasNext()) {
            c4088a = (C4088a) it.next();
            if (currentTimeMillis < c4088a.m20063a() || currentTimeMillis - c4088a.m20063a() > this.f15481b) {
                arrayList.add(c4088a);
            }
        }
        if (!arrayList.isEmpty()) {
            e.a("PushLogAC2712", "some connection info is expired:" + arrayList.size());
            this.f15485g.removeAll(arrayList);
        }
        c4088a = new C4088a();
        c4088a.m20065a(z);
        c4088a.m20064a(System.currentTimeMillis());
        if (this.f15485g.size() < this.f15480a) {
            this.f15485g.add(c4088a);
        } else {
            this.f15485g.remove(0);
            this.f15485g.add(c4088a);
        }
        String str = "|";
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it2 = this.f15485g.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(((C4088a) it2.next()).toString());
            stringBuffer.append(str);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        new h(context, "PushConnectControl").a("connectPushSvrInfos", stringBuffer.toString());
    }

    private boolean m20070a() {
        if (this.f15485g.size() < this.f15480a) {
            e.a("PushLogAC2712", "total connect times is less than " + this.f15480a);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.f15485g.iterator();
        int i = 0;
        while (it.hasNext()) {
            C4088a c4088a = (C4088a) it.next();
            int i2 = (currentTimeMillis <= c4088a.m20063a() || currentTimeMillis - c4088a.m20063a() >= this.f15481b) ? i : i + 1;
            i = i2;
        }
        e.a("PushLogAC2712", "connect times in last " + this.f15481b + " is " + i + ", limits is " + this.f15480a);
        return i >= this.f15480a;
    }

    private void m20071b() {
        this.f15484f = 0;
    }

    private void m20072b(Context context, boolean z) {
        e.a("PushLogAC2712", "set bad network mode " + z);
        c.a(context, new a("isBadNetworkMode", Boolean.class, Boolean.valueOf(z)));
    }

    private void m20073c() {
        this.f15484f++;
    }

    private void m20074c(Context context) {
        int i = 0;
        this.f15480a = com.huawei.android.pushagent.b.b.a.a(context).Z();
        this.f15481b = com.huawei.android.pushagent.b.b.a.a(context).Y();
        this.f15482c = com.huawei.android.pushagent.b.b.a.a(context).ab();
        this.f15483d = com.huawei.android.pushagent.b.b.a.a(context).aa();
        String b = new h(context, "PushConnectControl").b("connectPushSvrInfos");
        if (!TextUtils.isEmpty(b)) {
            e.a("PushLogAC2712", "connectPushSvrInfos is " + b);
            for (String str : b.split("\\|")) {
                C4088a c4088a = new C4088a();
                if (c4088a.m20066a(str)) {
                    this.f15485g.add(c4088a);
                }
            }
        }
        Collections.sort(this.f15485g);
        if (this.f15485g.size() > this.f15480a) {
            Collection arrayList = new ArrayList();
            int size = this.f15485g.size() - this.f15480a;
            while (i < size) {
                arrayList.add(this.f15485g.get(i));
                i++;
            }
            this.f15485g.removeAll(arrayList);
        }
    }

    private void m20075d(Context context) {
        if (!m20078g(context)) {
            e.a("PushLogAC2712", "It is not bad network mode, do nothing");
        } else if (this.f15485g.isEmpty()) {
            m20072b(context, false);
        } else {
            C4088a c4088a = (C4088a) this.f15485g.get(this.f15485g.size() - 1);
            if (c4088a.m20067b()) {
                e.a("PushLogAC2712", "last connection is success");
                long currentTimeMillis = System.currentTimeMillis();
                long a = c4088a.m20063a();
                if (currentTimeMillis - a > this.f15482c || currentTimeMillis < a) {
                    e.a("PushLogAC2712", this.f15482c + " has passed since last connect");
                    m20072b(context, false);
                    return;
                }
                e.a("PushLogAC2712", "connection keep too short , still in bad network mode");
                return;
            }
            e.a("PushLogAC2712", "last connection result is false , still in bad network mode");
        }
    }

    private long m20076e(Context context) {
        if (this.f15485g.isEmpty()) {
            e.a("PushLogAC2712", "first connection, return 0");
            return 0;
        }
        long k;
        long o;
        if (!c.a(context, "cloudpush_isNoDelayConnect", false)) {
            if (((long) this.f15484f) != com.huawei.android.pushagent.b.b.a.a(context).s()) {
                switch (this.f15484f) {
                    case 0:
                        k = 1000 * com.huawei.android.pushagent.b.b.a.a(context).k();
                        break;
                    case 1:
                        k = 1000 * com.huawei.android.pushagent.b.b.a.a(context).l();
                        break;
                    case 2:
                        k = 1000 * com.huawei.android.pushagent.b.b.a.a(context).m();
                        break;
                    case 3:
                        k = 1000 * com.huawei.android.pushagent.b.b.a.a(context).n();
                        break;
                    default:
                        o = 1000 * com.huawei.android.pushagent.b.b.a.a(context).o();
                        com.huawei.android.pushagent.b.b.a.a(context).a = true;
                        k = o;
                        break;
                }
            }
            com.huawei.android.pushagent.b.b.a.a(context).a = true;
            k = 1000 * com.huawei.android.pushagent.b.b.a.a(context).o();
        } else {
            k = 1000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        o = ((C4088a) this.f15485g.get(this.f15485g.size() - 1)).f15472a;
        if (currentTimeMillis < o) {
            e.a("PushLogAC2712", "now is less than last connect time");
            o = 0;
        } else {
            o = Math.max((o + k) - currentTimeMillis, 0);
        }
        e.b("PushLogAC2712", "after getConnectPushSrvInterval:" + o + " ms, connectTimes:" + this.f15484f);
        return o;
    }

    private long m20077f(Context context) {
        if (m20070a()) {
            m20072b(context, true);
        }
        boolean g = m20078g(context);
        e.a("PushLogAC2712", "bad network mode is " + g);
        if (!g || this.f15485g.isEmpty()) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b = ((C4088a) this.f15485g.get(this.f15485g.size() - 1)).f15472a;
        if (currentTimeMillis < b) {
            e.a("PushLogAC2712", "now is less than last connect time");
            b = 0;
        } else {
            b = Math.max((b + this.f15483d) - currentTimeMillis, 0);
        }
        e.a("PushLogAC2712", "It is in bad network mode, connect limit interval is " + b);
        return b;
    }

    private boolean m20078g(Context context) {
        return c.a(context, "isBadNetworkMode", false);
    }

    public void m20079a(Context context, C4089b c4089b, Bundle bundle) {
        e.a("PushLogAC2712", "receive reconnectevent:" + c4089b);
        switch (c4089b) {
            case NETWORK_CHANGE:
                m20071b();
                return;
            case TRS_QUERIED:
                m20071b();
                return;
            case SOCKET_CLOSE:
                m20075d(context);
                if (bundle.containsKey("errorType")) {
                    if (C4059a.Err_Connect == ((C4059a) bundle.getSerializable("errorType"))) {
                        m20069a(context, false);
                    } else {
                        e.a("PushLogAC2712", "socket close not caused by connect error, do not need save connection info");
                    }
                } else {
                    e.a("PushLogAC2712", "socket close not caused by pushException");
                }
                m20073c();
                com.huawei.android.pushagent.b.a.a.a(context).a(m20080b(context));
                return;
            case SOCKET_CONNECTED:
                m20071b();
                m20069a(context, true);
                return;
            default:
                return;
        }
    }

    public long m20080b(Context context) {
        return Math.max(m20076e(context), m20077f(context));
    }
}
