package com.huawei.bone.p552b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.ab.m;
import com.huawei.account.aidl.AccountAidlInfo;
import com.huawei.bone.C6753R;
import com.huawei.bone.root.MainActivity;
import com.huawei.bone.service.MigrateIntentService;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.g.a.v;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.a.ba;
import com.huawei.hwdatamigrate.a.h;
import com.huawei.hwdatamigrate.hihealth.c.be;
import com.huawei.hwdatamigrate.hihealth.c.bf;
import com.huawei.hwservicesmgr.PhoneService;
import com.huawei.hwservicesmgr.a.q;
import com.huawei.login.ui.login.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.a.f;
import com.huawei.sim.multisim.MultiSimAuth;
import com.huawei.ui.commonui.dialog.ae;
import com.huawei.ui.commonui.dialog.af;
import com.huawei.ui.device.activity.adddevice.AddDeviceActivity;
import com.huawei.ui.main.stories.downloadhihealth.activity.UpDateHiHealthActivity;
import com.huawei.ui.main.stories.guide.activity.BasicInfoSettingActivity;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: MainInterators */
public class C6756a {
    private static AccountAidlInfo f23118f = null;
    Class<?> f23119a = MainActivity.class;
    public boolean f23120b = false;
    public boolean f23121c = false;
    public boolean f23122d = false;
    public int f23123e = 0;
    private Context f23124g = null;
    private Handler f23125h = null;
    private Activity f23126i = null;
    private boolean f23127j = false;
    private boolean f23128k = false;
    private boolean f23129l = false;
    private boolean f23130m = false;
    private boolean f23131n = false;
    private af f23132o;
    private ae f23133p;
    private boolean f23134q = false;
    private boolean f23135r = false;
    private boolean f23136s = false;
    private Handler f23137t = new C6772q(this);
    private Runnable f23138u = new ab(this);

    public void m30072a() {
        this.f23129l = true;
        this.f23137t.removeCallbacks(this.f23138u);
        this.f23137t.post(this.f23138u);
    }

    public boolean m30084b() {
        boolean z;
        Context b = BaseApplication.b();
        if (!TextUtils.isEmpty(a.a(b).g())) {
            C2538c.c("MainInterators", new Object[]{"20 has login in"});
            z = true;
        } else if (com.huawei.hwdatamigrate.a.a(b).b(b)) {
            if ("true".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_migrate_from_15"))) {
                C2538c.c("MainInterators", new Object[]{"not need migrate data."});
                z = false;
            } else {
                ba c = h.c(b, h.a(b));
                if (c == null || c.g == null || c.g.isEmpty()) {
                    c.c("MainInterators", new Object[]{"app 1.5 is not login 2"});
                    z = false;
                } else if (h.c(BaseApplication.b())) {
                    c.c("MainInterators", new Object[]{"app 1.5 is already login 2"});
                    z = true;
                } else {
                    c.c("MainInterators", new Object[]{"app 1.5 is not login 3"});
                    z = false;
                }
            }
        } else {
            z = false;
        }
        C2538c.c("MainInterators", new Object[]{"states:" + a.a(BaseApplication.b()).d() + " isLogin:" + z});
        if (a.a(BaseApplication.b()).d() && z) {
            z = true;
        } else {
            z = false;
        }
        C2538c.c("MainInterators", new Object[]{"Leave getLoginState isLogin:" + z});
        return z;
    }

    public static boolean m30037a(Context context) {
        boolean z;
        com.huawei.login.a.a aVar = new com.huawei.login.a.a(context, null);
        if (com.huawei.login.a.a.c(context)) {
            z = true;
        } else {
            z = false;
        }
        C2538c.c("MainInterators", new Object[]{"isHwIdApkLogined: res:" + z});
        return z;
    }

    public static boolean m30044b(Context context) {
        C2538c.c("MainInterators", new Object[]{"isInstallHwIdApk = " + com.huawei.login.a.a.b(context)});
        return com.huawei.login.a.a.b(context);
    }

    public void m30077a(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter goToLoginActivity "});
        new com.huawei.up.a.a(context.getApplicationContext()).a(context, iBaseResponseCallback);
    }

