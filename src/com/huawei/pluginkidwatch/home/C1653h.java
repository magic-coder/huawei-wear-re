package com.huawei.pluginkidwatch.home;

import android.graphics.Bitmap;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.p148c.C1467b;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.home.p156b.C1638r;

/* compiled from: HomeActivity */
class C1653h implements C1378e {
    final /* synthetic */ boolean f4348a;
    final /* synthetic */ boolean f4349b;
    final /* synthetic */ HomeActivity f4350c;

    C1653h(HomeActivity homeActivity, boolean z, boolean z2) {
        this.f4350c = homeActivity;
        this.f4348a = z;
        this.f4349b = z2;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (this.f4350c.isFinishing()) {
            C2538c.m12680e("KIDWATCH_HomeActivity", "===== getBindDeviceInfos Activity is finished");
            return;
        }
        this.f4350c.f4131c.removeCallbacks(this.f4350c.cl);
        this.f4350c.f4131c.sendEmptyMessage(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos return failure");
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos return failure mK1DeviceType" + C1467b.m6789d(this.f4350c.f4109F));
            this.f4350c.m7517a(r0);
        } else {
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos return success");
            BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel = (BindDeviceInfosIOEntityModel) baseEntityModel;
            C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos return success response" + bindDeviceInfosIOEntityModel.toString());
            if (bindDeviceInfosIOEntityModel.deviceProfiles != null) {
                if (bindDeviceInfosIOEntityModel.deviceProfiles.size() == 0) {
                    C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos return CommonLibConstants.ZERO == model.deviceProfiles.size()");
                    this.f4350c.m7461D();
                    this.f4350c.m7614p();
                    C2538c.m12677c("KIDWATCH_HomeActivity", "=====getBindDeviceInfos have no bind device mK1DeviceType" + C1467b.m6789d(this.f4350c.f4109F));
                    this.f4350c.m7517a(r0);
                    return;
                }
                C1392h.m6280a(this.f4350c.f4109F, C1462f.m6744i(), bindDeviceInfosIOEntityModel.deviceProfiles);
                Bitmap bitmap = null;
                for (Bitmap bitmap2 : bindDeviceInfosIOEntityModel.deviceProfiles) {
                    Bitmap bitmap22;
                    if (bitmap22 != null) {
                        this.f4350c.m7561b((DeviceProfile) bitmap22);
                        C2538c.m12674b("KIDWATCH_HomeActivity", "====www123===========updateDeviceCode KWCache.getDeviceCode()" + C1462f.m6746j());
                        C2538c.m12674b("KIDWATCH_HomeActivity", "====www123===========updateDeviceCode deviceInfo.deviceCode" + bitmap22.deviceCode);
                        if (C1492l.m6919c(C1462f.m6746j()) || bitmap22.deviceCode <= 0) {
                            bitmap22 = bitmap;
                        } else {
                            C2538c.m12674b("KIDWATCH_HomeActivity", "====www123============updateDeviceCode 1");
                            int d = C1467b.m6789d(this.f4350c.f4109F);
                            C2538c.m12677c("KIDWATCH_HomeActivity", "====www123===========updateDeviceCode mK1DeviceType" + d);
                            if (7 == d) {
                                C2538c.m12677c("KIDWATCH_HomeActivity", "====www123==========select k2 enter k2 deviceInfo.deviceType==" + bitmap22.deviceType);
                                if (1 == bitmap22.deviceType) {
                                    C2538c.m12674b("KIDWATCH_HomeActivity", "====www123===========select k2 enter k2  deviceInfo==" + bitmap22);
                                    this.f4350c.m7566b(String.valueOf(bitmap22.deviceCode));
                                }
                                bitmap22 = bitmap;
                            } else {
                                if (5 == d) {
                                    C2538c.m12677c("KIDWATCH_HomeActivity", "====www123============select k1 enter k1 deviceInfo.deviceType==" + bitmap22.deviceType);
                                    if (bitmap22.deviceType == 0 || -1 == bitmap22.deviceType) {
                                        C2538c.m12674b("KIDWATCH_HomeActivity", "====www123===========select k1 enter k1  deviceInfo==" + bitmap22);
                                        this.f4350c.m7566b(String.valueOf(bitmap22.deviceCode));
                                    }
                                }
                                bitmap22 = bitmap;
                            }
                            if (bitmap22 != null) {
                                C2538c.m12674b("KIDWATCH_HomeActivity", "====www123=========== updateDeviceCode==" + bitmap22);
                            }
                            if (this.f4350c.f4141n != null) {
                                this.f4350c.f4141n.clear();
                            }
                        }
                        bitmap = bitmap22;
                    }
                }
                this.f4350c.m7549a(bindDeviceInfosIOEntityModel.deviceProfiles);
            }
            this.f4350c.m7623t();
            this.f4350c.aF();
            if (C1462f.m6748k() != null && C1492l.m6913a(this.f4350c.f4109F, C1466a.m6777a())) {
                this.f4350c.m7560b(C1462f.m6748k());
            }
            if (C1462f.m6748k() != null) {
                this.f4350c.f4146s.setDeviceName(C1462f.m6748k().f3083c);
            } else {
                C2538c.m12674b("KIDWATCH_HomeActivity", "=====Make KWCache.curDeviceInfo null ");
            }
            if (this.f4348a) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "============ getWatchStatus 2");
                this.f4350c.m7551a(true, true, this.f4349b);
                this.f4350c.m7519a(null);
                this.f4350c.m7617q();
            }
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "=====getBindDeviceInfos null return");
        C1638r.m7761b(this.f4350c.f4109F);
    }
}
