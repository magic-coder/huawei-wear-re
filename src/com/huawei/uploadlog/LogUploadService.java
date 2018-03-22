package com.huawei.uploadlog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.uploadlog.p187b.C2499a;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2517m;
import com.huawei.uploadlog.p188c.C2519o;

public class LogUploadService extends Service {
    private static int f8965b = 0;
    private Handler f8966a = null;

    public static int m12400a() {
        return f8965b;
    }

    public static void m12402a(int i) {
        f8965b = i;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.onCreate] <>");
        super.onCreate();
        AppContext.getInstance().setApplication(getApplication());
    }

    public void onDestroy() {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.onDestroy] <>");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.onStartCommand] <>");
        if (intent == null || intent.getExtras() == null) {
            return 2;
        }
        String action = intent.getAction();
        if ("com.huawei.crowdtestsdk.RESUME_UPLOAD".equals(action)) {
            return m12401a(intent);
        }
        if (SdkConstants.ACTION_UPLOAD_REQUEST_INTENT.equals(action)) {
            return m12404b(intent);
        }
        return 2;
    }

    private int m12401a(Intent intent) {
        int i = 1;
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] <>");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Bundle Null!");
        } else {
            int i2 = extras.getInt("reason");
            Context application = AppContext.getInstance().getApplication();
            if (C2507c.m12460b() == 0 || C2507c.m12460b() == 3 || C2507c.m12460b() == 2) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        i = 2;
                    } else {
                        i = i2;
                    }
                }
                m12402a(i);
                C2507c.m12461b(C2517m.m12561a(C2517m.m12562a(application)));
                C2507c.m12463c(C2517m.m12575b(application));
                if (C2507c.m12467g() == -1 || C2507c.m12466f() == 0) {
                    C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload] Start to kill process!");
                    C2507c.m12462c().clear();
                    C2507c.m12457a(0);
                    C2517m.m12585e();
                    C2519o c2519o = new C2519o(Looper.getMainLooper());
                    c2519o.sendMessage(c2519o.obtainMessage(0));
                } else {
                    C2517m.m12581c(application);
                    new Thread(new C2522e(this, application)).start();
                }
            } else {
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload]getUploadType:" + C2507c.m12460b());
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.resumeUpload]Upload Type Not Match!");
            }
        }
        return 2;
    }

    private int m12404b(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            LogUpload logUpload = new LogUpload();
            logUpload.setVisible(extras.getBoolean("alert_visible"));
            logUpload.setFilePath(extras.getString("filepath"));
            logUpload.setId(extras.getLong("id"));
            logUpload.setSize(extras.getLong(UploadFile.SIZE_LABEL));
            logUpload.setEncrypt(extras.getBoolean("encrypt"));
            logUpload.setPrivacy(extras.getBoolean("privacy"));
            logUpload.setFlags(extras.getInt("flags"));
            logUpload.setChannelId(extras.getInt(UploadFile.SYS_ID_CHANNEL));
            logUpload.setFeedBackPackageName(extras.getString("feedBackPackageName"));
            logUpload.setFeedBackClassName(extras.getString("feedBackClassName"));
            logUpload.setStartTime(System.currentTimeMillis());
            if (extras.getString(UploadFile.ENCRYTKEY, null) != null) {
                logUpload.setSecret(extras.getString(UploadFile.ENCRYTKEY));
            }
            if (!StringUtils.isNullOrEmpty(extras.getString("productName"))) {
                logUpload.setProductName(extras.getString("productName"));
            }
            if (!StringUtils.isNullOrEmpty(extras.getString("romVersion"))) {
                logUpload.setRomVersion(extras.getString("romVersion"));
            }
            if (!StringUtils.isNullOrEmpty(extras.getString(UploadFile.ZIP_TIME))) {
                logUpload.setZipTime(extras.getString(UploadFile.ZIP_TIME));
            }
            if (!StringUtils.isNullOrEmpty(extras.getString("logDetailedInfo")) && extras.getString("logDetailedInfo").length() <= 15000) {
                logUpload.setLogDetailInfo(extras.getString("logDetailedInfo"));
            }
            if (extras.getInt("usertype", 1) == 1) {
                logUpload.setUserType(0);
            } else if (extras.getInt("usertype", 1) == 3) {
                logUpload.setUserType(1);
            } else if (extras.getInt("usertype", 1) == 2) {
                logUpload.setUserType(2);
            } else {
                logUpload.setUserType(3);
            }
            C2511g.m12484d("BETACLUB_SDK", "[LogUploadService.startUpload] logUploadInfo.getUserType():" + logUpload.getUserType());
            Context baseContext = AppContext.getInstance().getApplication().getBaseContext();
            C2517m.m12581c((Context) this);
            new Thread(new C2523f(this, baseContext, logUpload)).start();
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        C2511g.m12481b("BETACLUB_SDK", "onUnbind()");
        return super.onUnbind(intent);
    }

    public static void m12403a(LogUpload logUpload) {
        C2507c.m12461b(C2517m.m12561a(C2517m.m12562a(AppContext.getInstance().getApplication().getBaseContext())));
        C2507c.m12463c(C2517m.m12575b(AppContext.getInstance().getApplication().getBaseContext()));
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.prepareForUpload] networkType=" + C2507c.m12466f() + ", netType=" + C2507c.m12467g());
        if (C2507c.m12466f() == 0) {
            C2519o c2519o = new C2519o(Looper.getMainLooper());
            c2519o.sendMessage(c2519o.obtainMessage(0));
            return;
        }
        int flags = logUpload.getFlags();
        int i = flags & 1;
        int i2 = flags & 2;
        flags &= 4;
        C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.prepareForUpload] flagWifi=" + i + ", flag3g=" + i2 + ", flag2g=" + flags);
        if (C2507c.m12466f() != 1) {
            C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.prepareForUpload] networkType=" + C2507c.m12466f());
            if (i2 == 2 || flags == 4) {
                C2511g.m12481b("BETACLUB_SDK", "[LogUploadService.prepareForUpload] Begin to start the thread...");
                C2499a.m12430a().m12431a(new C2524g(logUpload, 0));
                return;
            }
            c2519o = new C2519o(Looper.getMainLooper());
            c2519o.sendMessage(c2519o.obtainMessage(0));
        } else if (i == 1) {
            if (!(logUpload.getUserType() == 0 || logUpload.getUserType() == 2)) {
                C2517m.m12584d();
            }
            C2511g.m12481b("BETACLUB_SDK", "Begin to start the thread...");
            C2499a.m12430a().m12431a(new C2524g(logUpload, 0));
        } else {
            c2519o = new C2519o(Looper.getMainLooper());
            c2519o.sendMessage(c2519o.obtainMessage(0));
        }
    }
}