    private boolean m30064q() {
        boolean z;
        f a = f.a(BaseApplication.b());
        boolean d = a.d();
        boolean e = a.e();
        if (d || e) {
            z = true;
        } else {
            z = false;
        }
        C2538c.c("MainInterators", new Object[]{"isKidwatchExist k1Exist:" + d + "\n k2Exist:" + e + " isKidwatchExist res:" + z});
        return z;
    }

    private void m30027a(Context context, boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter getHuidInHwid "});
        if (z) {
            new com.huawei.login.a.a(BaseApplication.b(), null).a(context, iBaseResponseCallback);
        } else {
            iBaseResponseCallback.onResponse(190110, "no need login ");
        }
    }

    public boolean m30087c() {
        boolean z;
        C2538c.c("MainInterators", new Object[]{"isTimeout:", com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout")});
        if ("false".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout"))) {
            C2538c.c("MainInterators", new Object[]{"migrateOver:", com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over")});
            if ("true".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over"))) {
                z = false;
            } else {
                z = true;
            }
        } else {
            com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "", new com.huawei.hwdataaccessmodel.a.c(0));
            z = true;
        }
        C2538c.c("MainInterators", new Object[]{"isNeedLogin:", Boolean.valueOf(z)});
        return z;
    }

    public boolean m30089d() {
        boolean b = m30084b();
        if ((m30087c() || !b) && !(b && m30064q())) {
            b = false;
        } else {
            b = true;
        }
        C2538c.b("MainInterators", new Object[]{"isSupportAD res:" + b});
        return b;
    }

    public String m30090e() {
        C2538c.c("MainInterators", new Object[]{"Enter getCurrentUserId"});
        Object c = a.a(BaseApplication.b()).c();
        if (TextUtils.isEmpty(c)) {
            c.c("MainInterators", new Object[]{"2021 not logined"});
            if (com.huawei.hwdatamigrate.a.a(BaseApplication.b()).b(BaseApplication.b())) {
                if ("true".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_migrate_from_15"))) {
                    c.c("MainInterators", new Object[]{"not need migrate data."});
                } else {
                    boolean z;
                    c.c("MainInterators", new Object[]{"need to migrate"});
                    c.c("MainInterators", new Object[]{"isLogin：" + h.c(BaseApplication.b())});
                    String a = h.a(BaseApplication.b());
                    ba c2 = h.c(BaseApplication.b(), a);
                    if (c2 == null || c2.g == null || c2.g.isEmpty()) {
                        c.c("MainInterators", new Object[]{"app 1.5 is not login"});
                        z = false;
                    } else if (z) {
                        c.c("MainInterators", new Object[]{"app 1.5 is already login"});
                        z = true;
                    } else {
                        c.c("MainInterators", new Object[]{"app 1.5 is not login 2"});
                        z = false;
                    }
                    if (z && c2 != null) {
                        String str = c2.g;
                        if (c2.c != 0) {
                            str = com.huawei.hwdatamigrate.common.h.f(BaseApplication.b());
                        }
                        com.huawei.login.ui.login.util.c.a(BaseApplication.b()).a(a);
                        com.huawei.login.ui.login.util.c.a(BaseApplication.b()).a(str, null);
                        c.c("MainInterators", new Object[]{"original huid:" + a});
                        c.c("MainInterators", new Object[]{"original st:" + str});
                        if (1 == c2.c) {
                            com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b(4);
                        } else if (4 == c2.c) {
                            com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b(7);
                        } else if (6 == c2.c) {
                            com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b(1);
                        } else {
                            com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b(c2.c);
                        }
                        c.b("MainInterators", new Object[]{"original at:" + c2.b});
                        com.huawei.login.ui.login.util.c.a(BaseApplication.b()).c(h.e(BaseApplication.b(), str), null);
                        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_migrate_from_15", "true", new com.huawei.hwdataaccessmodel.a.c(0));
                        new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b()).c(true);
                    }
                }
            }
            c.c("MainInterators", new Object[]{"res:" + a.a(BaseApplication.b()).c()});
            return a.a(BaseApplication.b()).c();
        }
        c.c("MainInterators", new Object[]{"2021 logined"});
        return c;
    }

    public void m30092f() {
        C2538c.c("MainInterators", new Object[]{"saveTempAccountToAccount:-1"});
        com.huawei.login.ui.login.util.c.a(BaseApplication.b()).b(-1);
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_is_account_from_hwid_app", "migrate_account_is_from_hwid", new com.huawei.hwdataaccessmodel.a.c(0));
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "true", new com.huawei.hwdataaccessmodel.a.c(0));
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f23124g, String.valueOf(20007), "migrate_provide_login_infomation", "migrate_not_support", new com.huawei.hwdataaccessmodel.a.c(0));
        new com.huawei.login.a.a(BaseApplication.b(), null).e();
    }

