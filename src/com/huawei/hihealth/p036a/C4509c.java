package com.huawei.hihealth.p036a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDataReadOption;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.a.a;
import com.huawei.hihealth.am;
import com.huawei.hihealth.an;
import com.huawei.hihealth.data.p312b.C3951c;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hihealth.data.p312b.C4549a;
import com.huawei.hihealth.data.p312b.C4550d;
import com.huawei.hihealth.data.p312b.C4551e;
import com.huawei.hihealth.data.p312b.C4552f;
import com.huawei.hihealth.data.p312b.C4553g;
import com.huawei.hihealth.p393b.C4536a;
import com.huawei.hihealth.p393b.C4537b;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HiHealthNativeAPI */
public class C4509c implements ServiceConnection, a {
    private static Context f16698a;
    private am f16699b;
    private ExecutorService f16700c;
    private ExecutorService f16701d;
    private ae f16702e;
    private Object f16703f;

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"onServiceConnected() name = ", componentName, " time is ", Long.valueOf(currentTimeMillis)});
        this.f16699b = an.m21692a(iBinder);
        if (this.f16699b == null) {
            C2538c.d("HiH_HiHealthNativeAPI", new Object[]{"onServiceConnected error !", " time is ", Long.valueOf(currentTimeMillis)});
        }
        synchronized (this.f16703f) {
            this.f16703f.notifyAll();
        }
        m21599e();
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"onServiceConnected() end name = ", componentName, " time is ", Long.valueOf(currentTimeMillis)});
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"onServiceDisconnected() name = ", componentName});
        this.f16699b = null;
        m21600f();
    }

    public static C4509c m21594a(Context context) {
        f16698a = context.getApplicationContext();
        return ad.f16697a;
    }

    private C4509c() {
        this.f16702e = new ae();
        this.f16703f = new Object();
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"HiHealthNativeAPI create "});
        this.f16700c = Executors.newSingleThreadExecutor();
        this.f16701d = Executors.newFixedThreadPool(5);
        this.f16700c.execute(new C4510d(this));
    }

    private static Intent m21593a(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"bindService() resolveInfo == null"});
            return null;
        } else if (queryIntentServices.size() == 1) {
            return intent;
        } else {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"bindService() resolveInfo.size = ", Integer.valueOf(queryIntentServices.size())});
            return null;
        }
    }

    private synchronized void m21598d() {
        Object obj = 1;
        synchronized (this) {
            if (this.f16699b == null) {
                long currentTimeMillis = System.currentTimeMillis();
                C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"bindService()! time is ", Long.valueOf(currentTimeMillis)});
                Intent intent = new Intent("com.huawei.hihealthservice.HiHealthService");
                intent.setPackage(WeChat.HEALTH_PACKAGE_NAME);
                intent = C4509c.m21593a(f16698a, intent);
                if (intent == null) {
                    C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"bindService() explicitIntent = null"});
                } else {
                    f16698a.bindService(intent, this, 1);
                    synchronized (this.f16703f) {
                        while (obj != null) {
                            try {
                                this.f16703f.wait(StatisticConfig.MIN_UPLOAD_INTERVAL);
                                obj = null;
                            } catch (InterruptedException e) {
                                C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"bindService() InterruptedException = ", e.getMessage()});
                            }
                        }
                    }
                    C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"bindService bind over mApiAidl is ", this.f16699b, " end time is ", Long.valueOf(currentTimeMillis)});
                }
            }
        }
    }

    public void m21612a(List<Integer> list, C4552f c4552f) {
        this.f16701d.execute(new ab(this, list, c4552f));
    }

    public void m21613a(List<Integer> list, C4553g c4553g) {
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{list});
        this.f16701d.execute(new C4511e(this, list, c4553g));
    }

    public void m21605a(HiAggregateOption hiAggregateOption, C4549a c4549a) {
        this.f16701d.execute(new C4513g(this, hiAggregateOption, c4549a));
    }

    public void m21606a(HiDataInsertOption hiDataInsertOption, C3951c c3951c) {
        this.f16700c.execute(new C4517i(this, hiDataInsertOption, c3951c));
    }

    public void m21607a(HiDataReadOption hiDataReadOption, C4550d c4550d) {
        this.f16701d.execute(new C4519k(this, hiDataReadOption, c4550d));
    }

    public void m21608a(HiDeviceInfo hiDeviceInfo, List<Integer> list, C4551e c4551e) {
        this.f16700c.execute(new C4521m(this, hiDeviceInfo, list, c4551e));
    }

    public void m21610a(HiUserInfo hiUserInfo, C3961b c3961b) {
        this.f16700c.execute(new C4523o(this, hiUserInfo, c3961b));
    }

    public void m21617b(C3961b c3961b) {
        this.f16701d.execute(new C4525q(this, c3961b));
    }

    public void m21609a(HiSyncOption hiSyncOption, C3961b c3961b) {
        this.f16700c.execute(new C4527s(this, hiSyncOption, c3961b));
    }

    public void m21604a(HiAccountInfo hiAccountInfo, C3961b c3961b) {
        this.f16700c.execute(new C4528t(this, hiAccountInfo, c3961b));
    }

    public void m21611a(C3961b c3961b) {
        this.f16701d.execute(new C4530v(this, c3961b));
    }

    public void m21603a(int i, List<HiGoalInfo> list, C3961b c3961b) {
        this.f16700c.execute(new C4532x(this, i, list, c3961b));
    }

    public void m21602a(int i, int i2, C3961b c3961b) {
        this.f16701d.execute(new C4534z(this, i, i2, c3961b));
    }

    public boolean m21615a(HiUserPreference hiUserPreference, boolean z) {
        boolean a;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"setUserPreference can't be called in main thread needNotifyChange = ", Boolean.valueOf(z)});
        }
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"setUserPreference userPreference = ", hiUserPreference, ",needNotifyChange = ", Boolean.valueOf(z)});
        long currentTimeMillis = System.currentTimeMillis();
        m21598d();
        try {
            a = this.f16699b.mo4524a(hiUserPreference, z);
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"setUserPreference e = ", e.getMessage()});
            a = false;
        }
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"setUserPreference result = ", Boolean.valueOf(a), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    public HiUserPreference m21601a(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"getUserPreference can't be called in main thread key = ", str});
        }
        long currentTimeMillis = System.currentTimeMillis();
        HiUserPreference hiUserPreference = null;
        m21598d();
        try {
            hiUserPreference = this.f16699b.mo4530c(str);
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"getUserPreference e = ", e.getMessage()});
        }
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"getUserPreference userPreference = ", hiUserPreference, ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return hiUserPreference;
    }

    public boolean m21614a() {
        Intent intent = new Intent("com.huawei.hihealthservice.HiHealthService");
        intent.setPackage(WeChat.HEALTH_PACKAGE_NAME);
        List queryIntentServices = f16698a.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthServiceExist() resolveInfo == null || resolveInfo.size () != 1 false "});
            return false;
        }
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthServiceExist() true"});
        return true;
    }

    public boolean m21618b(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthLogin can't be called in main thread"});
        }
        if (C4539a.m21748a(str)) {
            C2538c.d("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthLogin huid = null"});
            return false;
        }
        boolean d;
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthLogin"});
        long currentTimeMillis = System.currentTimeMillis();
        m21598d();
        try {
            d = this.f16699b.mo4533d(str);
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthLogin e = ", e.getMessage()});
            d = false;
        }
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"checkHiHealthLogin login = ", Boolean.valueOf(d), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return d;
    }

    public int m21616b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"getHiHealthVersionCode can't be called in main thread"});
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        m21598d();
        try {
            i = this.f16699b.mo4529c();
        } catch (Exception e) {
            C2538c.e("HiH_HiHealthNativeAPI", new Object[]{"getHiHealthVersionCode e = ", e.getMessage()});
        }
        C2538c.c("HiH_HiHealthNativeAPI", new Object[]{"getHiHealthVersion version = ", Integer.valueOf(i), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    private void m21599e() {
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"registerMyBroadcast()"});
        if (WeChat.HEALTH_PACKAGE_NAME.equals(f16698a.getPackageName())) {
            C4537b.m21740a(f16698a, this.f16702e, C4536a.m21738a());
        }
    }

    private void m21600f() {
        C2538c.b("HiH_HiHealthNativeAPI", new Object[]{"unregisteMyBroadcast()"});
        if (WeChat.HEALTH_PACKAGE_NAME.equals(f16698a.getPackageName())) {
            C4537b.m21739a(f16698a, this.f16702e);
        }
    }
}
