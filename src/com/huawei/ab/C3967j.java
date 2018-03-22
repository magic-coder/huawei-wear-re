package com.huawei.ab;

import android.os.Message;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.data.p312b.C3961b;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

import java.util.List;

/* compiled from: HWUserInfoMgr */
class C3967j implements C3961b {
    final /* synthetic */ C3966i f15197a;

    C3967j(C3966i c3966i) {
        this.f15197a = c3966i;
    }

    public void mo4331a(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"mHiHealthCloudSyncReceiver fetchUserData onSuccess"});
        List list = (List) obj;
        if (list.size() > 0) {
            HiUserInfo hiUserInfo = (HiUserInfo) list.get(0);
            synchronized (C3956a.f15170c) {
                if (this.f15197a.f15196a.f15172d == null) {
                    C2538c.c("HWUserInfoMgr", new Object[]{"mHiHealthCloudSyncReceiver onReceive if (mUserInfo == null)"});
                    this.f15197a.f15196a.f15172d = new UserInfomation();
                    this.f15197a.f15196a.f15172d.setWeight(Integer.valueOf((int) hiUserInfo.getWeight()));
                    this.f15197a.f15196a.f15172d.setHeight(Integer.valueOf(hiUserInfo.getHeight()));
                    this.f15197a.f15196a.f15172d.setClientSet(Integer.valueOf(hiUserInfo.getUnitType()));
                    this.f15197a.f15196a.f15172d.setSetTime(this.f15197a.f15196a.m19652b(hiUserInfo));
                } else {
                    C2538c.c("HWUserInfoMgr", new Object[]{"mHiHealthCloudSyncReceiver onReceive if (mUserInfo == null) ELSE"});
                    this.f15197a.f15196a.f15172d.setWeight(Integer.valueOf((int) hiUserInfo.getWeight()));
                    this.f15197a.f15196a.f15172d.setHeight(Integer.valueOf(hiUserInfo.getHeight()));
                    this.f15197a.f15196a.f15172d.setClientSet(Integer.valueOf(hiUserInfo.getUnitType()));
                    this.f15197a.f15196a.f15172d.setSetTime(this.f15197a.f15196a.m19652b(hiUserInfo));
                    Message obtainMessage = this.f15197a.f15196a.f15176h.obtainMessage();
                    obtainMessage.obj = this.f15197a.f15196a.f15172d;
                    obtainMessage.what = 1002;
                    this.f15197a.f15196a.f15176h.sendMessage(obtainMessage);
                }
            }
            return;
        }
        C2538c.c("HWUserInfoMgr", new Object[]{"mHiHealthCloudSyncReceiver fetchUserData data size = 0"});
    }

    public void mo4332b(int i, Object obj) {
        C2538c.c("HWUserInfoMgr", new Object[]{"mHiHealthCloudSyncReceiver fetchUserData onFailure"});
    }
}