    public boolean m30081a(String str) {
        if (i.a(57)) {
            boolean z;
            if (com.huawei.hwdatamigrate.a.a(BaseApplication.b()).b(BaseApplication.b())) {
                ArrayList b = h.b(BaseApplication.b());
                if (b != null) {
                    if (b.size() > 1) {
                        z = true;
                    } else if (1 == b.size() && !"default_userid".equals(b.get(0))) {
                        if (!(((String) b.get(0)).equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_old_st_of_before")) || ((String) b.get(0)).equals(str))) {
                            z = true;
                        }
                    }
                    C2538c.c("MainInterators", new Object[]{"isRemainingHuidExist:" + z});
                    return z;
                }
            }
            z = false;
            C2538c.c("MainInterators", new Object[]{"isRemainingHuidExist:" + z});
            return z;
        }
        C2538c.c("MainInterators", new Object[]{"isRemainingHuidExist: not support migrate data in cloud"});
        return false;
    }

    public void m30083b(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showHandleMigrateDialog"});
        C2538c.c("MainInterators", new Object[]{"showHandleMigrateDialog hasNotice:" + com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_show_handle_migrate")});
        if ("migrate_has_notice".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_show_handle_migrate"))) {
            iBaseResponseCallback.onResponse(0, "");
            return;
        }
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_has_show_handle_migrate", "migrate_has_notice", new com.huawei.hwdataaccessmodel.a.c(0));
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.c(context);
        aVar.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        aVar.c(context.getString(C6753R.string.IDS_migrage_forcechange_note3));
        aVar.a(context.getString(C6753R.string.IDS_common_notification_know_tips), new C6757b(this, iBaseResponseCallback, aVar));
        if (aVar.isShowing()) {
            C2538c.c("MainInterators", new Object[]{"showHandleMigrateDialog on click 2"});
            return;
        }
        C2538c.c("MainInterators", new Object[]{"showHandleMigrateDialog on click 1"});
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m30086c(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showAPPOuttimeDialog"});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.c(context);
        aVar.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        aVar.c(context.getString(C6753R.string.IDS_migrage_forcechange_note4));
        aVar.a(context.getString(C6753R.string.IDS_common_notification_know_tips), new C6776u(this, iBaseResponseCallback, aVar));
        if (aVar.isShowing()) {
            C2538c.c("MainInterators", new Object[]{"showAPPOuttimeDialog on click 2"});
            return;
        }
        C2538c.c("MainInterators", new Object[]{"showAPPOuttimeDialog on click 1"});
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m30088d(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showNetworkErrorDialog"});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.c(context);
        aVar.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        aVar.c(context.getString(C6753R.string.IDS_migrage_forcechange_note5));
        aVar.a(context.getString(C6753R.string.IDS_common_notification_know_tips), new ac(this, iBaseResponseCallback, aVar));
        if (aVar.isShowing()) {
            C2538c.c("MainInterators", new Object[]{"showNetworkErrorDialog on click 2"});
            return;
        }
        C2538c.c("MainInterators", new Object[]{"showNetworkErrorDialog on click 1"});
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m30091e(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showNetworkInviableDialog"});
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.c(context);
        aVar.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        aVar.c(context.getString(C6753R.string.IDS_connect_error));
        aVar.a(context.getString(C6753R.string.IDS_common_notification_know_tips), new ad(this, iBaseResponseCallback, aVar));
        if (aVar.isShowing()) {
            C2538c.c("MainInterators", new Object[]{"showNetworkInviableDialog on click 2"});
            return;
        }
        C2538c.c("MainInterators", new Object[]{"showNetworkInviableDialog on click 1"});
        aVar.b();
        aVar.setCancelable(false);
    }

    public void m30094g() {
        C2538c.c("MainInterators", new Object[]{"Enter saveHealthLoginStateAsWear"});
    }

    public void m30075a(long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("error_code", j);
        C2538c.a(907127009, "MainInterators", bundle, false, new Object[]{"notice cloud migrate account data but return error message." + bundle});
    }

    public long m30082b(String str) {
        long j = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
                C2538c.c("MainInterators", new Object[]{"NumberFormatException Error " + str});
            }
        }
        return j;
    }

    public void m30080a(ak akVar) {
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_old_st_of_before", a.a(BaseApplication.b()).c(), new com.huawei.hwdataaccessmodel.a.c(0));
        if (ak.DIFF_WITH_HEALTH.ordinal() == akVar.ordinal()) {
            C2538c.c("MainInterators", new Object[]{"dialogtype:DIALOGTYPE.DIFF_WITH_HEALTH"});
            m30094g();
            return;
        }
        C2538c.c("MainInterators", new Object[]{"dialogtype:DIALOGTYPE.DIFF_WITH_HWID"});
        m30092f();
    }

    public void m30078a(Context context, MergeUserAllDataReq mergeUserAllDataReq) {
        Intent intent = new Intent(context, MigrateIntentService.class);
        intent.setAction("com.huawei.bone.service.MigrateIntentService");
        intent.putExtra("migrate_old_huid", mergeUserAllDataReq.getOriginalHuid());
        intent.putExtra("migrate_old_st", mergeUserAllDataReq.getOriginalST());
        intent.putExtra("migrate_current_huid", a.a(BaseApplication.b()).c());
        context.startService(intent);
    }

    private void m30036a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C2538c.c("MainInterators", new Object[]{"null,return"});
            return;
        }
        bf bfVar = new bf();
        bfVar.b(str3);
        bfVar.a(str);
        bfVar.c(str2);
        if (i.a(57)) {
            bfVar.b(false);
        } else {
            bfVar.b(true);
        }
        bfVar.c(false);
        bfVar.a(false);
        bfVar.d(false);
        be.a().a(bfVar);
        be.a().c(str3);
    }

    public static boolean m30057h() {
        C2538c.c("MainInterators", new Object[]{"MainInterators --> Enter checkIsInstallHuaweiAccount"});
        C2538c.c("MainInterators", new Object[]{"MainInterators -- >checkIsInstallHuaweiAccount:", Boolean.valueOf(CloudAccount.checkIsInstallHuaweiAccount(BaseApplication.b()))});
        return CloudAccount.checkIsInstallHuaweiAccount(BaseApplication.b());
    }

    public void m30076a(Context context, ak akVar, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showForceMigrateDialog dialogtype:" + akVar});
        this.f23134q = true;
        MergeUserAllDataReq mergeUserAllDataReq = new MergeUserAllDataReq();
        String c = a.a(BaseApplication.b()).c();
        String g = a.a(BaseApplication.b()).g();
        mergeUserAllDataReq.setOriginalHuid(c);
        mergeUserAllDataReq.setOriginalST(g);
        c = "";
        if (ak.DIFF_WITH_HEALTH.ordinal() == akVar.ordinal()) {
            c = context.getString(C6753R.string.IDS_migrage_forcechange_note2);
            g = context.getResources().getQuantityString(C6753R.plurals.IDS_hour_string_21, 24, new Object[]{Integer.valueOf(24)});
            c.c("MainInterators", new Object[]{"Enter showForceMigrateDialog time:" + g});
            c = String.format(c, new Object[]{context.getString(C6753R.string.IDS_app_name), context.getString(C6753R.string.IDS_app_name_health), g});
        } else {
            c = context.getString(C6753R.string.IDS_migrage_forcechange_note);
            g = context.getResources().getQuantityString(C6753R.plurals.IDS_hour_string_21, 24, new Object[]{Integer.valueOf(24)});
            c.c("MainInterators", new Object[]{"Enter showForceMigrateDialog time:" + g});
            c = String.format(c, new Object[]{context.getString(C6753R.string.IDS_app_name), g});
        }
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        com.huawei.ui.commonui.dialog.a b = com.huawei.ui.commonui.dialog.a.b(context);
        b.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        b.c(c);
        b.a(context.getString(C6753R.string.IDS_main_change), new ae(this, akVar, mergeUserAllDataReq, context, iBaseResponseCallback, b));
        b.b(context.getString(C6753R.string.IDS_settings_button_cancal), new af(this, iBaseResponseCallback, b));
        if (!b.isShowing()) {
            b.b();
            b.setCancelable(false);
        }
    }

    public void m30093f(Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter showNoteLoginDialog "});
        String string = context.getString(C6753R.string.IDS_migrage_please_login);
        com.huawei.ui.commonui.dialog.a aVar = new com.huawei.ui.commonui.dialog.a(context, C6753R.style.app_update_dialogActivity);
        aVar = com.huawei.ui.commonui.dialog.a.b(context);
        aVar.b(context.getString(C6753R.string.IDS_service_area_notice_title));
        aVar.c(string);
        aVar.a(context.getString(C6753R.string.IDS_yes), new ag(this, iBaseResponseCallback, aVar));
        aVar.b(context.getString(C6753R.string.IDS_no), new ah(this, iBaseResponseCallback, aVar));
        if (!aVar.isShowing()) {
            aVar.b();
            aVar.setCancelable(false);
        }
    }

    private void m30034a(MergeUserAllDataReq mergeUserAllDataReq, Context context, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c("MainInterators", new Object[]{"Enter sendMigrateDataToCloud"});
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f23135r = false;
        newSingleThreadExecutor.execute(new ai(this, mergeUserAllDataReq, context, iBaseResponseCallback, countDownLatch));
    }

    public void m30085c(Context context) {
        C2538c.c("MainInterators", new Object[]{"Enter setActivityContext"});
        C2538c.c("MainInterators", new Object[]{"Enter MainInterators begin"});
        if (context instanceof Activity) {
            this.f23124g = context;
            this.f23126i = (Activity) context;
            return;
        }
        C2538c.c("MainInterators", new Object[]{"Enter setActivityContext Error"});
        throw new RuntimeException("you need use an activitycontext,instead of an application");
    }

    public void m30079a(Handler handler) {
        C2538c.c("MainInterators", new Object[]{"Enter setHandler"});
        this.f23125h = handler;
    }

    public void m30095i() {
        C2538c.c("MainInterators", new Object[]{"Enter alreadyLoginProcess"});
        m30090e();
        if (m30064q()) {
            String str;
            C2538c.c("MainInterators", new Object[]{"alreadyLoginProcess kidwatch exist"});
            int b = a.a(this.f23124g.getApplicationContext()).b();
            boolean z = (b == 0 || b == -1) ? false : true;
            C2538c.c("MainInterators", new Object[]{"login third type! login type is:" + b, ", isThirdLogin = ", Boolean.valueOf(z)});
            String str2 = "";
            if (z) {
                str = "migrate_support";
                C2538c.c("MainInterators", new Object[]{"alreadyLoginProcess support st 1"});
            } else {
                if ("migrate_account_is_from_hwid".equals(com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_is_account_from_hwid_app")) || (C6756a.m30044b(this.f23124g.getApplicationContext()) && m30050d(this.f23124g.getApplicationContext()))) {
                    C2538c.c("MainInterators", new Object[]{"alreadyLoginProcess not support"});
                    str = "migrate_not_support";
                } else {
                    C2538c.c("MainInterators", new Object[]{"alreadyLoginProcess support st 2"});
                    str = "migrate_support";
                }
            }
            com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f23124g, String.valueOf(20007), "migrate_provide_login_infomation", str, new com.huawei.hwdataaccessmodel.a.c(0));
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 1"});
            m30102p();
            return;
        }
        C2538c.c("MainInterators", new Object[]{"alreadyLoginProcess kidwatch not exist"});
        C2538c.c("MainInterators", new Object[]{"healt not logined"});
        if (C6756a.m30037a(this.f23124g)) {
            m30065r();
        } else {
            m30066s();
        }
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f23124g, String.valueOf(20007), "migrate_provide_login_infomation", "migrate_not_support", new com.huawei.hwdataaccessmodel.a.c(0));
    }

    public void m30096j() {
        C2538c.c("MainInterators", new Object[]{"Enter notLoginProcess"});
        C2538c.c("MainInterators", new Object[]{"Enter loginHwid 1"});
        m30070w();
    }

    private void m30043b(ak akVar) {
        C2538c.c("MainInterators", new Object[]{"Enter processDifferentHuid"});
        if (m30064q()) {
            C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 3"});
            m30102p();
            return;
        }
        m30076a(this.f23124g, akVar, new C6758c(this));
    }

    private void m30065r() {
        Executors.newSingleThreadExecutor().execute(new C6760e(this));
    }

    private void m30066s() {
        C2538c.b("MainInterators", new Object[]{"Enter hwidNotLogined"});
        m30027a(this.f23124g, true, new C6766k(this, m30090e()));
    }

    private void m30040b(int i) {
        if (34 != i) {
            this.f23121c = false;
            if (3002 == i) {
                m30093f(this.f23124g, new C6769n(this));
            } else if (5 == i) {
                this.f23126i.runOnUiThread(new C6770o(this));
            } else if (190110 == i) {
                C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess NO_NEED_LOGIN 10"});
                m30102p();
            } else if (40 == i) {
                this.f23126i.runOnUiThread(new C6771p(this));
            } else if (35 == i) {
                C2538c.c("MainInterators", new Object[]{"low version...."});
                this.f23123e++;
                this.f23122d = true;
            } else {
                C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 9"});
                m30102p();
            }
        } else if (this.f23121c) {
            this.f23123e++;
            com.huawei.ui.commonui.c.a.a(this.f23124g, this.f23124g.getString(C6753R.string.IDS_main_pleast_install_hwid));
        } else {
            this.f23121c = true;
        }
    }

    private void m30067t() {
        C2538c.c("MainInterators", new Object[]{"Enter showAppOuttimeDialog"});
        m30086c(this.f23124g, new C6773r(this));
    }

    private void m30068u() {
        C2538c.c("MainInterators", new Object[]{"Enter showNetworkErrorDialog"});
        m30088d(this.f23124g, new C6774s(this));
    }

    private void m30069v() {
        C2538c.c("MainInterators", new Object[]{"Enter showNetworkInvalableDialog"});
        m30091e(this.f23124g, new C6775t(this));
    }

    private void m30070w() {
        C2538c.c("MainInterators", new Object[]{"Enter loginHwid"});
        if (m30084b()) {
            C2538c.c("MainInterators", new Object[]{"loginHwid hwid logined return"});
            return;
        }
        m30077a(this.f23124g, new C6777v(this));
    }

    public void m30074a(int i, Object obj) {
        C2538c.c("MainInterators", new Object[]{"loginResult -err_code:" + i});
        this.f23126i.runOnUiThread(new C6778w(this, i, obj));
    }

    private void m30046c(int i) {
        if (34 != i) {
            this.f23120b = false;
            this.f23122d = false;
            if (3002 == i) {
                m30093f(this.f23124g, new C6780y(this));
            } else if (5 == i) {
                this.f23126i.runOnUiThread(new C6781z(this));
            } else if (35 == i) {
                C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 请升级"});
                this.f23123e++;
                this.f23122d = true;
            } else if (40 == i) {
                this.f23126i.runOnUiThread(new aa(this));
            } else {
                C2538c.c("MainInterators", new Object[]{"Enter MainInterators originalProcess 12"});
                m30102p();
            }
        } else if (this.f23120b) {
            this.f23123e++;
            com.huawei.ui.commonui.c.a.a(this.f23124g, this.f23124g.getString(C6753R.string.IDS_main_pleast_install_hwid));
        } else {
            this.f23120b = true;
        }
    }

    public void m30097k() {
        C2538c.c("MainInterators", new Object[]{"onResume"});
        if (this.f23134q) {
            C2538c.c("MainInterators", new Object[]{"onResume reset"});
            this.f23120b = false;
            this.f23121c = false;
            this.f23122d = false;
            this.f23123e = 0;
        }
        C2538c.c("MainInterators", new Object[]{"onResume HWID_IS_NOT_EXIT_1:" + this.f23120b});
        C2538c.c("MainInterators", new Object[]{"onResume HWID_IS_NOT_EXIT_2:" + this.f23121c});
        C2538c.c("MainInterators", new Object[]{"onResume HWID_IS_NOT_EXIT_3:" + this.f23122d});
        C2538c.c("MainInterators", new Object[]{"onResume ALART_TIMES:" + this.f23123e});
        if (this.f23120b) {
            if (this.f23123e < 1) {
                C2538c.c("MainInterators", new Object[]{"Enter loginHwid 2"});
                m30070w();
            } else if (C6756a.m30057h()) {
                C2538c.c("MainInterators", new Object[]{"Enter loginHwid 3"});
                m30070w();
            } else {
                this.f23126i.finish();
            }
        }
        if (this.f23121c) {
            if (this.f23123e < 2) {
                m30066s();
            } else if (C6756a.m30057h()) {
                m30066s();
            } else {
                this.f23126i.finish();
            }
        }
        if (this.f23122d) {
            if (this.f23123e < 2) {
                C2538c.c("MainInterators", new Object[]{"Enter loginHwid 6"});
                this.f23122d = false;
                m30070w();
            } else {
                this.f23126i.finish();
            }
        }
        if (this.f23133p != null && this.f23132o != null) {
            C2538c.c("MainInterators", new Object[]{"noteDialog is not null, dismiss dialog first...."});
            this.f23132o.a(this.f23133p);
            this.f23132o = null;
            this.f23133p = null;
            C2538c.c("MainInterators", new Object[]{"login once to check if 40...."});
            if (m30084b()) {
                C2538c.c("MainInterators", new Object[]{"Enter if getLoginState.."});
                if ("0".equals(m30090e())) {
                    C2538c.c("MainInterators", new Object[]{"Enter cooperateWithHealth current huid is 0"});
                    m30102p();
                    return;
                }
                m30095i();
                return;
            }
            m30096j();
        }
    }

    public void m30098l() {
        if (this.f23137t != null) {
            this.f23137t.removeCallbacksAndMessages(null);
        }
    }

    public boolean m30099m() {
        C2538c.c("MainInterators", new Object[]{"getIfAccountArea res:" + m.a(BaseApplication.b()).e()});
        return m.a(BaseApplication.b()).e();
    }

    public String m30100n() {
        C2538c.c("MainInterators", new Object[]{"getAccountAreaFlag res:" + m.a(BaseApplication.b()).f()});
        return m.a(BaseApplication.b()).f();
    }

    public void m30073a(int i) {
        if (i >= 10) {
            i = 10;
        }
        m.a(BaseApplication.b()).b(i);
    }

    public int m30101o() {
        return m.a(BaseApplication.b()).j();
    }

    private boolean m30050d(Context context) {
        boolean exists;
        if (context != null) {
            exists = context.getApplicationContext().getDatabasePath("hihealth_003.db").exists();
        } else {
            C2538c.c("MainInterators", new Object[]{"isFromWear20 context is null"});
            exists = false;
        }
        C2538c.c("MainInterators", new Object[]{"isFromWear20 res:" + exists});
        return exists;
    }

    public void m30102p() {
        boolean z;
        Class b;
        C2538c.c("MainInterators", new Object[]{"Enter originalProcess"});
        com.huawei.ui.main.stories.guide.a.a aVar = new com.huawei.ui.main.stories.guide.a.a(BaseApplication.b());
        C2538c.c("MainInterators", new Object[]{"Enter bluetooth begin"});
        Intent intent = new Intent();
        intent.setClass(this.f23126i, PhoneService.class);
        this.f23126i.startService(intent);
        q.a(this.f23126i);
        C2538c.c("MainInterators", new Object[]{"Enter bluetooth end"});
        com.huawei.n.c a = com.huawei.n.c.a(BaseApplication.b());
        if (a != null) {
            C2538c.c("MainInterators", new Object[]{"hwDeviceConfigManager is not null"});
            if (a.b() == null) {
                C2538c.c("MainInterators", new Object[]{"no connected device "});
                this.f23131n = false;
            } else {
                C2538c.c("MainInterators", new Object[]{"have connected device "});
                this.f23131n = true;
            }
        }
        Intent intent2 = this.f23126i.getIntent();
        String action = intent2.getAction();
        aVar.h(false);
        aVar.i(false);
        if (action != null) {
            C2538c.b("MainInterators", new Object[]{"onCreate(), action " + action});
            if (action.equals("com.huawei.bone.ADD_MULTI_SIM_DEVICE")) {
                z = true;
            } else if (action.equals("com.google.android.wearable.action.CONFIGURE_CELLULAR")) {
                this.f23127j = true;
                aVar.h(true);
                z = false;
            } else if (action.equals("com.google.android.wearable.action.CONFIGURE_PAYMENTS")) {
                this.f23128k = true;
                aVar.i(true);
            }
            if (intent2.getBooleanExtra("need_multi_sim_auth", false)) {
                com.huawei.sim.a.a(BaseApplication.b()).setAdapter(v.a());
                this.f23119a = MultiSimAuth.class;
                C2538c.b("MainInterators", new Object[]{"startMultiSimAuthActivity."});
            } else if (z) {
                this.f23119a = AddDeviceActivity.class;
                C2538c.b("MainInterators", new Object[]{"startAddDeviceActivity."});
            } else if (!f.a(BaseApplication.b()).a()) {
                if (!aVar.d()) {
                    aVar.g(false);
                    this.f23119a = BasicInfoSettingActivity.class;
                    C2538c.b("MainInterators", new Object[]{"startBasicInfoSettingActivity."});
                } else if (aVar.e()) {
                    this.f23119a = UpDateHiHealthActivity.class;
                    C2538c.b("MainInterators", new Object[]{"startUpDateHiHealthActivity."});
                } else if (i.a(8) && !w.b()) {
                    C2538c.b("MainInterators", new Object[]{"Support Operation StartPage."});
                }
            } else if (!(this.f23127j || this.f23128k)) {
                b = f.a(BaseApplication.b()).b();
                if (b != null) {
                    this.f23119a = b;
                }
                C2538c.b("MainInterators", new Object[]{"startKidWatchHomeActivity."});
            }
            if (this.f23137t != null) {
                C2538c.b("MainInterators", new Object[]{"start Handler."});
                this.f23130m = true;
                this.f23137t.removeCallbacks(this.f23138u);
                this.f23137t.postDelayed(this.f23138u, 1000);
            }
        }
        z = false;
        if (intent2.getBooleanExtra("need_multi_sim_auth", false)) {
            com.huawei.sim.a.a(BaseApplication.b()).setAdapter(v.a());
            this.f23119a = MultiSimAuth.class;
            C2538c.b("MainInterators", new Object[]{"startMultiSimAuthActivity."});
        } else if (z) {
            this.f23119a = AddDeviceActivity.class;
            C2538c.b("MainInterators", new Object[]{"startAddDeviceActivity."});
        } else if (!f.a(BaseApplication.b()).a()) {
            b = f.a(BaseApplication.b()).b();
            if (b != null) {
                this.f23119a = b;
            }
            C2538c.b("MainInterators", new Object[]{"startKidWatchHomeActivity."});
        } else if (!aVar.d()) {
            aVar.g(false);
            this.f23119a = BasicInfoSettingActivity.class;
            C2538c.b("MainInterators", new Object[]{"startBasicInfoSettingActivity."});
        } else if (aVar.e()) {
            C2538c.b("MainInterators", new Object[]{"Support Operation StartPage."});
        } else {
            this.f23119a = UpDateHiHealthActivity.class;
            C2538c.b("MainInterators", new Object[]{"startUpDateHiHealthActivity."});
        }
        if (this.f23137t != null) {
            C2538c.b("MainInterators", new Object[]{"start Handler."});
            this.f23130m = true;
            this.f23137t.removeCallbacks(this.f23138u);
            this.f23137t.postDelayed(this.f23138u, 1000);
        }
    }

    private void m30035a(Class<?> cls) {
        Intent intent = new Intent(BaseApplication.b(), cls);
        intent.putExtra("haveDevice", this.f23131n);
        Bundle extras = this.f23126i.getIntent().getExtras();
        if (extras != null) {
            C2538c.b("MainInterators", new Object[]{"extras is not null."});
            intent.putExtra("openPackageName", extras.getString("openPackageName", ""));
            intent.putExtra("openClassName", extras.getString("openClassName", ""));
        }
        if (this.f23127j) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_ESIM_FLAG", true);
        }
        if (this.f23128k) {
            intent.putExtra("KEY_ANROIDWEAR_OPEN_WALLET_FLAG", true);
        }
        this.f23126i.startActivity(intent);
        C2538c.b("MainInterators", new Object[]{"Leave startActivity"});
        this.f23126i.finish();
    }

    private void m30071x() {
        C2538c.c("MainInterators", new Object[]{"enter showNoteHwidRunBackDialog:"});
        this.f23132o = null;
        this.f23133p = null;
        this.f23132o = new af(this.f23124g);
        this.f23133p = this.f23132o.a();
        this.f23133p.show();
    }
}
