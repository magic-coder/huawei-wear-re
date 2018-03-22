package com.huawei.hwdataaccessmodel.sharedpreference;

import android.content.Context;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C4761b;
import com.huawei.hwdataaccessmodel.p065a.C4762d;
import com.huawei.p111o.C5704b;
import com.huawei.p190v.C2538c;

/* compiled from: SharedPreferenceManager */
final class C4767c implements Runnable {
    final /* synthetic */ String f17368a;
    final /* synthetic */ String f17369b;
    final /* synthetic */ C4761b f17370c;

    C4767c(String str, String str2, C4761b c4761b) {
        this.f17368a = str;
        this.f17369b = str2;
        this.f17370c = c4761b;
    }

    public void run() {
        C4762d c4762d;
        try {
            c4762d = new C4762d();
            Context b = BaseApplication.b();
            SharedPreferenceModel sharedPreferenceModel = (SharedPreferenceModel) new Gson().fromJson(b.getSharedPreferences(this.f17368a, 0).getString(this.f17369b, ""), SharedPreferenceModel.class);
            if (sharedPreferenceModel == null) {
                c4762d.m22754a((Object) "");
            } else {
                c4762d.m22754a(C5704b.m26317a(b).m26328b(sharedPreferenceModel.getEncryptType(), sharedPreferenceModel.getValue()));
            }
            a.a(this.f17370c, c4762d);
        } catch (Exception e) {
            c4762d = new C4762d();
            c4762d.m22753a(201000);
            a.a(this.f17370c, c4762d);
            C2538c.e("SharedPreferenceManager", new Object[]{"getSharedPreference async exception:", e.getMessage()});
        }
    }
}
