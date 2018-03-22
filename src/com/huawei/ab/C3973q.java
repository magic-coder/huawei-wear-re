package com.huawei.ab;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.util.List;

/* compiled from: HWUserProfileMgr */
class C3973q implements C3961b {
    final /* synthetic */ UserInfomation f15206a;
    final /* synthetic */ C3957a f15207b;
    final /* synthetic */ m f15208c;

    C3973q(m mVar, UserInfomation userInfomation, C3957a c3957a) {
        this.f15208c = mVar;
        this.f15206a = userInfomation;
        this.f15207b = c3957a;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToHILocal fetchUserData onSuccess"});
        List list = (List) obj;
        HiUserInfo hiUserInfo;
        if (list.size() > 0) {
            try {
                hiUserInfo = (HiUserInfo) list.get(0);
                C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToHILocal userInfo:" + hiUserInfo.toString()});
                if (1 == this.f15206a.getGender()) {
                    hiUserInfo.setGender(0);
                } else if (this.f15206a.getGender() == 0) {
                    hiUserInfo.setGender(1);
                } else {
                    hiUserInfo.setGender(-1);
                }
                hiUserInfo.setBirthday(Integer.parseInt(this.f15206a.getBirthday()));
                hiUserInfo.setHeight(this.f15206a.getHeight());
                hiUserInfo.setWeight((float) this.f15206a.getWeight());
                hiUserInfo.setUnitType(this.f15206a.getClientSet());
                this.f15206a.setSetTime(System.currentTimeMillis());
                m.a(this.f15208c, hiUserInfo, this.f15206a.getSetTime());
                m.a(this.f15208c).m19662a(hiUserInfo, this.f15206a, this.f15207b, null);
                return;
            } catch (NumberFormatException e) {
                C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToHILocal set birthday error"});
                return;
            }
        }
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToHILocal fetchUserData data size = 0"});
        hiUserInfo = new HiUserInfo();
        hiUserInfo.setHeight(this.f15206a.getHeight());
        hiUserInfo.setWeight((float) this.f15206a.getWeight());
        hiUserInfo.setUnitType(this.f15206a.getClientSet());
        this.f15206a.setSetTime(System.currentTimeMillis());
        m.a(this.f15208c, hiUserInfo, this.f15206a.getSetTime());
        m.a(this.f15208c).m19662a(hiUserInfo, this.f15206a, this.f15207b, null);
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserProfileMgr", new Object[]{"setUserInfoToHILocal fetchUserData onFailure"});
        HiUserInfo hiUserInfo = new HiUserInfo();
        hiUserInfo.setHeight(this.f15206a.getHeight());
        hiUserInfo.setWeight((float) this.f15206a.getWeight());
        hiUserInfo.setUnitType(this.f15206a.getClientSet());
        this.f15206a.setSetTime(System.currentTimeMillis());
        m.a(this.f15208c, hiUserInfo, this.f15206a.getSetTime());
        m.a(this.f15208c).m19662a(hiUserInfo, this.f15206a, this.f15207b, null);
    }
}
