package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwservicesmgr.a.b.q;
import com.huawei.hwservicesmgr.a.b.r;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWFileTransferTaskQueue */
public class C1041p {
    private static final List<TransferFileInfo> f2026a = new ArrayList();
    private static final Object f2027b = new Object();
    private static C1041p f2028c;
    private C1040d f2029d;
    private Handler f2030e;
    private IBaseResponseCallback f2031f;

    public static C1041p m4346a() {
        if (f2028c == null) {
            f2028c = new C1041p();
        }
        return f2028c;
    }

    private C1041p() {
        this.f2029d = null;
        this.f2030e = null;
        this.f2031f = new q(this);
        this.f2029d = C1040d.m4273a();
        HandlerThread handlerThread = new HandlerThread("HWFileTransferTaskQueue");
        handlerThread.start();
        this.f2030e = new r(handlerThread.getLooper());
    }

    public void m4353a(TransferFileInfo transferFileInfo, Object obj) {
        synchronized (C1041p.m4352d()) {
            C2538c.m12677c("HWFileTransferTaskQueue", "getFile 进入锁");
            if (f2026a.size() == 0) {
                C2538c.m12677c("HWFileTransferTaskQueue", "getFile size = 0");
                transferFileInfo.setCallback(obj);
                C2538c.m12677c("HWFileTransferTaskQueue", "getFile transferFileInfo.getCallback() = " + transferFileInfo.getCallback() + " transferFileInfo.getType() = " + transferFileInfo.getType());
                f2026a.add(transferFileInfo);
                this.f2029d.m4337a(transferFileInfo, this.f2031f);
            } else {
                C2538c.m12677c("HWFileTransferTaskQueue", "getFile size != 0");
                transferFileInfo.setCallback(obj);
                C2538c.m12677c("HWFileTransferTaskQueue", "getFile transferFileInfo.getCallback() = " + transferFileInfo.getCallback() + " transferFileInfo.getType() = " + transferFileInfo.getType());
                m4347a(f2026a, transferFileInfo);
            }
            C2538c.m12677c("HWFileTransferTaskQueue", "getFile 退出锁");
        }
    }

    private static synchronized Object m4352d() {
        Object obj;
        synchronized (C1041p.class) {
            obj = f2027b;
        }
        return obj;
    }

    private void m4347a(List<TransferFileInfo> list, TransferFileInfo transferFileInfo) {
        Object obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (transferFileInfo.getType() == ((TransferFileInfo) list.get(i)).getType()) {
                list.remove(list.get(i));
                list.add(i, transferFileInfo);
                obj = 1;
                break;
            }
        }
        if (obj == null) {
            list.add(transferFileInfo);
        }
    }
}
