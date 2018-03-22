package com.huawei.uploadlog;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.LongSparseArray;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;

/* compiled from: LogUploadService */
class C2522e implements Runnable {
    final /* synthetic */ Context f9003a;
    final /* synthetic */ LogUploadService f9004b;

    C2522e(LogUploadService logUploadService, Context context) {
        this.f9004b = logUploadService;
        this.f9003a = context;
    }

    public void run() {
        C2497b c2497b = new C2497b(this.f9003a);
        synchronized (C2507c.f8987a) {
            LongSparseArray a = C2496a.m12414a(c2497b);
        }
        if (a == null || a.size() <= 0) {
            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Start to kill process!");
            C2519o c2519o = new C2519o(Looper.getMainLooper());
            c2519o.sendMessage(c2519o.obtainMessage(0));
            return;
        }
        int size = a.size();
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload]  sizeLimit " + size);
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            LogUpload logUpload = (LogUpload) a.valueAt(i);
            if (logUpload == null) {
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload]  logUpload == null");
                z2 = z;
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] task id=" + logUpload.getId());
                long startTime = logUpload.getStartTime();
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] i=" + i + ", size=" + logUpload.getSize());
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] startTime=" + startTime);
                long currentTimeMillis = System.currentTimeMillis();
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] currentTimeMillis=" + currentTimeMillis);
                if (logUpload.isPaused()) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Paused tasks do NOT resume automatically.");
                    z2 = z;
                } else if (currentTimeMillis - startTime >= 259200000) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Begin to delete the task...");
                    C2529l.m12606a(logUpload, false);
                    z2 = z;
                } else {
                    int b = C2517m.m12576b(logUpload);
                    if (b == 1 || b == 2) {
                        C2511g.m12481b("BETACLUB_SDK", "taskId:" + logUpload.getTaskId() + "status:" + b);
                        z2 = true;
                    } else {
                        b = logUpload.getFlags();
                        int i2 = b & 1;
                        int i3 = b & 2;
                        b &= 4;
                        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] flagWifi=" + i2 + ", flag3g=" + i3 + ", flag2g=" + b);
                        Message obtainMessage;
                        if (C2507c.m12466f() != 1) {
                            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] networkType " + C2507c.m12466f());
                            if (i3 == 2 || b == 4) {
                                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Begin to start the thread...");
                                c2519o = new C2519o(Looper.getMainLooper());
                                obtainMessage = c2519o.obtainMessage(2);
                                obtainMessage.obj = a.valueAt(i);
                                obtainMessage.arg1 = LogUploadService.m12400a();
                                c2519o.sendMessage(obtainMessage);
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                        } else if (i2 != 1) {
                            z2 = z;
                        } else {
                            if (!(logUpload.getUserType() == 0 || logUpload.getUserType() == 2)) {
                                C2517m.m12584d();
                            }
                            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Begin to start the thread...");
                            c2519o = new C2519o(Looper.getMainLooper());
                            obtainMessage = c2519o.obtainMessage(2);
                            obtainMessage.obj = a.valueAt(i);
                            obtainMessage.arg1 = LogUploadService.m12400a();
                            c2519o.sendMessage(obtainMessage);
                            z2 = true;
                        }
                    }
                }
            }
            i++;
            z = z2;
        }
        if (!z) {
            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] No task, start to kill process!");
            c2519o = new C2519o(Looper.getMainLooper());
            c2519o.sendMessage(c2519o.obtainMessage(0));
        }
    }
}
