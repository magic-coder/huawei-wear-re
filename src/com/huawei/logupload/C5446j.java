package com.huawei.logupload;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.huawei.logupload.a.a;
import com.huawei.logupload.a.c;
import com.huawei.logupload.c.b;
import com.huawei.logupload.c.f;
import com.huawei.logupload.c.h;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.util.List;

/* compiled from: UploadReceiver */
class C5446j implements Runnable {
    final /* synthetic */ UploadReceiver f19278a;

    C5446j(UploadReceiver uploadReceiver) {
        this.f19278a = uploadReceiver;
    }

    public void run() {
        c cVar = new c(UploadReceiver.m26063a());
        synchronized (com.huawei.logupload.c.c.a) {
            List a = a.a(cVar);
        }
        Object obj = null;
        Intent intent;
        if (a.size() > 0) {
            int size = a.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                long z = ((LogUpload) a.get(i)).z();
                f.b(this.f19278a.f19264a, "startTime=" + z);
                long currentTimeMillis = System.currentTimeMillis();
                f.b(this.f19278a.f19264a, "currentTimeMillis=" + currentTimeMillis);
                Intent intent2;
                if (currentTimeMillis - z >= 259200000) {
                    f.b(this.f19278a.f19264a, "Begin to delete the task...");
                    LogUpload logUpload = (LogUpload) a.get(i);
                    h.a(logUpload);
                    String C = logUpload.C();
                    if ("com.huawei.lcagent".equals(C) || "com.huawei.hidp".equals(C) || "com.huawei.imonitor".equals(C)) {
                        h.a(UploadReceiver.m26063a(), logUpload, false);
                    } else if (com.huawei.logupload.c.c.i() != 1) {
                        Intent intent3 = new Intent();
                        intent3.setPackage(C);
                        intent3.setAction("com.example.logupload.progressSmall");
                        intent3.putExtra("mLogUploadInfo", logUpload);
                        UploadReceiver.m26063a().sendBroadcast(intent3);
                    } else {
                        intent2 = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                        intent2.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
                        intent2.putExtra("isuploadsuccess", false);
                        b.a().b().startService(intent2);
                    }
                    h.b(new StringBuilder(String.valueOf(logUpload.f())).toString());
                    synchronized (com.huawei.logupload.c.c.a) {
                        a.b(cVar, logUpload);
                    }
                    obj2 = obj;
                } else {
                    int i2;
                    if (com.huawei.logupload.c.c.c() == null || com.huawei.logupload.c.c.c().size() <= 0) {
                        i2 = 0;
                    } else {
                        f.d(this.f19278a.f19264a, "CommonConstants.getTaskList() " + com.huawei.logupload.c.c.c() + "lstUploadInfo.get(i) " + a.get(i));
                        if (a.get(i) != null) {
                            f.d(this.f19278a.f19264a, "lstUploadInfo.get(i).getTaskId() " + ((LogUpload) a.get(i)).f());
                        }
                        i2 = h.a(new StringBuilder(String.valueOf(((LogUpload) a.get(i)).f())).toString());
                    }
                    if (i2 == 1 || i2 == 2) {
                        f.b(this.f19278a.f19264a, "taskId:" + ((LogUpload) a.get(i)).f() + "status:" + i2);
                        obj2 = 1;
                    } else {
                        int l = ((LogUpload) a.get(i)).l();
                        f.b(this.f19278a.f19264a, "uploadFlags " + l + "taskStatus" + i2);
                        i2 = l & 1;
                        int i3 = l & 2;
                        l &= 4;
                        f.b(this.f19278a.f19264a, "flagWifi " + i2 + "flag3g" + i3 + "flag2g" + l);
                        h.a aVar;
                        Message obtainMessage;
                        if (com.huawei.logupload.c.c.f() != 1) {
                            f.b(this.f19278a.f19264a, "networkType " + com.huawei.logupload.c.c.f());
                            if (com.huawei.logupload.c.c.f() == 0) {
                                h.e();
                                f.b(this.f19278a.f19264a, "myPid: " + Process.myPid());
                                if (com.huawei.logupload.c.c.i() != 1) {
                                    intent2 = new Intent();
                                    intent2.setAction("com.example.logupload.progress");
                                    intent2.setPackage(UploadReceiver.m26063a().getPackageName());
                                    intent2.putExtra(JoinConstants.EXCEPTION, "1");
                                    f.a(JoinConstants.EXCEPTION, "1");
                                    UploadReceiver.m26063a().sendBroadcast(intent2);
                                } else {
                                    intent2 = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                                    intent2.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
                                    intent2.putExtra("isuploadsuccess", false);
                                    b.a().b().startService(intent2);
                                }
                                com.huawei.logupload.c.c.c().clear();
                                com.huawei.logupload.c.c.a(0);
                                com.huawei.logupload.c.c.c(-1);
                                com.huawei.logupload.c.c.b(0);
                                UploadReceiver.m26065a(-100);
                            }
                            if (i3 == 2 || l == 4) {
                                obj2 = 1;
                                f.b(this.f19278a.f19264a, "Begin to start the thread...");
                                aVar = new h.a(Looper.getMainLooper());
                                obtainMessage = aVar.obtainMessage(3);
                                obtainMessage.obj = a.get(i);
                                aVar.sendMessage(obtainMessage);
                            }
                        } else if (i2 == 1) {
                            if (!(((LogUpload) a.get(i)).F() == 0 || ((LogUpload) a.get(i)).F() == 2 || ((LogUpload) a.get(i)).F() == 4)) {
                                h.d();
                            }
                            obj2 = 1;
                            f.b(this.f19278a.f19264a, "Begin to start the thread...");
                            aVar = new h.a(Looper.getMainLooper());
                            obtainMessage = aVar.obtainMessage(3);
                            obtainMessage.obj = a.get(i);
                            aVar.sendMessage(obtainMessage);
                        }
                        obj2 = obj;
                    }
                }
                i++;
                obj = obj2;
            }
            if (obj == null) {
                f.b(this.f19278a.f19264a, "No task，start to kill process!");
                f.b(this.f19278a.f19264a, "myPid: " + Process.myPid());
                if (com.huawei.logupload.c.c.i() != 1) {
                    intent = new Intent();
                    intent.setAction("com.example.logupload.progress");
                    intent.setPackage(UploadReceiver.m26063a().getPackageName());
                    intent.putExtra(JoinConstants.EXCEPTION, "1");
                    f.a(JoinConstants.EXCEPTION, "1");
                    UploadReceiver.m26063a().sendBroadcast(intent);
                } else {
                    intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                    intent.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
                    intent.putExtra("isuploadsuccess", false);
                    b.a().b().startService(intent);
                }
                com.huawei.logupload.c.c.c().clear();
                com.huawei.logupload.c.c.a(0);
                com.huawei.logupload.c.c.c(-1);
                com.huawei.logupload.c.c.b(0);
                UploadReceiver.m26065a(-100);
                return;
            }
            return;
        }
        f.b(this.f19278a.f19264a, "Start to kill process!");
        f.b(this.f19278a.f19264a, "myPid: " + Process.myPid());
        if (com.huawei.logupload.c.c.i() != 1) {
            intent = new Intent();
            intent.setAction("com.example.logupload.progress");
            intent.setPackage(UploadReceiver.m26063a().getPackageName());
            intent.putExtra(JoinConstants.EXCEPTION, "1");
            f.a(JoinConstants.EXCEPTION, "1");
            UploadReceiver.m26063a().sendBroadcast(intent);
        } else {
            intent = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
            intent.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
            intent.putExtra("isuploadsuccess", false);
            b.a().b().startService(intent);
        }
        com.huawei.logupload.c.c.c().clear();
        com.huawei.logupload.c.c.a(0);
        com.huawei.logupload.c.c.c(-1);
        com.huawei.logupload.c.c.b(0);
        UploadReceiver.m26065a(-100);
    }
}
