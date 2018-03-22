package com.huawei.multisimsdk.p096a.p098b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import com.huawei.multisimsdk.multidevicemanager.f;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.p107a.C1175c;
import com.huawei.multisimsdk.p096a.p097a.C1115a;
import com.huawei.multisimsdk.p096a.p097a.C1118d;
import com.huawei.multisimservice.C1188a;
import com.huawei.multisimservice.C1193f;
import com.huawei.multisimservice.model.C1121b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: AttachedDeviceManager */
public class C1119a {
    private static final HashMap<C1115a, C1126f> f2365h = new HashMap();
    private static final ArrayList<C1115a> f2366i = new ArrayList();
    private static final ArrayList<C1118d> f2367j = new ArrayList();
    private static int f2368k = 1;
    private Context f2369a = null;
    private HandlerThread f2370b = null;
    private C1127g f2371c = null;
    private C1193f f2372d = null;
    private C1188a f2373e = null;
    private String f2374f = null;
    private boolean f2375g = false;
    private C1121b f2376l = new C1122b(this);
    private ServiceConnection f2377m = new C1123c(this);
    private DeathRecipient f2378n = new C1124d(this);

    private void m4989a(Handler handler, int i, Bundle bundle) {
        if (handler == null) {
            C1183h.m5286d("AttachedDeviceManager", "sendMyMessage handler is null.");
            return;
        }
        Looper looper = handler.getLooper();
        if (looper == null) {
            C1183h.m5286d("AttachedDeviceManager", "sendMyMessage looper is null.");
            return;
        }
        Thread thread = looper.getThread();
        if (thread == null) {
            C1183h.m5286d("AttachedDeviceManager", "sendMyMessage thread is null.");
        } else if (thread.isAlive()) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        } else {
            C1183h.m5286d("AttachedDeviceManager", "sendMyMessage the state of the thread is not alive.");
        }
    }

    public static synchronized C1119a m4985a() {
        C1119a c1119a;
        synchronized (C1119a.class) {
            c1119a = C1125e.f2382a;
        }
        return c1119a;
    }

    public int m5006a(Context context) {
        C1183h.m5282b("AttachedDeviceManager", "init");
        if (context == null) {
            C1183h.m5286d("AttachedDeviceManager", "Get instance, context is null.");
            return -1;
        }
        this.f2369a = context.getApplicationContext();
        this.f2374f = context.getPackageName();
        if (this.f2370b == null) {
            this.f2370b = new HandlerThread("AttachedDeviceManager");
            this.f2370b.start();
        }
        if (this.f2371c == null) {
            this.f2371c = new C1127g(this, this.f2370b.getLooper());
        }
        return m5008c();
    }

    public void m5007b() {
        C1183h.m5282b("AttachedDeviceManager", "finish");
        m5009d();
        this.f2369a = null;
        this.f2374f = null;
        this.f2371c = null;
        if (this.f2370b != null) {
            this.f2370b.quit();
            this.f2370b = null;
        }
        f2365h.clear();
        f2366i.clear();
        f2367j.clear();
    }

    private void m4990a(Message message) {
        if (message == null) {
            C1183h.m5286d("AttachedDeviceManager", "msg is null");
            return;
        }
        Bundle data = message.getData();
        synchronized (f2365h) {
            HashMap hashMap = (HashMap) f2365h.clone();
        }
        for (Entry entry : hashMap.entrySet()) {
            C1126f c1126f = (C1126f) entry.getValue();
            if (((C1115a) entry.getKey()).m4981b() == 0) {
                C1183h.m5278a("AttachedDeviceManager", "send message, MSG_GET_DEVICE_INFO_CALLBACK: get attached device multi-sim info.");
                m4989a(c1126f, 7, data);
            } else if (1 == ((C1115a) entry.getKey()).m4981b()) {
                C1183h.m5278a("AttachedDeviceManager", "send message, MSG_IS_NEED_DOWNLOAD_PROFILE_CALLBACK: whether need download profile.");
                m4989a(c1126f, 3, data);
            }
        }
    }

    private void m4997b(int i) {
        ArrayList arrayList;
        C1183h.m5278a("AttachedDeviceManager", "notify service connected status changed, service status = " + i);
        synchronized (f2367j) {
            arrayList = (ArrayList) f2367j.clone();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C1118d) it.next()).m4983a(i);
        }
    }

    public int m5008c() {
        C1183h.m5282b("AttachedDeviceManager", "attemptToBindService : " + f2368k);
        if (this.f2369a == null) {
            C1183h.m5286d("AttachedDeviceManager", "context is null, can't bind service.");
            return -1;
        }
        if (f2368k != 0) {
            C1183h.m5278a("AttachedDeviceManager", "service current status, not connected.");
            Intent intent = new Intent("com.huawei.wearserver.AttachDeviceService");
            intent.setComponent(new ComponentName("com.huawei.bone", "com.huawei.multisimservice.MultiSimService"));
            try {
                this.f2369a.bindService(intent, this.f2377m, 1);
            } catch (Exception e) {
                C1183h.m5286d("AttachedDeviceManager", "bindService exception occurred.");
                return -1;
            }
        }
        C1183h.m5278a("AttachedDeviceManager", "Bind service succeed.");
        return 0;
    }

    public int m5009d() {
        C1183h.m5282b("AttachedDeviceManager", "unBindService: " + f2368k);
        if (this.f2369a == null) {
            C1183h.m5286d("AttachedDeviceManager", "context is null, can't unbind service.");
            return -1;
        }
        if (f2368k == 0) {
            try {
                this.f2369a.unbindService(this.f2377m);
                this.f2373e = null;
                f2368k = 1;
            } catch (IllegalArgumentException e) {
                C1183h.m5286d("AttachedDeviceManager", "unbind service, IllegalArgumentException");
                return -1;
            }
        }
        m4997b(f2368k);
        C1183h.m5278a("AttachedDeviceManager", "Unbind service succeed.");
        return 0;
    }

    private boolean m4994a(ComponentName componentName) {
        if (componentName == null) {
            C1183h.m5286d("AttachedDeviceManager", "checkServiceIdentity, component name is null.");
            return false;
        }
        String packageName = componentName.getPackageName();
        boolean equals = "com.huawei.hwmultisim".equals(this.f2374f);
        C1183h.m5278a("AttachedDeviceManager", "sdkInHwMultiSim = " + equals + ", sdkPkgName = " + this.f2374f + ", servicePkgName = " + packageName);
        if (equals) {
            if (!"com.huawei.bone".equals(packageName)) {
                C1183h.m5284c("AttachedDeviceManager", "checkServiceIdentity: service Package name is not the same with hw wear app");
                return false;
            } else if (this.f2369a == null) {
                C1183h.m5286d("AttachedDeviceManager", "check, context is null");
                return false;
            } else {
                PackageManager packageManager = this.f2369a.getPackageManager();
                String a = C1175c.m5270a("1310403;132b3b330313231313760115605033g353:1b;57;;5e43g32323636330353023a033:35306637352031707f02210323353066373;203:7446525f54575e5f54022103233530663734203:605;565f544b5;565f023e033g353066373b20357;465244565:022;0325353066373a203e6756415g5:5f525`705e5g43525f4:032f243g0207030002070301020203016b243g0707030003050301020203016b0353023a033:35306637352031707f02210323353066373;203:7446525f54575e5f54022103233530663734203:605;565f544b5;565f023e033g353066373b20357;465244565:022;0325353066373a203e6756415g5:5f525`705e5g43525f4:03;2:e033g353:1b;57;;5e43g323232363330;2;g3303;2;:31;2;233;`eea3a0a6707342`7:f25f21g14410gb;5:236g3g75:03b1a153:5ag6e;:e72`a1g;a0e`a2g34a;;eb6g0ef655g671g5gb0516:e43725b37b`5ff7g3125;`07f2gb;4ff07f2:1e27422;fe7ff43f1;7fe5:6g701ab40e16ff4;1ee4::14a7031e14:4f:3:f4e320fg750`17b07g;a:65f76gf41f`eef0gb:b4a23554e2fgb`43130323332033g353:1b;57;;5e43g323236363330;2;2337;a`:33f31176;b`11;012:4g;febae;0g6g:4f3:6;2:efeefe5:45624b35g655;75fa;ba67a2:;e7:02:6:356f`:f3;7a03bg6b5b76a5gfggbb34`13bg3b4`g:a14361:04e3f:a0042:02e:e7::;5506f6;42;eg`g:7:72f3fa6;1g1;2`ae7bg7eg;`2a:;5`715:e11534g44:ff`e;f466567;:2e7a57456b:56f1067:53;6003;", this.f2369a.getString(f.info_string_part_two), this.f2369a.getString(f.info_string_part_three));
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
                    if (packageInfo.signatures == null) {
                        C1183h.m5284c("AttachedDeviceManager", "checkServiceIdentity: signature is null");
                        return false;
                    }
                    for (Signature signature : packageInfo.signatures) {
                        if (signature != null && signature.toCharsString().equals(a)) {
                            return true;
                        }
                    }
                    return false;
                } catch (NameNotFoundException e) {
                    C1183h.m5286d("AttachedDeviceManager", "getPackageInfo NameNotFoundException.");
                    return false;
                }
            }
        } else if (this.f2374f.equals(packageName)) {
            return true;
        } else {
            C1183h.m5284c("AttachedDeviceManager", "sdk and service are not in the same App: sdk:" + this.f2374f + " service:" + packageName);
            return false;
        }
    }
}
