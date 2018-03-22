package com.huawei.feedback.component;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.huawei.feedback.C0809b;
import com.huawei.feedback.C0811c;
import com.huawei.feedback.C0820d;
import com.huawei.feedback.FeedbackApi;
import com.huawei.feedback.logic.C0822f;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.lcagent.client.LogCollectManager;
import com.huawei.lcagent.client.MetricConstant;
import com.huawei.logupload.C1094a;
import com.huawei.logupload.LogUpload;
import com.huawei.phoneserviceuni.common.p132d.C1372a;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.C1374f;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p000a.p001a.p002a.p003a.c$d;

public class ProgressService extends Service {
    private static C1094a f1256j;
    private static List<LogUpload> f1257k = new ArrayList();
    private static String f1258o = "";
    ServiceConnection f1259a = new C0815d(this);
    Handler f1260b = new Handler();
    private NotificationManager f1261c;
    private Map<Long, c$d> f1262d = new HashMap();
    private Map<Long, LogUpload> f1263e = new HashMap();
    private ProgressReceiver f1264f = new ProgressReceiver(this);
    private ProgressStartReceiver f1265g = new ProgressStartReceiver(this);
    private ProgressCancelReceiver f1266h = new ProgressCancelReceiver(this);
    private ProgressPauseReceiver f1267i = new ProgressPauseReceiver(this);
    private LogCollectManager f1268l = null;
    private AlertDialog f1269m;
    private boolean f1270n = false;
    private LogUpload f1271p = null;

    public class ProgressCancelReceiver extends BroadcastReceiver {
        final /* synthetic */ ProgressService f1252a;

        public ProgressCancelReceiver(ProgressService progressService) {
            this.f1252a = progressService;
        }

        public void onReceive(Context context, Intent intent) {
            long j = -1;
            boolean z = false;
            if (intent != null && !C0811c.m2789c()) {
                if ("com.example.logupload.progress.cancel".equals(intent.getAction())) {
                    boolean booleanExtra;
                    C1373c.m6138a("ProgressService", "ProgressCancelReceiver onReceive");
                    try {
                        j = intent.getLongExtra("strID", -1);
                        booleanExtra = intent.getBooleanExtra("comeFromRecord", false);
                    } catch (Exception e) {
                        C1373c.m6139b("ProgressService", "strId get exception" + e.getMessage());
                        booleanExtra = z;
                    }
                    C1373c.m6138a("ProgressService", "strId:" + j);
                    LogUpload logUpload = (LogUpload) this.f1252a.f1263e.get(Long.valueOf(j));
                    if (logUpload != null) {
                        this.f1252a.m2869h();
                        if (booleanExtra) {
                            this.f1252a.m2849b(logUpload, j);
                        } else if (this.f1252a.f1269m == null || !this.f1252a.f1269m.isShowing()) {
                            this.f1252a.m2839a(logUpload, j);
                        }
                    } else {
                        C1373c.m6141d("ProgressService", "ProgressCancelReceiver： ProgressCancelReceiver mLogUploadInfo == null");
                        Intent intent2 = new Intent();
                        intent2.setAction("com.example.logupload.exception");
                        intent2.putExtra("strID", j);
                        this.f1252a.sendBroadcast(intent2);
                    }
                    if (!this.f1252a.m2865f()) {
                        this.f1252a.stopSelf();
                    }
                }
            }
        }
    }

    public class ProgressPauseReceiver extends BroadcastReceiver {
        final /* synthetic */ ProgressService f1253a;

        public ProgressPauseReceiver(ProgressService progressService) {
            this.f1253a = progressService;
        }

        public void onReceive(Context context, Intent intent) {
            long j = -1;
            if (intent != null) {
                if ("com.example.logupload.progress.pause".equals(intent.getAction())) {
                    C1373c.m6138a("ProgressService", "ProgressPauseReceiver onReceive");
                    try {
                        j = intent.getLongExtra("strID", -1);
                    } catch (Exception e) {
                        C1373c.m6139b("ProgressService", "strId get exception" + e.getMessage());
                    }
                    C1373c.m6139b("ProgressService", "strID == " + j);
                    LogUpload logUpload = (LogUpload) this.f1253a.f1263e.get(Long.valueOf(j));
                    if (logUpload != null) {
                        logUpload.m4780c("1");
                        C1373c.m6140c("ProgressService", "ProgressPauseReceiver refresh");
                        this.f1253a.m2841a(logUpload, true);
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getId() :" + logUpload.m4800i());
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getTaskId() :" + logUpload.m4791f());
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getIsPause() :" + logUpload.m4777c());
                        try {
                            C1373c.m6138a("ProgressService", "updateStatus flag :" + ProgressService.f1256j.mo2354a(logUpload));
                            return;
                        } catch (RemoteException e2) {
                            C1373c.m6138a("ProgressService", "ProgressPauseReceiver external updateStatus RemoteException");
                            return;
                        }
                    }
                    C1373c.m6139b("ProgressService", "ProgressPauseReceiver mLogUploadInfo == null");
                }
            }
        }
    }

