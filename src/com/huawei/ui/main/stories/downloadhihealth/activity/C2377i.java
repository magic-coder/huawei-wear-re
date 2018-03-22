package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.guide.p181a.C2378a;

/* compiled from: UpDateHiHealthActivity */
class C2377i implements OnClickListener {
    final /* synthetic */ UpDateHiHealthActivity f8569a;

    C2377i(UpDateHiHealthActivity upDateHiHealthActivity) {
        this.f8569a = upDateHiHealthActivity;
    }

    public void onClick(View view) {
        C2378a c2378a = new C2378a(BaseApplication.m2632b());
        c2378a.m11995d(true);
        PackageInfo k = C0977d.m3572k(BaseApplication.m2632b());
        Intent intent;
        if (k != null) {
            C2538c.m12677c("UpDateHiHealthActivity", "CommonUtil.HIHEALTH_VERSION_CODE = 20100000 packageInfo.versionCode = " + k.versionCode);
            if (20100000 <= k.versionCode || c2378a.m12000f()) {
                intent = new Intent();
                intent.setClassName(BaseApplication.m2632b(), "com.huawei.bone.root.MainActivity");
                intent.setPackage(BaseApplication.m2632b().getPackageName());
                this.f8569a.startActivity(intent);
                this.f8569a.finish();
                return;
            }
            intent = new Intent(this.f8569a, HealthStartActivity.class);
            intent.putExtra("is_frome_update_hihealth_activity_to_enter", true);
            intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
            this.f8569a.startActivity(intent);
            this.f8569a.finish();
        } else if (c2378a.m12000f()) {
            intent = new Intent();
            intent.setClassName(BaseApplication.m2632b(), "com.huawei.bone.root.MainActivity");
            intent.setPackage(BaseApplication.m2632b().getPackageName());
            this.f8569a.startActivity(intent);
            this.f8569a.finish();
        } else {
            intent = new Intent(this.f8569a, HealthStartActivity.class);
            intent.putExtra("is_frome_update_hihealth_activity_to_enter", true);
            intent.putExtra("is_frome_device_pair_guide_activity_to_enter", true);
            this.f8569a.startActivity(intent);
            this.f8569a.finish();
        }
    }
}
