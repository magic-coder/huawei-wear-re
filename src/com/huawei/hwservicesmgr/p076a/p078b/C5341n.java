package com.huawei.hwservicesmgr.p076a.p078b;

import android.os.Handler;
import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.common.C4804j;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwdevicedfxmanager.utils.DetailSleepUtil;
import com.huawei.hwdevicedfxmanager.utils.MaintenanceUtil;
import com.huawei.hwservicesmgr.a.b.d;
import com.huawei.hwservicesmgr.datetype.C5359a;
import com.huawei.p190v.C2538c;

/* compiled from: HWFileTransferTaskManager */
class C5341n extends Handler {
    final /* synthetic */ d f19082a;

    private C5341n(d dVar) {
        this.f19082a = dVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (9 != message.what) {
            C2538c.c("HWFileTransferTaskManager", new Object[]{"handleMessage msg = " + message.what});
        }
        try {
            byte[] bArr;
            switch (message.what) {
                case 1:
                    if (d.a(this.f19082a) != null) {
                        d.a(this.f19082a).removeMessages(15);
                    }
                    bArr = (byte[]) message.obj;
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"info == " + C0973a.a(bArr)});
                    if (8 != bArr.length || TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
                        d.g(this.f19082a, d.n(this.f19082a).unGetFileName((byte[]) message.obj));
                        return;
                    } else if (d.a(this.f19082a, bArr)) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"is LEO return "});
                        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(10), "last_trigger_beta_log_time", String.valueOf(0), new com.huawei.hwdataaccessmodel.a.c(0));
                        this.f19082a.f();
                        if (d.a(this.f19082a) != null) {
                            d.a(this.f19082a).sendEmptyMessageDelayed(15, 600000);
                        }
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"isgetlog_from_aboutactivity  == " + C4804j.m23007a(BaseApplication.b(), HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY)});
                        if (!C4804j.m23007a(BaseApplication.b(), HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY).booleanValue() && d.f(this.f19082a) != null) {
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"is LEO return  callback"});
                            d.f(this.f19082a).onResponse(HWDeviceDFXConstants.ERROR_CODE_GET_FILE_LEO_NAME_ERROR, null);
                            return;
                        }
                        return;
                    } else {
                        this.f19082a.e();
                        if (d.f(this.f19082a) != null) {
                            d.p(this.f19082a).onDestroyMaintenance();
                            d.f(this.f19082a).onResponse(10002, C0973a.a(bArr));
                            return;
                        }
                        return;
                    }
                case 2:
                    if (d.a(this.f19082a) != null) {
                        d.a(this.f19082a).removeMessages(15);
                    }
                    d.h(this.f19082a, d.n(this.f19082a).unGetMaintParameters((byte[]) message.obj));
                    return;
                case 3:
                    if (d.a(this.f19082a) != null) {
                        d.a(this.f19082a).removeMessages(15);
                    }
                    bArr = (byte[]) message.obj;
                    if (8 == bArr.length && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
                        this.f19082a.e();
                        if (d.f(this.f19082a) != null) {
                            d.p(this.f19082a).onDestroyMaintenance();
                            if (d.p(this.f19082a) instanceof DetailSleepUtil) {
                                d.p(this.f19082a).setMaintRetryResult(true);
                            }
                            d.f(this.f19082a).onResponse(10002, C0973a.a(bArr));
                            return;
                        }
                        return;
                    }
                    d.i(this.f19082a, d.n(this.f19082a).unQueryFileInformation((byte[]) message.obj));
                    return;
                case 4:
                    d.j(this.f19082a, d.n(this.f19082a).getAckCodeExt((byte[]) message.obj));
                    return;
                case 5:
                    d.k(this.f19082a, d.n(this.f19082a).unApplyDataFromDevice((byte[]) message.obj));
                    return;
                case 7:
                    d.i(this.f19082a);
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"timeout reTransforTime = " + d.j(this.f19082a)});
                    if (d.j(this.f19082a) == 3) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"大于3次失败 reTransforTime = 3"});
                        this.f19082a.e();
                        if (d.f(this.f19082a) != null) {
                            d.p(this.f19082a).cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                            if (d.p(this.f19082a) instanceof DetailSleepUtil) {
                                d.p(this.f19082a).setMaintRetryResult(true);
                            }
                            d.f(this.f19082a).onResponse(10002, d.k(this.f19082a));
                        } else {
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenanceCallback is null!"});
                        }
                        if (d.a(this.f19082a) != null) {
                            d.a(this.f19082a).removeMessages(7);
                            return;
                        }
                        return;
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"timeout maintLogs.size() = " + d.l(this.f19082a).size()});
                    if (d.a(this.f19082a) != null) {
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"丢包重发"});
                        this.f19082a.c();
                        d.a(this.f19082a).sendEmptyMessageDelayed(7, (long) d.m(this.f19082a));
                        return;
                    }
                    return;
                case 10:
                    if (d.o(this.f19082a) == null || d.o(this.f19082a).size() <= 0) {
                        IBaseResponseCallback f = d.f(this.f19082a);
                        this.f19082a.e();
                        d.p(this.f19082a).onDestroyMaintenance();
                        if (f != null) {
                            d.p(this.f19082a).cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"!!dataPath = " + d.p(this.f19082a).getmTransferDataContentPath()});
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"!!statePath = " + d.p(this.f19082a).getmTransferStateContentPath()});
                            C5359a c5359a = new C5359a();
                            c5359a.m25817a(d.p(this.f19082a).getmTransferDataContentPath());
                            c5359a.m25819b(d.p(this.f19082a).getmTransferStateContentPath());
                            f.onResponse(10000, c5359a);
                        } else {
                            C2538c.c("HWFileTransferTaskManager", new Object[]{"callback is null"});
                        }
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenance success  ***"});
                        return;
                    }
                    d.a(this.f19082a, (String) d.o(this.f19082a).get(0));
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"start querySleepOrDFXFileInformation fileName = " + d.d(this.f19082a)});
                    d.b(this.f19082a, -1);
                    d.c(this.f19082a, d.d(this.f19082a));
                    return;
                case 11:
                    if (d.a(this.f19082a) != null) {
                        d.a(this.f19082a).removeMessages(15);
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"isgetlog_from_aboutactivity  == " + C4804j.m23007a(BaseApplication.b(), HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY)});
                    if (C4804j.m23007a(BaseApplication.b(), HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY).booleanValue()) {
                        this.f19082a.a(d.q(this.f19082a), d.f(this.f19082a));
                        C2538c.c("HWFileTransferTaskManager", new Object[]{"isgetlog_from_aboutactivity  =false= "});
                        C4804j.m23009a(BaseApplication.b(), HWDeviceDFXConstants.ISGETLOG_FROM_ABOUTACTIVITY, Boolean.valueOf(false));
                        return;
                    }
                    C2538c.b("HWFileTransferTaskManager", new Object[]{"the version is not beta. do not support 11"});
                    return;
                case 15:
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"data transfer time out ...."});
                    this.f19082a.e();
                    if (d.f(this.f19082a) != null) {
                        d.p(this.f19082a).cutFolder(MaintenanceUtil.LOG_PATH_TEMP, MaintenanceUtil.LOG_PATH);
                        if (d.p(this.f19082a) instanceof DetailSleepUtil) {
                            d.p(this.f19082a).setMaintRetryResult(true);
                        }
                        d.f(this.f19082a).onResponse(10001, "30s timeout");
                        return;
                    }
                    C2538c.c("HWFileTransferTaskManager", new Object[]{"maintenanceCallback is null!"});
                    return;
                case 127:
                    d.f(this.f19082a, d.n(this.f19082a).getErrorCode((byte[]) message.obj));
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
