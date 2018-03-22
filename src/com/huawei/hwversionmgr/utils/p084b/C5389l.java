package com.huawei.hwversionmgr.utils.p084b;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.huawei.hwversionmgr.a.e;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.IOException;

/* compiled from: DownloadService */
public class C5389l implements Runnable {
    private final String f19164a = "DownloadService";
    private Context f19165b;
    private Handler f19166c;
    private Boolean f19167d;

    public C5389l(Context context, Handler handler, Boolean bool) {
        this.f19165b = context;
        this.f19166c = handler;
        this.f19167d = bool;
    }

    public void run() {
        C2538c.b("DownloadService", new Object[]{"DownloadService run"});
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            C2538c.b("DownloadService", new Object[]{"Exception is " + e.getMessage()});
        }
        C2538c.b("DownloadService", new Object[]{"DownloadService set cancel download flag"});
        C5390m.m25937a(false);
        try {
            Thread.sleep(2200);
        } catch (InterruptedException e2) {
            C2538c.b("DownloadService", new Object[]{"Exception is " + e2.getMessage()});
        }
        C2538c.b("DownloadService", new Object[]{"DownloadService init download state"});
        com.huawei.hwversionmgr.utils.c.a(-1);
        try {
            m25925b();
            while (com.huawei.hwversionmgr.utils.c.f() != 1) {
                if (com.huawei.hwversionmgr.utils.c.f() == 0) {
                    try {
                        C2538c.b("DownloadService", new Object[]{"DOWNLOADING_STATE_START"});
                        Thread.sleep(2000);
                    } catch (InterruptedException e22) {
                        C2538c.e("DownloadService", new Object[]{"InterruptedException e:" + e22.getMessage()});
                    }
                } else if (com.huawei.hwversionmgr.utils.c.f() != 3 || !m25924a()) {
                    if (com.huawei.hwversionmgr.utils.c.b(this.f19165b)) {
                        C2538c.b("DownloadService", new Object[]{"DonwloadService NetworkAvailable"});
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e222) {
                            C2538c.b("DownloadService", new Object[]{"Exception is " + e222.getMessage()});
                        }
                        synchronized (C5389l.class) {
                            if (com.huawei.hwversionmgr.utils.c.e()) {
                                C2538c.b("DownloadService", new Object[]{"DonwloadService downloadThread already running,do not start new download"});
                            } else {
                                C2538c.b("DownloadService", new Object[]{"DonwloadService start downloadThread"});
                                com.huawei.hwversionmgr.utils.c.a(0);
                                new Thread(new C5390m(this.f19165b, this.f19166c, this.f19167d)).start();
                                com.huawei.hwversionmgr.utils.c.a(true);
                            }
                        }
                    } else {
                        com.huawei.hwversionmgr.utils.c.a(3);
                    }
                } else {
                    return;
                }
            }
            C2538c.b("DownloadService", new Object[]{"DownloadService DOWNLOADING_STATE_END"});
        } catch (RuntimeException e3) {
            C2538c.b("DownloadService", new Object[]{"RuntimeException e1:" + e3.getMessage()});
        } catch (Exception e4) {
            C2538c.b("DownloadService", new Object[]{"Exception  e :" + e4.getMessage()});
        }
    }

    private boolean m25924a() {
        int g = com.huawei.hwversionmgr.utils.c.g();
        C2538c.b("DownloadService", new Object[]{"retryNum is " + g});
        if (g < 3) {
            try {
                C2538c.b("DownloadService", new Object[]{"DOWNLOADING_STATE_RETRY, retry in 10S,current retryNum is " + g});
                Thread.sleep(5000);
                com.huawei.hwversionmgr.utils.c.b(g + 1);
                return false;
            } catch (InterruptedException e) {
                C2538c.e("DownloadService", new Object[]{"InterruptedException e = " + e.getMessage()});
                return false;
            }
        }
        C2538c.b("DownloadService", new Object[]{"DOWNLOADING_STATE_RETRY, retryOver,so stop send message DOWNLOAD_FAILED_CONNECT_ERROR"});
        com.huawei.hwversionmgr.utils.c.a(1);
        m25923a(null, 3);
        return true;
    }

    private void m25925b() throws IOException {
        String str = m25922a(this.f19167d).j;
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            m25922a(this.f19167d).z = externalStorageDirectory.getCanonicalPath() + File.separator + "download" + File.separator + str;
        } else {
            m25922a(this.f19167d).z = this.f19165b.getFilesDir() + File.separator + str;
        }
        C2538c.b("DownloadService", new Object[]{"apk storage path=" + m25922a(this.f19167d).z + "; mContext.getFilesDir() + File.separator =" + this.f19165b.getFilesDir() + File.separator});
        com.huawei.hwversionmgr.utils.c.d(m25922a(this.f19167d).z);
        com.huawei.hwversionmgr.utils.c.b(0);
    }

    private void m25923a(Object obj, int i) {
        if (this.f19166c != null) {
            Message message = new Message();
            message.obj = obj;
            message.what = i;
            this.f19166c.sendMessage(message);
        }
    }

    private e m25922a(Boolean bool) {
        if (bool.booleanValue()) {
            return com.huawei.hwversionmgr.utils.c.i();
        }
        return com.huawei.hwversionmgr.utils.c.j();
    }
}
