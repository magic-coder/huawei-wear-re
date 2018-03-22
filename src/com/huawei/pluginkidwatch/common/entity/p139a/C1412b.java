package com.huawei.pluginkidwatch.common.entity.p139a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.AbilityIOModel;
import com.huawei.pluginkidwatch.common.entity.model.AddFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.AddWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.AppProfileModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonRetOModel;
import com.huawei.pluginkidwatch.common.entity.model.CommonStateOModel;
import com.huawei.pluginkidwatch.common.entity.model.ConfirmBindIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeleteWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceBindUsersIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceSOSPhoneIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.EditManagerModel;
import com.huawei.pluginkidwatch.common.entity.model.FenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceModel;
import com.huawei.pluginkidwatch.common.entity.model.GetDeviceProfileRetModel;
import com.huawei.pluginkidwatch.common.entity.model.GetRewardInfoRetModel;
import com.huawei.pluginkidwatch.common.entity.model.GetTpyeRetModel;
import com.huawei.pluginkidwatch.common.entity.model.GetVoiceModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import com.huawei.pluginkidwatch.common.entity.model.HandleFenceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.HealthDataIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.RewardIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SetAccompanyUserIEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SetDeviceProfileModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchContactIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import com.huawei.pluginkidwatch.common.entity.model.SynchronizePushIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.TransferPrivilegeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UnbindDeviceIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.UploadTMIDIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.ValidateCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.VerifyBindCodeModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchPhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchSecurityCodeIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.WatchStatusIOModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1419a;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1421c;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1422d;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1423e;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1424f;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1425g;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1426h;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1427i;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1428j;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1429k;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1430l;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1431m;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1432n;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1433o;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1434p;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1435q;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1436r;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1437s;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1438t;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1439u;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1440v;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1441w;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1442x;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1443y;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.C1444z;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.aa;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ab;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ac;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ad;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ae;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.af;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ag;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ah;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ai;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.aj;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ak;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.al;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.am;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.an;
import com.huawei.pluginkidwatch.common.entity.p140b.p141a.p142a.ao;
import com.huawei.pluginkidwatch.common.entity.p144d.C1454a;
import com.huawei.pluginkidwatch.common.entity.p144d.C1457c;

/* compiled from: HttpApi */
public class C1412b {
    private static C1412b f3221a = null;
    private Context f3222b = null;
    private C1457c f3223c = null;
    private C1454a f3224d = null;

    private C1412b(Context context) {
        this.f3222b = context;
        this.f3223c = new C1457c(this.f3222b);
        this.f3224d = new C1454a(this.f3222b);
    }

    public static C1412b m6455a(Context context) {
        C1412b c1412b;
        synchronized (C1412b.class) {
            if (f3221a == null && context != null) {
                f3221a = new C1412b(context.getApplicationContext());
            }
            c1412b = f3221a;
        }
        return c1412b;
    }

    public void m6473a(GetDeviceProfileRetModel getDeviceProfileRetModel, C1378e c1378e) {
        m6456a(new C1437s(getDeviceProfileRetModel), c1378e);
    }

    public void m6484a(SetDeviceProfileModel setDeviceProfileModel, C1378e c1378e) {
        m6456a(new ac(setDeviceProfileModel), c1378e);
    }

    public void m6495a(WatchStatusIOModel watchStatusIOModel, C1378e c1378e) {
        m6456a(new ao(watchStatusIOModel), c1378e);
    }

    public void m6463a(CommonRetOModel commonRetOModel, C1378e c1378e) {
        m6456a(new C1426h(commonRetOModel), c1378e);
    }

    public void m6491a(ValidateCodeIOEntityModel validateCodeIOEntityModel, C1378e c1378e) {
        m6456a(new aj(validateCodeIOEntityModel), c1378e);
    }

    public void m6481a(PhoneNumIOEntityModel phoneNumIOEntityModel, C1378e c1378e) {
        m6456a(new aa(phoneNumIOEntityModel), c1378e);
    }

    public void m6461a(BindDeviceIOEntityModel bindDeviceIOEntityModel, C1378e c1378e) {
        m6456a(new C1424f(bindDeviceIOEntityModel), c1378e);
    }

    public void m6489a(UnbindDeviceIOEntityModel unbindDeviceIOEntityModel, C1378e c1378e, Context context) {
        m6456a(new ah(unbindDeviceIOEntityModel, context), c1378e);
    }

    public void m6496b(PhoneNumIOEntityModel phoneNumIOEntityModel, C1378e c1378e) {
        m6456a(new C1438t(phoneNumIOEntityModel), c1378e);
    }

    public void m6488a(TransferPrivilegeIOEntityModel transferPrivilegeIOEntityModel, C1378e c1378e) {
        m6456a(new ag(transferPrivilegeIOEntityModel), c1378e);
    }

    public void m6467a(DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel, C1378e c1378e) {
        m6456a(new C1429k(deviceBindUsersIOEntityModel), c1378e);
    }

    public void m6480a(MotionPathsIOEntityModel motionPathsIOEntityModel, C1378e c1378e) {
        m6456a(new C1444z(motionPathsIOEntityModel), c1378e);
    }

    public void m6458a(AddFenceIOEntityModel addFenceIOEntityModel, C1378e c1378e) {
        m6456a(new C1422d(addFenceIOEntityModel), c1378e);
    }

    public void m6470a(FenceIOEntityModel fenceIOEntityModel, C1378e c1378e) {
        m6456a(new C1432n(fenceIOEntityModel), c1378e);
    }

