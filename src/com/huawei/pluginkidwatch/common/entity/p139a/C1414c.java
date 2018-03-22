package com.huawei.pluginkidwatch.common.entity.p139a;

import android.content.Context;
import com.huawei.hwcloudmodel.c.a.b;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
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
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: KidApi */
public class C1414c implements C1413d {
    private static C1414c f3225d = null;
    C1411a f3226a = null;
    C1412b f3227b = null;
    private Context f3228c = null;
    private boolean f3229e = true;

    public static C1414c m6542a(Context context) {
        synchronized (C1414c.class) {
            if (f3225d == null && context != null) {
                f3225d = new C1414c(context.getApplicationContext());
            }
        }
        return f3225d;
    }

    private C1414c(Context context) {
        this.f3228c = context;
        this.f3226a = C1411a.m6450a(this.f3228c);
        this.f3227b = C1412b.m6455a(this.f3228c);
    }

    private C1414c() {
    }

    public void mo2483a(GetDeviceProfileRetModel getDeviceProfileRetModel, C1378e c1378e) {
        getDeviceProfileRetModel.interfaceName = "com.huawei.watch.getDeviceProfile";
        this.f3227b.m6473a(getDeviceProfileRetModel, c1378e);
    }

    public void mo2494a(SetDeviceProfileModel setDeviceProfileModel, C1378e c1378e) {
        setDeviceProfileModel.interfaceName = "com.huawei.watch.setDeviceProfile";
        this.f3227b.m6484a(setDeviceProfileModel, c1378e);
    }

    public void mo2505a(WatchStatusIOModel watchStatusIOModel, C1378e c1378e) {
        if (c1378e == null || C1483c.m6831b(watchStatusIOModel.deviceCode)) {
            watchStatusIOModel.interfaceName = "com.huawei.watch.getWatchStatus";
            this.f3227b.m6495a(watchStatusIOModel, c1378e);
            return;
        }
        c1378e.mo2465a(null);
    }

    public void mo2473a(CommonRetOModel commonRetOModel, C1378e c1378e) {
        commonRetOModel.interfaceName = "com.huawei.watch.sendCommand";
        this.f3227b.m6463a(commonRetOModel, c1378e);
    }

    public void mo2501a(ValidateCodeIOEntityModel validateCodeIOEntityModel, C1378e c1378e) {
        validateCodeIOEntityModel.interfaceName = "com.huawei.watch.getSecurityCode";
        this.f3227b.m6491a(validateCodeIOEntityModel, c1378e);
    }

    public void mo2491a(PhoneNumIOEntityModel phoneNumIOEntityModel, C1378e c1378e) {
        phoneNumIOEntityModel.interfaceName = "com.huawei.watch.setPhoneNum";
        this.f3227b.m6481a(phoneNumIOEntityModel, c1378e);
    }

    public void mo2471a(BindDeviceIOEntityModel bindDeviceIOEntityModel, C1378e c1378e) {
        bindDeviceIOEntityModel.interfaceName = "com.huawei.watch.bindDevice";
        this.f3227b.m6461a(bindDeviceIOEntityModel, c1378e);
    }

    public void mo2509b(PhoneNumIOEntityModel phoneNumIOEntityModel, C1378e c1378e) {
        phoneNumIOEntityModel.interfaceName = "com.huawei.watch.getPhoneNum";
        this.f3227b.m6496b(phoneNumIOEntityModel, c1378e);
    }

    public void mo2498a(TransferPrivilegeIOEntityModel transferPrivilegeIOEntityModel, C1378e c1378e) {
        transferPrivilegeIOEntityModel.interfaceName = "com.huawei.watch.transferPrivilege";
        this.f3227b.m6488a(transferPrivilegeIOEntityModel, c1378e);
    }

    public void mo2477a(DeviceBindUsersIOEntityModel deviceBindUsersIOEntityModel, C1378e c1378e) {
        deviceBindUsersIOEntityModel.interfaceName = "com.huawei.watch.getDeviceBindUsers";
        this.f3227b.m6467a(deviceBindUsersIOEntityModel, c1378e);
    }

    public void mo2490a(MotionPathsIOEntityModel motionPathsIOEntityModel, C1378e c1378e) {
        motionPathsIOEntityModel.interfaceName = "com.huawei.watch.getMotionPaths";
        this.f3227b.m6480a(motionPathsIOEntityModel, c1378e);
    }

    public void mo2468a(AddFenceIOEntityModel addFenceIOEntityModel, C1378e c1378e) {
        addFenceIOEntityModel.interfaceName = "com.huawei.watch.setFence";
        this.f3227b.m6458a(addFenceIOEntityModel, c1378e);
    }

    public void mo2480a(FenceIOEntityModel fenceIOEntityModel, C1378e c1378e) {
        fenceIOEntityModel.interfaceName = "com.huawei.watch.getFences";
        this.f3227b.m6470a(fenceIOEntityModel, c1378e);
    }

