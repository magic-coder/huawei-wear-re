package com.huawei.coresleepresult;

import android.support.v4.media.TransportMediator;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HwCoreSleepDataProvider */
class C4363a implements C3961b {
    final /* synthetic */ HwCoreSleepDataProvider f16225a;

    C4363a(HwCoreSleepDataProvider hwCoreSleepDataProvider) {
        this.f16225a = hwCoreSleepDataProvider;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c(HwCoreSleepDataProvider.f16194a, new Object[]{"get user info data = ", obj});
        List list = (List) obj;
        if (list.size() > 0) {
            HiUserInfo hiUserInfo = (HiUserInfo) list.get(0);
            this.f16225a.f16198e = hiUserInfo.getGender();
            if (1 == this.f16225a.f16198e) {
                this.f16225a.f16198e = 0;
            } else {
                this.f16225a.f16198e = 1;
            }
            this.f16225a.f16199f = hiUserInfo.getAge();
            if (this.f16225a.f16199f <= 0 || this.f16225a.f16199f > TransportMediator.KEYCODE_MEDIA_RECORD) {
                this.f16225a.f16199f = 30;
            }
            C2538c.c(HwCoreSleepDataProvider.f16194a, new Object[]{"user age= " + this.f16225a.f16199f + ",user gender= " + this.f16225a.f16198e});
        }
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c(HwCoreSleepDataProvider.f16194a, new Object[]{"get user info errCode = ", Integer.valueOf(i), ",errMsg = ", obj});
    }
}
