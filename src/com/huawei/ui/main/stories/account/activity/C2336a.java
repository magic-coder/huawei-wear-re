package com.huawei.ui.main.stories.account.activity;

import android.content.Intent;
import com.huawei.ui.main.stories.account.interactor.C2331j;

/* compiled from: SinaweiboLoginActivity */
class C2336a implements C2331j {
    final /* synthetic */ SinaweiboLoginActivity f8482a;

    C2336a(SinaweiboLoginActivity sinaweiboLoginActivity) {
        this.f8482a = sinaweiboLoginActivity;
    }

    public void mo2655a(boolean z) {
    }

    public void mo2654a(int i, String str, String str2, String str3, int i2) {
        Intent intent = new Intent();
        intent.putExtra("sinaweibo_userid", str2);
        intent.putExtra("sinaweibo_token", str);
        intent.putExtra("sinaweibo_username", str3);
        if (str != null) {
            this.f8482a.setResult(-1, intent);
        } else {
            this.f8482a.setResult(0, intent);
        }
        this.f8482a.finish();
    }

    public void mo2653a(int i, Boolean bool) {
        Intent intent = new Intent();
        intent.putExtra("sinaweibo_logout_isccucess", bool);
        this.f8482a.setResult(-1, intent);
        this.f8482a.finish();
    }
}
