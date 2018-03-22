package com.huawei.logupload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.logupload.c.b;
import com.huawei.logupload.c.c;
import com.huawei.logupload.c.f;
import com.huawei.logupload.c.h;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;

public class UploadReceiver extends BroadcastReceiver {
    private static int f19262b = -100;
    private static Context f19263c = null;
    private String f19264a = "UploadReceiver";

    public static Context m26063a() {
        return f19263c;
    }

    public static void m26066a(Context context) {
        f19263c = context;
    }

    public static void m26065a(int i) {
        f19262b = i;
    }

    public void onReceive(Context context, Intent intent) {
        m26066a(context);
        if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            c.b(h.a(h.d(context)));
            c.c(h.e(context));
            f.b(this.f19264a, new StringBuilder(HwAccountConstants.EXTRA_OPLOG_NETTYPE).append(c.g()).toString());
            f.b(this.f19264a, "networkType is " + c.f());
            f.b(this.f19264a, "preNetStaus is " + f19262b);
            if (c.f() == f19262b) {
                f.b(this.f19264a, "网络状态和之前的网络状态相同，因此不处理");
                return;
            }
            m26065a(c.f());
            Intent intent2;
            if (c.g() == -1 || c.f() == 0) {
                f.b(this.f19264a, "Start to kill process!");
                c.c().clear();
                c.a(0);
                c.c(-1);
                c.b(0);
                m26065a(-100);
                f.b(this.f19264a, "myPid: " + Process.myPid());
                if (c.i() != 1) {
                    intent2 = new Intent();
                    intent2.setAction("com.example.logupload.progress");
                    intent2.setPackage(context.getPackageName());
                    intent2.putExtra(JoinConstants.EXCEPTION, "1");
                    f.a(JoinConstants.EXCEPTION, "1");
                    context.sendBroadcast(intent2);
                    return;
                }
                intent2 = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                intent2.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
                intent2.putExtra("isuploadsuccess", false);
                b.a().b().startService(intent2);
            } else if (VERSION.SDK_INT > 22 && !h.a(context.getPackageManager(), "android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName())) {
                f.b(this.f19264a, "No permission!");
                c.c().clear();
                c.a(0);
                c.c(-1);
                c.b(0);
                m26065a(-100);
                f.b(this.f19264a, "myPid: " + Process.myPid());
                if (c.i() != 1) {
                    intent2 = new Intent();
                    intent2.setAction("com.example.logupload.progress");
                    intent2.setPackage(context.getPackageName());
                    intent2.putExtra(JoinConstants.EXCEPTION, "1");
                    f.a(JoinConstants.EXCEPTION, "1");
                    context.sendBroadcast(intent2);
                    return;
                }
                intent2 = new Intent("com.huawei.phoneservice.AUTOUPLOAD_DELETE");
                intent2.setClassName(b.a().b(), "com.huawei.feedback.component.AutoUploadService");
                intent2.putExtra("isuploadsuccess", false);
                b.a().b().startService(intent2);
            } else if (c.b() == 0) {
                h.f(context);
                new Thread(new C5446j(this)).start();
            }
        }
    }
}
