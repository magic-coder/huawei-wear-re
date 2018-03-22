package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.datatype.TransferTaskInfo;
import com.huawei.hwfitnessmgr.receiver.SyncFitnessDetailDataBroadcastReceiver;
import com.huawei.hwservicesmgr.r;
import com.huawei.p029c.C4334c;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskQueue */
class C5344r extends Handler {
    C5344r(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        TransferTaskInfo transferTaskInfo = (TransferTaskInfo) message.obj;
        r rVar;
        switch (message.what) {
            case 0:
                try {
                    rVar = (r) transferTaskInfo.getObject1();
                    if (rVar != null) {
                        C2538c.c("HWFileTransferTaskQueue", new Object[]{"可维可测返回"});
                        if (10000 == message.arg1) {
                            rVar.onSuccess(message.arg1, null, null);
                            return;
                        } else {
                            rVar.onFailure(message.arg1, transferTaskInfo.getObject2().toString());
                            return;
                        }
                    }
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"可维可测返回 dfxCallback = null"});
                    return;
                } catch (RemoteException e) {
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"可维可测返回 异常 e = " + e});
                    return;
                }
            case 1:
                C2538c.c("HWFileTransferTaskQueue", new Object[]{"GPS返回"});
                ((C4334c) transferTaskInfo.getObject1()).onResponse(message.arg1, transferTaskInfo.getObject2());
                return;
            case 2:
                try {
                    rVar = (r) transferTaskInfo.getObject1();
                    if (rVar != null) {
                        C2538c.c("HWFileTransferTaskQueue", new Object[]{"精细化睡眠返回"});
                        String str = "";
                        String str2 = "";
                        String str3 = "";
                        String str4;
                        if (10000 == message.arg1) {
                            if (transferTaskInfo.getObject2() != null) {
                                str3 = (String) transferTaskInfo.getObject2();
                            } else {
                                str3 = str;
                            }
                            if (transferTaskInfo.getObject3() != null) {
                                str4 = (String) transferTaskInfo.getObject3();
                            } else {
                                str4 = str2;
                            }
                            rVar.onSuccess(message.arg1, str3, str4);
                            return;
                        }
                        if (transferTaskInfo.getObject2() != null) {
                            str4 = (String) transferTaskInfo.getObject2();
                        } else {
                            str4 = str3;
                        }
                        rVar.onFailure(message.arg1, str4);
                        return;
                    }
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"精细化睡眠返回 sleepCallback = null"});
                    return;
                } catch (RemoteException e2) {
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"精细化睡眠返回 异常 e = " + e2});
                    SyncFitnessDetailDataBroadcastReceiver.b();
                    return;
                }
            default:
                return;
        }
    }
}
