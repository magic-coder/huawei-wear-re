package com.huawei.android.pushagent.p017a;

import android.content.Context;
import cn.com.fmsh.util.algorithm.RSA;
import com.huawei.android.pushagent.p018c.p019a.C0643c;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import java.util.HashMap;

public class C0644e extends C0643c {
    public C0644e(Context context) {
        super(context, "PushRouteInfo");
    }

    public C0644e(Context context, String str) {
        this(context);
        this.c = C0643c.m2365e(str);
    }

    private HashMap m2372b(String str, String str2) {
        String str3 = "\\d{1,3}";
        HashMap hashMap = new HashMap();
        for (String str4 : this.c.keySet()) {
            if (str4.matches(str + str3)) {
                hashMap.put(Long.valueOf(m2369b(str4, 1)), Long.valueOf(m2369b(str4.replace(str, str2), 2147483647L)));
            }
        }
        return hashMap;
    }

    public long m2373A() {
        return m2369b("push4StartInt", 1800);
    }

    public long m2374B() {
        return m2369b("pollingInterval", 1800);
    }

    public String m2375C() {
        return m2367a("pollingIp", "");
    }

    public int m2376D() {
        return m2366a("pollingPort", -1);
    }

    public int m2377E() {
        return m2366a("pollingId", -1);
    }

    public long m2378F() {
        return m2369b("tokenRegTimeOut", 30);
    }

    public long m2379G() {
        return m2369b("firstQueryTRSDayTimes", 6);
    }

    public long m2380H() {
        return m2369b("firstQueryTRSHourTimes", 2);
    }

    public long m2381I() {
        return m2369b("maxQueryTRSDayTimes", 1);
    }

    public HashMap m2382J() {
        return m2372b("flowcInterval", "flowcVlomes");
    }

    public long m2383K() {
        return m2369b("wifiFirstQueryTRSDayTimes", 18);
    }

    public long m2384L() {
        return m2369b("wifiFirstQueryTRSHourTimes", 6);
    }

    public long m2385M() {
        return m2369b("wifiMaxQueryTRSDayTimes", 3);
    }

    public long m2386N() {
        return m2369b("cloneCheckItval", 600);
    }

    public long m2387O() {
        return m2369b("updateFilesItval", 300);
    }

    public long m2388P() {
        return m2369b("stopServiceItval", 5);
    }

    public long m2389Q() {
        return m2369b("heartBeatRspTimeOut", 10) * 1000;
    }

    public HashMap m2390R() {
        return m2372b("wifiFlowcInterval", "wifiFlowcVlomes");
    }

    public HashMap m2391S() {
        HashMap hashMap = new HashMap();
        String str = "apn_";
        for (String str2 : this.c.keySet()) {
            if (str2.startsWith(str)) {
                hashMap.put(str2, (String) this.c.get(str2));
            }
        }
        return hashMap;
    }

    public int m2392T() {
        return m2366a("grpNum", 0);
    }

