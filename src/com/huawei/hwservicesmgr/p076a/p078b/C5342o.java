package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Handler;
import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.hwservicesmgr.datetype.C5362d;
import com.huawei.p190v.C2538c;

import java.util.HashMap;

/* compiled from: HWFileTransferTaskManager */
class C5342o extends Handler {
    final /* synthetic */ d f19083a;

    private C5342o(d dVar) {
        this.f19083a = dVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.c("HWFileTransferTaskManager", new Object[]{"handleMessage msg = " + message.what});
        try {
            byte[] bArr;
            IBaseResponseCallback f;
            switch (message.what) {
                case 1:
                    if (d.a(this.f19083a) != null) {
                        d.a(this.f19083a).removeMessages(15);
                    }
                    bArr = (byte[]) message.obj;
                    if (8 == bArr.length && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
                        this.f19083a.d();
                        if (d.f(this.f19083a) != null) {
                            d.f(this.f19083a).onResponse(HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR, C0973a.a(bArr));
                            return;
                        }
                        return;
                    }
                    d.b(this.f19083a, d.n(this.f19083a).unGetGPSFileName((byte[]) message.obj));
                    return;
                case 2:
                    if (d.a(this.f19083a) != null) {
                        d.a(this.f19083a).removeMessages(15);
                    }
                    d.c(this.f19083a, d.n(this.f19083a).unGetMaintParameters((byte[]) message.obj));
                    return;
                case 3:
                    if (d.a(this.f19083a) != null) {
                        d.a(this.f19083a).removeMessages(15);
                    }
                    bArr = (byte[]) message.obj;
                    if (8 == bArr.length && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
                        this.f19083a.d();
                        if (d.f(this.f19083a) != null) {
                            d.f(this.f19083a).onResponse(10002, C0973a.a(bArr));
                            return;
                        }
                        return;
                    }
                    d.d(this.f19083a, d.n(this.f19083a).unQueryFileInformation((byte[]) message.obj));
                    return;
                case 4:
                    if (d.a(this.f19083a) != null) {
                        d.a(this.f19083a).removeMessages(15);
                    }
                    d.e(this.f19083a, d.n(this.f19083a).getAckCode((byte[]) message.obj));
                    return;
                case 5:
                    d.a(this.f19083a, d.n(this.f19083a).unGPSApplyDataFromDevice((byte[]) message.obj), 0);
                    return;
                case 7:
                    d.i(this.f19083a);
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"gps timeout reTransforTime = " + d.j(this.f19083a)});
                    if (d.j(this.f19083a) == 3) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"大于3次失败 reTransforTime = 3"});
                        this.f19083a.d();
                        if (d.f(this.f19083a) != null) {
                            d.f(this.f19083a).onResponse(10002, d.k(this.f19083a));
                        }
                        if (d.a(this.f19083a) != null) {
                            d.a(this.f19083a).removeMessages(7);
                            return;
                        }
                        return;
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"timeout maintLogs.size() = " + d.l(this.f19083a).size()});
                    if (d.l(this.f19083a).size() != 0) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"丢包写入"});
                        d.l(this.f19083a).clear();
                    }
                    if (d.a(this.f19083a) != null) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"丢包重发"});
                        this.f19083a.b();
                        d.a(this.f19083a).sendEmptyMessageDelayed(7, (long) d.m(this.f19083a));
                        return;
                    }
                    return;
                case 10:
                    if (d.c(this.f19083a) == null || d.c(this.f19083a).size() <= 0) {
                        f = d.f(this.f19083a);
                        this.f19083a.d();
                        if (f != null) {
                            f.onResponse(10000, new Object[]{d.g(this.f19083a), d.h(this.f19083a)});
                        } else {
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"callback is null"});
                        }
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenance success  ***"});
                        return;
                    }
                    d.a(this.f19083a, ((C5362d) d.c(this.f19083a).get(0)).m25829b());
                    d.a(this.f19083a, ((C5362d) d.c(this.f19083a).get(0)).m25831c());
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"start queryFileInformation fileName = " + d.d(this.f19083a) + " fileType = " + d.e(this.f19083a)});
                    if (d.d(this.f19083a) == null || "".equals(d.d(this.f19083a))) {
                        d.c(this.f19083a).remove(0);
                        d.a(this.f19083a).sendEmptyMessage(10);
                        return;
                    }
                    d.b(this.f19083a, d.d(this.f19083a));
                    return;
                case 15:
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"data transfer time out ...."});
                    this.f19083a.d();
                    if (d.f(this.f19083a) != null) {
                        d.f(this.f19083a).onResponse(10001, "timeout");
                        return;
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenanceCallback is null!"});
                    return;
                case 16:
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"PROCESS_NEXT_TASK "});
                    f = d.f(this.f19083a);
                    this.f19083a.d();
                    if (f != null) {
                        f.onResponse(10000, new Object[]{new HashMap(), new HashMap()});
                    } else {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"callback is null"});
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenance success ***"});
                    return;
                case 127:
                    d.a(this.f19083a, d.n(this.f19083a).getErrorCode((byte[]) message.obj));
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            C2538c.e("HWFileTransferTaskManager", new Object[]{"handleMessage() Exception e = ", e.getMessage()});
        }
        C2538c.e("HWFileTransferTaskManager", new Object[]{"handleMessage() Exception e = ", e.getMessage()});
    }
}
