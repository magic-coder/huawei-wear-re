package com.huawei.android.pushagent.p020b.p328d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p020b.p328d.p329a.C4084b;
import com.huawei.android.pushagent.p020b.p328d.p329a.C4085a;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class C4086a {
    private static C4086a f15463h = null;
    Context f15464a = null;
    List f15465b = new LinkedList();
    List f15466c = new LinkedList();
    List f15467d = new LinkedList();
    List f15468e = new LinkedList();
    List f15469f = new LinkedList();
    List f15470g = new LinkedList();

    private C4086a(Context context) {
        this.f15464a = context;
        m20059f();
        if (this.f15465b.size() == 0 && this.f15466c.size() == 0 && this.f15467d.size() == 0 && this.f15468e.size() == 0 && this.f15469f.size() == 0 && this.f15470g.size() == 0) {
            e.a("PushLogAC2712", "Connect Control is not set, begin to config it");
            m20056c();
        }
    }

    private boolean m20043a(int i) {
        return 1 == C4103b.m20122a(this.f15464a) ? m20047a(this.f15470g) : m20047a(this.f15467d);
    }

    public static synchronized boolean m20044a(Context context) {
        boolean z;
        synchronized (C4086a.class) {
            C4086a.m20050b(context);
            if (f15463h == null) {
                e.d("PushLogAC2712", "cannot get ConnectControlMgr instance, may be system err!!");
                z = false;
            } else {
                z = f15463h.m20057d();
            }
        }
        return z;
    }

    public static synchronized boolean m20045a(Context context, int i) {
        boolean z;
        synchronized (C4086a.class) {
            C4086a.m20050b(context);
            if (f15463h == null) {
                e.d("PushLogAC2712", "cannot get ConnectControlMgr instance, may be system err!!");
                z = false;
            } else {
                z = f15463h.m20043a(i);
            }
        }
        return z;
    }

    private boolean m20046a(h hVar, List list, String str) throws Exception {
        String str2 = "\\|";
        list.clear();
        String b = hVar.b(str);
        if (TextUtils.isEmpty(b)) {
            e.a("PushLogAC2712", str + " is not set");
        } else {
            e.a("PushLogAC2712", str + "=" + b);
            for (String str3 : b.split(str2)) {
                C4085a c4085a = new C4085a();
                if (c4085a.m20041a(str3)) {
                    list.add(c4085a);
                }
            }
        }
        return true;
    }

    private boolean m20047a(List list) {
        if (m20048a(list, 1)) {
            m20053b(list, 1);
            m20058e();
            return true;
        }
        e.b("PushLogAC2712", "volumeControl not allow to pass!!");
        return false;
    }

    private boolean m20048a(List list, long j) {
        if (list == null || list.size() == 0) {
            e.a("PushLogAC2712", "there is no volome control");
            return true;
        }
        for (C4084b c4084b : list) {
            if (c4084b.mo4376a(j)) {
                e.a("PushLogAC2712", " pass:" + c4084b);
            } else {
                e.b("PushLogAC2712", " not pass:" + c4084b);
                return false;
            }
        }
        return true;
    }

    private boolean m20049a(List list, List list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (C4084b c4084b : list) {
            Object obj;
            for (C4084b a : list2) {
                if (c4084b.mo4377a(a)) {
                    obj = 1;
                    continue;
                    break;
                }
            }
            obj = null;
            continue;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static synchronized C4086a m20050b(Context context) {
        C4086a c4086a;
        synchronized (C4086a.class) {
            if (f15463h == null) {
                f15463h = new C4086a(context);
            }
            c4086a = f15463h;
        }
        return c4086a;
    }

    private boolean m20051b() {
        List linkedList = new LinkedList();
        linkedList.add(new C4085a(86400000, a.a(this.f15464a).G()));
        linkedList.add(new C4085a(3600000, a.a(this.f15464a).H()));
        if (m20049a(linkedList, this.f15465b)) {
            linkedList = new LinkedList();
            linkedList.add(new C4085a(86400000, a.a(this.f15464a).I()));
            if (m20049a(linkedList, this.f15466c)) {
                List linkedList2 = new LinkedList();
                for (Entry entry : a.a(this.f15464a).J().entrySet()) {
                    linkedList2.add(new C4085a(((Long) entry.getKey()).longValue() * 1000, ((Long) entry.getValue()).longValue()));
                }
                if (m20049a(linkedList2, this.f15467d)) {
                    linkedList = new LinkedList();
                    linkedList.add(new C4085a(86400000, a.a(this.f15464a).K()));
                    linkedList.add(new C4085a(3600000, a.a(this.f15464a).L()));
                    if (m20049a(linkedList, this.f15468e)) {
                        linkedList = new LinkedList();
                        linkedList.add(new C4085a(86400000, a.a(this.f15464a).M()));
                        if (m20049a(linkedList, this.f15469f)) {
                            linkedList2 = new LinkedList();
                            for (Entry entry2 : a.a(this.f15464a).R().entrySet()) {
                                linkedList2.add(new C4085a(((Long) entry2.getKey()).longValue() * 1000, ((Long) entry2.getValue()).longValue()));
                            }
                            if (m20049a(linkedList2, this.f15470g)) {
                                e.a("PushLogAC2712", "cur control is equal trs cfg");
                                return true;
                            }
                            e.a("PushLogAC2712", "wifiVolumeControl cfg is change!!");
                            return false;
                        }
                        e.a("PushLogAC2712", "wifiTrsFlowControl cfg is change!!");
                        return false;
                    }
                    e.a("PushLogAC2712", "wifiTrsFirstFlowControl cfg is change!");
                    return false;
                }
                e.a("PushLogAC2712", "flowcControl cfg is change!!");
                return false;
            }
            e.a("PushLogAC2712", "trsFlowControl cfg is change!!");
            return false;
        }
        e.a("PushLogAC2712", "trsFirstFlowControl cfg is change!");
        return false;
    }

    private boolean m20052b(h hVar, List list, String str) throws Exception {
        String str2 = "|";
        StringBuffer stringBuffer = new StringBuffer();
        for (C4084b a : list) {
            stringBuffer.append(a.mo4375a()).append(str2);
        }
        if (hVar.a(str, stringBuffer.toString())) {
            return true;
        }
        e.d("PushLogAC2712", "save " + str + " failed!!");
        return false;
    }

    private synchronized boolean m20053b(List list, long j) {
        boolean z;
        if (list != null) {
            if (list.size() != 0) {
                for (C4084b c4084b : list) {
                    if (!c4084b.mo4378b(j)) {
                        e.b("PushLogAC2712", " control info:" + c4084b);
                        z = false;
                        break;
                    }
                }
                z = true;
            }
        }
        z = true;
        return z;
    }

    private boolean m20054b(List list, List list2) {
        if (0 == c.a(this.f15464a, "lastQueryTRSsucc_time", 0)) {
            if (m20048a(list, 1)) {
                m20053b(list, 1);
            } else {
                e.d("PushLogAC2712", "trsFirstFlowControl not allowed to pass!!");
                return false;
            }
        } else if (m20048a(list2, 1)) {
            m20053b(list2, 1);
        } else {
            e.d("PushLogAC2712", "trsFlowControl not allowed to pass!!");
            return false;
        }
        m20058e();
        return true;
    }

    public static synchronized void m20055c(Context context) {
        synchronized (C4086a.class) {
            C4086a.m20050b(context);
            if (!(f15463h == null || f15463h.m20051b())) {
                e.a("PushLogAC2712", "TRS cfg change, need reload");
                f15463h.m20056c();
            }
        }
    }

    private boolean m20056c() {
        this.f15465b.clear();
        this.f15465b.add(new C4085a(86400000, a.a(this.f15464a).G()));
        this.f15465b.add(new C4085a(3600000, a.a(this.f15464a).H()));
        this.f15466c.clear();
        this.f15466c.add(new C4085a(86400000, a.a(this.f15464a).I()));
        this.f15467d.clear();
        for (Entry entry : a.a(this.f15464a).J().entrySet()) {
            this.f15467d.add(new C4085a(((Long) entry.getKey()).longValue() * 1000, ((Long) entry.getValue()).longValue()));
        }
        this.f15468e.clear();
        this.f15468e.add(new C4085a(86400000, a.a(this.f15464a).K()));
        this.f15468e.add(new C4085a(3600000, a.a(this.f15464a).L()));
        this.f15469f.clear();
        this.f15469f.add(new C4085a(86400000, a.a(this.f15464a).M()));
        this.f15470g.clear();
        for (Entry entry2 : a.a(this.f15464a).R().entrySet()) {
            this.f15470g.add(new C4085a(((Long) entry2.getKey()).longValue() * 1000, ((Long) entry2.getValue()).longValue()));
        }
        m20058e();
        return true;
    }

    private boolean m20057d() {
        return 1 == C4103b.m20122a(this.f15464a) ? m20054b(this.f15468e, this.f15469f) : m20054b(this.f15465b, this.f15466c);
    }

    private boolean m20058e() {
        try {
            h hVar = new h(this.f15464a, "PushConnectControl");
            return m20052b(hVar, this.f15468e, "wifiTrsFirstFlowControlData") && m20052b(hVar, this.f15469f, "wifiTrsFlowControlData") && m20052b(hVar, this.f15470g, "wifiVolumeControlData") && m20052b(hVar, this.f15465b, "trsFirstFlowControlData") && m20052b(hVar, this.f15466c, "trsFlowControlData") && m20052b(hVar, this.f15467d, "volumeControlData");
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
            return false;
        }
    }

    private boolean m20059f() {
        try {
            h hVar = new h(this.f15464a, "PushConnectControl");
            m20046a(hVar, this.f15465b, "trsFirstFlowControlData");
            m20046a(hVar, this.f15466c, "trsFlowControlData");
            m20046a(hVar, this.f15467d, "volumeControlData");
            m20046a(hVar, this.f15468e, "wifiTrsFirstFlowControlData");
            m20046a(hVar, this.f15469f, "wifiTrsFlowControlData");
            m20046a(hVar, this.f15470g, "wifiVolumeControlData");
            return true;
        } catch (Throwable e) {
            e.c("PushLogAC2712", e.toString(), e);
            return false;
        }
    }

    public void m20060a() {
        this.f15465b.clear();
        this.f15466c.clear();
        this.f15467d.clear();
        this.f15468e.clear();
        this.f15469f.clear();
        this.f15470g.clear();
    }
}
