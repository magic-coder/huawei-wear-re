package com.huawei.ui.homewear21.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.homewear21.card.p176a.C2243a;
import com.huawei.ui.main.stories.p177a.p178a.C2278b;

/* compiled from: UpdateDeviceService */
class C2275a extends BroadcastReceiver {
    final /* synthetic */ UpdateDeviceService f8267a;

    C2275a(UpdateDeviceService updateDeviceService) {
        this.f8267a = updateDeviceService;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String e = C2243a.m11601a().m11616e();
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("content");
            C2538c.m12677c("UpdateDeviceService", "mAutoCheckNewVersionReceiver onReceive: content = " + stringExtra);
            if ("action_band_auto_check_new_version_result".equals(action)) {
                C2538c.m12677c("UpdateDeviceService", "result = " + intent.getIntExtra("result", 8));
                switch (intent.getIntExtra("result", 8)) {
                    case 7:
                        UpdateDeviceService.m11712a(UpdateDeviceService.m11714b(), context);
                        C2538c.m12677c("UpdateDeviceService", "auto check band success ");
                        this.f8267a.f8262c = intent.getStringExtra("name");
                        this.f8267a.f8263d = intent.getIntExtra(UploadFile.SIZE_LABEL, -1);
                        C2538c.m12677c("UpdateDeviceService", "AUTO_CHECK_BAND_SUCCESS mCheckBandNewVersionName:" + this.f8267a.f8262c);
                        C2538c.m12677c("UpdateDeviceService", "AUTO_CHECK_BAND_SUCCESS mCheckBandNewVersionSize:" + this.f8267a.f8263d);
                        C2538c.m12677c("UpdateDeviceService", "AUTO_CHECK_BAND_SUCCESS deviceName:" + e);
                        Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("isForced", false));
                        if (valueOf != null) {
                            C2538c.m12677c("UpdateDeviceService", "is band forcedUPdate:" + valueOf);
                            if (!valueOf.booleanValue()) {
                                ah.m10316a(context).m10327a(this.f8267a.f8262c, this.f8267a.f8263d, this.f8267a.f8264e, e);
                                return;
                            }
                            return;
                        }
                        return;
                    case 11:
                        UpdateDeviceService.m11712a(UpdateDeviceService.m11714b(), context);
                        C2538c.m12677c("UpdateDeviceService", "mBandAutoCheckNewVersionReceiver: AUTO_CHECK_BAND_NOT_TIME");
                        ah.m10316a(context).m10345l();
                        return;
                    case 12:
                        UpdateDeviceService.m11712a(UpdateDeviceService.m11714b(), context);
                        C2538c.m12677c("UpdateDeviceService", "band not support silence OTA isAutoSuccess");
                        this.f8267a.f8261b.execute(new C2277c(this));
                        return;
                    case 13:
                        UpdateDeviceService.m11712a(UpdateDeviceService.m11714b(), context);
                        C2538c.m12677c("UpdateDeviceService", "band support silence OTA isAutoSuccess");
                        C2278b c2278b = new C2278b();
                        this.f8267a.f8261b.execute(new C2276b(this));
                        C2538c.m12677c("UpdateDeviceService", "get auto ota checkbox status,isAutoupdate = " + c2278b.m11721a());
                        if (c2278b.m11721a() && ah.m10316a(context).m10343j()) {
                            ah.m10316a(context).m10337d();
                            return;
                        }
                        return;
                    case 26:
                        UpdateDeviceService.m11712a(UpdateDeviceService.m11714b(), context);
                        C2538c.m12677c("UpdateDeviceService", "auto download band package success");
                        ah.m10316a(context).m10347n();
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
