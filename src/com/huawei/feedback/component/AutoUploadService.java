package com.huawei.feedback.component;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.C0809b;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.C0821e;
import com.huawei.feedback.bean.C0810a;
import com.huawei.feedback.p033a.p034a.C0806a;
import com.huawei.feedback.p033a.p034a.C0807b;
import com.huawei.feedback.p033a.p035b.C0808a;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.lcagent.client.MetricConstant;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.p133a.p134a.C1369a;
import com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a.C1370a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AutoUploadService extends Service {
    private static File f1250a;
    private static long f1251b = 0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        C1373c.m6140c("AppLogApi/AutoUploadService", "onCreate()");
        super.onCreate();
    }

    public void onDestroy() {
        C1373c.m6140c("AppLogApi/AutoUploadService", "onDestroy()");
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        C1373c.m6140c("AppLogApi/AutoUploadService", "onStart()");
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C1373c.m6140c("AppLogApi/AutoUploadService", "AutoUploadService onStartCommand()");
        if (intent == null || intent.getExtras() == null) {
            C1373c.m6140c("AppLogApi/AutoUploadService", "onStart() null");
            stopSelf();
        } else {
            byte[] bArr = new byte[11];
            C0821e.m2884a(bArr);
            String a = C1369a.m6093a("AESV2" + Base64.encodeToString(bArr, 2));
            String action = intent.getAction();
            C1373c.m6140c("AppLogApi/AutoUploadService", "action " + action);
            if ("com.huawei.phoneservice.AUTOUPLOAD_REQUEST".equals(action)) {
                Bundle bundleExtra = intent.getBundleExtra("metaData");
                String stringExtra = intent.getStringExtra("filepath");
                C1373c.m6140c("AppLogApi/AutoUploadService", "小包sd路径" + stringExtra);
                String stringExtra2 = intent.getStringExtra("aesSecret");
                boolean booleanExtra = intent.getBooleanExtra("uploadFile", false);
                if (bundleExtra == null) {
                    stopSelf();
                } else {
                    String string = bundleExtra.getString("Eventid");
                    String string2 = bundleExtra.getString("HappenTime");
                    String string3 = bundleExtra.getString("MetaData");
                    C0810a c0810a = new C0810a();
                    c0810a.m2738a(Integer.parseInt(string));
                    c0810a.m2744b(string2);
                    c0810a.m2746c(string3);
                    c0810a.m2741a(booleanExtra);
                    new Thread(new C0812a(this, stringExtra, stringExtra2, c0810a, bundleExtra, a)).start();
                }
            } else if ("com.huawei.phoneservice.AUTOCHECK".equals(action)) {
                Bundle bundleExtra2 = intent.getBundleExtra("metaData");
                if (bundleExtra2 == null) {
                    stopSelf();
                } else {
                    new Thread(new C0813b(this, bundleExtra2, a)).start();
                }
            } else if ("com.huawei.phoneservice.AUTOUPLOAD_DELETE".equals(action)) {
                Log.i("AutoUploadService", "ACTION_AUTOUPLOAD_DELETE_INTENT000 ");
                new Thread(new C0814c(this, intent.getBooleanExtra("isuploadsuccess", false))).start();
            }
        }
        return 2;
    }

    private void m2819a(Bundle bundle, String str) {
        AppLogApi.deleteOverTimeLog(getApplicationContext());
        if (C0811c.m2805l(getApplicationContext()) && C0811c.m2809p(getApplicationContext())) {
            boolean j = C0808a.m2700a().m2729j(getApplicationContext());
            C1373c.m6139b("AppLogApi/AutoUploadService", "isUnLimitSize==" + j);
            int i = AppLogApi.getremainUploadSize(C0811c.m2798f(getApplicationContext()), getApplicationContext());
            C1373c.m6139b("AppLogApi/AutoUploadService", "remainsize==" + i);
            Object createBiglogzip = AppLogApi.createBiglogzip(getApplicationContext(), (long) i, bundle, j);
            C1373c.m6139b("AppLogApi/AutoUploadService", "biglogFilePath==" + createBiglogzip);
            if (TextUtils.isEmpty(createBiglogzip)) {
                C1373c.m6141d("AppLogApi/AutoUploadService", "createBiglogzip failed!");
                getApplicationContext().stopService(new Intent(getApplicationContext(), AutoUploadService.class));
                return;
            }
            File file = new File(createBiglogzip);
            if (file.exists()) {
                if (!TextUtils.isEmpty(str)) {
                    C1373c.m6141d("AppLogApi/AutoUploadService", "big file path encryptFile!");
                    f1250a = C1370a.m6098a(file, str, false, getApplicationContext());
                }
                C0811c.m2783b(file);
            }
            i = m2827c();
            C1373c.m6139b("AppLogApi/AutoUploadService", "checkuoloadDB maxsizelimit==" + i);
            if (f1250a == null || !f1250a.exists() || (!j && f1250a.length() > ((long) i))) {
                C1373c.m6141d("AppLogApi/AutoUploadService", "waitUploadZipfile failed!");
                C0811c.m2783b(f1250a);
                getApplicationContext().stopService(new Intent(getApplicationContext(), AutoUploadService.class));
                return;
            }
            int i2;
            C1373c.m6141d("AppLogApi/AutoUploadService", "begin logupload!");
            m2825a(f1250a);
            f1251b = f1250a.length();
            Intent intent = new Intent(MetricConstant.ACTION_UPLOAD_REQUEST_INTENT);
            intent.setClassName(getApplicationContext(), "com.huawei.logupload.LogUploadService");
            intent.putExtra("alert_visible", false);
            intent.putExtra("filepath", f1250a.toString());
            intent.putExtra("id", Long.parseLong(new SimpleDateFormat("MMddHHmmssSSS").format(new Date())));
            intent.putExtra("usertype", 1);
            intent.putExtra("encrypt", true);
            intent.putExtra("privacy", false);
            intent.putExtra(UploadFile.SYS_ID_CHANNEL, 8);
            intent.putExtra(UploadFile.SIZE_LABEL, f1251b);
            intent.putExtra("feedBackPackageName", getApplicationContext().getPackageName());
            intent.putExtra("feedBackClassName", AutoUploadService.class.getName());
            if (C0811c.m2798f(getApplicationContext()) == 1) {
                i2 = 1;
            } else {
                i2 = 7;
            }
            intent.putExtra("flags", i2);
            intent.putExtra(UploadFile.ENCRYTKEY, str);
            intent.putExtra("autoupload", 1);
            getApplicationContext().startService(intent);
            return;
        }
        C1373c.m6141d("AppLogApi/AutoUploadService", "isAllowUpload " + C0811c.m2805l(getApplicationContext()) + "netWorkState " + C0811c.m2809p(getApplicationContext()));
        getApplicationContext().stopService(new Intent(getApplicationContext(), AutoUploadService.class));
    }

    private int m2827c() {
        int f = C0811c.m2798f(getApplicationContext());
        if (f == 1) {
            return 819200;
        }
        if (f == 2) {
            return 409600;
        }
        return 0;
    }

    private void m2828d() {
        Log.i("AppLogApi/AutoUploadService", "deleteuploadDB ACTION_AUTOUPLOAD_DELETE_INTENT ");
        C0806a c0806a = new C0806a(getApplicationContext());
        synchronized (C0809b.f1237b) {
            C0807b.m2697a(c0806a, AppLogApi.getAutouploadloglist());
        }
        synchronized (C0809b.f1237b) {
            C0807b.m2697a(c0806a, AppLogApi.getAutonologlist());
        }
        if (AppLogApi.getAutouploadloglist().size() > 0) {
            for (C0810a c0810a : AppLogApi.getAutouploadloglist()) {
                Log.i("AppLogApi/AutoUploadService", "ACTION_AUTOUPLOAD_DELETE_INTENT getFilepath");
                C0811c.m2795e(c0810a.m2745c());
            }
        }
    }

    private void m2818a(long j) {
        int f = C0811c.m2798f(getApplicationContext());
        Log.i("AppLogApi/AutoUploadService", "setHasUsedSize netType" + f);
        if (f == 1) {
            Log.i("AppLogApi/AutoUploadService", "setHasUsedSize file" + j);
            C0808a.m2700a().m2710b(getApplicationContext(), (int) (((long) C0808a.m2700a().m2717d(getApplicationContext())) + j));
        } else if (f == 2) {
            C0808a.m2700a().m2715c(getApplicationContext(), (int) (((long) C0808a.m2700a().m2720e(getApplicationContext())) + j));
        }
    }

    private void m2825a(File file) {
        if (file != null) {
            int f = C0811c.m2798f(getApplicationContext());
            if (f == 1) {
                C0808a.m2700a().m2719d(getApplicationContext(), (int) (((long) C0808a.m2700a().m2723f(getApplicationContext())) + file.length()));
            } else if (f == 2) {
                C0808a.m2700a().m2722e(getApplicationContext(), (int) (((long) C0808a.m2700a().m2726g(getApplicationContext())) + file.length()));
            }
        }
    }

    private void m2820a(C0810a c0810a) {
        C0806a c0806a = new C0806a(getApplicationContext());
        synchronized (C0809b.f1237b) {
            List a = C0807b.m2692a(c0806a);
            List a2 = C0807b.m2693a(c0806a, c0810a.m2745c());
            if (a.size() < 500 && a2.size() == 0) {
                C0807b.m2691a(c0806a, c0810a);
            }
        }
    }
}
