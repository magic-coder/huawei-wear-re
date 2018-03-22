package com.huawei.logupload;

import com.huawei.logupload.C1094a.C1096a;
import com.huawei.logupload.p088a.C1097a;
import com.huawei.logupload.p088a.C1098c;
import com.huawei.logupload.p090c.C1101b;
import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import java.util.List;

/* compiled from: ExternalOperService */
class C1100b extends C1096a {
    final /* synthetic */ ExternalOperService f2269a;

    C1100b(ExternalOperService externalOperService) {
        this.f2269a = externalOperService;
    }

    public boolean mo2354a(LogUpload logUpload) {
        C1103f.m4876a("ExternalOperDataBases", "updateStatus");
        C1098c c1098c = new C1098c(C1101b.m4858a().m4860b());
        synchronized (C1102c.f2274a) {
            if (logUpload != null) {
                C1103f.m4876a("ExternalOperDataBases", "mLogUpload.getIsPause() :" + logUpload.m4777c());
                C1097a.m4847a(c1098c, logUpload, true);
                return true;
            }
            return false;
        }
    }

    public List<LogUpload> mo2353a() {
        List<LogUpload> a;
        C1103f.m4876a("ExternalOperDataBases", "queryAllRecord");
        C1098c c1098c = new C1098c(C1101b.m4858a().m4860b());
        synchronized (C1102c.f2274a) {
            a = C1097a.m4844a(c1098c);
        }
        return a;
    }

    public String mo2355b(LogUpload logUpload) {
        C1103f.m4876a("ExternalOperDataBases", "getStatus");
        C1098c c1098c = new C1098c(C1101b.m4858a().m4860b());
        String str = "";
        synchronized (C1102c.f2274a) {
            if (logUpload != null) {
                str = C1097a.m4843a(c1098c, String.valueOf(logUpload.m4800i()));
            }
            C1103f.m4876a("ExternalOperDataBases", "isPause: " + str);
        }
        return str;
    }

    public void mo2356c(LogUpload logUpload) {
        C1103f.m4876a("ExternalOperDataBases", "cancelTask");
        if (logUpload != null) {
            C1110k.m4923a(logUpload, true);
        }
    }

    public LogUpload mo2352a(String str) {
        LogUpload b;
        C1098c c1098c = new C1098c(C1101b.m4858a().m4860b());
        synchronized (C1102c.f2274a) {
            b = C1097a.m4848b(c1098c, str);
        }
        return b;
    }
}
