package com.huawei.logupload;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.huawei.logupload.p088a.C1097a;
import com.huawei.logupload.p088a.C1098c;
import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.logupload.p090c.C1105h;
import com.huawei.logupload.p090c.C1105h.C1104a;
import java.util.List;

/* compiled from: LogUploadService */
class C1107d implements Runnable {
    final /* synthetic */ LogUploadService f2284a;
    private final /* synthetic */ Context f2285b;

    C1107d(LogUploadService logUploadService, Context context) {
        this.f2284a = logUploadService;
        this.f2285b = context;
    }

    public void run() {
        C1098c c1098c = new C1098c(this.f2285b);
        Object obj = null;
        synchronized (C1102c.f2274a) {
            List a = C1097a.m4844a(c1098c);
        }
        if (a.size() > 0) {
            int size = a.size();
            C1103f.m4880d("LogUpload Service", " sizeLimit " + size);
            int i = 0;
            while (i < size) {
                Object obj2;
                long z = ((LogUpload) a.get(i)).m4826z();
                C1103f.m4878b("LogUpload Service", new StringBuilder(String.valueOf(i)).append(" size ").append(((LogUpload) a.get(i)).m4802j()).toString());
                C1103f.m4878b("LogUpload Service", "startTime=" + z);
                long currentTimeMillis = System.currentTimeMillis();
                C1103f.m4878b("LogUpload Service", "currentTimeMillis=" + currentTimeMillis);
                if (currentTimeMillis - z >= 259200000) {
                    C1103f.m4878b("LogUpload Service", "Begin to delete the task...");
                    C1110k.m4923a((LogUpload) a.get(i), false);
                    obj2 = obj;
                } else {
                    int i2;
                    if (C1102c.m4867c() == null || C1102c.m4867c().size() <= 0) {
                        i2 = 0;
                    } else {
                        C1103f.m4880d("LogUpload Service", "CommonConstants.getTaskList() " + C1102c.m4867c() + "CommonConstants.getTaskList().size() " + C1102c.m4867c().size());
                        if (a.get(i) != null) {
                            C1103f.m4880d("LogUpload Service", "lstUploadInfo.get(i).getTaskId() " + ((LogUpload) a.get(i)).m4791f());
                        }
                        C1103f.m4880d("LogUpload Service", "CommonConstants.getTaskList() " + C1102c.m4867c());
                        i2 = C1105h.m4884a(new StringBuilder(String.valueOf(((LogUpload) a.get(i)).m4791f())).toString());
                    }
                    if (i2 == 1 || i2 == 2) {
                        C1103f.m4878b("LogUpload Service", "taskId:" + ((LogUpload) a.get(i)).m4791f() + "status:" + i2);
                        obj2 = 1;
                    } else {
                        int l = ((LogUpload) a.get(i)).m4806l();
                        C1103f.m4878b("LogUpload Service", "uploadFlags " + l + "taskStatus" + i2);
                        i2 = l & 1;
                        int i3 = l & 2;
                        l &= 4;
                        C1103f.m4878b("LogUpload Service", "flagWifi " + i2 + "flag3g" + i3 + "flag2g" + l);
                        C1104a c1104a;
                        Message obtainMessage;
                        if (C1102c.m4872f() != 1) {
                            C1103f.m4878b("LogUpload Service", "networkType " + C1102c.m4872f());
                            if (i3 == 2 || l == 4) {
                                obj2 = 1;
                                C1103f.m4878b("LogUpload Service", "Begin to start the thread...");
                                c1104a = new C1104a(Looper.getMainLooper());
                                obtainMessage = c1104a.obtainMessage(2);
                                obtainMessage.obj = a.get(i);
                                obtainMessage.arg1 = LogUploadService.m4827a();
                                c1104a.sendMessage(obtainMessage);
                            }
                        } else if (i2 == 1) {
                            if (!(((LogUpload) a.get(i)).m4763F() == 0 || ((LogUpload) a.get(i)).m4763F() == 2 || ((LogUpload) a.get(i)).m4763F() == 4)) {
                                C1105h.m4908d();
                            }
                            obj2 = 1;
                            C1103f.m4878b("LogUpload Service", "Begin to start the thread...");
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(2);
                            obtainMessage.obj = a.get(i);
                            obtainMessage.arg1 = LogUploadService.m4827a();
                            c1104a.sendMessage(obtainMessage);
                        }
                        obj2 = obj;
                    }
                }
                i++;
                obj = obj2;
            }
            if (obj == null) {
                C1103f.m4878b("LogUpload Service", "No task，start to kill process!");
                C1104a c1104a2 = new C1104a(Looper.getMainLooper());
                Message obtainMessage2 = c1104a2.obtainMessage(0);
                Bundle bundle = new Bundle();
                bundle.putString("packagename", this.f2285b.getPackageName());
                obtainMessage2.setData(bundle);
                c1104a2.sendMessage(obtainMessage2);
                return;
            }
            return;
        }
        C1103f.m4878b("LogUpload Service", "Start to kill process!");
        c1104a2 = new C1104a(Looper.getMainLooper());
        obtainMessage2 = c1104a2.obtainMessage(0);
        bundle = new Bundle();
        bundle.putString("packagename", this.f2285b.getPackageName());
        obtainMessage2.setData(bundle);
        c1104a2.sendMessage(obtainMessage2);
    }
}