    public void mo2488a(HandleFenceIOEntityModel handleFenceIOEntityModel, C1378e c1378e) {
        handleFenceIOEntityModel.interfaceName = "com.huawei.watch.handleFence";
        this.f3227b.m6478a(handleFenceIOEntityModel, c1378e);
    }

    public void mo2492a(RewardIOEntityModel rewardIOEntityModel, C1378e c1378e) {
        rewardIOEntityModel.interfaceName = "com.huawei.watch.addReward";
        this.f3227b.m6482a(rewardIOEntityModel, c1378e);
    }

    public void mo2484a(GetRewardInfoRetModel getRewardInfoRetModel, C1378e c1378e) {
        getRewardInfoRetModel.interfaceName = "com.huawei.watch.getRewardInfo";
        this.f3227b.m6474a(getRewardInfoRetModel, c1378e);
    }

    public void mo2500a(UploadTMIDIOEntityModel uploadTMIDIOEntityModel, C1378e c1378e) {
        uploadTMIDIOEntityModel.interfaceName = "com.huawei.watch.uploadTMID";
        this.f3227b.m6490a(uploadTMIDIOEntityModel, c1378e);
    }

    public void mo2475a(ConfirmBindIOEntityModel confirmBindIOEntityModel, C1378e c1378e) {
        confirmBindIOEntityModel.interfaceName = "com.huawei.watch.confirmBind";
        this.f3227b.m6465a(confirmBindIOEntityModel, c1378e);
    }

    public void mo2472a(BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel, C1378e c1378e) {
        bindDeviceInfosIOEntityModel.interfaceName = "com.huawei.watch.getBindDeviceInfos";
        this.f3227b.m6462a(bindDeviceInfosIOEntityModel, c1378e);
    }

    public void mo2504a(WatchSecurityCodeIOEntityModel watchSecurityCodeIOEntityModel, C1378e c1378e) {
        watchSecurityCodeIOEntityModel.interfaceName = "com.huawei.watch.getWatchSecurityCode";
        this.f3227b.m6494a(watchSecurityCodeIOEntityModel, c1378e);
    }

    public void mo2503a(WatchPhoneNumIOEntityModel watchPhoneNumIOEntityModel, C1378e c1378e) {
        watchPhoneNumIOEntityModel.interfaceName = "com.huawei.watch.setWatchPhoneNum";
        this.f3227b.m6493a(watchPhoneNumIOEntityModel, c1378e);
    }

    public void mo2481a(GetContactIOEntityModel getContactIOEntityModel, C1378e c1378e) {
        getContactIOEntityModel.interfaceName = "com.huawei.watch.getWatchContact";
        this.f3227b.m6471a(getContactIOEntityModel, c1378e);
    }

    public void mo2469a(AddWatchContactIOEntityModel addWatchContactIOEntityModel, C1378e c1378e) {
        addWatchContactIOEntityModel.interfaceName = "com.huawei.watch.addWatchContact";
        this.f3227b.m6459a(addWatchContactIOEntityModel, c1378e);
    }

    public void mo2476a(DeleteWatchContactIOEntityModel deleteWatchContactIOEntityModel, C1378e c1378e) {
        deleteWatchContactIOEntityModel.interfaceName = "com.huawei.watch.deleteWatchContact";
        this.f3227b.m6466a(deleteWatchContactIOEntityModel, c1378e);
    }

    public void mo2495a(SetWatchContactIOEntityModel setWatchContactIOEntityModel, C1378e c1378e) {
        setWatchContactIOEntityModel.interfaceName = "com.huawei.watch.setWatchContact";
        this.f3227b.m6485a(setWatchContactIOEntityModel, c1378e);
    }

    public void mo2496a(SetWatchSettingIOModel setWatchSettingIOModel, C1378e c1378e) {
        setWatchSettingIOModel.interfaceName = "com.huawei.watch.setWatchSetting";
        this.f3227b.m6486a(setWatchSettingIOModel, c1378e);
    }

    public void mo2487a(GetWatchSettingModel getWatchSettingModel, C1378e c1378e) {
        getWatchSettingModel.interfaceName = "com.huawei.watch.getWatchSetting";
        this.f3227b.m6477a(getWatchSettingModel, c1378e);
    }

    public void mo2478a(DeviceSOSPhoneIOEntityModel deviceSOSPhoneIOEntityModel, C1378e c1378e) {
        deviceSOSPhoneIOEntityModel.interfaceName = "com.huawei.watch.setSosPriority";
        this.f3227b.m6468a(deviceSOSPhoneIOEntityModel, c1378e);
    }

    public void mo2499a(UnbindDeviceIOEntityModel unbindDeviceIOEntityModel, C1378e c1378e) {
        unbindDeviceIOEntityModel.interfaceName = "com.huawei.watch.unbindDevice";
        this.f3227b.m6489a(unbindDeviceIOEntityModel, c1378e, this.f3228c);
    }

