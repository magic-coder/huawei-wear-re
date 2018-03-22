package com.huawei.ui.homewear21.p175a;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwdatamigrate.hihealth.f.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.webview.WebViewActivity;

/* compiled from: HomeFragment */
class bj implements OnClickListener {
    final /* synthetic */ b f8081a;
    final /* synthetic */ bi f8082b;

    bj(bi biVar, b bVar) {
        this.f8082b = biVar;
        this.f8081a = bVar;
    }

    public void onClick(View view) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "ok clicked");
        if (WebViewActivity.a(this.f8082b.f8080a.f8041z)) {
            this.f8082b.f8080a.bs();
            return;
        }
        C2538c.m12661a("MainUI", 0, "HomeFragment", "the first time to sync, in wifi condition");
        this.f8081a.a();
    }
}
