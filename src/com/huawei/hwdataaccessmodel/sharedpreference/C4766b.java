package com.huawei.hwdataaccessmodel.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.a.c;
import com.huawei.hwdataaccessmodel.p065a.C4761b;
import com.huawei.hwdataaccessmodel.p065a.C4762d;
import com.huawei.p111o.C5704b;
import com.huawei.p190v.C2538c;

/* compiled from: SharedPreferenceManager */
final class C4766b implements Runnable {
    final /* synthetic */ String f17363a;
    final /* synthetic */ String f17364b;
    final /* synthetic */ c f17365c;
    final /* synthetic */ String f17366d;
    final /* synthetic */ C4761b f17367e;

    C4766b(String str, String str2, c cVar, String str3, C4761b c4761b) {
        this.f17363a = str;
        this.f17364b = str2;
        this.f17365c = cVar;
        this.f17366d = str3;
        this.f17367e = c4761b;
    }

    public void run() {
        try {
            Context b = BaseApplication.b();
            C4762d c4762d = new C4762d();
            SharedPreferences sharedPreferences = b.getSharedPreferences(this.f17363a, 0);
            Object string = sharedPreferences.getString(this.f17364b, "");
            if (TextUtils.isEmpty(string)) {
                string = new SharedPreferenceModel();
                if (this.f17365c != null) {
                    string.setValue(C5704b.m26317a(b).m26325a(this.f17365c.b, this.f17366d));
                    string.setEncryptType(this.f17365c.b);
                } else {
                    string.setValue(this.f17366d);
                    string.setEncryptType(0);
                }
            } else {
                SharedPreferenceModel sharedPreferenceModel = (SharedPreferenceModel) new Gson().fromJson(string, SharedPreferenceModel.class);
                if (sharedPreferenceModel == null) {
                    c4762d.m22753a(201000);
                    a.a(this.f17367e, c4762d);
                    return;
                } else if (this.f17365c == null && sharedPreferenceModel.getEncryptType() != 0) {
                    c4762d.m22753a(200004);
                    a.a(this.f17367e, c4762d);
                    return;
                } else if (this.f17365c == null || sharedPreferenceModel.getEncryptType() == this.f17365c.b) {
                    sharedPreferenceModel.setValue(C5704b.m26317a(b).m26325a(sharedPreferenceModel.getEncryptType(), this.f17366d));
                } else {
                    c4762d.m22753a(200004);
                    a.a(this.f17367e, c4762d);
                    return;
                }
            }
            Editor edit = sharedPreferences.edit();
            edit.putString(this.f17364b, new Gson().toJson(string));
            if (edit.commit()) {
                c4762d.m22753a(0);
                a.a(this.f17367e, c4762d);
                return;
            }
            c4762d.m22753a(201000);
            a.a(this.f17367e, c4762d);
        } catch (Exception e) {
            C4762d c4762d2 = new C4762d();
            c4762d2.m22753a(201000);
            a.a(this.f17367e, c4762d2);
            C2538c.e("SharedPreferenceManager", new Object[]{"setSharedPreference exception" + e.toString()});
        }
    }
}