    public String m2393U() {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiCa5gkvCb+/dHAcgN1WMm0ItA\rY1njDoy6bPCE+oHZI439lmjP14PH7n2xtKsuybPbzPAGwuXq4doRz+wB8JiOUjNQ\rVI88zNzDDhdV3pxQlFgk61VojWtVBH2H45qMPMbMs4HdVs0Qcida2IhXOi6eAyRK\rp3PApI7e/ta1FHYKiwIDAQAB";
        return m2367a(RSA.PUBLIC_KEY, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiCa5gkvCb+/dHAcgN1WMm0ItA\rY1njDoy6bPCE+oHZI439lmjP14PH7n2xtKsuybPbzPAGwuXq4doRz+wB8JiOUjNQ\rVI88zNzDDhdV3pxQlFgk61VojWtVBH2H45qMPMbMs4HdVs0Qcida2IhXOi6eAyRK\rp3PApI7e/ta1FHYKiwIDAQAB");
    }

    public boolean m2394V() {
        return m2395W();
    }

    public boolean m2395W() {
        return ("".equals(m2405c()) || -1 == m2407d() || m2399a() != 0) ? false : true;
    }

    public boolean m2396X() {
        return ("".equals(m2375C()) || -1 == m2376D() || m2399a() != 0) ? false : true;
    }

    public long m2397Y() {
        return m2369b("ConnRange", 600) * 1000;
    }

    public int m2398Z() {
        return m2366a("MaxConnTimes", 3);
    }

    public int m2399a() {
        return m2366a("result", -1);
    }

    public void m2400a(long j) {
        m2368a("wifiMinHeartbeat", (Object) Long.valueOf(j));
    }

    public boolean m2401a(C0644e c0644e) {
        C0657e.m2512a("PushLogSC2712", "wifiMinHeartbeat=" + m2411g() + ",wifiMaxHeartbeat=" + m2412h() + ",3gMinHeartbeat=" + m2413i() + ",3gMaxHeartbeat=" + m2414j());
        return m2411g() == c0644e.m2411g() && m2412h() == c0644e.m2412h() && m2413i() == c0644e.m2413i() && m2414j() == c0644e.m2414j();
    }

    protected boolean m2402a(String str) {
        String b = m2403b();
        C0657e.m2512a("PushLogSC2712", "old belongId = " + b + ", current belongId = " + str);
        return b.equals(str);
    }

    public long aa() {
        return m2369b("ReConnInterval", 300) * 1000;
    }

    public long ab() {
        return m2369b("KeepConnTime", 300) * 1000;
    }

    public boolean ac() {
        return m2366a("allowPry", 0) == 1;
    }

    public long ad() {
        return m2369b("hbvalid", 1296000) * 1000;
    }

    public boolean ae() {
        return m2366a("isMultiSimEnabled", 0) != 0;
    }

    public String m2403b() {
        return m2367a("belongId", "-1");
    }

    public void m2404b(long j) {
        m2368a("wifiMaxHeartbeat", (Object) Long.valueOf(j));
    }

    public String m2405c() {
        return m2367a("serverIp", "");
    }

    public void m2406c(long j) {
        m2368a("g3MinHeartbeat", (Object) Long.valueOf(j));
    }

    public int m2407d() {
        return m2366a("serverPort", -1);
    }

    public void m2408d(long j) {
        m2368a("g3MaxHeartbeat", (Object) Long.valueOf(j));
    }

    public long m2409e() {
        return m2369b("trsValid_min", 7200);
    }

    public long m2410f() {
        return m2369b("trsValid_max", 2592000);
    }

    public long m2411g() {
        return m2369b("wifiMinHeartbeat", 1800);
    }

    public long m2412h() {
        return m2369b("wifiMaxHeartbeat", 1800);
    }

    public long m2413i() {
        return m2369b("g3MinHeartbeat", 900);
    }

    public long m2414j() {
        return m2369b("g3MaxHeartbeat", 1800);
    }

    public long m2415k() {
        return m2369b("serverRec1_min", 1);
    }

    public long m2416l() {
        return m2369b("serverRec2_min", 30);
    }

    public long m2417m() {
        return m2369b("serverRec3_min", 300);
    }

    public long m2418n() {
        return m2369b("serverRec4_min", 1800);
    }

    public long m2419o() {
        return m2369b("serverRec5_min", 1800);
    }

    public long m2420p() {
        return m2369b("noNetHeartbeat", 7200);
    }

    public long m2421q() {
        return m2369b("connTrsItval", 300);
    }

    public long m2422r() {
        return m2369b("connTrsErrItval", 1800);
    }

    public long m2423s() {
        return m2369b("SrvMaxFail_times", 6);
    }

    public long m2424t() {
        return m2369b("maxQTRS_times", 6);
    }

    public long m2425u() {
        return m2369b("socketConnTimeOut", 30);
    }

    public long m2426v() {
        return m2369b("socketConnectReadOut", 20);
    }

    public long m2427w() {
        return m2369b("pushLeastRun_time", 30);
    }

    public long m2428x() {
        return m2369b("push1StartInt", 3);
    }

    public long m2429y() {
        return m2369b("push2StartInt", 30);
    }

    public long m2430z() {
        return m2369b("push3StartInt", 600);
    }
}
