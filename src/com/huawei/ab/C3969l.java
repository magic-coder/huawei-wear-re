package com.huawei.ab;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcommonmodel.p064d.C4727e;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;

/* compiled from: HWUserInfoMgr */
class C3969l extends Handler {
    final /* synthetic */ C3956a f15199a;

    public C3969l(C3956a c3956a, Looper looper) {
        this.f15199a = c3956a;
        super(looper);
    }

    public void handleMessage(Message message) {
        int i = 0;
        super.handleMessage(message);
        HiUserInfo hiUserInfo;
        switch (message.what) {
            case 1000:
                C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler GET_HIHEALTH_MESSAGE"});
                UserInfomation a = this.f15199a.m19660a();
                hiUserInfo = (HiUserInfo) message.obj;
                C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler GET_HIHEALTH_MESSAGE userInfomation = " + a});
                C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler GET_HIHEALTH_MESSAGE userInfo.getHeight() = " + hiUserInfo.getHeight() + " userInfo.getWeight() = " + hiUserInfo.getWeight() + " userInfo.getModifiedTime() = " + this.f15199a.m19652b(hiUserInfo) + " userInfo.getBirthday() = " + hiUserInfo.getBirthday() + " userInfo.getGender() = " + hiUserInfo.getGender() + " userInfo.getUnitType() = " + hiUserInfo.getUnitType()});
                if (a.getSetTime() <= this.f15199a.m19652b(hiUserInfo)) {
                    if (1 == a.getClientSet()) {
                        a.setWeight(Integer.valueOf(C4727e.m22628g((int) hiUserInfo.getWeight())));
                        a.setHeight(Integer.valueOf(C4727e.m22626e(hiUserInfo.getHeight())));
                    } else {
                        a.setWeight(Integer.valueOf((int) hiUserInfo.getWeight()));
                        a.setHeight(Integer.valueOf(hiUserInfo.getHeight()));
                    }
                    a.setSetTime(this.f15199a.m19652b(hiUserInfo));
                    a.setBirthday(String.valueOf(hiUserInfo.getBirthday()));
                    switch (hiUserInfo.getGender()) {
                        case 0:
                            a.setGender(Integer.valueOf(1));
                            break;
                        case 1:
                            a.setGender(Integer.valueOf(0));
                            break;
                    }
                    C3978v.m19706b(a);
                    this.f15199a.sendBroadcast("com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
                    return;
                }
                return;
            case 1002:
                C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler SAVE_USERINFO_TO_LOCAL"});
                C3978v.m19706b((UserInfomation) message.obj);
                this.f15199a.sendBroadcast("com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
                return;
            case 1004:
                synchronized (C3956a.f15170c) {
                    C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler GET_HIHEALTH_MESSAGE_GET_USERINFO"});
                    hiUserInfo = (HiUserInfo) message.obj;
                    UserInfomation a2 = this.f15199a.m19660a();
                    if (this.f15199a.f15172d == null) {
                        this.f15199a.f15172d = a2;
                        C2538c.c("HWUserInfoMgr", new Object[]{"MaintHandler mUserInfo = null , mUserInfo = " + this.f15199a.f15172d});
                    } else {
                        i = 1;
                    }
                    if (hiUserInfo != null) {
                        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth onReceive if (hiUserInfo != null)"});
                        C2538c.c("HWUserInfoMgr", new Object[]{"locol.getSetTime() = " + a2.getSetTime() + " hiUserInfo.getModified_time() = " + this.f15199a.m19652b(hiUserInfo)});
                        C2538c.c("HWUserInfoMgr", new Object[]{"hiUserInfo.getWeight() = " + hiUserInfo.getWeight() + " hiUserInfo.getHeight() = " + hiUserInfo.getHeight()});
                        C2538c.c("HWUserInfoMgr", new Object[]{"hiUserInfo birthday = " + hiUserInfo.getBirthday() + "gender :" + hiUserInfo.getGender()});
                        if (1 == this.f15199a.m19652b(hiUserInfo)) {
                            hiUserInfo.setWeight(0.0f);
                            hiUserInfo.setHeight(0);
                            C2538c.c("HWUserInfoMgr", new Object[]{"hiUserInfo.getWeight() = " + hiUserInfo.getWeight() + " hiUserInfo.getHeight() = " + hiUserInfo.getHeight()});
                        }
                        this.f15199a.f15172d.setClientSet(Integer.valueOf(a2.getClientSet()));
                        if (a2.getSetTime() == this.f15199a.m19652b(hiUserInfo) && ((float) a2.getWeight()) == hiUserInfo.getWeight() && hiUserInfo.getGender() == 1) {
                            this.f15199a.f15172d.setWeight(Integer.valueOf(a2.getWeight()));
                            this.f15199a.f15172d.setHeight(Integer.valueOf(a2.getHeight()));
                            C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth failed :" + this.f15199a.f15172d.toString()});
                        } else if (a2.getSetTime() < this.f15199a.m19652b(hiUserInfo)) {
                            if (1 == a2.getClientSet()) {
                                this.f15199a.f15172d.setWeight(Integer.valueOf((int) Math.round(com.huawei.hwbasemgr.c.a((double) hiUserInfo.getWeight()))));
                                this.f15199a.f15172d.setHeight(Integer.valueOf(C4727e.m22626e(hiUserInfo.getHeight())));
                            } else {
                                this.f15199a.f15172d.setWeight(Integer.valueOf(Math.round(hiUserInfo.getWeight())));
                                this.f15199a.f15172d.setHeight(Integer.valueOf(hiUserInfo.getHeight()));
                            }
                            if (0 != this.f15199a.m19652b(hiUserInfo)) {
                                this.f15199a.f15172d.setSetTime(this.f15199a.m19652b(hiUserInfo));
                            }
                            if (!this.f15199a.getSharedPreference("KEY_IF_ACCOUNT_AREA").equals("1")) {
                                C2538c.c("HWUserInfoMgr", new Object[]{"no cloud set birthday gender  getTime:" + this.f15199a.m19652b(hiUserInfo)});
                                if (1 != this.f15199a.m19652b(hiUserInfo)) {
                                    this.f15199a.f15172d.setBirthday(String.valueOf(hiUserInfo.getBirthday()));
                                    if (hiUserInfo.getGender() == 0) {
                                        this.f15199a.f15172d.setGender(Integer.valueOf(1));
                                    } else {
                                        this.f15199a.f15172d.setGender(Integer.valueOf(0));
                                    }
                                }
                            }
                        } else {
                            this.f15199a.f15172d.setHeight(Integer.valueOf(a2.getHeight()));
                            this.f15199a.f15172d.setWeight(Integer.valueOf(a2.getWeight()));
                            if (!this.f15199a.getSharedPreference("KEY_IF_ACCOUNT_AREA").equals("1")) {
                                C2538c.c("HWUserInfoMgr", new Object[]{"no cloud set birthday gender  getTime:" + this.f15199a.m19652b(hiUserInfo)});
                                if (1 != this.f15199a.m19652b(hiUserInfo)) {
                                    this.f15199a.f15172d.setBirthday(String.valueOf(hiUserInfo.getBirthday()));
                                    if (hiUserInfo.getGender() == 0) {
                                        this.f15199a.f15172d.setGender(Integer.valueOf(1));
                                    } else {
                                        this.f15199a.f15172d.setGender(Integer.valueOf(0));
                                    }
                                }
                            }
                            if (a2.getSetTime() != this.f15199a.m19652b(hiUserInfo)) {
                                this.f15199a.m19647a(hiUserInfo, a2);
                                hiUserInfo.setCreateTime(a2.getSetTime());
                                if (hiUserInfo.getHeight() != 0) {
                                    this.f15199a.m19646a(hiUserInfo);
                                }
                            }
                        }
                    } else {
                        C2538c.c("HWUserInfoMgr", new Object[]{"getUserInfofromHiHealth() hiUserInfo = null"});
                        this.f15199a.f15172d = a2;
                        hiUserInfo = new HiUserInfo();
                        this.f15199a.m19647a(hiUserInfo, a2);
                        hiUserInfo.setCreateTime(a2.getSetTime());
                        if (hiUserInfo.getHeight() != 0) {
                            this.f15199a.m19646a(hiUserInfo);
                        }
                    }
                    if (i != 0 || 1 == message.arg1) {
                        C3978v.m19706b(this.f15199a.f15172d);
                        this.f15199a.sendBroadcast("com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
                    }
                }
                return;
            default:
                return;
        }
    }
}
