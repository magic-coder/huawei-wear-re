package com.huawei.uploadlog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.LongSparseArray;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p188c.C2506b;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;

public class ExternalOperService extends Service {
    C2500b f8964a = new C2520c(this);

    public IBinder onBind(Intent intent) {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.onBind] <>");
        return this.f8964a;
    }

    public void onCreate() {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.onCreate] <>");
        super.onCreate();
        C2506b.m12452a().m12453a(getApplication());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("filePath");
            boolean booleanExtra = intent.getBooleanExtra("status", false);
            C2511g.m12481b("BETACLUB_SDK", "[ExternalOperService.onStartCommand] filePath:" + stringExtra);
            C2511g.m12481b("BETACLUB_SDK", "[ExternalOperService.onStartCommand] status:" + booleanExtra);
            m12397a(stringExtra, booleanExtra);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.onDestroy] <>");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.onUnbind] <>");
        return super.onUnbind(intent);
    }

    private void m12397a(String str, boolean z) {
        if (!StringUtils.isNullOrEmpty(str)) {
            LogUpload a = m12394a(str);
            if (a == null) {
                C2511g.m12481b("BETACLUB_SDK", "[ExternalOperService.setDBStatus] logUpload null");
            } else if (z) {
                m12398b(a);
            } else {
                m12399a(a);
            }
        }
    }

    private void m12398b(LogUpload logUpload) {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.pauseTask] <>");
        synchronized (C2507c.f8987a) {
            if (logUpload != null) {
                logUpload.setPaused(true);
                C2496a.m12418a(m12395a(), logUpload, true);
            }
        }
    }

    void m12399a(LogUpload logUpload) {
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.resumeTask] <>");
        synchronized (C2507c.f8987a) {
            if (logUpload != null) {
                logUpload.setPaused(false);
                C2496a.m12418a(m12395a(), logUpload, true);
            }
        }
    }

    private C2497b m12395a() {
        return new C2497b(C2506b.m12452a().m12455c());
    }

    private LogUpload m12394a(String str) {
        LogUpload logUpload;
        C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.getLogUploadByFilePath] <>");
        synchronized (C2507c.f8987a) {
            LongSparseArray a = C2496a.m12414a(m12395a());
            C2511g.m12477a("BETACLUB_SDK", "[ExternalOperService.getLogUploadByFilePath] listLogUpload.size():" + a.size());
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
}
