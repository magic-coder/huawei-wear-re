package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.UserBasicInfo;
import com.huawei.hwcloudmodel.model.userprofile.UserGoalsInfo;
import com.huawei.hwdatamigrate.hihealth.c.ab;
import com.huawei.hwdatamigrate.hihealth.c.bs;
import com.huawei.hwdatamigrate.hihealth.c.bv;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.hwdatamigrate.hihealth.p069e.C1003a;
import com.huawei.hwdatamigrate.hihealth.sync.a.g;
import com.huawei.hwdatamigrate.hihealth.sync.b.m;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: HiSyncUserData */
public class C1014q implements C1006d {
    private Context f1802a;
    private int f1803b;
    private bs f1804c;
    private m f1805d;
    private a f1806e;
    private List<Integer> f1807f;

    public C1014q(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12677c("HiH_HiSyncUserData", "HiSyncUserData create");
        this.f1802a = context.getApplicationContext();
        this.f1803b = i;
        m3844d();
    }

    private void m3844d() {
        this.f1804c = bs.a(this.f1802a);
        this.f1805d = new m();
        this.f1806e = a.a(this.f1802a);
        this.f1807f = new ArrayList();
    }

    private HiUserInfo m3845e() {
        HiUserInfo a = this.f1804c.a(this.f1803b, 0);
        if (a != null) {
            return a;
        }
        C2538c.m12680e("HiH_HiSyncUserData", "uploadUserBasic no userInfo get");
        return null;
    }

    private List<HiGoalInfo> m3846f() {
        return ab.a(this.f1802a).a(this.f1803b, 0);
    }

    private void m3839a(List<UserGoalsInfo> list) {
        List<HiGoalInfo> a = this.f1805d.a(list);
        if (a == null || a.isEmpty()) {
            C2538c.m12679d("HiH_HiSyncUserData", "saveUserGoalsToDB no userGoalsInfos can change to hiGoalInfos");
            return;
        }
        for (HiGoalInfo hiGoalInfo : a) {
            hiGoalInfo.setOwnerId(this.f1803b);
            ab.a(this.f1802a).a(hiGoalInfo, 1);
        }
        C1003a.m3690a().m3692a(101, "HiSyncUserData", null);
    }

    private void m3838a(UserBasicInfo userBasicInfo) {
        HiUserInfo a = this.f1805d.a(userBasicInfo);
        if (a == null) {
            C2538c.m12679d("HiH_HiSyncUserData", "saveUserInfoToDB no userBasicInfo can change to hiUserInfo");
            return;
        }
        this.f1804c.a(a, this.f1803b, 1);
        C1001a.m3641a(this.f1802a, HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION, 2);
        C1001a.m3644b(this.f1802a, 5);
        C1003a.m3690a().m3692a(100, "HiSyncUserData", null);
    }

    private void m3840a(Map<String, String> map) {
        List<HiUserPreference> a = this.f1805d.a(map);
        if (a != null && !a.isEmpty()) {
            for (HiUserPreference hiUserPreference : a) {
                hiUserPreference.setUserId(this.f1803b);
                bv.a(this.f1802a).a(hiUserPreference);
            }
            C1003a.m3690a().m3692a(102, "HiSyncUserData", null);
        }
    }

    private List<HiUserPreference> m3847g() {
        return bv.a(this.f1802a).a(this.f1803b, 0);
    }

    private void m3848h() throws C1004h {
        m3850j();
        GetUserProfileReq getUserProfileReq = new GetUserProfileReq();
        getUserProfileReq.setProfileType(this.f1807f);
        CloudCommonReponse a = this.f1806e.a(getUserProfileReq);
        if (g.a(a, false)) {
            m3838a(a.getBasic());
            m3839a(a.getGoals());
            m3840a(a.getCustomDefine());
            return;
        }
        C2538c.m12679d("HiH_HiSyncUserData", "downLoadUserData rsp is null");
    }

