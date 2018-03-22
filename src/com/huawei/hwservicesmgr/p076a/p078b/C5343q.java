package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Message;
import com.huawei.datatype.TransferTaskInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.TransferFileInfo;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.a.b.p;
import com.huawei.hwservicesmgr.datetype.C5359a;
import com.huawei.hwservicesmgr.r;
import com.huawei.p029c.C4334c;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskQueue */
class C5343q implements IBaseResponseCallback {
    final /* synthetic */ p f19084a;

    C5343q(p pVar) {
        this.f19084a = pVar;
    }

    public void onResponse(int i, Object obj) {
        Object obj2 = null;
        synchronized (p.b()) {
            C2538c.c("HWFileTransferTaskQueue", new Object[]{"myCallback 进入锁"});
            if (p.c().size() <= 0) {
                C2538c.c("HWFileTransferTaskQueue", new Object[]{"callbacks size is 0 return!!!"});
                return;
            }
            Object obj3;
            C2538c.c("HWFileTransferTaskQueue", new Object[]{"myCallback 文件传输完毕，将返回值返回给上层 callbacks.size() = " + p.c().size() + " callbacks.get(0).getType() = " + ((TransferFileInfo) p.c().get(0)).getType()});
            int type = ((TransferFileInfo) p.c().get(0)).getType();
            if (1 == ((TransferFileInfo) p.c().get(0)).getType()) {
                obj3 = (C4334c) ((TransferFileInfo) p.c().get(0)).getCallback();
            } else {
                obj3 = null;
                r rVar = (r) ((TransferFileInfo) p.c().get(0)).getCallback();
            }
            p.c().remove(0);
            if (p.c().size() != 0) {
                C2538c.c("HWFileTransferTaskQueue", new Object[]{"myCallback 队列中还有数据，继续传输"});
                p.b(this.f19084a).a((TransferFileInfo) p.c().get(0), p.a(this.f19084a));
            } else {
                PhoneService.a(-1);
            }
            C2538c.c("HWFileTransferTaskQueue", new Object[]{"myCallback 文件传输完毕，将返回值返回给上层 callbacks.size() = " + p.c().size()});
            Message obtainMessage = p.c(this.f19084a).obtainMessage();
            if (obj3 != null) {
                TransferTaskInfo transferTaskInfo = new TransferTaskInfo();
                transferTaskInfo.setObject1(obj3);
                transferTaskInfo.setObject2(obj);
                obtainMessage.obj = transferTaskInfo;
                obtainMessage.what = 1;
                obtainMessage.arg1 = i;
                p.c(this.f19084a).sendMessage(obtainMessage);
            } else if (obj2 != null) {
                TransferTaskInfo transferTaskInfo2;
                if (2 != type) {
                    if (3 == type) {
                        if (10000 == i) {
                            transferTaskInfo2 = new TransferTaskInfo();
                            transferTaskInfo2.setObject1(obj2);
                            transferTaskInfo2.setObject2(null);
                            transferTaskInfo2.setObject3(null);
                            obtainMessage.obj = transferTaskInfo2;
                            obtainMessage.what = 0;
                            obtainMessage.arg1 = i;
                            p.c(this.f19084a).sendMessage(obtainMessage);
                        } else if (HWDeviceDFXConstants.ERROR_CODE_GET_FILE_LEO_NAME_ERROR != i) {
                            C2538c.c("HWFileTransferTaskQueue", new Object[]{"110002闭合"});
                        } else {
                            transferTaskInfo2 = new TransferTaskInfo();
                            transferTaskInfo2.setObject1(obj2);
                            transferTaskInfo2.setObject2(obj.toString());
                            obtainMessage.obj = transferTaskInfo2;
                            obtainMessage.what = 0;
                            obtainMessage.arg1 = i;
                            p.c(this.f19084a).sendMessage(obtainMessage);
                        }
                    } else if (10000 == i) {
                        transferTaskInfo2 = new TransferTaskInfo();
                        transferTaskInfo2.setObject1(obj2);
                        transferTaskInfo2.setObject2(null);
                        transferTaskInfo2.setObject3(null);
                        obtainMessage.obj = transferTaskInfo2;
                        obtainMessage.what = 0;
                        obtainMessage.arg1 = i;
                        p.c(this.f19084a).sendMessage(obtainMessage);
                    } else if (HWDeviceDFXConstants.ERROR_CODE_GET_FILE_LEO_NAME_ERROR != i) {
                        transferTaskInfo2 = new TransferTaskInfo();
                        transferTaskInfo2.setObject1(obj2);
                        transferTaskInfo2.setObject2(obj.toString());
                        obtainMessage.obj = transferTaskInfo2;
                        obtainMessage.what = 0;
                        obtainMessage.arg1 = i;
                        p.c(this.f19084a).sendMessage(obtainMessage);
                    } else {
                        C2538c.c("HWFileTransferTaskQueue", new Object[]{"110002闭合"});
                    }
                } else if (10000 == i) {
                    C5359a c5359a = (C5359a) obj;
                    String a = c5359a.m25816a();
                    String b = c5359a.m25818b();
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"getDataPath :" + a});
                    C2538c.c("HWFileTransferTaskQueue", new Object[]{"getStatusPath :" + b});
                    TransferTaskInfo transferTaskInfo3 = new TransferTaskInfo();
                    transferTaskInfo3.setObject1(obj2);
                    transferTaskInfo3.setObject2(a);
                    transferTaskInfo3.setObject3(b);
                    obtainMessage.obj = transferTaskInfo3;
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = i;
                    p.c(this.f19084a).sendMessage(obtainMessage);
                } else {
                    transferTaskInfo2 = new TransferTaskInfo();
                    transferTaskInfo2.setObject1(obj2);
                    transferTaskInfo2.setObject2(obj.toString());
                    obtainMessage.obj = transferTaskInfo2;
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = i;
                    p.c(this.f19084a).sendMessage(obtainMessage);
                }
            }
            C2538c.c("HWFileTransferTaskQueue", new Object[]{"myCallback 退出锁"});
        }
    }
}
