package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.homewear21.card.p176a.C2243a;

/* compiled from: HomeFragment */
class af extends BroadcastReceiver {
    final /* synthetic */ C2217a f8047a;

    af(C2217a c2217a) {
        this.f8047a = c2217a;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String e = C2243a.m11601a().m11616e();
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("content");
            C2538c.m12661a("MainUI", 0, "HomeFragment", "mAutoCheckNewVersionReceiver onReceive: content = " + stringExtra);
            if ("action_band_auto_check_new_version_result".equals(action)) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "result = " + intent.getIntExtra("result", 8));
                switch (intent.getIntExtra("result", 8)) {
                    case 5:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "auto check app success ");
                        this.f8047a.m11434Y();
                        return;
                    case 7:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "auto check band success ");
                        this.f8047a.ae = Boolean.valueOf(true);
                        this.f8047a.ab = intent.getStringExtra("name");
                        this.f8047a.ac = intent.getIntExtra(UploadFile.SIZE_LABEL, -1);
                        this.f8047a.ad = intent.getStringExtra("changelog");
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "AUTO_CHECK_BAND_SUCCESS mCheckBandNewVersionName:" + this.f8047a.ab);
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "AUTO_CHECK_BAND_SUCCESS mCheckBandNewVersionSize:" + this.f8047a.ac);
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "AUTO_CHECK_BAND_SUCCESS bandChangeLog:" + this.f8047a.ad);
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "AUTO_CHECK_BAND_SUCCESS deviceName:" + e);
                        Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("isForced", false));
                        if (valueOf != null) {
                            C2538c.m12661a("MainUI", 0, "HomeFragment", "is band forcedUPdate:" + valueOf);
                            if (valueOf.booleanValue() && ah.m10316a(this.f8047a.f8041z).m10356w()) {
                                valueOf = Boolean.valueOf(false);
                            }
                            if (valueOf.booleanValue()) {
                                this.f8047a.m11467a(e);
                                return;
                            }
                            if (this.f8047a.f8015Z == null) {
                                this.f8047a.f8015Z = ah.m10316a(this.f8047a.f8041z);
                            }
                            this.f8047a.f8015Z.m10327a(this.f8047a.ab, this.f8047a.ac, this.f8047a.ad, e);
                            this.f8047a.f8015Z.m10355v();
                            return;
                        }
                        return;
                    case 8:
                        this.f8047a.ae = Boolean.valueOf(false);
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "auto check band failed");
                        return;
                    case 11:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "mBandAutoCheckNewVersionReceiver: AUTO_CHECK_BAND_NOT_TIME");
                        if (this.f8047a.f8015Z == null) {
                            this.f8047a.f8015Z = ah.m10316a(this.f8047a.f8041z);
                        }
                        this.f8047a.f8015Z.m10345l();
                        return;
                    case 12:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "band not support silence OTA isAutoSuccess" + this.f8047a.ae);
                        if (this.f8047a.ae.booleanValue()) {
                            if (this.f8047a.f8015Z == null) {
                                this.f8047a.f8015Z = ah.m10316a(this.f8047a.f8041z);
                            }
                            this.f8047a.f8015Z.m10348o();
                            this.f8047a.m11469a(this.f8047a.ab, this.f8047a.ac, this.f8047a.ad, e, false);
                            return;
                        }
                        return;
                    case 13:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "band support silence OTA isAutoSuccess" + this.f8047a.ae);
                        if (this.f8047a.ae.booleanValue()) {
                            if (this.f8047a.f8015Z == null) {
                                this.f8047a.f8015Z = ah.m10316a(this.f8047a.f8041z);
                            }
                            this.f8047a.f8015Z.m10348o();
                            C2538c.m12661a("MainUI", 0, "HomeFragment", "get auto ota checkbox status,isAutoupdate = " + this.f8047a.aa.m11721a());
                            if (this.f8047a.aa.m11721a() && this.f8047a.f8015Z.m10343j()) {
                                this.f8047a.f8015Z.m10337d();
                                return;
                            } else {
                                this.f8047a.m11469a(this.f8047a.ab, this.f8047a.ac, this.f8047a.ad, e, true);
                                return;
                            }
                        }
                        return;
                    case 25:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "auto download band package failed");
                        return;
                    case 26:
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "auto download band package success");
                        if (this.f8047a.f8015Z == null) {
                            this.f8047a.f8015Z = ah.m10316a(this.f8047a.f8041z);
                        }
                        this.f8047a.f8015Z.m10347n();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
