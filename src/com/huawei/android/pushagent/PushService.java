package com.huawei.android.pushagent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.p017a.C0642a;
import com.huawei.android.pushagent.p018c.C0663g;
import com.huawei.android.pushagent.p018c.p019a.C0656a;
import com.huawei.android.pushagent.p018c.p019a.C0657e;
import com.huawei.android.pushagent.p020b.C0647a;
import com.huawei.android.pushagent.p020b.p021a.C0646a;
import com.huawei.android.pushagent.p020b.p022b.C0648a;
import com.huawei.android.pushagent.p020b.p022b.C0649c;
import com.huawei.android.pushagent.p020b.p023c.C0650a;
import com.huawei.android.pushagent.p020b.p024e.C0651d;
import com.huawei.android.pushagent.p020b.p025f.C0652a;
import com.huawei.android.pushagent.p020b.p025f.C0653b;
import java.util.Iterator;
import java.util.LinkedList;

public class PushService extends MKService {
    private static String f1145a = "PushLogAC2712";
    private static PushService f1146d = null;
    private LinkedList f1147b = new LinkedList();
    private C0654b f1148c;
    private C0641a f1149e = new C0641a(this);
    private long f1150f = 0;
    private boolean f1151g = false;
    private Context f1152h = null;

    class C0641a extends BroadcastReceiver {
        final /* synthetic */ PushService f1144a;

        C0641a(PushService pushService) {
            this.f1144a = pushService;
        }

        public void m2353a() {
            C0656a.m2506a(this.f1144a.f1152h, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
            C0656a.m2504a(this.f1144a.f1152h, new Intent("com.huawei.intent.action.PUSH").putExtra("EXTRA_INTENT_TYPE", "com.huawei.android.push.intent.HEARTBEAT_REQ").putExtra("heartbeat_interval", 2592000000L).setPackage(this.f1144a.f1152h.getPackageName()));
        }

        public void m2354a(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            for (String addAction : C0663g.m2628a()) {
                intentFilter.addAction(addAction);
            }
            context.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            try {
                PushService.m2357a(intent);
            } catch (Throwable e) {
                C0657e.m2521c(PushService.f1145a, "call PushInnerReceiver:onReceive cause " + e.toString(), e);
            }
        }
    }

    public static synchronized PushService m2356a() {
        PushService pushService;
        synchronized (PushService.class) {
            pushService = f1146d;
        }
        return pushService;
    }

    public static void m2357a(Intent intent) {
        try {
            PushService a = m2356a();
            if (a == null) {
                C0657e.m2522d(f1145a, "sendBroadcast error, pushService is null");
                return;
            }
            C0657e.m2512a(f1145a, "broadcast(),and mReceivers  " + f1146d.f1147b.size());
            a.m2360b(intent);
        } catch (Throwable e) {
            C0657e.m2521c(f1145a, "call PushService:broadcast() cause " + e.toString(), e);
        }
    }

    private void m2358a(C0647a c0647a, IntentFilter intentFilter) {
        this.f1147b.add(c0647a);
    }

    public static void m2359b() {
        if (f1146d != null) {
            f1146d.f1151g = true;
            f1146d.stopService();
        }
    }

    private synchronized void m2360b(Intent intent) {
        if (intent == null) {
            C0657e.m2512a(f1145a, "when broadcastToProcess, intent is null");
        } else {
            C0657e.m2512a(f1145a, "broadcastToProcess, intent is:" + intent.getAction());
            Iterator it = this.f1147b.iterator();
            while (it.hasNext()) {
                this.f1148c.m2500a((C0647a) it.next(), intent);
            }
        }
    }

    private static synchronized void m2361b(PushService pushService) {
        synchronized (PushService.class) {
            f1146d = pushService;
        }
    }

