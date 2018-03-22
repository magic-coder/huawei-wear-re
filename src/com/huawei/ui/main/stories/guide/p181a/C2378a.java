package com.huawei.ui.main.stories.guide.p181a;

import android.content.Context;
import com.huawei.ab.C0630m;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.up.model.UserInfomation;

/* compiled from: GuideInteractors */
public class C2378a extends C0628a {
    private Context f8570a = BaseApplication.m2632b();
    private C0630m f8571b = C0630m.m2297a(this.f8570a);

    public C2378a(Context context) {
        super(context);
    }

    protected Integer getModuleId() {
        return Integer.valueOf(MessageObserver.RET_AUTH_ERROR);
    }

    public void m11988a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("GuideInteractors", "getUserInfo enter");
        C0630m.m2297a(this.f8570a).m2306a(iBaseResponseCallback);
    }

    public void m11987a(Context context, UserInfomation userInfomation, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("GuideInteractors", "setUserInfo enter");
        C0630m.m2297a(this.f8570a).m2311a(false, context, userInfomation, iBaseResponseCallback);
    }

    public void m11989a(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeAgreeFlagToSharePreference enter");
        setSharedPreference("KEY_GUIDE_AGREE_PROTOCOL_AND_CLAUSE_FLAG", String.valueOf(z), null);
    }

    public void m11986a(int i) {
        C2538c.m12677c("GuideInteractors", "writeProtocolNumberToSharePreference enter,num = " + i);
        setSharedPreference("KEY_GUIDE_AGREE_PROTOCOL_AND_CLAUSE_NUMBER", String.valueOf(i), null);
    }

    public int m11985a() {
        C2538c.m12677c("GuideInteractors", "getProtocolNumFromSharePreference enter");
        String sharedPreference = getSharedPreference("KEY_GUIDE_AGREE_PROTOCOL_AND_CLAUSE_NUMBER");
        if (sharedPreference == null || sharedPreference.equals("")) {
            return 0;
        }
        C2538c.m12677c("GuideInteractors", "getProtocolNumFromSharePreference enter,protocolNumber = " + Integer.parseInt(sharedPreference.trim()));
        return Integer.parseInt(sharedPreference.trim());
    }

    public boolean m11992b() {
        C2538c.m12677c("GuideInteractors", "getAgreeFlagInSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_AGREE_PROTOCOL_AND_CLAUSE_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public void m11991b(boolean z) {
        C2538c.m12677c("GuideInteractors", "setUserAgreeFlagJoinPlan enter(): flagJoinPlan = " + z);
        this.f8571b.m2304a(1, z, "", null);
    }

    public boolean m11994c() {
        C2538c.m12677c("GuideInteractors", "getUserAgreeFlagJoinPlan enter");
        return this.f8571b.m2318c();
    }

    public void m11993c(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeSetUserInfoSuccessFlagToSharePreference enter");
        setSharedPreference("KEY_GUIDE_SET_USER_INFO_SUCCESS_FLAG", String.valueOf(z), null);
    }

    public void m11995d(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeSetOldUserSuccessFlagToSharePreference enter = " + z);
        setSharedPreference("KEY_GUIDE_SET_OLD_USER_SUCCESS_FLAG", String.valueOf(z), null);
    }

    public void m11997e(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeSetShowDownloadHihealthActivitySuccessFlagToSharePreference enter = " + z);
        setSharedPreference("KEY_GUIDE_SET_SHOW_HIHEALTH_DOWNLOAD_ACTIVITY_FLAG", String.valueOf(z), null);
    }

    public void m11999f(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeSetShowDownloadHihealthCardFlagToSharePreference enter = " + z);
        setSharedPreference("KEY_GUIDE_SET_SHOW_HIHEALTH_DOWNLOAD_ACTIVITY_CRAD_FLAG", String.valueOf(z), null);
    }

    public boolean m11996d() {
        C2538c.m12677c("GuideInteractors", "geSetUserInfoSuccessFlagInSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_SET_USER_INFO_SUCCESS_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public boolean m11998e() {
        C2538c.m12677c("GuideInteractors", "geSetOldUserSuccessFlagInSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_SET_OLD_USER_SUCCESS_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public boolean m12000f() {
        C2538c.m12677c("GuideInteractors", "geShowDownloadHihealthActivitySuccessFlagInSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_SET_SHOW_HIHEALTH_DOWNLOAD_ACTIVITY_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public boolean m12002g() {
        C2538c.m12677c("GuideInteractors", "geShowDownloadHihealthCardFlagToSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_SET_SHOW_HIHEALTH_DOWNLOAD_ACTIVITY_CRAD_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public void m12001g(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeShowSyncDialogFlagInSharePreference enter");
        setSharedPreference("KEY_SHOW_SYNC_DIALOG_ON_HOME_FRAGMENT", String.valueOf(z), null);
    }

    public void m12003h(boolean z) {
        C2538c.m12677c("GuideInteractors", "setAndroidWearOpenEsimFlagInSharePreference enter" + z);
        setSharedPreference("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", String.valueOf(z), null);
    }

    public void m12005i(boolean z) {
        C2538c.m12677c("GuideInteractors", "setAndroidWearOpenWalletFlagInSharePreference enter" + z);
        setSharedPreference("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", String.valueOf(z), null);
    }

    public boolean m12004h() {
        C2538c.m12677c("GuideInteractors", "getAndroidWearOpenEsimFlagInSharePreference enter");
        if (getSharedPreference("KEY_ANROIDWEAR_OPEN_ESIM_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public boolean m12006i() {
        C2538c.m12677c("GuideInteractors", "getAndroidWearOpenWalletFlagInSharePreference enter");
        if ("true".equals(getSharedPreference("KEY_ANROIDWEAR_OPEN_WALLET_FLAG"))) {
            return true;
        }
        return false;
    }

    protected void onDestroy() {
        super.onDestroy();
        C0977d.m3575n(this.f8570a);
    }

    public void m12007j(boolean z) {
        C2538c.m12677c("GuideInteractors", "writeSetShowSupportNewHiHealthCardFlagToSharePreference enter = " + z);
        setSharedPreference("KEY_GUIDE_SET_SHOW_NEW_HIHEALTH_ACTIVITY_CRAD_FLAG", String.valueOf(z), null);
    }

    public boolean m12008j() {
        C2538c.m12677c("GuideInteractors", "geShowSupportNewHiHealthCardFlagToSharePreference enter");
        if (getSharedPreference("KEY_GUIDE_SET_SHOW_NEW_HIHEALTH_ACTIVITY_CRAD_FLAG").equals("true")) {
            return true;
        }
        return false;
    }

    public void m12009k(boolean z) {
        C2538c.m12677c("GuideInteractors", "setDevelopOptionInSharePreference enter flag " + z);
        setSharedPreference("KEY_DEVELOP_OPTION_ENABLE_FLAG", String.valueOf(z), null);
    }

    public boolean m12010k() {
        C2538c.m12677c("GuideInteractors", "getDevelopOptionInSharePreference enter");
        if ("true".equals(getSharedPreference("KEY_DEVELOP_OPTION_ENABLE_FLAG"))) {
            return true;
        }
        return false;
    }

    public void m11990b(int i) {
        C2538c.m12677c("GuideInteractors", "writeAppVersionToSharePreference enter = " + i);
        setSharedPreference("KEY_GUIDE_SET_APP_VERSION", String.valueOf(i), null);
    }

    public int m12011l() {
        C2538c.m12677c("GuideInteractors", "getAppVersionToSharePreference enter");
        C2538c.m12677c("GuideInteractors", "getAppVersionToSharePreference version :  " + C0977d.m3524a(getSharedPreference("KEY_GUIDE_SET_APP_VERSION"), 1));
        return C0977d.m3524a(getSharedPreference("KEY_GUIDE_SET_APP_VERSION"), 1);
    }

    public void m12012l(boolean z) {
        C2538c.m12677c("GuideInteractors", "setAndroidWearOpenEsimFlagInSharePreference enter" + z);
        setSharedPreference("key_pair_success_from_pair_activity", String.valueOf(z), null);
    }

    public boolean m12014m() {
        C2538c.m12677c("GuideInteractors", "getAndroidWearOpenEsimFlagInSharePreference enter");
        if (getSharedPreference("key_pair_success_from_pair_activity").equals("true")) {
            return true;
        }
        return false;
    }

    public void m12013m(boolean z) {
        C2538c.m12677c("GuideInteractors", "setRootReminderIsChecked enter" + z);
        setSharedPreference("key_root_reminder_checkbox_is_checked", String.valueOf(z), null);
    }

    public boolean m12015n() {
        C2538c.m12677c("GuideInteractors", "setRootReminderIsChecked enter");
        if (getSharedPreference("key_root_reminder_checkbox_is_checked").equals("true")) {
            return true;
        }
        return false;
    }
}
