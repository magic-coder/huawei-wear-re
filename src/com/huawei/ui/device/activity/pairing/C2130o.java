package com.huawei.ui.device.activity.pairing;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.main.stories.downloadhihealth.activity.HealthStartActivity;
import com.huawei.ui.main.stories.guide.p181a.C2378a;

/* compiled from: DevicePairGuideActivity */
class C2130o implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7538a;

    C2130o(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7538a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver(): setResult = 2");
        this.f7538a.m10935h();
        this.f7538a.setResult(2);
        C2538c.m12677c("DevicePairGuideActivity", "onClick() value = " + C0996a.m3612a(this.f7538a.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status"));
        if ("true".equals(C0996a.m3612a(this.f7538a.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status"))) {
            this.f7538a.finish();
            return;
        }
        C0996a.m3611a(this.f7538a.f7497c, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "first_pair_success_status", "true", null);
        PackageInfo k = C0977d.m3572k(this.f7538a.f7497c);
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        Intent intent;
        if (k != null) {
            C2538c.m12677c("DevicePairGuideActivity", "!isFromDevicePairToEnter (ELSE) CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode || c2378a.m12000f()) {
                this.f7538a.finish();
                return;
            }
            intent = new Intent(this.f7538a.f7497c, HealthStartActivity.class);
            intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
            this.f7538a.startActivityForResult(intent, 1);
            if (this.f7538a.ah != null && this.f7538a.ah.equals("personalbasicinfosetting")) {
                this.f7538a.finish();
            }
        } else if (c2378a.m12000f()) {
            this.f7538a.finish();
        } else {
            intent = new Intent(this.f7538a.f7497c, HealthStartActivity.class);
            if (this.f7538a.ah != null && this.f7538a.ah.equals("personalbasicinfosetting")) {
                intent.putExtra("personalbasicinfosettingflag", "personalbasicinfosetting");
            }
            intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
            this.f7538a.startActivityForResult(intent, 1);
            if (this.f7538a.ah != null && this.f7538a.ah.equals("personalbasicinfosetting")) {
                this.f7538a.finish();
            }
        }
    }
}