    public void m6478a(HandleFenceIOEntityModel handleFenceIOEntityModel, C1378e c1378e) {
        m6456a(new C1442x(handleFenceIOEntityModel), c1378e);
    }

    public void m6482a(RewardIOEntityModel rewardIOEntityModel, C1378e c1378e) {
        m6456a(new ab(rewardIOEntityModel), c1378e);
    }

    public void m6474a(GetRewardInfoRetModel getRewardInfoRetModel, C1378e c1378e) {
        m6456a(new C1439u(getRewardInfoRetModel), c1378e);
    }

    public void m6490a(UploadTMIDIOEntityModel uploadTMIDIOEntityModel, C1378e c1378e) {
        C1418a aiVar = new ai(uploadTMIDIOEntityModel);
        C2538c.m12674b("HttpApi", "postUseThread() pushRestfulService=" + this.f3224d);
        if (this.f3224d != null) {
            this.f3224d.m6695a(aiVar, c1378e);
        }
    }

    public void m6465a(ConfirmBindIOEntityModel confirmBindIOEntityModel, C1378e c1378e) {
        m6456a(new C1427i(confirmBindIOEntityModel), c1378e);
    }

    public void m6462a(BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel, C1378e c1378e) {
        m6456a(new C1425g(bindDeviceInfosIOEntityModel), c1378e);
    }

    public void m6494a(WatchSecurityCodeIOEntityModel watchSecurityCodeIOEntityModel, C1378e c1378e) {
        m6456a(new an(watchSecurityCodeIOEntityModel), c1378e);
    }

    public void m6493a(WatchPhoneNumIOEntityModel watchPhoneNumIOEntityModel, C1378e c1378e) {
        m6456a(new am(watchPhoneNumIOEntityModel), c1378e);
    }

    public void m6471a(GetContactIOEntityModel getContactIOEntityModel, C1378e c1378e) {
        m6456a(new C1435q(getContactIOEntityModel), c1378e);
    }

    public void m6459a(AddWatchContactIOEntityModel addWatchContactIOEntityModel, C1378e c1378e) {
        m6456a(new C1423e(addWatchContactIOEntityModel), c1378e);
    }

    public void m6466a(DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel, C1378e c1378e) {
        m6456a(new C1428j(deleteWatchContactIOEntityModel), c1378e);
    }

    public void m6485a(SetWatchContactIOEntityModel setWatchContactIOEntityModel, C1378e c1378e) {
        m6456a(new ad(setWatchContactIOEntityModel), c1378e);
    }

    public void m6486a(SetWatchSettingIOModel setWatchSettingIOModel, C1378e c1378e) {
        m6456a(new ae(setWatchSettingIOModel), c1378e);
    }

    public void m6477a(GetWatchSettingModel getWatchSettingModel, C1378e c1378e) {
        m6456a(new C1441w(getWatchSettingModel), c1378e);
    }

    public void m6472a(GetDeviceModel getDeviceModel, C1378e c1378e) {
        m6456a(new C1436r(getDeviceModel), c1378e);
    }

    public void m6479a(HealthDataIOEntityModel healthDataIOEntityModel, C1378e c1378e) {
        m6456a(new C1443y(healthDataIOEntityModel), c1378e);
    }

    public void m6483a(SetAccompanyUserIEntityModel setAccompanyUserIEntityModel, C1378e c1378e) {
        m6456a(new C1421c(setAccompanyUserIEntityModel), c1378e);
    }

    public void m6475a(GetTpyeRetModel getTpyeRetModel, C1378e c1378e) {
        m6456a(new C1440v(getTpyeRetModel), c1378e);
    }

    public void m6476a(GetVoiceModel getVoiceModel, C1378e c1378e) {
        m6456a(new al(getVoiceModel), c1378e);
    }

    public void m6487a(SynchronizePushIOEntityModel synchronizePushIOEntityModel, C1378e c1378e) {
        C1418a afVar = new af(synchronizePushIOEntityModel);
        C2538c.m12674b("HttpApi", "postSynchronizePushInfo() pushRestfulService=" + this.f3224d);
        if (this.f3224d != null) {
            this.f3224d.m6695a(afVar, c1378e);
        }
    }

    public void m6469a(EditManagerModel editManagerModel, C1378e c1378e) {
        m6456a(new C1431m(editManagerModel), c1378e);
    }

    public void m6468a(DeviceSOSPhoneIOEntityModel deviceSOSPhoneIOEntityModel, C1378e c1378e) {
        m6456a(new C1430l(deviceSOSPhoneIOEntityModel), c1378e);
    }

    public void m6464a(CommonStateOModel commonStateOModel, C1378e c1378e) {
        m6456a(new C1434p(commonStateOModel), c1378e);
    }

    public void m6457a(AbilityIOModel abilityIOModel, C1378e c1378e) {
        this.f3223c.m6709a(new C1419a(abilityIOModel), c1378e);
    }

    private void m6456a(C1418a c1418a, C1378e c1378e) {
        C2538c.m12674b("HttpApi", "restfulService =" + this.f3223c);
        if (this.f3223c != null) {
            this.f3223c.m6709a(c1418a, c1378e);
        }
    }

    public void m6460a(AppProfileModel appProfileModel, C1378e c1378e) {
        C1418a c1433o = new C1433o(appProfileModel);
        if (this.f3223c != null) {
            this.f3223c.m6709a(c1433o, c1378e);
        }
    }

    public void m6492a(VerifyBindCodeModel verifyBindCodeModel, C1378e c1378e) {
        C1418a akVar = new ak(verifyBindCodeModel);
        if (this.f3223c != null) {
            this.f3223c.m6709a(akVar, c1378e);
        }
    }
}