    public void mo2482a(GetDeviceModel getDeviceModel, C1378e c1378e) {
        getDeviceModel.interfaceName = "com.huawei.watch.getDevice";
        this.f3227b.m6472a(getDeviceModel, c1378e);
    }

    public void mo2489a(HealthDataIOEntityModel healthDataIOEntityModel, C1378e c1378e) {
        healthDataIOEntityModel.interfaceName = "com.huawei.watch.getSportData";
        this.f3227b.m6479a(healthDataIOEntityModel, c1378e);
    }

    public void mo2493a(SetAccompanyUserIEntityModel setAccompanyUserIEntityModel, C1378e c1378e) {
        setAccompanyUserIEntityModel.interfaceName = "com.huawei.watch.setAccompanyUser";
        this.f3227b.m6483a(setAccompanyUserIEntityModel, c1378e);
    }

    public void mo2485a(GetTpyeRetModel getTpyeRetModel, C1378e c1378e) {
        getTpyeRetModel.interfaceName = "com.huawei.watch.inviteManager";
        this.f3227b.m6475a(getTpyeRetModel, c1378e);
    }

    public void mo2486a(GetVoiceModel getVoiceModel, C1378e c1378e) {
        getVoiceModel.interfaceName = "com.huawei.watch.addChatMessage";
        this.f3227b.m6476a(getVoiceModel, c1378e);
    }

    public void mo2497a(SynchronizePushIOEntityModel synchronizePushIOEntityModel, C1378e c1378e) {
        synchronizePushIOEntityModel.interfaceName = "com.huawei.watch.syncronizePushInfo";
        this.f3227b.m6487a(synchronizePushIOEntityModel, c1378e);
    }

    public void mo2479a(EditManagerModel editManagerModel, C1378e c1378e) {
        editManagerModel.interfaceName = "com.huawei.watch.setDeviceUser";
        this.f3227b.m6469a(editManagerModel, c1378e);
    }

    public void mo2502a(VerifyBindCodeModel verifyBindCodeModel, C1378e c1378e) {
        verifyBindCodeModel.interfaceName = "com.huawei.watch.verifyBindCode";
        this.f3227b.m6492a(verifyBindCodeModel, c1378e);
    }

    public void mo2474a(CommonStateOModel commonStateOModel, C1378e c1378e) {
        commonStateOModel.interfaceName = "com.huawei.watch.getCommonState";
        this.f3227b.m6464a(commonStateOModel, c1378e);
    }

    public void mo2507a(String str, C1647c c1647c) {
        this.f3226a.m6453a(str, c1647c);
    }

    public int mo2466a(String str) {
        return this.f3226a.m6452a(str);
    }

    public void mo2508a(String str, String str2) {
        if (2 != this.f3226a.m6452a(str)) {
            m6546b();
        } else {
            this.f3226a.m6454a(str, str2);
        }
    }

    private void m6543a() {
        C2538c.m12674b("getSOSLocation", "=======Enter fresh immediately");
        CommonRetOModel commonRetOModel = new CommonRetOModel();
        commonRetOModel.data = "";
        commonRetOModel.deviceCode = C1462f.m6746j();
        commonRetOModel.type = 15;
        Context b = C1462f.m6724b();
        if (b != null) {
            C1417a.m6594a(b).mo2473a(commonRetOModel, new C1415d(this));
        }
    }

    private void m6546b() {
        C2538c.m12674b("KidApi", "=====Enter timer1");
        try {
            if (this.f3229e) {
                this.f3229e = false;
                new Timer().schedule(new C1416e(this), 5000);
                return;
            }
            C2538c.m12674b("KidApi", "=====Timer has already started,so don't need start again");
        } catch (Exception e) {
            C2538c.m12674b("KidApi", "=====ERROR! e = " + e.getMessage());
            this.f3229e = true;
        }
    }

    public void mo2467a(AbilityIOModel abilityIOModel, C1378e c1378e) {
        abilityIOModel.interfaceName = "com.huawei.watch.getWatchAbility";
        this.f3227b.m6457a(abilityIOModel, c1378e);
    }

    public void mo2470a(AppProfileModel appProfileModel, C1378e c1378e) {
        appProfileModel.interfaceName = "com.huawei.watch.getAppProfile";
        this.f3227b.m6460a(appProfileModel, c1378e);
    }

    public void m6548a(a<Boolean> aVar) {
        Map hashMap = new HashMap();
        new b(this.f3228c).a("/kidwatch/bindWatch/getManagerNum", hashMap, aVar);
    }

    public void mo2506a(String str, a<Boolean> aVar) {
        Map hashMap = new HashMap();
        hashMap.put("imei", str);
        new b(this.f3228c).a("/kidwatch/bindWatch/resetManagerPreCheck", hashMap, aVar);
    }

    public void mo2510b(String str, a<Boolean> aVar) {
        Map hashMap = new HashMap();
        hashMap.put("imei", str);
        new b(this.f3228c).a("/kidwatch/bindWatch/resetManager", hashMap, aVar);
    }
}
