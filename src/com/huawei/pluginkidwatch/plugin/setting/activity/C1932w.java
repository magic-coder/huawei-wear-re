package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.Banlance;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1388d;
import com.sina.weibo.sdk.statistic.StatisticConfig;

/* compiled from: CheckBillActivity */
class C1932w implements C1378e {
    final /* synthetic */ CheckBillActivity f6700a;

    C1932w(CheckBillActivity checkBillActivity) {
        this.f6700a = checkBillActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("CheckBillActivity", "=checkBill=   GET_BILLINFO_FROMCLOUD_FAILURE ");
            this.f6700a.f6297b.sendEmptyMessage(4);
            return;
        }
        C2538c.m12674b("CheckBillActivity", "=checkBill=   GET_BILLINFO_FROMCLOUD_SUCCESS");
        this.f6700a.f6317v = new C1388d();
        if (baseEntityModel instanceof WatchStatusIOModel) {
            WatchStatusIOModel watchStatusIOModel = (WatchStatusIOModel) baseEntityModel;
            if (watchStatusIOModel.watchStatus == null) {
                C2538c.m12680e("CheckBillActivity", "=checkBill= watchStatus is null");
            } else if (watchStatusIOModel.watchStatus.banlance == null) {
                C2538c.m12680e("CheckBillActivity", "=checkBill=  banlance is null");
            } else {
                C2538c.m12674b("CheckBillActivity", "=checkBill=  watchStatus = " + watchStatusIOModel.watchStatus.toString());
                Banlance banlance = watchStatusIOModel.watchStatus.banlance;
                C2538c.m12674b("CheckBillActivity", "=checkBill= temStatus toString =" + banlance.toString());
                this.f6700a.f6317v.f3046g = C1462f.m6746j();
                this.f6700a.f6317v.f3042c = banlance.getTime();
                this.f6700a.f6317v.f3041b = banlance.getBalanceMessage();
                long f = C1492l.m6922f(this.f6700a.f6317v.f3042c);
                C2538c.m12674b("CheckBillActivity", "=checkBill=  getBillInfoFromCloud  lastDBtime :" + this.f6700a.f6318w + " >= billtime :" + f);
                if (this.f6700a.f6318w >= f) {
                    C2538c.m12674b("CheckBillActivity", "=checkBill=  getBillInfoFromCloud  lastDBtime  >= billtime");
                    this.f6700a.f6317v = null;
                    C2538c.m12674b("CheckBillActivity", "=checkBill=  getBillInfoFromCloud  isFromClick  : " + this.f6700a.f6321z);
                    if (this.f6700a.f6321z) {
                        this.f6700a.f6297b.postDelayed(this.f6700a.f6294D, StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    return;
                }
                this.f6700a.f6318w = f;
                C2538c.m12674b("CheckBillActivity", "=checkBill=  billContent = " + this.f6700a.f6317v.f3041b);
                this.f6700a.m9791a(this.f6700a.f6317v.f3041b);
            }
        }
    }
}
