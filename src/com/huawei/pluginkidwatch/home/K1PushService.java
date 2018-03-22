package com.huawei.pluginkidwatch.home;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.huawei.android.pushagent.PushService;
import com.huawei.p190v.C2538c;
import com.huawei.p190v.p191a.C2535a;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1496p;
import com.huawei.pluginkidwatch.home.receiver.CircleGetPushMessageReceiver;
import java.util.List;

public class K1PushService extends Service {
    CircleGetPushMessageReceiver f4154a = null;
    private Context f4155b = null;
    private Handler f4156c = new Handler();
    private Runnable f4157d = new bm(this);
    private Runnable f4158e = new bn(this);

    public void onCreate() {
        super.onCreate();
        C2538c.m12674b("K1PushService", "==========onCreate");
        this.f4155b = getApplicationContext();
        C2535a.m12642a(C2535a.m12643a(this.f4155b));
        this.f4154a = new CircleGetPushMessageReceiver();
        this.f4155b.registerReceiver(this.f4154a, new IntentFilter("com.huawei.intent.action.PUSH_STATE"));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
        }
        C2538c.m12674b("K1PushService", "==========onStartCommand ");
        if (C1483c.m6829b(this.f4155b)) {
            C2538c.m12674b("K1PushService", "===========In china");
            m7648a(this.f4155b);
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        C2538c.m12674b("K1PushService", "onBind()");
        return null;
    }

    public boolean onUnbind(Intent intent) {
        C2538c.m12674b("K1PushService", "onUnbind()");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        C2538c.m12674b("K1PushService", "onDestroy()");
        super.onDestroy();
        this.f4155b.unregisterReceiver(this.f4154a);
    }

    private void m7648a(Context context) {
        C2538c.m12674b("K1PushService", "==============startPushService");
        if (this.f4155b == null) {
            C2538c.m12674b("K1PushService", "=====startPushService-->mContext is null,return");
            return;
        }
        C1496p.m6934a(context, "k1pushtokenflag", Boolean.valueOf(false));
        new Thread(new bl(this, context)).start();
    }

    private boolean m7651a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        C2538c.m12674b("K1PushService", "setReceiverState:" + context.getPackageName());
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, str), 2, 1);
            return true;
        } catch (Exception e) {
            C2538c.m12674b("K1PushService", e.getMessage());
            return false;
        }
    }

    private void m7649a(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.m12674b("K1PushService", "startService-->return");
            return;
        }
        Intent intent2 = new Intent(context, PushService.class);
        intent2.fillIn(intent, 7);
        intent2.setPackage(context.getPackageName());
        C2538c.m12674b("K1PushService", "serviceIntent is" + intent2.toURI());
        context.startService(intent2);
    }

    private void m7647a() {
        if (this.f4155b == null) {
            C2538c.m12674b("K1PushService", "========getPushState -- >mContext is null");
        } else if (m7654b(this.f4155b, "com.huawei.android.pushagent.PushService") || C1492l.m6912a()) {
            C2538c.m12674b("K1PushService", "========Enter getPushState");
            Intent intent = new Intent("com.huawei.android.push.intent.GET_PUSH_STATE");
            intent.putExtra("pkg_name", this.f4155b.getPackageName());
            intent.setPackage(this.f4155b.getPackageName());
            intent.setFlags(32);
            LocalBroadcastManager.getInstance(this.f4155b).sendBroadcast(intent);
        } else {
            C2538c.m12674b("K1PushService", "========NetWork is available ?", C1492l.m6916b(this.f4155b) + "");
            C2538c.m12674b("K1PushService", "========PUSH 服务不存在，重新进行get Token");
            C1496p.m6934a(this.f4155b, "k1pushtokenflag", Boolean.valueOf(false));
            m7648a(this.f4155b);
        }
    }

    private boolean m7654b(Context context, String str) {
        C2538c.m12674b("K1PushService", "=====Enter isServiceRunning");
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(50);
        if (runningServices == null || runningServices.size() <= 0) {
            return false;
        }
        boolean z;
        for (int i = 0; i < runningServices.size(); i++) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str)) {
                z = true;
                break;
            }
        }
        z = false;
        C2538c.m12674b("K1PushService", "=====Leave isServiceRunning isRunning：" + z);
        return z;
    }
}