    private void m3849i() throws C1004h {
        SetUserProfileReq setUserProfileReq = new SetUserProfileReq();
        HiUserInfo e = m3845e();
        UserBasicInfo a = this.f1805d.a(e);
        if (a != null) {
            setUserProfileReq.setBasic(a);
            int i = 1;
        } else {
            boolean z = false;
        }
        List f = m3846f();
        List b = this.f1805d.b(f);
        if (!(b == null || b.isEmpty())) {
            setUserProfileReq.setGoals(b);
            i = 1;
        }
        List g = m3847g();
        Map c = this.f1805d.c(g);
        if (!(c == null || c.isEmpty())) {
            setUserProfileReq.setCustomDefine(c);
            i = 1;
        }
        if (i == 0) {
            C2538c.m12679d("HiH_HiSyncUserData", "uploadUserData nothing to pushData");
        } else if (g.a(this.f1806e.a(setUserProfileReq), false)) {
            if (a != null) {
                m3841b(e);
            }
            if (!(b == null || b.isEmpty())) {
                m3842b(f);
            }
            if (c != null && !c.isEmpty()) {
                m3843c(g);
            }
        } else {
            C2538c.m12679d("HiH_HiSyncUserData", "uploadUserData rsp error");
        }
    }

    private void m3841b(HiUserInfo hiUserInfo) {
        this.f1804c.a(hiUserInfo, this.f1803b, 1);
    }

    private void m3842b(List<HiGoalInfo> list) {
        for (HiGoalInfo hiGoalInfo : list) {
            if (hiGoalInfo != null) {
                ab.a(this.f1802a).a(this.f1803b, hiGoalInfo.getGoalType(), 1);
            }
        }
    }

    private void m3843c(List<HiUserPreference> list) {
        for (HiUserPreference a : list) {
            bv.a(this.f1802a).a(a, 1);
        }
    }

    private void m3850j() {
        this.f1807f.add(Integer.valueOf(1));
        this.f1807f.add(Integer.valueOf(2));
        this.f1807f.add(Integer.valueOf(99));
    }

    public void mo2311a() throws C1004h {
        C2538c.m12677c("HiH_HiSyncUserData", "downLoad() begin !");
        m3848h();
        C2538c.m12677c("HiH_HiSyncUserData", "downLoad() end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("HiH_HiSyncUserData", "upLoad() begin !");
        if (C1015e.m3864c()) {
            if (C1015e.m3856a(this.f1802a).m3881a(Integer.toString(this.f1803b))) {
                C2538c.m12677c("HiH_HiSyncUserData", "first user sync do not upload userData, who is ", Integer.valueOf(this.f1803b));
            } else {
                m3849i();
            }
            C1015e.m3856a(this.f1802a).m3880a(Integer.toString(this.f1803b), false);
            C2538c.m12677c("HiH_HiSyncUserData", "upLoad() end !");
            return;
        }
        C2538c.m12679d("HiH_HiSyncUserData", "pushData() userPrivacy switch is closed ,can not pushData right now ,push end!");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncUserData{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public boolean m3853a(HiUserInfo hiUserInfo) throws C1004h {
        C2538c.m12677c("HiH_HiSyncUserData", "start upLoadBasicInfoOnly");
        if (C1015e.m3864c()) {
            UserBasicInfo a = this.f1805d.a(hiUserInfo);
            if (a == null) {
                return false;
            }
            SetUserProfileReq setUserProfileReq = new SetUserProfileReq();
            setUserProfileReq.setBasic(a);
            if (g.a(this.f1806e.a(setUserProfileReq), false)) {
                C1001a.m3641a(this.f1802a, MessageObserver.RET_AUTH_ERROR, 2);
                m3841b(hiUserInfo);
                return true;
            }
            C1001a.m3641a(this.f1802a, MessageObserver.RET_AUTH_ERROR, 3);
            return false;
        }
        C2538c.m12679d("HiH_HiSyncUserData", "upLoadBasicInfoOnly() userPrivacy switch is closed ,can not pushData right now ,push end!");
        return false;
    }

    public boolean m3855c() throws C1004h {
        C2538c.m12677c("HiH_HiSyncUserData", "start downLoadBasicInfoOnly");
        GetUserProfileReq getUserProfileReq = new GetUserProfileReq();
        this.f1807f.add(Integer.valueOf(1));
        getUserProfileReq.setProfileType(this.f1807f);
        CloudCommonReponse a = this.f1806e.a(getUserProfileReq);
        if (g.a(a, false)) {
            m3838a(a.getBasic());
            return true;
        }
        C1001a.m3641a(this.f1802a, HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION, 3);
        return false;
    }
}
