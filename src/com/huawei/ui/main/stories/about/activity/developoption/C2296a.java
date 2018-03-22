package com.huawei.ui.main.stories.about.activity.developoption;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwappdfxmgr.a;

/* compiled from: DevelopOptionActivity */
class C2296a implements OnCheckedChangeListener {
    final /* synthetic */ DevelopOptionActivity f8356a;

    C2296a(DevelopOptionActivity developOptionActivity) {
        this.f8356a = developOptionActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            a.a(this.f8356a).b(true);
        } else {
            a.a(this.f8356a).b(false);
        }
    }
}
