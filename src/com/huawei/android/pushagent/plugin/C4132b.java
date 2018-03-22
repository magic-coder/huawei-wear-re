package com.huawei.android.pushagent.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushReceiver$BOUND_KEY;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4102h;
import com.huawei.android.pushagent.plugin.p331a.C4125a;
import com.huawei.android.pushagent.plugin.p331a.C4126b;
import com.huawei.android.pushagent.plugin.p331a.C4127c;
import com.huawei.android.pushagent.plugin.p331a.C4128d;
import com.huawei.android.pushagent.plugin.p331a.C4129e;
import com.huawei.android.pushagent.plugin.tools.C4142a;
import com.huawei.android.pushagent.plugin.tools.p335b.C4145a;
import java.util.Date;
import org.apache.log4j.helpers.FileWatchdog;
import org.json.JSONArray;
import org.json.JSONObject;

public class C4132b {
    private Context f15533a;
    private int f15534b = 0;
    private C4125a f15535c;

    public C4132b(Context context) {
        this.f15533a = context;
        this.f15535c = new C4125a(context);
    }

    private String m20199a(Context context) {
        e.b("PushLogSC2712", "begin to fetch salt");
        String a = C4145a.m20242a(context, C4142a.m20231b(context));
        if (a == null) {
            return null;
        }
        C4129e c4129e = new C4129e();
        c4129e.m20193a(a);
        e.a("PushLogSC2712", " saltValue reponse");
        if (c4129e.m20195c() > 0) {
            this.f15535c.a("minUp", Long.valueOf(c4129e.m20195c()));
        }
        if (c4129e.m20196d() > 0) {
            this.f15535c.a("maxUp", Long.valueOf(c4129e.m20196d()));
        }
        if (c4129e.m20194b() > -1) {
            this.f15535c.a("belongId", Integer.valueOf(c4129e.m20194b()));
        }
        if (TextUtils.isEmpty(c4129e.m20192a())) {
            e.b("PushLogSC2712", "fetch salt fail");
            return null;
        }
        this.f15535c.m20173a(c4129e.m20192a());
        return String.valueOf(c4129e.m20192a().hashCode());
    }

    private void m20200a(Context context, int i, boolean z) {
        context.sendBroadcast(new Intent("com.huawei.android.push.plugin.RESPONSE").putExtra(PushReceiver$BOUND_KEY.PLUGINREPORTTYPE, i).putExtra(PushReceiver$BOUND_KEY.PLUGINREPORTRESULT, z).putExtra("reportExtra", new Bundle()).setPackage(this.f15533a.getPackageName()));
    }

    private void m20201a(String str) {
        e.a("PushLogSC2712", "add tags failed, need remove local tags");
        m20202a(str, 1);
    }

    private void m20202a(String str, int i) {
        try {
            JSONArray b = C4103b.m20125b(str);
            if (b != null) {
                h hVar = new h(this.f15533a, "tags_info");
                int length = b.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = b.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("tagKey");
                        if (i == optJSONObject.optInt("opType")) {
                            hVar.f(optString);
                            e.a("PushLogSC2712", "delete local tags:" + optJSONObject.toString());
                        }
                    }
                }
            }
        } catch (Throwable e) {
            e.c("PushLogSC2712", "delete tags error:" + e.getMessage(), e);
        }
    }

    private boolean m20203a() {
        return !TextUtils.isEmpty(this.f15535c.m20171a());
    }

    private void m20204b(String str) {
        e.a("PushLogSC2712", "delect tags success, need remove local tags");
        m20202a(str, 2);
    }

    public void m20205a(String str, int i, int i2) {
        try {
            if (-1 == C4103b.m20122a(this.f15533a)) {
                e.b("PushLogSC2712", "network unavailable");
                m20200a(this.f15533a, i, false);
                if (C4126b.TAG.m20181b() == i) {
                    m20201a(str);
                    return;
                }
                return;
            }
            long b = this.f15535c.b("delayTime", 0);
            if (0 == b || b <= System.currentTimeMillis()) {
                this.f15535c.m20178c("delayTime");
                if (TextUtils.isEmpty(str)) {
                    m20200a(this.f15533a, i, false);
                    return;
                }
                Object b2 = C4142a.m20231b(this.f15533a);
                if (TextUtils.isEmpty(b2)) {
                    e.b("PushLogSC2712", "token is null, need to register and get deviceToken");
                    C4142a.m20230a(this.f15533a, new C4135c(this, str, i, i2));
                    return;
                }
                Object valueOf;
                if (m20203a()) {
                    valueOf = String.valueOf(this.f15535c.m20171a().hashCode());
                } else {
                    e.b("PushLogSC2712", "salt is null, need to get salt");
                    valueOf = m20199a(this.f15533a);
                }
                if (TextUtils.isEmpty(valueOf)) {
                    m20200a(this.f15533a, i, false);
                    if (C4126b.TAG.m20181b() == i) {
                        m20201a(str);
                        return;
                    }
                    return;
                }
                int i3;
                String a = C4145a.m20241a(this.f15533a, new C4127c(C4102h.m20120a(b2), i2, valueOf, str, this.f15533a));
                C4128d c4128d = new C4128d();
                if (a == null) {
                    i3 = -1;
                } else {
                    c4128d.m20190a(a);
                    i3 = c4128d.m20189a();
                    e.a("PushLogSC2712", "ReportRsp is " + c4128d.toString());
                }
                if (1 != i3 || this.f15534b >= 3) {
                    this.f15534b = 0;
                    if (i3 == 0) {
                        m20200a(this.f15533a, i, true);
                        if (C4126b.LBS.m20181b() == i) {
                            this.f15535c.m20172a(System.currentTimeMillis());
                            return;
                        } else if (C4126b.TAG.m20181b() == i) {
                            m20204b(str);
                            return;
                        } else {
                            return;
                        }
                    } else if (3 == i3) {
                        m20200a(this.f15533a, i, true);
                        i3 = Integer.parseInt(c4128d.m20191b());
                        this.f15535c.a("delayTime", Long.valueOf((((long) i3) * FileWatchdog.DEFAULT_DELAY) + System.currentTimeMillis()));
                        e.a("PushLogSC2712", "please report after " + i3 + "min");
                        return;
                    } else {
                        m20200a(this.f15533a, i, false);
                        if (C4126b.TAG.m20181b() == i) {
                            m20201a(str);
                            return;
                        }
                        return;
                    }
                }
                e.b("PushLogSC2712", "salt has expired, need re-fetch");
                this.f15534b++;
                this.f15535c.m20176b();
                m20205a(str, i, i2);
                return;
            }
            e.b("PushLogSC2712", "you can not repotr before " + new Date(b));
            m20200a(this.f15533a, i, false);
            if (C4126b.TAG.m20181b() == i) {
                m20201a(str);
            }
        } catch (Throwable e) {
            m20200a(this.f15533a, i, false);
            if (C4126b.TAG.m20181b() == i) {
                m20201a(str);
            }
            e.c("PushLogSC2712", e.getMessage(), e);
        }
    }
}
