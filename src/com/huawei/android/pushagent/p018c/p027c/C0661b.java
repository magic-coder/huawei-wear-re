package com.huawei.android.pushagent.p018c.p027c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.c.c.c;
import com.huawei.android.pushagent.c.h;
import com.huawei.android.pushagent.p018c.C0660a;
import com.huawei.android.pushagent.p018c.p019a.C0656a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p018c.p019a.C0658f;
import com.huawei.android.pushagent.p018c.p019a.C0659h;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import org.apache.log4j.helpers.FileWatchdog;

public class C0661b extends Thread {
    private static C0661b f1193a;
    private static long f1194b = 0;
    private static Handler f1195c = null;
    private static WakeLock f1196d = null;
    private static boolean f1197e = false;
    private static long f1198f = 0;

    static {
        f1193a = null;
        f1193a = new C0661b();
        f1193a.start();
    }

    public static void m2604a() {
        f1194b = System.currentTimeMillis();
    }

    private static void m2605a(Context context) {
        f1196d = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "pushagentPoxy");
    }

    public static void m2606a(Context context, Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        try {
            if (f1196d == null) {
                C0661b.m2605a(context);
            }
            while (f1195c == null && i <= 60) {
                if (i % 20 == 0) {
                    C0657e.m2512a("PushLogAC2712", "when send msg handler is null, waitTimes:" + i);
                }
                i++;
                C0661b.sleep(10);
            }
            if (f1196d != null) {
                f1196d.acquire(500);
            }
            if (f1195c != null) {
                f1195c.postDelayed(new c(context, intent), 1);
            }
        } catch (InterruptedException e) {
            C0657e.m2522d("PushLogAC2712", "call handleEvent cause InterruptedException:" + e.toString());
        } catch (Exception e2) {
            C0657e.m2522d("PushLogAC2712", "call handleEvent cause Exception:" + e2.toString());
        }
        C0657e.m2512a("PushLogAC2712", "PushProxy cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms dealwith " + intent);
    }

    private boolean m2608a(Context context, String str) {
        int q = C0660a.m2594q(context);
        CharSequence r = C0660a.m2595r(context);
        if ("android.intent.action.PACKAGE_ADDED".equals(str) || "android.intent.action.PACKAGE_REMOVED".equals(str) || q == 0 || TextUtils.isEmpty(r)) {
            if (C0662d.m2621a(context)) {
                C0660a.m2562a(context, true);
                q = 1;
            } else {
                q = 2;
                C0660a.m2562a(context, false);
            }
            C0657e.m2512a("PushLogAC2712", "After voting, My service Stats = " + q);
            new C0659h(context, "pushConfig").m2532a("NeedMyServiceRun", Integer.valueOf(q));
        }
        return 1 == q;
    }

    private void m2610b(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                C0661b.m2612c(context, intent);
            }
            h.a(context);
            boolean a = m2608a(context, intent.getAction());
            if (C0660a.m2592o(context)) {
                C0657e.m2512a("PushLogAC2712", "need not current " + context.getPackageName() + " to depose, so exit receiver");
                C0660a.m2560a(context, 3);
                PushService.m2359b();
            } else if (a) {
                C0657e.m2512a("PushLogAC2712", "my pkg " + context.getPackageName() + " need deal with:" + intent);
                m2613d(context, intent);
            } else if (C0660a.m2596s(context)) {
                C0660a.m2562a(context, false);
                C0657e.m2512a("PushLogAC2712", "need not current " + context.getPackageName() + " to depose, so exit receiver");
                C0660a.m2560a(context, 3);
                PushService.m2359b();
            } else {
                C0660a.m2562a(context, true);
                if (("com.huawei.android.push.intent.REGISTER".equals(intent.getAction()) || "com.huawei.android.push.intent.GET_PUSH_STATE".equals(intent.getAction()) || "com.huawei.android.push.intent.DEREGISTER".equals(intent.getAction())) && !intent.getStringExtra("pkg_name").equals(context.getPackageName())) {
                    C0657e.m2512a("PushLogAC2712", "my pkg " + context.getPackageName() + " need not deal with:" + intent);
                } else {
                    m2613d(context, intent);
                }
            }
        }
    }

    private boolean m2611b(Context context) {
        return System.currentTimeMillis() < f1194b || (C0648a.m2447a(context).m2386N() * 1000) + f1194b < System.currentTimeMillis();
    }

    private static void m2612c(Context context, Intent intent) {
        Object obj = "";
        Uri data = intent.getData();
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        String packageName = context.getPackageName();
        C0657e.m2512a("PushLogAC2712", "the Reinstall pkgName:" + obj + ", current PkgName:" + packageName);
        if (!TextUtils.isEmpty(obj) && obj.equals(packageName)) {
            C0660a.m2560a(context, 1);
            C0657e.m2512a("PushLogAC2712", "after apk reinstalled , stop pushservice:" + String.valueOf(context.stopService(new Intent(context, PushService.class))));
        }
    }

    private void m2613d(Context context, Intent intent) {
        if (context != null && intent != null) {
            C0657e.m2512a("PushLogAC2712", "my pkg " + context.getPackageName() + " need deal with:" + intent);
            if (!m2614e(context, intent)) {
                Intent intent2;
                if (m2611b(context)) {
                    C0657e.m2512a("PushLogAC2712", "enter checkBackUp()");
                    C0661b.m2604a();
                    C0660a.m2582f(context);
                    C0660a.m2593p(context);
                }
                if (MKService.getAppContext() == null) {
                    intent2 = new Intent(context, PushService.class);
                    intent2.fillIn(intent, 7);
                } else {
                    intent2 = new Intent();
                    C0657e.m2512a("PushLogAC2712", "MKService.getAppContext() is" + MKService.getAppContext());
                    intent2.setComponent(new ComponentName(context, "com.huawei.deviceCloud.microKernel.push.PushMKService"));
                    intent2.fillIn(intent, 7);
                }
                intent2.setPackage(context.getPackageName());
                C0657e.m2512a("PushLogAC2712", "serviceIntent is" + intent2.toURI());
                context.startService(intent2);
            }
        }
    }

    private boolean m2614e(Context context, Intent intent) {
        C0657e.m2512a("PushLogAC2712", "enter needDelayIntent");
        if (!TextUtils.isEmpty(C0658f.m2526a(context, SdkConstants.DEVICE_INFO, "deviceId"))) {
            C0657e.m2512a("PushLogAC2712", "local deviceId is not empty");
            return false;
        } else if (f1197e) {
            long currentTimeMillis = System.currentTimeMillis() - f1198f;
            if (0 >= currentTimeMillis || currentTimeMillis > FileWatchdog.DEFAULT_DELAY) {
                C0657e.m2512a("PushLogAC2712", "second enter, no deed to wait");
                return false;
            }
            C0657e.m2512a("PushLogAC2712", "second enter, waitting 1 minute");
            intent.setPackage(context.getPackageName());
            C0656a.m2507b(context, intent, FileWatchdog.DEFAULT_DELAY);
            return true;
        } else {
            f1197e = true;
            if (TextUtils.isEmpty(C0660a.m2574c(context))) {
                C0657e.m2512a("PushLogAC2712", "first enter, imei is empty, begin to wait 1 minute");
                f1198f = System.currentTimeMillis();
                intent.setPackage(context.getPackageName());
                C0656a.m2507b(context, intent, FileWatchdog.DEFAULT_DELAY);
                return true;
            }
            C0657e.m2512a("PushLogAC2712", "first enter, imei is not empty, no deed to wait");
            return false;
        }
    }

    public void run() {
        Looper.prepare();
        if (f1195c == null) {
            f1195c = new Handler();
        }
        Looper.loop();
    }
}
