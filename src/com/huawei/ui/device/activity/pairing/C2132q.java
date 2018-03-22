package com.huawei.ui.device.activity.pairing;

import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import com.huawei.ui.device.p170a.C1987o;
import com.huawei.ui.device.p170a.C1988p;

/* compiled from: DevicePairGuideActivity */
class C2132q implements Runnable {
    final /* synthetic */ int f7540a;
    final /* synthetic */ Object f7541b;
    final /* synthetic */ C2131p f7542c;

    C2132q(C2131p c2131p, int i, Object obj) {
        this.f7542c = c2131p;
        this.f7540a = i;
        this.f7541b = obj;
    }

    public void run() {
        if (this.f7540a == 0) {
            C2538c.m12677c("DevicePairGuideActivity", "state:" + ((C1987o) this.f7541b));
            if (C1987o.NO_BIND_DEVICE == ((C1987o) this.f7541b)) {
                this.f7542c.f7539a.m10911a(false);
                return;
            }
            C2538c.m12677c("DevicePairGuideActivity", "isHuaweiWearBinded Enter else isNoteHanShown:" + this.f7542c.f7539a.an);
            if (this.f7542c.f7539a.an) {
                this.f7542c.f7539a.m10904a(this.f7542c.f7539a.f7500f);
                return;
            }
            String b = C1988p.m10381a(this.f7542c.f7539a.f7497c).m10391b(this.f7542c.f7539a.f7500f);
            if (11 == this.f7542c.f7539a.f7500f && ("HUAWEI CM-R1P".equals(this.f7542c.f7539a.f7495a) || this.f7542c.f7539a.f7497c.getString(i.IDS_huawei_r1_pro_content).equals(this.f7542c.f7539a.f7495a) || this.f7542c.f7539a.f7497c.getString(i.IDS_device_r1_pro_name_title).equals(this.f7542c.f7539a.f7495a))) {
                b = this.f7542c.f7539a.f7497c.getString(i.IDS_huawei_r1_pro_content);
            }
            this.f7542c.f7539a.m10910a(b, this.f7542c.f7539a.f7500f);
            return;
        }
        this.f7542c.f7539a.m10911a(false);
    }
}
