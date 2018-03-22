package com.huawei.ab;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: HWUserProfileMgr */
class C3972p implements C3957a<Boolean> {
    final /* synthetic */ boolean f15202a;
    final /* synthetic */ C3957a f15203b;
    final /* synthetic */ UserInfomation f15204c;
    final /* synthetic */ m f15205d;

    C3972p(m mVar, boolean z, C3957a c3957a, UserInfomation userInfomation) {
        this.f15205d = mVar;
        this.f15202a = z;
        this.f15203b = c3957a;
        this.f15204c = userInfomation;
    }

    public void m19683a(Boolean bool, String str, boolean z) {
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToUp operationResult is " + z});
        if (z) {
            HiUserInfo hiUserInfo = new HiUserInfo();
            hiUserInfo.setHeight(this.f15204c.getHeight());
            hiUserInfo.setWeight((float) this.f15204c.getWeight());
            this.f15204c.setSetTime(System.currentTimeMillis());
            m.a(this.f15205d, hiUserInfo, this.f15204c.getSetTime());
            C2538c.c("HWUserProfileMgr", new Object[]{"setUserData start"});
            m.a(this.f15205d).m19662a(hiUserInfo, this.f15204c, this.f15203b, str);
            return;
        }
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToUp Fail"});
        if (this.f15202a) {
            hiUserInfo = new HiUserInfo();
            hiUserInfo.setHeight(this.f15204c.getHeight());
            hiUserInfo.setWeight((float) this.f15204c.getWeight());
            this.f15204c.setSetTime(System.currentTimeMillis());
            m.a(this.f15205d, hiUserInfo, this.f15204c.getSetTime());
            C2538c.c("HWUserProfileMgr", new Object[]{"setUserData start"});
            m.a(this.f15205d).m19662a(hiUserInfo, this.f15204c, this.f15203b, str);
            return;
        }
        this.f15203b.mo4330a(null, null, false);
    }
}
