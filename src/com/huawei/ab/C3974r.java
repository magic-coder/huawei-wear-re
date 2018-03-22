package com.huawei.ab;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.util.List;

/* compiled from: HWUserProfileMgr */
class C3974r implements C3961b {
    final /* synthetic */ UserInfomation f15209a;
    final /* synthetic */ C3957a f15210b;
    final /* synthetic */ m f15211c;

    C3974r(m mVar, UserInfomation userInfomation, C3957a c3957a) {
        this.f15211c = mVar;
        this.f15209a = userInfomation;
        this.f15210b = c3957a;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToLocal fetchUserData onSuccess"});
        List list = (List) obj;
        if (list.size() > 0) {
            HiUserInfo hiUserInfo = (HiUserInfo) list.get(0);
            C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToLocal userInfo:" + hiUserInfo.toString()});
            hiUserInfo.setHeight(this.f15209a.getHeight());
            hiUserInfo.setWeight((float) this.f15209a.getWeight());
            hiUserInfo.setUnitType(this.f15209a.getClientSet());
            this.f15209a.setSetTime(System.currentTimeMillis());
            m.a(this.f15211c, hiUserInfo, this.f15209a.getSetTime());
            m.a(this.f15211c).m19662a(hiUserInfo, this.f15209a, this.f15210b, null);
            return;
        }
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToLocal fetchUserData data size = 0"});
        hiUserInfo = new HiUserInfo();
        hiUserInfo.setHeight(this.f15209a.getHeight());
        hiUserInfo.setWeight((float) this.f15209a.getWeight());
        hiUserInfo.setUnitType(this.f15209a.getClientSet());
        this.f15209a.setSetTime(System.currentTimeMillis());
        m.a(this.f15211c, hiUserInfo, this.f15209a.getSetTime());
        m.a(this.f15211c).m19662a(hiUserInfo, this.f15209a, this.f15210b, null);
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToLocal fetchUserData onFailure"});
        HiUserInfo hiUserInfo = new HiUserInfo();
        hiUserInfo.setHeight(this.f15209a.getHeight());
        hiUserInfo.setWeight((float) this.f15209a.getWeight());
        hiUserInfo.setUnitType(this.f15209a.getClientSet());
        this.f15209a.setSetTime(System.currentTimeMillis());
        m.a(this.f15211c, hiUserInfo, this.f15209a.getSetTime());
        m.a(this.f15211c).m19662a(hiUserInfo, this.f15209a, this.f15210b, null);
    }
}
