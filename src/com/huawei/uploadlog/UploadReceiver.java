package com.huawei.uploadlog;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.LongSparseArray;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.uploadlog.p186a.C2496a;
import com.huawei.uploadlog.p186a.C2497b;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;

public class UploadReceiver extends BroadcastReceiver {
    static int f8967a = -100;
    private static Context f8968c = null;
    private String f8969b = "BETACLUB_SDK";

    public static Context m12405a() {
        return f8968c;
    }

    public static void m12407a(Context context) {
        f8968c = context;
        AppContext.getInstance().setApplication((Application) context.getApplicationContext());
    }

    public static void m12406a(int i) {
        f8967a = i;
    }

    public void onReceive(Context context, Intent intent) {
        m12407a(context);
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.huawei.crowdtestsdk.UPLOAD_CHECK")) {
            C2507c.m12461b(C2517m.m12561a(C2517m.m12562a(context)));
            C2507c.m12463c(C2517m.m12575b(context));
            C2511g.m12481b(this.f8969b, "[UploadReceiver.onReceive] netType=" + C2507c.m12467g());
            C2511g.m12481b(this.f8969b, "[UploadReceiver.onReceive] networkType=" + C2507c.m12466f());
            C2511g.m12481b(this.f8969b, "[UploadReceiver.onReceive] preNetStatus=" + f8967a);
            if (C2507c.m12466f() == f8967a) {
                C2511g.m12481b(this.f8969b, "[UploadReceiver.onReceive] 网络状态和之前的网络状态相同，因此不处理");
                return;
            }
            m12406a(C2507c.m12466f());
            if (C2507c.m12467g() == -1 || C2507c.m12466f() == 0) {
                C2511g.m12481b(this.f8969b, "[UploadReceiver.onReceive] Start to kill process!");
                C2511g.m12477a(this.f8969b, "[UploadReceiver.onReceive] msg5");
                m12411c();
            } else if (C2507c.m12460b() == 0) {
                C2517m.m12581c(context);
                new Thread(new C2528k(this)).start();
            }
        }
    }

    private void m12410b() {
        LongSparseArray a;
        C2497b c2497b = new C2497b(m12405a());
        synchronized (C2507c.f8987a) {
            a = C2496a.m12414a(c2497b);
        }
        Object obj = null;
        int size = a.size();
        C2511g.m12477a(this.f8969b, "[UploadReceiver.doRun] sizeLimit=" + size);
        if (size <= 0) {
            C2511g.m12477a(this.f8969b, "[UploadReceiver.doRun] msg4");
            m12411c();
            return;
        }
        int i = 0;
        while (i < size) {
            Object obj2;
            LogUpload logUpload = (LogUpload) a.valueAt(i);
            if (logUpload == null) {
                C2511g.m12477a(this.f8969b, "[UploadReceiver.doRun] logUpload == null");
                obj2 = obj;
            } else {
                long startTime = logUpload.getStartTime();
                C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] startTime=" + startTime);
                long currentTimeMillis = System.currentTimeMillis();
                C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] currentTimeMillis=" + currentTimeMillis);
                if (currentTimeMillis - startTime >= 259200000) {
                    C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] Begin to delete the task...");
                    C2517m.m12569a(logUpload);
                    C2517m.m12566a(m12405a(), logUpload, false);
                    C2517m.m12582c(logUpload);
                    synchronized (C2507c.f8987a) {
                        C2496a.m12421b(c2497b, logUpload);
                        C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun]Beyond days task, resubmit!");
                        String filePath = logUpload.getFilePath();
                        if (FileUtils.isFileExists(filePath)) {
                            C2513i.m12496a(f8968c, filePath, logUpload.getId(), logUpload.getSize(), logUpload.getFlags(), logUpload.getUserType(), logUpload.getChannelId());
                        }
                    }
                    obj2 = obj;
                } else {
                    int i2 = 0;
                    if (C2507c.m12462c() != null && C2507c.m12462c().size() > 0) {
                        i2 = C2517m.m12576b(logUpload);
                    }
                    if (i2 == 1 || i2 == 2) {
                        C2511g.m12481b(this.f8969b, "taskId:" + logUpload.getTaskId() + "status:" + i2);
                        obj2 = 1;
                    } else {
                        int flags = logUpload.getFlags();
                        C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] uploadFlags " + flags + "taskStatus" + i2);
                        i2 = flags & 1;
                        int i3 = flags & 2;
                        flags &= 4;
                        C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] flagWifi=" + i2 + ", flag3g=" + i3 + ", flag2g=" + flags);
                        if (C2507c.m12466f() != 1) {
                            C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] networkType " + C2507c.m12466f());
                            if (C2507c.m12466f() == 0) {
                                C2511g.m12477a(this.f8969b, "[UploadReceiver.doRun] CommonConstants.getNetworkType() == NetType.TYPE_UNKNOWN");
                                m12411c();
                                return;
                            } else if ((i3 == 2 || flags == 4) && !logUpload.isPaused()) {
                                obj2 = 1;
                                C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] Begin to start the thread...");
                                m12408a(logUpload, 3);
                            }
                        } else if (i2 == 1 && !logUpload.isPaused()) {
                            if (!(logUpload.getUserType() == 0 || logUpload.getUserType() == 2)) {
                                C2517m.m12584d();
                            }
                            obj2 = 1;
                            C2511g.m12481b(this.f8969b, "[UploadReceiver.doRun] Begin to start the thread...");
                            m12408a(logUpload, 3);
                        }
                        obj2 = obj;
                    }
                }
            }
            i++;
            obj = obj2;
        }
        if (obj == null) {
            C2511g.m12477a(this.f8969b, "[UploadReceiver.doRun] msg3");
            m12411c();
        }
    }

    private void m12408a(LogUpload logUpload, int i) {
        C2519o c2519o = new C2519o(Looper.getMainLooper());
        Message obtainMessage = c2519o.obtainMessage(i);
        obtainMessage.obj = logUpload;
        c2519o.sendMessage(obtainMessage);
    }

    private void m12411c() {
        C2507c.m12462c().clear();
        C2507c.m12457a(0);
        C2507c.m12463c(-1);
        C2507c.m12461b(0);
        m12406a(-100);
        C2511g.m12481b(this.f8969b, "[UploadReceiver.onNoTaskToRun] No task, start to kill process!");
        C2517m.m12585e();
        C2511g.m12481b(this.f8969b, "[UploadReceiver.onNoTaskToRun] myPid: " + Process.myPid());
        Intent intent = new Intent();
        intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
        intent.putExtra("packageName", "com.huawei.crowdtestsdk");
        intent.putExtra(JoinConstants.EXCEPTION, "1");
        m12405a().sendBroadcast(intent);
        Process.killProcess(Process.myPid());
    }
}
