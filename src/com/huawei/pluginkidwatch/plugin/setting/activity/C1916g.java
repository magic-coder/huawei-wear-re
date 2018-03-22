package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: BindbyQrActivity */
class C1916g implements C1378e {
    final /* synthetic */ BindbyQrActivity f6681a;

    C1916g(BindbyQrActivity bindbyQrActivity) {
        this.f6681a = bindbyQrActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b(this.f6681a.f6266b, "=======bindcallback======");
        this.f6681a.f6263A = "";
        this.f6681a.f6281q.setVisibility(8);
        this.f6681a.f6270f.setEnabled(false);
        C1506g.m6979b();
        BindDeviceIOEntityModel bindDeviceIOEntityModel = (BindDeviceIOEntityModel) baseEntityModel;
        if (bindDeviceIOEntityModel.retCode == 0) {
            if ("".equals(bindDeviceIOEntityModel.deviceCode) || "0".equals(bindDeviceIOEntityModel.deviceCode)) {
                C2538c.m12674b(this.f6681a.f6266b, "matb =======bindcallback====== 1111 resetManagerPreCheck mPhoneNum = " + this.f6681a.f6263A);
                this.f6681a.m9781m(C1462f.m6765y());
                return;
            }
            this.f6681a.m9740a(bindDeviceIOEntityModel.deviceCode, bindDeviceIOEntityModel.phoneNum);
        } else if (13203 == bindDeviceIOEntityModel.retCode) {
            C2538c.m12674b(this.f6681a.f6266b, "matb =======bindcallback====== 2222 resetManagerPreCheck mPhoneNum = " + this.f6681a.f6263A);
            this.f6681a.m9781m(C1462f.m6765y());
        } else if (13210 == bindDeviceIOEntityModel.retCode || 13211 == bindDeviceIOEntityModel.retCode) {
            this.f6681a.m9752d(bindDeviceIOEntityModel.deviceCode);
        } else if (13202 == bindDeviceIOEntityModel.retCode) {
            this.f6681a.m9756e(bindDeviceIOEntityModel.retMsg);
        } else if (13205 == bindDeviceIOEntityModel.retCode) {
            C2538c.m12674b(this.f6681a.f6266b, "==retCode ==13205===该手表已被多个家长绑定，已达最大限制");
            this.f6681a.m9760f(bindDeviceIOEntityModel.retMsg);
        } else if (13219 == bindDeviceIOEntityModel.retCode) {
            C2538c.m12674b(this.f6681a.f6266b, "==retCode ==13219===您所管理的手表数量已达最大限制");
            this.f6681a.m9764g(bindDeviceIOEntityModel.retMsg);
        } else if (2 == bindDeviceIOEntityModel.retCode) {
            C2538c.m12674b(this.f6681a.f6266b, "============跳转到手表号码设置页面======= retCode = " + bindDeviceIOEntityModel.retCode);
            this.f6681a.m9745b(bindDeviceIOEntityModel.deviceCode, bindDeviceIOEntityModel.phoneNum);
        } else {
            C2538c.m12674b(this.f6681a.f6266b, "======失败====" + bindDeviceIOEntityModel.toString(), "  retCode:" + bindDeviceIOEntityModel.retCode);
            if ("".equals(bindDeviceIOEntityModel.deviceCode)) {
                C2538c.m12674b(this.f6681a.f6266b, "======失败:deviceCode获取失败====");
            }
            this.f6681a.m9768h(bindDeviceIOEntityModel.retMsg);
            if (13238 == bindDeviceIOEntityModel.retCode) {
                C2538c.m12674b(this.f6681a.f6266b, "======失败==== binddevice manager number expires!!! startSetPhoneNumActivity");
                this.f6681a.m9766h();
            }
        }
    }
}
