package com.huawei.hwversionmgr.p080b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwversionmgr.utils.C1080f;
import com.huawei.hwversionmgr.utils.service.UpdateService;
import com.huawei.p190v.C2538c;
import java.io.File;

/* compiled from: HWVersionManager */
public class C1071a extends C0628a {
    private static C1071a f2156b = null;
    private Context f2157a;

    public C1071a(Context context) {
        super(context);
        this.f2157a = context;
    }

    public static C1071a m4507a(Context context) {
        if (f2156b == null && context != null) {
            f2156b = new C1071a(BaseApplication.m2632b());
        }
        return f2156b;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1003);
    }

    public void m4511a(Boolean bool) {
        C2538c.m12677c("HWVersionManager", "checkAppNewVersionService" + bool);
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        if (bool.booleanValue()) {
            intent.setAction("action_app_auto_check_new_version");
        } else {
            intent.setAction("action_app_manual_update_new_version");
        }
        this.f2157a.startService(intent);
    }

    public void m4509a() {
        C2538c.m12677c("HWVersionManager", "checkHiHealthAppNewVersionService");
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        intent.setAction("action_hihealth_app_manual_update_new_version");
        this.f2157a.startService(intent);
    }

    public void m4510a(int i, String str, String str2, Boolean bool) {
        C2538c.m12674b("HWVersionManager", "checkBandNewVersionService isAuto" + bool);
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        if (bool.booleanValue()) {
            intent.setAction("action_band_auto_check_new_version");
        } else {
            intent.setAction("action_band_manual_update_new_version");
        }
        intent.putExtra("extra_band_type", i);
        intent.putExtra("extra_band_version", str);
        intent.putExtra("extra_band_imei", str2);
        this.f2157a.startService(intent);
    }

    public void m4514b(Boolean bool) {
        C2538c.m12674b("HWVersionManager", "downloadPackage");
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        if (bool.booleanValue()) {
            intent.setAction("action_app_download_new_version");
        } else {
            intent.setAction("action_band_download_new_version");
        }
        this.f2157a.startService(intent);
    }

    public void m4513b() {
        C2538c.m12674b("HWVersionManager", "downloadHiHealthPackage");
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        intent.setAction("action_app_download_hihealth_new_version");
        this.f2157a.startService(intent);
    }

    public void m4516c() {
        C2538c.m12674b("HWVersionManager", "cancelDownload");
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        intent.setAction("action_cancel_download_app");
        this.f2157a.startService(intent);
    }

    public void m4518d() {
        C2538c.m12674b("HWVersionManager", "autoDownloadPackage");
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        intent.setAction("action_app_auto_download");
        this.f2157a.startService(intent);
    }

    public String m4508a(String str) {
        return C1080f.m4597a(str);
    }

    public boolean m4521e() {
        String c = C1080f.m4603c(this.f2157a);
        C2538c.m12674b("HWVersionManager", "haveNewAppVersion: newVersionCode = " + c);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        int d = C0977d.m3550d(this.f2157a);
        C2538c.m12674b("HWVersionManager", "haveNewAppVersion: newCode = " + C0977d.m3523a(c) + ", code = " + d);
        if (d < C0977d.m3523a(c)) {
            return true;
        }
        C1080f.m4605c(String.valueOf(d), this.f2157a);
        return false;
    }

    public boolean m4523f() {
        boolean z = true;
        Object e = C1080f.m4608e(this.f2157a);
        C2538c.m12674b("HWVersionManager", "haveNewBandVersion: newVersion = " + e);
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        C2538c.m12674b("HWVersionManager", "haveNewBandVersion: version = " + C1080f.m4614h(this.f2157a));
        if (e.equals(C1080f.m4614h(this.f2157a))) {
            z = false;
        }
        return z;
    }

    public boolean m4524g() {
        String str = "";
        Object g = C1080f.m4612g(this.f2157a);
        if (TextUtils.isEmpty(g)) {
            C2538c.m12680e("HWVersionManager", "isNewVersionFileExist() error, file path is empty...");
            return false;
        }
        C2538c.m12674b("HWVersionManager", "isNewVersionFileExist: bExist = " + new File(g).exists());
        return new File(g).exists();
    }

    public void m4525h() {
        C1080f.m4616i(this.f2157a);
    }

    public String m4526i() {
        C2538c.m12674b("HWVersionManager", "enter getCheckNewBandVersion ");
        return C1080f.m4608e(this.f2157a);
    }

    public String m4527j() {
        return C1080f.m4612g(this.f2157a);
    }

    public void m4515b(String str) {
        C1080f.m4615h(str, this.f2157a);
    }

    public void m4517c(String str) {
        C1080f.m4617i(str, this.f2157a);
    }

    public void m4519d(String str) {
        C1080f.m4607d(str, this.f2157a);
    }

    public String m4528k() {
        return C1080f.m4606d(this.f2157a);
    }

    public void m4520e(String str) {
        C1080f.m4613g(str, this.f2157a);
    }

    public String m4529l() {
        return C1080f.m4610f(this.f2157a);
    }

    public void m4522f(String str) {
        C1080f.m4609e(str, this.f2157a);
    }

    public void m4530m() {
        C2538c.m12674b("HWVersionManager", "resetBandUpdate");
        m4525h();
        C1080f.m4618j(this.f2157a);
    }

    public void m4512a(Boolean bool, Boolean bool2) {
        C2538c.m12677c("HWVersionManager", "reportStatus isApp: " + bool + " isSuccess: " + bool2);
        Intent intent = new Intent(this.f2157a, UpdateService.class);
        if (bool.booleanValue()) {
            if (bool2.booleanValue()) {
                intent.setAction("action_app_update_success");
            } else {
                intent.setAction("action_app_update_failed");
            }
        } else if (bool2.booleanValue()) {
            intent.setAction("action_band_update_success");
        } else {
            intent.setAction("action_band_update_failed");
        }
        this.f2157a.startService(intent);
    }
}
