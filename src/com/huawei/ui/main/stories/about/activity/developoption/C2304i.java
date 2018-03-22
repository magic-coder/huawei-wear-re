package com.huawei.ui.main.stories.about.activity.developoption;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwappdfxmgr.a;
import com.huawei.ui.main.stories.guide.p181a.C2378a;

/* compiled from: DevelopOptionActivity */
class C2304i implements OnClickListener {
    final /* synthetic */ DevelopOptionActivity f8365a;

    C2304i(DevelopOptionActivity developOptionActivity) {
        this.f8365a = developOptionActivity;
    }

    public void onClick(View view) {
        a.a(this.f8365a).b(true);
        new C2378a(this.f8365a).m12009k(false);
        this.f8365a.finish();
    }
}