    private void m2363d() {
        try {
            C0657e.m2512a(f1145a, "initProcess(),and mReceivers  " + this.f1147b.size());
            m2358a(new C0650a(this.f1152h), null);
            m2358a(new C0651d(this.f1152h), null);
            m2358a(new C0652a(this.f1152h), null);
            m2358a(new C0653b(this.f1152h), null);
            this.f1149e.m2354a(this.f1152h);
        } catch (Throwable e) {
            C0657e.m2513a(f1145a, "Exception:registerMyReceiver: " + e.toString(), e);
            stopService();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.f1152h = getContext();
        Thread.setDefaultUncaughtExceptionHandler(new C0645a(this));
        super.onCreate();
        try {
            C0657e.m2511a(this.f1152h);
            C0657e.m2517b(f1145a, "PushService:onCreate()");
            this.f1150f = System.currentTimeMillis();
            try {
                this.f1148c = new C0654b(this.f1152h);
                this.f1148c.start();
                int i = 0;
                while (this.f1148c.f1180a == null) {
                    int i2 = i + 1;
                    if (i > 80) {
                        C0657e.m2522d(f1145a, "call mReceiverDispatcher run after " + i2 + ", " + " but handler is null");
                        stopService();
                        return;
                    }
                    Thread.sleep(100);
                    if (i2 % 10 == 0) {
                        C0657e.m2512a(f1145a, "wait hander created: " + i2);
                        i = i2;
                    } else {
                        i = i2;
                    }
                }
                C0646a.m2431a(this.f1152h);
                m2361b(this);
                m2363d();
            } catch (Throwable e) {
                C0657e.m2513a(f1145a, "create ReceiverDispatcher thread or get channelMgr exception ,stopself, " + e.toString(), e);
                stopService();
            }
        } catch (Throwable e2) {
            C0657e.m2513a(f1145a, "Exception:Log.init: " + e2.toString(), e2);
            stopService();
        }
    }

    public void onDestroy() {
        long j = 0;
        C0657e.m2517b(f1145a, "enter PushService:onDestroy(), needExitService is:" + this.f1151g);
        try {
            m2360b(new Intent("com.huawei.android.push.intent.inner.STOP_SERVICE").putExtra("Remote_Package_Name", this.f1152h.getPackageName()).setPackage(this.f1152h.getPackageName()));
        } catch (Throwable e) {
            C0657e.m2521c(f1145a, "call PushService:onDestroy() in broadcastToProcess cause " + e.toString(), e);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e2) {
            C0657e.m2522d(f1145a, e2.toString());
        }
        try {
            if (this.f1149e != null) {
                this.f1149e.m2353a();
                this.f1152h.unregisterReceiver(this.f1149e);
            }
        } catch (Throwable e3) {
            C0657e.m2521c(f1145a, "call PushService:onDestroy() in unregisterReceiver cause " + e3.toString(), e3);
        }
        try {
            if (!(this.f1148c == null || this.f1148c.f1180a == null)) {
                this.f1148c.f1180a.getLooper().quit();
            }
        } catch (Throwable e32) {
            C0657e.m2521c(f1145a, "call PushService:onDestroy() in unregisterReceiver cause " + e32.toString(), e32);
        }
        if (!this.f1151g) {
            long a = System.currentTimeMillis() - this.f1150f > C0648a.m2447a(this.f1152h).m2427w() * 1000 ? 0 : C0649c.m2456a(this.f1152h, "run_time_less_times", 0) + 1;
            if (a == 0) {
                j = C0648a.m2447a(this.f1152h).m2428x() * 1000;
            } else if (a == 1) {
                j = C0648a.m2447a(this.f1152h).m2429y() * 1000;
            } else if (a == 2) {
                j = C0648a.m2447a(this.f1152h).m2430z() * 1000;
            } else if (a >= 3) {
                j = C0648a.m2447a(this.f1152h).m2373A() * 1000;
            }
            C0657e.m2512a(f1145a, "next start time will be " + (j / 1000) + " seconds later" + " run_time_less_times is " + a + "times");
            C0649c.m2460a(this.f1152h, new C0642a("run_time_less_times", Long.class, Long.valueOf(a)));
            C0656a.m2507b(this.f1152h, new Intent("com.huawei.intent.action.PUSH_ON").setPackage(this.f1152h.getPackageName()), j);
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            C0657e.m2517b(f1145a, "PushService onStartCommand");
            if ("com.huawei.android.pushagent".equals(this.f1152h.getPackageName())) {
                C0657e.m2520c(f1145a, "apk provide pushservice");
                Toast.makeText(this.f1152h, "HwPushService.apk error!", 1).show();
                return 2;
            } else if (intent != null) {
                C0657e.m2512a(f1145a, "onStartCommand, intent is:" + intent.toURI());
                m2360b(intent);
                return 1;
            } else {
                C0657e.m2517b(f1145a, "onStartCommand, intent is null ,mybe restart service called by android system");
                return 1;
            }
        } catch (Throwable e) {
            C0657e.m2521c(f1145a, "call PushService:onStartCommand() cause " + e.toString(), e);
            return 1;
        }
    }
}
