package com.huawei.logupload;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.lcagent.client.MetricConstant;
import com.huawei.logupload.p089b.C1099a;
import com.huawei.logupload.p090c.C1101b;
import com.huawei.logupload.p090c.C1102c;
import com.huawei.logupload.p090c.C1103f;
import com.huawei.logupload.p090c.C1105h;
import com.huawei.logupload.p090c.C1105h.C1104a;

public class LogUploadService extends Service {
    private static int f2258a = 0;

    public static int m4827a() {
        return f2258a;
    }

    public static void m4828a(int i) {
        f2258a = i;
    }

    public IBinder onBind(Intent intent) {
        C1103f.m4878b("LogUpload Service", "onBind()");
        return null;
    }

    public void onCreate() {
        C1103f.m4878b("LogUpload Service", "onCreate()");
        super.onCreate();
        C1101b.m4858a().m4859a(getApplication());
    }

    public void onDestroy() {
        C1103f.m4878b("LogUpload Service", "onDestroy()");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        C1103f.m4878b("LogUpload Service", "onStartCommand()");
        if (!(intent == null || intent.getExtras() == null)) {
            String action = intent.getAction();
            Bundle extras;
            if (action.equals(MetricConstant.ACTION_RESUME_UPLOAD_INTENT)) {
                extras = intent.getExtras();
                if (extras != null) {
                    int i4 = extras.getInt("reason");
                    Context b = C1101b.m4858a().m4860b();
                    if (C1102c.m4865b() == 0) {
                        if (i4 != 0) {
                            if (i4 == 1) {
                                i3 = 2;
                            } else {
                                i3 = i4;
                            }
                        }
                        m4828a(i3);
                        C1102c.m4866b(C1105h.m4883a(C1105h.m4907d(b)));
                        C1102c.m4868c(C1105h.m4909e(b));
                        C1103f.m4878b("LogUpload Service", new StringBuilder(HwAccountConstants.EXTRA_OPLOG_NETTYPE).append(C1102c.m4873g()).toString());
                        C1103f.m4878b("LogUpload Service", "networkType is " + C1102c.m4872f());
                        C1104a c1104a;
                        Message obtainMessage;
                        Bundle bundle;
                        if (C1102c.m4873g() == -1 || C1102c.m4872f() == 0) {
                            C1103f.m4878b("LogUpload Service", "Start to kill process!");
                            C1102c.m4867c().clear();
                            C1102c.m4862a(0);
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", b.getPackageName());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        } else if (VERSION.SDK_INT <= 22 || C1105h.m4897a(b.getPackageManager(), "android.permission.WRITE_EXTERNAL_STORAGE", b.getPackageName())) {
                            C1105h.m4911f(b);
                            new Thread(new C1107d(this, b)).start();
                        } else {
                            C1103f.m4878b("LogUpload Service", "ACTION_RESUME_UPLOAD_INTENT No permission!");
                            C1102c.m4867c().clear();
                            C1102c.m4862a(0);
                            c1104a = new C1104a(Looper.getMainLooper());
                            obtainMessage = c1104a.obtainMessage(0);
                            bundle = new Bundle();
                            bundle.putString("packagename", b.getPackageName());
                            obtainMessage.setData(bundle);
                            c1104a.sendMessage(obtainMessage);
                        }
                    }
                }
            } else if (action.equals(MetricConstant.ACTION_UPLOAD_REQUEST_INTENT)) {
                extras = intent.getExtras();
                if (extras != null) {
                    LogUpload logUpload = new LogUpload();
                    C1102c.m4870d(extras.getInt("autoupload"));
                    C1103f.m4878b("LogUpload Service", "autouploadtype" + C1102c.m4875i());
                    logUpload.m4771a(extras.getBoolean("alert_visible"));
                    logUpload.m4793f(extras.getString("filepath"));
                    logUpload.m4774b(extras.getLong("id"));
                    logUpload.m4779c(extras.getLong(UploadFile.SIZE_LABEL));
                    logUpload.m4776b(extras.getBoolean("encrypt"));
                    logUpload.m4781c(extras.getBoolean("privacy"));
                    logUpload.m4767a(extras.getInt("flags"));
                    logUpload.m4783d(extras.getInt(UploadFile.SYS_ID_CHANNEL));
                    logUpload.m4815p(extras.getString("feedBackPackageName"));
                    logUpload.m4816q(extras.getString("feedBackClassName"));
                    logUpload.m4784d(System.currentTimeMillis());
                    if (extras.getString(UploadFile.ENCRYTKEY) != null) {
                        logUpload.m4801i(extras.getString(UploadFile.ENCRYTKEY));
                    }
                    if (!TextUtils.isEmpty(extras.getString("productName"))) {
                        logUpload.m4770a(extras.getString("productName"));
                    }
                    if (!TextUtils.isEmpty(extras.getString("romVersion"))) {
                        logUpload.m4775b(extras.getString("romVersion"));
                    }
                    if (!TextUtils.isEmpty(extras.getString(UploadFile.ZIP_TIME))) {
                        logUpload.m4785d(extras.getString(UploadFile.ZIP_TIME));
                    }
                    if (!TextUtils.isEmpty(extras.getString("logDetailedInfo")) && extras.getString("logDetailedInfo").length() <= 15000) {
                        logUpload.m4789e(extras.getString("logDetailedInfo"));
                    }
                    if (extras.getInt("usertype", 1) == 1) {
                        logUpload.m4788e(0);
                    } else if (extras.getInt("usertype", 1) == 3) {
                        logUpload.m4788e(1);
                    } else if (extras.getInt("usertype", 1) == 2) {
                        logUpload.m4788e(2);
                    } else if (extras.getInt("usertype", 1) == 5) {
                        logUpload.m4788e(4);
                    } else {
                        logUpload.m4788e(0);
                    }
                    C1103f.m4880d("LogUpload Service", "logUploadInfo.getUserType():" + logUpload.m4763F());
                    C1103f.m4880d("LogUpload Service", "alert_visible=" + extras.getBoolean("alert_visible") + "; filepath=" + extras.getString("filepath") + "; transactionId=" + extras.getLong("id") + "; size=" + extras.getLong(UploadFile.SIZE_LABEL) + "; encrypt=" + extras.getBoolean("encrypt") + "; privacy=" + extras.getBoolean("privacy") + "; flags=" + extras.getInt("flags") + "; channelId=" + extras.getInt(UploadFile.SYS_ID_CHANNEL) + "; feedBackPackageName=" + extras.getString("feedBackPackageName") + "; feedBackClassName=" + extras.getString("feedBackClassName") + "; usertype=" + extras.getInt("usertype", 1) + "; productName=" + extras.getString("productName") + "; romVersion=" + extras.getString("romVersion") + "; zipTime=" + extras.getString(UploadFile.ZIP_TIME) + "; logDetailedInfo=" + extras.getString("logDetailedInfo"));
                    Context baseContext = C1101b.m4858a().m4860b().getBaseContext();
                    C1105h.m4911f(this);
                    new Thread(new C1108e(this, baseContext, logUpload)).start();
                }
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        C1103f.m4878b("LogUpload Service", "onUnbind()");
        return super.onUnbind(intent);
    }

    public static void m4829a(LogUpload logUpload) {
        C1102c.m4866b(C1105h.m4883a(C1105h.m4907d(C1101b.m4858a().m4860b().getBaseContext())));
        C1102c.m4868c(C1105h.m4909e(C1101b.m4858a().m4860b().getBaseContext()));
        C1103f.m4878b("LogUpload Service", "prepareForUpload networkType" + C1102c.m4872f() + HwAccountConstants.EXTRA_OPLOG_NETTYPE + C1102c.m4873g());
        if (C1102c.m4872f() == 0) {
            C1104a c1104a = new C1104a(Looper.getMainLooper());
            Message obtainMessage = c1104a.obtainMessage(0);
            Bundle bundle = new Bundle();
            bundle.putString("packagename", logUpload.m4760C());
            obtainMessage.setData(bundle);
            c1104a.sendMessage(obtainMessage);
            return;
        }
        int l = logUpload.m4806l();
        int i = l & 1;
        int i2 = l & 2;
        l &= 4;
        C1103f.m4878b("LogUpload Service", "flagWifi " + i + "flag3g" + i2 + "flag2g" + l);
        if (C1102c.m4872f() != 1) {
            C1103f.m4878b("LogUpload Service", "networkType " + C1102c.m4872f());
            if (i2 == 2 || l == 4) {
                C1103f.m4878b("LogUpload Service", "Begin to start the thread...");
                C1099a.m4851a().m4852a(new C1109f(logUpload, 0));
                return;
            }
            c1104a = new C1104a(Looper.getMainLooper());
            obtainMessage = c1104a.obtainMessage(0);
            bundle = new Bundle();
            bundle.putString("packagename", logUpload.m4760C());
            obtainMessage.setData(bundle);
            c1104a.sendMessage(obtainMessage);
        } else if (i == 1) {
            if (!(logUpload.m4763F() == 0 || logUpload.m4763F() == 2 || logUpload.m4763F() == 4)) {
                C1105h.m4908d();
            }
            C1103f.m4878b("LogUpload Service", "Begin to start the thread...");
            C1099a.m4851a().m4852a(new C1109f(logUpload, 0));
        } else {
            c1104a = new C1104a(Looper.getMainLooper());
            obtainMessage = c1104a.obtainMessage(0);
            bundle = new Bundle();
            bundle.putString("packagename", logUpload.m4760C());
            obtainMessage.setData(bundle);
            c1104a.sendMessage(obtainMessage);
        }
    }
}
