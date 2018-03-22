package com.tencent.open.p542b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6403p;
import com.tencent.open.p532d.C6408u;
import com.tencent.open.p541a.C6367n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class C6378g {
    protected static C6378g f22180a;
    protected Random f22181b = new Random();
    protected List<Serializable> f22182c = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> f22183d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread f22184e = null;
    protected Handler f22185f;
    protected Executor f22186g = C6408u.m29231b();
    protected Executor f22187h = C6408u.m29231b();

    public static synchronized C6378g m29155a() {
        C6378g c6378g;
        synchronized (C6378g.class) {
            if (f22180a == null) {
                f22180a = new C6378g();
            }
            c6378g = f22180a;
        }
        return c6378g;
    }

    private C6378g() {
        if (this.f22184e == null) {
            this.f22184e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f22184e.start();
        }
        if (this.f22184e.isAlive() && this.f22184e.getLooper() != null) {
            this.f22185f = new C6379h(this, this.f22184e.getLooper());
        }
    }

    public void m29157a(Bundle bundle, String str, boolean z) {
        if (bundle != null) {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (m29162a("report_via", str) || z) {
                this.f22186g.execute(new C6380i(this, bundle, z));
            }
        }
    }

    public void m29158a(String str, long j, long j2, long j3, int i) {
        m29159a(str, j, j2, j3, i, "", false);
    }

    public void m29159a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (m29162a("report_cgi", "" + i) || z) {
            this.f22187h.execute(new C6381j(this, j, str, str2, i, j2, j3, z));
        }
    }

    protected void m29163b() {
        this.f22187h.execute(new C6382k(this));
    }

    protected boolean m29162a(String str, String str2) {
        boolean z = true;
        boolean z2 = false;
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        if (!TextUtils.isEmpty(str)) {
            int i;
            int a;
            if (str.equals("report_cgi")) {
                try {
                    a = m29156a(Integer.parseInt(str2));
                    if (this.f22181b.nextInt(100) >= a) {
                        z = false;
                    }
                    z2 = z;
                    i = a;
                } catch (Exception e) {
                }
            } else if (str.equals("report_via")) {
                a = C6376e.m29150a(str2);
                if (this.f22181b.nextInt(100) < a) {
                    z2 = true;
                    i = a;
                } else {
                    i = a;
                }
            } else {
                i = 100;
            }
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z2 + " | frequency: " + i);
        }
        return z2;
    }

    protected boolean m29161a(String str, int i) {
        int i2 = 5;
        int a;
        if (str.equals("report_cgi")) {
            a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Common_CGIReportMaxcount");
            if (a != 0) {
                i2 = a;
            }
        } else if (str.equals("report_via")) {
            a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Agent_ReportBatchCount");
            if (a != 0) {
                i2 = a;
            }
        } else {
            i2 = 0;
        }
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        if (i >= i2) {
            return true;
        }
        return false;
    }

    protected int m29156a(int i) {
        int a;
        if (i == 0) {
            a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Common_CGIReportFrequencySuccess");
            if (a == 0) {
                return 10;
            }
            return a;
        }
        a = C6403p.m29203a(C6395h.m29184a(), null).m29212a("Common_CGIReportFrequencyFailed");
        if (a == 0) {
            return 100;
        }
        return a;
    }

    protected Bundle m29164c() {
        if (this.f22182c.size() == 0) {
            return null;
        }
        C6373b c6373b = (C6373b) this.f22182c.get(0);
        if (c6373b == null) {
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = (String) c6373b.f22171a.get("appid");
        Collection a = C6377f.m29151a().m29152a("report_cgi");
        if (a != null) {
            this.f22182c.addAll(a);
        }
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f22182c.size());
        if (this.f22182c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", "OpenSdk_2.9.1");
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", "V1_AND_OpenSDK_2.9.1_1077_RDM_B");
            bundle.putString(SMSKeyInfo.TAG_KEY, "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.f22182c.size(); i++) {
                c6373b = (C6373b) this.f22182c.get(i);
                bundle.putString(i + "_1", (String) c6373b.f22171a.get("apn"));
                bundle.putString(i + "_2", (String) c6373b.f22171a.get("frequency"));
                bundle.putString(i + "_3", (String) c6373b.f22171a.get("commandid"));
                bundle.putString(i + "_4", (String) c6373b.f22171a.get("resultCode"));
                bundle.putString(i + "_5", (String) c6373b.f22171a.get("timeCost"));
                bundle.putString(i + "_6", (String) c6373b.f22171a.get("reqSize"));
                bundle.putString(i + "_7", (String) c6373b.f22171a.get("rspSize"));
                bundle.putString(i + "_8", (String) c6373b.f22171a.get("detail"));
                bundle.putString(i + "_9", (String) c6373b.f22171a.get("uin"));
                bundle.putString(i + "_10", C6374c.m29143e(C6395h.m29184a()) + SNBConstant.FILTER + ((String) c6373b.f22171a.get("deviceInfo")));
            }
            C6367n.m29107b("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Throwable e) {
            C6367n.m29108b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle m29165d() {
        Collection a = C6377f.m29151a().m29152a("report_via");
        if (a != null) {
            this.f22183d.addAll(a);
        }
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f22183d.size());
        if (this.f22183d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f22183d) {
            JSONObject jSONObject = new JSONObject();
            C6373b c6373b = (C6373b) serializable;
            for (String str : c6373b.f22171a.keySet()) {
                try {
                    Object obj = (String) c6373b.f22171a.get(str);
                    if (obj == null) {
                        obj = "";
                    }
                    jSONObject.put(str, obj);
                } catch (Throwable e) {
                    C6367n.m29105a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        C6367n.m29107b("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (Throwable e2) {
            C6367n.m29105a("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void m29166e() {
        this.f22186g.execute(new C6383l(this));
    }

    public void m29160a(String str, String str2, Bundle bundle, boolean z) {
        C6408u.m29230a(new C6384m(this, bundle, str, z, str2));
    }
}
