package com.huawei.hwservicesmgr.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.hihealth.a.b;
import com.huawei.p032e.C4392e;
import com.huawei.p032e.C4395h;
import com.huawei.p190v.C2538c;

class RemoteServiceMgr$1 implements ServiceConnection {
    final /* synthetic */ RemoteServiceMgr this$0;

    RemoteServiceMgr$1(RemoteServiceMgr remoteServiceMgr) {
        this.this$0 = remoteServiceMgr;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                C2538c.c("RemoteServiceMgr", new Object[]{"start to authenticate to Huawei Health"});
                IBinder a = C4392e.m21069a(iBinder).mo4445a("com.huawei.bone");
                if (a != null) {
                    C2538c.c("RemoteServiceMgr", new Object[]{"authenticate Successfully"});
                    synchronized (RemoteServiceMgr.access$000()) {
                        if (RemoteServiceMgr.access$100() == null) {
                            RemoteServiceMgr.access$102(C4395h.m21084a(a));
                            if (RemoteServiceMgr.access$100() != null) {
                                HWExerciseAdviceManager.getInstance().setiCallbackInterface(RemoteServiceMgr.access$100());
                                RemoteServiceMgr.access$100().mo4451a(RemoteServiceMgr.access$200(this.this$0));
                                RemoteServiceMgr.access$100().mo4452a(RemoteServiceMgr.access$400().toJson(RemoteServiceMgr.access$300().b()));
                                RemoteServiceMgr.access$100().mo4454a(RemoteServiceMgr.access$500());
                                RemoteServiceMgr.access$100().mo4448a(RemoteServiceMgr.access$600(this.this$0), "PhoneService", "");
                            } else {
                                C2538c.c("RemoteServiceMgr", new Object[]{"iCallbackInterface is null"});
                            }
                        }
                    }
                } else {
                    C2538c.e("RemoteServiceMgr", new Object[]{"remote binder is null, maybe current APP is not authenticated!!!"});
                }
            } catch (Exception e) {
                C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
            }
        } else {
            C2538c.e("RemoteServiceMgr", new Object[]{"remote binder is incorrect, maybe current APP is not authenticated!!!"});
        }
        RemoteServiceMgr.access$700(this.this$0);
        C2538c.c("RemoteServiceMgr", new Object[]{"AIDL remote service has been connected!"});
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2538c.e("RemoteServiceMgr", new Object[]{"Service has unexpectedly disconnected"});
        if (RemoteServiceMgr.access$100() != null) {
            try {
                RemoteServiceMgr.access$100().mo4458b(RemoteServiceMgr.access$200(this.this$0));
            } catch (RemoteException e) {
                C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
            }
        }
        RemoteServiceMgr.access$102(null);
        if (RemoteServiceMgr.access$800(this.this$0) != null) {
            b.a(RemoteServiceMgr.access$1000(this.this$0)).a(RemoteServiceMgr.access$800(this.this$0), RemoteServiceMgr.access$900(this.this$0));
            RemoteServiceMgr.access$802(this.this$0, null);
        }
    }
}
