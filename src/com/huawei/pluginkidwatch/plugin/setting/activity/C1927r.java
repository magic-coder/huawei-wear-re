package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.kidsdevice.ResetManagerRsp;
import com.huawei.p190v.C2538c;

/* compiled from: BindbyQrActivity */
class C1927r implements a<Boolean> {
    final /* synthetic */ C1926q f6695a;

    C1927r(C1926q c1926q) {
        this.f6695a = c1926q;
    }

    public void m10118a(Boolean bool, String str, boolean z) {
        int i;
        long j = 0;
        int i2 = -1;
        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager operationResult ...");
        ResetManagerRsp resetManagerRsp;
        if (z) {
            C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager sucess!!!");
            try {
                resetManagerRsp = (ResetManagerRsp) new Gson().fromJson(str, ResetManagerRsp.class);
                if (resetManagerRsp != null) {
                    i2 = resetManagerRsp.getResultCode();
                }
                if (i2 == 0) {
                    j = resetManagerRsp.getwatchNo();
                }
                this.f6695a.f6694b.m9776j(String.valueOf(j));
                C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager sucess deviceCode = " + r0);
            } catch (JsonSyntaxException e) {
                C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager 1111  json exception :" + e.getMessage());
            }
            if (this.f6695a.f6694b.f6288x != null) {
                this.f6695a.f6694b.f6288x.post(new C1928s(this));
                i = 1;
            }
            i = 0;
        } else {
            try {
                resetManagerRsp = (ResetManagerRsp) new Gson().fromJson(str, ResetManagerRsp.class);
                if (resetManagerRsp != null) {
                    i2 = resetManagerRsp.getResultCode();
                }
                switch (i2) {
                    case 0:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager 1111 sucess!!!");
                        if (i2 == 0) {
                            j = resetManagerRsp.getwatchNo();
                        }
                        this.f6695a.f6694b.m9776j(String.valueOf(j));
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager 1111 sucess deviceCode = " + r0);
                        if (this.f6695a.f6694b.f6288x != null) {
                            this.f6695a.f6694b.f6288x.post(new C1929t(this));
                            break;
                        }
                        break;
                    case 1001:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager parameter wrongful!!!");
                        break;
                    case 1003:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager conversation expire!!!");
                        break;
                    case 1004:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager token expire!!!");
                        break;
                    case 13237:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager manager number not same!!!");
                        break;
                    default:
                        C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager unknow error!!!  resultCode = " + i2);
                        break;
                }
                i = 0;
            } catch (JsonSyntaxException e2) {
                C2538c.m12677c(this.f6695a.f6694b.f6266b, "matb resetManager json exception :" + e2.getMessage());
            }
        }
        if (i == 0 && this.f6695a.f6694b.f6288x != null) {
            this.f6695a.f6694b.f6288x.post(new C1930u(this));
        }
    }
}
