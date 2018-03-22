package com.huawei.ui.main.stories.settings.p185a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: UserProfileSettingsInteractors */
class C2477r implements OnClickListener {
    final /* synthetic */ C2465f f8887a;

    C2477r(C2465f c2465f) {
        this.f8887a = c2465f;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12677c("UserProfileSettingsInteractors", "同意更改weight");
        C2538c.m12677c("UserProfileSettingsInteractors", "weight :" + this.f8887a.f8856j.getFisrtPickerValue() + HwAccountConstants.BLANK + this.f8887a.f8856j.getThirdPickerValue());
        String thirdPickerValue = this.f8887a.f8856j.getThirdPickerValue();
        this.f8887a.f8860n.sendEmptyMessage(7);
        this.f8887a.m12312d(thirdPickerValue);
        this.f8887a.f8857k.dismiss();
    }
}
