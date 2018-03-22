package com.huawei.hwdatamigrate.hihealth.p069e;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.huawei.hihealth.HiHealthClient;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.as;
import com.huawei.hwdatamigrate.hihealth.e.a;
import com.huawei.p190v.C2538c;

/* compiled from: ListenerManager */
class C4889b implements Runnable {
    final /* synthetic */ int f17907a;
    final /* synthetic */ HiHealthClient f17908b;
    final /* synthetic */ String f17909c;
    final /* synthetic */ HiHealthData f17910d;
    final /* synthetic */ a f17911e;

    C4889b(a aVar, int i, HiHealthClient hiHealthClient, String str, HiHealthData hiHealthData) {
        this.f17911e = aVar;
        this.f17907a = i;
        this.f17908b = hiHealthClient;
        this.f17909c = str;
        this.f17910d = hiHealthData;
    }

    public void run() {
        RemoteCallbackList remoteCallbackList = (RemoteCallbackList) a.a(this.f17911e).get(this.f17907a);
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    ((as) remoteCallbackList.getBroadcastItem(i)).mo4487a(this.f17907a, this.f17908b, this.f17909c, this.f17910d, System.currentTimeMillis());
                }
            } catch (RemoteException e) {
                C2538c.e("Debug_ListenerManager", new Object[]{"RemoteException = " + e.getMessage()});
            } finally {
                remoteCallbackList.finishBroadcast();
            }
        }
    }
}