    public class ProgressReceiver extends BroadcastReceiver {
        final /* synthetic */ ProgressService f1254a;

        public ProgressReceiver(ProgressService progressService) {
            this.f1254a = progressService;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                Parcelable parcelableExtra;
                String action = intent.getAction();
                try {
                    parcelableExtra = intent.getParcelableExtra("mLogUploadInfo");
                } catch (Exception e) {
                    C1373c.m6139b("ProgressService", "ProgressReceiver onReceive error " + e.getMessage());
                    parcelableExtra = null;
                }
                if (parcelableExtra != null && (parcelableExtra instanceof LogUpload)) {
                    this.f1254a.f1271p = (LogUpload) parcelableExtra;
                }
                if ("com.example.logupload.progress".equals(action)) {
                    this.f1254a.m2840a(this.f1254a.f1271p, intent);
                } else if ("com.example.logupload.progressSmall".equals(action) && this.f1254a.f1271p != null) {
                    this.f1254a.m2850b(this.f1254a.f1271p, intent);
                }
            }
        }
    }

    public class ProgressStartReceiver extends BroadcastReceiver {
        final /* synthetic */ ProgressService f1255a;

        public ProgressStartReceiver(ProgressService progressService) {
            this.f1255a = progressService;
        }

        public void onReceive(Context context, Intent intent) {
            long j = -1;
            if (intent != null) {
                if ("com.example.logupload.progress.start".equals(intent.getAction())) {
                    C1373c.m6138a("ProgressService", "ProgressStartReceiver onReceive");
                    try {
                        j = intent.getLongExtra("strID", -1);
                    } catch (Exception e) {
                        C1373c.m6139b("ProgressService", "strId get exception" + e.getMessage());
                    }
                    C1373c.m6138a("ProgressService", "strId:" + j);
                    LogUpload logUpload = (LogUpload) this.f1255a.f1263e.get(Long.valueOf(j));
                    if (logUpload != null) {
                        boolean a;
                        logUpload.m4780c("0");
                        C0822f.m2889a(String.valueOf(logUpload.m4800i()), 5);
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getId() :" + logUpload.m4800i());
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getTaskId() :" + logUpload.m4791f());
                        C1373c.m6138a("ProgressService", "mLogUploadInfo.getIsPause() :" + logUpload.m4777c());
                        C1373c.m6140c("ProgressService", "ProgressStartReceiver refresh");
                        this.f1255a.m2841a(logUpload, false);
                        try {
                            a = ProgressService.f1256j.mo2354a(logUpload);
                        } catch (RemoteException e2) {
                            C1373c.m6138a("ProgressService", "onReceive： external updateStatus RemoteException");
                            a = false;
                        }
                        if (a) {
                            Intent intent2 = new Intent(MetricConstant.ACTION_UPLOAD_REQUEST_INTENT);
                            intent2.setClassName(context, "com.huawei.logupload.LogUploadService");
                            intent2.putExtra("alert_visible", logUpload.m4797g());
                            intent2.putExtra("filepath", logUpload.m4798h());
                            intent2.putExtra("id", logUpload.m4800i());
                            intent2.putExtra(UploadFile.SIZE_LABEL, logUpload.m4802j());
                            intent2.putExtra("encrypt", logUpload.m4805k());
                            intent2.putExtra("privacy", logUpload.m4817q());
                            if (4 == logUpload.m4763F()) {
                                intent2.putExtra("usertype", 5);
                            } else {
                                intent2.putExtra("usertype", logUpload.m4763F());
                            }
                            intent2.putExtra("flags", logUpload.m4806l());
                            intent2.putExtra(UploadFile.SYS_ID_CHANNEL, logUpload.m4758A());
                            intent2.putExtra("feedBackPackageName", logUpload.m4760C());
                            intent2.putExtra("feedBackClassName", logUpload.m4761D());
                            intent2.putExtra(UploadFile.ENCRYTKEY, logUpload.m4812o());
                            FeedbackApi.getApplicationcontext().startService(intent2);
                            return;
                        }
                        return;
                    }
                    C1373c.m6139b("ProgressService", "ProgressStartReceiver mLogUploadInfo == null");
                }
            }
        }
    }

    public static void m2842a(String str) {
        f1258o = str;
    }

    private void m2851b(String str) {
        m2842a(str);
    }

    public static C1094a m2831a() {
        return f1256j;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        C1373c.m6139b("ProgressService", "onDestroy");
        if (this.f1270n) {
            unbindService(this.f1259a);
            this.f1270n = false;
        }
        C1373c.m6138a("ProgressService", "CommonConstants.getReceiverHasRegisted():" + C0809b.m2736b());
        if (C0809b.m2736b() == 1) {
            unregisterReceiver(this.f1264f);
        } else if (C0809b.m2736b() == 2) {
            unregisterReceiver(this.f1264f);
            unregisterReceiver(this.f1265g);
        } else if (C0809b.m2736b() == 3) {
            unregisterReceiver(this.f1264f);
            unregisterReceiver(this.f1265g);
            unregisterReceiver(this.f1267i);
        } else if (C0809b.m2736b() == 4) {
            unregisterReceiver(this.f1264f);
            unregisterReceiver(this.f1265g);
            unregisterReceiver(this.f1267i);
            unregisterReceiver(this.f1266h);
        }
        C0809b.m2733a(0);
        super.onDestroy();
    }

    public void onCreate() {
        C1373c.m6139b("ProgressService", "onCreate");
        this.f1261c = (NotificationManager) getSystemService("notification");
        super.setTheme(C1374f.m6153e(this));
        try {
            this.f1268l = FeedbackApi.getLogCollectManager();
            if (this.f1268l == null) {
                this.f1268l = new LogCollectManager(getApplicationContext());
            }
        } catch (Exception e) {
            C1373c.m6141d("ProgressService", "The init of the object logCollectManager is exception!");
        }
        String packageName = getApplicationContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            C1373c.m6141d("ProgressService", "packagename null!");
        } else {
            m2851b(packageName);
        }
        Intent intent = new Intent();
        intent.setClassName(this, "com.huawei.logupload.ExternalOperService");
        intent.setAction("com.huawei.logupload.ExternalOperService");
        this.f1270n = bindService(intent, this.f1259a, 1);
        super.onCreate();
    }

    private void m2840a(LogUpload logUpload, Intent intent) {
        Object stringExtra = intent.getStringExtra(JoinConstants.EXCEPTION);
        if (TextUtils.isEmpty(stringExtra)) {
            if (logUpload != null) {
                C1373c.m6138a("ProgressService", "ProgressReceiver onReceive");
                C1373c.m6138a("ProgressService", "mLogUploadInfo.getId() :" + logUpload.m4800i());
                C1373c.m6138a("ProgressService", "mLogUploadInfo.getTaskId() :" + logUpload.m4791f());
                String stringExtra2 = intent.getStringExtra("extraValue");
                if (f1258o.equals(logUpload.m4760C())) {
                    C1373c.m6140c("ProgressService", "dealexceptionProgress createNotification");
                    m2848b(logUpload);
                    if (!TextUtils.isEmpty(logUpload.m4822v())) {
                        if ("2".equals(logUpload.m4777c()) && stringExtra2 == null) {
                            logUpload.m4780c("0");
                            try {
                                f1256j.mo2354a(logUpload);
                            } catch (RemoteException e) {
                                C1373c.m6138a("ProgressService", "external updateStatus RemoteException");
                            }
                        }
                        C1373c.m6140c("ProgressService", "dealexceptionProgress updateNotification");
                        m2856c(logUpload);
                    }
                }
            }
        } else if ("1".equals(stringExtra)) {
            C1373c.m6138a("ProgressService", "exception:1");
            m2863e();
        } else if ("2".equals(stringExtra) && logUpload != null) {
            C1373c.m6138a("ProgressService", "exception:" + stringExtra);
            m2838a(logUpload);
        }
    }

    private void m2850b(LogUpload logUpload, Intent intent) {
        C1373c.m6138a("ProgressService", "com.example.logupload.progressSmall");
        if (f1258o.equals(logUpload.m4760C())) {
            this.f1260b.postDelayed(new C0816e(this, logUpload), 500);
        }
    }

    private void m2863e() {
        List list = null;
        if (f1256j != null) {
            try {
                list = f1256j.mo2353a();
            } catch (RemoteException e) {
                C1373c.m6139b("ProgressService", "dealexceptionResume()：external queryAllRecord RemoteException");
            }
        }
        if (r0 != null) {
            for (LogUpload logUpload : r0) {
                if (f1258o.equals(logUpload.m4760C()) && !"1".equals(logUpload.m4777c())) {
                    logUpload.m4780c("2");
                    CharSequence v = logUpload.m4822v();
                    C0822f.m2889a(String.valueOf(logUpload.m4800i()), 2);
                    try {
                        C1373c.m6138a("ProgressService", "updateStatus flag:" + f1256j.mo2354a(logUpload));
                        if (TextUtils.isEmpty(v)) {
                            C1373c.m6140c("ProgressService", "dealexceptionResume createNotification");
                            m2848b(logUpload);
                            C1373c.m6140c("ProgressService", "dealexceptionResume updateNotification");
                            m2856c(logUpload);
                        } else {
                            C1373c.m6140c("ProgressService", "dealexceptionResume contentRanger is notEmpty updateNotification");
                            m2856c(logUpload);
                        }
                    } catch (RemoteException e2) {
                        C1373c.m6141d("ProgressService", "updateNotification RemoteException e");
                    }
                }
            }
        }
    }

    private void m2838a(LogUpload logUpload) {
        List list = null;
        if (f1256j != null) {
            try {
                list = f1256j.mo2353a();
            } catch (RemoteException e) {
                C1373c.m6141d("ProgressService", "dealexceptionSingle(LogUpload mLogUploadInfo)：external queryAllRecord RemoteException");
            }
        }
        if (r0 != null) {
            Object obj;
            for (LogUpload i : r0) {
                if (i.m4800i() == logUpload.m4800i()) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null && f1258o.equals(logUpload.m4760C())) {
                logUpload.m4780c("2");
                C0822f.m2889a(String.valueOf(logUpload.m4800i()), 2);
                try {
                    C1373c.m6138a("ProgressService", "updateStatus flag:" + f1256j.mo2354a(logUpload));
                    C1373c.m6140c("ProgressService", "dealexceptionSingle updateNotification");
                    m2856c(logUpload);
                } catch (RemoteException e2) {
                    C1373c.m6139b("ProgressService", "dealexceptionSingle(LogUpload mLogUploadInfo)：external updateStatus RemoteException");
                }
            }
        }
    }

    private boolean m2865f() {
        List list = null;
        if (f1256j != null) {
            try {
                list = f1256j.mo2353a();
            } catch (RemoteException e) {
                C1373c.m6139b("ProgressService", "isFeedbackLogExist()：external queryAllRecord RemoteException");
            }
        }
        if (r0 != null) {
            for (LogUpload C : r0) {
                if (f1258o.equals(C.m4760C())) {
                    return true;
                }
            }
        }
        return false;
    }

    private Bitmap m2866g() {
        try {
            return ((BitmapDrawable) getPackageManager().getApplicationIcon(getPackageName())).getBitmap();
        } catch (OutOfMemoryError e) {
            C1373c.m6141d("ProgressService", "getNotifyLargeIcon --OutOfMemoryError");
            return null;
        } catch (Exception e2) {
            C1373c.m6141d("ProgressService", "getNotifyLargeIcon Exception--");
            return null;
        }
    }

    private void m2848b(LogUpload logUpload) {
        if (logUpload != null && logUpload.m4758A() != 8) {
            C1373c.m6138a("ProgressService", "CreateNotification");
            int e = m2861e(logUpload);
            C1373c.m6138a("ProgressService", "notificationId: " + e);
            if (this.f1262d.containsKey(Long.valueOf(logUpload.m4800i())) || FeedbackApi.getApplicationcontext() == null) {
                C1373c.m6138a("ProgressService", "download.contains(notificationId)");
                return;
            }
            c$d c = new c$d(this).m5a(true).m8c(String.format(Locale.getDefault(), getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_loguploading")), new Object[]{"0%"}));
            if (C1372a.m6128m()) {
                c.m2a(C0820d.m2878e(FeedbackApi.getApplicationcontext(), "feedback_pushmsg_icon_new"));
            } else {
                c.m2a(C0820d.m2878e(FeedbackApi.getApplicationcontext(), "feedback_pushmsg_icon"));
            }
            c.m4a(C0811c.m2800g(FeedbackApi.getApplicationcontext()));
            c.m7b(String.format(Locale.getDefault(), getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_loguploading")), new Object[]{"0%"}));
            Bitmap g = m2866g();
            if (g != null) {
                c.m3a(g);
            }
            Notification a = c.m6a();
            this.f1262d.put(Long.valueOf(logUpload.m4800i()), c);
            this.f1263e.put(Long.valueOf(logUpload.m4800i()), logUpload);
            this.f1261c.notify(e, a);
        }
    }

    private void m2841a(LogUpload logUpload, boolean z) {
        if (logUpload != null && logUpload.m4758A() != 8) {
            C1373c.m6138a("ProgressService", UploadFile.REFRESH_LABEL);
            int e = m2861e(logUpload);
            C1373c.m6138a("ProgressService", "refresh  notificationId:" + e);
            C1373c.m6138a("ProgressService", "refresh  notificationId:" + logUpload.m4800i());
            String v = logUpload.m4822v();
            CharSequence charSequence = "";
            long j = logUpload.m4802j();
            if (TextUtils.isEmpty(v)) {
                v = "0";
            } else {
                String[] split = v.split(",");
                if (split.length >= 2 && !TextUtils.isEmpty(split[1])) {
                    v = split[1].substring(0, split[1].length() - 1);
                }
            }
            try {
                int parseInt = Integer.parseInt(v);
                if (j > 0) {
                    parseInt = (int) ((((float) parseInt) / ((float) j)) * 100.0f);
                    v = String.format(Locale.getDefault(), getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_loguploading")), new Object[]{parseInt + "%"});
                } else {
                    CharSequence charSequence2 = charSequence;
                }
                charSequence = v;
            } catch (NumberFormatException e2) {
                C1373c.m6138a("ProgressService", "NumberFormatException");
            }
            c$d a_a_a_a_c_d = (c$d) this.f1262d.get(Long.valueOf(logUpload.m4800i()));
            a_a_a_a_c_d.m7b(charSequence);
            this.f1261c.notify(e, a_a_a_a_c_d.m6a());
        }
    }

    private void m2856c(LogUpload logUpload) {
        if (logUpload != null && logUpload.m4758A() != 8) {
            C1373c.m6138a("ProgressService", "updateNotification");
            int e = m2861e(logUpload);
            String d = m2860d(logUpload);
            C1373c.m6138a("ProgressService", "isPause = " + d);
            String v = logUpload.m4822v();
            long j = logUpload.m4802j();
            String c = m2854c(v);
            v = "";
            try {
                CharSequence string;
                int i;
                int parseInt = Integer.parseInt(c);
                Object format;
                if (j > 0) {
                    int i2 = (int) ((((float) parseInt) / ((float) j)) * 100.0f);
                    if ("2".equals(d)) {
                        string = getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_logupload_fail"));
                        i = i2;
                    } else {
                        format = String.format(Locale.getDefault(), getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_loguploading")), new Object[]{i2 + "%"});
                        i = i2;
                    }
                } else {
                    format = v;
                    i = 0;
                }
                c$d a_a_a_a_c_d = (c$d) this.f1262d.get(Long.valueOf(logUpload.m4800i()));
                a_a_a_a_c_d.m8c(String.format(Locale.getDefault(), getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_advanced_loguploading")), new Object[]{i + "%"}));
                a_a_a_a_c_d.m7b(string);
                this.f1261c.notify(e, a_a_a_a_c_d.m6a());
                this.f1263e.put(Long.valueOf(logUpload.m4800i()), logUpload);
                if (i == 100) {
                    this.f1260b.postDelayed(new C0817f(this, e, logUpload), 500);
                }
            } catch (NumberFormatException e2) {
                C1373c.m6138a("ProgressService", "NumberFormatException");
            }
        }
    }

    private String m2854c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        String[] split = str.split(",");
        int i = (split.length < 2 || TextUtils.isEmpty(split[1])) ? 0 : 1;
        if (i != 0) {
            return split[1].substring(0, split[1].length() - 1);
        }
        return str2;
    }

    private String m2860d(LogUpload logUpload) {
        C1373c.m6139b("ProgressService", "findSelfInList");
        String str = "";
        try {
            str = f1256j.mo2355b(logUpload);
        } catch (RemoteException e) {
            C1373c.m6139b("ProgressService", "findSelfInList(): RemoteException");
        }
        return str;
    }

    private void m2869h() {
        Object systemService = getSystemService("statusbar");
        try {
            Class cls = Class.forName("android.app.StatusBarManager");
            if (systemService != null) {
                Method method = cls.getMethod("collapsePanels", new Class[0]);
                method.setAccessible(true);
                method.invoke(systemService, new Object[0]);
            }
        } catch (ClassNotFoundException e) {
            C1373c.m6141d("ProgressService", "ClassNotFoundException");
        } catch (NoSuchMethodException e2) {
            C1373c.m6141d("ProgressService", "NoSuchMethodException");
        } catch (IllegalAccessException e3) {
            C1373c.m6141d("ProgressService", "IllegalAccessException");
        } catch (IllegalArgumentException e4) {
            C1373c.m6141d("ProgressService", "IllegalArgumentException");
        } catch (InvocationTargetException e5) {
            C1373c.m6141d("ProgressService", "InvocationTargetException");
        }
    }

    private void m2839a(LogUpload logUpload, long j) {
        Builder a;
        if (C1372a.m6121f()) {
            a = m2829a(C0820d.m2876c(FeedbackApi.getApplicationcontext(), "feedback_dialog_cancel_uploadlog_new"));
        } else {
            a = m2829a(C0820d.m2876c(FeedbackApi.getApplicationcontext(), "feedback_dialog_cancel_uploadlog"));
        }
        a.setPositiveButton(getResources().getString(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_ok")), new C0819h(this, logUpload, j)).setNegativeButton(C0820d.m2875b(FeedbackApi.getApplicationcontext(), "feedback_cancel"), new C0818g(this));
        this.f1269m = a.create();
        this.f1269m.getWindow().setType(2003);
        this.f1269m.show();
        this.f1269m.setCanceledOnTouchOutside(false);
    }

    private Builder m2829a(int i) {
        View inflate = LayoutInflater.from(this).inflate(i, null);
        Builder builder = new Builder(this);
        builder.setView(inflate);
        return builder;
    }

    private int m2861e(LogUpload logUpload) {
        String valueOf = String.valueOf(logUpload.m4791f());
        C1373c.m6138a("ProgressService", "noticationIdTemp:" + valueOf);
        if (valueOf.length() > 9) {
            valueOf = valueOf.substring(valueOf.length() - 9, valueOf.length());
            C1373c.m6138a("ProgressService", valueOf);
        }
        return Integer.parseInt(valueOf);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C1373c.m6138a("ProgressService", "onStartCommand");
        return 2;
    }

    private void m2849b(LogUpload logUpload, long j) {
        try {
            f1256j.mo2356c(logUpload);
        } catch (RemoteException e) {
            C1373c.m6139b("ProgressService", "dealwithRecord RemoteException");
        }
        this.f1261c.cancel(m2861e(logUpload));
        C0822f.m2889a(String.valueOf(j), 3);
        if (TextUtils.isEmpty(logUpload.m4798h())) {
            C1373c.m6138a("ProgressService", "file path is empty or null: mLogUploadInfo.getFilepath()):" + logUpload.m4798h());
        } else {
            File file = new File(logUpload.m4798h());
            C1373c.m6139b("ProgressService", "path:" + logUpload.m4798h());
            if (file.exists() && file.delete()) {
                C1373c.m6139b("ProgressService", "file delete sccess!");
            } else {
                C1373c.m6139b("ProgressService", "file not exist or error! file delete fail!");
            }
        }
        Object x = logUpload.m4824x();
        C1373c.m6139b("ProgressService", "encryfilePath" + x);
        if (!TextUtils.isEmpty(x)) {
            File file2 = new File(x);
            C1373c.m6139b("ProgressService", "encryfilePath" + file2.getAbsolutePath());
            if (file2.exists() && file2.delete()) {
                C1373c.m6139b("ProgressService", "file delete success!");
            } else {
                C1373c.m6139b("ProgressService", "file not exist or error! file delete fail!");
            }
        }
    }
}
