package com.huawei.uploadlog;

import android.os.RemoteException;
import android.util.LongSparseArray;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExternalOperService */
class C2520c extends C2500b {
    final /* synthetic */ ExternalOperService f9002a;

    C2520c(ExternalOperService externalOperService) {
        this.f9002a = externalOperService;
    }

    public boolean mo2665a(LogUpload logUpload) throws RemoteException {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.updateStatus] <>");
        if (logUpload != null) {
            return false;
        }
        synchronized (C2507c.f8987a) {
            C2496a.m12418a(this.f9002a.m12395a(), null, true);
        }
        return true;
    }

    public List<LogUpload> mo2664a() throws RemoteException {
        List<LogUpload> arrayList;
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.queryAllRecord] <>");
        synchronized (C2507c.f8987a) {
            LongSparseArray a = C2496a.m12414a(this.f9002a.m12395a());
            arrayList = new ArrayList();
            for (int i = 0; i < a.size(); i++) {
                arrayList.add(a.valueAt(i));
            }
        }
        return arrayList;
    }

    public LogUpload mo2663a(String str) throws RemoteException {
        LogUpload logUpload;
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.queryRecordByFilePath] <>");
        synchronized (C2507c.f8987a) {
            LongSparseArray a = C2496a.m12414a(this.f9002a.m12395a());
            for (int i = 0; i < a.size(); i++) {
                logUpload = (LogUpload) a.valueAt(i);
                if (str.equalsIgnoreCase(logUpload.getFilePath())) {
                    break;
                }
            }
            logUpload = null;
        }
        return logUpload;
    }

    public String mo2667b(LogUpload logUpload) throws RemoteException {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.getStatus] <>");
        String str = "";
        synchronized (C2507c.f8987a) {
            if (logUpload != null) {
                str = C2496a.m12415a(this.f9002a.m12395a(), String.valueOf(logUpload.getId()));
            }
            C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.getStatus] isPause: " + str);
        }
        return str;
    }

    public void mo2668c(LogUpload logUpload) throws RemoteException {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.cancelTask] <>");
        if (logUpload != null) {
            C2529l.m12606a(logUpload, true);
        }
    }

    public void mo2669d(LogUpload logUpload) throws RemoteException {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.pauseTask] <>");
        synchronized (C2507c.f8987a) {
            if (logUpload != null) {
                logUpload.setPaused(true);
                C2529l.m12610c(logUpload);
                C2496a.m12418a(this.f9002a.m12395a(), logUpload, true);
            }
        }
    }

    public void mo2670e(LogUpload logUpload) throws RemoteException {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.resumeTask] <>");
        synchronized (C2507c.f8987a) {
            if (logUpload != null) {
                logUpload.setPaused(false);
                C2529l.m12611d(logUpload);
                C2496a.m12418a(this.f9002a.m12395a(), logUpload, true);
            }
        }
    }

    public LogUpload mo2666b(String str) throws RemoteException {
        LogUpload b;
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.selectLogUpload] <>");
        synchronized (C2507c.f8987a) {
            b = C2496a.m12419b(this.f9002a.m12395a(), str);
        }
        return b;
    }
}
