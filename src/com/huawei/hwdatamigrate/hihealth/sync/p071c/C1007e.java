package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.userprofile.BindDeviceReq;
import com.huawei.hwdatamigrate.hihealth.c.ak;
import com.huawei.hwdatamigrate.hihealth.c.bg;
import com.huawei.hwdatamigrate.hihealth.c.y;
import com.huawei.hwdatamigrate.hihealth.p068d.C1002g;
import com.huawei.hwdatamigrate.hihealth.sync.a.g;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiSyncClient */
public class C1007e implements C1006d {
    private Context f1705a;
    private int f1706b;
    private List<C1002g> f1707c;
    private y f1708d;
    private bg f1709e;
    private ak f1710f;

    public C1007e(Context context, HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12674b("HiH_HiSyncClient", "HiSyncClient create");
        this.f1705a = context.getApplicationContext();
        this.f1706b = i;
        m3727c();
    }

    private void m3727c() {
        this.f1710f = ak.a(this.f1705a);
        this.f1708d = y.a(this.f1705a);
        this.f1709e = bg.a(this.f1705a);
        this.f1707c = this.f1710f.a(this.f1706b, 0);
    }

    private BindDeviceReq m3725a(C1002g c1002g) {
        if (c1002g == null) {
            return null;
        }
        HiDeviceInfo a = this.f1708d.a(c1002g.m3684e());
        if (a == null) {
            C2538c.m12679d("HiH_HiSyncClient", "createBindDeviceReq get no hiDeviceInfo from DB");
            return null;
        }
        BindDeviceReq bindDeviceReq = new BindDeviceReq();
        bindDeviceReq.setProductId(Integer.valueOf(a.getDeviceType()));
        bindDeviceReq.setUniqueId(a.getDeviceUniqueCode());
        bindDeviceReq.setName(a.getDeviceName());
        bindDeviceReq.setFirmwareVersion(a.getFirmwareVersion());
        bindDeviceReq.setHardwareVersion(a.getHardwareVersion());
        bindDeviceReq.setSoftwareVersion(a.getSoftwareVersion());
        bindDeviceReq.setManufacturer(a.getManufacturer());
        bindDeviceReq.setDeviceData(a.getDeviceSN());
        return bindDeviceReq;
    }

    private void m3726a(C1002g c1002g, BindDeviceReq bindDeviceReq) throws C1004h {
        C2538c.m12677c("HiH_HiSyncClient", "bindDevice start bindDevice , device name is ", bindDeviceReq.getName(), " product is ", bindDeviceReq.getProductId());
        CloudCommonReponse a = a.a(this.f1705a).a(bindDeviceReq);
        if (g.a(a, false)) {
            long longValue = a.getDeviceCode().longValue();
            if (longValue <= 0) {
                C2538c.m12680e("HiH_HiSyncClient", "bindDevice error ans from cloud, deviceCode is ", Long.valueOf(longValue), " client is ", c1002g);
                return;
            }
            c1002g.m3677a(longValue);
            c1002g.m3676a(1);
            this.f1709e.a(c1002g);
            return;
        }
        C2538c.m12680e("HiH_HiSyncClient", "bindDevice error");
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("HiH_HiSyncClient", "pushData() begin !");
        if (!C1015e.m3862b()) {
            C2538c.m12679d("HiH_HiSyncClient", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
        } else if (this.f1707c == null || this.f1707c.isEmpty()) {
            C2538c.m12677c("HiH_HiSyncClient", "pushData() end ! no device needed to bindDevice to cloud, stop pushData");
        } else {
            for (C1002g c1002g : this.f1707c) {
                BindDeviceReq a = m3725a(c1002g);
                if (a != null) {
                    m3726a(c1002g, a);
                }
            }
            C2538c.m12677c("HiH_HiSyncClient", "pushData() end !");
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncClient{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void mo2311a() throws C1004h {
    }

    public void mo2312a(long j, long j2) throws C1004h {
    }
}
